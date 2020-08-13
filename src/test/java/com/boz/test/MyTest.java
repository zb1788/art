package com.boz.test;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyTest {



    @Test
    public void ziFindTest(){

        String str = "zb123111";
        System.out.println(new Md5Hash(str).toHex().toString());
    }


}
