package com.car.demo.service.impl;

import com.car.demo.entity.*;
import com.car.demo.mapper.RecordMapper;
import com.car.demo.mapper.SafeProblemMapper;
import com.car.demo.service.SafeProblemService;
import com.car.demo.util.ExcelImageAndWords;
import com.car.demo.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
public class SafeProblemServiceImpl implements SafeProblemService {
    @Resource
    private SafeProblemMapper safeProblemMapper;

    @Resource
    private RecordMapper recordMapper;

    @Override
    public ResultInfo searchByCondition(SafeProblem safeProblem) {
        List<SafeProblem> safeProblems = safeProblemMapper.searchByCondition(safeProblem);
//        if(safeProblems==null||safeProblems.size()==0){
//            return new ResultInfo(1, "no result", null);
//        }
        return new ResultInfo(1, safeProblems);
    }

    @Override
    public ResultInfo insert(MultipartFile[] myfiles, User user) {
        String filePath = null;
        try {
            String uploadPath = "D:/car";
            Date nowSameDate = new Date();//same Date
            //register record begin
            String recordId = MD5Util.str2MD5(UUID.randomUUID().toString());
            Record record = new Record(recordId, user.getNumber(), user.getName(), nowSameDate, user.getUserId());
            recordMapper.insert(record);
            //register record end
            for (MultipartFile myfile : myfiles) {
                if (!myfile.isEmpty()) {
                    //save excel begin
                    String oldName = myfile.getOriginalFilename();
                    UUID uuid = UUID.randomUUID();
                    String newName = uuid.toString() + oldName.substring(oldName.lastIndexOf("."));
                    filePath = uploadPath + "/" + newName;
                    myfile.transferTo(new File(filePath));//io's package file
                    //save excel end
                    List<SafeProblem> safeProblems = ExcelImageAndWords.getDataFromExcel(filePath, nowSameDate, recordId);
                    for (SafeProblem safeProblem : safeProblems) {
                        safeProblemMapper.insert(safeProblem);
                    }
                }
            }
        } catch (IOException e) {
            log.error("IOException: transferTo {} catch wrong", filePath);
            return new ResultInfo(0, "filePath有误：" + filePath);
        }
//        if(len==null||len<=0){
//            return new ResultInfo(0,"insert_false",null);
//        }
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
