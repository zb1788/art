package com.boz.shiro.config;

import com.boz.shiro.domain.User;
import com.boz.shiro.mapper.UserMapper;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;

    //角色权限和对应权限添加
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String)principalCollection.getPrimaryPrincipal();
        //查询用户
        User user = userMapper.findByUsername(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Map role : userMapper.findUserRoles(user.getUserId())){
            //添加角色
            simpleAuthorizationInfo.addRole((String) role.get("rolename"));
        }
        for (Map permission : userMapper.findUserPermissions(user.getUserId())){
            //添加权限
            simpleAuthorizationInfo.addStringPermission((String) permission.get("permissionname"));
        }
        return simpleAuthorizationInfo;
    }

    //用户认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求
        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
        String name = authenticationToken.getPrincipal().toString();
        User user = userMapper.findByUsername(name);
        if(user == null){
            //这里返回后会报出对应异常
            return null;
        }else{
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(name, user.getPassword().toString(), getName());

            return simpleAuthenticationInfo;
        }
    }
}
