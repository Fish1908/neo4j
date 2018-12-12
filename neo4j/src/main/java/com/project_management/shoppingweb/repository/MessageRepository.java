package com.project_management.shoppingweb.repository;

import com.project_management.shoppingweb.pojo.nodeEntity.Message;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface MessageRepository extends GraphRepository<Message> {
}
