package com.car.demo.service.impl;

import com.car.demo.entity.*;
import com.car.demo.mapper.RecordMapper;
import com.car.demo.mapper.SafeProblemMapper;
import com.car.demo.service.SafeProblemService;
import com.car.demo.util.*;
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
        SafeProblemForSearch safeProblemForSearch = new SafeProblemForSearch();
        //获取当前月第一天：
        safeProblemForSearch.setStartTime(CalendarUtil.getFirstDayofThisMonth());
        //获取当前月最后一天
        safeProblemForSearch.setEndTime(CalendarUtil.getLastDayofThisMonth());
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

                    myFile.transferTo(new File(filePath));

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
        } catch (Exception e) {
            log.error("transferTo {} catch wrong", filePath, e);
            return new ResultInfo(0, "上传失败，请重试");
        }

        return new ResultInfo(1);
    }

    @Override
    public ResultInfo audit() {

        SafeProblemForSearch safeProblemForSearch = new SafeProblemForSearch();//为了日期
        //获取当前月第一天：
        Date first = CalendarUtil.getFirstDayofThisMonth();
        //获取当前月最后一天
        Date end = CalendarUtil.getLastDayofThisMonth();
        safeProblemForSearch.setStartTime(first);
        safeProblemForSearch.setEndTime(end);
        List<Map<String, Object>> hierarchy = safeProblemMapper.searchHierarchy(safeProblemForSearch);
        List<Map<String, Object>> hierarchyCompleteRatio = safeProblemMapper.searchFloorCompleteRatio(safeProblemForSearch);
        List<Map<String, Object>> problemType = safeProblemMapper.searchProblemType(safeProblemForSearch);
        List<Map<String, Object>> companyAudit = safeProblemMapper.searchCompanyAudit(safeProblemForSearch);
        AuditData auditData = new AuditData(hierarchy, hierarchyCompleteRatio, problemType, companyAudit);
        List<Map<String, Object>> companyAuditNew = safeProblemMapper.searchCompanyAuditByMonth(safeProblemForSearch);
        List<Map<String, Object>> audit = safeProblemMapper.searchAuditByMonth(safeProblemForSearch);
        List<Map<String, Object>> companyProblemType = safeProblemMapper.searchCompanyProblemTypeByMonth(safeProblemForSearch);
        //AuditData auditData = new AuditData(hierarchy, hierarchyCompleteRatio, problemType, companyAudit);
        AuditDataNew auditDataNew = new AuditDataNew(companyAuditNew, audit, companyProblemType);
        AuditTotal auditTotal = new AuditTotal(auditData, auditDataNew);
        return new ResultInfo(1, auditTotal);

    }

    @Override
    public ResultInfo audit(Integer year, Integer month) {

        SafeProblemForSearch safeProblemForSearch = new SafeProblemForSearch();//为了日期
        //获取指定月第一天：
        Date first = CalendarUtil.getFisrtDayOfMonth(year, month);
        //获取指定月最后一天
        Date end = CalendarUtil.getLastDayOfMonth(year, month);
        safeProblemForSearch.setStartTime(first);
        safeProblemForSearch.setEndTime(end);
        List<Map<String, Object>> hierarchy = safeProblemMapper.searchHierarchy(safeProblemForSearch);
        List<Map<String, Object>> hierarchyCompleteRatio = safeProblemMapper.searchFloorCompleteRatio(safeProblemForSearch);
        List<Map<String, Object>> problemType = safeProblemMapper.searchProblemType(safeProblemForSearch);
        List<Map<String, Object>> companyAudit = safeProblemMapper.searchCompanyAudit(safeProblemForSearch);
        AuditData auditData = new AuditData(hierarchy, hierarchyCompleteRatio, problemType, companyAudit);
        List<Map<String, Object>> companyAuditNew = safeProblemMapper.searchCompanyAuditByMonth(safeProblemForSearch);
        List<Map<String, Object>> audit = safeProblemMapper.searchAuditByMonth(safeProblemForSearch);
        List<Map<String, Object>> companyProblemType = safeProblemMapper.searchCompanyProblemTypeByMonth(safeProblemForSearch);
        AuditDataNew auditDataNew = new AuditDataNew(companyAuditNew, audit, companyProblemType);
        AuditTotal auditTotal = new AuditTotal(auditData, auditDataNew);
        return new ResultInfo(1, auditTotal);
    }

    public ResultInfo update(SafeProblem safeProblem) {
        //判断是否是完成，或者 n/m (n==m)
        if (Others.isCompletion(safeProblem.getCompletionStatus())) {
            safeProblem.setIsCompletion(1);
        } else {
            safeProblem.setIsCompletion(0);
        }
        safeProblemMapper.update(safeProblem);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo searchById(String problemId) {
        SafeProblem safeProblem = safeProblemMapper.searchById(problemId);
        return new ResultInfo(1, safeProblem);
    }
}
