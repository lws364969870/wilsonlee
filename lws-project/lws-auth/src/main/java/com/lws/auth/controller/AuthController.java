package com.lws.auth.controller;

import com.lws.auth.constant.AccountEnum;
import com.lws.auth.dto.LoginDto;
import com.lws.common.utils.EmailUtils;
import com.lws.system.api.SystemFeign;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AuthController {

    @Resource
    private SystemFeign systemFeign;
    @Resource
    private EmailUtils emailUtils;

    @PostMapping("/getAuth" )
    public Object getAuth() {
        return "ggasdas";
    }


    @ResponseBody
    @PostMapping("/getFeign" )
    public Object getFeign() {
        return systemFeign.getSystem();
    }

    @ResponseBody
    @PostMapping("/login" )
    public String login(@RequestBody LoginDto loginDto) {
        boolean result = AccountEnum.checkAccount(loginDto.getUserName(), loginDto.getPwd());
        return result + "";
    }


    @ResponseBody
    @GetMapping("/sendMail" )
    public String sendMail() {
        String subject = "主题"; //主题
        String[] sendTo = new String[]{"364969870@qq.com"}; //收件人
        String[] sendCc = new String[]{}; //抄送人
        String[] sendBcc = new String[]{}; //密送人
        String content = "内容"; //内容
        boolean isHtml = true; //内容是否解析为HTML
        List<File> attachment = new ArrayList<File>(); //附件
        try {
            emailUtils.sendSimpleMail(subject, sendTo, sendCc, sendBcc, content, isHtml, attachment);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "";
    }

}
