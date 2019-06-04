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

    @GetMapping("audit_hierarchy_id")
    public ResultInfo searchAuditHierarchyById(String auditHierarchyId) {
        if(StringUtils.isEmpty(auditHierarchyId)){
            return new ResultInfo(0,"请选择一条");
        }
        return adminService.searchAuditHierarchyById(auditHierarchyId);
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

    @GetMapping("completion_status_id")
    public ResultInfo searchCompletionStatusById(String completionStatusId) {
        if(StringUtils.isEmpty(completionStatusId)){
            return new ResultInfo(0,"请选择一条");
        }
        return adminService.searchCompletionStatusById(completionStatusId);
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

    @GetMapping("problem_classification_id")
    public ResultInfo searchProblemClassificationById(String problemClassificationId) {
        if(StringUtils.isEmpty(problemClassificationId)){
            return new ResultInfo(0,"请选择一条");
        }
        return adminService.searchProblemClassificationById(problemClassificationId);
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

    @GetMapping("rank_id")
    public ResultInfo searchRankById(String rankId) {
        if(StringUtils.isEmpty(rankId)){
            return new ResultInfo(0,"请选择一条");
        }
        return adminService.searchRankById(rankId);
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

    @GetMapping("state_judgement_id")
    public ResultInfo searchStateJudgementById(String stateJudgementId) {
        if(StringUtils.isEmpty(stateJudgementId)){
            return new ResultInfo(0,"请选择一条");
        }
        return adminService.searchStateJudgementById(stateJudgementId);
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

    @GetMapping("subdivision_type")
    public ResultInfo searchSubdivisionType(String problemClassificationId) {
        if(StringUtils.isEmpty(problemClassificationId)){
            return new ResultInfo(0, "需先选定一个问题分类");
        }
        return adminService.searchSubdivisionType(problemClassificationId);
    }

    @GetMapping("subdivision_type_id")
    public ResultInfo searchSubdivisionTypeById(String subdivisionTypeId) {
        if(StringUtils.isEmpty(subdivisionTypeId)){
            return new ResultInfo(0,"请选择一条");
        }
        return adminService.searchSubdivisionTypeById(subdivisionTypeId);
    }

    @PostMapping("subdivision_type_insert")
    public ResultInfo insertSubdivisionType(String subdivisionTypeName,String problemClassificationId) {
        if (StringUtils.isEmpty(subdivisionTypeName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        if(StringUtils.isEmpty(problemClassificationId)){
            return new ResultInfo(0, "需先选定一个问题分类");
        }
        return adminService.insertSubdivisionType(subdivisionTypeName,problemClassificationId);
    }

    @PostMapping("subdivision_type_update")
    public ResultInfo updateSubdivisionType(String subdivisionTypeId, String subdivisionTypeName) {
        if (StringUtils.isEmpty(subdivisionTypeId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        if (StringUtils.isEmpty(subdivisionTypeName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateSubdivisionType(subdivisionTypeId, subdivisionTypeName);
    }

    @PostMapping("subdivision_type_delete")
    public ResultInfo deleteSubdivisionType(String subdivisionTypeId) {
        if (StringUtils.isEmpty(subdivisionTypeId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return adminService.deleteSubdivisionType(subdivisionTypeId);
    }
    //=====================================================================6

    @GetMapping("responsible_area")
    public ResultInfo searchResponsibleArea() {
        return adminService.searchResponsibleArea();
    }

    @GetMapping("responsible_area_id")
    public ResultInfo searchResponsibleAreaById(String responsibleAreaId) {
        if(StringUtils.isEmpty(responsibleAreaId)){
            return new ResultInfo(0,"请选择一条");
        }
        return adminService.searchResponsibleAreaById(responsibleAreaId);
    }

    @PostMapping("responsible_area_insert")
    public ResultInfo insertResponsibleArea(String responsibleAreaName) {
        if (StringUtils.isEmpty(responsibleAreaName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertResponsibleArea(responsibleAreaName);
    }

    @PostMapping("responsible_area_update")
    public ResultInfo updateResponsibleArea(String responsibleAreaId, String responsibleAreaName) {
        if (StringUtils.isEmpty(responsibleAreaId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        if (StringUtils.isEmpty(responsibleAreaName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateResponsibleArea(responsibleAreaId, responsibleAreaName);
    }

    @PostMapping("responsible_area_delete")
    public ResultInfo deleteResponsibleArea(String responsibleAreaId) {
        if (StringUtils.isEmpty(responsibleAreaId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return adminService.deleteResponsibleArea(responsibleAreaId);
    }
    //=====================================================================7
}
