package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.constant.HttpResponseConstants.Public;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.requestEntity.LikeNode;
import com.project_management.shoppingweb.dao.pojo.requestEntity.NameNode;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import com.project_management.shoppingweb.service.PersonService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import com.project_management.shoppingweb.util.MD5Util;
import java.text.DecimalFormat;
import org.apache.commons.lang3.RandomUtils;
import org.apache.http.client.methods.RequestBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonRepository personRepository;
  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Override
  public RequestResultVO insert(Person person) {
    person.setPassword(MD5Util.encrypt(person.getPassword()));
    Person res = personRepository.save(person);
    return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200, res);
  }

  @Override
  public RequestResultVO delete(String name) {
    personRepository.delete(name);
    return ResultBuilder.buildSuccessResult(Public.SUCCESS_400);
  }

  @Override
  public RequestResultVO update(Person person) {

    Person old = personRepository.findOne(person.getId());
    Long id = person.getId();
    String name = person.getName() != null ? person.getName() : old.getName();
    String password = person.getPassword() != null ? MD5Util.encrypt(person.getPassword()) :
        old.getPassword();
    String sex = person.getSex() != null ? person.getSex() : old.getSex();
    String classNumber =
        person.getClassNumber() != null ? person.getClassNumber() : old.getClassNumber();
    Long iconId = person.getIconId()!=null ?person.getIconId():old.getIconId();
    personRepository.update(id, name, password, sex, classNumber,iconId);
    return ResultBuilder.buildSuccessResult(Public.SUCCESS_300, person);
  }


  @Override
  public RequestResultVO find(Long id) {
    Person person = personRepository.findOne(id);
    return ResultBuilder.buildSuccessResult(person);
  }

  @Override
  public RequestResultVO findByName(String name) {
    try {
      Person person = personRepository.findByName(name);
      return ResultBuilder.buildSuccessResult(Public.SUCCESS, person);
    } catch (ClassCastException e) {
      e.printStackTrace();
    }
    return ResultBuilder.buildSuccessResult(Public.ERROR_100);
  }

  /**
   * 注册
   */
  @Override
  public RequestResultVO addregister(Person loginPerson) {

    String name = loginPerson.getName();

    Person person = personRepository.findByName(name);
    //验证用户名是否已存在
    if (person != null) {
      //System.out.println(person.getName() + " " + person.getId() + " " + person.getClassNumber());
      return ResultBuilder.buildFailResult("用户已经注册");
    } else {
      loginPerson.setPassword(MD5Util.encrypt(loginPerson.getPassword()));
      Person person1 = personRepository.save(loginPerson);
      return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200, person1);
    }

  }

  @Override
  @Cacheable(value = "captcha")
  public String genCaptcha(String name) {
    System.out.println("未使用redis!");
    String code = new DecimalFormat("0000").format(RandomUtils.nextInt(0,9999));
    return code;
  }

  public boolean validCaptcha(String name, String actual)
  {
    String expect = stringRedisTemplate.opsForValue().get(name);

    if(expect!=null&&expect.equals(actual)){
      return true;
    }
    return false;
  }


  @Override
  public RequestResultVO addfriend(NameNode nameNode) {
    Person me = personRepository.findByName(nameNode.getMyname());
    Person myFriend = personRepository.findByName(nameNode.getFriendname());
    if (me == null || myFriend == null) {
      return ResultBuilder.buildFailResult("找不到此人");
    } else {
      me.friends.add(myFriend);
      personRepository.save(me);
      return ResultBuilder.buildSuccessResult("success");
    }
  }

    @Override
    public RequestResultVO deleteFriend(NameNode nameNode) {
        Person me = personRepository.findByName(nameNode.getMyname());
        Person friend = personRepository.findByName(nameNode.getFriendname());
        for (Person myfriend : me.friends) {
            if (myfriend.equals(friend)) {
                me.friends.remove(myfriend);
                personRepository.save(me);
                return ResultBuilder.buildSuccessResult("删除好友成功");
            }
        }
        return ResultBuilder.buildFailResult("你们不是好友");
    }

    @Override
    public Object viewFriendInformation(NameNode nameNode) {
        Person me = personRepository.findTopByName(nameNode.getMyname());
        Person friend = personRepository.findTopByName(nameNode.getFriendname());
        for(Person myfriend : me.friends)
            if (myfriend.equals(friend)) {
                Person information = new Person();
                information.setName(friend.getName());
                information.setSex(friend.getSex());
                information.setClassNumber(friend.getClassNumber());
                Set<Person> tempFriends = new HashSet<>();
                for (String friendName:
                        personRepository.findMoreFriends(friend.getId())) {
                    Person tempFriend = new Person();
                    tempFriend.setName(friendName);
                    tempFriends.add(tempFriend);
                }
                information.setFriends(tempFriends);
                information.setIconId(friend.getIconId());
                information.moments = friend.moments;
                return information;
            }
        return ResultBuilder.buildFailResult("你们不是好友");
    }

    @Override
    public RequestResultVO findMoreFriends(LikeNode likeNode) {
        Person person = personRepository.findByName(likeNode.getName());
        if(person == null) {
            return ResultBuilder.buildFailResult(HttpResponseConstants.Public.ERROR_904
                    + " name:" + likeNode.getName());
        }
        //好友的好友
        List<String> moreFriends = personRepository.findMoreFriends(person.getId());
        //好友
        List<Person> friends = personRepository.findFriends(person.getId());

        //统计推荐好友的出现次数，去除他本人的好友
        //存储本人好友的set
        Set<String> friendsSet = new HashSet<String>();
        for(Person p : friends) {
            friendsSet.add(p.getName());
        }
        //统计推荐好友的姓名和次数
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String s : moreFriends) {
            if(!friendsSet.contains(s)) {
                int count = map.getOrDefault(s, 0);
                map.put(s, count+1);
            }
        }

        //规范输出格式
        List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Map<String, Object> temp = new HashMap<String, Object>();
            temp.put("name", entry.getKey());
            temp.put("count", entry.getValue());
            temp.put("iconId",personRepository.findByName(entry.getKey()).getIconId());
            result.add(temp);
        }

        return ResultBuilder.buildSuccessResult(result);
    }


}
