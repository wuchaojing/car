package com.car.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class DocumentInfo {

    private String docId;
    private String docNewName;
    private String docOriginName;
    @JsonIgnore
    private String secondCategoryId;
    @JsonIgnore
    private String userId;
    @JsonIgnore
    private Date createTime;

}
