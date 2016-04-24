package com.tenement.controller;

import com.alibaba.fastjson.JSONObject;
import com.tenement.common.util.Result;
import com.tenement.mapper.UserMapper;
import com.tenement.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	@Autowired
	private UserMapper userMapper;
    @Autowired
    private userService userService;
//    @Autowired
//    private MyEmail myEmail;


	@RequestMapping(value="/test")
	public String test(Model model) {
		model.addAttribute("number", 1);
		model.addAttribute("user", "张三");
		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
	public Result register(HttpServletRequest request, Model model) {
        Result result = new Result();
		String email = request.getParameter("email");
		String nickname = request.getParameter("nickname");
		String password = request.getParameter("register_password");

        if (! userService.checkAccount(email)) {
            result.setSuccessful(false);
            result.setMsg("用户已存在");
            return result;
        }
        try {
            boolean registerResult= userService.userRegister(email, nickname, password);
            if (registerResult) {
                result.setSuccessful(true);
                result.setMsg("注册成功");
            } else {
                result.setSuccessful(false);
                result.setMsg("注册失败");
            }
        }catch (Exception e) {
            result.setSuccessful(false);
            result.setMsg("操作失败");
        }

        JSONObject account = new JSONObject();
        account.put("nickname", nickname);
        account.put("password", password);
        result.setData(account);
		return result;
	}

	@RequestMapping(value = "/login")
    @ResponseBody
	public Result login(HttpServletRequest request, Model model) {
        Result result = new Result();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
        String nickname = "";

        try {
            nickname = userService.userLogin(account, password);
        }catch (Exception e) {
            result.setSuccessful(false);
            result.setMsg(e.getMessage());
        }
        JSONObject userInfo = new JSONObject();
        userInfo.put("nickname", nickname);
        result.setData(account);
		return result;
	}

//    @RequestMapping(value="/forgot")
//    @ResponseBody
//    public Result forgot(HttpServletRequest request, Model model) {
//        Result result = new Result();
//        myEmail.sendMial();
//        return result;
//    }

}
