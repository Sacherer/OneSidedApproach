package com.example.demo.service;

import com.example.demo.po.Teacher;

public interface TeacherService {
    boolean authorize(String code, String phone, String tid, String openId, String nickname, String sex, String headimgurl);

    Teacher getTeacherByOpenId(String openId);

    Teacher selectByPrimaryKey(String tid);

    boolean updateDeptment(String tid);
}
