package com.jamelli88.douyin.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * http请求
 * <br/>
 *
 * @author jamel.li
 * @date 2019/11/22 14:31
 */
@Slf4j
public class HttpUtil {

    /**
     * DEFAULT_HEADERS
     */
    public static Header[] DEFAULT_HEADERS = {
            new BasicHeader("Content-type", "application/json"),
            new BasicHeader("DataEncoding", "UTF-8")};

    /**
     * 发送原生put请求
     * <br/>
     *
     * @param url                      请求的url
     * @param jsonStr                  请求的参数，json格式
     * @param connectionTimeout        连接建立时间，三次握手时间（毫秒）
     * @param connectionRequestTimeout 从连接池获取连接的超时时间（毫秒）
     * @param socketTimeout            传输过程中数据包间隔最大时间（毫秒）
     * @return java.lang.String
     * @author jamel.li
     * @date 2019/11/22 15:32
     */
    public static String request(String url, String requestType, String jsonStr, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {

        HttpPut httpRequest = new HttpPut(url);
        //设置超时时间
        String result = null;
        try {
            httpRequest.setEntity(new StringEntity(jsonStr));
            result = execute(httpRequest, DEFAULT_HEADERS, connectionTimeout, connectionRequestTimeout, socketTimeout);
        } catch (UnsupportedEncodingException e) {
            log.error("", e.toString());
        } finally {
            httpRequest = null;
        }
        return result;
    }

    /**
     * 发送原生put请求
     * <br/>
     *
     * @param url                      请求的url
     * @param jsonStr                  请求的参数，json格式
     * @param connectionTimeout        连接建立时间，三次握手时间（毫秒）
     * @param connectionRequestTimeout 从连接池获取连接的超时时间（毫秒）
     * @param socketTimeout            传输过程中数据包间隔最大时间（毫秒）
     * @return java.lang.String
     * @author jamel.li
     * @date 2019/11/22 15:32
     */
    public static String doPut(String url, String jsonStr, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {

        HttpPut httpRequest = new HttpPut(url);
        //设置超时时间
        String result = null;
        try {
            httpRequest.setEntity(new StringEntity(jsonStr));
            result = execute(httpRequest, DEFAULT_HEADERS, connectionTimeout, connectionRequestTimeout, socketTimeout);
        } catch (UnsupportedEncodingException e) {
            log.error("", e.toString());
        } finally {
            httpRequest = null;
        }
        return result;
    }

    /**
     * 发送原生delete请求
     * <br/>
     *
     * @param url                      请求的url
     * @param connectionTimeout        连接建立时间，三次握手时间（毫秒）
     * @param connectionRequestTimeout 从连接池获取连接的超时时间（毫秒）
     * @param socketTimeout            传输过程中数据包间隔最大时间（毫秒）
     * @return java.lang.String
     * @author jamel.li
     * @date 2019/11/22 15:32
     */
    public static String doDelete(String url, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {

        HttpDelete httpRequest = new HttpDelete(url);
        //设置超时时间
        String result = null;
        try {
            result = execute(httpRequest, DEFAULT_HEADERS, connectionTimeout, connectionRequestTimeout, socketTimeout);
        } finally {
            httpRequest = null;
        }
        return result;
    }

    /**
     * 发送原生put请求
     * <br/>
     *
     * @param url                      请求的url
     * @param connectionTimeout        连接建立时间，三次握手时间（毫秒）
     * @param connectionRequestTimeout 从连接池获取连接的超时时间（毫秒）
     * @param socketTimeout            传输过程中数据包间隔最大时间（毫秒）
     * @return java.lang.String
     * @author jamel.li
     * @date 2019/11/22 15:32
     */
    public static String doPost(String url, String jsonStr, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {

        HttpPost httpRequest = new HttpPost(url);
        //设置超时时间
        String result = null;
        try {
            httpRequest.setEntity(new StringEntity(jsonStr));
            result = execute(httpRequest, DEFAULT_HEADERS, connectionTimeout, connectionRequestTimeout, socketTimeout);
        } catch (UnsupportedEncodingException e) {
            log.error("", e.toString());
        } finally {
            httpRequest = null;
        }
        return result;
    }

    /**
     * 发送原生get请求
     * <br/>
     *
     * @param url
     * @return java.lang.String
     * @author jamel.li
     * @date 2019/11/22 15:56
     */
    public static String doGet(String url, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {

        HttpGet httpRequest = new HttpGet(url);

        //设置超时时间
        String result = null;
        try {
            result = execute(httpRequest, DEFAULT_HEADERS, connectionTimeout, connectionRequestTimeout, socketTimeout);
        } finally {
            httpRequest = null;
        }
        return result;
    }

    /**
     * 执行 request
     * <br/>
     *
     * @param request 例如 HttpPut，HttpGet等等
     * @return java.lang.String
     * @author jamel.li
     * @date 2019/11/22 15:54
     */
    public static String execute(HttpRequestBase request, Header[] headers, int connectionTimeout, int connectionRequestTimeout, int socketTimeout) {

        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(connectionTimeout).setConnectionRequestTimeout(connectionRequestTimeout).setSocketTimeout(socketTimeout).build();
        request.setConfig(requestConfig);
        request.setHeaders(headers);

        //创建客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse httpResponse = null;
        try {
            //执行请求
            httpResponse = httpClient.execute(request);
            //得到返回结果
            HttpEntity entity = httpResponse.getEntity();

            return EntityUtils.toString(entity);

        } catch (ClientProtocolException e) {
            log.error("", e.toString());
        } catch (IOException e) {
            log.error("", e.toString());
        } finally {
            if (null != httpResponse) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    log.error("", e.toString());
                }
            }
            if (null != httpClient) {
                try {
                    httpClient.close();
                } catch (IOException e) {
                    log.error("", e.toString());
                }
            }
        }
        return null;
    }

}

