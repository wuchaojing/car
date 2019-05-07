package com.car.demo.service;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.entity.SafeProblemForSearch;
import com.car.demo.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.util.List;

public interface SafeProblemService {
    ResultInfo searchByCondition(SafeProblemForSearch safeProblemForSearch);

    ResultInfo upload(MultipartFile[] myFiles, User user);

    ResultInfo audit();
}
