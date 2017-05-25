package com.yfkj.bms.common.util;

import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zhangzhixiang on 2017/5/17.
 */
public class WXUtilsExt {
    /**
     * 发起https请求并获取结果
     *
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值)
     */
    public static JSONObject HttpRequest(String request , String RequestMethod , String output ){
        @SuppressWarnings("unused")
        JSONObject jsonObject = null;
        StringBuffer buffer = new StringBuffer();
        try {
            //建立连接
            URL url = new URL(request);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(RequestMethod);
            if(output!=null){
                OutputStream out = connection.getOutputStream();
                out.write(output.getBytes("UTF-8"));
                out.close();
            }
            //流处理
            InputStream input = connection.getInputStream();
            InputStreamReader inputReader = new InputStreamReader(input,"UTF-8");
            BufferedReader reader = new BufferedReader(inputReader);
            String line;
            while((line=reader.readLine())!=null){
                buffer.append(line);
            }
            //关闭连接、释放资源
            reader.close();
            inputReader.close();
            input.close();
            input = null;
            connection.disconnect();
            jsonObject = JSONObject.fromObject(buffer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    /**
     * 数据提交与请求通用方法
     * @param access_token 凭证
     * @param RequestMt 请求方式
     * @param RequestURL 请求地址
     * @param outstr 提交json数据
     * */
    public static String PostMessage(String access_token ,String RequestMt , String RequestURL , String outstr){
        RequestURL = RequestURL.replace("ACCESS_TOKEN", access_token);
        JSONObject jsonobject = HttpRequest(RequestURL, RequestMt, outstr);
        return jsonobject.toString();
    }

    /*public static void main(String[] args) {
        String PostData = Create("医方审核部门", 1);
        System.out.println(PostData);
        String token="G12V66JB5g8lc74c-jp6BsLoTptCrWujOL0DMcBxqvc6_acgbw0WlxeanDEjJ3-6VF3O4ejrxsjyej5pK1oNE4hKU1V2uNk7ov8GKJ9gNS6t_m6arrd_TndOHRp0MEi6SfUlscxx51OSFevi_R8dE3WZQ_BV5LHbtdOxSv71NSR4sN1ubBilAC-_NAHrrsMiLyvyB4VKhmaVBpb83Y8_7eL4N1mSr_eOLTUdPsA4cPFvTBreoFhn8MaFE0-SLq32mRBoBVy-ReKeGaixF1zdR7V966ki74qXaL_BILxIYuU";
        String url="https://qyapi.weixin.qq.com/cgi-bin/department/create?access_token=ACCESS_TOKEN";
        // 提交数据,获取结果
       // int result = PostMessage(token, "POST", url, PostData);
    }*/
}
