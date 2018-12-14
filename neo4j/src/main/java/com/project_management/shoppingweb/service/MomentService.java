package com.project_management.shoppingweb.service;


import com.project_management.shoppingweb.dao.pojo.nodeEntity.Moment;
import com.project_management.shoppingweb.dao.pojo.requestEntity.AddMomentNode;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;

public interface MomentService {
  public RequestResultVO insert(Moment moment);
  public RequestResultVO delete(Long momentId,String personName);
  public RequestResultVO update(Moment moment);
  public RequestResultVO find(Long momentId);
  public RequestResultVO findOne(Long momentId);
  public RequestResultVO findByMomentId(Long momentId);

  public Object addMoment(AddMomentNode addMomentNode);

}
