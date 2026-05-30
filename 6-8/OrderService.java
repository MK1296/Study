package com.example.ecorder.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecorder.entity.Order;
import com.example.ecorder.entity.Product;
import com.example.ecorder.repository.OrderRepository;

@Service
    public class OrderService {


@Autowired
    private OrderRepository orderRepository;

    // 受注一覧取得
    public List<Order> findAll() {

        return orderRepository.findAll();
    }

    // 商品Map取得
    public Map<Integer, String> getProductMap() {

        List<Product> productList = orderRepository.getProductMap();

        Map<Integer, String> productMap = new LinkedHashMap<>();

        for (Product product : productList) {

            productMap.put(
                product.getProductId(),
                product.getProductName()
            );
        }

        return productMap;
    }

    // 受注登録
    public void insert(Order order) {

        int count = orderRepository.countDuplicate(order);

        if (count > 0) {

            throw new RuntimeException(
                "同じ購入者・商品・受注日の受注が既に存在します。"
            );
        }

        orderRepository.insert(order);
    }

    // 受注1件取得
    public Order findById(Integer orderId) {

        return orderRepository.findById(orderId);
    }

    // 更新
    public void update(Order order) {

    int count = orderRepository.countDuplicate(order);
    if (count > 0) {
        throw new RuntimeException(
            "同じ購入者・商品・受注日の受注が既に存在します。"
        );
    }

    orderRepository.update(order);

    }

    // 論理削除
    public void delete(Integer orderId) {

        orderRepository.delete(orderId);
    }


    }
