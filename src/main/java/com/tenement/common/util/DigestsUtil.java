package com.tenement.common.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by LXPENG on 2016/4/25.
 */
public class DigestsUtil {
    public static char[] hexChar = { '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };

    public static String MD5Digests(String key) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //MD5加密
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        byte[] keyByte = messageDigest.digest(key.getBytes());
        return toHexString(keyByte);

    }

    public static String toHexString(byte[] b) {
        StringBuilder sb = new StringBuilder(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            sb.append(hexChar[(b[i] & 0xf0) >>> 4]);
            sb.append(hexChar[b[i] & 0x0f]);
        }
        return sb.toString();
    }
}
