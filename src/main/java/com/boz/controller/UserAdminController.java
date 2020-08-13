package com.boz.controller;

import com.boz.bean.JSONResult;
import com.boz.bean.UserAdmin;
import com.boz.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserAdminController {


    @Autowired
    UserAdminService userAdminService;

    @RequestMapping("/selectAllUser")
    public JSONResult selectAll(){
        List<UserAdmin> lists = userAdminService.selectAll();
        return JSONResult.ok(lists);
    }

    @RequestMapping("/selectUserByPage")
    public JSONResult selectUserByPage(@RequestParam("pageStart") Integer pageStart,@RequestParam("pageSize") Integer pageSize){
        Map result = userAdminService.selectUserByPage(pageStart,pageSize);
        return JSONResult.ok(result);
    }


    @RequestMapping("selectUserByPageHelp")
    public JSONResult selectUserByPageHelp(@RequestParam("pageStart") Integer pageStart,@RequestParam("pageSize") Integer pageSize){
        Map map = userAdminService.selectUserByPageHelp(pageStart,pageSize);
        return JSONResult.ok(map);
    }



    @RequestMapping("findUserByUsernameAndPwd")
    public JSONResult findUserByUsernameAndPwd(@RequestParam("username") String username,@RequestParam("pwd") String pwd){
        List<UserAdmin> lists = userAdminService.findUserByUsernameAndPwd(username,pwd);

        if(lists.size()>0){
            return JSONResult.ok(lists.get(0));
        }else{
            return JSONResult.errorMsg("用户名或者密码错误");
        }
    }

    @RequestMapping("findUserById")
    public JSONResult findUserById(@RequestParam("id") Integer id){
        UserAdmin userAdmin = userAdminService.findUserById(id);
        return JSONResult.ok(userAdmin);
    }

    @RequestMapping("updateUser")
    public JSONResult updateUser(@RequestBody UserAdmin userAdmin){
        int count = userAdminService.updateUser(userAdmin);
        if(count == 0){
            return JSONResult.errorMsg("update error");
        }else{
            return JSONResult.ok();
        }
    }

    @RequestMapping("insertUser")
    public JSONResult insertUser(@RequestBody UserAdmin userAdmin){
        int count;
        if(userAdmin.getUid() == 0){
            //新增
            count = userAdminService.insertUser(userAdmin);
        }else{
            //更新
            count = userAdminService.updateUser(userAdmin);
        }
        
        if(count == 0){
            return JSONResult.errorMsg("insert error");
        }else{
            return JSONResult.ok();
        }
    }


    @RequestMapping("delUserById")
    public JSONResult delUserById(@RequestParam("id") Integer id){
        int count = userAdminService.delUserById(id);
        if(count == 0){
            return JSONResult.errorMsg("delete error");
        }else{
            return JSONResult.ok();
        }
    }

    @RequestMapping("logout")
    public JSONResult logout(){
        return JSONResult.ok();
    }

}
