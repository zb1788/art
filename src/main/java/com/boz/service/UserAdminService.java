package com.boz.service;

import com.boz.bean.UserAdmin;
import com.boz.bean.UserAdminExample;
import com.boz.mapper.UserAdminMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserAdminService {

    @Autowired
    UserAdminMapper userAdminMapper;


    public List<UserAdmin> selectAll() {
        UserAdminExample example = new UserAdminExample();
        return userAdminMapper.selectByExample(example);
    }

    public Map selectUserByPage(Integer pageStart, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("start", (pageStart-1)*pageSize);
        map.put("size", pageSize);

        UserAdminExample example = new UserAdminExample();
        Long count = userAdminMapper.countByExample(example);

        List<UserAdmin> lists = userAdminMapper.selectByPage(map);

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("lists",lists);
        result.put("total",count);
        return result;
    }

    public Map selectUserByPageHelp(Integer pageStart, Integer pageSize) {
        //开始分页
        Page page = PageHelper.startPage(pageStart,pageSize);

        UserAdminExample example = new UserAdminExample();
        List<UserAdmin> lists = userAdminMapper.selectByExample(example);

        Map<String,Object> map = new HashMap<>();
        map.put("lists",lists);
        map.put("total",page.getTotal());
        return map;
    }

    public List<UserAdmin> findUserByUsernameAndPwd(String username, String pwd) {
        UserAdminExample example = new UserAdminExample();
        String pwdMd5 = new com.boz.util.MD5().getMD5ofStr(pwd).toLowerCase();
        example.or().andUsernameEqualTo(username).andPwdEqualTo(pwdMd5);
        return userAdminMapper.selectByExample(example);
    }

    public UserAdmin findUserById(Integer id) {
        return userAdminMapper.selectByPrimaryKey(id);
    }

    public int updateUser(UserAdmin userAdmin) {
        return userAdminMapper.updateByPrimaryKeySelective(userAdmin);
    }

    public int insertUser(UserAdmin userAdmin) {
        return userAdminMapper.insertSelective(userAdmin);
    }

    public int delUserById(Integer id) {
        return userAdminMapper.deleteByPrimaryKey(id);
    }
}
