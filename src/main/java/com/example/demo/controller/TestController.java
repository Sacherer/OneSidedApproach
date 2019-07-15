package com.example.demo.controller;

import com.aliyuncs.exceptions.ClientException;
import com.example.demo.utils.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {
    @Autowired
    private SmsUtil sendSms;

    @RequestMapping("/t1")
    public String test(){
        return "测试内网穿透！";
    }
    @RequestMapping("/t2")
    public String test1() throws ClientException {
        sendSms.sendSms("1","1","1","1");
        return "测试内网穿透！";
    }

}
