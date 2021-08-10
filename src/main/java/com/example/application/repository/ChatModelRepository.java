package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.model.ChatModel;

public interface ChatModelRepository extends JpaRepository<ChatModel, Long> {

}
