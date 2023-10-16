package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserRequest;
import com.example.demo.model.User;

public interface UserServiceInter {

	User saveUser(UserRequest userRequest);
	
	List<User> getAllUsers();
	
	User getUser(int userid);
}
