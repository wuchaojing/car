package com.car.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 表3的一行
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Table3Row {
    List<Audit3> audit3s=new ArrayList<>();
}
