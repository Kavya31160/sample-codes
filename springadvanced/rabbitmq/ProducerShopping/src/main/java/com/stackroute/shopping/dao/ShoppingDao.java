package com.stackroute.shopping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.shopping.model.Book;


@Repository
public interface ShoppingDao extends JpaRepository<Book,String> {

}
