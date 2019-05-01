package com.car.demo.service.impl;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.mapper.UserMapper;
import com.car.demo.service.UserService;
import com.car.demo.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;
    @Override
    public ResultInfo insert(User user) {
        if(userMapper.selectByName(user)>0){//has register
            return new ResultInfo(0,"has register",null);
        }
        user.setUserId(MD5Util.str2MD5(UUID.randomUUID().toString()));//uuid-md5
        Date date=new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        user.setReviewState("未审核");
        Integer len=userMapper.insert(user);
        if(len>0){//insert success
            return new ResultInfo(1,"success",len);
        }else{//insert false
            return new ResultInfo(0,"insert user false",len);
        }
    }

    @Override
    public ResultInfo select(User user) {
        User u=userMapper.select(user);
        if(u==null){//don't match
            return new ResultInfo(0,"not match",null);
        }else if(u.getReviewState().equals("未审核")){//hasn't review
            return new ResultInfo(0,"hasn't review",u);
        }else if(u.getReviewState().equals("拒绝")){//hasn't review
            return new ResultInfo(0,"reviewed false",u);
        }else{
            return new ResultInfo(1,"success",u);
        }

    }

    @Override
    public ResultInfo selectByCondition(User user) {
        List<User> list=userMapper.selectByCondition(user);
        if(list==null){
            return new ResultInfo(0,"no user",null);
        }else{
            return new ResultInfo(1,"success",list);
        }
    }

    @Override
    public ResultInfo update(User user) {
        Integer len=userMapper.updateSelective(user);
        if(len>0){
            return new ResultInfo(1,"update success",len);
        }else{
            return new ResultInfo(0,"no update",len);
        }
    }
}
