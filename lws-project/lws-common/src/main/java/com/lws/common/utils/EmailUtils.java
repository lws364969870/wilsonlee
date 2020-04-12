package com.lws.common.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.CollectionUtils;

@Slf4j
public class EmailUtils {

    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sendFrom;

    /**
     * 发送文本邮件
     *
     * @param subject    主题
     * @param sendTo     收件人
     * @param sendCc     抄送人
     * @param sendBcc    密送人
     * @param content    内容
     * @param isHtml     内容是否解析为HTML
     * @param attachment 附件
     */
    public boolean sendSimpleMail(String subject, String[] sendTo, String[] sendCc, String[] sendBcc, String content,
        boolean isHtml, List<File> attachment) throws MessagingException {

        // 建立HTML邮件消息
        MimeMessage mailMessage = javaMailSender.createMimeMessage();

        //是否包含附件
        boolean isFiles = !CollectionUtils.isEmpty(attachment);
        //附件模式要设置为true
        MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, isFiles, "utf-8");
        mailMessage.setFrom(sendFrom);
        //主题
        messageHelper.setSubject(subject);
        //内容
        messageHelper.setText(content, isHtml);
        //设置收信人的email地址
        messageHelper.setTo(sendTo);
        //抄送人
        if (null != sendBcc && sendBcc.length > 0) {
            messageHelper.setBcc(sendBcc);
        }
        //密送人
        if (null != sendCc && sendCc.length > 0) {
            messageHelper.setCc(sendCc);
        }
        //添加附件
        if (isFiles) {
            for (File file : attachment) {
                messageHelper.addAttachment(file.getName(), file);
            }
        }
        //发送邮件
        javaMailSender.send(mailMessage);
        return true;
    }

    @Getter
    @Setter
    class MailBody {
        /**
         * 主题
         */
        private String subject;
        /**
         * 收件人
         */
        private String[] sendTo;
        /**
         * 抄送人
         */
        private String[] sendCc;
        /**
         * 密送人
         */
        private String[] sendBcc;
        /**
         * 内容
         */
        private String content;
        /**
         * 内容是否解析为HTML
         */
        private boolean isHtml = true;
        /**
         * 附件
         */
        private List<File> attachment = new ArrayList<File>();

        public void setSendTo(String... sendTo) {
            this.sendTo = sendTo;
        }

        public void setSendCc(String... sendTo) {
            this.sendTo = sendTo;
        }

        public void setSendBcc(String... sendTo) {
            this.sendTo = sendTo;
        }
    }
}
