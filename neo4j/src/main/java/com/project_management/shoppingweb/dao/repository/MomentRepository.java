package com.project_management.shoppingweb.dao.repository;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Moment;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface MomentRepository extends GraphRepository <Moment>{

  @Query("MATCH ((p:person)-[v:Viewpyq]->(m:moment)) where id(m)={1} and p.name={0} DELETE v,m")
  void delete(String personName, Long id);
//  @Query("MATCH (m:moment) where id(m)={0} return m")
  Moment findByMomentId(Long momentId);


}
