package com.project_management.shoppingweb.service;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.NameNode;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;

public interface PersonService {
    /**
     * 新增
     * @param
     * @return
     */
    public RequestResultVO insert(Person person);
    public RequestResultVO delete(String name);
    public RequestResultVO update(Person person);
    public RequestResultVO find(Long id);
    public Object findByName(String name);
    public Object addregister(Person loginPerson);

//    public RequestResultVO findByName(String name);
    public RequestResultVO addFriend(NameNode nameNode);

}
