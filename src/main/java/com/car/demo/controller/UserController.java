package com.car.demo.controller;

import com.car.demo.entity.Integration;
import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.service.UserService;
import com.car.demo.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;


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
    public ResultInfo register(HttpSession session, @RequestBody User user) {
        if (StringUtils.isEmpty(user.getName())) {
            return new ResultInfo(0, "请输入用户名");
        }

        if (StringUtils.isEmpty(user.getNumber())) {
            return new ResultInfo(0, "请输入编号");
        }

        if (StringUtils.isEmpty(user.getPassword())) {
            return new ResultInfo(0, "请输入密码");
        }

        if (StringUtils.isEmpty(user.getLevel())) {
            return new ResultInfo(0, "请输入级别");
        }

        if (StringUtils.isEmpty(user.getDetail())) {
            return new ResultInfo(0, "请输入具体级别");
        }
        User userWillParent = (User) session.getAttribute(ConstantUtil.CLIENT_ID);

        if (userWillParent == null || StringUtils.isEmpty(userWillParent.getUserId())) {
            return new ResultInfo(0, "用户未登录");
        }

        user.setSuperiorId(userWillParent.getUserId());
        return userService.register(user);
    }

    @GetMapping("login")
    @ResponseBody
    public ResultInfo login(HttpSession session, User user) {
        User u = (User) session.getAttribute(ConstantUtil.CLIENT_ID);
        if (u != null) {//现在登录了一个，不允许再登一个
            if (!u.getNumber().equals(user.getNumber())) {//解决关了当前页面但没关此浏览器全部页面导致同一用户不能重复登录的bug
                return new ResultInfo(0, "不允许同时登录俩用户，请先退出之前用户");
            }
        }
        if (StringUtils.isEmpty(user.getNumber())) {
            return new ResultInfo(0, "请输入编号");
        }
        if (StringUtils.isEmpty(user.getPassword())) {
            return new ResultInfo(0, "请输入密码");
        }
        ResultInfo resultInfo = userService.login(user);
        User dbUser = (User) resultInfo.getData();
        session.setAttribute(ConstantUtil.CLIENT_ID, dbUser);
        session.setMaxInactiveInterval(30 * 60);//以秒为单位，即在没有活动30分钟后，session将失效
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

    @GetMapping("user_search_part")
    @ResponseBody
    public ResultInfo selectPart(HttpSession session) {//login了审核的用户后方可使用
        User user = (User) session.getAttribute(ConstantUtil.CLIENT_ID);
        if (user == null) {
            return new ResultInfo(0, "用户未登录");
        }
        return userService.selectPart(user);
    }

    @PostMapping("admin_update") // 【修改具体分区】
    @ResponseBody
    public ResultInfo update(@RequestBody User user) {

        if (StringUtils.isEmpty(user.getUserId())) {
            return new ResultInfo(0, "请选择用户");
        }

        if (StringUtils.isEmpty(user.getDetail())) {
            return new ResultInfo(0, "请输入具体级别分区");
        }

        if (StringUtils.isEmpty(user.getSuperiorId())) {
            return new ResultInfo(0, "请输入该用户上级");
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

    @GetMapping("get_upper_class")
    @ResponseBody
    public ResultInfo getUpperClass(User user) {
        if (StringUtils.isEmpty(user.getLevel())) {
            return new ResultInfo(0, "请选择一个用户");
        }
        return userService.getUpperClass(user.getLevel());
    }

    @PostMapping("mark")
    @ResponseBody
    public ResultInfo mark(@RequestBody Integration integration, @RequestBody Map<String, String> params) {
        String level = params.get("level");
        if (StringUtils.isEmpty(level)) {
            return new ResultInfo(0, "输入当前用户级别");
        }
        if (StringUtils.isEmpty(integration.getName())) {
            return new ResultInfo(0, "用户名不能为空");
        }
        if (StringUtils.isEmpty(integration.getReason())) {
            return new ResultInfo(0, "原因不能为空");
        }
        if (StringUtils.isEmpty(integration.getMark())) {
            return new ResultInfo(0, "打分不能为空");
        }
        if (StringUtils.isEmpty(integration.getMarkId())) {
            return new ResultInfo(0, "评分人不能为空");
        }
        if (StringUtils.isEmpty(integration.getUserId())) {
            if (!"班组长".equals(level)) {
                return new ResultInfo(0, "请输入下拉框里面的人");
            }
            integration.setUserId("");//班组可以不用传那个人
        }
        if (StringUtils.isEmpty(integration.getName())) {
            return new ResultInfo(0, "用户名不能为空");
        }
        return userService.mark(integration);
    }

    @GetMapping("direct_sons")
    @ResponseBody
    public ResultInfo getDirectSons(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return new ResultInfo(0, "请选择一个用户");
        }
        return userService.getDirectSons(userId);
    }

    @GetMapping("self_and_sons_mark")
    @ResponseBody
    public ResultInfo getSelfAndSonsMark(String userId) {
        if (StringUtils.isEmpty(userId)) {
            return new ResultInfo(0, "请选择一个用户");
        }
        return userService.getSelfAndSonsMark(userId);
    }

    @PostMapping("mark_delete")
    @ResponseBody
    public ResultInfo deleteMark(@RequestBody Map<String, String> params) {
        String markId=params.get("markId");
        if (StringUtils.isEmpty(markId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return userService.deleteMark(markId);
    }
}
