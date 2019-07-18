package com.example.demo.service;

import com.example.demo.po.Student;

public interface StudentService {
    Student getStudentByOpenId(String openId);

    Student selectByPrimaryKey(String sid);

    void send(String phone);

    boolean authorize(String code, String phone, String sid, String openId, String nickname, String sex, String headimgurl);
}
