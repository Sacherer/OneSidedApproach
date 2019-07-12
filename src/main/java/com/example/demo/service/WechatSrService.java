package com.example.demo.service;

public interface WechatSrService {
    String check(String signature, String timestamp, String nonce, String echostr, String token);
    String sort(String token, String timestamp, String nonce);
    String sha1(String str);
}
