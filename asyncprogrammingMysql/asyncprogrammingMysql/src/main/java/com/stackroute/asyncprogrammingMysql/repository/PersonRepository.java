package com.stackroute.asyncprogrammingMysql.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.asyncprogrammingMysql.model.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long>{
}
