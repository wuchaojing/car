package com.car.demo.entity;

import lombok.Data;

@Data
public class Integration {
    private String id;
    private String name;
    private String reason;
    private Double mark;
    private String userId;
    private String markId;

    public Integration(String name, String reason, Double mark, String userId, String markId) {
        this.name = name;
        this.reason = reason;
        this.mark = mark;
        this.userId = userId;
        this.markId = markId;
    }

    public Integration() {
    }
}
