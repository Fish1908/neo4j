package com.project_management.shoppingweb.controller;

import com.project_management.shoppingweb.dao.pojo.requestEntity.LikeNode;
import com.project_management.shoppingweb.dao.pojo.requestEntity.NameNode;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    /**
     *
     *
     * @param person
     * @return
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object insert(@RequestBody Person person){
        return personService.insert(person);
    }

    /**
     *
     * @param
     * @return
     */


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Object delete(@RequestBody() Person person){

        return personService.delete(person.getName());
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public Object find(@RequestBody Person person){

        return personService.find(person.getId());
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object update(@RequestBody Person person)
    {
        return  personService.update(person);
    }

    @RequestMapping(value = "/addregister", method = RequestMethod.POST)
    public Object addregister(@RequestBody Person loginPerson) {
        return personService.addregister(loginPerson);
    }

    @RequestMapping(value = "/addfriend",method = RequestMethod.POST)
    public Object addfriend(@RequestBody NameNode nameNode){
        return personService.addfriend(nameNode);
    }

    @RequestMapping(value = "/findbyname", method = RequestMethod.POST)
    public Object findbyname(@RequestBody Person person){

        return personService.findByName(person.getName());
    }

    @RequestMapping(value = "/deleteFriend",method = RequestMethod.DELETE)
    public Object deleteFriend(@RequestBody NameNode nameNode){
        return personService.deleteFriend(nameNode);
    }

    @RequestMapping(value = "viewFriendInformation",method = RequestMethod.GET)
    public Object viewFriendInformation(@RequestBody NameNode nameNode) {
        return personService.viewFriendInformation(nameNode);
    }

    /**
     * 推荐好友
     */
    @RequestMapping(value = "/recommend",method = RequestMethod.POST)
    public Object recommend(@RequestBody LikeNode likeNode){
        return personService.findMoreFriends(likeNode);
    }

}
