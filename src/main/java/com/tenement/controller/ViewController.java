package com.tenement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by LXPENG on 2016/5/5.
 * 返回视图
 */
@Controller
@RequestMapping(value = "/view")
public class ViewController {
    private static final String LEFT = "left";
    private static final String TOP = "top";
    private static final String FRAMESET = "frameset";

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


}
