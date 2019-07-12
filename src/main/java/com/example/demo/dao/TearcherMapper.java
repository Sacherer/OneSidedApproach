package com.example.demo.dao;

import com.example.demo.po.Tearcher;

public interface TearcherMapper {
    int deleteByPrimaryKey(Integer tid);

    int insert(Tearcher record);

    int insertSelective(Tearcher record);

    Tearcher selectByPrimaryKey(Integer tid);

    int updateByPrimaryKeySelective(Tearcher record);

    int updateByPrimaryKey(Tearcher record);
}