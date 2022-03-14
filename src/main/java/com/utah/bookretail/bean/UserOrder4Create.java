package com.utah.bookretail.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserOrder4Create {
    private Long userId;
    private BigDecimal orderAmount;
}
