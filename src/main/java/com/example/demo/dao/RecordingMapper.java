package com.example.demo.dao;

import com.example.demo.dto.OwnRecordingListDTO;
import com.example.demo.dto.RecordIngListDTO;
import com.example.demo.dto.StudentRecordIngListDTO;
import com.example.demo.dto.TeacherRecordIngListDTO;
import com.example.demo.po.Recording;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RecordingMapper {
    int deleteByPrimaryKey(Integer rid);

    int insert(Recording record);

    int insertSelective(Recording record);

    Recording selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(Recording record);

    int updateByPrimaryKey(Recording record);

    Page<StudentRecordIngListDTO> getSelectByStudentList(@Param("sname") String sname, @Param("name") String name,@Param("openId") String openId);

    Page<TeacherRecordIngListDTO> getSelectByTeacherList(@Param("sname") String sname, @Param("name") String name, @Param("sid") String sid);

    RecordIngListDTO selectByPrimaryKey2(@Param("rid") int rid);


    void getUpdatevisits(@Param("rid") int rid);

    void getInsertThumbup(@Param("rid") int rid);

    List<OwnRecordingListDTO> getSelectStudentAndOecordingList(@Param("openId") String openId);

    List<StudentRecordIngListDTO> getStudentAndDeptmant(@Param("tid") Integer tid);

    List<StudentRecordIngListDTO> selectByIds(String ids);
}