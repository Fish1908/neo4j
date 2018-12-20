package com.project_management.shoppingweb.service;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Message;
import com.project_management.shoppingweb.dao.pojo.requestEntity.LikeNode;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;

public interface MessageService {

    RequestResultVO insert(Message message);

    //点赞
    RequestResultVO addLike(LikeNode likeNode);

    //根据姓名查找其通知
    RequestResultVO getMessages(LikeNode likeNode);

    //某人确认收到通知
    RequestResultVO confirmMessages(LikeNode likeNode);
}
