package com.car.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表1：完成率的分子和分母中的其中一个
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditAll {
    private String responsibleArea;
    private Integer number;
}
