package com.tenement.controller;

import com.tenement.common.util.Result;
import com.tenement.service.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LXPENG on 2016/4/27.
 */
@Controller
@RequestMapping(value = "/crawl")
public class CrawlHouseController {
    @Autowired
    private CrawlService crawlService;

    /**
     * 获取筛选区域数据
     *
     * @param city 城市名
     * @return
     */
    @RequestMapping(value = "/areaOptions" , method = RequestMethod.GET)
    @ResponseBody
    public Result crawlFilterOption(@RequestParam(required = false, defaultValue = "宁波") String city) {
        Result result = crawlService.crawlFilterOption(city);
        return result;
    }

    @RequestMapping(value = "/house/info", method = RequestMethod.GET)
    @ResponseBody
    public Result crawlHouseInfo(@RequestParam(required = false, defaultValue = "") String location,
                                 @RequestParam(required = false, defaultValue = "") String price,
                                 @RequestParam(required = false, defaultValue = "") String roomNumber,
                                 @RequestParam(required = false, defaultValue = "") String rentType,
                                 @RequestParam(required = false, defaultValue = "") String toward,
                                 @RequestParam(required = false, defaultValue = "") String decoration) {
        String urlString = crawlService.getUrl(location, price, roomNumber, rentType, toward, decoration);
        crawlService.crawlHouseInfo(urlString);
        return null;


    }
}
