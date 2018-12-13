package com.project_management.shoppingweb.repository;

import com.project_management.shoppingweb.pojo.nodeEntity.Moment;
import java.util.List;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

public interface MomentRepository extends GraphRepository <Moment>{

  @Query("MATCH ((p:person)-[v:viewpyq]->(m:moment)) where id(m)={1} and p.name={0} DELETE v,m")
  void delete(String personName, Long id);
//  @Query("MATCH (m:moment) where id(m)={0} return m")
  Moment findByMomentId(Long momentId);



}
