package com.utah.bookretail.service.impl;

import com.utah.bookretail.bean.UserOrder4Create;
import com.utah.bookretail.common.Result;
import com.utah.bookretail.entity.User;
import com.utah.bookretail.entity.UserOrder;
import com.utah.bookretail.exception.BookretailException;
import com.utah.bookretail.repository.UserOrderRepository;
import com.utah.bookretail.repository.UserRepository;
import com.utah.bookretail.service.IUserOrderService;
import com.utah.bookretail.utils.DateUtil;
import com.utah.bookretail.utils.NumberUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserOrderServiceImpl implements IUserOrderService {
    @Autowired
    private UserOrderRepository userOrderRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void submitOrder(UserOrder4Create userOrder4Create) {
        Long userId = userOrder4Create.getUserId();
        User user = userRepository.findByIdAndDeleted(userId, 0);
        if (user == null) {
            throw new BookretailException("The user is not exist!");
        }
        UserOrder userOrder = new UserOrder();
        userOrder.setUserId(userId);
        userOrder.setOrderNumber(NumberUtil.genOrderNo());
        BigDecimal orderAmount = userOrder4Create.getOrderAmount();
        userOrder.setOrderAmount(orderAmount);
        userOrder.setDeleted(0);
        userOrder.setPayStatus(0);
        userOrder.setTradeStatus(0);
        userOrder.setCreateTime(DateUtil.now());
        userOrder.setUpdateTime(DateUtil.now());
        userOrderRepository.save(userOrder);
        Integer memberTypeId = user.getMemberTypeId();
        BigDecimal userPoints = user.getPoints() == null ? new BigDecimal(0) : user.getPoints();
        switch (memberTypeId) {
            case 1:
                userPoints = userPoints.add(orderAmount);
                break;
            case 2:
                userPoints = userPoints.add(orderAmount.multiply(new BigDecimal(2)));
                break;
            case 3:
                userPoints = userPoints.add(orderAmount.multiply(new BigDecimal(3)));
                break;
            default:
                break;
        }
        user.setPoints(userPoints);
        userRepository.save(user);

    }

    @Override
    public Result<List<UserOrder>> listByUserId(Long userId) {
        List<UserOrder> userOrderList = userOrderRepository.findByUserId(userId);
        Result<List<UserOrder>> result = new Result<>();
        result.setData(userOrderList);
        return result;
    }
}
