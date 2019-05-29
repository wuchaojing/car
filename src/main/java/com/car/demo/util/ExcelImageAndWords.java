package com.car.demo.util;

import com.car.demo.entity.SafeProblem;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTMarker;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class ExcelImageAndWords {

    /**
     * @param filePath
     * @param nowSameDate a person's submitDate and recodeDate should be same
     * @param recordId
     * @return
     */
    public static List<SafeProblem> getDataFromExcel(String filePath, Date nowSameDate, String recordId) {
        List<SafeProblem> safeProblems = new ArrayList<>();
        try {
            // is excel?
            if (!filePath.endsWith(".xls") && !filePath.endsWith(".xlsx")) {
                log.error("{} is not excel", filePath);
                return null;
            }
            FileInputStream fis = null;
            Workbook wookbook = null;
            Sheet sheet = null;
            // get absolute stream
            fis = new FileInputStream(filePath);
            if (filePath.endsWith(".xls")) {
                wookbook = new HSSFWorkbook(fis);// getWorkBook
            } else if (filePath.endsWith(".xlsx")) {
                wookbook = new XSSFWorkbook(fis);// getWorkBook
            }
            Map<String, PictureData> maplist = null;
            Map<String, String> picMap = null;
            assert wookbook != null;
            sheet = wookbook.getSheetAt(0);
            // 07 or 03 getPicture
            if (filePath.endsWith(".xls")) {
                maplist = getXlsPicture((HSSFSheet) sheet);
            } else if (filePath.endsWith(".xlsx")) {
                maplist = getXlsxPicture((XSSFSheet) sheet);
            }
            picMap = printImg(maplist);
            if (null == picMap) {
                return null;
            }
            Row rowHead = sheet.getRow(0);
            int totalRowNum = sheet.getLastRowNum();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");
            for (int i = 2; i <= totalRowNum; i++) {
                // get row[i] object【the 0,1 is no use】
                Row row = sheet.getRow(i);
                Cell cell = null;
                SafeProblem safeProblem = new SafeProblem();

                safeProblem.setProblemId(MD5Util.str2MD5(UUID.randomUUID().toString()));//encryption UUID is problemId

                cell = row.getCell((short) 1);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setAuditArea(cell.getStringCellValue());

                cell = row.getCell((short) 2);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setProposeTime(simpleDateFormat.parse(cell.getStringCellValue()));

                cell = row.getCell((short) 3);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setProblemDescription(cell.getStringCellValue());

                cell = row.getCell((short) 4);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setPhoto(picMap.get(i + "-" + 4));

                cell = row.getCell((short) 5);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setStateJudgement(cell.getStringCellValue());

                cell = row.getCell((short) 6);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setProblemClassification(cell.getStringCellValue());

                cell = row.getCell((short) 7);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setSubdivisionType(cell.getStringCellValue());

                cell = row.getCell((short) 8);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setRank(cell.getStringCellValue());

                cell = row.getCell((short) 9);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setRectificationMeasures(cell.getStringCellValue());

                cell = row.getCell((short) 10);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setResponsibleArea(cell.getStringCellValue());

                cell = row.getCell((short) 11);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setPersonLiable(cell.getStringCellValue());

                cell = row.getCell((short) 12);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setCompletionDeadline(simpleDateFormat.parse(cell.getStringCellValue()));

                cell = row.getCell((short) 13);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setAuditHierarchy(cell.getStringCellValue());

                cell = row.getCell((short) 14);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setRepeatQuestion(cell.getStringCellValue());

                cell = row.getCell((short) 15);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setCompletionStatus(cell.getStringCellValue());

                cell = row.getCell((short) 16);
                cell.setCellType(Cell.CELL_TYPE_STRING);//set cellType String
                safeProblem.setFinishPhoto(picMap.get(i + "-" + 16));

                //the last content
                safeProblem.setCreateTime(nowSameDate);//unite every time equal
                safeProblem.setRecordId(recordId);
                //System.out.println(safeProblem);
                safeProblems.add(safeProblem);

            }
        } catch (FileNotFoundException e) {
            log.error("FileNotFoundException: {}", filePath, e);
            return null;
        } catch (IOException e) {
            log.error("IOException: new HSSFWorkbook or XSSFWorkbook", e);
            return null;
        } catch (ParseException e) {
            log.error("ParseException: parse excel Time yyyy-MM-dd error", e);
            return null;
        } catch (Exception e) {
            log.error("file format error", e);
            return null;
        }
        return safeProblems;
    }

    /**
     * get picture and position (xls)
     */
    private static Map<String, PictureData> getXlsPicture(HSSFSheet sheet) {
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
     * get picture and position (xlsx)
     */
    private static Map<String, PictureData> getXlsxPicture(XSSFSheet sheet) {
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

    // write picture to disk
    private static Map<String, String> printImg(Map<String, PictureData> sheetList) {
        Map<String, String> picMap = new HashMap<>();
        String picNameAndExt = null;
        try {
            // for (Map<String, PictureData> map : sheetList) {
            for (String key : sheetList.keySet()) {
                // get picture stream
                PictureData pic = sheetList.get(key);
                // get picture index
                String picName = UUID.randomUUID().toString();//UUID to identity
                // get picture type
                String ext = pic.suggestFileExtension();
                picNameAndExt = picName + "." + ext;
                picMap.put(key, picNameAndExt);//i use  【"row-colume",picNameAndExt】 put in picMap\\\ConstantUtil.PIC_PATH+
                byte[] data = pic.getData();
                // get picture save position
                FileOutputStream out = null;

                String picPath = ConstantUtil.PIC_PATH + picNameAndExt;
                out = new FileOutputStream(picPath);
                log.info("picture save position：{}", picPath);
                out.write(data);
                out.close();

                new Thread(() -> {
                    // 图片上传到服务器
                    File file = new File(picPath);
                    uploadFileRemote(file);
                }).start();
            }
        } catch (FileNotFoundException e) {
            log.error("fail to find file: {}", picNameAndExt, e);
            return null;
        } catch (IOException e) {
            log.error("IOException: {} or {}", "out.write", "out.close", e);
            return null;
        }
        return picMap;
    }

    private static void uploadFileRemote(File tmpFile) {
        try {
            String[] shPath = new String[]{"/Users/wuchaojing/developer/car/src/main/resources/shell/upload.sh", tmpFile.getPath()};
            Process ps = Runtime.getRuntime().exec(shPath);
            ps.waitFor();
        } catch (Exception e) {
            log.error("fail to exec scp.sh", e);
        } finally {
            tmpFile.delete();
        }
    }
}
