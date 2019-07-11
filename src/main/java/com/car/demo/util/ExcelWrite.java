package com.car.demo.util;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

import java.io.*;

public class ExcelWrite {

//    /**
//     * 创建excel并填入数据
//     *
//     * @author LiQuanhui
//     * @date 2017年11月24日 下午5:25:13
//     * @param head 数据头
//     * @param body 主体数据
//     * @return HSSFWorkbook
//     */
//    public static String[] head = new String[]{"1", "2", "3"};
//    public static String path=Con
//    public static String expExcel() {
//        //创建一个excel工作簿
//        HSSFWorkbook workbook = new HSSFWorkbook();
//        //创建一个sheet工作表
//        HSSFSheet sheet = workbook.createSheet("学生信息");
//
//        //创建第0行表头，再在这行里在创建单元格，并赋值
//        HSSFRow row = sheet.createRow(0);
//        HSSFCell cell = null;
//        for (int i = 0; i < head.length; i++) {
//            cell = row.createCell(i);
//            cell.setCellValue(head[i]);//设置值
//        }
//
//        //将主体数据填入Excel中
//        for (int i = 0; i < 5; i++) {
//            row = sheet.createRow(i + 1);
//            for (int j = 0; j < 3; j++) {
//                cell = row.createCell(j);
//                cell.setCellValue(i + " --- " + j);//设置值
//            }
//        }
//        OutputStream os = null;
//        try {
//            os = new FileOutputStream(new File(path));
//            workbook.write(os);
//            os.close();
//        } catch (FileNotFoundException e1) {
//            e1.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//    return path;
    //}
}