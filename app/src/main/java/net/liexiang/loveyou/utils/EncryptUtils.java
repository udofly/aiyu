package net.liexiang.loveyou.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * describe：加密（MD5、SHA1）
 * author： Gao Chunfa.
 * time： 2017/3/10-11:02.
 */
public class EncryptUtils {

    /**
     * @param algorithm 加密类型（MD5、SHA1）
     * @param original  加密的原文
     * @return 返回加密后的十六进制字符串
     */


    public static String encrypt(String algorithm, String original) {
        MessageDigest mMessageDigest = null;
        byte[]        data           = original.getBytes();
        try {
            mMessageDigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
//                加载数据
        mMessageDigest.update(data);
//                处理数据
        byte[]        digest  = mMessageDigest.digest();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < digest.length; i++) {
            int result = digest[i] & 0xFF;
            if (result <= 0x0F) {
                builder.append("0");
            }
//                    将result转换成十六进制表示
            String hexResult = Integer.toHexString(result);
            builder.append(hexResult);
        }
        return builder.toString();
    }
}



/**
 * package com.example.myapplication;
 *
 * import android.util.Base64;
 *
 * import java.io.ByteArrayOutputStream;
 * import java.io.UnsupportedEncodingException;
 * import java.security.Key;
 * import java.security.KeyFactory;
 * import java.security.PrivateKey;
 * import java.security.PublicKey;
 * import java.security.spec.PKCS8EncodedKeySpec;
 * import java.security.spec.X509EncodedKeySpec;
 * import java.util.ArrayList;
 * import java.util.Arrays;
 * import java.util.List;
 *
 * import javax.crypto.Cipher;
 *
 * /**
 *  * author:CHM
 *  * 创建时间：2021/4/7 15:52
 *  * Describe:
 *
 *

public class Utils {
 *
         *     /**
  *      * base64解密
  *      *
  *      * @param encodeWord 解密内容
  *
         *

    public static String setDecrypt(String encodeWord) {
 *try {
 *return new String(Base64.decode(encodeWord.getBytes(), Base64.DEFAULT));
 *} catch (Exception e) {
 *e.printStackTrace();
 *return "";
 *}
 *}
 *
         *     /**
  *      * 分段
  *      *
  *      * @param content
  *      * @return
  *      *
         *

    public static List<String> setList(String content) {
 *String[] strings = content.split("(?<=\\G.{128})");
 *return new ArrayList<>(Arrays.asList(strings));
 *}
 *
         *     /**
  *      * 转换成二进制
  *      *
  *      * @param val
  *      * @return
  *      *
         *

    public static char[] parseBinary(int val) {
 *         //十进制转成二进制 读数是从右往左读
 *String unitData = Integer.toBinaryString(val);
 *int len = unitData.toCharArray().length;
 *StringBuilder lostVal = new StringBuilder();
 *if (len < 8) {
 *for (int i = 0; i < 8 - len; i++) {
 *lostVal.append("0");
 *}
 *}
 *char[] list = (lostVal.toString() + unitData).toCharArray();
 *return list;
 *}
 *
         *
}
 */