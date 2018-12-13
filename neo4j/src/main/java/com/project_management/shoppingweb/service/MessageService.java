package com.project_management.shoppingweb.service;

import com.project_management.shoppingweb.pojo.nodeEntity.Message;
import com.project_management.shoppingweb.pojo.vo.RequestResultVO;

public interface MessageService {

    public RequestResultVO insert(Message message);

}
