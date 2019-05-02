package com.car.demo.controller;

import com.car.demo.entity.Record;
import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.User;
import com.car.demo.service.RecordService;
import org.springframework.stereotype.Controller;


import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("record")
public class RecordController {
    @Resource
    RecordService recordService;

    @GetMapping("relative_records")
    @ResponseBody
    public ResultInfo getRelativeRecords(User user) {
        if (StringUtils.isEmpty(user.getUserId())) {
            return new ResultInfo(0, "请输入用户id");
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
