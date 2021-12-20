package com.gsy.syutils.encrypt;


import android.util.Base64;


import com.gsy.syutils.StringUtil;

import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * Describe:
 * Created by Gao Chunfa on 解密.
 * Company: Hainan DaDi(Jinan) Network Technology Co. Ltd
 */
public class AesEcb256Utils {

    static String key = "iDtag1t9rNzUWGpFojnrdwceow8TlkI8";

    /**
     * AesEcb256加密
     *
     * @param mingWen
     * @return
     */
    public static String aesEcb256Encrypt(String myKey,String mingWen) {
        if (StringUtil.isNull(mingWen) || StringUtil.isNull(myKey)) {
            return "";
        }
        // 判断Key是否为16位
//        if (sKey.length() != 16) {
//            System.out.print("Key长度不是16位");
//            return null;
//        }
        byte[] encrypted = new byte[0];
        try {
            byte[]        raw      = myKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher        cipher   = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] bytes_mingwen = mingWen.getBytes("utf-8");
            encrypted = cipher.doFinal(bytes_mingwen);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        }

        String s = Base64.encodeToString(encrypted, Base64.DEFAULT);
        return s;//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    /**
     * AesEcb256解密
     *
     * @param miwen
     * @return
     */
    public static String aesEcb256Decrypt(String myKey,String miwen) {

        if (StringUtil.isNull(miwen) || StringUtil.isNull(myKey)) {
            return "";
        }

        try {

            byte[] cryptograph = miwen.getBytes("utf-8");

            byte[]        raw      = myKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
//            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
//            SecretKey secretKey = kgen.generateKey();
//            byte[] enCodeFormat = skeySpec.getEncoded();
            SecretKeySpec secretKeySpec = new SecretKeySpec(raw, "AES");
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] content = cipher.doFinal(Base64.decode(cryptograph, Base64.DEFAULT));
            String s       = new String(content);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private static Map<Integer, String> keyMap = new HashMap<Integer, String>();  //用于封装随机产生的公钥与私钥

//    public static void rsaTest(String str_mingWen) throws Exception {
//        //生成公钥和私钥
//        genKeyPair();
//        //加密字符串
//        String message = "df723820";
//        Logs.test("随机生成的公钥为:" + keyMap.get(0));
//        Logs.test("随机生成的私钥为:" + keyMap.get(1));
//        String messageEn = aesEcb256Encrypt(message, keyMap.get(0));
//        Logs.test(message + "\t加密后的字符串为:" + messageEn);
//        String messageDe = aesEcb256Decrypt(messageEn, keyMap.get(1));
//        Logs.test("还原后的字符串为:" + messageDe);
//    }

    /**
     * 随机生成密钥对
     *
     * @throws NoSuchAlgorithmException
     */
    public static void genKeyPair() throws NoSuchAlgorithmException {
        // KeyPairGenerator类用于生成公钥和私钥对，基于RSA算法生成对象
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        // 初始化密钥对生成器，密钥大小为96-1024位
        keyPairGen.initialize(1024, new SecureRandom());
        // 生成一个密钥对，保存在keyPair中
        KeyPair       keyPair         = keyPairGen.generateKeyPair();
        RSAPrivateKey privateKey      = (RSAPrivateKey) keyPair.getPrivate();   // 得到私钥
        RSAPublicKey  publicKey       = (RSAPublicKey) keyPair.getPublic();  // 得到公钥
        String        publicKeyString = Base64.encodeToString(publicKey.getEncoded(), 0);
        // 得到私钥字符串
        String privateKeyString = Base64.encodeToString((privateKey.getEncoded()), 0);
        // 将公钥和私钥保存到Map
        keyMap.put(0, publicKeyString);  //0表示公钥
        keyMap.put(1, privateKeyString);  //1表示私钥
    }

    /**
     * RSA公钥加密
     *
     * @param str       加密字符串
     * @param publicKey 公钥
     * @return 密文
     * @throws Exception 加密过程中的异常信息
     */
    public static String rsaEncrypt(String str, String publicKey) throws Exception {
        //base64编码的公钥
        byte[]       decoded = Base64.decode(publicKey, 0);
        RSAPublicKey pubKey  = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RSA加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, pubKey);
        String outStr = Base64.encodeToString(cipher.doFinal(str.getBytes("UTF-8")), 0);
        return outStr;
    }

    /**
     * RSA私钥解密
     *
     * @param str        加密字符串
     * @param privateKey 私钥
     * @return 铭文
     * @throws Exception 解密过程中的异常信息
     */
    public static String rsaDecrypt(String str, String privateKey) throws Exception {
        //64位解码加密后的字符串
        byte[] inputByte = Base64.decode(str.getBytes("UTF-8"), 0);
        //base64编码的私钥
        byte[]        decoded = Base64.decode(privateKey, 0);
        RSAPrivateKey priKey  = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(decoded));
        //RSA解密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, priKey);
        String outStr = new String(cipher.doFinal(inputByte));
        return outStr;
    }


}
