package com.cxy.register.controller;


import com.alibaba.druid.support.spring.stat.annotation.Stat;
import com.cxy.background.entity.User;
import com.cxy.common.pojo.State;
import com.cxy.register.service.IRegisterService;
import com.cxy.sms.SMSUtils;
import com.cxy.sms.response.SMSResonse;
import com.google.gson.Gson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("register")
public class RegisterController {

    @Autowired
    private IRegisterService registerService;

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @ResponseBody
    @RequestMapping("sendSMSCode/{phone}")
    public String sendSMSCode(@PathVariable String phone){

        System.out.println("phone = " + phone);
        String smsCode = createSMSCode(6);
        System.out.println(smsCode);
        String smsContent = "【爱上良品】尊敬的用户，您好，您正在注册\"爱上良品\"网站，验证码为"+smsCode+"，请于5分钟内正确输入，如非本人操作，请忽略此短信。";
        SMSResonse smsResonse = SMSUtils.sendMessage(phone, smsContent);
        System.out.println("state = " +smsResonse.getState());
        if (smsResonse.getState().equals(SMSResonse.SUCCESS)){
            return State.SUCCESS;
        }
        return State.ERROR;
    }
    
    private String createSMSCode(int length){

        Random random = new Random();
        int randomInt = random.nextInt(9*((int)Math.pow(10,length-1)))+100000;
        return randomInt+"";

    }


    @RequestMapping("register")
    @ResponseBody
    public String register(User user){

        String uuidString = UUID.randomUUID().toString();
        user.setActivtUuid(uuidString);
        int result = registerService.register(user);

        if (result > 0){

            Gson gson = new Gson();
            String json = gson.toJson(user);
            System.out.println("json = " + json);
            System.out.println(result);

            rabbitTemplate.convertAndSend("user.register", json);
            return State.SUCCESS;
        }

        return State.ERROR;
    }


    @RequestMapping("activity")
    @ResponseBody
    public String activity(Integer userId, String activityUUID){

        int result = registerService.activity(userId, activityUUID);

        if (result > 0){
            return State.SUCCESS;
        }

        return State.ERROR;
    }
}
