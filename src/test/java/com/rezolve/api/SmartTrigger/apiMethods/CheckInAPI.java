package com.rezolve.api.SmartTrigger.apiMethods;

import com.rezolve.api.SmartTrigger.model.CommonPrams;
import com.rezolve.api.SmartTrigger.model.SmartTriggersData;
import com.rezolve.api.SmartTrigger.model.SmartTriggersNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class CheckInAPI {
    public static Response checkInAPI(TestData testData, String authToken)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersData.class).getCheckInAPIPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersData.class).getCheckInAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(SmartTriggersData.class).getCheckInAPIPayload();

        String schemaFilePath = "CheckInSchema.json";
        return RestAPIUtil.performPost(url, headers,payload,schemaFilePath);

    }
    public static Response checkInAPIWithoutAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        Map<String,Object> payload = testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithIncorrectDataPayload();

        return RestAPIUtil.performPostWithoutSchema(url, headers,payload);
    }
    public static Response checkInAPIInvalidAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithIncorrectDataheaders();
        headers.put("authorization","InvalidauthToken");
        Map<String,Object> payload = testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithIncorrectDataPayload();

        return RestAPIUtil.performPostWithoutSchema(url, headers,payload);
    }
    public static Response checkInAPIWithEmptyData(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithIncorrectDataPayload();
        payload.put("applicationId","");
        payload.put("version","");
        payload.put("os","");
        payload.put("pushTokenType","");
        payload.put("apiKey","");
        payload.put("pushToken","");
        return RestAPIUtil.performPostWithoutSchema(url, headers,payload);
    }
}
