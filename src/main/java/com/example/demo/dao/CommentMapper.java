package com.example.demo.dao;

import com.example.demo.po.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer mid);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}