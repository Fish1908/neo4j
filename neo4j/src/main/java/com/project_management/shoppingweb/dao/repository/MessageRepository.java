package com.project_management.shoppingweb.dao.repository;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Message;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface MessageRepository extends GraphRepository<Message> {
}
