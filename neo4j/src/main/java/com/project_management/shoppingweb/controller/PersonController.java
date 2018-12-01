package com.project_management.shoppingweb.controller;

import com.project_management.shoppingweb.dao.nodeEntity.Person;
import com.project_management.shoppingweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     * 新增卡包信息
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody Person person){
        return personService.insert(person);
    }

    /**
     * 新增卡包信息
     */
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Object test(@RequestBody Person person){
        return 1;
    }
}
