package com.project_management.shoppingweb.service;


import com.project_management.shoppingweb.pojo.nodeEntity.Moment;
import com.project_management.shoppingweb.pojo.vo.RequestResultVO;
import org.springframework.stereotype.Service;

public interface MomentService {
  public RequestResultVO insert(Moment moment);
  public RequestResultVO delete(Long momentId,String personName);
  public RequestResultVO update(Moment moment);
  public RequestResultVO find(Long momentId);
  public RequestResultVO findOne(Long momentId);
  public RequestResultVO findByMomentId(Long momentId);


}
