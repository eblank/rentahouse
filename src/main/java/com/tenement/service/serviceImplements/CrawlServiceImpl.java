package com.tenement.service.serviceImplements;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tenement.common.util.Result;
import com.tenement.mapper.*;
import com.tenement.model.*;
import com.tenement.model.constant.QueryDecorationEnum;
import com.tenement.model.constant.QueryRoomNumberEnum;
import com.tenement.model.constant.QueryTowardEnum;
import com.tenement.service.CrawlService;
import com.tenement.service.webMagic.pipeline.CityListPipeline;
import com.tenement.service.webMagic.pipeline.FilterOptionPipeline;
import com.tenement.service.webMagic.pipeline.HouseInfoPipeline;
import com.tenement.service.webMagic.processor.CityListProcessor;
import com.tenement.service.webMagic.processor.FilterOptionProcessor;
import com.tenement.service.webMagic.processor.HouseInfoProcessor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by LXPENG on 2016/4/27.
 */
@Service
public class CrawlServiceImpl implements CrawlService {
    @Autowired
    private CityListProcessor cityListProcessor;
    @Autowired
    private CityListPipeline cityListPipeline;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private FilterOptionProcessor filterOptionProcessor;
    @Autowired
    private FilterOptionPipeline filterOptionPipeline;
    @Autowired
    private HouseInfoProcessor houseInfoProcessor;
    @Autowired
    private HouseInfoPipeline houseInfoPipeline;
    @Autowired
    private CountyMapper countyMapper;
    @Autowired
    private TownMapper townMapper;
    @Autowired
    private HouseMapper houseMapper;
    @Autowired
    private LandlordMapper landlordMapper;

    /**
     * 抓取城市列表
     * <p/>
     * //     * @param url http://www.58.com/chuzu/changecity/?PGTID=0d3090a7-029c-40b0-8319-2473d96e2e12&ClickID=1
     */
    @Override
    public boolean crawlCityList() {
        String url = "http://www.58.com/chuzu/changecity/?PGTID=0d3090a7-029c-40b0-8319-2473d96e2e12&ClickID=1";
        Spider spider = Spider.create(cityListProcessor);
        spider.addUrl(url)
                .addPipeline(cityListPipeline)
                .thread(1)
                .run();
        spider.getStatus();
        return true;
    }

    /**
     * 获取筛选条件
     *
     * @param cityName
     * @return
     */
    @Override
    public Result crawlFilterOption(String cityName) {
        Result result = new Result();
        CityExample cityExample = new CityExample();
        cityExample.createCriteria().andNameEqualTo(cityName);
        List<City> cityList = cityMapper.selectByExample(cityExample);
        if (cityList == null || cityList.size() < 1) {
            result.setSuccessful(false);
            return result;
        }
        City city = cityList.get(0);
        String url = city.getUrl();
        String cityCode = city.getId() + "";

        CountyExample countyExample = new CountyExample();
        countyExample.createCriteria().andCityCodeEqualTo(cityCode);
        List<County> countyList = countyMapper.selectByExample(countyExample);
        if (countyList.size() < 1) {
            Spider spider = Spider.create(filterOptionProcessor);
            spider.addUrl(url)
                    .addPipeline(filterOptionPipeline)
                    .thread(1)
                    .run();
            spider.getStatus();
        }

        JSONArray countyArray = new JSONArray();
        if (countyList.size() < 1) {
            countyList = countyMapper.selectByExample(countyExample);
        }
        for (County county : countyList) {
            JSONObject countyJson = new JSONObject();
            countyJson.put("text", county.getName());
            countyJson.put("value", county.getName());

            String countyCode = county.getId() + "";
            TownExample townExample = new TownExample();
            townExample.createCriteria().andCountyCodeEqualTo(countyCode);
            List<Town> townList = townMapper.selectByExample(townExample);

            if (townList != null) {
                JSONArray townArray = new JSONArray();
                for (Town town : townList) {
                    JSONObject townObject = new JSONObject();
                    townObject.put("text", town.getName());
                    townObject.put("value", town.getName());
                    townArray.add(townObject);
                }
                countyJson.put("options", townArray);
            }
            countyArray.add(countyJson);
        }

        result.setData(countyArray);
        return result;
    }

    /**
     * 根据筛选条件获取url
     *
     * @param location
     * @param price
     * @param roomNumber
     * @param rentType
     * @param toward
     * @param decoration
     * @return
     */
    @Override
    public String getUrl(String location, String price, String roomNumber, String rentType, String toward, String decoration) {
        StringBuilder accumUrl = new StringBuilder();
        String urlString = "http://nb.58.com/chuzu/";
        String host = "";
        String file = "";
        try {
            URL url = new URL(urlString);
            host = url.getHost();
            file = url.getFile();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        accumUrl.append("http://").append(host);
        if (StringUtils.isNotBlank(location)) {
            accumUrl.append("/").append(location);
        }
        if (StringUtils.isNotBlank(rentType)) {
            accumUrl.append("/").append(rentType);
        } else {
            accumUrl.append("/").append("zufang");
        }
        accumUrl.append("/").append(1);
        if (StringUtils.isNotBlank(toward) | StringUtils.isNotBlank(decoration) | StringUtils.isNotBlank(roomNumber)) {
            accumUrl.append("/").append(toward).append(decoration).append(roomNumber);
        }
        if (StringUtils.isNotBlank(price)) {
            accumUrl.append("?minprice=").append(price);
        }
        return accumUrl.toString();
    }

    /**
     * 抓取房屋详细信息
     *
     * @param url
     * @return
     */
    @Override
    public void crawlHouseInfo(String url) {
        Spider spider = Spider.create(houseInfoProcessor);
        spider.addUrl(url)
                .addPipeline(houseInfoPipeline)
                .thread(1)
                .run();
    }

    public static void main(String[] args) {
        CrawlServiceImpl crawlService = new CrawlServiceImpl();
        String url = crawlService.getUrl("", "", "", "", "", "");
        System.out.println(url);
    }

    /**
     * 获取房屋信息
     *
     * @param location   区域
     * @param price      租金
     * @param roomNumber 卧室数
     * @param rentType   租金
     * @param toward     朝向
     * @param decoration 装修程度
     * @return
     */
    @Override
    public List getHouseInfo(String location, String price, String roomNumber, String rentType, String toward, String decoration) {
        Result result = new Result();
        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria criteria = houseExample.createCriteria();

        if (StringUtils.isNotBlank(location)) {
            criteria.andTownEqualTo(location);
        }
        if (StringUtils.isNotBlank(roomNumber)) {
            int bedroomNumber = QueryRoomNumberEnum.valueOf(roomNumber).getValue();
            if (bedroomNumber >= 5) {
                criteria.andBedRoomGreaterThanOrEqualTo(bedroomNumber);
            } else {
                criteria.andBedRoomEqualTo(bedroomNumber);
            }
        }
        if (StringUtils.isNotBlank(price)) {
            int minPrice = Integer.parseInt(price.split("_")[0]);
            String maxPriceString = price.split("_")[1];
            if ("*".equals(maxPriceString)) {
                criteria.andHousePriceGreaterThan(minPrice);
            } else {
                criteria.andHousePriceBetween(minPrice, Integer.parseInt(maxPriceString));
            }
        }
        if (StringUtils.isNotBlank(toward)) {
            toward = QueryTowardEnum.valueOf(toward).getValue();
            criteria.andTowardEqualTo(toward);
        }
        if (StringUtils.isNotBlank(decoration)) {
            decoration = QueryDecorationEnum.valueOf(decoration).getValue();
            criteria.andDecorationEqualTo(decoration);
        }
        if (StringUtils.isNotBlank(rentType)) {

        }

        List<House> houseList = houseMapper.selectByExample(houseExample);

        return houseList;
    }
}
