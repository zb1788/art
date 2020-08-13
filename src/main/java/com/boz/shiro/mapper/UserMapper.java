package com.boz.shiro.mapper;

import com.boz.shiro.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
@Service
public interface UserMapper {

    @Select("select * from shiro_sys_user")
    @Results({
            @Result(id=true,column="user_id",property="userId"),
    })
    List<User> selectAll();

    @Select("select * from shiro_sys_user where username = #{username}")
    @Results({
            @Result(id=true,column="user_id",property="userId"),
    })
    User findByUsername(String username);

    @Select("SELECT m.role_id, m.rolename FROM shiro_sys_role m LEFT JOIN shiro_sys_user_role n ON m.role_id=n.role_id WHERE n.user_id=#{userId}")
    List<Map> findUserRoles(Integer userId);

    @Select("SELECT m.role_id,p.permissionname FROM shiro_sys_role m LEFT JOIN shiro_sys_user_role n ON m.role_id=n.role_id LEFT JOIN shiro_permission p  ON n.role_id=p.role_id WHERE n.user_id=#{userId}")
    List<Map> findUserPermissions(Integer userId);

}
