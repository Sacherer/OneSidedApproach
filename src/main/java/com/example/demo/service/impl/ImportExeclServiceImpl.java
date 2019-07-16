package com.example.demo.service.impl;

import com.example.demo.po.Student;
import com.example.demo.service.ImportExeclService;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ImportExeclServiceImpl implements ImportExeclService {

    @Override
    public boolean importStudent(MultipartFile multipartFile) throws IOException {
        List<Student> list = new ArrayList<Student>();
        XSSFWorkbook workbook =null;

        //把MultipartFile转化为File
        CommonsMultipartFile cmf= (CommonsMultipartFile)multipartFile;
        DiskFileItem dfi=(DiskFileItem) cmf.getFileItem();
        File fo=dfi.getStoreLocation();

        //创建Excel，读取文件内容
        workbook = new XSSFWorkbook(FileUtils.openInputStream(fo));

        //获取第一个工作表
        XSSFSheet sheet = workbook.getSheet("Sheet1");

        //获取sheet中第一行行号
        int firstRowNum = sheet.getFirstRowNum();
        //获取sheet中最后一行行号
        int lastRowNum = sheet.getLastRowNum();

        try {
            //循环插入数据
            for(int i=firstRowNum+1;i<=lastRowNum;i++){
                XSSFRow row = sheet.getRow(i);
                Student student = new Student();

                XSSFCell sid = row.getCell(0);//学号
                if(sid!=null){
                    student.setSid(sid.getStringCellValue());
                }

                XSSFCell sname = row.getCell(1);//姓名
                if(sname!=null){
                    student.setSname(sname.getStringCellValue());
                }

                XSSFCell phone = row.getCell(2);//手机号
                if(phone!=null){
                    student.setPhone(phone.getStringCellValue());
                }

                XSSFCell did = row.getCell(3);//身份
                if(did!=null)
                list.add(users);
            }
            //usersMapper.insert(list);//往数据库插入数据
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            workbook.close();
        }

        return false;
    }
}
