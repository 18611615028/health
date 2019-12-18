package com.example.health;

import com.example.health.controller.DocController;
import com.example.health.domin.Doc;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HealthApplication.class})
class HealthApplicationTests {

    @Autowired
    DocController docController;

    @Test
    void contextLoads() {
        Doc doc = new Doc();
        doc.setUserName("doc01");
        doc.setPassWord("passw0rd");
        int login = docController.login(doc);
        System.out.println(login);

    }
}
