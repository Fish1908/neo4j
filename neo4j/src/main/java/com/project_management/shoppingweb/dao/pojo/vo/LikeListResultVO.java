package com.project_management.shoppingweb.dao.pojo.vo;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Moment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Title: LikeListResultVO</p>
 * <p>Description: </p>
 *
 * @author wgw
 * @version 1.0.0
 * @date 2019/1/8 20:10
 */
public class LikeListResultVO {
    private Long momentId;
    private String pictureUrl;
    private String content;
    private String date;

    public List<Map<String, Object>> getLikeList() {
        return likeList;
    }

    public void setLikeList(List<Map<String, Object>> likeList) {
        this.likeList = likeList;
    }

    private List<Map<String,Object>> likeList;

    public Long getMomentId() {
        return momentId;
    }

    public void setMomentId(Long momentId) {
        this.momentId = momentId;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
