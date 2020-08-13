package com.boz.controller;

import com.boz.bean.JSONResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController {
    public static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    String suffixList = "jpg,png,ico,jpeg,bmp,mp4";

    @PostMapping("/single")
    public JSONResult upload(@RequestParam("file")MultipartFile file, HttpServletRequest request){

        //文件超过最大限制在全局异常中捕获

        if(file.isEmpty()){
            return JSONResult.errorMsg("文件不能为空！");
        }else{
            String fileName = file.getOriginalFilename();
            logger.info("format before fileName:{}" , fileName);


            logger.info("format after fileName:{}" , fileName);
            //获取文件后缀
            String suffix = fileName.substring(fileName.lastIndexOf(".") + 1).trim().toLowerCase();
            //设置允许文件上传列表
            if(suffixList.contains(suffix)){
                Date date = new Date();
                SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd");

                String savePath = request.getSession().getServletContext().getRealPath("/")+"upload/" + sf.format(date) + "/";
                String toName = System.currentTimeMillis() + UUID.randomUUID().toString() + "." + suffix;

                File dir = new File(savePath);
                if(!dir.exists() && !dir.isDirectory()){
                    dir.mkdirs();
                }

                logger.info("dist filepath:"+ savePath + toName);
                File dist = new File(savePath + toName);
                try {
                    file.transferTo(dist);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                HashMap<String,String> map = new HashMap<>();
                map.put("fromName",fileName);
                map.put("toName",toName);
                map.put("filePath",savePath);
                return JSONResult.ok(map);
            }else{
                return JSONResult.errorMsg("文件类型错误！");
            }
        }
    }


    @RequestMapping("showStatus")
    public JSONResult showStatus(@ModelAttribute("message") String message){
        return JSONResult.errorMsg(message);
    }

}
