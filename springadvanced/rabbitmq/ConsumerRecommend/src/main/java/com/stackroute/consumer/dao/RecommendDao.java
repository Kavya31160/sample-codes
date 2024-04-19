package com.stackroute.consumer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.consumer.model.Recommend;


@Repository
public interface RecommendDao extends JpaRepository<Recommend,String>{

	List<Recommend> findByBookname(String bookname);
}
