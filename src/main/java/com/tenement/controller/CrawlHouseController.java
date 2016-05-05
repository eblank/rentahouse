package com.tenement.controller;

import com.alibaba.fastjson.JSONArray;
import com.tenement.common.util.Result;
import com.tenement.model.User;
import com.tenement.service.CollectionsHouseService;
import com.tenement.service.CrawlService;
import com.tenement.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LXPENG on 2016/4/27.
 */
@Controller
@RequestMapping(value = "/crawl")
public class CrawlHouseController {
    private static final String LIST = "crawlHouseInfo";

    @Autowired
    private CrawlService crawlService;
    @Autowired
    private HouseService houseService;
    @Autowired
    private CollectionsHouseService collectionsHouseService;

    @RequestMapping(value = "/test")
    @ResponseBody
    public List test() {
        User user = new User();
        user.setNickName("aaa");
        List<User> userList = new ArrayList<User>();
        userList.add(user);
        User user2 = new User();
        user2.setNickName("bbbb");
        user2.setMobile("11112446");
        userList.add(user2);
        return userList;
    }

    /**
     * 进入筛选页面 加载地域信息
     * @param city
     * @return
     */
    @RequestMapping(value = "/page/crawlhouseInfo", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView crawlHouseInfo(@RequestParam(required = false, defaultValue = "宁波") String city) {
        ModelAndView modelAndView = new ModelAndView(LIST);
        Result result = crawlService.crawlFilterOption(city);
        if (result.isSuccessful()) {
            modelAndView.addObject("queryLocal", result.getData());
        }
        return modelAndView;
    }

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

    /**
     * 导入信息
     * @param location 地域
     * @param price 租金
     * @param roomNumber 卧室数
     * @param rentType 出租方式
     * @param toward 朝向
     * @param decoration 装修程度
     * @return 筛选结果
     */
    @RequestMapping(value = "/house/info", method = RequestMethod.GET)
    @ResponseBody
    public Result crawlHouseInfo(@RequestParam(required = false, defaultValue = "") String location,
                                 @RequestParam(required = false, defaultValue = "") String price,
                                 @RequestParam(required = false, defaultValue = "") String roomNumber,
                                 @RequestParam(required = false, defaultValue = "") String rentType,
                                 @RequestParam(required = false, defaultValue = "") String toward,
                                 @RequestParam(required = false, defaultValue = "") String decoration) {
        //获取对应的URL
        String urlString = crawlService.getUrl(location, price, roomNumber, rentType, toward, decoration);
        //抓取数据
//        crawlService.crawlHouseInfo(urlString);
        //从数据库读取数据
        List houseList = crawlService.getHouseInfo(location, price, roomNumber, rentType, toward, decoration);
        Result result = new Result();
        if (houseList.size() < 1) {
            result.setSuccessful(false);
            result.setMsg("没有数据");
        } else {
            result.setData(houseList);
        }
        return result;
    }

    /**
     * 删除信息
     *
     *
     * @param houseIdListString
     * @return
     */
    @RequestMapping(value = "/houseInfo/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result collectHouse(@RequestParam(required = false) String houseIdListString) {
        List<Long> houseIdList = JSONArray.parseArray(houseIdListString, Long.class);
        Result result = new Result();
        boolean collecteResult = false;
        if (houseIdList == null || houseIdList.size() < 1) {
            result.setSuccessful(false);
            result.setMsg("删除失败");
            return result;
        }
        if (houseIdList.size() == 1) {
            collecteResult = houseService.deleteOneHouseInfo(houseIdList.get(0));
        } else {
            collecteResult = houseService.deleteHouseInfoList(houseIdList);
        }
        if (collecteResult) {
            result.setSuccessful(true);
            result.setMsg("删除成功");
            return result;
        }

        result.setSuccessful(false);
        result.setMsg("删除失败");

        return result;
    }
}
