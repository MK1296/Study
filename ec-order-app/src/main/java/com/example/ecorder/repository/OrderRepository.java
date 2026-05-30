package com.example.ecorder.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.ecorder.entity.Order;
import com.example.ecorder.entity.Product;

@Mapper
public interface OrderRepository {

    // 受注一覧取得
    List<Order> findAll();

    // 商品一覧取得
    List<Product> getProductMap();

    // 受注登録
    void insert(Order order);

    // 受注1件取得
    Order findById(Integer orderId);

    // 論理削除
    void delete(Integer orderId);

    // 更新
    void update(Order order);

    // 重複チェック
    int countDuplicate(Order order);
}