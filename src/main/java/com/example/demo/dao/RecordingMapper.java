package com.example.demo.dao;

import com.example.demo.dto.StudentRecordIngListDTO;
import com.example.demo.po.Recording;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordingMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Recording record);

    int insertSelective(Recording record);

    Recording selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Recording record);

    int updateByPrimaryKey(Recording record);

    List<StudentRecordIngListDTO> getSelectByStudentList(@Param("sname") String sname, @Param("name") String name);
}