package com.xiazhou.base.utils.encrypt;

/**
 * Created by zhangsong on 15/8/14.
 */
import java.io.IOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Base64 {
    private static Log log = LogFactory.getLog(Base64.class);

    public Base64() {
    }

    public static String encode(byte[] bytes) {
        BASE64Encoder b64e = new BASE64Encoder();
        String rs = b64e.encodeBuffer(bytes);
        return rs != null?rs.replaceAll("\\n|\\r", ""):rs;
    }

    public static byte[] decode(String data) {
        if(data == null) {
            return null;
        } else {
            BASE64Decoder dec = new BASE64Decoder();

            try {
                return dec.decodeBuffer(data);
            } catch (IOException var3) {
                log.warn("Couldn\'t decode form [ " + data + " ] for base64");
                return null;
            }
        }
    }
}