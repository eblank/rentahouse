package com.tenement.service.serviceImplements;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tenement.common.util.ClassUtil;
import com.tenement.common.util.Result;
import com.tenement.manager.TenementBloomFilter;
import com.tenement.mapper.*;
import com.tenement.model.*;
import com.tenement.model.constant.*;
import com.tenement.service.CrawlService;
import com.tenement.service.webMagic.pipeline.CityListPipeline;
import com.tenement.service.webMagic.pipeline.ConsolePipeline;
import com.tenement.service.webMagic.pipeline.FilterOptionPipeline;
import com.tenement.service.webMagic.pipeline.HouseInfoPipeline;
import com.tenement.service.webMagic.processor.CityListProcessor;
import com.tenement.service.webMagic.processor.FilterOptionProcessor;
import com.tenement.service.webMagic.processor.HouseInfoProcessor;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Request;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.scheduler.QueueScheduler;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Autowired
    private TenementBloomFilter tenementBloomFilter;
    @Autowired
    private UrlMapper urlMapper;

    /**
     * 抓取城市列表
     * <p/>
     * //     * @param urlString http://www.58.com/chuzu/changecity/?PGTID=0d3090a7-029c-40b0-8319-2473d96e2e12&ClickID=1
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
     * @return {options : [{text : "庄市", value : "庄市"}]}
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
     * @param location 地域
     * @param price 租金
     * @param roomNumber 房间数
     * @param rentType 出租类型
     * @param toward 朝向
     * @param decoration 装修程度
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
            TownExample townExample = new TownExample();
            TownExample.Criteria criteria = townExample.createCriteria().andNameEqualTo(location);
            List<Town> townList = townMapper.selectByExample(townExample);
            if (townList.size() > 0) {
                accumUrl.append("/").append(townList.get(0).getUrl());
            }
        }
        if (StringUtils.isNotBlank(rentType)) {
//            accumUrl.append("/").append(rentType);
        } else {
            accumUrl.append("/").append("zufang");
        }
        accumUrl.append("/").append(1);
        if (StringUtils.isNotBlank(toward) | StringUtils.isNotBlank(decoration) | StringUtils.isNotBlank(roomNumber)) {
            accumUrl.append("/").append(toward).append(decoration).append(roomNumber);
        }
        accumUrl.append("/");

        //取今日0：0：0的时间戳 查询条件相同的url 一天只能抓取一次
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long TimeStamp = calendar.getTime().getTime();
        if (StringUtils.isNotBlank(price)) {
            accumUrl.append("?minprice=").append(price);
            //防止url重复 被过滤
            accumUrl.append("&").append(TimeStamp);
        } else {
            //防止url重复 被过滤
            accumUrl.append("?").append(TimeStamp);
        }
        return accumUrl.toString();
    }

    /**
     * 抓取房屋详细信息
     *
     * @param urlString
     * @return
     */
    @Override
    public void crawlHouseInfo(String urlString) {
        QueueScheduler queueScheduler = new QueueScheduler();
        queueScheduler.setDuplicateRemover(tenementBloomFilter.getDuplicateRemover());

        Spider spider = Spider.create(houseInfoProcessor)
                .setScheduler(queueScheduler);
        spider.addUrl(urlString)
                .addPipeline(new ConsolePipeline())
                .thread(1)
                .run();

        //此次爬虫访问的url 保存到数据库
        List<Request> requests = spider.getNewRequests();
        for (Request request : requests) {
            Url url = new Url();
            url.setUrl(request.getUrl());
            url.setUrlType(UrlTypeEnum.HOUSEINFO.getValue());
            ClassUtil.setDefaultValues(url);
            urlMapper.insert(url);
        }
    }

    /**
     * 获取房屋信息
     *
     * @param location   区域 镇级地域
     * @param price      租金 "100_500" 大于等于100且小于等于500
     * @param roomNumber 卧室数
     * @param rentType   租金
     * @param toward     朝向
     * @param decoration 装修程度
     * @return
     */
    @Override
    public List getHouseInfo(String location, String price, String roomNumber, String rentType, String toward, String decoration) {
        JSONArray collectionArray = new JSONArray();
        Result result = new Result();
        HouseExample houseExample = new HouseExample();
        HouseExample.Criteria criteria = houseExample.createCriteria();

        //查询条件匹配 镇级地域
        if (StringUtils.isNotBlank(location)) {
            criteria.andTownEqualTo(location);
        }
        //查询条件匹配 卧室数
        if (StringUtils.isNotBlank(roomNumber)) {
            int bedroomNumber = QueryRoomNumberEnum.valueOf(roomNumber).getValue();
            //匹配大于 或是 等于
            if (bedroomNumber >= 5) {
                //当卧室数大于5 匹配大于bedroomNumber
                criteria.andBedRoomGreaterThanOrEqualTo(bedroomNumber);
            } else {
                //匹配等于bedroomNumber
                criteria.andBedRoomEqualTo(bedroomNumber);
            }
        }
        //查询条件匹配 价格区间
        if (StringUtils.isNotBlank(price)) {
            int minPrice = Integer.parseInt(price.split("_")[0]);
            String maxPriceString = price.split("_")[1];
            //上限为‘*’
            if ("*".equals(maxPriceString)) {
                //条件大于最小值
                criteria.andHousePriceGreaterThan(minPrice);
            } else {
                //价格范围
                criteria.andHousePriceBetween(minPrice, Integer.parseInt(maxPriceString));
            }
        }
        //查询条件匹配 朝向
        if (StringUtils.isNotBlank(toward)) {
            toward = QueryTowardEnum.valueOf(toward).getValue();
            criteria.andTowardEqualTo(toward);
        }
        //查询条件匹配 装修程度
        if (StringUtils.isNotBlank(decoration)) {
            decoration = QueryDecorationEnum.valueOf(decoration).getValue();
            criteria.andDecorationEqualTo(decoration);
        }

        //todo 出租类型匹配 目前仅支持zufang
        if (StringUtils.isNotBlank(rentType)) {

        }

        List<House> houseList = houseMapper.selectByExample(houseExample);


        return houseList;
    }
}
