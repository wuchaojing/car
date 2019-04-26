package com.car.demo.controller;

import com.car.demo.entity.Json;
import com.car.demo.service.SafeProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("safeProblem")
public class SafeProblemController {
    @Resource
    private SafeProblemService safeProblemService;
    @RequestMapping("selectAll")
    @ResponseBody
    public Json addExcel()
    {
        Json js=new Json();
        js.setMsg("成功");
        js.setSuccess(true);
        js.setData(safeProblemService.searchAll());
        return js;
    }
}
