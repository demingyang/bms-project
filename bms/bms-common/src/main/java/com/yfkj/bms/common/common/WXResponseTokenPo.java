package com.yfkj.bms.common.common;

import java.io.Serializable;

/**
 * Created by zhangzhixiang on 2017/5/16.
 */
public class WXResponseTokenPo implements Serializable{
    private String errcode;
    private String errmsg;
    private String access_token;
    private Integer expires_in;

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

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Integer getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(Integer expires_in) {
        this.expires_in = expires_in;
    }
}
