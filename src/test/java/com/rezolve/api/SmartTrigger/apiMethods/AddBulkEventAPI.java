package com.rezolve.api.SmartTrigger.apiMethods;

import com.rezolve.api.SmartTrigger.model.CommonPrams;
import com.rezolve.api.SmartTrigger.model.SmartTriggersData;
import com.rezolve.api.SmartTrigger.model.SmartTriggersNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class AddBulkEventAPI {
    public static Response addBulkEventAPI(TestData testData, String authToken)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersData.class).getAddBulkEventAPIPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersData.class).getAddBulkEventAPIheaders();
        Map<String,Object> payload = testData.getTestData(SmartTriggersData.class).getAddBulkEventAPIPayload();
        headers.put("authorization",authToken);
        return RestAPIUtil.performPostWithoutSchema(url, headers,payload);

    }
    public static Response addBulkEventAPIWithEmptyBody(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getAddBulkEventAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getAddBulkEventAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(SmartTriggersNegativeData.class).getAddBulkEventAPIWithIncorrectDataPayload();
        payload.remove("eventType");
        payload.remove("timestamp");
        payload.remove("latitude");
        payload.remove("longitude");
        payload.remove("coordinateSystem");
        return RestAPIUtil.performPostWithoutSchema(url, headers,payload);
    }
    public static Response addBulkEventAPIWithNullData(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getAddBulkEventAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getAddBulkEventAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(SmartTriggersNegativeData.class).getAddBulkEventAPIWithIncorrectDataPayload();
        payload.put("eventType",null);
        payload.put("timestamp",null);
        payload.put("latitude", null);
        payload.put("longitude",null);
        payload.put("coordinateSystem",null);
        return RestAPIUtil.performPostWithoutSchema(url, headers,payload);
    }

}
