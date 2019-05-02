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
    UserMapper userMapper;

    @Override
    public ResultInfo insert(User user) {
        if (userMapper.selectByNumber(user) > 0) {//has register
            return new ResultInfo(0, "该用户已经注册");
        }
        user.setUserId(MD5Util.str2MD5(UUID.randomUUID().toString()));//uuid-md5
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        user.setReviewState("未审核");
        userMapper.insert(user);
//        if(len==null||len<=0){//insert false
//            return new ResultInfo(0,"insert user false",0);
//        }//insert success
        return new ResultInfo(1, "注册成功");

    }

    @Override
    public ResultInfo selectByNumberAndPassword(HttpSession session,User user) {
        User u = userMapper.selectByNumberAndPassword(user);
        if (u == null) {//don't match
            return new ResultInfo(0, "账号或者密码错误", null);
        } else if (u.getReviewState().equals("未审核")) {//hasn't review
            return new ResultInfo(0, "该账号还未审核，请等待管理员审核", u);
        } else if (u.getReviewState().equals("拒绝")) {//hasn't review
            return new ResultInfo(0, "该用户审核不通过，拒绝访问", u);
        } else {
            session.setAttribute("user",u);
            return new ResultInfo(1, "登录成功", u);
        }

    }

    @Override
    public ResultInfo selectByCondition(User user) {
        List<User> list = userMapper.selectByCondition(user);
//        if(list==null||list.size()==0){
//            return new ResultInfo(0,"no user",null);
//        }
        return new ResultInfo(1, "管理员查询用户成功", list);

    }

    @Override
    public ResultInfo updateReviewStateByUserId(User user) {
        userMapper.updateReviewState(user);
//        if(len==null||len<=0){
//            return new ResultInfo(0,"no update",len);
//        }
        return new ResultInfo(1, "管理员修改数据成功");

    }
}
