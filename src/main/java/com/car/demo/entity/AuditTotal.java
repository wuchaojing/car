package com.car.demo.entity;

import lombok.Data;

@Data
public class AuditTotal {
    private AuditData auditData;
    private AuditDataNew auditDataNew;

    public AuditTotal(AuditData auditData, AuditDataNew auditDataNew) {
        this.auditData = auditData;
        this.auditDataNew = auditDataNew;
    }
}
