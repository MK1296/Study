package com.example.taskmanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.taskmanagement.entity.CategoryEntity;
import com.example.taskmanagement.repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // カテゴリー一覧を取得
    public List<CategoryEntity> getAllCategories() {
        return categoryRepository.findAll();
    }
}