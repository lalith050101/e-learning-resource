package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.model.UserModel;
import com.example.application.repository.UserModelRepository;

@RestController
public class SignupController {

	@Autowired
	private UserModelRepository userModelRepository;
	
	@PostMapping("/signup")
	public ResponseEntity<?> saveUser(@RequestBody UserModel userModel) {
		
		try {
		if(userModelRepository.findById(userModel.getEmail()).orElse(null) == null) {
			userModelRepository.save(userModel);
			return new ResponseEntity<String> ("true", HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<String> ("false", HttpStatus.CONFLICT);
		}
		}
		catch(Exception e) {
			return new ResponseEntity<String> ("false", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

	@PostMapping("/")
	public ResponseEntity<String> saveUser() {
		
		return new ResponseEntity<String> ("App working", HttpStatus.OK);
		
	}
	
}
