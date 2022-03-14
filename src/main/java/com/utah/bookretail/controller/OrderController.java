package com.utah.bookretail.controller;

import com.utah.bookretail.bean.UserOrder4Create;
import com.utah.bookretail.common.Result;
import com.utah.bookretail.entity.UserOrder;
import com.utah.bookretail.service.IUserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IUserOrderService userOrderService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void submitOrder(@RequestBody UserOrder4Create request) {
        userOrderService.submitOrder(request);
    }

    @GetMapping("/listByUserId/{userId}")
    public Result<List<UserOrder>> listByUserId(@PathVariable Long userId) {
        return userOrderService.listByUserId(userId);
    }
}
