package com.boz.service;

import com.boz.bean.MusicGroup;
import com.boz.bean.MusicGroupExample;
import com.boz.bean.MusicInfo;
import com.boz.bean.MusicInfoExample;
import com.boz.mapper.MusicGroupMapper;
import com.boz.mapper.MusicInfoMapper;
import com.boz.mapper.MusicInfoMapperCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MusicInfoService {

    @Autowired
    MusicInfoMapper musicInfoMapper;

    @Autowired
    MusicGroupMapper musicGroupMapper;

    @Autowired
    MusicInfoMapperCustom musicInfoMapperCustom;
    public Map selectMusicByPage(Integer pageStart, Integer pageSize) {
        Map<String, Object> map = new HashMap<>();
        map.put("start", (pageStart-1)*pageSize);
        map.put("size", pageSize);

        MusicInfoExample example = new MusicInfoExample();


        long count = musicInfoMapper.countByExample(example);

        List<MusicInfo> lists =musicInfoMapper.selectByPage(map);

        Map<String, Object> result = new HashMap<>();
        result.put("lists",lists);
        result.put("total",count);
        return result;
    }

    public List selectMusicBypageCustom(Integer pageStart, Integer pageSize){
        Map<String, Object> map = new HashMap<>();
        map.put("start", (pageStart-1)*pageSize);
        map.put("size", pageSize);

        List<Map<String,Object>> lists = musicInfoMapperCustom.selectByPage(map);
        return lists;
    }


    public MusicInfo findMusicById(Integer id) {
        return musicInfoMapper.selectByPrimaryKey(id);
    }

    public int insertMusic(MusicInfo musicInfo) {
        return musicInfoMapper.insertSelective(musicInfo);
    }

    public int saveMusic(MusicInfo musicInfo) {
        return musicInfoMapper.updateByPrimaryKeySelective(musicInfo);
    }

    public int delMusicById(Integer id) {
        return musicInfoMapper.deleteByPrimaryKey(id);
    }


    public List<MusicGroup> selectGenre() {
        MusicGroupExample example = new MusicGroupExample();
        return musicGroupMapper.selectByExample(example);
    }
}
