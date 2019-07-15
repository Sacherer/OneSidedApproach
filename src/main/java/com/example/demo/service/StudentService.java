package com.example.demo.service;

import com.example.demo.po.Student;

public interface StudentService {
    Student getStudentByOpenId(String openId);

    Student selectByPrimaryKey(String sid);

    void send(String phone);
}
