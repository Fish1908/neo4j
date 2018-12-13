package com.project_management.shoppingweb.controller;

import com.project_management.shoppingweb.pojo.nodeEntity.Moment;
import com.project_management.shoppingweb.service.MomentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MomentController
 * @Description TODO
 * @Author xiaojian
 * @Date 2018/12/11 19:54
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/moment")
public class MomentController {

  @Autowired
  private MomentService momentService;

  @RequestMapping(value = "/insert", method = RequestMethod.POST)
  public Object insert(@RequestBody Moment moment) {
    return momentService.insert(moment);
  }

  @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
  public Object delete(@RequestParam("momentId") Long momentId,
      @RequestParam("personName") String personName) {
    return momentService.delete(momentId, personName);
  }

  @RequestMapping(value = "/update", method = RequestMethod.POST)
  public Object update(@RequestBody Moment moment) {

    return momentService.update(moment);
  }

  @RequestMapping(value = "/find", method = RequestMethod.GET)
  public Object find(@RequestParam Long momentId) {
    return momentService.find(momentId);
  }

  @RequestMapping(value = "/findOne", method = RequestMethod.GET)
  public Object findOne(@RequestParam Long momentId) {
    return momentService.findOne(momentId);
  }
  @RequestMapping(value = "/findByMomentId", method = RequestMethod.GET)
  public Object findByName(@RequestParam Long momentId) {
    return momentService.findByMomentId(momentId);
  }

}
