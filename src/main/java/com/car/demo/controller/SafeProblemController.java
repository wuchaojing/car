package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.service.SafeProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class SafeProblemController {
    @Resource
    private SafeProblemService safeProblemService;

    @GetMapping("safeProblems")
    @ResponseBody
    public ResultInfo searchByCondition(SafeProblem safeProblem)
    {
        ResultInfo js=new ResultInfo();
        try{
            js.setData(safeProblemService.searchByCondition(safeProblem));
            js.setMsg("成功");
            js.setSuccess(true);
        }catch (Exception e){
            js.setMsg("查询出错");//--
            js.setSuccess(false);
        }
        return js;
    }
}
