package com.yfkj.bms.domain;

public class WXSecret {
    private Integer id;

    private Integer companyId;

    private String corpid;

    private String secret;

    private String agentid;

    private String txlSecret;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCorpid() {
        return corpid;
    }

    public void setCorpid(String corpid) {
        this.corpid = corpid == null ? null : corpid.trim();
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret == null ? null : secret.trim();
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid == null ? null : agentid.trim();
    }

    public String getTxlSecret() {
        return txlSecret;
    }

    public void setTxlSecret(String txlSecret) {
        this.txlSecret = txlSecret;
    }
}