package com.yfkj.bms.filter;

import com.alibaba.fastjson.JSONObject;
import com.yfkj.bms.common.AuthUrls;
import com.yfkj.bms.common.util.JwtUtils;
import com.yfkj.bms.domain.SysUser;
import com.yfkj.bms.po.ResponsePO;
import com.yfkj.bms.redis.RedisClientTemplate;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/4/28.
 */
public class AppFilter implements Filter {

   /* @Autowired
    private RedisClientTemplate redisClientTemplate;*/
    private HttpServletRequest request;
    private HttpServletResponse response;

    public void init(FilterConfig config) {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String ip = ((HttpServletRequest) request).getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = ((HttpServletRequest) request).getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = ((HttpServletRequest) request).getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        this.request =(HttpServletRequest)request;
        this.response = (HttpServletResponse) response;
        // 取得根目录所对应的绝对路径:
        String currentURL = this.request.getRequestURI();
        System.out.println(currentURL);
        ResponsePO<String> po=new ResponsePO<String>();
        try {
            String authtoken =  this.request.getHeader("x-access-token");
            if(authtoken==null||"".equals(authtoken)){
                request.setAttribute("loginStatus",0);//未登录
                if(AuthUrls.getUrls().contains(currentURL)){
                    po.setStatus(200);
                    po.setMsg("请登录！");
                    response.getWriter().write(JSONObject.toJSONString(po));
                    return;
                }
            }
            //解密
            Claims claims = JwtUtils.parseToken(authtoken);
            String json = claims.getSubject();
            SysUser user = JSONObject.parseObject(json, SysUser.class);
            if(user!=null){
                //通过userid去缓存中取，若取到再判断user-token与header-token是否一致，若一致则成功
                request.setAttribute("loginUserId","");
                request.setAttribute("loginStatus",1);//已登录
            }
        }catch (Exception e){
            request.setAttribute("loginStatus",0);//未登录
        }
        chain.doFilter(request, response);
    }
    public void destroy() {

    }
}
