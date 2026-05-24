package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.UserEntity;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserMapper userMapper;

    @Test
    void searchAllで一覧取得できる() {

        // Arrange
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setName("田中");

        List<UserEntity> userList = new ArrayList<>();
        userList.add(user);

        when(userMapper.findAll()).thenReturn(userList);

        // Act
        List<UserEntity> result = userService.searchAll();

        // Assert
        assertEquals(1, result.size());
        assertEquals("田中", result.get(0).getName());
    }
}