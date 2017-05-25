package com.yfkj.bms.common.common;

import java.math.BigDecimal;

/**
 * Created by zhangzhixiang on 2017/5/11.
 */
public class MsgResponsePo {
    private String status;
    private String desc;
    private BigDecimal mobileCount;
    private String taskId;
    private Integer overage;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public BigDecimal getMobileCount() {
        return mobileCount;
    }

    public void setMobileCount(BigDecimal mobileCount) {
        this.mobileCount = mobileCount;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Integer getOverage() {
        return overage;
    }

    public void setOverage(Integer overage) {
        this.overage = overage;
    }

    @Override
    public String toString() {
        return "MsgResponsePo{" +
                "status='" + status + '\'' +
                ", desc='" + desc + '\'' +
                ", mobileCount=" + mobileCount +
                ", taskId=" + taskId +
                ", overage=" + overage +
                '}';
    }
}
