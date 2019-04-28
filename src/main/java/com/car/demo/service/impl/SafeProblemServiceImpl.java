package com.car.demo.service.impl;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.mapper.SafeProblemMapper;
import com.car.demo.service.SafeProblemService;
import com.car.demo.util.ExcelImageAndWords;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class SafeProblemServiceImpl implements SafeProblemService {
    @Resource
    private SafeProblemMapper safeProblemMapper;

    @Override
    public ResultInfo searchByCondition(SafeProblem safeProblem) {
        List<SafeProblem> safeProblems = safeProblemMapper.searchByCondition(safeProblem);
        return new ResultInfo(1, "success", safeProblems);
    }

    @Override
    public ResultInfo insert(MultipartFile[] myfiles) {
        int len=0;
        try {
            String uploadPath = "D:/car";
            for (MultipartFile myfile : myfiles) {
                if (!myfile.isEmpty()) {
                    String oldName = myfile.getOriginalFilename();
                    UUID uuid = UUID.randomUUID();
                    String newName = uuid.toString() + oldName.substring(oldName.lastIndexOf("."));
                    //io包下的file
                    myfile.transferTo(new File(uploadPath + "/" + newName));
                    List<SafeProblem> safeProblems=ExcelImageAndWords.getDataFromExcel(uploadPath + "/" + newName);
                    for(SafeProblem safeProblem:safeProblems){
                        len+=safeProblemMapper.insert(safeProblem);
                    }
                }
            }
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Integer n=safeProblemMapper.insert(safeProblem);
        return new ResultInfo(1,"success",len);
    }
}
