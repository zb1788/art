package com.boz.controller;

import com.boz.bean.JSONResult;
import com.boz.mapper.UserinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("getnobean")
public class UserinfoController {


    @Autowired
    UserinfoMapper userinfoMapper;

    @RequestMapping("list")
    public JSONResult userinfolist(){
        return JSONResult.ok(userinfoMapper.findAll());
    }
}
