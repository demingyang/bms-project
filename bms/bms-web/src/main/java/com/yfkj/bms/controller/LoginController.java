package com.yfkj.bms.controller;

import javax.servlet.http.HttpServletRequest;

import com.yfkj.bms.shiro.IncorrectCaptchaException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yfkj.bms.common.JsonResult;
import com.yfkj.bms.domain.SysUser;

/**
 */
@Controller
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(LoginController.class.getName());
    @Autowired
    private DefaultWebSessionManager sessionManager;

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("index")
    public String index() {
        log.info("登录....");
        log.debug("登录....");

        return "login";
    }

    /**
     *
     */
    @RequestMapping("main")
    public String main() {
        log.info("登录成功....");
        log.debug("登录成功.....");
        return "main";
    }

    /**
     * 登出 跳转到主页面
     *
     * @return
     */
    @RequestMapping("logout")
    public String logout() {
        log.info("注销中....");
        log.debug("注销中....");
        SecurityUtils.getSubject().logout();
        return "redirect:/index";
    }

    /**
     *
     */
    @RequestMapping("dologin")
    public String dologin(HttpServletRequest request,Model mode) {
        log.info("登录中....");
        log.debug("登录中....");
        String loginFailure = (String) request.getAttribute("shiroLoginFailure");
        JsonResult loginMessage=new JsonResult();
        SysUser user=new SysUser();
        //可以在这里放 错误信息  从这里就可以拿到认证异常了
        if (loginFailure != null) {
        	 String username = WebUtils.getCleanParam(request,"username");
             String password = WebUtils.getCleanParam(request,"password");
             user.setUsername(username);
             user.setPassword(password);
             mode.addAttribute("user",user);
          if (UnknownAccountException.class.getName().equals(loginFailure)) {  
        	  loginMessage.setMsg("用户名或密码不正确");        	  
        	  mode.addAttribute("loginMessage", loginMessage);
        	  return "forward:/index";
          } else if (IncorrectCredentialsException.class.getName().equals(loginFailure)) {                    
        	  loginMessage.setMsg("用户名或密码不正确");
        	  mode.addAttribute("loginMessage", loginMessage);
        	  return "forward:/index";
          }else if(IncorrectCaptchaException.class.getName().equals(loginFailure)){
        	  loginMessage.setMsg("验证码不正确");
        	  mode.addAttribute("loginMessage", loginMessage);
        	  return "forward:/index"; 
          }else {  
        	  loginMessage.setMsg("未知错误");
        	  mode.addAttribute("loginMessage",loginMessage);
        	  return "forward:/index";    
          }         
       }     
        return "redirect:/main";
    }
}
