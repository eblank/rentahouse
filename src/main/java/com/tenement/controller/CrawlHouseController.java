package com.tenement.controller;

import com.tenement.common.util.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by LXPENG on 2016/4/27.
 */
@Controller
@RequestMapping(value = "/crawl")
public class CrawlHouseController {

    public Result crawlFilterOption(@RequestParam(required = false, value = "宁波") String city) {
        Result result = new Result();

        return null;
    }
}
