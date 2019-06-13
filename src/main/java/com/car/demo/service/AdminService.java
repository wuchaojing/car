package com.car.demo.service;

import com.car.demo.entity.ResultInfo;

public interface AdminService {
    ResultInfo searchAuditHierarchy();

    ResultInfo insertAuditHierarchy(String auditHierarchyName);

    ResultInfo updateAuditHierarchy(String auditHierarchyId, String auditHierarchyName);

    ResultInfo deleteAuditHierarchy(String auditHierarchyId);

    ResultInfo searchAuditHierarchyById(String auditHierarchyId);
    //======================================================================1

    ResultInfo searchCompletionStatus();

    ResultInfo insertCompletionStatus(String completionStatusName);

    ResultInfo updateCompletionStatus(String completionStatusId, String completionStatusName);

    ResultInfo deleteCompletionStatus(String completionStatusId);

    ResultInfo searchCompletionStatusById(String completionStatusId);
    //======================================================================2

    ResultInfo searchProblemClassification();

    ResultInfo insertProblemClassification(String problemClassificationName);

    ResultInfo updateProblemClassification(String problemClassificationId, String problemClassificationName);

    ResultInfo deleteProblemClassification(String problemClassificationId);

    ResultInfo searchProblemClassificationById(String problemClassificationId);
    //======================================================================3

    ResultInfo searchRank();

    ResultInfo insertRank(String rankName);

    ResultInfo updateRank(String rankId, String rankName);

    ResultInfo deleteRank(String rankId);

    ResultInfo searchRankById(String rankId);
    //======================================================================4

    ResultInfo searchStateJudgement();

    ResultInfo insertStateJudgement(String stateJudgementName);

    ResultInfo updateStateJudgement(String stateJudgementId, String stateJudgementName);

    ResultInfo deleteStateJudgement(String stateJudgementId);

    ResultInfo searchStateJudgementById(String stateJudgementId);
    //======================================================================5

    ResultInfo searchSubdivisionType(String problemClassificationId);

    ResultInfo insertSubdivisionType(String subdivisionTypeName,String problemClassificationId);

    ResultInfo updateSubdivisionType(String subdivisionTypeId, String subdivisionTypeName);

    ResultInfo deleteSubdivisionType(String subdivisionTypeId);

    ResultInfo searchSubdivisionTypeById(String subdivisionTypeId);
    //======================================================================6

    ResultInfo searchResponsibleArea();

    ResultInfo insertResponsibleArea(String responsibleAreaName);

    ResultInfo updateResponsibleArea(String responsibleAreaId, String responsibleAreaName);

    ResultInfo deleteResponsibleArea(String responsibleAreaId);

    ResultInfo searchResponsibleAreaById(String responsibleAreaId);
    //======================================================================7
}
