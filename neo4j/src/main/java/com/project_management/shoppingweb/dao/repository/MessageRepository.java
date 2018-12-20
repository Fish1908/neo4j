package com.project_management.shoppingweb.dao.repository;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Message;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface MessageRepository extends GraphRepository<Message> {
    //根据人查询其下面所有通知
    @Query("match (p: person)-[r:check]->(m: message) where id(p)={id} return m")
    Set<Message> findByPerson(@Param("id") Long id);

    //根据动态id查找通知
    @Query("match (m: message) where m.momentId={id} return m")
    Message findByMoment(@Param("id") Long id);
}
