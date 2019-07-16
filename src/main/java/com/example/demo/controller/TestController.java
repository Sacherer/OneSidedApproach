package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.example.demo.utils.SmsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
