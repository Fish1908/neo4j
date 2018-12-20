package com.project_management.shoppingweb.dao.pojo.nodeEntity;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity(label = "person")
public class Person {

  @GraphId
  private Long id;
  private String name;
  private String password;
  private String sex;
  private String classNumber;

  @Relationship(type = "friends",direction = Relationship.UNDIRECTED)
  public Set<Person> friends = new HashSet<Person>();

  @Relationship(type = "Viewpyq" , direction = Relationship.OUTGOING)
  public Set<Moment> moments = new HashSet<Moment>();

  @Relationship(type = "check" , direction = Relationship.OUTGOING)
  public Set<Message> messages = new HashSet<Message>();

  public Person() {
    // Empty constructor required as of Neo4j API 2.0.5
  };


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getClassNumber() {
    return classNumber;
  }

  public void setClassNumber(String classNumber) {
    this.classNumber = classNumber;
  }

  public Set<Person> getFriends() {
    return friends;
  }

  public void setFriends(Set<Person> friends) {
    this.friends = friends;
  }

  public Set<Moment> getMoments() {
    return moments;
  }

  public void setMoments(Set<Moment> moments) {
    this.moments = moments;
  }

  public Set<Message> getMessages() {
    return messages;
  }

  public void setMessages(Set<Message> messages) {
    this.messages = messages;
  }

  @Override
  public String toString() {
    return "Person{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        ", sex='" + sex + '\'' +
        ", classNumber='" + classNumber + '\'' +
        '}';
  }


}
