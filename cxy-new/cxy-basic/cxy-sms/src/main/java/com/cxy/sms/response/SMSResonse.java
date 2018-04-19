package com.cxy.sms.response;

import java.util.List;

public class SMSResonse {

    public static final String SUCCESS = "000000";
    public static final String FAILURE = "00141";

    private String respCode;
    private String respDesc;
    private Integer failCount;
    private List<String> failList;
    private String smsId;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private String state;


    public String getRespCode() {
        return respCode;
    }

    public void setRespCode(String respCode) {
        this.respCode = respCode;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

    public Integer getFailCount() {
        return failCount;
    }

    public void setFailCount(Integer failCount) {
        this.failCount = failCount;
    }

    public List<String> getFailList() {
        return failList;
    }

    public void setFailList(List<String> failList) {
        this.failList = failList;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public void switchState(){
        System.out.println(this.respCode);
        if (SUCCESS.equals(this.respCode)){
            this.state=SUCCESS;
        }else{
            this.state = FAILURE;
        }
    }
}
