package com.project_management.shoppingweb.dao.repository;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import java.util.List;
import java.util.Set;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends GraphRepository<Person>{
    @Query("match (p:person) where p.name={name} return p")
    Person findByName(@Param("name") String name);

    Person findTopByName(String name);

    @Query("match (p1:person{name:{0}})-[f:friends]->(p2:person) DELETE p1,f")
    void delete(String name);

    @Query("match (p:person{id:{0}) set p={name:{1},password:{2},sex:{3},classNumber:{4}}")
    Person update(Long id,String name,String password,String sex,String classNumber);

    //根据动态查人
    @Query("match (p: person)-[r:Viewpyq]->(m: moment) where id(m)={id} return p")
    Person findByMoment(@Param("id") Long id);

    //查询好友的好友
    @Query("MATCH (a:person )-[:friends]-(b:person)-[:friends]-(c:person) where id(a)={id} return c.name")
    List<String> findMoreFriends(@Param("id") Long id);

    //查询某人的好友
    @Query("MATCH (a:person )-[:friends]-(b:person) where id(a)={id} return b")
    List<Person> findFriends(@Param("id") Long id);

    @Query("MATCH (n:person) RETURN n")
    List<Person> findAllPeople();
}
