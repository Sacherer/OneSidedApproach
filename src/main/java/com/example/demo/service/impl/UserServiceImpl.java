package com.example.demo.service.impl;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public boolean login(String phone,String code) {
        String syscode = (String)redisTemplate.opsForValue().get("code" + phone);
        if(syscode!=null&&syscode.equals(code)){
            return true;
        }
        return false;
    }
}
