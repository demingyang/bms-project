package com.yfkj.bms.common.util;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import com.yfkj.bms.common.constants.WXConstants;
import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
 
 
public class RSAUtils{
    public static final String KEY_ALGORITHM="RSA";
    public static final String SIGNATURE_ALGORITHM="MD5withRSA";
    private static final int KEY_SIZE=1024;
    private static final String PUBLIC_KEY="RSAPublicKey";
    private static final String PRIVATE_KEY="RSAPrivateKey";
      /**
       * 使用getPublicKey得到公钥,返回类型为PublicKey
       * @param base64 String to PublicKey
       * @throws Exception
       */
      public static PublicKey getPublicKey(String key) throws Exception {
            byte[] keyBytes;
            keyBytes = (new BASE64Decoder()).decodeBuffer(key);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
      }
      /**
       * 转换私钥
       * @param base64 String to PrivateKey
       * @throws Exception
       */
      public static PrivateKey getPrivateKey(String key) throws Exception {
            byte[] keyBytes;
            keyBytes = (new BASE64Decoder()).decodeBuffer(key);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            return privateKey;
      }

      //***************************签名和验证*******************************
      public static byte[] sign(byte[] data) throws Exception{
        PrivateKey priK = getPrivateKey(WXConstants.str_priK);
          Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);        
          sig.initSign(priK);
          sig.update(data);
          return sig.sign();
      }
      
      public static boolean verify(byte[] data,byte[] sign) throws Exception{
          PublicKey pubK = getPublicKey(WXConstants.str_pubK);
          Signature sig = Signature.getInstance(SIGNATURE_ALGORITHM);
          sig.initVerify(pubK);
          sig.update(data);
          return sig.verify(sign);
      }
      
      //************************加密解密**************************
      public static String  encrypt(String bt_plaintext)throws Exception{
          byte [] b=bt_plaintext.getBytes();
          PublicKey publicKey = getPublicKey(WXConstants.str_pubK);
          Cipher cipher = Cipher.getInstance("RSA");
          cipher.init(Cipher.ENCRYPT_MODE, publicKey);
         byte[] bt_encrypted = cipher.doFinal(b);
        return Base64.encodeBase64String(bt_encrypted);
      }
      
      public static String decrypt(String bt_encrypted)throws Exception{
          byte[] b= Base64.decodeBase64(bt_encrypted);
        PrivateKey privateKey = getPrivateKey(WXConstants.str_priK);
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] bt_original = cipher.doFinal(b);
        return new String(bt_original);
      }
      //********************main函数：加密解密和签名验证*********************
      public static void main(String[] args) throws Exception {
            String str_plaintext = "1";
            System.err.println("明文："+str_plaintext);
            String bt_cipher = encrypt(str_plaintext);
            System.out.println("加密后："+bt_cipher);//decodeBase64(Base64.encodeBase64String(bt_cipher))
             String str="Kq3QJMxyIO7JD1jWvCKOnGPykWUMnbliSsGAevrz2 DFZFa7hdRoMltnNBs+k0jS36cjWnO6yLiWlaHemf0AQWN1a9wALjeNAw9RoG0HfdRpB8x6sXa3e/Jn/DacHYryl9pgTXJhF70sXS/91szDnfJ5VXVzOsMbH SVicTh ko=";
          str=str.replace(" ","+");
             String bt_original = decrypt(str);
            System.out.println("解密结果:"+bt_original);
            
            /*String str="被签名的内容";
            System.err.println("\n原文:"+str);
            byte[] signature=sign(str.getBytes());
            System.out.println("产生签名："+Base64.encodeBase64String(signature));
            boolean status=verify(str.getBytes(), signature);
            System.out.println("验证情况："+status);*/
      }
 
}