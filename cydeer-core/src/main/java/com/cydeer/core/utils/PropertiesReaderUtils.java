package com.cydeer.core.utils;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.*;

/**
 * @author Cydeer on 15/9/9.
 */
public class PropertiesReaderUtils {
    private static volatile PropertiesReaderUtils instance;

    public PropertiesReaderUtils() {
    }

    public static PropertiesReaderUtils get() {
        if(instance == null) {
            Class var0 = PropertiesReaderUtils.class;
            synchronized(PropertiesReaderUtils.class) {
                if(instance == null) {
                    instance = new PropertiesReaderUtils();
                }
            }
        }

        return instance;
    }

    public int getInt(Properties props, String key) {
        return this.getInt(props, key, 0);
    }

    public int getInt(Properties props, String key, int defaultValue) {
        return NumberUtils.toInt(this.getString(props, key), defaultValue);
    }

    public long getLong(Properties props, String key, int defaultValue) {
        return NumberUtils.toLong(this.getString(props, key), (long)defaultValue);
    }

    public boolean getBoolean(Properties props, String key) {
        return BooleanUtils.toBoolean(this.getString(props, key));
    }

    public String getString(Properties props, String key) {
        return this.getString(props, key, (String)null);
    }

    public String getString(Properties props, String key, String defaultValue) {
        return StringUtils.isBlank(key)?defaultValue:props.getProperty(key, defaultValue);
    }

    public Map<String, String> filterProps(Properties props, String keyPrefix) {
        if(props != null && !StringUtils.isBlank(keyPrefix)) {
            HashMap filterMap = new HashMap();
            Set keySets = props.entrySet();
            String key = null;
            String value = null;
            Iterator var7 = keySets.iterator();

            while(var7.hasNext()) {
                Map.Entry keySet = (Map.Entry)var7.next();
                key = keySet.getKey().toString();
                if(StringUtils.startsWith(key, keyPrefix)) {
                    value = keySet.getValue().toString();
                    if(StringUtils.isNotBlank(value)) {
                        key = StringUtils.removeStart(StringUtils.removeStart(key, keyPrefix), ".");
                        filterMap.put(key, value);
                    }
                }
            }

            return filterMap;
        } else {
            return null;
        }
    }
}
