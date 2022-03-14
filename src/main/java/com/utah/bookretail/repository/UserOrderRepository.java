package com.utah.bookretail.repository;

import com.utah.bookretail.entity.UserOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserOrderRepository extends CrudRepository<UserOrder, Long> {
    List<UserOrder> findByUserId(Long userId);
}
