package com.project_management.shoppingweb.service.Impl;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.constant.HttpResponseConstants.Public;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Moment;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.requestEntity.AddMomentNode;
import com.project_management.shoppingweb.dao.pojo.requestEntity.DeleteMomentNode;
import com.project_management.shoppingweb.dao.pojo.requestEntity.ViewAllMomentsNode;
import com.project_management.shoppingweb.dao.pojo.vo.MomentResultVO;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.dao.repository.MomentRepository;
import com.project_management.shoppingweb.dao.repository.PersonRepository;
import com.project_management.shoppingweb.service.MomentService;
import com.project_management.shoppingweb.service.common.ResultBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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

    @Autowired
    private PersonRepository personRepository;

    @Override
    public RequestResultVO insert(Moment moment) {
        Moment res = momentRepository.save(moment);
        return ResultBuilder.buildSuccessResult(HttpResponseConstants.Public.SUCCESS_200, res);


    }

    @Override
    public RequestResultVO delete(Long id, String personName) {

        momentRepository.delete(personName, id);
        return ResultBuilder.buildSuccessResult(Public.SUCCESS_400);
    }

    @Override
    public RequestResultVO update(Moment moment) {
        return null;
    }

    @Override
    public RequestResultVO find(Long momentId) {
        Moment moment = momentRepository.findOne(momentId);
        return ResultBuilder.buildSuccessResult(moment);

    }

    public RequestResultVO findOne(Long momentId) {
        Moment moment = momentRepository.findOne(momentId);
        return ResultBuilder.buildSuccessResult(moment);

    }

    @Override
    public RequestResultVO findByMomentId(Long momentId) {
        Moment moment = momentRepository.findByMomentId(momentId);
        return ResultBuilder.buildSuccessResult(moment);
    }

    @Override
    public RequestResultVO addMoment(AddMomentNode addMomentNode) {
        Date current = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = simpleDateFormat.format(current);
        addMomentNode.getMoment().setDate(dateString);
        Moment moment = momentRepository.save(addMomentNode.getMoment());
        Person person = personRepository.findByName(addMomentNode.getName());
        person.moments.add(moment);
        personRepository.save(person);
        return ResultBuilder.buildSuccessResult(moment);
    }

    @Override
    public RequestResultVO viewAllMoments(ViewAllMomentsNode viewAllMomentsNode) {
        Person me = personRepository.findTopByName(viewAllMomentsNode.getMyName());
        ArrayList<MomentResultVO> momentResultVOS = new ArrayList<MomentResultVO>();
        for (Person friend :
                me.friends) {
            Person person = personRepository.findTopByName(friend.getName());
            for (Moment moment :
                    person.moments) {
                MomentResultVO momentResultVO = new MomentResultVO();
                momentResultVO.setName(person.getName());
                Moment tempMoment = new Moment();
                tempMoment = moment;
                momentResultVO.setMoment(tempMoment);
                momentResultVOS.add(momentResultVO);
            }

        }
        Collections.sort(momentResultVOS);
        return ResultBuilder.buildSuccessResult(momentResultVOS);
    }

    @Override
    public RequestResultVO viewAllRepositoryMoments() {
        List<Person> allPeople = personRepository.findAllPeople();
        ArrayList<MomentResultVO> momentResultVOS = new ArrayList<>();
        for (Person person :
                allPeople) {
            Person tempPerson = personRepository.findTopByName(person.getName());
            for (Moment moment :
                    person.moments) {
                MomentResultVO momentResultVO = new MomentResultVO();
                momentResultVO.setName(tempPerson.getName());
                Moment tempMoment = new Moment();
                tempMoment = moment;
                momentResultVO.setMoment(tempMoment);
                momentResultVOS.add(momentResultVO);
            }
        }
        Collections.sort(momentResultVOS);
        return ResultBuilder.buildSuccessResult(momentResultVOS);
    }

}
