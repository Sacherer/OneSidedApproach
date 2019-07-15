package com.example.demo.dao;

import com.example.demo.dto.TeacherListDTO;
import com.example.demo.po.Teacher;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {
    int deleteByPrimaryKey(String tid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(String tid);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);

}