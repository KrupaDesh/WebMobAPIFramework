package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class UpdateCard {
    public static Response updateCardAPI(TestData testData, String authToken, String user_id, String partner_id, String address_id, String card_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getUpdateCardAPIPath()+partner_id+"/customer/"+user_id+"/wallet/"+card_id;
        Map<String, String> headers = testData.getTestData(RCEData.class).getUpdateCardAPIheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCEData.class).getUpdateCardAPIPayload();
        payload.put("address_id",address_id);
        String schemaFilePath = "RCE/UpdateCardSchema.json";
        return RestAPIUtil.performPut(url, headers, payload,schemaFilePath);
    }
    public static Response updateCardAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/wallet/"
                +testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataCardID();
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPutWithoutSchema(url, headers, payload);
    }
    public static Response updateCardAPIWithNullData(TestData testData, String authToken, String user_id, String partner_id,String card_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/wallet/"
                +card_id;
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataPayload();
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
    public static Response updateCardAPIWithEmptyData(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/wallet/"
                +testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataCardID();
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectDataPayload();
        payload.clear();
        return RestAPIUtil.performPutWithoutSchema(url, headers, payload);
    }
}
