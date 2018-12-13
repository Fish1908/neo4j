package com.project_management.shoppingweb.controller;


import com.project_management.shoppingweb.pojo.nodeEntity.Message;
import com.project_management.shoppingweb.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private MessageService messageService;

    /**
     * 新增
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody Message message){
//        Map<String, ArrayList<String>> nameList = new HashMap<String, ArrayList<String>>();
//        ArrayList<String> namel = new ArrayList<String>();
//        namel.add("点赞人1");
//        namel.add("点赞人2");
//        nameList.put("小健", namel);
//        message.setNameList(nameList);

        return messageService.insert(message);
    }


}


