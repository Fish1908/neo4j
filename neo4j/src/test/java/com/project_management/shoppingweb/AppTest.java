package com.project_management.shoppingweb;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {

  @Autowired
  PersonRepository personRepository;
  @Test
  public void contextLoad() {
   Person person= personRepository.findByName("孙露阳");
    System.out.println(person);
  }
}