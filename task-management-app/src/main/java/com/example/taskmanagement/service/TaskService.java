package com.example.taskmanagement.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.taskmanagement.repository.TaskRepository;
import com.example.taskmanagement.entity.TaskEntity;
import com.example.taskmanagement.exception.TaskNotFoundException;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // タスク登録
    public TaskEntity createTask(TaskEntity task) {

        LocalDateTime now = LocalDateTime.now();

        task.setCreatedAt(now);
        task.setUpdatedAt(now);

        return taskRepository.save(task);
    }

    // タスク一覧取得
    public List<TaskEntity> getAllTasks() {
        return taskRepository.findAll();
    }

    // タスクIDで検索
    public TaskEntity getTaskById(Integer taskId) {

        return taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("指定されたタスクが存在しません。"));
    }

    // タスク名で検索
    public List<TaskEntity> searchTasks(String keyword) {
        return taskRepository.findByTaskNameContaining(keyword);
    }

    // タスク更新
    public TaskEntity updateTask(TaskEntity task) {

        TaskEntity existingTask = taskRepository.findById(task.getTaskId())
                .orElseThrow(() -> new TaskNotFoundException("指定されたタスクが存在しません。"));

        task.setCreatedAt(existingTask.getCreatedAt());
        task.setUpdatedAt(LocalDateTime.now());

        return taskRepository.save(task);
    }

    // タスク削除
    @Transactional
    public void deleteTask(Integer taskId) {

        if (!taskRepository.existsById(taskId)) {
            throw new TaskNotFoundException("指定されたタスクが存在しません。");
        }

        taskRepository.deleteById(taskId);
    }
}