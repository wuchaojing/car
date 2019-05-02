package com.car.demo.service;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;

import javax.servlet.http.HttpSession;

public interface UserService {
    ResultInfo insert(User user);

    ResultInfo selectByNumberAndPassword(HttpSession session,User user);

    ResultInfo selectByCondition(User user);

    ResultInfo updateReviewStateByUserId(User user);

    ResultInfo update(User user);
}
