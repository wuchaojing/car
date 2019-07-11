package com.car.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DocumentInfo {

    private String docId = "";
    private String docNewName = "";
    private String docOriginName = "";
    @JsonIgnore
    private String secondCategoryId;
    private String happenTime;
    @JsonIgnore
    private String userId;
    @JsonIgnore
    private Date createTime;

}
