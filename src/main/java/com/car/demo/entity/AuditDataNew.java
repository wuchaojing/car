package com.car.demo.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AuditDataNew {

    private List<Map<String, Object>> companyAuditNew;
    private List<Map<String, Object>> audit;
    private List<Map<String, Object>> companyProblemType;

    public AuditDataNew(List<Map<String, Object>> companyAuditNew, List<Map<String, Object>> audit, List<Map<String, Object>> companyProblemType) {
        this.companyAuditNew = companyAuditNew;
        this.audit = audit;
        this.companyProblemType = companyProblemType;
    }
}
