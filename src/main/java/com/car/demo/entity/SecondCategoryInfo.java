package com.car.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class SecondCategoryInfo {

    private String secondCategoryId;
    private String secondCategoryName;
    @JsonIgnore
    private String categoryId;
    @JsonIgnore
    private Date createTime;

    public SecondCategoryInfo() {
    }

    public SecondCategoryInfo(String secondCategoryId, String secondCategoryName, String categoryId, Date createTime) {
        this.secondCategoryId = secondCategoryId;
        this.secondCategoryName = secondCategoryName;
        this.categoryId = categoryId;
        this.createTime = createTime;
    }
}
