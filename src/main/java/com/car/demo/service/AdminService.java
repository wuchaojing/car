package com.car.demo.service;

import com.car.demo.entity.ResultInfo;

public interface AdminService {
    ResultInfo searchAuditHierarchy();

    ResultInfo insertAuditHierarchy(String auditHierarchyName);

    ResultInfo updateAuditHierarchy(String auditHierarchyId, String auditHierarchyName);

    ResultInfo deleteAuditHierarchy(String auditHierarchyId);
    //======================================================================1

    ResultInfo searchCompletionStatus();

    ResultInfo insertCompletionStatus(String completionStatusName);

    ResultInfo updateCompletionStatus(String completionStatusId, String completionStatusName);

    ResultInfo deleteCompletionStatus(String completionStatusId);
    //======================================================================2

    ResultInfo searchProblemClassification();

    ResultInfo insertProblemClassification(String problemClassificationName);

    ResultInfo updateProblemClassification(String problemClassificationId, String problemClassificationName);

    ResultInfo deleteProblemClassification(String problemClassificationId);
    //======================================================================3

    ResultInfo searchRank();

    ResultInfo insertRank(String rankName);

    ResultInfo updateRank(String rankId, String rankName);

    ResultInfo deleteRank(String rankId);
    //======================================================================4

    ResultInfo searchStateJudgement();

    ResultInfo insertStateJudgement(String stateJudgementName);

    ResultInfo updateStateJudgement(String stateJudgementId, String stateJudgementName);

    ResultInfo deleteStateJudgement(String stateJudgementId);
    //======================================================================5
}
