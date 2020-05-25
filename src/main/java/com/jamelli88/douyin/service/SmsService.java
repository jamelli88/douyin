package com.jamelli88.douyin.service;

import com.jamelli88.douyin.core.MobileEnc;
import com.jamelli88.douyin.core.X_S_STUB;

import java.util.*;

/**
 * @author jamel.li
 * @ClassName: SmsService
 * @Description
 * @since 2020-05-25 13:18
 */
public class SmsService {

    public static final String url = "https://lf-hl.snssdk.com/passport/mobile/send_code/v1/";


    public static final Map<String, String> query_samsung = new LinkedHashMap<>() {{
        put("account_sdk_version", "386");
        put("os_api", "23");
        put("device_type", "SM-C7010");
        put("ssmix", "a");
        put("manifest_version_code", "110101");
        put("dpi", "420");
        put("uuid", "354734081925642");
        put("app_name", "aweme");
        put("version_name", "11.1.0");
        put("ts", "");
        put("cpu_support64", "true");
        put("app_type", "normal");
        put("ac", "wifi");
        put("host_abi", "armeabi-v7a");
        put("update_version_code", "11009900");
        put("channel", "samsungapps");
        put("_rticket", "");
        put("device_platform", "android");
        put("iid", "3175031820265055");
        put("version_code", "");
        put("cdid", "25c82ff2-19c4-4fdd-a7f4-4e878bfb104d");
        put("openudid", "3a7a5260db70a421");
        put("device_id", "69090214758");
        put("resolution", "1080*1920");
        put("os_version", "6.0.1");
        put("language", "zh");
        put("device_brand", "samsung");
        put("aid", "1128");
    }};

    public static final Map<String, String> body_samsung = new LinkedHashMap<>() {{
        put("is_vcd", "1");
        put("auto_read", "0");
        put("account_sdk_source", "app");
        put("mix_mode", "1");
        put("type", "3731");
        put("unbind_exist", "35");
        put("mobile", "");
    }};

    public static final Map<String, String> header_samsung = new LinkedHashMap<>() {{
        put("Content-Length", "118");
        put("Cookie", "");
        put("x-tt-passport-csrf-token", "");
        put("X-SS-REQ-TICKET", "");
        put("sdk-version", "1");
        put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
        put("X-SS-STUB", "");
        put("X-SS-DP", "1128");
        put("x-tt-trace-id", "");
        put("User-Agent", "com.ss.android.ugc.aweme/110101 (Linux; U; Android 6.0.1; zh_CN; SM-C7010; Build/MMB29M; Cronet/TTNetVersion");
        put("X-Gorgon", "");
        put("X-Khronos", "");
    }};

    public static String send(String mobile) {

        Map<String, String> queryMap = new LinkedHashMap<>();

        queryMap.putAll(query_samsung);

        Date curr=Calendar.getInstance().getTime();
        query_samsung.put("ts", Calendar.getInstance().getTimeInMillis()/1000+"");//2020-05-25 15:00:56 1590390056
        query_samsung.put("_rticket", Calendar.getInstance().getTimeInMillis()+"");//2020-05-25 15:00:57 1590390057623

        Map<String, String> bodyMap = new LinkedHashMap<>();
        bodyMap.putAll(body_samsung);

        bodyMap.put("mobile", MobileEnc.core(mobile));

        Map<String, String>headerMap = new LinkedHashMap<>();
        headerMap.putAll(header_samsung);

        headerMap.put("Cookie","odin_tt=b5155e713ad28e8aeef38512bf9c421e945aff650f72153199c5d789dee11b284be12994e24a106603636f218874b02e266f0e6add3edc3c7fff97db71e60a5a; tt_webid=e5b5e020add0757f3fe64edf801c257d; install_id=3175031820265055; ttreq=1$7ba6f1384247dc07dd8b9b76d01141283dd1ae92; passport_csrf_token=768a5a302d94193f37a72c5f4dfea8ff");
        headerMap.put("x-tt-passport-csrf-token", "768a5a302d94193f37a72c5f4dfea8ff");;
        headerMap.put("X-SS-REQ-TICKET",curr.getTime()/1000+"");//2020-05-25 15:00:57  1590390057620
        headerMap.put("x-tt-trace-id","");
        headerMap.put("X-Gorgon","");
        headerMap.put("X-Khronos","");


        return null;

    }
}
