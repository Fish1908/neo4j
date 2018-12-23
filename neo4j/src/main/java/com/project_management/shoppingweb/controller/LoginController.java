package com.project_management.shoppingweb.controller;

import com.project_management.shoppingweb.constant.HttpResponseConstants.Public;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.service.LoginService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LoginController
 * @Description TODO
 * @Author xiaojian
 * @Date 2018/12/16 21:56
 * @Version 1.0
 */

@RestController
public class LoginController {
  @Autowired
  private LoginService loginService;
  @RequestMapping(value="/login",method = RequestMethod.POST)
  public Object login(@RequestBody Person person)
  {
   return loginService.login(person);
  }
  @RequestMapping(value="/logout",method = RequestMethod.POST)
  public Object logout()
  {

    return loginService.logout();
  }

}
