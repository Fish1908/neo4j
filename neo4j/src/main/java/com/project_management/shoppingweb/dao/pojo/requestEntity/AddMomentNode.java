package com.project_management.shoppingweb.dao.pojo.requestEntity;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Moment;

/**
 * <p>Title: addMomentNode</p>
 * <p>Description: </p>
 *
 * @author wgw
 * @version 1.0.0
 * @date 2018/12/14 15:58
 */
public class AddMomentNode {
    Moment moment;
    String name;

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
}
