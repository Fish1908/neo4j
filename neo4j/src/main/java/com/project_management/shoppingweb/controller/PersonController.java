package com.project_management.shoppingweb.controller;

import com.project_management.shoppingweb.constant.HttpResponseConstants.Public;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Moment;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.requestEntity.LikeNode;
import com.project_management.shoppingweb.dao.pojo.requestEntity.NameNode;
import com.project_management.shoppingweb.dao.pojo.requestEntity.RegisterNode;
import com.project_management.shoppingweb.dao.pojo.requestEntity.SendEmailNode;
import com.project_management.shoppingweb.service.MailService;
import com.project_management.shoppingweb.service.PersonService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

  @Autowired
  private PersonService personService;

  @Autowired
  private MailService mailService;

  /**
   *
   *
   * @param person
   * @return
   */
  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public Object insert(@RequestBody Person person) {
    return personService.insert(person);
  }

  /**
   *
   * @param
   * @return
   */


  @RequestMapping(value = "/delete", method = RequestMethod.POST)
  public Object delete(@RequestBody() Person person) {

    return personService.delete(person.getName());
  }

  @RequestMapping(value = "/find", method = RequestMethod.POST)
  public Object find(@RequestBody Person person) {

    return personService.find(person.getId());
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public Object update(@RequestBody Person person) {
    return personService.update(person);
  }

  @RequestMapping(value = "/addregister", method = RequestMethod.POST)
  public Object addregister(@RequestBody RegisterNode registerNode){


    boolean validation = personService.validCaptcha(registerNode.getName(),
                                                   registerNode.getCaptcha());
    if (!validation) {
      return ResultBuilder.buildFailResult(Public.ERROR_909);
    }

    Person loginPerson = new Person();
    loginPerson.setName(registerNode.getName());
    loginPerson.setSex(registerNode.getSex());
    loginPerson.setPassword(registerNode.getPassword());
    loginPerson.setClassNumber(registerNode.getClassNumber());
    return personService.addregister(loginPerson);
  }

  @RequestMapping(value = "/sendemail", method = RequestMethod.POST)
  public Object sendEmail(@RequestBody SendEmailNode sendEmailNode) {
    String code = personService.genCaptcha(sendEmailNode.getName());
    code = "Welcome to Moments! \nYour verification code is " + code;
    return mailService.sengSimpleMail(sendEmailNode.getEmail(), "注册验证码", code);

  }


  @RequestMapping(value = "/addfriend", method = RequestMethod.POST)
  public Object addfriend(@RequestBody NameNode nameNode) {
    return personService.addfriend(nameNode);
  }

  @RequestMapping(value = "/findbyname", method = RequestMethod.POST)
  public Object findbyname(@RequestBody Person person) {

    return personService.findByName(person.getName());
  }

  @RequestMapping(value = "/deleteFriend", method = RequestMethod.POST)
  public Object deleteFriend(@RequestBody NameNode nameNode) {
    return personService.deleteFriend(nameNode);
  }

  /**
   * 查看好友信息
   * @param nameNode
   * @return
   */
  @RequestMapping(value = "/viewFriendInformation", method = RequestMethod.POST)
  public Object viewFriendInformation(@RequestBody NameNode nameNode) {
    return personService.viewFriendInformation(nameNode);
  }




  /**
   * 推荐好友
   */
  @RequestMapping(value = "/recommend", method = RequestMethod.POST)
  public Object recommend(@RequestBody LikeNode likeNode) {
    return personService.findMoreFriends(likeNode);
  }

}
