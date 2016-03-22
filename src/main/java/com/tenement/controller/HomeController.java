package com.tenement.controller;

import com.tenement.mapper.UserMapper;
import com.tenement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
public class HomeController {
	@Autowired
	UserMapper userMapper;


	@RequestMapping(value="/")
	public String test(Model model) throws IOException{
		User user = userMapper.selectByPrimaryKey(1L);
		model.addAttribute("user", user.getUser());
		return "home";
	}
}
