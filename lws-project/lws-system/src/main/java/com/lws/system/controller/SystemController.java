package com.lws.system.controller;

import com.lws.common.exception.LwsException;
import com.lws.system.dto.ChildA;
import com.lws.system.dto.System2Dto;
import com.lws.system.dto.SystemDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SystemController {

    @ResponseBody
    @PostMapping(value = "/getSystem")
    public SystemDto getAuth() {


        ChildA childA = new ChildA();
        childA.setHour("50");
        childA.setMinute("60");
        childA.setSecond("70");


        System2Dto dto2 = new System2Dto();
        dto2.setData(childA);

        SystemDto dto = new SystemDto();
        dto.setCode("code system");
        dto.setData(dto2);

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
