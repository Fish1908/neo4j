package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.constant.HttpResponseConstants.Public;
import com.project_management.shoppingweb.pojo.nodeEntity.Moment;
import com.project_management.shoppingweb.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.repository.MomentRepository;
import com.project_management.shoppingweb.service.MomentService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @ClassName MomentServiceImpl
 * @Description TODO
 * @Author xiaojian
 * @Date 2018/12/11 19:59
 * @Version 1.0
 */
@Service
public class MomentServiceImpl implements MomentService {
@Autowired
 private MomentRepository momentRepository;
  @Override
  public RequestResultVO insert(Moment moment) {
    Moment res= momentRepository.save(moment);
    return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200,res);


  }

  @Override
  public RequestResultVO delete(Long id,String personName) {

    momentRepository.delete(personName,id);
    return ResultBuilder.buildSuccessResult(Public.SUCCESS_400);
  }

  @Override
  public RequestResultVO update(Moment moment) {
    return null;
  }

  @Override
  public RequestResultVO find(Long momentId) {
    Moment moment= momentRepository.findByMomentId(momentId);
    return ResultBuilder.buildSuccessResult(moment);

  }

  public RequestResultVO findOne(Long momentId) {
    Moment moment= momentRepository.findOne(momentId);
    return ResultBuilder.buildSuccessResult(moment);

  }

  @Override
  public RequestResultVO findByMomentId(Long momentId) {
    Moment moment= momentRepository.findByMomentId(momentId);
    return ResultBuilder.buildSuccessResult(moment);
  }


}
