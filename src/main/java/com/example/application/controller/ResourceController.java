package com.example.application.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.model.ResourceModel;
import com.example.application.repository.ResourceModelRepository;

@RestController
public class ResourceController {

	@Autowired
	private ResourceModelRepository resourceModelRepository;
	
	@GetMapping("/home")
	public ResponseEntity<List<?>> getResource() {
		return new ResponseEntity<List<?>>(resourceModelRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/home/{id}")
	public ResponseEntity<?> getResourceById(@PathVariable Long id) {
		try {
			ResourceModel resourceModel = resourceModelRepository.findById(id).orElse(null);
			if(resourceModel == null) {
				return new ResponseEntity<String>("Resource Doesn't Exist", HttpStatus.CONFLICT);
			}
			return new ResponseEntity<ResourceModel>(resourceModel, HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Error in server", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/home/{id}")
	public ResponseEntity<?> resourceEditSave(@PathVariable Long id, @RequestBody ResourceModel resourceModel ) {
		try{
			
			resourceModelRepository.save(resourceModel);
			return new ResponseEntity<String>("Update Success", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Update failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/home/{id}")
	public ResponseEntity<?> resourceDelete(@PathVariable Long id) {
		try{
			
			resourceModelRepository.deleteById(id);
			return new ResponseEntity<String>("Resource Deleted", HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("Resource Delete failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/home")
	public ResponseEntity<?> resourceSave(@RequestBody ResourceModel resourceModel) {
		try {
			
//			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date date = new Date();
			resourceModel.setCreatedOn(date);
			System.out.println("rs 1");
			resourceModelRepository.save(resourceModel);
			System.out.println("rs 2");
			return new ResponseEntity<String>("Added Successfully", HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println("error: " + e);
			return new ResponseEntity<String>("Not added", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
