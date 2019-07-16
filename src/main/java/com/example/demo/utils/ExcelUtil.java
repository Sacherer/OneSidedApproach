package com.example.demo.utils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.excel.entity.enmus.ExcelType;

import com.example.demo.dto.ImportStudentDTO;
import com.example.demo.dto.ImportTeacherDTO;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    /**
     * 下载带有表头的空白Excel模板文件
     *
     * @param clazz
     * @param fileName
     * @param response
     * @throws IOException
     */
    public static void exportExcel(Class<?> clazz, String fileName, HttpServletResponse response) throws IOException {
        ExportParams exportParams = new ExportParams();
        exportParams.setCreateHeadRows(true);
        defaultExport(new ArrayList<>(), clazz, fileName, response, exportParams);
    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> clazz, String fileName, boolean isCreateHeader, HttpServletResponse response) throws IOException {
        ExportParams exportParams = new ExportParams(title, sheetName);
        exportParams.setCreateHeadRows(isCreateHeader);
        defaultExport(list, clazz, fileName, response, exportParams);
    }

    public static void exportExcel(List<?> list, Class<?> clazz, String fileName, HttpServletResponse response) throws IOException {
        defaultExport(list, clazz, fileName, response, new ExportParams());
    }

    public static void exportExcel(List<?> list, String title, String sheetName, Class<?> clazz, String fileName, HttpServletResponse response) throws IOException {
        defaultExport(list, clazz, fileName, response, new ExportParams(title, sheetName));
    }

    public static void exportExcel(List<Map<String, Object>> list, String fileName, HttpServletResponse response) throws IOException {
        defaultExport(list, fileName, response);
    }

    private static void defaultExport(List<?> list, Class<?> clazz, String fileName, HttpServletResponse response, ExportParams exportParams) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(exportParams, clazz, list);
        if (workbook != null) downLoadExcel(fileName, response, workbook);
    }

    private static void downLoadExcel(String fileName, HttpServletResponse response, Workbook workbook) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("content-Type", "application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        workbook.write(response.getOutputStream());
    }

    private static void defaultExport(List<Map<String, Object>> list, String fileName, HttpServletResponse response) throws IOException {
        Workbook workbook = ExcelExportUtil.exportExcel(list, ExcelType.HSSF);
        if (workbook != null) downLoadExcel(fileName, response, workbook);
    }

    public static <T> List<T> importExcel(String filePath, Integer titleRows, Integer headerRows, Class<T> clazz) {
        if (StringUtils.isBlank(filePath)) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        return ExcelImportUtil.importExcel(new File(filePath), clazz, params);
    }

    public static <T> List<T> importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> clazz) throws Exception {
        if (file == null) {
            return null;
        }
        ImportParams params = new ImportParams();
        params.setTitleRows(titleRows);
        params.setHeadRows(headerRows);
        return ExcelImportUtil.importExcel(file.getInputStream(), clazz, params);
    }

    /**
     * 将excel文件内容转换成User集合
     *
     * @param file
     * @return
     * @throws IOException
     */
    public static List<ImportStudentDTO> getImportStudentDTOList(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = isExcel2003 ? new HSSFWorkbook(is) : new XSSFWorkbook(is);
        ImportStudentDTO importStudentDTO;
        List<ImportStudentDTO> list = new LinkedList<>();
        int sheetNumber = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNumber; i++) {
            Sheet sheet = wb.getSheetAt(i);
            int rowNumber = sheet.getLastRowNum();
            for (int r = 1; r <= rowNumber; r++) {
                Row row = sheet.getRow(r);
                if (row != null) {
                    String sid = getCellValue(row.getCell(0));
                    String tname = getCellValue(row.getCell(1));
                    String phone = getCellValue(row.getCell(2));
                    String did = getCellValue(row.getCell(3));
                    importStudentDTO=new ImportStudentDTO(sid,tname,phone,did);
                    list.add(importStudentDTO);
                }
            }
        }
        return list;
    }

    public static List<ImportTeacherDTO> getImportTeacherDTOList(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = isExcel2003 ? new HSSFWorkbook(is) : new XSSFWorkbook(is);
        ImportTeacherDTO importTeacherDTO;
        List<ImportTeacherDTO> list = new LinkedList<>();
        int sheetNumber = wb.getNumberOfSheets();
        for (int i = 0; i < sheetNumber; i++) {
            Sheet sheet = wb.getSheetAt(i);
            int rowNumber = sheet.getLastRowNum();
            for (int r = 1; r <= rowNumber; r++) {
                Row row = sheet.getRow(r);
                if (row != null) {
                    String sid = getCellValue(row.getCell(0));
                    String sname = getCellValue(row.getCell(1));
                    String phone = getCellValue(row.getCell(2));
                    String did = getCellValue(row.getCell(3));
                    importTeacherDTO=new ImportTeacherDTO(sid,sname,phone,did);
                    list.add(importTeacherDTO);
                }
            }
        }
        return list;
    }

    private static String getCellValue(Cell cell) {
        if (cell == null) return null;
        cell.setCellType(CellType.STRING);
        return cell.getStringCellValue();
    }
}
