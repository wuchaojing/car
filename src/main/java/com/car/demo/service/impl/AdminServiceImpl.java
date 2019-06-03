package com.car.demo.service.impl;

import com.car.demo.entity.ResultInfo;
import com.car.demo.mapper.AdminMapper;
import com.car.demo.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public ResultInfo searchAuditHierarchy() {
        List<String> list = adminMapper.searchAuditHierarchy();
        return new ResultInfo(1, list);
    }

    @Override
    public ResultInfo insertAuditHierarchy(String auditHierarchyName) {
        adminMapper.insertAuditHierarchy(UUID.randomUUID().toString(), auditHierarchyName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo updateAuditHierarchy(String auditHierarchyId, String auditHierarchyName) {
        adminMapper.updateAuditHierarchy(auditHierarchyId, auditHierarchyName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo deleteAuditHierarchy(String auditHierarchyId) {
        adminMapper.deleteAuditHierarchy(auditHierarchyId);
        return new ResultInfo(1);
    }
    //=====================================================================1

    @Override
    public ResultInfo searchCompletionStatus() {
        List<String> list = adminMapper.searchCompletionStatus();
        return new ResultInfo(1, list);
    }

    @Override
    public ResultInfo insertCompletionStatus(String completionStatusName) {
        adminMapper.insertCompletionStatus(UUID.randomUUID().toString(), completionStatusName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo updateCompletionStatus(String completionStatusId, String completionStatusName) {
        adminMapper.updateCompletionStatus(completionStatusId, completionStatusName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo deleteCompletionStatus(String completionStatusId) {
        adminMapper.deleteCompletionStatus(completionStatusId);
        return new ResultInfo(1);
    }
    //=====================================================================2

    @Override
    public ResultInfo searchProblemClassification() {
        List<String> list = adminMapper.searchProblemClassification();
        return new ResultInfo(1, list);
    }

    @Override
    public ResultInfo insertProblemClassification(String problemClassificationName) {
        adminMapper.insertProblemClassification(UUID.randomUUID().toString(), problemClassificationName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo updateProblemClassification(String problemClassificationId, String problemClassificationName) {
        adminMapper.updateProblemClassification(problemClassificationId, problemClassificationName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo deleteProblemClassification(String problemClassificationId) {
        adminMapper.deleteProblemClassification(problemClassificationId);
        return new ResultInfo(1);
    }
    //=====================================================================3

    @Override
    public ResultInfo searchRank() {
        List<String> list = adminMapper.searchRank();
        return new ResultInfo(1, list);
    }

    @Override
    public ResultInfo insertRank(String rankName) {
        adminMapper.insertRank(UUID.randomUUID().toString(), rankName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo updateRank(String rankId, String rankName) {
        adminMapper.updateRank(rankId, rankName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo deleteRank(String rankId) {
        adminMapper.deleteRank(rankId);
        return new ResultInfo(1);
    }
    //=====================================================================4

    @Override
    public ResultInfo searchStateJudgement() {
        List<String> list = adminMapper.searchStateJudgement();
        return new ResultInfo(1, list);
    }

    @Override
    public ResultInfo insertStateJudgement(String stateJudgementName) {
        adminMapper.insertStateJudgement(UUID.randomUUID().toString(), stateJudgementName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo updateStateJudgement(String stateJudgementId, String stateJudgementName) {
        adminMapper.updateStateJudgement(stateJudgementId, stateJudgementName);
        return new ResultInfo(1);
    }

    @Override
    public ResultInfo deleteStateJudgement(String stateJudgementId) {
        adminMapper.deleteStateJudgement(stateJudgementId);
        return new ResultInfo(1);
    }
    //=====================================================================5
}
