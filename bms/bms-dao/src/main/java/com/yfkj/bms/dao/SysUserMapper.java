package com.yfkj.bms.dao;

import com.yfkj.bms.common.common.PageVo;
import com.yfkj.bms.common.common.Pageable;
import com.yfkj.bms.domain.SysUser;
import com.yfkj.bms.interceptor.PageList;

import org.apache.ibatis.annotations.Param;

public interface SysUserMapper {

    SysUser getUserByUserName(String username);

    int modifyPassword(SysUser record);

    PageList<SysUser> findUserList(@Param("vo") PageVo vo, Pageable pageable);
    int insert(SysUser sysUser);
}