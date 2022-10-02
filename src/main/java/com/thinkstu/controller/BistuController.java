package com.thinkstu.controller;

import com.thinkstu.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/bistu")
public class BistuController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "login", method = {RequestMethod.GET, RequestMethod.POST})
    public Map<String, Object> login(@RequestParam(value = "login_url", required = false) String login_url,
                                     @RequestParam("username") String username,
                                     @RequestParam("password") String password) {

        Map<String, Object> map = new HashMap<>();

        try {
            map.put("code", 0);
            map.put("msg", "login success!");
            Map<String, String> cookies = loginService.login(login_url, username, password);
            if (cookies == null) {
                throw new RuntimeException("登陆失败，cookies返回为null");
            }
            StringBuffer buffer = new StringBuffer();
            int          size   = 0;
            for (String key : cookies.keySet()) {
                if (size == cookies.size() - 1) {
                    buffer.append(key);
                    buffer.append('=');
                    buffer.append(cookies.get(key));
                } else {
                    buffer.append(key);
                    buffer.append('=');
                    buffer.append(cookies.get(key));
                    buffer.append(';');
                }
                size++;
            }
            map.put("cookies", buffer.toString());
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", 1);
            map.put("msg", "login failed! " + e.getMessage());
            map.put("cookies", null);
            return map;
        }
    }
}
