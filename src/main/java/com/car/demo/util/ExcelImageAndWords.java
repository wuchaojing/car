package com.car.demo.util;

import com.car.demo.entity.SafeProblem;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class ExcelImageAndWords {

    public static List<SafeProblem> getDataFromExcel(String filePath) {
        List<SafeProblem> safeProblems = new ArrayList<>();
        try {
            // 判断是否为excel类型文件
            if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
                System.out.println("文件不是excel类型");
            }
            FileInputStream fis = null;
            Workbook wookbook = null;
            Sheet sheet = null;
            // 获取一个绝对地址的流
            fis = new FileInputStream(filePath);
            if (filePath.endsWith(".xls")) {
                // 2003版本的excel，用.xls结尾
                wookbook = new HSSFWorkbook(fis);// 得到工作簿
            } else if (filePath.endsWith(".xlsx")) {
                // 2007版本的excel，用.xlsx结尾
                fis = new FileInputStream(filePath);
                wookbook = new XSSFWorkbook(fis);// 得到工作簿
            }
            Map<String, PictureData> maplist = null;
            Map<String, String> picMap = null;
            sheet = wookbook.getSheetAt(0);
            // 判断用07还是03的方法获取图片
            if (filePath.endsWith(".xls")) {
                maplist = getPictures1((HSSFSheet) sheet);
            } else if (filePath.endsWith(".xlsx")) {
                maplist = getPictures2((XSSFSheet) sheet);
            }
            picMap = printImg(maplist);
            // 得到一个工作表
            // 获得表头
            Row rowHead = sheet.getRow(0);
            // 判断表头是否正确
            int len = rowHead.getPhysicalNumberOfCells();
            // 获得数据的总行数
            int totalRowNum = sheet.getLastRowNum();
            // 要获得属性
            String temp = "";
            // 获得所有数据
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            for (int i = 2; i <= totalRowNum; i++) {
                // 获得第i行对象【表格第一、二行无用，i从2开始】
                Row row = sheet.getRow(i);
                Cell cell = null;
                String cellValue = null;
                SafeProblem safeProblem = new SafeProblem();
                for (int j = 0; j < len; j++) {
                    cell = row.getCell((short) j);
                    cell.setCellType(Cell.CELL_TYPE_STRING);//都按照string读入
                    cellValue = cell.getStringCellValue();
                    if (j == 1) {
                        safeProblem.setAuditAera(cellValue);
                    } else if (j == 2) {
                        try {
                            safeProblem.setProposeTime(simpleDateFormat.parse(cellValue));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else if (j == 3) {
                        safeProblem.setProblemDescription(cellValue);
                    } else if (j == 4) {
                        safeProblem.setPhoto(picMap.get(i + "-" + j));
                    } else if (j == 5) {
                        safeProblem.setStateJudgement(cellValue);
                    } else if (j == 6) {
                        safeProblem.setProblemClassification(cellValue);
                    } else if (j == 7) {
                        safeProblem.setSubdivisionType(cellValue);
                    } else if (j == 8) {
                        safeProblem.setRank(cellValue);
                    } else if (j == 9) {
                        safeProblem.setRectificationMeasures(cellValue);
                    } else if (j == 10) {
                        safeProblem.setResponsibleArea(cellValue);
                    } else if (j == 11) {
                        safeProblem.setPersonLiable(cellValue);
                    } else if (j == 12) {
                        safeProblem.setCompletionDeadline(cellValue);
                    } else if (j == 13) {
                        safeProblem.setAuditHierarchy(cellValue);
                    } else if (j == 14) {
                        safeProblem.setRepeatQuestion(cellValue);
                    } else if (j == 15) {
                        safeProblem.setCompletionStatus(cellValue);
                    } else if (j == 16) {
                        safeProblem.setFinishPhoto(picMap.get(i + "-" + j));
                    }
                }
                //数据库剩余内容填充
                safeProblem.setSubmitPerson(666);//自己随便编写的
                safeProblem.setCreateTime(new Date());
                safeProblem.setLastTime(new Date());
                //System.out.println(safeProblem);
                safeProblems.add(safeProblem);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return safeProblems;
    }

    /**
     * 获取图片和位置 (xls)
     */
    public static Map<String, PictureData> getPictures1(HSSFSheet sheet) {
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
     */
    public static Map<String, PictureData> getPictures2(XSSFSheet sheet) {
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
    public static Map<String, String> printImg(Map<String, PictureData> sheetList) {
        Map<String, String> picMap = new HashMap<>();
        try {
            // for (Map<String, PictureData> map : sheetList) {
            for (String key : sheetList.keySet()) {
                // 获取图片流
                PictureData pic = sheetList.get(key);
                // 获取图片索引
                String picName = UUID.randomUUID().toString();//随机生成个名，这样不重复
                // 获取图片格式
                String ext = pic.suggestFileExtension();
                picMap.put(key, picName + "." + ext);//我按照  【"行-列",图片名】存储在picMap
                byte[] data = pic.getData();
                // 图片保存路径
                FileOutputStream out = null;
                out = new FileOutputStream("D:\\photo_xingyi_excel2\\" + picName + "." + ext);
                out.write(data);
                out.close();
            }
            // }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picMap;
    }
}
