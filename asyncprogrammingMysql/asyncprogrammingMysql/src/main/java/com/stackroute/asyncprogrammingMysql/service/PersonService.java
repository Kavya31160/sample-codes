package com.stackroute.asyncprogrammingMysql.service;


import com.stackroute.asyncprogrammingMysql.model.Person;
import com.stackroute.asyncprogrammingMysql.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class PersonService  {



    private PersonRepository personRepository;



    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    
    
    
    @Async
    public CompletableFuture<Person> savePersonAsync(String name, int age) {
        // Simulate a time-consuming task
        try {
            Thread.sleep(5000); // 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Person person = new Person();
        person.setName(name);
        person.setAge(age);

        Person savedPerson = personRepository.save(person);

        return CompletableFuture.completedFuture(savedPerson);
    }

    @Async
    public CompletableFuture<List<Person>> findAllUsersAsync() {
        return CompletableFuture.completedFuture(personRepository.findAll());
    }
}
