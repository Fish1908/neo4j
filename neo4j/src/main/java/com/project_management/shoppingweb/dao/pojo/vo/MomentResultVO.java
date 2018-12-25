package com.project_management.shoppingweb.dao.pojo.vo;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Moment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>Title: MessageResultVO</p>
 * <p>Description: </p>
 *
 * @author wgw
 * @version 1.0.0
 * @date 2018/12/25 10:31
 */
public class MomentResultVO implements java.io.Serializable, Comparable<MomentResultVO> {

    private String name = "";


    private Moment moment = null;

    public MomentResultVO() {
    }

    public MomentResultVO(String name, Moment moment) {

        this.name = name;
        this.moment = moment;
    }

    public Moment getMoment() {
        return moment;
    }

    public void setMoment(Moment moment) {
        this.moment = moment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(MomentResultVO momentResultVO) {
        if (this.getMoment().getDate()!=null && (momentResultVO.getMoment().getDate())!=null)
        return this.getMoment().getDate().compareTo(momentResultVO.getMoment().getDate());
        else if (this.getMoment().getDate()!=null) {
            return 1;
        }else return -1;
    }
}
