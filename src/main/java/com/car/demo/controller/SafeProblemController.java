package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.service.SafeProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SafeProblemController { // 提示：controller的作用只是参数判断和请求转发。一般比较简洁

    @Resource
    private SafeProblemService safeProblemService;

    @GetMapping("safeProblems") // todo 改为safe_problems // 一般url里面不使用大写
    @ResponseBody
    public ResultInfo searchByCondition(SafeProblem safeProblem) {
        return safeProblemService.searchByCondition(safeProblem);
    }
}
