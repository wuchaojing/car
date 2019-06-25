package com.car.demo.service.impl;

import com.car.demo.entity.Integration;
import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.mapper.UserMapper;
import com.car.demo.service.UserService;
import com.car.demo.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public ResultInfo getSuperior(User user) {
        List<User> users = userMapper.searchNumberAndName(user);
        return new ResultInfo(1, users);
    }

    @Override
    public ResultInfo register(User user) {
        if (userMapper.selectByNumber(user) > 0) {
            return new ResultInfo(0, "该用户已经注册");
        }

        user.setUserId(MD5Util.str2MD5(UUID.randomUUID().toString()));//uuid-md5
        Date date = new Date();
        user.setCreateTime(date);
        user.setUpdateTime(date);
        user.setReviewState("已审核");//user.setReviewState("未审核");
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
    public ResultInfo selectPart(User user) {
        List<User> list = new ArrayList<>();
        getRelativeUsers(user, list);
        return new ResultInfo(1, list);

    }

    private List<User> getRelativeUsers(User superiorUser, List<User> list) {
        if (superiorUser == null) {//end: is null
            return null;
        }
        //list.add(superiorUser);//add this【若需要自己，则取消这行，注释隔一行】
        List<User> curs = userMapper.selectSonsBySuperiorId(superiorUser.getUserId());
        list.addAll(curs);//【只要下属的】
        for (User user : curs) {
            getRelativeUsers(user, list);//into his every son
        }
        return list;
    }

    @Override
    public ResultInfo update(User user) {
        user.setUpdateTime(new Date());
        userMapper.update(user);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo search(User user) {
        List<User> list = userMapper.searchByCondition(user);
        return new ResultInfo(1, list);
    }

    @Override
    public ResultInfo delete(User user) {//伪删除，注销用户即可
        user.setReviewState("已注销");
        user.setUpdateTime(new Date());
        userMapper.update2Delete(user);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo updatePassword(User user, String newPassword) {
        user.setUpdateTime(new Date());
        Integer num = userMapper.selectCountByNumberAndPassword(user);
        if (num == null || num == 0) {
            return new ResultInfo(0, "用户旧密码不正确");
        }
        user.setPassword(newPassword);
        userMapper.updatePassword(user);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo getUpperClass(String level) {
        String[] levels = {"车间长", "工段长", "班组长", "普通员工"};
        int flag = -1;
        String pinjie = "'管理员'";
        for (int i = 0; i < levels.length; i++) {
            if (levels[i].equals(level)) {
                flag = i;
                break;
            } else {
                pinjie += ",'" + levels[i] + "'";
            }
        }
        if (flag == -1) {
            return new ResultInfo(0, "这个身份非正确格式");
        }
        System.out.println(pinjie);
        List<User> users = userMapper.searchUpperClass(pinjie);
        return new ResultInfo(1, users);
    }

    @Override
    public ResultInfo mark(Integration integration) {
        String id = MD5Util.str2MD5(UUID.randomUUID().toString());
        integration.setId(id);
        userMapper.mark(integration);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo getDirectSons(String userId) {
        List<User> users=userMapper.getDirectSons(userId);
        return new ResultInfo(1, users);
    }

    @Override
    public ResultInfo getSelfAndSonsMark(String userId) {
        List<Integration> integrations=userMapper.getSelfAndSonsMark(userId);//也查了userId，若和自己相同则是自己的
        return new ResultInfo(1, integrations);
    }

    @Override
    public ResultInfo deleteMark(String markId) {
        userMapper.deleteMark(markId);
        return new ResultInfo(1);
    }
}
