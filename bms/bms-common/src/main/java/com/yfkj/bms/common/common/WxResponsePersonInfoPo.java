package com.yfkj.bms.common.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhangzhixiang on 2017/5/16.
 */
public class WxResponsePersonInfoPo implements Serializable{
    private String userid;
    private String name;
    private List<String> department;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDepartment() {
        return department;
    }

    public void setDepartment(List<String> department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "WxResponsePersonInfoPo{" +
                "userid='" + userid + '\'' +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
