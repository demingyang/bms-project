package com.yfkj.bms.po;

import com.yfkj.bms.common.util.StringUtil;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/5/9.
 */
public class ResponsePO<T> implements Serializable{
    private Integer status;
    private T data;
    private String msg;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
