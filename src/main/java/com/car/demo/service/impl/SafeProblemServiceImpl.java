package com.car.demo.service.impl;

import com.car.demo.entity.ResultInfo;
import com.car.demo.entity.SafeProblem;
import com.car.demo.mapper.SafeProblemMapper;
import com.car.demo.service.SafeProblemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SafeProblemServiceImpl implements SafeProblemService {
    @Resource
    private SafeProblemMapper safeProblemMapper;

    @Override
    public ResultInfo searchByCondition(SafeProblem safeProblem) {
//        return safeProblemMapper.searchByCondition(safeProblem);
        List<SafeProblem> safeProblems = safeProblemMapper.searchByCondition(safeProblem);

        return new ResultInfo(true, "success", safeProblems);

    }
}
