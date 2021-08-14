package com.example.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.example.application.repository.ChatModelRepository;

@CrossOrigin(origins = {"*"})
@RestController
public class ChatController {

	@Autowired
	private ChatModelRepository chatModelRepository;
	
	@PostMapping
	public ResponseEntity<?> startChat() {
		return new ResponseEntity<String> ("chat started", HttpStatus.OK);
	}
}
