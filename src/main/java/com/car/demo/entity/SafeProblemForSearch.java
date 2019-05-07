package com.car.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SafeProblemForSearch {
    //    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date proposeTime;
    private String stateJudgement;
    private String problemClassification;
    private String subdivisionType;
    private String rank;
    //    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date completionDeadline;
    private String auditHierarchy;
    private String repeatQuestion;
    private String completionStatus;
    //    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date proposeTimeMin;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date proposeTimeMax;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date completionDeadlineMin;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private Date completionDeadlineMax;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeMin;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeMax;


}
