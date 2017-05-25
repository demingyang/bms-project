package com.yfkj.bms.common.common;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:  RelationEnum
 */
public enum RelationEnum {

	FATHER(1, "父亲"),
    MOTHER(2, "母亲"),
    CHILD(3, "子女"),
    MATE(4, "配偶"),
    MYSELF(5, "本人");

	private int code;

	private String msg;

	private RelationEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public static RelationEnum codeToEnum(int code) {

        RelationEnum[] values = RelationEnum.values();
        for (RelationEnum returnCode : values) {
            if (returnCode.code == code) {
                return returnCode;
            }
        }
        return null;
    }

    public int code() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String msg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, ?> Map() {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", this.msg);
        return hashMap;
    }

    public Map<String, ?> Map(int code) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", this.msg);
        return hashMap;
    }

    public Map<String, ?> Map(Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", this.code);
        hashMap.put("msg", msg);
        return hashMap;
    }

    public Map<String, ?> Map(int code, Object msg) {
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        hashMap.put("code", code);
        hashMap.put("msg", msg);
        return hashMap;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{\"code\":").append(this.code).append(",");
        sb.append("\"msg\":\"").append(this.msg).append("\"}");

        return sb.toString();
    }
	

}
