package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.application.model.LoginModel;
import com.example.application.model.UserModel;
import com.example.application.repository.UserModelRepository;

@CrossOrigin(origins = {"*"})
@RestController
public class LoginController {

	@Autowired
	private UserModelRepository userModelRepository;
	
	@PostMapping("/login")
	public ResponseEntity<?> checkUser(@RequestBody LoginModel loginModel) {
		
		try {
			UserModel userModel = userModelRepository.findById(loginModel.getEmail()).orElse(null);
		
		if(userModel != null && userModel.getPassword().equals(loginModel.getPassword())) {
			
			return new ResponseEntity<String> ("true", HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String> ("false", HttpStatus.FORBIDDEN);
		}
		}
		catch(Exception e) {
			return new ResponseEntity<String> ("false", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
}
