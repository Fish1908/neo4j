package com.project_management.shoppingweb.controller;


import com.project_management.shoppingweb.dao.pojo.nodeEntity.Message;
import com.project_management.shoppingweb.dao.pojo.requestEntity.LikeNode;
import com.project_management.shoppingweb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/message")

/**
 * MessageController类，用来控制点赞、查询点赞通知
 */
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 新增
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody Message message){
        return messageService.insert(message);
    }

    /**
     * 点赞
     */
    @RequestMapping(value = "/addLike", method = RequestMethod.POST)
    public Object addLike(@RequestBody LikeNode likeNode){
        return messageService.addLike(likeNode);
    }

    /**
     * 查看消息列表
     */
    @RequestMapping(value = "/getMessages", method = RequestMethod.POST)
    public Object getMessages(@RequestBody LikeNode likeNode){
        return messageService.getMessages(likeNode);
    }

    /**
     * 某人确认消息
     */
    @RequestMapping(value = "/confirmMessages", method = RequestMethod.POST)
    public Object confirmMessages(@RequestBody LikeNode likeNode){
        return messageService.confirmMessages(likeNode);
    }




}


