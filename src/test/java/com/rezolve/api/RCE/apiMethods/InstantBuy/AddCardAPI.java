package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class AddCardAPI {
    public static Response addCardAPI(TestData testData, String authToken, String user_id, String partner_id, String address_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getAddCardAPIPath()+partner_id+"/customer/"+user_id+"/wallet";
        Map<String, String> headers = testData.getTestData(RCEData.class).getAddCardAPIheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCEData.class).getAddCardAPIPayload();
        payload.put("address_id",address_id);
        String schemaFilePath = "RCE/AddCardSchema.json";
        return RestAPIUtil.performPost(url, headers, payload,schemaFilePath);
    }
    public static Response addCardAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/wallet";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectDataheaders();
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response addCardAPIWithNullData(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/wallet";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectDataPayload();
        payload.put("valid_from",null);
        payload.put("type",null);
        payload.put("short_name",null);
        payload.put("pan6",null);
        payload.put("pan4",null);
        payload.put("pan",null);
        payload.put("name_on_card",null);
        payload.put("expires_on",null);
        payload.put("brand",null);
        payload.put("address_id",null);
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response addCardAPIWithEmptyData(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/wallet";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectDataPayload();
        payload.clear();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
}
