package com.tenement.service.serviceImplements;

import com.tenement.mapper.CityMapper;
import com.tenement.mapper.CountyMapper;
import com.tenement.mapper.TownMapper;
import com.tenement.model.City;
import com.tenement.model.CityExample;
import com.tenement.model.Town;
import com.tenement.service.CrawlService;
import com.tenement.service.webMagic.pipeline.CityListPipeline;
import com.tenement.service.webMagic.processor.CityListProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

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

    /**
     * 抓取城市列表
     *
//     * @param url http://www.58.com/chuzu/changecity/?PGTID=0d3090a7-029c-40b0-8319-2473d96e2e12&ClickID=1
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
    public boolean crawlFilterOption(String cityName) {
        CityExample cityExample = new CityExample();
        cityExample.createCriteria().andNameEqualTo(cityName);
        List<City> cityList = cityMapper.selectByExample(cityExample);
        if (cityList == null || cityList.size() < 1) {
            return false;
        }
        City city = cityList.get(0);
        String url = city.getUrl();

        return false;
    }
}
