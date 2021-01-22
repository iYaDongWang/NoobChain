package com.wyd.noobchain.utils;


import org.apache.commons.codec.digest.DigestUtils;

import javax.swing.*;

/**
 * @author 王亚东
 * @date 2021/1/21 14:53
 */
public class StringUtils {
    private static final String SHA_256 = "SHA-256";
    private static final String MD5 = "MD5";
    private static final String SHA_512 = "SHA-512";

    public static String encrypt(String plain,String type) {
        if (SHA_256.equals(type)) {
            return DigestUtils.sha256Hex(plain);
        }
        return null;
    }

    public static String applySha256(String plain) {
        return encrypt(plain, SHA_256);
    }
}
