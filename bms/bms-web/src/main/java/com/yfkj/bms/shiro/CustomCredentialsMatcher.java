package com.yfkj.bms.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @Description:
 */
public class CustomCredentialsMatcher extends SimpleCredentialsMatcher {
	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {
		UsernamePasswordToken usertoken = (UsernamePasswordToken) token; 
		String username=usertoken.getUsername();
		//注意token.getPassword()拿到的是一个char[]，不能直接用toString()，它底层实现不是我们想的直接字符串，只能强转
		Object tokenCredentials="";// = Encrypt.mzd5(String.valueOf(usertoken.getPassword()),usertoken.getUsername());
		if(username!=null&&!username.equals("")&&username.length()>=11){
			//tokenCredentials=PasswordHelper.md5(PasswordHelper.md5(username.substring(5,11)+"d")+username.substring(7,11));
			tokenCredentials=PasswordHelper.md5(PasswordHelper.md5(new String(usertoken.getPassword()))+username.substring(7,11));
		}
		Object accountCredentials = getCredentials(info);  
		//将密码加密与系统加密后的密码校验，内容一致就返回true,不一致就返回false
		return equals(tokenCredentials, accountCredentials);  
	}
}
