package com.boz.shiro.controller;

import com.boz.bean.JSONResult;
import com.boz.shiro.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("shiro")
public class UserController {


    @Autowired
    UserMapper userMapper;


    @RequestMapping("index")
    public JSONResult index(){
        return JSONResult.ok("index");
    }

    @RequestMapping("login")
    public JSONResult login(){
        return JSONResult.ok("login");
    }

    @RequestMapping("loginAc")
    public JSONResult loginAc(){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken("zb","123");
        subject.login(usernamePasswordToken);
        return JSONResult.ok("loginAc");
    }

    @RequestMapping("loginO")
    public JSONResult loginO(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return JSONResult.ok("loginO");
    }

    @RequiresPermissions("user:add")
    @RequestMapping("selectUser")
    public JSONResult selectAllUser(){
            return JSONResult.ok(userMapper.selectAll());
    }

    @RequestMapping("findUserRoles")
    public JSONResult findUserRoles(){
        List<Map> result = userMapper.findUserRoles(1);
        return JSONResult.ok(result);
    }

    @RequestMapping("findUserPermissions")
    public JSONResult findUserPermissions(){
        return JSONResult.ok(userMapper.findUserPermissions(1));
    }
}
