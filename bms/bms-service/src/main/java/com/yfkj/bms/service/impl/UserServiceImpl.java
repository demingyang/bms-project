package com.yfkj.bms.service.impl;

import com.yfkj.bms.common.common.ResponseDTO;
import com.yfkj.bms.common.common.ReturnCode;
import com.yfkj.bms.common.util.MsgUtils;
import com.yfkj.bms.common.util.StringUtil;
import com.yfkj.bms.service.UserService;
import com.yfkj.bms.po.ResponsePO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by zhangzhixiang on 2017/5/9.
 */
@Service
public class UserServiceImpl implements UserService{
    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class.getName());
    @Override
    public ResponsePO<String> sendCode(String mobilePhome,String type,String roleType) throws Exception{
        ResponsePO<String> vo=new ResponsePO();
        /**1：注册
         * 1.1通过角色判断若存在则不能发送，否则发送
        **/
        if(type.equals("1")){
              return vo;
        }
        if(StringUtil.checkNotEmpty(mobilePhome)&&MsgUtils.isMobile(mobilePhome)) {
            String code=MsgUtils.generatCode(6);
            ResponseDTO dto = MsgUtils.sendMsg(mobilePhome, code);
            vo.setStatus(dto.getCode());
            if(dto.getMessage()==null) {
                vo.setMsg(ReturnCode.codeToEnum(dto.getCode()).msg());
            }
            vo.setData(String.valueOf(dto.getAttach()));
        }else{
            vo.setStatus(300);
            vo.setMsg("手机号不合法!");
        }
        return vo;
    }
    public ResponsePO<String> insert() throws Exception{
        log.info("service层执行");
        return null;
    }
}
