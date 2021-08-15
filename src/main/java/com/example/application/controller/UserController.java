package com.example.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.repository.UserModelRepository;

@CrossOrigin(origins = {"*"})
@RestController
public class UserController {

	@Autowired
	private UserModelRepository userModelRepository;
	
	@GetMapping("/admin")
	public ResponseEntity<?> getAllUsers() {
        try{
			return new ResponseEntity<List<?>> (userModelRepository.findAll(), HttpStatus.OK);
		
		}
		catch(Exception e) {
			return new ResponseEntity<String> ("error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
