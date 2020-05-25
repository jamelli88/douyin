package com.jamelli88.douyin.core;

import com.alibaba.fastjson.JSON;
import com.jamelli88.douyin.util.HttpUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jamel.li
 * @ClassName: X_S_STUB
 * @Description 加密SS-STUB
 * @since 2020-05-25 13:17
 */
public class X_S_STUB {

    public static final String url = "http://172.29.90.71:8005";

    /**
     * 加密请求结果集
     * @param str
     * @return
     */
    public static String code(String str) {
        Map<String, String> jsonParamMap = new HashMap<>(1) {{
            put("body", str);
        }};

        String result = HttpUtil.doPost(url, JSON.toJSONString(jsonParamMap), 3000, 3000, 3000);
        return result;
    }
}
