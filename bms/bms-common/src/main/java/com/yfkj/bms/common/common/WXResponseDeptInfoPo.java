package com.yfkj.bms.common.common;

import java.io.Serializable;

/**
 * Created by zhangzhixiang on 2017/5/17.
 */
public class WXResponseDeptInfoPo implements Serializable{
    private String id;
    private String name;
    private String parentid;
    private String order;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "WXResponseDeptInfoPo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", parentid='" + parentid + '\'' +
                ", order='" + order + '\'' +
                '}';
    }
}
