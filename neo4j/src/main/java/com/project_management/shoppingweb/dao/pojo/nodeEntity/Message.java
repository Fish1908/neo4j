package com.project_management.shoppingweb.dao.pojo.nodeEntity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NodeEntity(label = "message")
public class Message {

    @GraphId
    private Long id;
    private Long momentId;
    // name of person

    private List<String> nameList = new ArrayList<String>();
    // <momentId, <name1 and time1, name2 and time2>>

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMomentId() {
        return momentId;
    }

    public void setMomentId(Long momentId) {
        this.momentId = momentId;
    }

    public List<String> getNameList() {
        return nameList;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }
}
