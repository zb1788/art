package com.boz.controller;

import com.boz.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {



	@RequestMapping("/index")
	public String hello(){


		return "hello";
	}
	
	@RequestMapping("/test")
	public String test(){
		return "test";
	}	
}
