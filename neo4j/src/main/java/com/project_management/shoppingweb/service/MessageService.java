package com.project_management.shoppingweb.service;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Message;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;

public interface MessageService {

    RequestResultVO insert(Message message);

}
