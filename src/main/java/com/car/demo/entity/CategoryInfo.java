package com.car.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

@Data
public class CategoryInfo {

    private String categoryId;
    private String categoryName;
    @JsonIgnore
    private Date createTime;

    public CategoryInfo() {
    }

    public CategoryInfo(String categoryId, String categoryName, Date createTime) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createTime = createTime;
    }
}
