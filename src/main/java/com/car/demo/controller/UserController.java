package com.car.demo.controller;

import com.car.demo.entity.User;
import com.car.demo.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//@Controller
@RestController//等价于controller+responsebody
public class UserController {//http://localhost:8080/searchAll
    @Resource
    private UserService userService;

    @RequestMapping("searchAll")
    public List<User> searchAll() {/*http://localhost:8080/searchAll*/
//        User user = new User("abc");
        User user = new User();
        return userService.searchAll(user);
    }


}
