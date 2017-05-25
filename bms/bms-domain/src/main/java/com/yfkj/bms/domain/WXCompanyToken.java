package com.yfkj.bms.domain;

import java.util.Date;

public class WXCompanyToken {
    private Integer id;

    private String accessToken;

    private Integer companyId;
    private Date updateTime;

    private String txlToken;

    private Date txlUpdateTime;//通讯录token更新时间

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken == null ? null : accessToken.trim();
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getTxlToken() {
        return txlToken;
    }

    public void setTxlToken(String txlToken) {
        this.txlToken = txlToken;
    }

    public Date getTxlUpdateTime() {
        return txlUpdateTime;
    }

    public void setTxlUpdateTime(Date txlUpdateTime) {
        this.txlUpdateTime = txlUpdateTime;
    }
}