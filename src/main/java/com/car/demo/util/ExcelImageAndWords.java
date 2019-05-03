package com.car.demo.util;

import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelImageAndWords {

    public static void getDataFromExcel(String filePath) throws IOException {
        // String filePath = "E:\\123.xlsx";

        // 判断是否为excel类型文件
        if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
            System.out.println("文件不是excel类型");
        }

        FileInputStream fis = null;
        Workbook wookbook = null;
        Sheet sheet = null;
        try {
            // 获取一个绝对地址的流
            fis = new FileInputStream(filePath);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 2003版本的excel，用.xls结尾
            wookbook = new HSSFWorkbook(fis);// 得到工作簿

        } catch (Exception ex) {
            // ex.printStackTrace();
            try {
                // 2007版本的excel，用.xlsx结尾
                fis = new FileInputStream(filePath);
                wookbook = new XSSFWorkbook(fis);// 得到工作簿
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        Map<String, PictureData> maplist = null;

        sheet = wookbook.getSheetAt(0);
        // 判断用07还是03的方法获取图片
        if (filePath.endsWith(".xls")) {
            maplist = getPictures1((HSSFSheet) sheet);
        } else if (filePath.endsWith(".xlsx")) {
            maplist = getPictures2((XSSFSheet) sheet);
        }
        try {
            printImg(maplist);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        // 得到一个工作表

        // 获得表头
        Row rowHead = sheet.getRow(0);

        // 判断表头是否正确
        System.out.println(rowHead.getPhysicalNumberOfCells());
        int len = rowHead.getPhysicalNumberOfCells();

        // 获得数据的总行数
        int totalRowNum = sheet.getLastRowNum();

        // 要获得属性
        String temp = "";
        // 获得所有数据
        for (int i = 1; i <= totalRowNum; i++) {
            // 获得第i行对象【第一行是表头】
            Row row = sheet.getRow(i);
            Cell cell = null;
            for (int j = 0; j < len; j++) {
                cell = row.getCell((short) j);
                if (cell != null) {
                    cell.setCellType(Cell.CELL_TYPE_STRING);
                    temp = cell.getStringCellValue();
                    System.out.print(temp + " ");
                } else {
                    System.out.println("空数据 ");
                }

            }
            System.out.println();
        }
        for (Map.Entry<String, PictureData> entry : maplist.entrySet()) { /* 自带的entry */

            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

        }
    }

    /**
     * 获取图片和位置 (xls)
     *
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<String, PictureData> getPictures1(HSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<HSSFShape> list = sheet.getDrawingPatriarch().getChildren();
        for (HSSFShape shape : list) {
            if (shape instanceof HSSFPicture) {
                HSSFPicture picture = (HSSFPicture) shape;
                HSSFClientAnchor cAnchor = (HSSFClientAnchor) picture.getAnchor();
                PictureData pdata = picture.getPictureData();
                String key = cAnchor.getRow1() + "-" + cAnchor.getCol1(); // 行号-列号
                map.put(key, pdata);
            }
        }
        return map;
    }

    /**
     * 获取图片和位置 (xlsx)
     *
     * @param sheet
     * @return
     * @throws IOException
     */
    public static Map<String, PictureData> getPictures2(XSSFSheet sheet) throws IOException {
        Map<String, PictureData> map = new HashMap<String, PictureData>();
        List<POIXMLDocumentPart> list = sheet.getRelations();
        for (POIXMLDocumentPart part : list) {
            if (part instanceof XSSFDrawing) {
                XSSFDrawing drawing = (XSSFDrawing) part;
                List<XSSFShape> shapes = drawing.getShapes();
                for (XSSFShape shape : shapes) {
                    XSSFPicture picture = (XSSFPicture) shape;
                    XSSFClientAnchor anchor = picture.getPreferredSize();
                    CTMarker marker = anchor.getFrom();
                    String key = marker.getRow() + "-" + marker.getCol();
                    map.put(key, picture.getPictureData());
                }
            }
        }
        return map;
    }

    // 图片写出
    public static void printImg(Map<String, PictureData> sheetList) throws IOException {

        // for (Map<String, PictureData> map : sheetList) {
        Object key[] = sheetList.keySet().toArray();
        for (int i = 0; i < sheetList.size(); i++) {
            // 获取图片流
            PictureData pic = sheetList.get(key[i]);
            // 获取图片索引
            String picName = key[i].toString();
            // 获取图片格式
            String ext = pic.suggestFileExtension();

            byte[] data = pic.getData();

            // 图片保存路径
            FileOutputStream out = new FileOutputStream("D:\\photo_xingyi_excel2\\" + picName + "." + ext);
            out.write(data);
            out.close();
        }
        // }

    }

    public static void main(String[] args) throws Exception {
        // getDataFromExcel("E:"+ File.separator +"学生信息表.xlsx");
        getDataFromExcel("D:\\jk.xlsx");

    }

}
