package com.car.demo.service;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.entity.User;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.transform.Result;
import java.util.List;

public interface SafeProblemService {
    ResultInfo searchByCondition(SafeProblem safeProblem);

    ResultInfo insert(MultipartFile[] myfiles, User user);
}
