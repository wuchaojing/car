package com.car.demo.service;

import com.car.demo.entity.SafeProblem;

import java.util.List;

public interface SafeProblemService {
    List<SafeProblem> searchByCondition(SafeProblem safeProblem);
}
