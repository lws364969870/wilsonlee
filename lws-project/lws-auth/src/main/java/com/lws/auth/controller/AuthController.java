package com.lws.auth.controller;

import com.lws.system.api.SystemFeign;
import org.springframework.web.bind.annotation.PostMapping;
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

}
