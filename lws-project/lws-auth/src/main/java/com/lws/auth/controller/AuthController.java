package com.lws.auth.controller;

import com.lws.auth.constant.AccountEnum;
import com.lws.auth.dto.LoginDto;
import com.lws.system.api.SystemFeign;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class AuthController {

    @Resource
    private SystemFeign systemFeign;

    @PostMapping("/getAuth")
    public Object getAuth() {
        return "ggasdas";
    }


    @ResponseBody
    @PostMapping("/getFeign")
    public Object getFeign() {
        return systemFeign.getSystem();
    }

    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
        boolean result = AccountEnum.checkAccount(loginDto.getUserName(), loginDto.getPwd());
        return result + "";
    }

}
