package com.cxy.sms;

import com.cxy.sms.response.SMSResonse;
import com.google.gson.Gson;

public class SMSUtils {


    private static String operation = "/industrySMS/sendSMS";

    private static String accountSid = Config.ACCOUNT_SID;

    /**
     * 验证码通知短信
     */
    public static SMSResonse sendMessage(String to, String smsContent)
    {
        String url = Config.BASE_URL + operation;
        String body = "accountSid=" + accountSid + "&to=" + to + "&smsContent=" + smsContent
                + HttpUtil.createCommonParam();

        // 提交请求
        String result = HttpUtil.post(url, body);
        System.out.println("result:" + System.lineSeparator() + result);

        Gson gson = new Gson();
        SMSResonse smsResonse = gson.fromJson(result, SMSResonse.class);
        smsResonse.switchState();
        return smsResonse;
    }

}
