package com.example.demo.service.impl;

import com.example.demo.service.WechatSrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

@Service
public class WechatSrSerciceImpl implements WechatSrService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String check(String signature, String timestamp, String nonce, String echostr, String token) {
        logger.info("微信-开始校验签名");
        logger.info("收到来自微信的 echostr 字符串:{}", echostr);
//        加密/校验流程如下:
//        1. 将token、timestamp、nonce三个参数进行字典序排序
//        2. 将三个参数字符串拼接成一个字符串进行sha1加密
//        3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        // 1.排序
        String sortString = sort(token, timestamp, nonce);
        // 2.sha1加密
        String myString = sha1(sortString);
        // 3.字符串校验
        if (myString != null && myString != "" && myString.equals(signature)) {
            logger.info("微信-签名校验通过");
            //如果检验成功原样返回echostr，微信服务器接收到此输出，才会确认检验完成。
            logger.info("回复给微信的 echostr 字符串:{}", echostr);
            return echostr;
        } else {
            logger.error("微信-签名校验失败");
            return "";
        }
    }

    @Override
    public String sort(String token, String timestamp, String nonce) {
        String[] strArray = {token, timestamp, nonce};
        Arrays.sort(strArray);
        StringBuilder sb = new StringBuilder();
        for (String str : strArray) {
            sb.append(str);
        }

        return sb.toString();
    }

    @Override
    public String sha1(String str) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(str.getBytes());
            byte messageDigest[] = digest.digest();
            // 创建 16进制字符串
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
