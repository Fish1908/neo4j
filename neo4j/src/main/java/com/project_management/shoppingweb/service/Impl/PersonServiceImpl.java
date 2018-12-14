package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.NameNode;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import com.project_management.shoppingweb.service.PersonService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonRepository personRepository;


    @Override
    public RequestResultVO insert(Person person) {
       Person res= personRepository.save(person);
        return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200,res);
    }

    @Override
    public RequestResultVO delete(String name) {
        personRepository.delete(Long.valueOf(1));
        return null;
    }

    @Override
    public RequestResultVO update(Person person) {
        return null;
    }

    @Override
    public RequestResultVO find(Long id) {
        Person person= personRepository.findOne(id);
        return ResultBuilder.buildSuccessResult(person);
    }


    @Override
    public RequestResultVO findByName(String name) {
        Person person = personRepository.findByName(name);
        return ResultBuilder.buildSuccessResult(person);
    }

    /**
     * 注册
     * */
    @Override
    public RequestResultVO addregister(Person loginPerson) {

        String name = loginPerson.getName();

        Person person = personRepository.findByName(name);
        //验证用户名是否已存在
        if (person != null) {
            System.out.println(person.getName() + " " + person.getId() + " " + person.getClassNumber());
            return ResultBuilder.buildFailResult("用户已经注册");
        } else {
            Person person1 = personRepository.save(loginPerson);
            return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200, person1);
        }

    }
    @Override
    public RequestResultVO addFriend(NameNode nameNode) {

        Person friend = personRepository.findByName(nameNode.getFriendname());
        Person me = personRepository.findByName(nameNode.getMyname());
        if (friend == null || me == null) {
            return ResultBuilder.buildFailResult("找不到此人");
        } else {
            me.friends.add(me);
            me.friends.add(friend);
            personRepository.save(me.friends);
            return ResultBuilder.buildSuccessResult("success");
        }
    }
}
