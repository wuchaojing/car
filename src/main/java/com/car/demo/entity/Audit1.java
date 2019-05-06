package com.car.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表1 负责区域、审计层级及数量
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audit1 {
    private String responsibleArea;
    private String auditHierarchy;//rank;
    private Integer number;
}
