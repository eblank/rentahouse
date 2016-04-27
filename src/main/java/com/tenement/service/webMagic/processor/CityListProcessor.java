package com.tenement.service.webMagic.processor;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tenement.model.City;
import com.tenement.service.webMagic.pipeline.ConsolePipeline;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.selector.Html;

import java.util.List;


/**
 * Created by luxp on 2016/3/25.
 */
@Service
public class CityListProcessor implements PageProcessor {
    private Site site = Site.me().setRetryTimes(3).setSleepTime(100);

    @Override
    public void process(Page page) {
        Html htmlPage = page.getHtml();
        JSONObject areaJson = new JSONObject();
        //所有一级地区（省） province
        List<String> provinceList = htmlPage
                .xpath("//*[@id=\"clist\"]/dt/text()")
                .all();
        for (int i = 0; i < provinceList.size(); i++) {
            String provinceString = provinceList.get(i);
            //一级地区对应的二级地区和链接（市名链接） city
            String xpath = "//*[@id=\"clist\"]/dd[" + (i + 1) + "]/a/@href|//*[@id=\"clist\"]/dd[" + (i + 1) + "]/a/text()";
            List<String> cityLinkList = htmlPage
                    .xpath(xpath)
                    .all();

            int size = 0;
            if (cityLinkList != null) {
                size = cityLinkList.size() / 2;
            }
            JSONArray cityArray = new JSONArray();
            for (int j = 0; j < cityLinkList.size() / 2; j++) {
                String cityUrl = cityLinkList.get(j);
                String cityName = cityLinkList.get(j + size);
                City city = new City();
                city.setName(cityName);
                city.setUrl(cityUrl);
                cityArray.add(city);
            }
//            areaJson.put(province, cityArray);
            page.putField(provinceString, cityArray);
//            page.putField("cityList", areaJson);
        }
    }

    @Override
    public Site getSite() {
        return this.site;
    }

    public static void main(String[] args) {
        Spider.create(new CityListProcessor())
                .addUrl("http://www.58.com/chuzu/changecity/?PGTID=0d3090a7-0008-75de-a346-150345b848c1&ClickID=1")
                .addPipeline(new ConsolePipeline())
                .thread(5)
                .run();

    }
}
