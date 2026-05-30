package com.example.ecorder.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.ecorder.entity.Order;
import com.example.ecorder.service.OrderService;

import jakarta.validation.Valid;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    // 一覧画面
    @GetMapping("/orders")
    public String showList(Model model) {

        List<Order> orderList = orderService.findAll();

        model.addAttribute("orderList", orderList);

        return "orderList";
    }

    // 登録画面表示
    @GetMapping("/orders/new")
    public String showForm(Model model) {

        Map<Integer, String> productMap = orderService.getProductMap();

        model.addAttribute("order", new Order());
        model.addAttribute("productMap", productMap);

        return "orderForm";
    }

    // 登録処理
    @PostMapping("/orders/save")
    public String saveOrder(
            @Valid @ModelAttribute Order order,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {

            model.addAttribute(
                    "productMap",
                    orderService.getProductMap());

            return "orderForm";
        }

        try {

            orderService.insert(order);

        } catch (RuntimeException e) {

            model.addAttribute(
                    "productMap",
                    orderService.getProductMap());

            model.addAttribute(
                    "duplicateError",
                    e.getMessage());

            return "orderForm";
        }

        return "redirect:/orders";
    }

    // 編集画面表示
    @GetMapping("/orders/edit/{orderId}")
    public String editOrder(
            @PathVariable Integer orderId,
            Model model) {

        Order order = orderService.findById(orderId);

        Map<Integer, String> productMap = orderService.getProductMap();

        model.addAttribute("order", order);
        model.addAttribute("productMap", productMap);

        return "orderForm";
    }

    // 更新処理
    @PostMapping("/orders/update")
    public String updateOrder(@ModelAttribute Order order) {

        orderService.update(order);

        return "redirect:/orders";
    }

    // 削除処理（論理削除）
    @GetMapping("/orders/delete/{orderId}")
    public String deleteOrder(@PathVariable Integer orderId) {

        orderService.delete(orderId);

        return "redirect:/orders";
    }
}