package com.example.ecorder.entity;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Order {

    private Integer orderId;

    @NotBlank(message = "受注番号は必須です")
    private String orderNo;

    @NotBlank(message = "購入者名は必須です")
    private String customerName;

    @NotNull(message = "商品を選択してください")
    private Integer productId;

    private String productName;

    @NotNull(message = "数量は必須です")
    @Min(value = 1, message = "数量は1以上で入力してください")
    @Max(value = 999, message = "数量は999以下で入力してください")
    private Integer quantity;

    @NotBlank(message = "ステータスは必須です")
    private String orderStatus;

    @NotNull(message = "受注日は必須です")
    private LocalDate orderDate;

    private LocalDate deliveryDate;

    private Integer deleteFlg;
}