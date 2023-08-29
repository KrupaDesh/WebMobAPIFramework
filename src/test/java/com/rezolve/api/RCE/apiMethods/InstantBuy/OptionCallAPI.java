package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class OptionCallAPI {
    public static Response optionCallAPI(TestData testData, String authToken, String user_id, String partner_id, String merchant_id, Integer product_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost() + testData.getTestData(RCEData.class).getOptionCallAPIPath() + partner_id + "/customer/" + user_id + "/merchant/" + merchant_id + "/options";
        Map<String, String> headers = testData.getTestData(RCEData.class).getOptionCallAPIheaders();
        headers.put("authorization", authToken);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> payload = objectMapper.convertValue(testData.getTestData(RCEData.class).getOptionCallAPIPayload(), Map.class);

        payload.put("id", product_id);
        payload.put("qty", Integer.valueOf(1));
        //System.out.println("Integer value to get from map: "+Integer.valueOf((String) payload.get("qty")));
        String schemaFilePath = "RCE/OptionCallSchema.json";
        return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);
    }

    //For ACI payment method
    public static Response optionCallACIAPI(TestData testData, String authToken, String user_id, String partner_id,Integer product_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost() + testData.getTestData(RCEData.class).getOptionCallACIAPIPath() + partner_id + "/customer/" + user_id + "/merchant/"
                + testData.getTestData(RCEData.class).getOptionCallACIMerchantID() + "/options";
        Map<String, String> headers = testData.getTestData(RCEData.class).getOptionCallACIAPIheaders();
        headers.put("authorization", authToken);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> payload = objectMapper.convertValue(testData.getTestData(RCEData.class).getOptionCallACIAPIPayload(), Map.class);
        payload.put("id", Integer.valueOf(4240));
        Integer productid = Integer.parseInt(payload.get("id").toString());

        payload.put("id", productid);
        payload.put("qty", Integer.valueOf(1));
        //System.out.println("Integer value to get from map: "+Integer.valueOf((String) payload.get("qty")));
        String schemaFilePath = "RCE/OptionCallSchema.json";
        return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);
    }
    public static Response optionCallAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost() + testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPath() + partner_id + "/customer/" + user_id + "/merchant/" + "177" + "/options";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> payload = objectMapper.convertValue(testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPayload(), Map.class);

        payload.put("id", Integer.valueOf(4232));
        payload.put("qty", Integer.valueOf(1));
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response optionCallAPIWithEmptyData(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost() + testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPath() + partner_id + "/customer/" + user_id + "/merchant/" + "177" + "/options";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataheaders();
        headers.put("authorization", authToken);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> payload = objectMapper.convertValue(testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPayload(), Map.class);
        payload.clear();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response optionCallAPIWithNullData(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost() + testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPath() + partner_id + "/customer/" + user_id + "/merchant/" + "177" + "/options";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataheaders();
        headers.put("authorization", authToken);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> payload = objectMapper.convertValue(testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPayload(), Map.class);
        payload.put("id", null);
        payload.put("qty", null);
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response optionCallAPIWithMaxQty(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost() + testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPath() + partner_id + "/customer/" + user_id + "/merchant/" + "177" + "/options";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataheaders();
        headers.put("authorization", authToken);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> payload = objectMapper.convertValue(testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPayload(), Map.class);
        String id = payload.get("id").toString();
        payload.put("id", Integer.valueOf(4232));
        payload.put("qty", Integer.valueOf(898));
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response optionCallAPIWithInvalidID(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost() + testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPath() + partner_id + "/customer/" + user_id + "/merchant/" + "177" + "/options";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataheaders();
        headers.put("authorization", authToken);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> payload = objectMapper.convertValue(testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectDataPayload(), Map.class);
        String id = payload.get("id").toString();
        payload.put("id", Integer.valueOf(42320997));
        payload.put("qty", Integer.valueOf(1));
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
}
