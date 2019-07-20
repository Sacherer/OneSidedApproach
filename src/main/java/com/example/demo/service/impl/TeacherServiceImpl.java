package com.example.demo.service.impl;

import com.example.demo.dao.TDMapper;
import com.example.demo.dao.TeacherMapper;
import com.example.demo.po.TD;
import com.example.demo.po.Teacher;
import com.example.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TDMapper tdMapper;

    @Override
    public boolean authorize(String code, String phone, String tid, String openId, String nickname, String sex, String headimgurl) {
        String syscode = (String) redisTemplate.opsForValue().get("code" + phone);
        if (syscode != null && syscode.equals(code)) {
            teacherMapper.updateByTid(tid, openId, nickname, sex, headimgurl);
            return true;
        }
        return false;
    }

    @Override
    public Teacher getTeacherByOpenId(String openId) {
        return teacherMapper.getTeacherByOpenId(openId);
    }

    @Override
    public Teacher selectByPrimaryKey(String tid) {
        return teacherMapper.selectByPrimaryKey(tid);
    }

    @Override
    public boolean updateDeptment(String tid,String did) {
        int i =tdMapper.deleteByTid(tid);
        if(i>0){
            String[] split = did.split(",");
            for (String s : split) {
                TD td = new TD();
                td.setTid(tid);
                td.setDid(Integer.parseInt(s));
                int insert = tdMapper.insert(td);
                if(insert>0){
                    return true;
                }
            }

        }
        return false;
    }
}
