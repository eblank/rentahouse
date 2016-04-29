package com.tenement.service;

import com.tenement.common.util.Result;

/**
 * Created by LXPENG on 2016/4/27.
 */
public interface CrawlService {

    /**
     * 抓取城市列表
     *
     * @param url http://www.58.com/chuzu/changecity/?PGTID=0d3090a7-029c-40b0-8319-2473d96e2e12&ClickID=1
     */
    boolean crawlCityList();

    /**
     * 获取筛选条件
     *
     * @param cityName
     * @return
     */
    Result crawlFilterOption(String cityName);

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
    String getUrl(String location, String price, String roomNumber, String rentType, String toward, String decoration);

    /**
     * 抓取房屋信息
     *
     * @param url
     * @return
     */
    Result crawlHouseInfo(String url);
}
