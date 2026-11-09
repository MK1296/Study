package com.example.taskmanagement;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.taskmanagement.exception.TaskNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // タスクが存在しない場合の例外処理
    @ExceptionHandler(TaskNotFoundException.class)
    public String handleTaskNotFoundException(
            TaskNotFoundException e, Model model) {

        // エラー情報をログファイルに出力
        logger.error("タスクが見つかりませんでした。", e);

        // エラーメッセージを画面に表示
        model.addAttribute("errorMessage", e.getMessage());

        return "error";
    }
}