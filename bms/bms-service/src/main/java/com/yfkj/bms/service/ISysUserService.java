package com.yfkj.bms.service;

import com.yfkj.bms.common.common.PageVo;
import com.yfkj.bms.domain.SysUser;
import com.yfkj.bms.interceptor.PageList;

import java.util.Set;

/**
 */
public interface ISysUserService {


    SysUser getUserByUserName(String userName);
    int insert(SysUser sysUser);

}
