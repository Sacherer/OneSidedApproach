package com.example.demo.dao;

import com.example.demo.po.Recording;

public interface RecordingMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Recording record);

    int insertSelective(Recording record);

    Recording selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Recording record);

    int updateByPrimaryKey(Recording record);
}