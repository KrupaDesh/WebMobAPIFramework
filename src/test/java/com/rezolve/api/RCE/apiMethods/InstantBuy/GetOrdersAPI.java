package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class GetOrdersAPI {
    public static Response getOrdersAPI(TestData testData, String authToken, String user_id, String partner_id) {
        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getGetOrdersAPIPath()+partner_id+"/customer/"+user_id+"/order";
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetOrdersAPIheaders();
        headers.put("authorization",authToken);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime oneYearBack = now.minusYears(1);
        String today = now.format(formatter);
        String pastDate = oneYearBack.format(formatter);
        Map<String,Object> queryParam = new HashMap<>();
        queryParam.put("from", pastDate);
        queryParam.put("to",today);
        String schemaFilePath = "RCE/GetOrdersSchema.json";
        return RestAPIUtil.performGetWithQueryParam(url, headers, queryParam,schemaFilePath);
    }
    public static Response getOrdersAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id) {
        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetOrdersAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/order";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetOrdersAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getOrdersAPIWithIncorrectDates(TestData testData,String authToken, String user_id, String partner_id) {
        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetOrdersAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/order";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetOrdersAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam = new HashMap<>();
        queryParam.put("from", null);
        queryParam.put("to",null);
        return RestAPIUtil.performGetWithQueryParamWithoutSchema(url, headers,queryParam);
    }
}

