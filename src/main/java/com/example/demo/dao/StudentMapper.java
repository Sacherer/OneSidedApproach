package com.example.demo.dao;

import com.example.demo.dto.WechatUser;
import com.example.demo.po.Student;

public interface StudentMapper {
    int deleteByPrimaryKey(String sid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(String sid);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    Student getStudentByOpenId(String openId);

    void updateBySid(String sid, String openId,String nickname,String sex,String headimgurl);
}