package com.rezolve.api.SmartTrigger.apiMethods;

import com.rezolve.api.SmartTrigger.model.CommonPrams;
import com.rezolve.api.SmartTrigger.model.SmartTriggersData;
import com.rezolve.api.SmartTrigger.model.SmartTriggersNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GetTagsAPI {
    public static Response getTagsAPI(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersData.class).getGetTagsAPIPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersData.class).getGetTagsAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "GetTagsSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);

    }
    public static Response getTagsAPIWithoutAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getGetTagsAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getGetTagsAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getTagsAPIWithInvalidAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getGetTagsAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getGetTagsAPIWithIncorrectDataheaders();
        headers.put("authorization","InvalidAuth");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}
