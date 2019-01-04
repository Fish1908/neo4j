package com.project_management.shoppingweb.dao.repository;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.LikeTime;
import com.project_management.shoppingweb.dao.pojo.requestEntity.LikeNode;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface LikeTimeRepository extends GraphRepository<LikeTime> {
    //根据点赞人和被点赞消息id获取点赞时间
    @Query("match (l: likeTime) where l.name={name} and l.momentId={momentId} return l")
    LikeTime findByMoment(@Param("name") String name, @Param("momentId") Long momentId);
}
