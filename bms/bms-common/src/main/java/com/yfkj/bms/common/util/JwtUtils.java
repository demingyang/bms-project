package com.yfkj.bms.common.util;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import java.util.Date;

/**
 * Created by zhangzhixiang on 2017/5/9.
 */
public class JwtUtils {
    public static final String JWT_ID = "jwt";
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    public static final int JWT_TTL = 60*60*1000;  //millisecond
    public static final int JWT_REFRESH_TTL = 12*60*60*1000;  //millisecond
    /**
     * 由字符串生成加密key
     * @return
     */
    public static SecretKey generalKey(){
        String stringKey = JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
    /**
     * 创建 jwt
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     * @throws Exception
     */
    public static String createToken(String id, String subject, long ttlMillis) throws Exception {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256 ;
        long nowMillis = System. currentTimeMillis();
        Date now = new Date( nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts. builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0){
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date( expMillis);
            builder.setExpiration( exp);
        }
        return builder.compact();
    }

    /**
     * 解密 jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseToken(String jwt) throws Exception{
        SecretKey key = generalKey();
        Claims claims = Jwts. parser()
                .setSigningKey( key)
                .parseClaimsJws( jwt).getBody();
        return claims;
    }
}
