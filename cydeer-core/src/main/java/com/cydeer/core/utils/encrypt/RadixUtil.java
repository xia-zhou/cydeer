package com.cydeer.core.utils.encrypt;

/**
 * @author Cydeer on 15/8/14.
 */
public class RadixUtil {
    static char[] HEX_DIGIT = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public RadixUtil() {
    }

    public static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];

        for(int i = 0; i < len; ++i) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }

        return result;
    }

    public static String binToHex(byte[] bin) {
        if(bin == null) {
            throw new IllegalArgumentException("Parameter bin shouldn\'t be null");
        } else {
            int len = bin.length;
            char[] str = new char[len * 2];
            int k = 0;

            for(int i = 0; i < len; ++i) {
                byte byte0 = bin[i];
                str[k++] = HEX_DIGIT[byte0 >>> 4 & 15];
                str[k++] = HEX_DIGIT[byte0 & 15];
            }

            return new String(str);
        }
    }
}

