package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.constant.HttpResponseConstants.Public;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.requestEntity.NameNode;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import com.project_management.shoppingweb.service.PersonService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import com.project_management.shoppingweb.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public RequestResultVO insert(Person person) {
        person.setPassword(MD5Util.encrypt(person.getPassword()));
        Person res = personRepository.save(person);
        return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200, res);
    }

    @Override
    public RequestResultVO delete(String name) {
        personRepository.delete(name);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400);
    }

    @Override
    public RequestResultVO update(Person person) {

        Person old = personRepository.findOne(person.getId());
        Long id = person.getId();
        String name = person.getName() != null ? person.getName() : old.getName();
        String password = person.getPassword() != null ? MD5Util.encrypt(person.getPassword()) :
                old.getPassword();
        String sex = person.getSex() != null ? person.getSex() : old.getSex();
        String classNumber =
                person.getClassNumber() != null ? person.getClassNumber() : old.getClassNumber();
        personRepository.update(id, name, password, sex, classNumber);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, person);
    }


    @Override
    public RequestResultVO find(Long id) {
        Person person = personRepository.findOne(id);
        return ResultBuilder.buildSuccessResult(person);
    }

    @Override
    public RequestResultVO findByName(String name) {
        try {
            Person person = personRepository.findByName(name);
            return ResultBuilder.buildSuccessResult(Public.SUCCESS, person);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return ResultBuilder.buildSuccessResult(Public.ERROR_100);
    }

    /**
     * 注册
     */
    @Override
    public RequestResultVO addregister(Person loginPerson) {

        String name = loginPerson.getName();

        Person person = personRepository.findByName(name);
        //验证用户名是否已存在
        if (person != null) {
            //System.out.println(person.getName() + " " + person.getId() + " " + person.getClassNumber());
            return ResultBuilder.buildFailResult("用户已经注册");
        } else {
            loginPerson.setPassword(MD5Util.encrypt(loginPerson.getPassword()));
            Person person1 = personRepository.save(loginPerson);
            return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200, person1);
        }

    }

    @Override
    public RequestResultVO addfriend(NameNode nameNode) {
        Person me = personRepository.findByName(nameNode.getMyname());
        Person myFriend = personRepository.findByName(nameNode.getFriendname());
        if (me == null || myFriend == null) {
            return ResultBuilder.buildFailResult("找不到此人");
        } else {
            me.friends.add(myFriend);
            personRepository.save(me);
            return ResultBuilder.buildSuccessResult("success");
        }
    }

    @Override
    public RequestResultVO deleteFriend(NameNode nameNode) {
        Person me = personRepository.findByName(nameNode.getMyname());
        Person friend = personRepository.findByName(nameNode.getFriendname());
        for (Person myfriend : me.friends) {
            if (myfriend.equals(friend)) {
                me.friends.remove(myfriend);
                personRepository.save(me);
                return ResultBuilder.buildSuccessResult("删除好友成功");
            }
        }
        return ResultBuilder.buildFailResult("你们不是好友");
    }


}
