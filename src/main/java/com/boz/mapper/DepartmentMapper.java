package com.boz.mapper;

import com.boz.bean.Department;
import com.boz.bean.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Mapper
public interface DepartmentMapper {
	//查询所有部门

	List<Department> findAll();

	Department findById(Integer id);

	Integer editById(Integer id, String name);
	
	
	Integer editByDepBean(Department dep);

	

	List<Employee> selectByDepId(Integer id);
	
	

	Department findByIdOneToMany(Integer id);
	
	

	List<Object> findDepBySql(Integer id);

}
