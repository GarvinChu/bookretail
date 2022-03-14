package com.utah.bookretail.service.impl;

import com.utah.bookretail.bean.UserBean4Create;
import com.utah.bookretail.entity.User;
import com.utah.bookretail.repository.UserRepository;
import com.utah.bookretail.service.IUserService;
import com.utah.bookretail.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public void save(UserBean4Create userBean4Create) {
        User user = new User();
        user.setName(userBean4Create.getName());
        user.setMemberTypeId(userBean4Create.getMemberTypeId());
        user.setPoints(new BigDecimal(0));
        user.setDeleted(0);
        user.setCreateTime(DateUtil.now());
        user.setUpdateTime(DateUtil.now());
        userRepository.save(user);
    }
}
