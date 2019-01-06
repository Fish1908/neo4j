package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants.Public;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import com.project_management.shoppingweb.service.LoginService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import com.project_management.shoppingweb.util.MD5Util;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @ClassName LoginServiceImpl
 * @Description TODO
 * @Author xiaojian
 * @Date 2018/12/16 21:55
 * @Version 1.0
 */
@Service
public class LoginServiceImpl implements LoginService {
  @Autowired
  PersonRepository personRepository;

  //@Cacheable(cacheNames = "login")
  @Override
  public RequestResultVO login(Person person) {
    String LoginName = person.getName();
    String LoginPassword= MD5Util.encrypt(person.getPassword());
    Subject subject = SecurityUtils.getSubject();
    UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(LoginName,LoginPassword);

    try {
      subject.login(usernamePasswordToken);
    }catch (UnknownAccountException ue)
    {
      return ResultBuilder.buildFailResult(Public.ERROR_901);
    }catch (IncorrectCredentialsException ie)
    {
      return ResultBuilder.buildFailResult(Public.ERROR_902);

    }
    Long iconid =  personRepository.findByName(LoginName).getIconId();
    return ResultBuilder.buildSuccessResult(Public.SUCCESS_600,iconid);

  }

  @Override
  public RequestResultVO logout() {

    Subject subject = SecurityUtils.getSubject();
    subject.logout();
    return ResultBuilder.buildSuccessResult(Public.SUCCESS_700);
  }
}
