package com.rezolve.api.SmartTrigger.apiMethods;

import com.rezolve.api.SmartTrigger.model.CommonPrams;
import com.rezolve.api.SmartTrigger.model.SmartTriggersData;
import com.rezolve.api.SmartTrigger.model.SmartTriggersNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class UpdateTagsAPI {
    public static Response updateTagsAPI(TestData testData, String authToken)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersData.class).getUpdateTagsAPIPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersData.class).getUpdateTagsAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(SmartTriggersData.class).getUpdateTagsAPIPayload();
        String schemaFilePath = "UpdateTagsSchema.json";
        return RestAPIUtil.performPatch(url, headers, payload,schemaFilePath);

    }
    public static Response updateTagsAPIWithEmptyData(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getUpdateTagsAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getUpdateTagsAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(SmartTriggersNegativeData.class).getUpdateTagsAPIWithIncorrectDataPayload();
        payload.remove("tags");
        return RestAPIUtil.performPatchWithoutSchema(url, headers, payload);

    }
}
