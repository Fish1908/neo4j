package com.project_management.shoppingweb.service;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;

public interface LoginService {

   RequestResultVO login(Person person);
   RequestResultVO logout(Person person);
}
