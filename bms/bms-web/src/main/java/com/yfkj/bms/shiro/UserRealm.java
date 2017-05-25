package com.yfkj.bms.shiro;

import com.yfkj.bms.common.constants.Constants;
import com.yfkj.bms.domain.SysUser;
import com.yfkj.bms.service.ISysUserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 */
public class UserRealm extends AuthorizingRealm {

    private static final Logger log = LoggerFactory.getLogger("UserRealm");

    @Autowired
    private ISysUserService sysUserService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser user = (SysUser) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        /*//添加用户的角色以及 权限
        authorizationInfo.setRoles(sysUserService.getRoleNameSetByUsername(user.getUsername()));
        log.info("已经添加用户的角色~~~");
        authorizationInfo.setStringPermissions(sysUserService.getAuthSetByUsername(user.getUsername()));
        log.info("已经添加用户的权限~~~");*/
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
    	CaptchaUsernamePasswordToken theToken = (CaptchaUsernamePasswordToken) token;

        String inputCaptcha = theToken.getCaptcha();
        String captcha = (String) SecurityUtils.getSubject().getSession().getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);

        if (!captcha.equalsIgnoreCase(inputCaptcha)) {
            throw new IncorrectCaptchaException("验证码错误");
        }
        
        //对用户信息进行验证 
        String username = (String) token.getPrincipal();
        SysUser user = sysUserService.getUserByUserName(username);

        if (user == null) {
            throw new UnknownAccountException();//没找到帐号
        }

        if (Constants.ONE == user.getDelFlag()) {
            throw new LockedAccountException(); //帐号锁定
        }        
        if(!username.equalsIgnoreCase(user.getUsername())){
        	throw new UnknownAccountException("用户名错误");
        }  
        //交给AuthenticatingRealm使用CredentialsMatcher进行密码匹配 
        //这里传入的密码是密文的
        //这里传入盐会加密后和上面的密码进行比对
        /*SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                getName()
        );*/
        AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),getName());
        return authenticationInfo;
    }

}