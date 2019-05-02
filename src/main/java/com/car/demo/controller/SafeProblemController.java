package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.entity.User;
import com.car.demo.service.SafeProblemService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
//        if(myfiles==null||user==null|| StringsHasNullorEmpty.check(user.getNumber(),user.getName())){
//            return new ResultInfo(0,"插入的数据不合法",null);
//        }
        if (myfiles.length <= 0) {
            return new ResultInfo(0, "请上传excel文件");
        }
        if (StringUtils.isEmpty(user.getNumber())) {
            return new ResultInfo(0, "请输入用户编号");
        }
        if (StringUtils.isEmpty(user.getName())) {
            return new ResultInfo(0, "请输入用户名");
        }
        return safeProblemService.insert(myfiles, user);
    }
}
