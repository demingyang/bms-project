package com.yfkj.bms.domain;

public class WXAuditDept {
    private Integer id;

    private Integer companyId;

    private Integer auditDeptId;

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

    public Integer getAuditDeptId() {
        return auditDeptId;
    }

    public void setAuditDeptId(Integer auditDeptId) {
        this.auditDeptId = auditDeptId;
    }
}