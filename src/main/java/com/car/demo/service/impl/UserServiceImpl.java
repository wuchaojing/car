package com.car.demo.service.impl;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.mapper.UserMapper;
import com.car.demo.service.UserService;
import com.car.demo.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ResultInfo register(User user) {
        if (userMapper.selectByNumber(user) > 0) {
            return new ResultInfo(0, "该用户已经注册");
        }

        user.setUserId(MD5Util.str2MD5(UUID.randomUUID().toString()));//uuid-md5
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        user.setReviewState("未审核");
        userMapper.insert(user);
        return new ResultInfo(1);

    }

    @Override
    public ResultInfo login(User user) {
        User dbUser = userMapper.selectByNumberAndPassword(user);

        if (dbUser == null) {

            return new ResultInfo(0, "账号或者密码错误");

        } else if (dbUser.getReviewState().equals("未审核")) {//hasn't review

            return new ResultInfo(0, "该账号还未审核，请等待管理员审核");

        } else if (dbUser.getReviewState().equals("拒绝")) {//hasn't review

            return new ResultInfo(0, "该用户审核不通过，拒绝访问");

        } else if (dbUser.getReviewState().equals("已注销")) {//删除了后就是注销状态
            return new ResultInfo(0, "该用户已注销，不可使用");
        } else {
            return new ResultInfo(1, dbUser);
        }

    }

    @Override
    public ResultInfo selectAll() {
        List<User> list = userMapper.selectAll();
        return new ResultInfo(1, list);

    }

    @Override
    public ResultInfo update(User user) {
        userMapper.update(user);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo searchByCondition(User user) {
        List<User> list = userMapper.searchByCondition(user);
        return new ResultInfo(1, list);
    }

    @Override
    public ResultInfo updateReviewStateToCancle(User user) {//伪删除，注销用户即可
        user.setReviewState("已注销");
        userMapper.updateReviewStateToCancle(user);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo updatePassword(User user) {
        userMapper.updatePassword(user);
        return new ResultInfo(1);
    }
}
