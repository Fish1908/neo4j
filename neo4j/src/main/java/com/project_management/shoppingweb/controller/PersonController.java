package com.project_management.shoppingweb.controller;

import com.project_management.shoppingweb.constant.HttpResponseConstants;
import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.dao.pojo.vo.RequestResultVO;
import com.project_management.shoppingweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
    @Autowired
    private PersonService personService;
    private Person localPerson;

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
     * @param name
     * @return
     */


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Object delete(@RequestParam("name") String name){

        return personService.delete(name);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
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

    @RequestMapping(value = "/addfriend",method = RequestMethod.GET)
    public Object addFriend(@RequestParam("myname") String myname, @RequestParam("friendname") String friendname) {
        return personService.addFriend(myname,friendname);
    }
}
