package com.boz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
@Service
public interface MusicInfoMapperCustom {

    List<Map<String,Object>> selectByPage(Map<String, Object> map);
}