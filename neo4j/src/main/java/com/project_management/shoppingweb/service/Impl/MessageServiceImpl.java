package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Message;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Moment;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.requestEntity.LikeNode;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.MessageRepository;
import com.project_management.shoppingweb.dao.repository.MomentRepository;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import com.project_management.shoppingweb.service.MessageService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private MomentRepository momentRepository;

    @Override
    public RequestResultVO insert(Message message) {
        messageRepository.save(message);
        return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200);
    }

    @Override
    @Transactional
    /**
     * 点赞
     */
    public RequestResultVO addLike(LikeNode likeNode) {
        //参数校验:人不存在、动态不存在
        Person person = personRepository.findByName(likeNode.getName());
        if(person == null) {
            return ResultBuilder.buildFailResult(HttpResponseConstants.Public.ERROR_901
                    + " name:" + likeNode.getName());
        }
        Moment moment = momentRepository.findOne(likeNode.getId());
        if(moment == null) {
            return ResultBuilder.buildFailResult(HttpResponseConstants.Public.ERROR_902
                    + " momentId:" + likeNode.getId());
        }

        Person likedPerson = personRepository.findByMoment(moment.getMomentId());

        //如果已经点赞，则取消点赞
        if(moment.getLikeList().contains(person.getName())) {
            moment.getLikeList().remove(person.getName());
            momentRepository.save(moment);

            //同时取消相应的通知消息
            Set<Message> messages = messageRepository.findByPerson(likedPerson.getId());
            for(Message message : messages) {
                //该通知只有这一个人，则删除通知；否则移除名字
                if(message.getMomentId().equals(likeNode.getId()) && message.getNameList().contains(person.getName())) {
                    message.getNameList().remove(person.getName());
                    if(message.getNameList().size() == 0) {
                        messageRepository.delete(message);
                    } else {
                        messageRepository.save(message);
                    }
                    break;
                }
            }
            return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_501);
        }

        //动态点赞列表添加姓名
        moment.getLikeList().add(person.getName());
        momentRepository.save(moment);

        //在此人通知列表添加此条点赞信息
        //根据动态id找到发动态人，判断是否已有该动态对应的通知，有则直接在通知中加入name，没有则先创建
//        Person likedPerson = personRepository.findByMoment(moment.getMomentId());
        Message message = messageRepository.findByMoment(moment.getMomentId());
        if(message == null) {
            message = new Message();
            message.setMomentId(moment.getMomentId());
            message.getNameList().add(person.getName());
            likedPerson.getMessages().add(message);
            personRepository.save(likedPerson);
        } else{
            if(!message.getNameList().contains(person.getName())) {
                message.getNameList().add(person.getName());
                messageRepository.save(message);
            }
        }

        return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_500);
    }

    /**
     * 查看某人对应的所有通知消息
     */
    @Override
    public RequestResultVO getMessages(LikeNode likeNode) {
        Person person = personRepository.findByName(likeNode.getName());
        if(person == null) {
            return ResultBuilder.buildFailResult(HttpResponseConstants.Public.ERROR_904
                    + " name:" + likeNode.getName());
        }
        Set<Message> messages = messageRepository.findByPerson(person.getId());
//        Map<Long, List<String>> map = new HashMap<Long, List<String>>();
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(Message message : messages) {
            Map<String,Object> map = new HashMap<>();
            map.put("momentId",message.getMomentId());
            map.put("nameList",message.getNameList());
            list.add(map);
        }
        return ResultBuilder.buildSuccessResult(list);
    }

    @Override
    public RequestResultVO confirmMessages(LikeNode likeNode) {
        Person person = personRepository.findByName(likeNode.getName());
        if(person == null) {
            return ResultBuilder.buildFailResult(HttpResponseConstants.Public.ERROR_904
                    + " name:" + likeNode.getName());
        }
        Set<Message> messages = messageRepository.findByPerson(person.getId());
        messageRepository.delete(messages);
        return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_400);
    }
}
