package com.utah.bookretail.controller;

import com.utah.bookretail.bean.UserBean4Create;
import com.utah.bookretail.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void createUser(@RequestBody UserBean4Create request) {
        userService.save(request);
    }
}
