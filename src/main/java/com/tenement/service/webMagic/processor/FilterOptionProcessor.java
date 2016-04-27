package com.tenement.service.webMagic.processor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tenement.mapper.CityMapper;
import com.tenement.model.City;
import com.tenement.model.CityExample;
import com.tenement.model.Town;
import com.tenement.service.webMagic.pipeline.ConsolePipeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;

/**
 * Created by LXPENG on 2016/4/27.
 */
@Service
public class FilterOptionProcessor implements PageProcessor {
    @Autowired
    private CityMapper cityMapper;
    private static Long cityCode;
    private static boolean hadCityCode = false;
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);
    /**
     * get the site settings
     *
     * @return site
     * @see Site
     */
    @Override
    public Site getSite() {
        return this.site;
    }

    /**
     * process the page, extract urls to fetch, extract the data and store
     *
     * @param page page
     */
    @Override
    public void process(Page page) {
        Html htmlPage = page.getHtml();
        String cityName = htmlPage
                .xpath("//div[@class='search_bd clearfix']/dl[1]/dd/a/text()")
                .get();
        cityName = cityName.substring(1);

//        synchronized (this) {
//            if (!hadCityCode) {
//                CityExample cityExample =  new CityExample();
//                cityExample.createCriteria().andNameEqualTo(cityName);
//                List<City> cityList  = cityMapper.selectByExample(cityExample);
//                FilterOptionProcessor.cityCode = cityList.get(0).getId();
//                FilterOptionProcessor.hadCityCode = true;
//            }
//        }

        JSONObject cityJson = new JSONObject();
        JSONObject countyJson = new JSONObject();
        JSONArray townArray = new JSONArray();
        List<String> countyList = htmlPage
                .xpath("//div[@class=\"search_bd clearfix\"]/dl[1]/dd/a")
                .links()
                .all();
        page.addTargetRequests(countyList);
        String county = htmlPage
                .xpath("//a[@para='local' and @class='select']/text()")
                .get();
        String countyUrl = htmlPage
                .xpath("//a[@para='local' and @class='select']/@href")
                .get();
        List<String> townList = htmlPage
                .xpath("//div[@class='arealist']/a/@href|//div[@class='arealist']/a/text()")
                .all();
        int size = 0;
        if (townList != null) {
            size = townList.size() / 2;
        }
        for (int j = 0; j < townList.size() / 2; j++) {
            String townUrl = townList.get(j);
            String townName = townList.get(j + size);
            Town town = new Town();
            town.setName(townUrl);
            town.setUrl(townName);
            townArray.add(town);
        }
        countyJson.put("name", county);
        countyJson.put("url", countyUrl);
        countyJson.put("town", townArray);

        cityJson.put("name", cityName);
        cityJson.put("county", countyJson);
        page.putField("city", cityJson);
    }

    public static void main(String[] args) {
        Spider.create(new FilterOptionProcessor())
                .addUrl("http://nb.58.com/chuzu/?PGTID=0d3090a7-0008-ac1a-3a00-5e9f760b3e82&ClickID=1")
                .addPipeline(new ConsolePipeline())
                .thread(1)
                .run();

    }
}
