package com.yfkj.bms.shiro;

import com.yfkj.bms.domain.SysUser;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * 密码生成器
 */
public class PasswordHelper {
    private static RandomNumberGenerator randomNumberGenerator =
            new SecureRandomNumberGenerator();
    private static String algorithmName = "md5";
    private static final int HASHITERATIONS = 2;

    /**
     * 生成用户密码 盐使用了随机数 生成时使用了用户名+盐 生成密码 并且经过2次md5
     *
     * @param user
     */
    public static SysUser encryptPassword(SysUser user) {
        user.setCredentialsSalt(user.getSalt());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),
                HASHITERATIONS).toHex();
        user.setPassword(newPassword);
        return user;
    }
    /**
     * 获取MD5加密
     *
     * @param pwd
     *            需要加密的字符串
     * @return String字符串 加密后的字符串
     */
    public static String md5(String pwd) {
        try {
            // 创建加密对象
            MessageDigest digest = MessageDigest.getInstance("md5");

            // 调用加密对象的方法，加密的动作已经完成
            byte[] bs = digest.digest(pwd.getBytes());
            // 接下来，我们要对加密后的结果，进行优化，按照mysql的优化思路走
            // mysql的优化思路：
            // 第一步，将数据全部转换成正数：
            String hexString = "";
            for (byte b : bs) {
                // 第一步，将数据全部转换成正数：
                // 解释：为什么采用b&255
                /*
                 * b:它本来是一个byte类型的数据(1个字节) 255：是一个int类型的数据(4个字节)
                 * byte类型的数据与int类型的数据进行运算，会自动类型提升为int类型 eg: b: 1001 1100(原始数据)
                 * 运算时： b: 0000 0000 0000 0000 0000 0000 1001 1100 255: 0000
                 * 0000 0000 0000 0000 0000 1111 1111 结果：0000 0000 0000 0000
                 * 0000 0000 1001 1100 此时的temp是一个int类型的整数
                 */
                int temp = b & 255;
                // 第二步，将所有的数据转换成16进制的形式
                // 注意：转换的时候注意if正数>=0&&<16，那么如果使用Integer.toHexString()，可能会造成缺少位数
                // 因此，需要对temp进行判断
                if (temp < 16 && temp >= 0) {
                    // 手动补上一个“0”
                    hexString = hexString + "0" + Integer.toHexString(temp);
                } else {
                    hexString = hexString + Integer.toHexString(temp);
                }
            }
            return hexString;
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args) {
        SysUser u = new SysUser();
        u.setUsername("13911238460");
        String s=md5(md5("238460d")+"8460");
        u.setPassword("238460d");
        u.setSalt("8460");
        SysUser user=new PasswordHelper().encryptPassword(u);
       // System.out.println(u.getPassword() + "-" + u.getSalt()+"-"+u.getCredentialsSalt());
        System.out.println(s);
        System.out.println(user.getPassword());
    }
}   
