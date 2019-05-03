package com.car.demo.controller;

import com.car.demo.entity.Record;
import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.service.RecordService;
import com.car.demo.util.ConstantUtil;
import org.springframework.stereotype.Controller;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("record")
public class RecordController {
    @Resource
    private RecordService recordService;

    @GetMapping("relative_records")
    @ResponseBody
    public ResultInfo getRelativeRecords(HttpSession session) {
        User user=(User)session.getAttribute(ConstantUtil.CLIENT_ID);
        if(user==null){
            return new ResultInfo(0, "该session获取user对象无效");
        }
        if (StringUtils.isEmpty(user.getUserId())) {//（虽然先拦截，登录了必定有user），这样更安全一些
            return new ResultInfo(0, "从session获取用户id无效");
        }
        return recordService.getRelativeRecords(user);
    }

    @GetMapping("safe_problems")
    @ResponseBody
    public ResultInfo getSafeProblemByRecordId(Record record) {
        if(StringUtils.isEmpty(record.getRecordId())){
            return new ResultInfo(0, "请输入recordId");
        }
        return recordService.getSafeProblemByRecordId(record);
    }
}
