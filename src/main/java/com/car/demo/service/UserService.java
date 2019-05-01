package com.car.demo.service;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;

public interface UserService {
    ResultInfo insert(User user);

    ResultInfo selectByNumberAndPassword(User user);

    ResultInfo selectByCondition(User user);

    ResultInfo updateReviewStateByUserId(User user);
}
