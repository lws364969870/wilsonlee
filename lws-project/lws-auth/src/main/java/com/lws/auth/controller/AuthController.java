package com.lws.auth.controller;

import javax.annotation.Resource;

import com.lws.auth.constant.AccountEnum;
import com.lws.auth.dto.LoginDto;
import com.lws.common.utils.EmailUtils;
import com.lws.system.api.SystemFeign;
import com.lws.system.dto.ChildA;
import com.lws.system.dto.System2Dto;
import com.lws.system.dto.SystemDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Resource
    private SystemFeign systemFeign;

    private EmailUtils emailUtils;

    @PostMapping("/getAuth")
    public Object getAuth() {
        return "ggasdas";
    }

    @ResponseBody
    @PostMapping("/getFeign")
    public Object getFeign() {
        SystemDto<System2Dto> systemDto = systemFeign.getSystem();
        System2Dto system2Dto =  systemDto.getJSONData();
        System2Dto<ChildA> dto = systemDto.getData();

        ChildA childA = dto.getData();

        return systemDto;
    }

    @ResponseBody
    @PostMapping("/login")
    public boolean login(@RequestBody LoginDto loginDto) {
        boolean result = AccountEnum.checkAccount(loginDto.getUserName(), loginDto.getPwd());
        return result;
    }

    @ResponseBody
    @GetMapping("/sendMail")
    public String sendMail() {
        if (1 == 1) {
            throw new RuntimeException("gg");
        }
        return "";
        //        String subject = "主题"; //主题
        //        String[] sendTo = new String[]{"364969870@qq.com"}; //收件人
        //        String[] sendCc = new String[]{}; //抄送人
        //        String[] sendBcc = new String[]{}; //密送人
        //        String content = "内容"; //内容
        //        boolean isHtml = true; //内容是否解析为HTML
        //        List<File> attachment = new ArrayList<File>(); //附件
        //        try {
        //            emailUtils.sendSimpleMail(subject, sendTo, sendCc, sendBcc, content, isHtml, attachment);
        //        } catch (MessagingException e) {
        //            e.printStackTrace();
        //        }
        //        return "";
    }

}
