package com.yfkj.bms.common.constants;

/**
 * Created by zhangzhixiang on 2017/5/16.
 */
public class WXConstants {
    public static String str_pubK = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYqJKj+DIhGq49WVkakIEhBgITZxB2idcxjFgFFUSJ2wLQYpuXWQTvD+ne7O9CQfU/SFlTBcT1UPa4m3OAixi5CioFrXkWLfsXNJ69iLd71FVKd4pOEq/cvHyIw/fC2P8IdJpTd+5dkwYQmhWmFCblIW/EtAJtHSOF1YL1R710lQIDAQAB";

    public static String str_priK ="MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJiokqP4MiEarj1ZWRqQgSEGAhNn"+
            "EHaJ1zGMWAUVRInbAtBim5dZBO8P6d7s70JB9T9IWVMFxPVQ9ribc4CLGLkKKgWteRYt+xc0nr2I"+
            "t3vUVUp3ik4Sr9y8fIjD98LY/wh0mlN37l2TBhCaFaYUJuUhb8S0Am0dI4XVgvVHvXSVAgMBAAEC"+
            "gYAP/uHWooQGKfiF3x3SBcAyCKIhDFSSRyEwROdYKQFUfIlP8nUhJ6e3sPAtdqAfTi/3YIpTg7A+"+
            "kCw57bftiSWe3HA5+9+k6pc1p+8LAW2q4SqlXvuDJ+ALJeykUgswOrSbWP1xBTp1xN33rCeGMQjc"+
            "4qL6WTe8Qop0Pknv1SAGZQJBANBy+eAOsdlPIzXANCAJADFHL6iIwjn6YtqFxeHss0/n2rqS9yXI"+
            "gzIpHKdWLs+znNKvq2O9faclSAPPeoUCgeMCQQC7e4gp9TE2IofhBPl0SarDxGHzxKnOE6TUg4U7"+
            "59vCBddwaLwkY0C8gawH8+fU1S6abvEBwUhma715fZGJSZknAkEAqP5N7oR7U36BQTaOC9rAOTNJ"+
            "RA17yZ1hP2BsyXko9oM2JUS48fzZwHTsMg4A7YrkfTrGbJpXoIbtF4nB/svFmQJBAI9py5rs6JwU"+
            "hgRnHbsKrwnZq2QhSBNPi4LUqJJOphghB9ABDgp3sgmA1+utc+WmvWN9Afbpt0xBlkrc9vshxXkC"+
            "QGpHJA1G5BLwJk6yb+MhA9LNLBqPFUay7eSCJl/GaWfk4LAe6A3x8v/P2mnq78MVbUlqnaFW5JFz"+
            "gbyGEjBUNlc=";

    //创建TOKEN(用于调用接口)
    public static String CREATE_TOKEN_URL="https://qyapi.weixin.qq.com/cgi-bin/gettoken";
    //发送消息
    public static String SEND_URL="https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=ACCESS_TOKEN";
    //获取用户信息
    public static String GET_USER_URL="https://qyapi.weixin.qq.com/cgi-bin/user/get";


    //
    public static String MSG="有申请需要审核</a>";

    public static String GET_CODE_URL="https://open.weixin.qq.com/connect/oauth2/authorize?response_type=code&scope=snsapi_userinfo";
    //后缀
    public static String GET_CODE_URL_SUFFIX="#wechat_redirect";

    //获取个人信息
    public static String GET_USER_INFO_URL="https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo";


    public static String AUDIT_REDIRECT_URL="http://www.xiaochun.website:8089/wxApi/examine";
    public static String GET_CODE_REDIRECT_URL="www.xiaochun.website:8089/wxApi/getCode";

    public static String AUDIT_DEPT_NAME="医方审核部";
    public static String CREATE_DEPT_URL="https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN";

    public static String CREATE_USER="https://qyapi.weixin.qq.com/cgi-bin/user/create?access_token=ACCESS_TOKEN";

    //用户列表
    public static String USER_LIST="https://qyapi.weixin.qq.com/cgi-bin/user/simplelist";

    //获取部门
    public static String DEPT_LIST_INFO="https://qyapi.weixin.qq.com/cgi-bin/department/list";

    public static String MSG_AGREE_APPLY="您的申请已审核通过!";
    public static String MSG_REFUSE_APPLY="您的申请已被拒绝!";
    public static String EMAIL_MSG="有新的申请通过的订单：<br/>详情如下：<br/> 申请人信息：<br/>公司：${companyName}<br/>" +
            "姓名：${applyUserName}<br/>手机号：${applyPhoneNumber}<br/>邮箱：${applyUserId}<br/>部门：${applyDeptName}<br/><br/>" +
            "患者信息如下：<br/>姓名：${patientName}<br/>手机号：${contactPhoneNumber}<br/>关系：${relation}<br/>年龄：${age}<br/>性别：${gender}<br/>病种：${diseases}<br/>";

    public static String EMAIL_CUSTOM="shenxiang@efangtec.com";
    public static String EMAIL_USER_NAME="zhangzhixiang@efangtec.com";
    public static String EMAIL_USER_PASSWORD="1356963zhanG";
}
