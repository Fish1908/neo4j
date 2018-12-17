package com.project_management.shoppingweb.shopping_web.Service.Impl;

import com.project_management.shoppingweb.service.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sengSimpleMail("twostarxingxin@163.com", "test simple mail", "hello, this is a test mail from hsing.");
    }
}
