package com.example.demo.controller;

import com.example.demo.service.WechatSrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wx")
@CrossOrigin
public class WechatSrController {

    @Autowired
    private WechatSrService wechatSrService;

    private String TOKEN = "wechat";

    @GetMapping("/check")
    public String check(@RequestParam(name = "signature") String signature,
                            @RequestParam(name = "timestamp") String timestamp,
                            @RequestParam(name = "nonce") String nonce,
                            @RequestParam(name = "echostr") String echostr) {
        return wechatSrService.check(signature,timestamp,nonce,echostr,TOKEN);
    }
}
