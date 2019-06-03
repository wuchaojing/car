package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.service.AdminService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Resource
    private AdminService adminService;

    @GetMapping("audit_hierarchy")
    public ResultInfo searchAuditHierarchy() {
        return adminService.searchAuditHierarchy();
    }

    @PostMapping("audit_hierarchy_insert")
    public ResultInfo insertAuditHierarchy(String auditHierarchyName) {
        if (StringUtils.isEmpty(auditHierarchyName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertAuditHierarchy(auditHierarchyName);
    }

    @PostMapping("audit_hierarchy_update")
    public ResultInfo updateAuditHierarchy(String auditHierarchyId, String auditHierarchyName) {
        if (StringUtils.isEmpty(auditHierarchyId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        if (StringUtils.isEmpty(auditHierarchyName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateAuditHierarchy(auditHierarchyId, auditHierarchyName);
    }

    @PostMapping("audit_hierarchy_delete")
    public ResultInfo deleteAuditHierarchy(String auditHierarchyId) {
        if (StringUtils.isEmpty(auditHierarchyId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return adminService.deleteAuditHierarchy(auditHierarchyId);
    }
    //=====================================================================1

    @GetMapping("completion_status")
    public ResultInfo searchCompletionStatus() {
        return adminService.searchCompletionStatus();
    }

    @PostMapping("completion_status_insert")
    public ResultInfo insertCompletionStatus(String completionStatusName) {
        if (StringUtils.isEmpty(completionStatusName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertCompletionStatus(completionStatusName);
    }

    @PostMapping("completion_status_update")
    public ResultInfo updateCompletionStatus(String completionStatusId, String completionStatusName) {
        if (StringUtils.isEmpty(completionStatusId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        if (StringUtils.isEmpty(completionStatusName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateCompletionStatus(completionStatusId, completionStatusName);
    }

    @PostMapping("completion_status_delete")
    public ResultInfo deleteCompletionStatus(String completionStatusId) {
        if (StringUtils.isEmpty(completionStatusId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return adminService.deleteCompletionStatus(completionStatusId);
    }
    //=====================================================================2

    @GetMapping("problem_classification")
    public ResultInfo searchProblemClassification() {
        return adminService.searchProblemClassification();
    }

    @PostMapping("problem_classification_insert")
    public ResultInfo insertProblemClassification(String problemClassificationName) {
        if (StringUtils.isEmpty(problemClassificationName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertProblemClassification(problemClassificationName);
    }

    @PostMapping("problem_classification_update")
    public ResultInfo updateProblemClassification(String problemClassificationId, String problemClassificationName) {
        if (StringUtils.isEmpty(problemClassificationId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        if (StringUtils.isEmpty(problemClassificationName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateProblemClassification(problemClassificationId, problemClassificationName);
    }

    @PostMapping("problem_classification_delete")
    public ResultInfo deleteProblemClassification(String problemClassificationId) {
        if (StringUtils.isEmpty(problemClassificationId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return adminService.deleteProblemClassification(problemClassificationId);
    }
    //=====================================================================3

    @GetMapping("rank")
    public ResultInfo searchRank() {
        return adminService.searchRank();
    }

    @PostMapping("rank_insert")
    public ResultInfo insertRank(String rankName) {
        if (StringUtils.isEmpty(rankName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertRank(rankName);
    }

    @PostMapping("rank_update")
    public ResultInfo updateRank(String rankId, String rankName) {
        if (StringUtils.isEmpty(rankId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        if (StringUtils.isEmpty(rankName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateRank(rankId, rankName);
    }

    @PostMapping("rank_delete")
    public ResultInfo deleteRank(String rankId) {
        if (StringUtils.isEmpty(rankId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return adminService.deleteRank(rankId);
    }
    //=====================================================================4

    @GetMapping("state_judgement")
    public ResultInfo searchStateJudgement() {
        return adminService.searchStateJudgement();
    }

    @PostMapping("state_judgement_insert")
    public ResultInfo insertStateJudgement(String stateJudgementName) {
        if (StringUtils.isEmpty(stateJudgementName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertStateJudgement(stateJudgementName);
    }

    @PostMapping("state_judgement_update")
    public ResultInfo updateStateJudgement(String stateJudgementId, String stateJudgementName) {
        if (StringUtils.isEmpty(stateJudgementId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        if (StringUtils.isEmpty(stateJudgementName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateStateJudgement(stateJudgementId, stateJudgementName);
    }

    @PostMapping("state_judgement_delete")
    public ResultInfo deleteStateJudgement(String stateJudgementId) {
        if (StringUtils.isEmpty(stateJudgementId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return adminService.deleteStateJudgement(stateJudgementId);
    }
    //=====================================================================5
}
