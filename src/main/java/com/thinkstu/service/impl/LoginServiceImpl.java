package com.thinkstu.service.impl;


import com.thinkstu.process.*;
import com.thinkstu.service.*;
import org.apache.commons.lang3.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {

    @Value("${LOGIN_API}")
    private String LOGIN_API;// 登陆接口

    @Override
    public Map<String, String> login(String login_url, String username, String password) throws Exception {
        if (StringUtils.isEmpty(login_url)) {
            login_url = LOGIN_API;
        }

        if (StringUtils.isAllBlank(username) || StringUtils.isAllBlank(password)) {
            throw new RuntimeException("用户名或者密码为空");
        }

        // 封装参数
        Map<String, String> params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);

        // 根据login_url判断类型
        BistuLoginProcess process = new BistuLoginProcess(login_url, params);
        return process.login();
    }


    @Override
    public Map<String, String> login(String username, String password) throws Exception {
        return login(null, username, password);
    }

}
