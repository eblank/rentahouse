package com.tenement.controller;

import com.tenement.common.baseController.BaseController;
import com.tenement.common.util.Result;
import com.tenement.service.CrawlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by LXPENG on 2016/5/5.
 * 返回视图
 */
@Controller
@RequestMapping(value = "/view")
public class ViewController extends BaseController {
    private static final String LEFT = "left";
    private static final String TOP = "top";
    private static final String FRAMESET = "frameset";
    private static final String MYCOLLECTION = "myCollection";

    @Autowired
    private CrawlService crawlService;

    @RequestMapping(value = "/left")
    public String leftView() {
        return LEFT;
    }

    @RequestMapping(value = "/top")
    public String topView() {
        return TOP;
    }

    @RequestMapping(value = "/frameset")
    public String framesetView() {
        return FRAMESET;
    }

    /**
     * 进入我的收藏页面 加载地域信息
     *
     * @param city
     * @return
     */
    @RequestMapping(value = "/myCollection", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView crawlHouseInfo(@RequestParam(required = false, defaultValue = "宁波") String city) {
        ModelAndView modelAndView = new ModelAndView(MYCOLLECTION);
        Result result = crawlService.crawlFilterOption(city);
        if (result.isSuccessful()) {
            modelAndView.addObject("queryLocal", result.getData());
        }
        return modelAndView;
    }


}
