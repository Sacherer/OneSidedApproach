package com.example.demo.dao;

import com.example.demo.po.Deptment;

public interface DeptmentMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Deptment record);

    int insertSelective(Deptment record);

    Deptment selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Deptment record);

    int updateByPrimaryKey(Deptment record);
}