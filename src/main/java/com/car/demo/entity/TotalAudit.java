package com.car.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TotalAudit {
    private String responsibleArea;
    private Integer countRankA;
    private Integer countRankB;
    private Integer countRankC;
    private String completionRate;//因为可能是不存在
}
