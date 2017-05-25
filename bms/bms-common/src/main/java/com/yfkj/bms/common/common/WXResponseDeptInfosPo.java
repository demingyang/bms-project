package com.yfkj.bms.common.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangzhixiang on 2017/5/17.
 */
public class WXResponseDeptInfosPo implements Serializable {
    private String errcode;
    private String errmsg;
    private List<WXResponseDeptInfoPo> department;

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

    public List<WXResponseDeptInfoPo> getDepartment() {
        return department;
    }

    public void setDepartment(List<WXResponseDeptInfoPo> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "WXResponseDeptInfosPo{" +
                "errcode='" + errcode + '\'' +
                ", errmsg='" + errmsg + '\'' +
                ", department=" + department +
                '}';
    }
}
