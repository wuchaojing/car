package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.entity.SafeProblemForSearch;
import com.car.demo.entity.User;
import com.car.demo.service.SafeProblemService;
import com.car.demo.util.ConstantUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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

    @GetMapping("search_by_condition")
    @ResponseBody
    public ResultInfo searchByCondition(SafeProblemForSearch safeProblemForSearch) {//now only by id or null
        return safeProblemService.searchByCondition(safeProblemForSearch);
    }

    @PostMapping("upload")
    @ResponseBody
    public ResultInfo insert(HttpSession session, MultipartFile[] myfiles) {
        User user = (User) session.getAttribute(ConstantUtil.CLIENT_ID);
        //make sure peaceful run；
        if (user == null) {
            return new ResultInfo(0, "该session获取user对象无效");
        }
        if (StringUtils.isEmpty(user.getUserId())) {
            return new ResultInfo(0, "该用户没有用户Id");
        }
        if (StringUtils.isEmpty(user.getNumber())) {
            return new ResultInfo(0, "该用户没有用户编号");
        }
        if (StringUtils.isEmpty(user.getName())) {
            return new ResultInfo(0, "该用户没有用户名");
        }
        if (myfiles == null || myfiles.length <= 0) {
            return new ResultInfo(0, "请上传excel文件");
        }

        return safeProblemService.insert(myfiles, user);
    }

    @GetMapping("audit")
    @ResponseBody
    public ResultInfo audit() {
        return safeProblemService.audit();
    }


}
