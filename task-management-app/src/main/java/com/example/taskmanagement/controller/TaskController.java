package com.example.taskmanagement.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.taskmanagement.entity.TaskEntity;
import com.example.taskmanagement.service.TaskService;
import com.example.taskmanagement.dto.TaskDto;
import com.example.taskmanagement.service.UserService;
import com.example.taskmanagement.service.CategoryService;
import com.example.taskmanagement.entity.CategoryEntity;
import com.example.taskmanagement.entity.UserEntity;

@Controller
public class TaskController {

    private final TaskService taskService;
    private final UserService userService;
    private final CategoryService categoryService;

    // コンストラクタ
    public TaskController(
            TaskService taskService,
            UserService userService,
            CategoryService categoryService) {

        this.taskService = taskService;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    // タスク一覧画面を表示
    @GetMapping("/tasks")
    public String showTaskList(
            @RequestParam(required = false) String keyword,
            Model model) {

        // タスク一覧を取得
        List<TaskEntity> tasks;

        // 検索キーワードが入力されている場合
        if (keyword != null && !keyword.isBlank()) {

            tasks = taskService.searchTasks(keyword);

        } else {

            // 検索キーワードがない場合は全件取得
            tasks = taskService.getAllTasks();
        }

        // DBからカテゴリー一覧を取得
        List<CategoryEntity> categories = categoryService.getAllCategories();

        // カテゴリーIDとカテゴリー名を対応させる
        Map<Integer, String> categoryMap = new HashMap<>();

        // カテゴリー一覧を繰り返し処理
        for (CategoryEntity category : categories) {
            categoryMap.put(
                category.getCategoryId(),
                category.getCategoryName()
            );
        }

        // 現在の日付を取得
        Date today = new Date();

        // 日付の表示形式を指定
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        // 日付を文字列に変換
        String formattedDate = sdf.format(today);

        System.out.println("今日の日付：" + formattedDate);

        // DBからユーザー一覧を取得
        List<UserEntity> users = userService.getAllUsers();

        // HTMLにデータを渡す
        model.addAttribute("tasks", tasks);
        model.addAttribute("users", users);
        model.addAttribute("categoryMap", categoryMap);
        model.addAttribute("keyword", keyword);

        return "task/list";
    }

    // タスク新規登録画面を表示
    @GetMapping("/tasks/create")
    public String showCreateForm(Model model) {

        // 入力フォーム用のDTOを用意
        model.addAttribute("task", new TaskDto());

        // DBからユーザー一覧を取得
        List<UserEntity> users = userService.getAllUsers();

        // HTMLにユーザー一覧を渡す
        model.addAttribute("users", users);

        // 新規登録画面を表示
        return "task/create";
    }

    // タスク登録処理
    @PostMapping("/tasks/create")
    public String createTask(
            @Valid @ModelAttribute("task") TaskDto taskDto,
            BindingResult bindingResult,
            Model model) {

        // 入力チェックでエラーがあれば登録画面に戻る
        if (bindingResult.hasErrors()) {

            // ユーザー一覧を再取得
            List<UserEntity> users = userService.getAllUsers();

            // HTMLにユーザー一覧を渡す
            model.addAttribute("users", users);

            return "task/create";
        }

        // ユーザーIDが存在するか確認
        if (!userService.existsUser(taskDto.getUserId())) {

            // エラーメッセージを設定
            bindingResult.rejectValue(
                "userId",
                "userId.invalid",
                "選択されたユーザーは存在しません。"
            );

            // ユーザー一覧を再取得
            List<UserEntity> users = userService.getAllUsers();

            // HTMLにユーザー一覧を渡す
            model.addAttribute("users", users);

            return "task/create";
        }

        // DTOからEntityにデータを移す
        TaskEntity task = new TaskEntity();

        task.setUserId(taskDto.getUserId());
        task.setCategoryId(taskDto.getCategoryId());
        task.setTaskName(taskDto.getTaskName());
        task.setTaskDetail(taskDto.getTaskDetail());
        task.setDueDate(taskDto.getDueDate());
        task.setStatus(taskDto.getStatus());

        // Serviceを通じてDBに登録
        taskService.createTask(task);

        // 登録後はタスク一覧画面へ戻る
        return "redirect:/tasks";
    }

    // タスク更新画面を表示
    @GetMapping("/tasks/edit/{taskId}")
    public String showEditForm(@PathVariable Integer taskId, Model model) {

        // タスクIDから対象のタスクを取得
        TaskEntity task = taskService.getTaskById(taskId);

        // HTMLにタスク情報を渡す
        model.addAttribute("task", task);

        // 更新画面を表示
        return "task/edit";
    }

    // タスク更新処理
    @PostMapping("/tasks/edit")
    public String updateTask(
            @Valid @ModelAttribute("task") TaskDto taskDto,
            BindingResult bindingResult) {

        // 入力チェックでエラーがあれば更新画面に戻る
        if (bindingResult.hasErrors()) {
            return "task/edit";
        }

        // DTOからEntityにデータを移す
        TaskEntity task = new TaskEntity();

        task.setTaskId(taskDto.getTaskId());
        task.setUserId(taskDto.getUserId());
        task.setCategoryId(taskDto.getCategoryId());
        task.setTaskName(taskDto.getTaskName());
        task.setTaskDetail(taskDto.getTaskDetail());
        task.setDueDate(taskDto.getDueDate());
        task.setStatus(taskDto.getStatus());

        // Serviceを通じてDBを更新
        taskService.updateTask(task);

        // 更新後は一覧画面へ戻る
        return "redirect:/tasks";
    }

    // タスク削除処理
    @PostMapping("/tasks/delete/{taskId}")
    public String deleteTask(@PathVariable Integer taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/tasks";
    }
}