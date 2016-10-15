package com.xiazhou.base.utils.encrypt;

/**
 * Created by zhangsong on 15/8/14.
 */
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MD5 {
    private static Log log = LogFactory.getLog(MD5.class);
    private static final String ALGORITHM = "MD5";

    public MD5() {
    }

    public static String encryptHex(String strInput) {
        return encryptHex(strInput, "UTF-8");
    }

    public static String encryptHex(String strInput, String charset) {
        Object b = null;

        byte[] b1;
        try {
            b1 = strInput.getBytes(charset);
        } catch (UnsupportedEncodingException var4) {
            b1 = strInput.getBytes();
        }

        return encryptHex(b1);
    }

    public static String encryptHex(byte[] byteInput) {
        return RadixUtil.binToHex(encrypt(byteInput));
    }

    public static byte[] encrypt(byte[] byteInput) {
        try {
            MessageDigest nsae = MessageDigest.getInstance("MD5");
            nsae.update(byteInput);
            return nsae.digest();
        } catch (NoSuchAlgorithmException var2) {
            log.error("No such Algorithm in digest");
            return new byte[0];
        }
    }
}
