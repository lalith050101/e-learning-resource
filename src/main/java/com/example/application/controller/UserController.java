package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
import com.example.application.model.LoginModel;
import com.example.application.model.UserModel;
import com.example.application.repository.UserModelRepository;

@CrossOrigin(origins = {"*"})
@RestController
public class UserController {

	@Autowired
	private UserModelRepository userModelRepository;
	
	@GetMapping("/admin")
	public ResponseEntity<List<?>> getAllUsers() {
        try{
			return new ResponseEntity<List<?>> (userModelRepository.findAll(), HttpStatus.OK);
		
		}
		catch(Exception e) {
			return new ResponseEntity<String> ("server error", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
