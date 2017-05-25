package com.yfkj.bms.service;

import com.yfkj.bms.po.ResponsePO;

/**
 * Created by Administrator on 2017/5/9.
 */
public interface UserService {
    ResponsePO<String> sendCode(String mobilePhome,String type,String roleType) throws Exception;
    ResponsePO<String> insert() throws Exception;
}
