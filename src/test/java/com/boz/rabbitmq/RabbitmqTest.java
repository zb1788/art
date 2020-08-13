package com.boz.rabbitmq;


import com.boz.bean.Order;
import com.boz.rabbitmq.producer.OrderSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitmqTest {

    @Autowired
    private OrderSender orderSender;

    @Test
    public void testSend(){
        Order order = new Order();
        order.setId("2019030400000001");
        order.setName("测试订单1");
        order.setMessageId(System.currentTimeMillis()+"$"+ UUID.randomUUID().toString());

        orderSender.send(order);

    }


    @Test
    public void reciveTest(){

    }

}
