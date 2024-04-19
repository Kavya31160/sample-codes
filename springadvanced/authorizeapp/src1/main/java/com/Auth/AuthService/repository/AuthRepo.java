package com.Auth.AuthService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Auth.AuthService.entity.Auth;
@Repository
public interface AuthRepo extends JpaRepository<Auth,String> {

}
