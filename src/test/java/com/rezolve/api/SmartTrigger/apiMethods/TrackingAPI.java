package com.rezolve.api.SmartTrigger.apiMethods;

import com.rezolve.api.SmartTrigger.model.CommonPrams;
import com.rezolve.api.SmartTrigger.model.SmartTriggersData;
import com.rezolve.api.SmartTrigger.model.SmartTriggersNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class TrackingAPI {
    public static Response trackingAPI(TestData testData, String authToken)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersData.class).getTrackingAPIPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersData.class).getTrackingAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(SmartTriggersData.class).getTrackingAPIPayload();
        String schemaFilePath = "TrackingSchema.json";
        return RestAPIUtil.performPut(url, headers, payload,schemaFilePath);

    }
    public static Response trackingAPIWithoutAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getTrackingAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getTrackingAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        Map<String,Object> payload = testData.getTestData(SmartTriggersNegativeData.class).getTrackingAPIWithIncorrectDataPayload();

        return RestAPIUtil.performPutWithoutSchema(url, headers, payload);
    }
    public static Response trackingAPIWithEmptyData(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getTrackingAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getTrackingAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(SmartTriggersNegativeData.class).getTrackingAPIWithIncorrectDataPayload();
        payload.put("latitude","");
        payload.put("longitude","");
        payload.put("radius","");
        payload.put("coordinateSystem","");
        return RestAPIUtil.performPutWithoutSchema(url, headers, payload);
    }
}
