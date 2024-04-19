package com.stackroute.oauthdemo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    @GetMapping("/demo")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hai Successfully logged in using git account. Welcome to OAuth Demo");




    }
}

	
 