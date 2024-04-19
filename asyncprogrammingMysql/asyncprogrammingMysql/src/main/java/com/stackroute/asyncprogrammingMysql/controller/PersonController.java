package com.stackroute.asyncprogrammingMysql.controller;

import com.stackroute.asyncprogrammingMysql.model.Person;
import com.stackroute.asyncprogrammingMysql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;


@RestController
@RequestMapping("/person")
public class PersonController {



    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/viewuserasync")
    public CompletableFuture<List<Person>> getAllUsersAsync() {
        return personService.findAllUsersAsync();
    }

    @GetMapping("/savePersonAsync/{name}/{age}")
    public CompletableFuture<Person> savePersonAsync(
            @PathVariable String name,
            @PathVariable int age) {
        return personService.savePersonAsync(name, age);
    }
}