package com.example.demo.dao;

import com.example.demo.po.Ts;

public interface TsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Ts record);

    int insertSelective(Ts record);

    Ts selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Ts record);

    int updateByPrimaryKey(Ts record);
}