package com.project_management.shoppingweb.repository;

import com.project_management.shoppingweb.dao.nodeEntity.Person;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;

public interface PersonRepository extends GraphRepository<Person>{
    Person findByName(@Param("name") String name);
}
