package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.opentelemetry.sdk.trace.samplers.SamplingResult;
import io.restassured.response.Response;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class GetOrderByID {
    public static Response getOrderByIdAPI(TestData testData, String authToken, String user_id, String partner_id, String order_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getGetOrderByIDAPIPath()+partner_id+"/customer/"+user_id+"/order/"+order_id;
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetOrderByIDAPIheaders();
        headers.put("authorization",authToken);

        String schemaFilePath = "RCE/GetOrderByIDSchema.json";
        return RestAPIUtil.performGet(url, headers,schemaFilePath);
    }
    public static Response getOrderByIdAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetOrderByIDAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/order/"+"10439";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetOrderByIDAPIWithIncorrectDataheaders();
        headers.put("authorization","InvalidAuth");

        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getOrderByIdAPIWithNullDates(TestData testData,String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetOrderByIDAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/order/"+null;
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetOrderByIDAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);

        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}

