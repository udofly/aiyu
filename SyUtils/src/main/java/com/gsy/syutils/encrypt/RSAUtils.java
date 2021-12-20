package com.gsy.syutils.encrypt;

import android.content.Context;
import android.util.Base64;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import Decoder.BASE64Decoder;

public class RSAUtils {

    /**
     * 参开文档
     * https://blog.csdn.net/qq_41566219/article/details/116302087
     */

    public static final String RSA                = "RSA";// 非对称加密密钥算法
    public static final String ECB_PKCS1_PADDING  = "RSA/ECB/PKCS1Padding";//加密填充方式
    public static final int    DEFAULT_KEY_SIZE   = 1024;//秘钥默认长度
    public static final byte[] DEFAULT_SPLIT      = "#PART#".getBytes();    // 当要加密的内容超过bufferSize，则采用partSplit进行分块加密
    public static final int    DEFAULT_BUFFERSIZE = (DEFAULT_KEY_SIZE / 8) - 11;// 当前秘钥支持加密的最大字节数
    public static       String strPublicKey       = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdFkdYqgiheS00S9bPnAojaf+e\n" +
            "wGcy0CAYunEhqFD8kLK626EBR+E+dG6Hqk6U+1lbu9l6M7fKIkSejQZ7P6fUaIPz\n" +
            "E1cJSZxtDGF0Gxt7JzXibTD4BqOHKKJcWH+yTW/AykMHykZv0uUptfrMAbasz86/\n" +
            "yVDI47rGP6fk9ocaJwIDAQAB";


    /**
     * Rsa公钥解密
     *
     * @param context
     * @param miWen
     */
//    public static String rsaDecodeByPublicKey(Context context, String miWen) {
//        PublicKey publicKey = (RSAPublicKey) getPubKey(context, strPublicKey);
//        String    mingWen   = "";
//        try {
//            Cipher cipher = Cipher.getInstance(ECB_PKCS1_PADDING);
//            cipher.init(Cipher.DECRYPT_MODE, publicKey);
//            byte[]       cipherText = Base64.decode(miWen, Base64.DEFAULT);
//            List<byte[]> listByte   = getListByte(cipherText);
//            for (int i = 0; i < listByte.size(); i++) {
//                byte[] decryptText = cipher.doFinal(listByte.get(i));
//                String s = new String(decryptText, "UTF-8");
//                mingWen = mingWen + s;
//            }
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (InvalidKeyException e) {
//            e.printStackTrace();
//        } catch (NoSuchPaddingException e) {
//            e.printStackTrace();
//        } catch (BadPaddingException e) {
//            e.printStackTrace();
//        } catch (IllegalBlockSizeException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return mingWen;
//
//    }
    public static String rsaDecodeByPublicKey(Context context, String miWen) {
        PublicKey publicKey = (RSAPublicKey) getPubKey(context, strPublicKey);
        String    mingWen   = "";
        try {
            Cipher cipher = Cipher.getInstance(ECB_PKCS1_PADDING);
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            byte[]       cipherText = Base64.decode(miWen, Base64.DEFAULT);
            List<byte[]> listByte   = getListByte(cipherText);

            //获取加密后的字节数组
            List<byte[]> listByteDe = new ArrayList<>();
            for (int i = 0; i < listByte.size(); i++) {
                byte[] decryptText = cipher.doFinal(listByte.get(i));
                listByteDe.add(decryptText);
            }

            //确定数组长度
            int length_byte = 0;
            for (int i = 0; i < listByteDe.size(); i++) {
                length_byte += listByteDe.get(i).length;
            }
            byte[] all_byte = new byte[length_byte];

            //解密后.拼成一个完成的字节数组后再转字符串(避免出现中文乱码)
            int countLength = 0;
            for (int i = 0; i < listByteDe.size(); i++) {
                byte[] b = listByteDe.get(i);
                System.arraycopy(b, 0, all_byte, countLength, b.length);
                countLength += b.length;
            }
            mingWen = new String(all_byte, "UTF-8");

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mingWen;

    }

    /**
     * 将字节数组按128长度分段
     *
     * @param data
     * @return
     */
    public static List<byte[]> getListByte(byte[] data) {
        List<byte[]> list  = new ArrayList<>();
        int          index = data.length / 128;

        for (int i = 0; i < index; i++) {
            list.add(getByteSub(data, i * 128, 128));
        }

        if (index * 128 < data.length) {
            list.add(getByteSub(data, index * 128, 128));
        }
        return list;
    }

    public static byte[] getByteSub(byte[] data, int start, int length) {
        byte[] bt = new byte[length];

        if (start + length > data.length) {
            bt = new byte[data.length - start];
        }
        for (int i = 0; i < length && (i + start) < data.length; i++) {
            bt[i] = data[i + start];
        }
        return bt;
    }


    /**
     * 实例化公钥
     *
     * @return
     */
    public static PublicKey getPubKey(Context context, String strPublicKey) {
        PublicKey publicKey = null;

        //获取方式1
        try {
            // 自己的公钥(测试)
            X509EncodedKeySpec bobPubKeySpec = new X509EncodedKeySpec(new BASE64Decoder().decodeBuffer(strPublicKey));
            // RSA对称加密算法
            KeyFactory  keyFactory = KeyFactory.getInstance("RSA");
            // 取公钥匙对象
            publicKey = keyFactory.generatePublic(bobPubKeySpec);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //获取方式2

//        try {
//            InputStream inPublic = context.getResources().getAssets().open("rsa_public_key.pem");
//            publicKey = loadPublicKey(inPublic);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        return publicKey;
    }


    /**
     * 从文件中输入流中加载公钥
     *
     * @param in 公钥输入流
     * @throws Exception 加载公钥时产生的异常
     */
    public static PublicKey loadPublicKey(InputStream in) throws Exception {
        try {
            return loadPublicKey(readKey(in));
        } catch (IOException e) {
            throw new Exception("公钥数据流读取错误");
        } catch (NullPointerException e) {
            throw new Exception("公钥输入流为空");
        }
    }

    /**
     * 读取密钥信息
     *
     * @param in
     * @return
     * @throws IOException
     */
    private static String readKey(InputStream in) throws IOException {
        BufferedReader br       = new BufferedReader(new InputStreamReader(in));
        String         readLine = null;
        StringBuilder  sb       = new StringBuilder();
        while ((readLine = br.readLine()) != null) {
            if (readLine.charAt(0) == '-') {
                continue;
            } else {
                sb.append(readLine);
                sb.append('\r');
            }
        }

        return sb.toString();
    }

    /**
     * 从字符串中加载公钥
     *
     * @param publicKeyStr 公钥数据字符串
     * @throws Exception 加载公钥时产生的异常
     */
    public static PublicKey loadPublicKey(String publicKeyStr) throws Exception {
        try {
            byte[]             buffer     = Base64.decode(publicKeyStr,0);
            KeyFactory         keyFactory = KeyFactory.getInstance(RSA);
            X509EncodedKeySpec keySpec    = new X509EncodedKeySpec(buffer);
            return (RSAPublicKey) keyFactory.generatePublic(keySpec);
        } catch (NoSuchAlgorithmException e) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException e) {
            throw new Exception("公钥非法");
        } catch (NullPointerException e) {
            throw new Exception("公钥数据为空");
        }
    }

    /**
     * 分段
     *
     * @param content
     * @return
     */
    public static List<String> setList(String content) {
        String[] strings = content.split("(?<=\\G.{128})");
        return new ArrayList<>(Arrays.asList(strings));
    }
//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~往下暂时不用关注  没有验证其准确性~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

//
//    /**
//     * 随机生成RSA密钥对
//     *
//     * @param keyLength 密钥长度，范围：512～2048
//     *                  一般1024
//     * @return
//     */
//    public static KeyPair generateRSAKeyPair(int keyLength) {
//        try {
//            KeyPairGenerator kpg = KeyPairGenerator.getInstance(RSA);
//            kpg.initialize(keyLength);
//            return kpg.genKeyPair();
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 用公钥对字符串进行加密
//     *
//     * @param data 原文
//     */
//    public static byte[] encryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
//        // 得到公钥
//        X509EncodedKeySpec keySpec   = new X509EncodedKeySpec(publicKey);
//        KeyFactory         kf        = KeyFactory.getInstance(RSA);
//        PublicKey          keyPublic = kf.generatePublic(keySpec);
//        // 加密数据
//        Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
//        cp.init(Cipher.ENCRYPT_MODE, keyPublic);
//        return cp.doFinal(data);
//    }
//
//    /**
//     * 私钥加密
//     *
//     * @param data       待加密数据
//     * @param privateKey 密钥
//     * @return byte[] 加密数据
//     */
//    public static byte[] encryptByPrivateKey(byte[] data, byte[] privateKey) throws Exception {
//        // 得到私钥
//        PKCS8EncodedKeySpec keySpec    = new PKCS8EncodedKeySpec(privateKey);
//        KeyFactory          kf         = KeyFactory.getInstance(RSA);
//        PrivateKey          keyPrivate = kf.generatePrivate(keySpec);
//        // 数据加密
//        Cipher cipher = Cipher.getInstance(ECB_PKCS1_PADDING);
//        cipher.init(Cipher.ENCRYPT_MODE, keyPrivate);
//        return cipher.doFinal(data);
//    }
//
//    /**
//     * 公钥解密
//     *
//     * @param data      待解密数据
//     * @param publicKey 密钥
//     * @return byte[] 解密数据
//     */
//    public static byte[] decryptByPublicKey(byte[] data, byte[] publicKey) throws Exception {
//        // 得到公钥
//        X509EncodedKeySpec keySpec   = new X509EncodedKeySpec(publicKey);
//        KeyFactory         kf        = KeyFactory.getInstance(RSA);
//        PublicKey          keyPublic = kf.generatePublic(keySpec);
//        // 数据解密
//        Cipher cipher = Cipher.getInstance(RSA);
//        cipher.init(Cipher.DECRYPT_MODE, keyPublic);
//        return cipher.doFinal(data);
//    }
//
//    /**
//     * 使用私钥进行解密
//     */
//    public static byte[] decryptByPrivateKey(byte[] encrypted, byte[] privateKey) throws Exception {
//        // 得到私钥
//        PKCS8EncodedKeySpec keySpec    = new PKCS8EncodedKeySpec(privateKey);
//        KeyFactory          kf         = KeyFactory.getInstance(RSA);
//        PrivateKey          keyPrivate = kf.generatePrivate(keySpec);
//
//        // 解密数据
//        Cipher cp = Cipher.getInstance(ECB_PKCS1_PADDING);
//        cp.init(Cipher.DECRYPT_MODE, keyPrivate);
//        byte[] arr = cp.doFinal(encrypted);
//        return arr;
//    }
//
//    /**
//     * 用公钥对字符串进行分段加密
//     */
//    public static byte[] encryptByPublicKeyForSpilt(byte[] data, byte[] publicKey) throws Exception {
//        int dataLen = data.length;
//        if (dataLen <= DEFAULT_BUFFERSIZE) {
//            return encryptByPublicKey(data, publicKey);
//        }
//        List<Byte> allBytes    = new ArrayList<Byte>(2048);
//        int        bufIndex    = 0;
//        int        subDataLoop = 0;
//        byte[]     buf         = new byte[DEFAULT_BUFFERSIZE];
//        for (int i = 0; i < dataLen; i++) {
//            buf[bufIndex] = data[i];
//            if (++bufIndex == DEFAULT_BUFFERSIZE || i == dataLen - 1) {
//                subDataLoop++;
//                if (subDataLoop != 1) {
//                    for (byte b : DEFAULT_SPLIT) {
//                        allBytes.add(b);
//                    }
//                }
//                byte[] encryptBytes = encryptByPublicKey(buf, publicKey);
//                for (byte b : encryptBytes) {
//                    allBytes.add(b);
//                }
//                bufIndex = 0;
//                if (i == dataLen - 1) {
//                    buf = null;
//                } else {
//                    buf = new byte[Math.min(DEFAULT_BUFFERSIZE, dataLen - i - 1)];
//                }
//            }
//        }
//        byte[] bytes = new byte[allBytes.size()];
//        {
//            int i = 0;
//            for (Byte b : allBytes) {
//                bytes[i++] = b.byteValue();
//            }
//        }
//        return bytes;
//    }
//
//    /**
//     * 分段加密
//     *
//     * @param data       要加密的原始数据
//     * @param privateKey 秘钥
//     */
//    public static byte[] encryptByPrivateKeyForSpilt(byte[] data, byte[] privateKey) throws Exception {
//        int dataLen = data.length;
//        if (dataLen <= DEFAULT_BUFFERSIZE) {
//            return encryptByPrivateKey(data, privateKey);
//        }
//        List<Byte> allBytes    = new ArrayList<Byte>(2048);
//        int        bufIndex    = 0;
//        int        subDataLoop = 0;
//        byte[]     buf         = new byte[DEFAULT_BUFFERSIZE];
//        for (int i = 0; i < dataLen; i++) {
//            buf[bufIndex] = data[i];
//            if (++bufIndex == DEFAULT_BUFFERSIZE || i == dataLen - 1) {
//                subDataLoop++;
//                if (subDataLoop != 1) {
//                    for (byte b : DEFAULT_SPLIT) {
//                        allBytes.add(b);
//                    }
//                }
//                byte[] encryptBytes = encryptByPrivateKey(buf, privateKey);
//                for (byte b : encryptBytes) {
//                    allBytes.add(b);
//                }
//                bufIndex = 0;
//                if (i == dataLen - 1) {
//                    buf = null;
//                } else {
//                    buf = new byte[Math.min(DEFAULT_BUFFERSIZE, dataLen - i - 1)];
//                }
//            }
//        }
//        byte[] bytes = new byte[allBytes.size()];
//        {
//            int i = 0;
//            for (Byte b : allBytes) {
//                bytes[i++] = b.byteValue();
//            }
//        }
//        return bytes;
//    }
//
//    /**
//     * 公钥分段解密
//     *
//     * @param encrypted 待解密数据
//     * @param publicKey 密钥
//     */
//    public static byte[] decryptByPublicKeyForSpilt(byte[] encrypted, byte[] publicKey) throws Exception {
//        int splitLen = DEFAULT_SPLIT.length;
//        if (splitLen <= 0) {
//            return decryptByPublicKey(encrypted, publicKey);
//        }
//        int        dataLen          = encrypted.length;
//        List<Byte> allBytes         = new ArrayList<Byte>(1024);
//        int        latestStartIndex = 0;
//        for (int i = 0; i < dataLen; i++) {
//            byte    bt           = encrypted[i];
//            boolean isMatchSplit = false;
//            if (i == dataLen - 1) {
//                // 到data的最后了
//                byte[] part = new byte[dataLen - latestStartIndex];
//                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
//                byte[] decryptPart = decryptByPublicKey(part, publicKey);
//                for (byte b : decryptPart) {
//                    allBytes.add(b);
//                }
//                latestStartIndex = i + splitLen;
//                i = latestStartIndex - 1;
//            } else if (bt == DEFAULT_SPLIT[0]) {
//                // 这个是以split[0]开头
//                if (splitLen > 1) {
//                    if (i + splitLen < dataLen) {
//                        // 没有超出data的范围
//                        for (int j = 1; j < splitLen; j++) {
//                            if (DEFAULT_SPLIT[j] != encrypted[i + j]) {
//                                break;
//                            }
//                            if (j == splitLen - 1) {
//                                // 验证到split的最后一位，都没有break，则表明已经确认是split段
//                                isMatchSplit = true;
//                            }
//                        }
//                    }
//                } else {
//                    // split只有一位，则已经匹配了
//                    isMatchSplit = true;
//                }
//            }
//            if (isMatchSplit) {
//                byte[] part = new byte[i - latestStartIndex];
//                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
//                byte[] decryptPart = decryptByPublicKey(part, publicKey);
//                for (byte b : decryptPart) {
//                    allBytes.add(b);
//                }
//                latestStartIndex = i + splitLen;
//                i = latestStartIndex - 1;
//            }
//        }
//        byte[] bytes = new byte[allBytes.size()];
//        {
//            int i = 0;
//            for (Byte b : allBytes) {
//                bytes[i++] = b.byteValue();
//            }
//        }
//        return bytes;
//    }
//
//    /**
//     * 使用私钥分段解密
//     */
//    public static byte[] decryptByPrivateKeyForSpilt(byte[] encrypted, byte[] privateKey) throws Exception {
//        int splitLen = DEFAULT_SPLIT.length;
//        if (splitLen <= 0) {
//            return decryptByPrivateKey(encrypted, privateKey);
//        }
//        int        dataLen          = encrypted.length;
//        List<Byte> allBytes         = new ArrayList<Byte>(1024);
//        int        latestStartIndex = 0;
//        for (int i = 0; i < dataLen; i++) {
//            byte    bt           = encrypted[i];
//            boolean isMatchSplit = false;
//            if (i == dataLen - 1) {
//                // 到data的最后了
//                byte[] part = new byte[dataLen - latestStartIndex];
//                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
//                byte[] decryptPart = decryptByPrivateKey(part, privateKey);
//                for (byte b : decryptPart) {
//                    allBytes.add(b);
//                }
//                latestStartIndex = i + splitLen;
//                i = latestStartIndex - 1;
//            } else if (bt == DEFAULT_SPLIT[0]) {
//                // 这个是以split[0]开头
//                if (splitLen > 1) {
//                    if (i + splitLen < dataLen) {
//                        // 没有超出data的范围
//                        for (int j = 1; j < splitLen; j++) {
//                            if (DEFAULT_SPLIT[j] != encrypted[i + j]) {
//                                break;
//                            }
//                            if (j == splitLen - 1) {
//                                // 验证到split的最后一位，都没有break，则表明已经确认是split段
//                                isMatchSplit = true;
//                            }
//                        }
//                    }
//                } else {
//                    // split只有一位，则已经匹配了
//                    isMatchSplit = true;
//                }
//            }
//            if (isMatchSplit) {
//                byte[] part = new byte[i - latestStartIndex];
//                System.arraycopy(encrypted, latestStartIndex, part, 0, part.length);
//                byte[] decryptPart = decryptByPrivateKey(part, privateKey);
//                for (byte b : decryptPart) {
//                    allBytes.add(b);
//                }
//                latestStartIndex = i + splitLen;
//                i = latestStartIndex - 1;
//            }
//        }
//        byte[] bytes = new byte[allBytes.size()];
//        {
//            int i = 0;
//            for (Byte b : allBytes) {
//                bytes[i++] = b.byteValue();
//            }
//        }
//        return bytes;
//    }


}
