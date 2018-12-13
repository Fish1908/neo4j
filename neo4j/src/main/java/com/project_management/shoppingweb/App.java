package com.project_management.shoppingweb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Servlet;
import javax.swing.Action;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;


@SpringBootApplication
@EnableNeo4jRepositories("com.project_management.shoppingweb.repository")

public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }

//  List<String> l = Arrays.asList("a","b","c");
//  List<String>l2=new ArrayList<String>(3){"a","b","c"};



}

