package com.boz.controller;

import com.boz.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("thy")
public class ThyController {

    @Autowired
    private UserAdminService userAdminService;

    @RequestMapping("index")
    public String abc(ModelMap map){
        map.addAttribute("name","hello world every");

        map.addAttribute("userlist",userAdminService.selectAll());
        //int a = 1/0;
        return "thymeleaf/index";
    }
}
