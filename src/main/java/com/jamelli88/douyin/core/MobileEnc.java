package com.jamelli88.douyin.core;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jamel.li
 * @ClassName: MobileEnc
 * @Description 加密手机号
 * @since 2020-05-25 13:23
 */
public class MobileEnc {

    /** 手机号码对应的加密值 */
    public final static Map<String, String> numberKv = new HashMap<>() {{
        put("1", "34");
        put("2", "37");
        put("3", "36");
        put("4", "31");
        put("5", "30");
        put("6", "33");
        put("7", "32");
        put("8", "3d");
        put("9", "3c");
        put("0", "35");
    }};

    /** 手机号前缀对应的加密值 */
    public final static Map<String, String> firstKv = new HashMap<>() {{
        put("13", "6");
        put("17", "2");
        put("18", "d");
        put("15", "0");
    }};

    /** 手机号前缀指定的加密值 */
    public final static String firstTag = "2e3d3325343";

    /**
     * 手机号加密
     * @param mobile
     * @return
     */
    public final static String core(String mobile) {

        StringBuffer stringBuffer = new StringBuffer(firstTag);

        stringBuffer.append(firstKv.get(mobile.substring(0, 2)));

        for (int i = 3; i < mobile.length(); i++) {
            stringBuffer.append(numberKv.get(mobile.charAt(i)));
        }

        return stringBuffer.toString();

    }
}
