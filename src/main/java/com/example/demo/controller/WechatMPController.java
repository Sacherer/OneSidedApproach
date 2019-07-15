package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.api.WechatSnsApi;
import com.example.demo.dto.WechatUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/wechat")
@CrossOrigin
public class WechatMPController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WechatSnsApi wechatSnsApi;

    @Value("${wechat.mp.appid}")
    private String appid;

    @Value("${wechat.mp.secret}")
    private String secret;

    @GetMapping("/getUserInfo")
    public WechatUser getUserInfo(@RequestParam String code){
        String authorization_code = wechatSnsApi.getUserAccessToken(appid, secret, code, "authorization_code");
        JSONObject getTokenJson = JSONObject.parseObject(authorization_code);
        String openid = getTokenJson.getString("openid");
        logger.info("openId:{}",openid);
        String access_token = getTokenJson.getString("access_token");
        String refresh_token = getTokenJson.getString("refresh_token");
        // 第五步验证access_token是否失效
        String validToken = wechatSnsApi.vlidToken(access_token, openid);
        JSONObject validTokenJson = JSONObject.parseObject(validToken);
        if (!"0".equals(validTokenJson.getString("errcode"))) {
            //刷新access_token
            String refresh_token1 = wechatSnsApi.refreshToken(appid, "refresh_token", refresh_token);
            JSONObject refreshTokenJson = JSONObject.parseObject(refresh_token1);
            access_token = refreshTokenJson.getString("access_token");
        }
        //拉取用户信息
        String userInfo = wechatSnsApi.getUserInfo(access_token, openid, "zh_CN");
        JSONObject getUserInfoJson = JSONObject.parseObject(userInfo);
        WechatUser wechatUser = new WechatUser();
        wechatUser.setOpenId(getUserInfoJson.getString("openid"));
        wechatUser.setCity(getUserInfoJson.getString("city"));
        wechatUser.setCountry(getUserInfoJson.getString("country"));
        wechatUser.setHeadimgurl(getUserInfoJson.getString("headimgurl"));
        wechatUser.setNickname(getUserInfoJson.getString("nickname"));
        wechatUser.setProvince(getUserInfoJson.getString("province"));
        wechatUser.setSex(getUserInfoJson.getIntValue("sex"));
        return wechatUser;
    }
}
