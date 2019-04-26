package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.service.SafeProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SafeProblemController {

    @Resource
    private SafeProblemService safeProblemService;

    @GetMapping("safe_problems")
    @ResponseBody
    public ResultInfo searchByCondition(SafeProblem safeProblem) {
        return safeProblemService.searchByCondition(safeProblem);
    }
}
