package com.boz.controller;

import com.boz.bean.JSONResult;
import com.boz.bean.UserAdmin;
import com.boz.util.GsonTools;
import com.boz.util.RedisOperator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("redis")
public class RedisController {
	
	@Autowired
	private StringRedisTemplate strRedis;


	@Autowired
	private RedisOperator redis;
	
	@RequestMapping("/test")
	public JSONResult test() {
		
		strRedis.opsForValue().set("imooc-cache", "hello 慕课网~~~~~~");

		UserAdmin userAdmin = new UserAdmin();
		userAdmin.setUid(1);
		userAdmin.setUsername("abc");
		userAdmin.setTruename("aaa");
		userAdmin.setPwd("123456");
		userAdmin.setIfadmin(1);

		strRedis.opsForValue().set("json:user", GsonTools.beanToJSONString(userAdmin));

		UserAdmin jsonUser = (UserAdmin) GsonTools.JSONStringToObject(strRedis.opsForValue().get("json:user"), UserAdmin.class);
		
		return JSONResult.ok(jsonUser);
	}
	
	@RequestMapping("/getJsonList")
	public JSONResult getJsonList() {

		UserAdmin userAdmin1 = new UserAdmin();
		userAdmin1.setUid(1);
		userAdmin1.setUsername("abc");
		userAdmin1.setTruename("aaa");
		userAdmin1.setPwd("123456");
		userAdmin1.setIfadmin(1);

		UserAdmin userAdmin2 = new UserAdmin();
		userAdmin2.setUid(2);
		userAdmin2.setUsername("bbbbb");
		userAdmin2.setTruename("22222222222");
		userAdmin2.setPwd("123456");
		userAdmin2.setIfadmin(1);

		UserAdmin userAdmin3 = new UserAdmin();
		userAdmin3.setUid(3);
		userAdmin3.setUsername("cccccccc");
		userAdmin3.setTruename("333333333");
		userAdmin3.setPwd("123456");
		userAdmin3.setIfadmin(1);
		
		List<UserAdmin> userList = new ArrayList<>();
		userList.add(userAdmin1);
		userList.add(userAdmin2);
		userList.add(userAdmin3);

		System.out.println(userList);


		redis.set("json:info:userlist", GsonTools.beanToJSONString(userList), 2000);

		String userListJson = redis.get("json:info:userlist");

		List<Object> returnData = GsonTools.jsonToList(userListJson,UserAdmin.class);

		return JSONResult.ok(returnData);
	}


	@RequestMapping("tt")
	public JSONResult testZ(){
//		String str = redis.get("8056_0");
//		Map<Object, Object> aa = redis.hgetall("8056_0");
		Set<String> abc = strRedis.opsForZSet().range("8056_0",0,-1);


		redis.set("abcaaaaaaaaaaaa","abc");
		String tt = redis.get("abcaaaaaaaaaaaa");
		return JSONResult.ok(abc);
	}



}