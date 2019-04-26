package com.car.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class SafeProblem {
  private Integer id;
  private String auditAera;
  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")//json时
  @DateTimeFormat(pattern = "yyyy-MM-dd")//平常接收
  private Date proposeTime;
  private String problemDescription;
  private String photo;
  private String stateJudgement;
  private String problemClassification;
  private String subdivisionType;
  private String rank;
  private String rectificationMeasures;
  private String responsibleArea;
  private String personLiable;
  private String completionDeadline;
  private String auditHierarchy;
  private String repeatQuestion;
  private String completionStatus;
  private String finishPhoto;
  private Integer submitPerson;
  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")//json时
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//平常接收
  private Date createTime;
  @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")//json时
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")//平常接收
  private Date lastTime;

}
