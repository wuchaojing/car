package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.entity.User;
import com.car.demo.service.SafeProblemService;
import com.car.demo.util.StringIsNullorEmpty;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@Controller
@RequestMapping("safe_problem")
public class SafeProblemController {

    @Resource
    private SafeProblemService safeProblemService;

    @GetMapping("search_by_condition")
    @ResponseBody
    public ResultInfo searchByCondition(SafeProblem safeProblem) {//now only by id or null
        return safeProblemService.searchByCondition(safeProblem);
    }

    @PostMapping("insert_file_and_user")
    @ResponseBody
    public ResultInfo insert(MultipartFile[] myfiles, User user) {
        if(myfiles==null||user==null|| StringIsNullorEmpty.check(user.getNumber(),user.getName())){
            return new ResultInfo(0,"插入的数据不合法",null);
        }
        return safeProblemService.insert(myfiles,user);
    }
}
