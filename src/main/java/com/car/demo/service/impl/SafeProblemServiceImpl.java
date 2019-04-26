package com.car.demo.service.impl;

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
    public List<SafeProblem> searchAll(SafeProblem safeProblem) {
        return safeProblemMapper.searchAll(safeProblem);
    }
}
