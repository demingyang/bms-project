package com.yfkj.bms.common.common;

/**
 * Created by zhangzhixiang on 2017/5/16.
 */
public class WXResponseBasicPersonInfoPo {
    private String errcode;
    private String errmsg;
    private String UserId;
    private String DeviceId;
    private String user_ticket;
    private String expires_in;
    private String userId;
    private String deviceId;
    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        this.UserId = userId;
        this.userId = userId;
    }

    public String getDeviceId() {
        return DeviceId;
    }

    public void setDeviceId(String deviceId) {
        this.DeviceId = deviceId;
        this.deviceId=deviceId;
    }

    public String getUser_ticket() {
        return user_ticket;
    }

    public void setUser_ticket(String user_ticket) {
        this.user_ticket = user_ticket;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
}
