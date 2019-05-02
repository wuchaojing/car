package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.service.UserService;
import com.car.demo.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("register")
    @ResponseBody
    public ResultInfo register(User user) {
        if (StringUtils.isEmpty(user.getName())) {
            return new ResultInfo(0, "请输入用户名");
        }

        if (StringUtils.isEmpty(user.getNumber())) {
            return new ResultInfo(0, "请输入编号");
        }

        if (StringUtils.isEmpty(user.getPassword())) {
            return new ResultInfo(0, "请输入密码");
        }

        if (StringUtils.isEmpty(user.getSuperiorId())) {
            return new ResultInfo(0, "请选择上级");
        }

        return userService.register(user);
    }

    @GetMapping("login")
    @ResponseBody
    public ResultInfo login(HttpSession session, User user) {
        if (StringUtils.isEmpty(user.getNumber())) {
            return new ResultInfo(0, "请输入编号");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return new ResultInfo(0, "请输入密码");
        }
        ResultInfo resultInfo = userService.login(user);
        User dbUser = (User) resultInfo.getData();
        session.setAttribute(ConstantUtil.CLIENT_ID, dbUser);
        return resultInfo;
    }

    @GetMapping("admin_search_all") // 管理员只需要查看所有用户信息，不需要单独查看用户信息
    @ResponseBody
    public ResultInfo selectAll() {
        return userService.selectAll();
    }


    @PostMapping("admin_update") // 只有管理员有这个权限
    @ResponseBody
    public ResultInfo update(User user) {

        if (StringUtils.isEmpty(user.getUserId())) {
            return new ResultInfo(0, "请选择用户");
        }

        if (StringUtils.isEmpty(user.getReviewState())) {
            return new ResultInfo(0, "请选择审核状态");
        }

        if (StringUtils.isEmpty(user.getSuperiorId())) {//无上级也传值
            return new ResultInfo(0, "请选择该用户上级");
        }

        return userService.update(user);
    }
}
