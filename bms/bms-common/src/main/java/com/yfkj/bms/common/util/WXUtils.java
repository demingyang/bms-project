package com.yfkj.bms.common.util;

import com.alibaba.fastjson.JSONObject;
import com.yfkj.bms.common.common.*;
import com.yfkj.bms.common.constants.WXConstants;
import com.yfkj.bms.common.httpclient.HttpConnectionManager;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangzhixiang on 2017/5/16.
 */
public class WXUtils {
    /**
     * 获取token
     * @param corpid
     * @param secret
     * @return
     */
    public static String createToken(String corpid,String secret){
        Map<String,String> params=new HashMap<String,String>();
        params.put("corpid",corpid);
        params.put("corpsecret",secret);
        ResponseDTO dto= HttpConnectionManager.doGet(WXConstants.CREATE_TOKEN_URL,params);
        WXResponseTokenPo wxPo=null;
        if(dto!=null&&dto.getAttach()!=null) {
            wxPo= JSONObject.parseObject((String) dto.getAttach(), WXResponseTokenPo.class);
            if (wxPo != null) {
                if(wxPo.getErrcode()!=null&&wxPo.getErrcode().equals("0")){
                    return wxPo.getAccess_token();
                }
            }
        }
        return null;
    }


    /**
     * 获取部门成员列表信息
     * @param deptId\部门id
     * @Param fetch_child是否获取子部门下成员 1是 0否
     * @param token
     * @return
     */
    public static WXResponseDeptUsersPo getDeptUserList(String deptId,String fetch_child,String token){
        Map<String,String> params=new HashMap<String,String>();
        params.put("access_token",token);
        params.put("department_id",deptId);
        params.put("fetch_child",fetch_child);
        ResponseDTO dto= HttpConnectionManager.doGet(WXConstants.USER_LIST,params);
        WXResponseDeptUsersPo wxPo=null;
        if(dto!=null&&dto.getAttach()!=null) {
            wxPo= JSONObject.parseObject((String) dto.getAttach(), WXResponseDeptUsersPo.class);
            if (wxPo != null) {
                if(wxPo.getErrcode()!=null&&wxPo.getErrcode().equals("0")){//0成功
                    return wxPo;
                }
            }
        }
        return wxPo;
    }


    /**
     * 通过code和token获取用户信息
     * @param code
     * @param token
     * @return
     */
    public static WXResponseBasicPersonInfoPo getUserInfo(String code,String token){
        Map<String,String> params=new HashMap<String,String>();
        params.put("code",code);
        params.put("access_token",token);
        ResponseDTO dto= HttpConnectionManager.doGet(WXConstants.GET_USER_INFO_URL,params);
        WXResponseBasicPersonInfoPo wxPo=null;
        if(dto!=null&&dto.getAttach()!=null) {
            wxPo= JSONObject.parseObject((String) dto.getAttach(), WXResponseBasicPersonInfoPo.class);
            if (wxPo != null) {
                if(wxPo.getErrcode()!=null&&wxPo.getErrcode().equals("0")){//0成功
                    return wxPo;
                }
            }
        }
        return wxPo;
    }

    /**
     * 拼装创建部门请求头字符串
     * @param name
     * @param parentid
     * @return
     */
    public static String createDeptData(String name , int parentid){
        String Postjson = "{\"name\":"+'"'+name+'"'+",\"parentid\":%s}";
        return String.format(Postjson,parentid);
    }
    /**
     * 通过code和toke创建审核部门
     * @param token
     * @return
     */
    public static WXResponseDeptPo createDept(String token){
       String jsonStr= WXUtilsExt.PostMessage(token, "POST",WXConstants.CREATE_DEPT_URL, createDeptData(WXConstants.AUDIT_DEPT_NAME,1));
        WXResponseDeptPo wxPo=JSONObject.parseObject(jsonStr,WXResponseDeptPo.class);
        return wxPo;
    }

    public static WXResponseBasePo createUser(String token,String userid,String name,String mobile,String department,String email){
        String str=createUserData(userid,name ,mobile,department,email);
        String jsonStr= WXUtilsExt.PostMessage(token, "POST",WXConstants.CREATE_USER, str);
        WXResponseBasePo wxPo=JSONObject.parseObject(jsonStr,WXResponseBasePo.class);
        return  wxPo;
    }
    /**
     * 拼装创建部门请求头字符串
     * @param name
     * @return
     */
    public static String createUserData(String userId,String name ,String mobile,String department,String email){
        String Postjson = "{\"userid\":"+'"'+userId+'"'+",\"name\":"+'"'+name+'"'+",\"mobile\":"+'"'+mobile+'"'+",\"department\":"+'['+department+']'+",\"email\":"+'"'+email+'"'+"}";
        return String.format(Postjson);
    }
    /**
     * 拼装创建部门请求头字符串
     * @return
     */
    public static String createMsg(String auditId,String type,String agentid,String content){
        String Postjson = "{\"touser\":"+'"'+auditId+'"'+",\"msgtype\":"+'"'+type+'"'+",\"agentid\":"+'"'+agentid+'"'+",\"text\":{"+'"'+"content"+'"'+":"+'"'+content+'"'+"}}";
        System.out.println(Postjson);
        return Postjson;
    }

    /**
     * 发微信消息接口
     * @param auditId
     * @param type
     * @param agentid
     * @param content
     * @param token
     * @return
     */
    public static WXResponseBasePo sendMsg(String userId,String type,String agentid,String content,String token){
        String str=createMsg(userId,type ,agentid,content);
        String jsonStr= WXUtilsExt.PostMessage(token, "POST",WXConstants.SEND_URL, str);
        WXResponseBasePo wxPo=JSONObject.parseObject(jsonStr,WXResponseBasePo.class);
        return  wxPo;
    }

    /**
     * 获取用户信息
     * @param userId
     * @param token
     * @return
     */
    public static WXResponsePersonPo getUser(String userId,String token){
        Map<String,String> params=new HashMap<String,String>();
        params.put("userid",userId);
        params.put("access_token",token);
        ResponseDTO dto= HttpConnectionManager.doGet(WXConstants.GET_USER_URL,params);
        WXResponsePersonPo wxPo=null;
        if(dto!=null&&dto.getAttach()!=null) {
            wxPo= JSONObject.parseObject((String) dto.getAttach(), WXResponsePersonPo.class);
            if (wxPo != null) {
                if(wxPo.getErrcode()!=null&&wxPo.getErrcode().equals("0")){//0成功
                    return wxPo;
                }
            }
        }
        return wxPo;
    }

    /**
     * 获取部门信息
     * @param deptId
     * @param token
     * @return
     */
    public static WXResponseDeptInfosPo getDept(String deptId,String token){
        Map<String,String> params=new HashMap<String,String>();
        params.put("id",deptId);
        params.put("access_token",token);
        ResponseDTO dto= HttpConnectionManager.doGet(WXConstants.DEPT_LIST_INFO,params);
        WXResponseDeptInfosPo wxPo=null;
        if(dto!=null&&dto.getAttach()!=null) {
            wxPo= JSONObject.parseObject((String) dto.getAttach(), WXResponseDeptInfosPo.class);
            if (wxPo != null) {
                if(wxPo.getErrcode()!=null&&wxPo.getErrcode().equals("0")){//0成功
                    return wxPo;
                }
            }
        }
        return wxPo;
    }
    public static void main(String[] args) {
        String token="P0_1TZW4LDKHjxwUEVOS4MrNa5naQDG-v7sGtTVA8RnNqOInYqxc49pvnSh6c7Ftqr6ppQFd-8M24O673pFNokgeVkpjcFJhIVnfrrREWbZUw6bjIwMaHihmzeun4QofAot6V9eHdwXms4M8WLq3KRbAHGp2kTZx24dh8RxXfOpJWchK7ACvcfIfMgfFtzYRqzBX197QBcLfGR7pzjKFR4d5lFkUbTS1TI4E15ixtejtl7k9eD-lCU-D12d-utq4cJdeEOEQvsJ__fYMtUwDr6rGpx9rTLzwhQQFK7OfJI8";
        String token2="G12V66JB5g8lc74c-jp6BsLoTptCrWujOL0DMcBxqvc6_acgbw0WlxeanDEjJ3-6VF3O4ejrxsjyej5pK1oNE4hKU1V2uNk7ov8GKJ9gNS6t_m6arrd_TndOHRp0MEi6SfUlscxx51OSFevi_R8dE3WZQ_BV5LHbtdOxSv71NSR4sN1ubBilAC-_NAHrrsMiLyvyB4VKhmaVBpb83Y8_7eL4N1mSr_eOLTUdPsA4cPFvTBreoFhn8MaFE0-SLq32mRBoBVy-ReKeGaixF1zdR7V966ki74qXaL_BILxIYuU";
        /*WXResponseDeptPo wxResponseDeptPo= WXUtils.createUser(token,"zhangzhixiang@efangtec.com","张志祥","13569633175",
                "4","zhangzhixiang@efangtec.com");*/
        /*WXResponseBasePo base=createUser(token,"yangdeming@efangtec.com","杨德明","18035834232",
                "4","yangdeming@efangtec.com");*/
        /*WXResponseDeptUsersPo po=WXUtils.getDeptUserList("4","0",token);
        System.out.println(po.getUserlist());*/

        /*String content="<a href='http://www.xiaochun.website:8089/wxApi/parseMsg?info=\"%7B%22addr%22%3A%22%E5%8C%97%E4%BA%AC%22%2C%22age%22%3A10%2C%22applyDeptName%22%3A%22%E5%BC%80%E5%8F%91%E9%83%A8%22%2C%22applyUserId%22%3A%22zhangzhixiang%40efangtec.com%22%2C%22auditUserId%22%3A%22yangdeming%40efangtec.com%22%2C%22companyId%22%3A1%2C%22diseases%22%3A%22%E6%84%9F%E5%86%92%22%2C%22diseasesTime%22%3A%221998-10-20%22%2C%22gender%22%3A1%2C%22patientName%22%3A%22zzx%22%2C%22phone%22%3A%2213569633175%22%2C%22relation%22%3A1%7D\"'>"+WXConstants.MSG;
        content=WXConstants.MSG;
        content="<a href='http://www.xiaochun.website:8089/wxApi/parseMsg?info=rId%22%3A%22zhangzhixiang%40efangtec.com%22%2C%22auditUserId%22%3A%22yangdeming%40efangtec.com%22%2C%22companyId%22%3A1%2C%22diseases%22%3A%22%E6%84%9F%E5%86%92%22%2C%22diseasesTime%22%3A%221998-10-20%22%2C%22gender%22%3A1%2C%22patientName%22%3A%22zzx%22%2C%22phone%22%3A%2213569633175%22%2C%22relation%22%3A1%7D'>"+WXConstants.MSG;
        WXResponseBasePo po=WXUtils.sendMsg("zhangzhixiang@efangtec.com","text","1000003",content,token);
        System.out.println(po);*/
        WXResponsePersonPo po=getUser("zhangzhixiang@efangtec.com",token);
        System.out.println(po.getDepartment().get(0));
        //System.out.println(getDept("4",token));
    }
}
