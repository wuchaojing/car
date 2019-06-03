package com.car.demo.service;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    ResultInfo getSuperior(User users);

    ResultInfo register(User user);

    ResultInfo login(User user);

    ResultInfo update(User user);

    ResultInfo selectAll();

    ResultInfo selectPart(User user);

    ResultInfo search(User user);

    ResultInfo delete(User user);

    ResultInfo updatePassword(User user, String oldPassword);
}
