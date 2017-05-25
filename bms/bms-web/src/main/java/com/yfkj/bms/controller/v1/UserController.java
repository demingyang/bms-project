package com.yfkj.bms.controller.v1;

import com.yfkj.bms.domain.SysUser;
import com.yfkj.bms.service.ISysUserService;
import com.yfkj.bms.service.UserService;
import com.yfkj.bms.po.ResponsePO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/4/28.
 */
@Controller
@RequestMapping("/openApi/v1")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private ISysUserService iSysUserService;
    @Autowired
    private UserService userService;

    /**
     * 发送验证码
     * @param mobilePhone
     * @param type
     * @param roleType
     * @return
     */
    @RequestMapping("/getAuthCode/{mobilePhone}/{type}")
    public @ResponseBody ResponsePO<String> sendCode(@PathVariable String mobilePhone,
                                                      @PathVariable String type,@RequestParam String roleType){
        try {
            ResponsePO<String> responsePO = userService.sendCode(mobilePhone, type, roleType);
            return responsePO;
        }catch (Exception e){

        }
       return null;
    }

    /**
     * 对于用户登录我们需要创建token--uid的关系，用户退出时需要需删除token--uid的关系。
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/login")
    public @ResponseBody String login(String username,String password){
        System.out.println("noAuthApi--login已执行...."+username+","+password);
        return "abcd";
    }

    @RequestMapping("/tolist")
    public @ResponseBody SysUser tolist(SysUser sysUser){
        try {
            Timer timer = new Timer();
            timer.schedule(new RemindTask(),0,2000);
        }catch (Exception e){

        }
        return sysUser;
    }
    class RemindTask extends TimerTask {
        public void run() {
            System.out.println("插入");
            SysUser sysUser=new SysUser();
            sysUser.setCreateTime(new Date());
            iSysUserService.insert(sysUser);
        }
    }
}


