package com.project_management.shoppingweb.service;

import com.project_management.shoppingweb.dao.pojo.requestEntity.LikeNode;
import com.project_management.shoppingweb.dao.pojo.requestEntity.NameNode;
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
    public RequestResultVO findByName(String name);
    public RequestResultVO addregister(Person loginPerson);
    public String genCaptcha(String name);
    public boolean validCaptcha(String name, String actual);
    public RequestResultVO addfriend(NameNode nameNode);
    public RequestResultVO deleteFriend(NameNode nameNode);

    public Object viewFriendInformation(NameNode nameNode);

    //查找好友的好友
    public RequestResultVO findMoreFriends(LikeNode likeNode);
}
