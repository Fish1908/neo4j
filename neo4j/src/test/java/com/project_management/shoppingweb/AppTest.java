package com.project_management.shoppingweb;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import com.project_management.shoppingweb.service.PersonService;
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

  @Test
  public void contextLoad() {
   RequestResultVO person= personService.findByName("小健");
    System.out.println(person);
  }
  @Test
  public void test01()
  {
    System.out.println(personService.genCaptcha("小健"));
    String returnValue = stringRedisTemplate.opsForValue().get("captcha:小健");
    String input="3984";
    Assert.assertEquals(returnValue,input);
  }
}