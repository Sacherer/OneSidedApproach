package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.po.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public Student getStudentByOpenId(String openId) {
        return studentMapper.getStudentByOpenId(openId);
    }

    @Override
    public Student selectByPrimaryKey(Integer sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }
}
