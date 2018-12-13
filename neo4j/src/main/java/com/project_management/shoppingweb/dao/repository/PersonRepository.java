package com.project_management.shoppingweb.dao.repository;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends GraphRepository<Person>{

    Person findByName(String name);

    @Query("MATCH (user:User{id:{0}})-[has:HAS]->(socialUser:SocialUser) DELETE user, has, socialUser")
    void delete(String id);



}
