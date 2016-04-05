package com.tenement.controller;

import com.tenement.mapper.UserMapper;
import com.tenement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping(value = "/home")
public class HomeController {
	@Autowired
	private UserMapper userMapper;


	@RequestMapping(value="/test")
	public String test(Model model) {
		User user = new User("逗逼", "张三", new Date(), "1");
		int result = userMapper.insert(user);
		model.addAttribute("number", result);
		model.addAttribute("user", "张三");
		return "home";
	}

}
