package com.boz.controller;

import com.boz.bean.JSONResult;
import com.boz.bean.MusicGroup;
import com.boz.bean.MusicInfo;
import com.boz.service.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("music")
public class MusicController {

    @Autowired
    MusicInfoService musicInfoService;

    @RequestMapping("/selectMusicByPage")
    public JSONResult selectMusicByPage(@RequestParam("pageStart") Integer pageStart, @RequestParam("pageSize") Integer pageSize){
        Map result = musicInfoService.selectMusicByPage(pageStart,pageSize);

        return JSONResult.ok(result);
    }


    @RequestMapping("testCustom")
    public JSONResult selectTestByCustom(){
        List lists = musicInfoService.selectMusicBypageCustom(1,3);
        return JSONResult.ok(lists);
    }


    @RequestMapping("findMusicById")
    public JSONResult findMusicById(@RequestParam("id") Integer id){
        MusicInfo musicInfo = musicInfoService.findMusicById(id);
        return JSONResult.ok(musicInfo);
    }

    @RequestMapping("saveMusic")
    public JSONResult saveMusic(@RequestBody MusicInfo musicInfo){
        int count;
        if(musicInfo.getId() == 0){
            count = musicInfoService.insertMusic(musicInfo);
        }else{
            count = musicInfoService.saveMusic(musicInfo);
        }
        if(count == 0){
            return JSONResult.errorMsg("insert error");
        }else{
            return JSONResult.ok();
        }
    }

    @RequestMapping("delMusicByID")
    public JSONResult delMusicById(@RequestParam("id") Integer id){
        int count = musicInfoService.delMusicById(id);
        if(count == 0){
            return JSONResult.errorMsg("del error");
        }else{
            return JSONResult.ok();
        }
    }


    @RequestMapping("selectGenre")
    public JSONResult selectGenre(){
        List<MusicGroup> lists =musicInfoService.selectGenre();
        return JSONResult.ok(lists);
    }


}
