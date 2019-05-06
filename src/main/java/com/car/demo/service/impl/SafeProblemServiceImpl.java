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
import java.util.*;

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
            Record record = new Record(recordId, user.getNumber(), user.getName(), nowSameDate,user.getUserId());
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
            return new ResultInfo(0, "filePath有误："+filePath);
        }
//        if(len==null||len<=0){
//            return new ResultInfo(0,"insert_false",null);
//        }
        return new ResultInfo(1);

    }

    @Override
    public ResultInfo totalAudit() {
        List<Object> result=new ArrayList<>();
        Map<String, Table1Row> table1=new HashMap<>();
        //Map<String,Integer> mapAuditAll=new HashMap<>();
        Map<String,Integer> mapAuditAll_done=new HashMap<>();
        List<AuditAll> auditAlls=safeProblemMapper.searchResponsibleAreaAndNumber();
//        for(AuditAll auditAll:auditAlls){
//            mapAuditAll.put(auditAll.getResponsibleArea(),auditAll.getNumber());//总的
//        }
        List<AuditAll> auditAlls_done=safeProblemMapper.searchResponsibleAreaAndNumberAndCompletionStatusDone();//完成的
        for(AuditAll auditAll:auditAlls_done){
            mapAuditAll_done.put(auditAll.getResponsibleArea(),auditAll.getNumber());
        }
        Integer fenmu=null;
        Integer fenzi=null;
        Table1Row table1Row=null;
        for(AuditAll auditAll:auditAlls){//原来是遍历分子，但是分子可能没有；所以现在遍历分母，分母是0的话，就没有，我就在Table1Row默认是-1.0即没有完成率
            fenmu=auditAll.getNumber();
            fenzi=mapAuditAll_done.get(auditAll.getResponsibleArea());
            table1Row =new Table1Row();
            if(fenmu==null||fenmu==0){
                table1Row.setComptetionRate(-1.0);//-1即因为分母是0
            }else if(fenzi==null||fenzi==0){//分子没有（因为group by是0的不显示），或者是0
                table1Row.setComptetionRate(0.0);
            }else{
                table1Row.setComptetionRate(Double.valueOf(fenzi)/fenmu);
            }
            table1.put(auditAll.getResponsibleArea(),table1Row);
        }
        //表一的柱状部分
        List<Audit1> audit1s=safeProblemMapper.searchResponsibleAreaAndAuditHierarchyAndNumber();
        List<Audit1> familyAudits=null;
        for(Audit1 audit1:audit1s){
            familyAudits=table1.get(audit1.getResponsibleArea()).getAudit1s();
            familyAudits.add(audit1);
        }
        result.add(table1);
        /*表2*/
        List<Table2Row> table2=safeProblemMapper.searchStateJudgementAndNumber();
        result.add(table2);
        /*表3*/
        Map<String,Table3Row> table3=new HashMap<>();
        Table3Row table3Row=null;
        List<Audit3> audit3s=safeProblemMapper.searchProblemClassificationAndRankAndNumber();
        for(Audit3 audit3:audit3s){
            if(table3.get(audit3.getProblemClassification())==null){//第一次是木有的
                table3Row=new Table3Row();
                table3Row.getAudit3s().add(audit3);
                table3.put(audit3.getProblemClassification(),table3Row);
            }else{
                table3.get(audit3.getProblemClassification()).getAudit3s().add(audit3);
            }
        }
        result.add(table3);
        return new ResultInfo(1,result);
    }
}
