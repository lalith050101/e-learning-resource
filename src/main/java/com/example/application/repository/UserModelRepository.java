package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.model.UserModel;

public interface UserModelRepository extends JpaRepository<UserModel, String> {

	
}
