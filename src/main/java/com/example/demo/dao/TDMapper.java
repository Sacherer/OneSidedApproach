package com.example.demo.dao;

import com.example.demo.po.TD;

public interface TDMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TD record);

    int insertSelective(TD record);

    TD selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TD record);

    int updateByPrimaryKey(TD record);
}