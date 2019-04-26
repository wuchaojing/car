package com.car.demo.entity;

import lombok.Data;

@Data
public class Json {
    private boolean success;
    private String msg;
    private Object data;
}
