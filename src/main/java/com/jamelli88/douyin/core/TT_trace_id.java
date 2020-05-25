package com.jamelli88.douyin.core;

import com.alibaba.fastjson.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jamel.li
 * @ClassName: X_S_STUB
 * @Description 加密SS-STUB
 * @since 2020-05-25 13:17
 */
public class TT_trace_id {

    public static final String first = "4a";
    public static final String last = "0468";
    public static final String middle = "0a1016190366";

    public static void main(String[] args) {



    }

    public static Map<String,Object> requestAnalyze(){
        try {
            //excel模板路径
            File cfgFile = new File("D:\\work\\work\\20200512\\抖音手机号请求内容.xlsx");
            InputStream in = new FileInputStream(cfgFile);
            //读取excel模板
            XSSFWorkbook wb = new XSSFWorkbook(in);

            //获取sheet表格，及读取单元格内容
            XSSFSheet sheet = wb.getSheetAt(0);
            List<String> data=new ArrayList<>(sheet.getLastRowNum() + 1);

            for (int i = 1; i < sheet.getLastRowNum() + 1; i++) {

                JSONObject jsonObject=new JSONObject();

                String[] name = sheet.getRow(i).getCell(0).getStringCellValue().split("\n");

                String[] queryArr=name[0].split(" ")[1].split("\\?")[1].split("&");
                JSONObject queryJsonObject=new JSONObject();
                for (String s : queryArr) {
                    queryJsonObject.put(s.split("=")[0],s.split("=")[1]);
                }

                String[] bodyArr=name[name.length - 1].split("&");

                jsonObject.put("query",queryJsonObject);

                jsonObject.put("url","");
                JSONObject headerJsonObject=new JSONObject();

                jsonObject.put("headers","");

                jsonObject.put("body","");
                jsonObject.put("query","");
//                data.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
