package com.thinkstu.builder;

import com.thinkstu.entity.*;
import lombok.extern.slf4j.*;

import java.net.*;

@Slf4j
public class BistuLoginEntityBuilder {
    private String loginUrl;
    private String needcaptchaUrl;
    private String captchaUrl;
    private String host;
    private String protocol;

    public BistuLoginEntityBuilder loginUrl(String loginUrl) {
        URL url = null;
        try {
            url = new URL(loginUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.host = url.getHost();
        this.protocol = url.getProtocol();
        this.loginUrl = loginUrl;
        return this;
    }

    public BistuLoginEntity build() {
        this.needcaptchaUrl = protocol + "://" + host + "/authserver/checkNeedCaptcha.htl";
        this.captchaUrl = protocol + "://" + host + "/authserver/getCaptcha.htl";
//        log.info("是否需要验证码：{}", this.needcaptchaUrl);
//        log.info("验证码链接：{}", this.captchaUrl);
        return new BistuLoginEntity(loginUrl, needcaptchaUrl, captchaUrl);
    }
}
