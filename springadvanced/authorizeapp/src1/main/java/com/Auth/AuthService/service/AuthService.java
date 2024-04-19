package com.Auth.AuthService.service;

import com.Auth.AuthService.entity.Auth;

public interface AuthService {
	Auth register(Auth auth);
	boolean login(String username,String password);

}
