package com.example.demo.service.impl;

import com.example.demo.dao.DeptmentMapper;
import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.TeacherMapper;
import com.example.demo.dto.ImportStudentDTO;
import com.example.demo.dto.ImportTeacherDTO;
import com.example.demo.po.Deptment;
import com.example.demo.po.Student;
import com.example.demo.po.Teacher;
import com.example.demo.service.ImportExeclService;
import com.example.demo.utils.ExcelUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImportExeclServiceImpl implements ImportExeclService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private DeptmentMapper deptmentMapper;

    @Override
    public boolean importStudent(MultipartFile multipartFile,Integer id) {
        int i =0;
        try {
            List<ImportStudentDTO> importStudentDTOList = ExcelUtil.getImportStudentDTOList(multipartFile);
            for (ImportStudentDTO importStudentDTO : importStudentDTOList) {
                Student student = studentMapper.selectByPrimaryKey(importStudentDTO.getSid());
                if(student==null){
                    Deptment deptment = deptmentMapper.selectByName(importStudentDTO.getDid(),id);
                    if(deptment!=null){
                        importStudentDTO.setDid(deptment.getDid()+"");
                    }else{
                        Deptment dep = new Deptment();
                        dep.setDname(importStudentDTO.getDid());
                        dep.setPid(id);
                        deptmentMapper.insert(dep);
                        importStudentDTO.setDid(dep.getDid()+"");
                    }
                    i=studentMapper.insertByImport(importStudentDTO);
                }
            }
            if(i>0){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return false;
    }

    @Override
    public boolean importTeacher(MultipartFile multipartFile) {
        int i =0;
        try {
            List<ImportTeacherDTO> importTeacherDTOList = ExcelUtil.getImportTeacherDTOList(multipartFile);
            for (ImportTeacherDTO importTeacherDTO : importTeacherDTOList) {
                Teacher teacher = teacherMapper.selectByPrimaryKey(importTeacherDTO.getTid());
                if(teacher==null){
                    i=teacherMapper.insertByImport(importTeacherDTO);
                }
            }
            if(i>0){
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
