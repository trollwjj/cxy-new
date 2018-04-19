package com.cxy.email.handler;

import com.cxy.background.entity.User;
import com.cxy.common.pojo.State;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;


public class EmailHandler {

    @Autowired
    private JavaMailSender javaMailSender;

    public String sendEmail(String receive,String subject,String content){

        System.out.println("receive :" +receive);
        System.out.println("subject :" + subject);
        System.out.println("content :" + content);

        SimpleMailMessage sms = new SimpleMailMessage();
        sms.setTo(receive);
        sms.setSubject(subject);
        sms.setText(content);
        javaMailSender.send(sms);
        return State.SUCCESS;
    }

    public void sendActivityEmail(String json){

        System.out.println("json:"+json);
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);
        String subject = "【爱上优品】注册激活";
        String content= "请点击下面的链接激活您的账号\n" +
                " http:\\localhost:8084\\register\\activity?userId="+user.getId()+"&activityUUID=" + user.getActivtUuid();
        sendEmail(user.getEmail(), subject, content);
    }
}
