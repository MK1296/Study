package com.example.taskmanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.taskmanagement.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {

    // タスク名で検索
    List<TaskEntity> findByTaskNameContaining(String keyword);

}
