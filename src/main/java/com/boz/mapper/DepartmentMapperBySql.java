package com.boz.mapper;

import com.boz.bean.Department;
import com.boz.bean.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

  
@Mapper
public interface DepartmentMapperBySql {
	//查询所有部门
	
	@Select("select * from tbl_dep")
	List<Department> findAll();
	
	@Select("select * from tbl_dep where id=#{id}")
	Department findById(Integer id);

	@Update("update tbl_dep set name=#{name} where id=#{id}")
	Integer editById(@Param("id") Integer id,@Param("name") String name);
	
	
	@Update("update tbl_dep set name=#{name} where id=#{id}")
	Integer editByDepBean(Department dep);

	
	@Select("select * from tbl_emp where did=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="genre",property="genre"),
		@Result(column="age",property="age"),
		@Result(column="createTime",property="createTime")
	})
	List<Employee> selectByDepId(Integer id);
	
	
	@Select("select * from tbl_dep where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="name",property="name"),
		@Result(column="id",property="empList",
			many=@Many(
					select="com.boz.mapper.DepartmentMapper.selectByDepId"
//					,fetchType=FetchType.LAZY
			)
		)
	})
	Department findByIdOneToMany(Integer id);
	
	
	@Select("select d.id,d.name,e.name as ename,e.genre,e.age,e.age,e.createTime from tbl_dep d left join tbl_emp e on d.id=e.did where d.id=#{id}")
	@Results({
		@Result(column="id"),
		@Result(column="name")
	})	
	List<Object> findDepBySql(Integer id);

}
