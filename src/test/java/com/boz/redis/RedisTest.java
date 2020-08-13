package com.boz.redis;

import com.boz.util.RedisOperator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisOperator redisOperator;

    //查询过期时间
    @Test
    public void testTtl(){
        long a = redisOperator.ttl("name");
        System.out.println(a);
    }

    //设置过期时间
    @Test
    public void testExpire(){
        redisOperator.expire("name",55);
    }
    
    
    //测试字符串
    @Test
    public void testString(){
        System.out.println(redisOperator.get("name"));
        redisOperator.set("name","zb");
        System.out.println(redisOperator.get("name"));
    }


    //测试哈希
    @Test
    public void testHash(){
//        redisOperator.hset("akey","field","a b c d");
//        redisOperator.hset("akey","field2","e");
        redisOperator.hset("akey","field3","f");
    }


    @Test
    public void testGetHash(){
        Map<Object, Object> map = redisOperator.hgetall("akey");
        System.out.println(map);

        System.out.println(map.get("field3"));

        String str = redisOperator.hget("akey", "field2");
        System.out.println(str);


    }

    
    
}
