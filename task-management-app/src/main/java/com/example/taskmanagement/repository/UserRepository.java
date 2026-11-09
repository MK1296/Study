package com.example.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.taskmanagement.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}