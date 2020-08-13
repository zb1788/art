package com.boz.config;

import com.boz.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    /**
     * 程序启动的时候写入内存的数据
     * @return
     */
    @Bean
    User user(){
        User u = new User();
        u.setAge("18");
        u.setId("111");
        u.setName("zs");
        return u;
    }
}
