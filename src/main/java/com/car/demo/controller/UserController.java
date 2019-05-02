package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("register")
    @ResponseBody
    public ResultInfo insert(User user) {//number;name;password;superiorId
//        if(user==null||StringUtil.haveNullOrEmpty(user.getName(),user.getNumber(),user.getPassword())){
//            return new ResultInfo(0,"注册数据不合法");
//        }
        //need detial
        if (StringUtils.isEmpty(user.getName())) {
            return new ResultInfo(0, "请输入用户名");
        }
        if (StringUtils.isEmpty(user.getNumber())) {
            return new ResultInfo(0, "请输入编号");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return new ResultInfo(0, "请输入密码");
        }
        return userService.insert(user);
    }

    @GetMapping("login")
    @ResponseBody
    public ResultInfo selectByNumberAndPassword(HttpSession session, User user) {
//        if (user == null || StringUtil.haveNullOrEmpty(user.getNumber(), user.getPassword())) {
//            return new ResultInfo(0, "登录不合法");
//        }//need detial
        if (StringUtils.isEmpty(user.getNumber())) {
            return new ResultInfo(0, "请输入编号");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return new ResultInfo(0, "请输入密码");
        }
        return userService.selectByNumberAndPassword(session,user);
    }

    @GetMapping("search_by_condition")
    @ResponseBody
    public ResultInfo selectByCondition(User user) {
        return userService.selectByCondition(user);
    }

    @PostMapping("update_review_state")
    @ResponseBody
    public ResultInfo updateReviewStateByUserId(User user) {//userId reviewState
//        if (user == null || StringsHasNullorEmpty.check(user.getUserId(), user.getReviewState())) {
//            return new ResultInfo(0, "修改操作不合法");
//        }
        if (StringUtils.isEmpty(user.getUserId())) {
            return new ResultInfo(0, "请输入用户id");
        }
        if (StringUtils.isEmpty(user.getReviewState())) {
            return new ResultInfo(0, "请输入要修改的状态");
        }
        return userService.updateReviewStateByUserId(user);
    }
}
