package com.project_management.shoppingweb.pojo.nodeEntity;

import java.util.ArrayList;
import java.util.List;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @ClassName Moment
 * @Description TODO
 * @Author xiaojian
 * @Date 2018/12/11 19:44
 * @Version 1.0
 */
@NodeEntity(label = "moment")
public class Moment {

  @GraphId
  private Long momentId;
  private String pictureUrl;
  private String content;
  private List<String> likeList = new ArrayList<>();

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

  public List<String> getLikeList() {
    return likeList;
  }

  public void setLikeList(List<String> likeList) {
    this.likeList = likeList;
  }
}
