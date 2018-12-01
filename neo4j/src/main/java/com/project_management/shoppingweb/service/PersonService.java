package com.project_management.shoppingweb.service;

import com.project_management.shoppingweb.dao.nodeEntity.Person;
import com.project_management.shoppingweb.dao.vo.RequestResultVO;

public interface PersonService {
    /**
     * 新增
     * @param
     * @return
     */
    public RequestResultVO insert(Person person);
}
