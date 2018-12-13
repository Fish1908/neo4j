package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import com.project_management.shoppingweb.service.PersonService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
