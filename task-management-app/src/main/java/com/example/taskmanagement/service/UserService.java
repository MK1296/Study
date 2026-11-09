package com.example.taskmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanagement.entity.UserEntity;
import com.example.taskmanagement.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // ユーザー一覧を取得
    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    // ユーザーIDが存在するか確認
    public boolean existsUser(Integer userId) {
        return userRepository.existsById(userId);
    }
}