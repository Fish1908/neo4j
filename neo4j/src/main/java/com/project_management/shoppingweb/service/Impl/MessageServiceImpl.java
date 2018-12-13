package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Message;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.MessageRepository;
import com.project_management.shoppingweb.service.MessageService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    public RequestResultVO insert(Message message) {
        messageRepository.save(message);
        return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200);
    }
}
