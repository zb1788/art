package com.boz.user;


import com.boz.bean.UserAdmin;
import com.boz.service.UserAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserAdminTest {

    @Autowired
    private UserAdminService userAdminService;


    @Test
    public void findUserTest(){
        UserAdmin userAdmin = userAdminService.findUserById(1);
        System.out.println(userAdmin.getUsername());
    }
}
