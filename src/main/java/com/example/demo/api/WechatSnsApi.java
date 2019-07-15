package com.example.demo.api;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "sns",url = "https://api.weixin.qq.com/sns")
public interface WechatSnsApi {
    @GetMapping("/oauth2/access_token")
    String getUserAccessToken(@RequestParam String appid,
                                  @RequestParam String secret,
                                  @RequestParam String code,
                                  @RequestParam String grant_type);

    @GetMapping("/auth")
    String vlidToken(@RequestParam String access_token,
                         @RequestParam String openid);

    @GetMapping("/oauth2/refresh_token")
    String refreshToken(@RequestParam String appid,
                            @RequestParam String grant_type,
                            @RequestParam String refresh_token);

    @GetMapping("/userinfo")
    String getUserInfo(@RequestParam String access_token,
                           @RequestParam String openid,
                           @RequestParam String lang);
}
