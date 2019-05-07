package com.car.demo.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class AuditData {

    private List<Map<String, Object>> hierarchy;
    private List<Map<String, Object>> hierarchyCompleteRatio;
    private List<Map<String, Object>> problemType;
    private List<Map<String, Object>> companyAudit;

    public AuditData(List<Map<String, Object>> hierarchy, List<Map<String, Object>> hierarchyCompleteRatio, List<Map<String, Object>> problemType, List<Map<String, Object>> companyAudit) {
        this.hierarchy = hierarchy;
        this.hierarchyCompleteRatio = hierarchyCompleteRatio;
        this.problemType = problemType;
        this.companyAudit = companyAudit;
    }
}
