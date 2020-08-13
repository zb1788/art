package com.boz.yw;


import com.boz.bean.Cixing;
import com.boz.bean.CixingExample;
import com.boz.bean.Zi;
import com.boz.bean.ZiExample;
import com.boz.mapper.CixingMapper;
import com.boz.mapper.ZiMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ZiTest {


    @Autowired
    private ZiMapper ziMapper;

    @Autowired
    private CixingMapper cixingMapper;

    @Test
    public void ziFindTest(){
        ZiExample ziExample = new ZiExample();
        ziExample.or().andZiEqualTo("大");
        List<Zi> ziList = ziMapper.selectByExample(ziExample);
        System.out.println(ziList.get(0).toString());
    }


    @Test
    public void ciXingTest(){
        CixingExample cixingExample = new CixingExample();
        cixingExample.or().andZiEqualTo("大");
        List<Cixing> list = cixingMapper.selectByExample(cixingExample);
        System.out.println(list.get(0).getCizu());

        Cixing cixing = list.get(0);
        cixing.setCizu("大雁#大地#光明正大#哈哈");
        cixingMapper.updateByPrimaryKeySelective(cixing);

    }
}
