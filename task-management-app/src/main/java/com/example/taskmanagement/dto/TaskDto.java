package com.example.taskmanagement.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TaskDto {

    // タスクID
    private Integer taskId;

    // ユーザーID
    @NotNull(message = "ユーザーIDを入力してください")
    private Integer userId;

    // カテゴリーID
    @NotNull(message = "カテゴリーを選択してください")
    private Integer categoryId;

    // タスク名
    @NotBlank(message = "タスク名を入力してください")
    @Size(max = 100, message = "タスク名は100文字以内で入力してください")
    private String taskName;

    // タスクの詳細
    @Size(max = 500, message = "詳細は500文字以内で入力してください")
    private String taskDetail;

    // 期限
    private LocalDate dueDate;

    // タスクのステータス
    @NotBlank(message = "ステータスを入力してください")
    private String status;

    // Getter・Setter

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public void setTaskDetail(String taskDetail) {
        this.taskDetail = taskDetail;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}