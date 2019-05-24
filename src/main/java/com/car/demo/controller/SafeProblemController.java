package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblemForSearch;
import com.car.demo.entity.User;
import com.car.demo.service.SafeProblemService;
import com.car.demo.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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


}
