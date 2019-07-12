package com.example.demo.dao;

import com.example.demo.po.Classes;

public interface ClassesMapper {
    int deleteByPrimaryKey(Integer cId);

    int insert(Classes record);

    int insertSelective(Classes record);

    Classes selectByPrimaryKey(Integer cId);

    int updateByPrimaryKeySelective(Classes record);

    int updateByPrimaryKey(Classes record);
}