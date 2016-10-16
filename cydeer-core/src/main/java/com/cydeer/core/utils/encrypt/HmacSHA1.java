package com.cydeer.core.utils.encrypt;

/**
 * @author Cydeer on 15/8/14.
 */
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HmacSHA1 {
    private static Logger logger = LoggerFactory.getLogger(HmacSHA1.class);
    private static final String MAC_NAME = "HmacSHA1";
    private static final String ENCODING = "UTF-8";

    public HmacSHA1() {
    }

    public static byte[] encrypt(String encryptText, String encryptKey) {
        return encrypt(encryptText, encryptKey, "UTF-8");
    }

    public static byte[] encrypt(String encryptText, String encryptKey, String encoding) {
        if(StringUtils.isBlank(encoding)) {
            encoding = "UTF-8";
        }

        byte[] keyData;
        try {
            keyData = encryptKey.getBytes(encoding);
        } catch (UnsupportedEncodingException var9) {
            keyData = encryptKey.getBytes();
        }

        SecretKeySpec secretKey = new SecretKeySpec(keyData, "HmacSHA1");
        Object textData = null;

        byte[] textData1;
        try {
            textData1 = encryptText.getBytes(encoding);
        } catch (UnsupportedEncodingException var8) {
            textData1 = encryptText.getBytes();
        }

        try {
            Mac e1 = Mac.getInstance("HmacSHA1");
            e1.init(secretKey);
            return e1.doFinal(textData1);
        } catch (NoSuchAlgorithmException | InvalidKeyException var7) {
            logger.error("签名失败", var7);
            return new byte[0];
        }
    }

    public static String encryptHex(String encryptText, String encryptKey) {
        return RadixUtil.binToHex(encrypt(encryptText, encryptKey, "UTF-8"));
    }

    public static String encryptHex(String encryptText, String encryptKey, String encoding) {
        return RadixUtil.binToHex(encrypt(encryptText, encryptKey, encoding));
    }
}
