package com.boz.controller;

import com.boz.bean.PersionProperties;
import com.boz.util.DbConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello")
@PropertySource(value= {"classpath:author.properties"},encoding="UTF-8")
public class HelloController {
	
	@Value("${name}")
	private String name;
	
	@Value("${age}")
	private Integer age;
	
	@Value("${content}")
	private String content;
	
	@Autowired
	private PersionProperties persionProperties;
	
	@Autowired
	private DbConfigProperties dbConfigProperties;
	
	
	@RequestMapping("/index")
	public String index(){
		System.out.println(name);
		return "第一种直接取：hello " + name + " ,age:" + age + "<br/>" 
				+ "第二种拼接好取：" + content + "<br/>"
				+ "第三种从配置类中取（推荐使用）：name:" + persionProperties.getName() + ",age:" + persionProperties.getAge() + ",dburl:"+dbConfigProperties.getDriverClassName();
	}
}
