package com.boz.controller;

import com.boz.bean.JSONResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("getdb")
public class GetDbNoBean {

    @Mapper
    public interface UserinfoMapper{

        @Select("select name from userinfo limit 1")
        String getName();

        @Select("select * from userinfo where id=#{id}")
        Map getUserById(int id);

        @Select("select * from userinfo limit 1")
        Map getUser();

        @Select("select name,age from userinfo limit 3")
        List<Map> getUserList();
    }

    @Autowired
    @SuppressWarnings("all")
    UserinfoMapper userinfoMapper;


    @RequestMapping("getName")
    public JSONResult getdata(){
        String name = userinfoMapper.getName();

        return JSONResult.ok(name);
    }


    @RequestMapping("getUserById")
    public JSONResult getUserById(@RequestParam("id") Integer id){
        Map user = userinfoMapper.getUserById(id);

        return JSONResult.ok(user);
    }

    @RequestMapping("getUser")
    public JSONResult getUser(){
        Map user = userinfoMapper.getUser();

        return JSONResult.ok(user);
    }



    @RequestMapping("getUserList")
    public JSONResult getUserList(){
        List<Map> userList = userinfoMapper.getUserList();

        return JSONResult.ok(userList);
    }



}
