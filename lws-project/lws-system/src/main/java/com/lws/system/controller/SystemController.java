package com.lws.system.controller;

import com.lws.common.exception.LwsException;
import com.lws.system.dto.SystemDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @ResponseBody
    @PostMapping(value = "/getSystem")
    public SystemDto<String> getAuth() {
        SystemDto dto = new SystemDto();
        dto.setCode("code system");
        dto.setData("this is data");
        return dto;
    }

    @ResponseBody
    @PostMapping("/test2")
    public Long test2() {
        if (1 == 1) {
            throw new LwsException("GG");
        }

        return 1L;
    }

}
