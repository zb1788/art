package com.boz.controller;

import com.boz.bean.JSONResult;
import com.boz.bean.User;
import com.boz.util.GsonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    User user;

    @RequestMapping("/index")
    @ResponseBody
    public JSONResult index(){
        System.out.println(user.toString());
        return JSONResult.ok("OK");
    }


    @RequestMapping("/test")
    @ResponseBody
    public JSONResult testZn(@RequestParam("name") String name){
        return JSONResult.ok(name);
    }


    @RequestMapping("getParams")
    @ResponseBody
    public JSONResult test(@RequestParam("data") String data){
        try {
            data = URLDecoder.decode(data,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Object json = GsonTools.JSONStringToObject(data,Object.class);

        System.out.println(json);
        return JSONResult.ok(json);
    }





}
