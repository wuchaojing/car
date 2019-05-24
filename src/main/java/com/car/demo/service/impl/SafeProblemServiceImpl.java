package com.car.demo.service.impl;

import com.car.demo.entity.*;
import com.car.demo.mapper.RecordMapper;
import com.car.demo.mapper.SafeProblemMapper;
import com.car.demo.service.SafeProblemService;
import com.car.demo.util.ConstantUtil;
import com.car.demo.util.ExcelImageAndWords;
import com.car.demo.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class SafeProblemServiceImpl implements SafeProblemService {
    @Resource
    private SafeProblemMapper safeProblemMapper;

    @Resource
    private RecordMapper recordMapper;

    @Override
    public ResultInfo searchByCondition(SafeProblemForSearch safeProblemForSearch) {
        List<SafeProblem> safeProblems = safeProblemMapper.searchByCondition(safeProblemForSearch);

        return new ResultInfo(1, safeProblems);
    }

    @Override
    public ResultInfo searchByThisMonth() {
        SafeProblemForSearch safeProblemForSearch=new SafeProblemForSearch();
        //获取当前月第一天：
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, 0);
        c.set(Calendar.DAY_OF_MONTH, 1);//设置为1号,当前日期既为本月第一天
        safeProblemForSearch.setStartTime(c.getTime());
        //获取当前月最后一天
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        safeProblemForSearch.setEndTime(ca.getTime());
        List<SafeProblem> safeProblems = safeProblemMapper.searchByThisMonth(safeProblemForSearch);
        return new ResultInfo(1, safeProblems);
    }

    @Override
    public ResultInfo upload(MultipartFile[] myFiles, User user) {
        String filePath = null;
        try {
            String uploadPath = ConstantUtil.UPLOAD_PATH;
            Date nowSameDate = new Date();//same Date

            String recordId = MD5Util.str2MD5(UUID.randomUUID().toString());


            for (MultipartFile myFile : myFiles) {
                if (!myFile.isEmpty()) {

                    String oldName = myFile.getOriginalFilename();
                    UUID uuid = UUID.randomUUID();
                    String newName = uuid.toString() + oldName.substring(oldName.lastIndexOf("."));

                    filePath = uploadPath + "/" + newName;

                    myFile.transferTo(new File(filePath));//io's package file

                    List<SafeProblem> safeProblems = ExcelImageAndWords.getDataFromExcel(filePath, nowSameDate, recordId);

                    if (null == safeProblems) {
                        return new ResultInfo(0, "上传失败，请检查文件是否规范");
                    }

                    for (SafeProblem safeProblem : safeProblems) {
                        safeProblemMapper.insert(safeProblem);
                    }
                    Record record = new Record(recordId, user.getNumber(), user.getName(), nowSameDate, user.getUserId());
                    recordMapper.insert(record);
                }
            }
        } catch (IOException e) {
            log.error("transferTo {} catch wrong", filePath, e);
            return new ResultInfo(0, "上传失败，请重试");
        }

        return new ResultInfo(1);
    }

    @Override
    public ResultInfo audit() {
        List<Map<String, Object>> hierarchy = safeProblemMapper.searchHierarchy();

        List<Map<String, Object>> hierarchyCompleteRatio = safeProblemMapper.searchFloorCompleteRatio();

        List<Map<String, Object>> problemType = safeProblemMapper.searchProblemType();

        List<Map<String, Object>> companyAudit = safeProblemMapper.searchCompanyAudit();

        AuditData auditData = new AuditData(hierarchy, hierarchyCompleteRatio, problemType, companyAudit);

        return new ResultInfo(1, auditData);

    }
}
