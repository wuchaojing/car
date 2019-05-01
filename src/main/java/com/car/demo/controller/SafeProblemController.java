package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.service.SafeProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
public class SafeProblemController {

    @Resource
    private SafeProblemService safeProblemService;

    @GetMapping("safe_problems")
    @ResponseBody
    public ResultInfo searchByCondition(SafeProblem safeProblem) {//now only by id
        return safeProblemService.searchByCondition(safeProblem);
    }

    @PostMapping("safe_problems")
    @ResponseBody
    public ResultInfo insert(MultipartFile[] myfiles) {
        return safeProblemService.insert(myfiles);
    }
}
