package com.example.taskmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.taskmanagement.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

}