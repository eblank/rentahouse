package com.tenement.controller;

import com.alibaba.fastjson.JSONObject;
import com.tenement.common.util.Result;
import com.tenement.mapper.UserMapper;
import com.tenement.model.CaptchaCode;
import com.tenement.service.UserService;
import com.tenement.serviceImplements.common.mailService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	@Autowired
	private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private mailService mailService;


	@RequestMapping(value="page/login")
	public String test() {
		return "login";
	}

    /**
     * 注册
     *
     * @param email
     * @param nickname
     * @param registerPassword
     * @return
     */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
	public Result register(@RequestParam String email,
                           @RequestParam String nickname,
                           @RequestParam("register_password") String registerPassword) {
        Result result = new Result();

        if (! userService.checkAccount(email)) {
            result.setSuccessful(false);
            result.setMsg("用户已存在");
            return result;
        }
        try {
            boolean registerResult= userService.userRegister(email, nickname, registerPassword);
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
        account.put("password", registerPassword);
        result.setData(account);
		return result;
	}

    /**
     * 登录
     *
     * @param account
     * @param password
     * @return
     */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
	public Result login(@RequestParam String account,
                        @RequestParam String password) {
        Result result = new Result();
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

    /**
     * 发送验证邮件
     *
     * @param account
     * @return
     */
    @RequestMapping(value="/forgot", method = RequestMethod.POST)
    @ResponseBody
    public Result forgot(@RequestParam String account) {
        Result result = new Result();
        try {
            mailService.sendMial(account);
        } catch (Exception e) {
            result.setSuccessful(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

    /**
     * 验证修改密码安全码
     *
     * @param sid
     * @param model
     * @return
     */
    @RequestMapping(value="/checkLink", method = RequestMethod.GET)
    public String checkEmail(@RequestParam String sid, Model model) {
        if (!userService.cheackEmail(sid)) {
            model.addAttribute("errorMessage", "已过期");
            return "error";
        }
        return "resetPassword";
    }

    /**
     * 修改密码
     *
     * @param password
     * @param passwordagain
     * @param validataCode
     * @return
     */
    @RequestMapping(value="/password/change", method = RequestMethod.POST)
    @ResponseBody
    public Result changePassword(@RequestParam("password") String password,
                                 @RequestParam("password_again") String passwordagain,
                                 @RequestParam("sid") String validataCode) {
        Result result = new Result();
        try {
            boolean success = userService.changePassword(password, passwordagain, validataCode);
            if (success) {
//                JSONObject accountInfo = new JSONObject();
//                accountInfo.put("account", captchaCode.getUserAccount());
//                accountInfo.put("password", password);
//                result.setData(accountInfo);
                result.setMsg("修改密码成功");
            } else {
                result.setSuccessful(false);
                result.setMsg("修改密码失败");
            }
        } catch (Exception e) {
            result.setSuccessful(false);
            result.setMsg(e.getMessage());
        }
        return result;
    }

}
