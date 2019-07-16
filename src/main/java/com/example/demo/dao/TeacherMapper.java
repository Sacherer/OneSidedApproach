package com.example.demo.dao;

import com.example.demo.dto.ImportTeacherDTO;
import com.example.demo.po.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(String tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

    void updateByTid(String tid, String openId, String nickname, String sex, String headimgurl);

    Teacher getTeacherByOpenId(String openId);

    int updateDeptmentByTid(String tid);

    int insertByImport(ImportTeacherDTO importTeacherDTO);

}