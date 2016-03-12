/*
        Copyright  DR.YangLong

        Licensed under the Apache License, Version 2.0 (the "License");
        you may not use this file except in compliance with the License.
        You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

        Unless required by applicable law or agreed to in writing, software
        distributed under the License is distributed on an "AS IS" BASIS,
        WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        See the License for the specific language governing permissions and
        limitations under the License.
*/
package org.apache.mycat.advisor.common.net.mail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;

/**
 * 功能或描述：邮件发送实现类
 *
 * @Package mail
 * @Author: DR.YangLong
 * @Date: 14-9-23
 * @Time: 下午4:00
 * @Email: 410357434@163.com
 * @Version: 1.0
 * @Module: 修正:            日期：
 */
public class MailSender {
    private static final Logger logger = LoggerFactory.getLogger(MailSender.class);
    /**
     * spring实现的邮件发送类
     * @see org.springframework.mail.javamail.JavaMailSenderImpl
     */
    private JavaMailSenderImpl javaMailSender;
    /**
     * 发送邮件的地址
     */
    private String sender;

    /**
     * 发送简单文本邮件
     *
     * @param accepter 接收人地址
     * @param subject  主题
     * @param context  内容
     */
    public void sendTextMail(final String accepter, final String subject, final String context) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(accepter);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(context);
            javaMailSender.send(simpleMailMessage);
        } catch (MailException e) {
           logger.error("发送简单文本邮件失败！错误信息："+e.getMessage());
        }
    }

    /**
     * 发送不带附件的简单Html邮件
     *
     * @param accepter 接收人地址
     * @param subject  主题
     * @param context  内容
     */
    public void sendSimpleHtmlMail(final String accepter, final String subject, final String context) {
        try{
            MimeMessage mailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mailHelper=new MimeMessageHelper(mailMessage,true,"UTF-8");
            mailHelper.setFrom(sender);
            mailHelper.setTo(accepter);
            mailHelper.setSubject(subject);
            mailHelper.setText(context,true);
            javaMailSender.send(mailMessage);
        }catch (Exception e){
            logger.error("发送简单html邮件失败！错误信息："+e.getMessage());
        }

    }

    public JavaMailSenderImpl getJavaMailSender() {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSenderImpl javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
