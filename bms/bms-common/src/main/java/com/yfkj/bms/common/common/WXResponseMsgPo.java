package com.yfkj.bms.common.common;

import java.io.Serializable;

/**
 * Created by zhangzhixiang on 2017/5/16.
 */
public class WXResponseMsgPo implements Serializable{
    private String errcode;
    private String errmsg;
    private String invaliduser;
    private String invalidparty;

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

    public String getInvaliduser() {
        return invaliduser;
    }

    public void setInvaliduser(String invaliduser) {
        this.invaliduser = invaliduser;
    }

    public String getInvalidparty() {
        return invalidparty;
    }

    public void setInvalidparty(String invalidparty) {
        this.invalidparty = invalidparty;
    }
}
