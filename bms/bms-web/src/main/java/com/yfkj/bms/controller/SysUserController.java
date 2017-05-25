package com.yfkj.bms.controller;

import com.yfkj.bms.domain.SysUser;
import com.yfkj.bms.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 */
@Controller
@RequestMapping("/sysuser")
public class SysUserController extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(SysUserController.class.getName());

    @Autowired
    private ISysUserService sysUserService;


    /**
     * 去往用户管理列表
     */
    @RequestMapping("/tolist")
    public String tolist(ModelAndView mv){
        System.out.println("shiro控制权限");
        return "success";
    }
    @RequestMapping(value = "/tolist2")
    public @ResponseBody SysUser tolist(SysUser sysUser){
        System.out.println(sysUser);
        System.out.println("authApi已执行....");
        return sysUser;
    }
}
