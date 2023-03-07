package com.tourism.demo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tourism.demo.dao.UserRepository;
import com.tourism.demo.entity.User;
@Service
public class UserServiceImp implements UserService{

	@Autowired 
	UserRepository dao;
	
	public User findByname(String name) {
		// TODO Auto-generated method stub
		return dao.findByname(name) ;
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@Valid @RequestBody User  userData) {
		User user = dao.findByname( userData.getName());

		if (user.getPassword().equals( userData.getPassword())) {
			User senduser=new User();
			senduser.setUser_id(user.getUser_id());
			senduser.setName(user.getName());
			senduser.setGender(user.getGender());
			senduser.setEmail(user.getEmail());
			senduser.setPassword(user.getCity());	
			senduser.setPhoneNumber(user.getPhoneNumber());
			senduser.setDistrict(user.getDistrict());
			senduser.setZip(user.getZip());
			senduser.setState(user.getState());
			
			return ResponseEntity.ok(senduser);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}
	@Override
	public ResponseEntity<?> saveUser(User user) {
		User u=dao.findByname(user.getName());
		if(u!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		else {
			dao.save(user);
			return ResponseEntity.ok(user);
		}	}
	@Override
	public User getuserById(long User_id) {
		return dao.findById(User_id).orElse(null);
		//return dao.findById(User_id).orElseThrow(()->new exception.ResourceNotFoundException("user"));
	}


	@Override
	public User updateUser(User user, long User_id) {
		User existingUser=dao.findById(user.getUser_id()).orElse(null);
		  
				existingUser.setName(user.getName());
				existingUser.setGender(user.getGender());
				existingUser.setPhoneNumber(user.getPhoneNumber());
				existingUser.setEmail(user.getEmail());
				existingUser.setPassword(user.getPassword());
				existingUser.setCity(user.getCity());
				existingUser.setDistrict(user.getDistrict());
				existingUser.setZip(user.getZip());
				existingUser.setState(user.getState());
			
		
		return dao.save(existingUser);
	}

	@Override
	public void deleteUser(long User_id) {
		dao.findById(User_id).orElse(null);
		dao.deleteById(User_id);
		User existsID=dao.findById(User_id).orElse(null);
	
	
	}

	@Override
	public List<User> getAlluser() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public User saveuser(User user) {
		// TODO Auto-generated method stub
		return dao.save(user);
	}




	
	

}
