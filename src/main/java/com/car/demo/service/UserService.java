package com.car.demo.service;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;

public interface UserService {
    ResultInfo register(User user);

    ResultInfo login(User user);

    ResultInfo update(User user);

    ResultInfo selectAll();
}
