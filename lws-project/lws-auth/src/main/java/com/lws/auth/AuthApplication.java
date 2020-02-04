package com.lws.auth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients({"com.lws.system.api"})
@SpringBootApplication(scanBasePackages = {"com.lws.auth", "com.lws.system", "com.lws.common"})
public class AuthApplication {

    public static void main(String[] args) {

        SpringApplication.run(AuthApplication.class, args);
        log.info("auth 启动成功 !!!!");
    }
}
