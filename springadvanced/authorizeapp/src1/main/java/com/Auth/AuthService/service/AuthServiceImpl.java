package com.Auth.AuthService.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.Auth.AuthService.entity.Auth;

public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private AuthService authservice;

	@Override
	public Auth register(Auth auth) {
		
		return null;
	}

	@Override
	public boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return false;
	}

}
