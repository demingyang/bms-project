package com.yfkj.bms.common.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangzhixiang on 2017/5/16.
 */
public class WXResponseDeptUsersPo implements Serializable{
    private String errcode;
    private String errmsg;
    private List<WxResponsePersonInfoPo> userlist;

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

    public List<WxResponsePersonInfoPo> getUserlist() {
        return userlist;
    }

    public void setUserlist(List<WxResponsePersonInfoPo> userlist) {
        this.userlist = userlist;
    }

    @Override
    public String toString() {
        return "WXResponseDeptUsersPo{" +
                "errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", userlist=" + userlist +
                '}';
    }
}
