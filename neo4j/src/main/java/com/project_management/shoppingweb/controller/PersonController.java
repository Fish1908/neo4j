package com.project_management.shoppingweb.controller;

import com.project_management.shoppingweb.dao.pojo.nodeEntity.Person;
import com.project_management.shoppingweb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
     * @param name
     * @return
     */


    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Object delete(@RequestParam("name") String name){

        return personService.delete(name);
    }

    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Object find(@RequestParam("id") Long id){

        return personService.find(id);
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object update(@RequestBody Person person)
    {
        return  personService.update(person);
    }


}
