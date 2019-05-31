package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.service.UserService;
import com.car.demo.util.ConstantUtil;
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

    @GetMapping("register_superior")
    @ResponseBody
    public ResultInfo registerSuperior(User user) {//查出已经审核通过的name(名字是模糊查询)【选上级id的时候用】(可条件查询)
        return userService.getSuperior(user);
    }

    @PostMapping("register")
    @ResponseBody
    public ResultInfo register(@RequestBody User user) {
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
            user.setSuperiorId("");
        }

        if(user.getSuperiorId().equals(user.getUserId())){//避免死循环
            return new ResultInfo(0, "上级不可以是自己");
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

    @PostMapping("update_password") // 登录的就有这个权限
    @ResponseBody
    public ResultInfo updatePassword(HttpSession session, String oldPassword, String newPassword) {
        User user = (User) session.getAttribute(ConstantUtil.CLIENT_ID);
        if (user == null) {
            return new ResultInfo(0, "用户未登录");
        }
        if (StringUtils.isEmpty(user.getUserId())) {
            return new ResultInfo(0, "该选择用户");
        }
        if (StringUtils.isEmpty(oldPassword)) {
            return new ResultInfo(0, "旧密码不能为空");
        }
        if (StringUtils.isEmpty(newPassword)) {
            return new ResultInfo(0, "新密码不能为空");
        }
        user.setPassword(oldPassword);
        return userService.updatePassword(user, newPassword);
    }

    @GetMapping("admin_search_all")
    @ResponseBody
    public ResultInfo selectAll() {//login了审核的用户后方可使用
        return userService.selectAll();
    }


    @PostMapping("admin_update") // 只有管理员有这个权限
    @ResponseBody
    public ResultInfo update(@RequestBody User user) {

        if (StringUtils.isEmpty(user.getUserId())) {
            return new ResultInfo(0, "请选择用户");
        }

        if (StringUtils.isEmpty(user.getReviewState())) {
            return new ResultInfo(0, "请选择审核状态");
        }

//        if (StringUtils.isEmpty(user.getSuperiorId())) {//无上级也传值
//            return new ResultInfo(0, "请选择该用户上级");
//        }

        if(user.getSuperiorId().equals(user.getUserId())){
            return new ResultInfo(0,"其上级不是是其自己");
        }
        return userService.update(user);
    }

    @GetMapping("admin_search") // 管理员可以根据条件查询用户（userId,number以及模糊查询用户名，审核状态）【给其找回密码】
    @ResponseBody
    public ResultInfo search(User user) {//login了审核的用户后方可使用
        return userService.search(user);
    }

    @PostMapping("admin_delete")
    @ResponseBody
    public ResultInfo delete(User user) {//login了审核的用户后方可使用
        if (StringUtils.isEmpty(user.getUserId())) {
            return new ResultInfo(0, "请选择用户");
        }
        return userService.delete(user);
    }

    @GetMapping("logout")
    @ResponseBody
    public ResultInfo logout(HttpSession session, User user) {
        session.removeAttribute(ConstantUtil.CLIENT_ID);
        return new ResultInfo(1);
    }

}
