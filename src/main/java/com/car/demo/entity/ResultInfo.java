package com.car.demo.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL) // 可以查一下这个
@Data
public class ResultInfo {

    /*
        返回对象一般是这样的
        int code; // 0：表示成功，1：表示失败
        String msg;
        Object data;
        不使用boolean类型
     */

    private boolean success;
    private String msg;
    private Object data;

    public ResultInfo(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public ResultInfo(boolean success) {
        this.success = success;
    }
}
