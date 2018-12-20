package com.project_management.shoppingweb.dao.pojo.requestEntity;

public class LikeNode {
    //点赞人
    private String name;
    //动态id
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
