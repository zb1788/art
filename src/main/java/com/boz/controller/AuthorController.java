package com.boz.controller;

import com.boz.bean.AuthorProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
@PropertySource(value = {"classpath:author.properties"},encoding = "utf-8")
public class AuthorController {
    @Autowired
    private AuthorProperties authorProperties;

    @RequestMapping("index")
    public String index(){
        return "name:"+ authorProperties.getName() + ",age:" + authorProperties.getAge();
    }
}
