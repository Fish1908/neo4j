package com.project_management.shoppingweb.dao.pojo.nodeEntity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import java.util.ArrayList;
import java.util.Map;

@NodeEntity(label = "message")
public class Message {

    @GraphId
    private Long id;
    private String msgName;
    // name of person

    private Map<String, ArrayList<String>> nameList;
    // <momentId, <name1 and time1, name2 and time2>>


    public String getMsgName() {
        return msgName;
    }

    public void setMsgName(String msgName) {
        this.msgName = msgName;
    }

}
