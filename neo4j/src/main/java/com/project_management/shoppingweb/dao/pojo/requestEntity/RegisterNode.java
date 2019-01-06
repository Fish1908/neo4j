package com.project_management.shoppingweb.dao.pojo.requestEntity;

/**
 * @ClassName RegisterNode
 * @Description TODO
 * @Author xiaojian
 * @Date 2018/12/23 21:43
 * @Version 1.0
 */
public class RegisterNode {
  private String name;
  private String password;
  private String sex;
  private String classNumber;
  private String captcha;
  private String iconid;

  public String getIconid() {
    return iconid;
  }

  public void setIconid(String iconid) {
    this.iconid = iconid;
  }

  public String getCaptcha() {
    return captcha;
  }

  public void setCaptcha(String captcha) {
    this.captcha = captcha;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getClassNumber() {
    return classNumber;
  }

  public void setClassNumber(String classNumber) {
    this.classNumber = classNumber;
  }

}
