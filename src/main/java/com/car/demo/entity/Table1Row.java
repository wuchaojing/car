package com.car.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table1Row {
    private List<Audit1> audit1s=new ArrayList<>();//名称、等级及数量的List
    private Double comptetionRate=-1.0;//默认完成率是-1.0【即不存在】
}
