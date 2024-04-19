package com.stackroute.authorizeapp.service;

import com.stackroute.authorizeapp.model.UserInfo;

public interface UserService {

			UserInfo registerUser(UserInfo user);
			
			boolean login(String email,String password);
}
