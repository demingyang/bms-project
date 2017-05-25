package com.yfkj.bms.common.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yfkj.bms.common.common.MsgResponsePo;
import com.yfkj.bms.common.common.ResponseDTO;
import com.yfkj.bms.common.httpclient.HttpConnectionManager;
import net.sf.json.util.JSONUtils;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangzhixiang on 2017/5/11.
 */
public class MsgUtils {
    private static String SEND_MSG_URL="http://api.chanzor.com/send";
    private static String SEND_MSG_ACCOUNT="yifangkeji1";
    private static String SEND_MSG_PASSWORD="7m0e7wtt";
    private static String SEND_MSG_SIGN_NAME="【医方科技】";
    public static ResponseDTO sendMsg(String mobilePhone, String content){
        Map<String,String> params=new HashMap<String,String>();
        params.put("mobile",mobilePhone);
        params.put("content",content+SEND_MSG_SIGN_NAME);
        params.put("account",SEND_MSG_ACCOUNT);
        params.put("password",SEND_MSG_PASSWORD);
        ResponseDTO dto= HttpConnectionManager.doPost(SEND_MSG_URL,params);
        System.out.println(dto.getCode()+"....."+(String)dto.getAttach());
        if(dto!=null&&dto.getAttach()!=null) {
            MsgResponsePo msgPo = JSONObject.parseObject((String) dto.getAttach(), MsgResponsePo.class);
            System.out.println(msgPo);
            if (msgPo != null) {
                if(!msgPo.getStatus().equals("0")){//0成功
                    dto.setMessage(msgPo.getDesc());
                }
            }
        }
        return dto;
    }

    public static String generatCode(int length){
        Random random = new Random();
        String result="";
        for(int i=0;i<length;i++) {
            result += random.nextInt(10);
        }
        return result;
    }
    /**
     * 手机号验证
     *
     * @param  str
     * @return 验证通过返回true
     */
    public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);
        b = m.matches();
        return b;
    }

}
