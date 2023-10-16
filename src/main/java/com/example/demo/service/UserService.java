package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.UserRequest;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service
public class UserService implements UserServiceInter {

	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public User saveUser(UserRequest userRequest) {
//		User user =new User(0,userRequest.getName(),userRequest.getEmail(),userRequest.getMobile(),userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());
		
		User user =User.build(userRequest.getName(),userRequest.getEmail(),userRequest.getMobile(),userRequest.getGender(),userRequest.getAge(),userRequest.getNationality());
		return userRepo.save(user);
	}
	
	@Override
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	@Override
	public User getUser(int userid) throws UserNotFoundException {
		User user= userRepo.findByuserid(userid);
		if(user!=null) {
			return user;
		}
		else {
			throw new UserNotFoundException("User not with id:"+userid);
		}
	}
}
