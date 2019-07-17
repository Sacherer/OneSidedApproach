package com.example.demo.dao;

import com.example.demo.dto.DeptmentNode;
import com.example.demo.po.Deptment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DeptmentMapper {
    int deleteByPrimaryKey(Integer did);

    int insert(Deptment record);

    int insertSelective(Deptment record);

    Deptment selectByPrimaryKey(Integer did);

    int updateByPrimaryKeySelective(Deptment record);

    int updateByPrimaryKey(Deptment record);

    List<DeptmentNode> getSelectTree(@Param("did") Integer did);

    Deptment getSelectByAreaId(@Param("pid") Integer pid);

    Deptment selectByName(@Param("did")String did,@Param("id")Integer id);
}