package com.project_management.shoppingweb;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import com.project_management.shoppingweb.service.MailService;
import com.project_management.shoppingweb.service.PersonService;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import org.apache.commons.lang3.RandomUtils;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

  @Autowired
  PersonRepository personRepository;
  @Autowired
  PersonService personService;
  @Autowired
  StringRedisTemplate stringRedisTemplate;
  @Autowired
  MailService mailService;
  @Test
  public void contextLoad() {
   RequestResultVO person= personService.findByName("小健");
    System.out.println(person);
  }
  @Test
  public void test01()
  {
    System.out.println(personService.genCaptcha("小健"));

  }
  @Test
  public  void test02()
  {

    System.out.println(new DecimalFormat("0000").format(1));
  }
  @Test
  public void test03()
  {
    String code="1234";
    mailService.sengSimpleMail("1353250459@qq.com","注册验证码",code);
  }
  @Test
  public  void test04()
  {
    JSONObject jsonObject=new JSONObject();
  }
}