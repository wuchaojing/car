package com.car.demo.controller;

import com.car.demo.entity.Record;
import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblemForSearch;
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
        User user = (User) session.getAttribute(ConstantUtil.CLIENT_ID);
        if (user == null) {
            return new ResultInfo(0, "用户未登录");
        }
        return recordService.getRelativeRecords(user);
    }



    @GetMapping("safe_problems_batch")
    @ResponseBody
    public ResultInfo getSafeProblemByRecordIds(String recordIds) {//格式 '','',''
        if (StringUtils.isEmpty(recordIds)) {
            return new ResultInfo(0, "请至少选择一条提交记录");
        }
        return recordService.getSafeProblemByRecordIds(recordIds);
    }

    @GetMapping("safe_problems_batch_search")
    @ResponseBody
    public ResultInfo getSafeProblemByRecordIdsAndCondition(String recordIds, SafeProblemForSearch safeProblemForSearch) {//格式 '','',''  另外加上了查询
        if (StringUtils.isEmpty(recordIds)) {
            return new ResultInfo(0, "请至少选择一条提交记录");
        }
        return recordService.getSafeProblemByRecordIdsAndCondition(recordIds, safeProblemForSearch);
    }
}
