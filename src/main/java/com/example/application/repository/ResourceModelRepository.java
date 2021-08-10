package com.example.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.application.model.ResourceModel;

public interface ResourceModelRepository extends JpaRepository<ResourceModel, Long> {

}
