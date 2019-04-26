package com.car.demo.entity;

import lombok.Data;

@Data
public class ResultInfo {
    private boolean success;
    private String msg;
    private Object data;
}
