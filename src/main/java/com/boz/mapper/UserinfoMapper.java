package com.boz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
@Service
public interface UserinfoMapper {

    @Select("select * from userinfo")
    List<Map> findAll();
}
