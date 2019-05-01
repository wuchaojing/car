package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {
    @Resource
    UserService userService;

    @PostMapping("user")
    @ResponseBody
    public ResultInfo insert(User user) {//number;name;password;superiorId
        return userService.insert(user);
    }

    @GetMapping("user")
    @ResponseBody
    public ResultInfo select(User user) {
        return userService.select(user);
    }

    @GetMapping("users")
    @ResponseBody
    public ResultInfo selectByCondition(User user){
        return userService.selectByCondition(user);
    }

    @PutMapping("user")
    @ResponseBody
    public ResultInfo update(User user){//userId reviewState
        return userService.update(user);
    }
}
