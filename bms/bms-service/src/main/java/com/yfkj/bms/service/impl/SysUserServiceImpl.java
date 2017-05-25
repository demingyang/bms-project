package com.yfkj.bms.service.impl;

import com.yfkj.bms.common.util.ServiceValidate;
import com.yfkj.bms.dao.SysUserMapper;
import com.yfkj.bms.domain.SysUser;
import com.yfkj.bms.service.ISysUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 */
@Service
public class SysUserServiceImpl implements ISysUserService {
    private static final Logger log = LoggerFactory.getLogger("service");

    @Autowired
    private SysUserMapper sysUserMapper;



    @Override
    public SysUser getUserByUserName(String userName) {
        if (StringUtils.isEmpty(userName)) {
            ServiceValidate.isTrue(Boolean.FALSE, "用户名不能为空");
        }
        log.info("检查用户名通过...");
        return sysUserMapper.getUserByUserName(userName);
    }
    public int insert(SysUser sysUser){
        return sysUserMapper.insert(sysUser);
    }





}
