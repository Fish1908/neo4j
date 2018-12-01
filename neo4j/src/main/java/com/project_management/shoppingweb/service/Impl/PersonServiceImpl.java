package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.dao.nodeEntity.Person;
import com.project_management.shoppingweb.dao.vo.RequestResultVO;
import com.project_management.shoppingweb.repository.PersonRepository;
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
        personRepository.save(person);
        return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200);
    }
}
