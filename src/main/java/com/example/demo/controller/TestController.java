package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.exceptions.ClientException;
import com.example.demo.utils.FastDFSPollClient;
import com.example.demo.utils.SmsUtil;
import org.csource.fastdfs.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
@CrossOrigin
public class TestController {
    @Autowired
    private SmsUtil sendSms;

    @Autowired
    private FastDFSPollClient fastDFSPollClient;

    @RequestMapping("/t1")
    public String test() {
        return "测试内网穿透！";
    }

    @RequestMapping("/t2")
    public String test1(@RequestParam String path) throws ClientException {
        File file = new File(path);
        return file.getName();
    }

}
