package com.boz.controller;

import com.boz.bean.Department;
import com.boz.bean.JSONResult;
import com.boz.mapper.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/dep")
public class DepartmentController {

	@Autowired
	DepartmentMapper departmentMapper;

	@RequestMapping("/test")
	public JSONResult test(){
		System.out.println("xxx");
		return JSONResult.ok("ok");
	}
	
	@RequestMapping("/findAll")
	public JSONResult findAll(){
		List<Department> departments = departmentMapper.findAll();
		System.out.println("aaa");
		return JSONResult.ok(departments);
	}
	
	@RequestMapping("/findById")
	public JSONResult findById(@RequestParam("id") Integer id){
		Department dep = departmentMapper.findById(id);
		return JSONResult.ok(dep);
	}
	
	@RequestMapping("editById")
	public JSONResult editById(@RequestParam("id") Integer id,@RequestParam("name") String name){
		Integer re = departmentMapper.editById(id, name);
		if(re>0){
			return JSONResult.ok();
		}else{
			return JSONResult.errorMsg("error");
		}
	}
	
	@RequestMapping("/editByDepBean")
	public JSONResult editByDepBean(){
		Department dep = new Department();
		dep.setId(1);
		dep.setName("设计部2");
		Integer re = departmentMapper.editByDepBean(dep);
		if(re>0){
			return JSONResult.ok();
		}else{
			return JSONResult.errorMsg("error");
		}
	}
	
	
	@RequestMapping("/editByDepBean2")
	public JSONResult editByDepBean2(@RequestBody Department dep){
		Integer re = departmentMapper.editByDepBean(dep);
		if(re>0){
			return JSONResult.ok();
		}else{
			return JSONResult.errorMsg("error");
		}
	}	
	
	//一对多
	@RequestMapping("/findByIdOneToMany")
	public JSONResult findByIdOneToMany(@RequestParam("id") Integer id){
		Department dep = departmentMapper.findByIdOneToMany(id);
		return JSONResult.ok(dep);
	}
	
	
	//原生sql查询
	@RequestMapping("/findDepBySql")
	public JSONResult findDepBySql(@RequestParam("id") Integer id){
		List<Object> deps = departmentMapper.findDepBySql(id);
		return JSONResult.ok(deps);
	}
	
	
	
	
}
