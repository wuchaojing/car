package com.car.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SafeProblem {
    private String problemId;
    private String auditArea="";
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date proposeTime;
    private String problemDescription="";
    private String photo="";
    private String stateJudgement="";
    private String problemClassification="";
    private String subdivisionType="";
    private String rank="";
    private String rectificationMeasures="";
    private String responsibleArea="";
    private String personLiable="";
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date completionDeadline;
    private String auditHierarchy="";
    private String repeatQuestion="";
    private String completionStatus="";
    private String finishPhoto="";
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String recordId;
    private Integer isCompletion;
}
