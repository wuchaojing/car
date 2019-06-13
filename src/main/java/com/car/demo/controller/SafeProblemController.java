package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.entity.SafeProblemForSearch;
import com.car.demo.entity.User;
import com.car.demo.service.SafeProblemService;
import com.car.demo.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("safe_problem")
public class SafeProblemController {

    @Resource
    private SafeProblemService safeProblemService;

    @GetMapping("search")
    @ResponseBody
    public ResultInfo searchByCondition(SafeProblemForSearch safeProblemForSearch) {//now only by id or null
        return safeProblemService.searchByCondition(safeProblemForSearch);
    }

    @GetMapping("search_this_month")
    @ResponseBody
    public ResultInfo searchByThisMonth() {
        return safeProblemService.searchByThisMonth();
    }

    @PostMapping("upload")
    @ResponseBody
    public ResultInfo insert(HttpSession session, MultipartFile[] myFiles) {
        User user = (User) session.getAttribute(ConstantUtil.CLIENT_ID);
        //make sure peaceful run；
        if (user == null) {
            return new ResultInfo(0, "用户未登录");
        }
        if (myFiles == null || myFiles.length <= 0) {
            return new ResultInfo(0, "请上传excel文件");
        }

        return safeProblemService.upload(myFiles, user);
    }

    @GetMapping("audit")
    @ResponseBody
    public ResultInfo audit() {
        return safeProblemService.audit();
    }

    @GetMapping("audit_year_month")
    @ResponseBody
    public ResultInfo audit(Integer year, Integer month) {//前端传来需要保证是数字
        if (year == null) {
            return new ResultInfo(0, "请输入具体的年");
        }
        if (month == null) {
            return new ResultInfo(0, "请输入具体的月");
        }

        if (month > 12 || month < 1) {
            return new ResultInfo(0, "输入的月不符合规范");
        }

        return safeProblemService.audit(year, month);
    }

    @PostMapping("update")
    @ResponseBody
    public ResultInfo update(@RequestBody SafeProblem safeProblem) {
        return safeProblemService.update(safeProblem);
    }

    @GetMapping("search_one")
    @ResponseBody
    public ResultInfo searchById(String problemId) {
        if (StringUtils.isEmpty(problemId)) {
            return new ResultInfo(0, "请选择一条要修改的报表");
        }
        return safeProblemService.searchById(problemId);
    }

}
