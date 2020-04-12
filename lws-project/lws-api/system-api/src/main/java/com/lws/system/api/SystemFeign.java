package com.lws.system.api;

import com.lws.system.dto.SystemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(name = "system", url = "localhost:9001")
public interface SystemFeign {

    @ResponseBody
    @PostMapping(value = "/getSystem")
    public SystemDto getSystem();
}
