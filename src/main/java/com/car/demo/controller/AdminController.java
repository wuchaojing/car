package com.car.demo.controller;

import com.car.demo.entity.ResultInfo;
import com.car.demo.service.AdminService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

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
    public ResultInfo searchAuditHierarchyById(@RequestBody Map<String, String> params) {
        String auditHierarchyId=params.get("auditHierarchyId");
        if (StringUtils.isEmpty(auditHierarchyId)) {
            return new ResultInfo(0, "请选择一条");
        }
        return adminService.searchAuditHierarchyById(auditHierarchyId);
    }

    @PostMapping("audit_hierarchy_insert")
    public ResultInfo insertAuditHierarchy(@RequestBody Map<String, String> params) {
        String auditHierarchyName=params.get("aurditHierachyName");
        if (StringUtils.isEmpty(auditHierarchyName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertAuditHierarchy(auditHierarchyName);
    }

    @PostMapping("audit_hierarchy_update")
    public ResultInfo updateAuditHierarchy(@RequestBody Map<String, String> params) {
        String auditHierarchyId=params.get("auditHierarchyId");
        if (StringUtils.isEmpty(auditHierarchyId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        String auditHierarchyName=params.get("auditHierarchyName");
        if (StringUtils.isEmpty(auditHierarchyName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateAuditHierarchy(auditHierarchyId, auditHierarchyName);
    }

    @PostMapping("audit_hierarchy_delete")
    public ResultInfo deleteAuditHierarchy(@RequestBody Map<String, String> params) {
        String auditHierarchyId=params.get("auditHierarchyId");
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
    public ResultInfo searchCompletionStatusById(@RequestBody Map<String, String> params) {
        String completionStatusId=params.get("completionStatusId");
        if (StringUtils.isEmpty(completionStatusId)) {
            return new ResultInfo(0, "请选择一条");
        }
        return adminService.searchCompletionStatusById(completionStatusId);
    }

    @PostMapping("completion_status_insert")
    public ResultInfo insertCompletionStatus(@RequestBody Map<String, String> params) {
        String completionStatusName=params.get("completionStatusName");
        if (StringUtils.isEmpty(completionStatusName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertCompletionStatus(completionStatusName);
    }

    @PostMapping("completion_status_update")
    public ResultInfo updateCompletionStatus(@RequestBody Map<String, String> params) {
        String completionStatusId=params.get("completionStatusId");
        if (StringUtils.isEmpty(completionStatusId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        String completionStatusName=params.get("completionStatusName");
        if (StringUtils.isEmpty(completionStatusName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateCompletionStatus(completionStatusId, completionStatusName);
    }

    @PostMapping("completion_status_delete")
    public ResultInfo deleteCompletionStatus(@RequestBody Map<String, String> params) {
        String completionStatusId=params.get("completionStatusId");
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
    public ResultInfo searchProblemClassificationById(@RequestBody Map<String, String> params) {
        String problemClassificationId=params.get("problemClassificationId");
        if (StringUtils.isEmpty(problemClassificationId)) {
            return new ResultInfo(0, "请选择一条");
        }
        return adminService.searchProblemClassificationById(problemClassificationId);
    }

    @PostMapping("problem_classification_insert")
    public ResultInfo insertProblemClassification(@RequestBody Map<String, String> params) {
        String problemClassificationName=params.get("problemClassificationName");
        if (StringUtils.isEmpty(problemClassificationName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertProblemClassification(problemClassificationName);
    }

    @PostMapping("problem_classification_update")
    public ResultInfo updateProblemClassification(@RequestBody Map<String, String> params) {
        String problemClassificationId=params.get("problemClassificationId");
        if (StringUtils.isEmpty(problemClassificationId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        String problemClassificationName=params.get("problemClassificationName");
        if (StringUtils.isEmpty(problemClassificationName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateProblemClassification(problemClassificationId, problemClassificationName);
    }

    @PostMapping("problem_classification_delete")
    public ResultInfo deleteProblemClassification(@RequestBody Map<String, String> params) {
        String problemClassificationId=params.get("problemClassificationId");
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
    public ResultInfo searchRankById(@RequestBody Map<String, String> params) {
        String rankId=params.get("rankId");
        if (StringUtils.isEmpty(rankId)) {
            return new ResultInfo(0, "请选择一条");
        }
        return adminService.searchRankById(rankId);
    }

    @PostMapping("rank_insert")
    public ResultInfo insertRank(@RequestBody Map<String, String> params) {
        String rankName=params.get("rankName");
        if (StringUtils.isEmpty(rankName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertRank(rankName);
    }

    @PostMapping("rank_update")
    public ResultInfo updateRank(@RequestBody Map<String, String> params) {
        String rankId=params.get("rankId");
        if (StringUtils.isEmpty(rankId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        String rankName=params.get("rankName");
        if (StringUtils.isEmpty(rankName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateRank(rankId, rankName);
    }

    @PostMapping("rank_delete")
    public ResultInfo deleteRank(@RequestBody Map<String, String> params) {
        String rankId=params.get("rankId");
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
    public ResultInfo searchStateJudgementById(@RequestBody Map<String, String> params) {
        String stateJudgementId=params.get("stateJudgementId");
        if (StringUtils.isEmpty(stateJudgementId)) {
            return new ResultInfo(0, "请选择一条");
        }
        return adminService.searchStateJudgementById(stateJudgementId);
    }

    @PostMapping("state_judgement_insert")
    public ResultInfo insertStateJudgement(@RequestBody Map<String, String> params) {
        String stateJudgementName=params.get("stateJudgementName");
        if (StringUtils.isEmpty(stateJudgementName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertStateJudgement(stateJudgementName);
    }

    @PostMapping("state_judgement_update")
//    public ResultInfo updateStateJudgement(@RequestBody String stateJudgementId, @RequestBody String stateJudgementName) {
    public ResultInfo updateStateJudgement(@RequestBody Map<String, String> params) {
        String stateJudgementId=params.get("stateJudgementId");
        String stateJudgementName=params.get("stateJudgementName");
        System.out.println(params.size()+" "+stateJudgementId+" "+stateJudgementName);
        if (StringUtils.isEmpty(stateJudgementId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        if (StringUtils.isEmpty(stateJudgementName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateStateJudgement(stateJudgementId, stateJudgementName);
    }

    @PostMapping("state_judgement_delete")
    public ResultInfo deleteStateJudgement(@RequestBody Map<String, String> params) {
        String stateJudgementId=params.get("stateJudgementId");
        if (StringUtils.isEmpty(stateJudgementId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return adminService.deleteStateJudgement(stateJudgementId);
    }
    //=====================================================================5

    @GetMapping("subdivision_type")
    public ResultInfo searchSubdivisionType(@RequestBody Map<String, String> params) {
        String problemClassificationId=params.get("problemClassificationId");
        if (StringUtils.isEmpty(problemClassificationId)) {
            return new ResultInfo(0, "需先选定一个问题分类");
        }
        return adminService.searchSubdivisionType(problemClassificationId);
    }

    @GetMapping("subdivision_type_id")
    public ResultInfo searchSubdivisionTypeById(@RequestBody Map<String, String> params) {
        String subdivisionTypeId=params.get("subdivisionTypeId");
        if (StringUtils.isEmpty(subdivisionTypeId)) {
            return new ResultInfo(0, "请选择一条");
        }
        return adminService.searchSubdivisionTypeById(subdivisionTypeId);
    }

    @PostMapping("subdivision_type_insert")
    public ResultInfo insertSubdivisionType(@RequestBody Map<String, String> params) {
        String problemClassificationId=params.get("problemClassificationId");

        String subdivisionTypeName=params.get("subdivisionTypeName");
        if (StringUtils.isEmpty(subdivisionTypeName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        if (StringUtils.isEmpty(problemClassificationId)) {
            return new ResultInfo(0, "需先选定一个问题分类");
        }
        return adminService.insertSubdivisionType(subdivisionTypeName, problemClassificationId);
    }

    @PostMapping("subdivision_type_update")
    public ResultInfo updateSubdivisionType(@RequestBody Map<String, String> params) {
        String subdivisionTypeId=params.get("subdivisionTypeId");
        if (StringUtils.isEmpty(subdivisionTypeId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        String subdivisionTypeName=params.get("subdivisionTypeName");
        if (StringUtils.isEmpty(subdivisionTypeName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateSubdivisionType(subdivisionTypeId, subdivisionTypeName);
    }

    @PostMapping("subdivision_type_delete")
    public ResultInfo deleteSubdivisionType(@RequestBody Map<String, String> params) {
        String subdivisionTypeId=params.get("subdivisionTypeId");
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
    public ResultInfo searchResponsibleAreaById(@RequestBody Map<String, String> params) {
        String responsibleAreaId=params.get("responsibleAreaId");
        if (StringUtils.isEmpty(responsibleAreaId)) {
            return new ResultInfo(0, "请选择一条");
        }
        return adminService.searchResponsibleAreaById(responsibleAreaId);
    }

    @PostMapping("responsible_area_insert")
    public ResultInfo insertResponsibleArea(@RequestBody Map<String, String> params) {
        String responsibleAreaName=params.get("responsibleAreaName");
        if (StringUtils.isEmpty(responsibleAreaName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.insertResponsibleArea(responsibleAreaName);
    }

    @PostMapping("responsible_area_update")
    public ResultInfo updateResponsibleArea(@RequestBody Map<String, String> params) {
        String responsibleAreaId=params.get("responsibleAreaId");
        if (StringUtils.isEmpty(responsibleAreaId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        String responsibleAreaName=params.get("responsibleAreaName");
        if (StringUtils.isEmpty(responsibleAreaName)) {
            return new ResultInfo(0, "输入的名不能为空");
        }
        return adminService.updateResponsibleArea(responsibleAreaId, responsibleAreaName);
    }

    @PostMapping("responsible_area_delete")
    public ResultInfo deleteResponsibleArea(@RequestBody Map<String, String> params) {
        String responsibleAreaId=params.get("responsibleAreaId");
        if (StringUtils.isEmpty(responsibleAreaId)) {
            return new ResultInfo(0, "至少选择一个");
        }
        return adminService.deleteResponsibleArea(responsibleAreaId);
    }
    //=====================================================================7
}
