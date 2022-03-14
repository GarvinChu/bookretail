package com.utah.bookretail.service;

import com.utah.bookretail.bean.UserOrder4Create;
import com.utah.bookretail.common.Result;
import com.utah.bookretail.entity.UserOrder;

import java.util.List;

public interface IUserOrderService {

    void submitOrder(UserOrder4Create userOrder4Create);

    Result<List<UserOrder>> listByUserId(Long userId);
}
