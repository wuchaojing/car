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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
//        Integer countRankA=safeProblemMapper.countRankByResponsibleArea("A","涂装车间");
//        Integer countRankB=safeProblemMapper.countRankByResponsibleArea("B","涂装车间");//这一行测试通过了
//        Integer countRankC=safeProblemMapper.countRankByResponsibleArea("C","涂装车间");
//        Double done=(double)safeProblemMapper.completionStatusIsDone("涂装车间");//这一行测试通过了//这个地方错了，应该是重复率，我一开始写成完成率了
//        Integer all=safeProblemMapper.completionStatusAll("涂装车间");//这一行测试通过了
//        TotalAudit totalAudit=new TotalAudit("涂装车间",countRankA,countRankB,countRankC,done/all);
//        return new ResultInfo(1,totalAudit);
        String responsibleAreas[]=new String[]{"冲压","车身车间","涂装车间","总装","发动机车间","维修车间","采购","质量科"};
        List<TotalAudit> totalAudits=new ArrayList<>();
        Integer countRankA=null;
        Integer countRankB=null;
        Integer countRankC=null;
        Double isRepeat=null;
        Integer all=null;
        String repetitionRate=null;
        for(String responsibleArea:responsibleAreas){
            countRankA=safeProblemMapper.countRankByResponsibleArea("A",responsibleArea);
            countRankB=safeProblemMapper.countRankByResponsibleArea("B",responsibleArea);
            countRankC=safeProblemMapper.countRankByResponsibleArea("C",responsibleArea);
            isRepeat=(double)safeProblemMapper.completionStatusisRepeat(responsibleArea);
            all=safeProblemMapper.completionStatusAll(responsibleArea);
            if(all!=0){
                repetitionRate=isRepeat/all+"";
            }else{
                repetitionRate="不存在（因为总数为0）";
            }
            TotalAudit totalAudit=new TotalAudit(responsibleArea,countRankA,countRankB,countRankC,repetitionRate);
            totalAudits.add(totalAudit);
        }
        return new ResultInfo(1,totalAudits);
    }
}
