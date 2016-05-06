package com.tenement.controller;

import com.tenement.common.baseController.BaseController;
import com.tenement.common.util.Result;
import com.tenement.mapper.UserMapper;
import com.tenement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by LXPENG on 2016/5/7.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends BaseController {
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/saveInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result saveInfo(@RequestParam Long id,
                           @RequestParam String nickName,
                           @RequestParam String realName,
                           @RequestParam String sex,
                           @RequestParam String province,
                           @RequestParam String city,
                           @RequestParam String county,
                           @RequestParam String town,
                           @RequestParam String mobile) {
        Result result = new Result();
        Long currentId = this.getUserId();
        if (id != currentId) {
            result.setSuccessful(false);
            result.setMsg("身份验证失败");
            return result;
        }
        User user = userMapper.selectByPrimaryKey(id);
        user.setNickName(nickName);
        user.setRealName(realName);
        user.setSex(sex);
        user.setProvince(province);
        user.setCity(city);
        user.setCounty(county);
        user.setTown(town);
        user.setMobile(mobile);

        int update = userMapper.updateByPrimaryKey(user);
        if (update < 1) {
            result.setSuccessful(false);
            result.setMsg("保存失败");
            return result;
        }
        result.setSuccessful(true);
        result.setMsg("保存成功");
        return result;
    }

    @RequestMapping(value = "/view/info")
    public String framesetView(Model model) {
        Long userId = this.getUser().getId();
        User user = userMapper.selectByPrimaryKey(userId);
        model.addAttribute("user", user);
        return "userInfo";
    }
}
