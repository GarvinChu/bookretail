package com.utah.bookretail.service;

import com.utah.bookretail.bean.UserBean4Create;
import com.utah.bookretail.entity.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void save(UserBean4Create userBean4Create);
}
