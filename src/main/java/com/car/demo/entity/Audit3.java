package com.car.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 表3 问题分类、等级及数量
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Audit3 {
    private String problemClassification;
    private String rank;
    private Integer number;
}
