package com.example.demo.service.impl;

import com.aliyuncs.exceptions.ClientException;
import com.example.demo.dao.StudentMapper;
import com.example.demo.dto.WechatUser;
import com.example.demo.po.Student;
import com.example.demo.service.StudentService;
import com.example.demo.utils.SmsUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@EnableAutoConfiguration
public class StudentServiceImpl implements StudentService {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Value("${sms.send.template_code}")
    private String template_code;

    @Value("${sms.send.sign_name}")
    private String sign_name;

    @Autowired
    private SmsUtil smsUtil;

    @Override
    public Student getStudentByOpenId(String openId) {
        return studentMapper.getStudentByOpenId(openId);
    }

    @Override
    public Student selectByPrimaryKey(String sid) {
        return studentMapper.selectByPrimaryKey(sid);
    }

    @Override
    public void send(String phone) {
        String code = RandomStringUtils.randomNumeric(6);
        logger.info("code is {}",code);
        redisTemplate.opsForValue().set("code"+phone,code,5, TimeUnit.MINUTES);
        try {
            smsUtil.sendSms(phone,template_code,sign_name,"{\"code\":\""+code+"\"}");
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean authorize(String code, String phone,String sid, String openId,String nickname,String sex,String headimgurl) {
        String syscode = (String)redisTemplate.opsForValue().get("code" + phone);
        if(syscode!=null&&syscode.equals(code)){
            studentMapper.updateBySid(sid,openId,nickname,sex,headimgurl);
            return true;
        }
        return false;
    }
}
