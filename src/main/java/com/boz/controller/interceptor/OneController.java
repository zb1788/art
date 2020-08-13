package com.boz.controller.interceptor;

import com.boz.bean.JSONResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("one")
public class OneController {


    @RequestMapping("test")
    public JSONResult test(){
        String msg = "hello world";
        System.out.println(msg);
        return JSONResult.ok(msg);
    }
}
