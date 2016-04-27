package com.tenement.service.serviceImplements;

import com.tenement.service.CrawlService;
import com.tenement.service.webMagic.pipeline.CityListPipeline;
import com.tenement.service.webMagic.processor.CityListProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.codecraft.webmagic.Spider;

/**
 * Created by LXPENG on 2016/4/27.
 */
@Service
public class CrawlServiceImpl implements CrawlService {
    @Autowired
    private CityListProcessor cityListProcessor;
    @Autowired
    private CityListPipeline cityListPipeline;

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
}
