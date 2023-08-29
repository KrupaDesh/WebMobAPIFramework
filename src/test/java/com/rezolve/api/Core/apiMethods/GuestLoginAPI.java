package com.rezolve.api.Core.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Core.model.CoreData;
import com.rezolve.api.Core.model.CoreNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GuestLoginAPI {
    public static Response verifyGuestLoginAPI(TestData testData, String username) throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost() + testData.getTestData(CoreData.class).getGuestLoginPath();
        Map<String, String> headers = testData.getTestData(CoreData.class).getGuestLoginHeaders();
        Map<String, Object> payload = testData.getTestData(CoreData.class).getGuestLoginPayload();
        payload.put("entityId", username);
        String schemaFilePath = "GuestLoginSchema.json";
        return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);

    }

    public static Response verifyGuestLoginAPIwithIncorrectData(TestData testData, String username) throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost() + testData.getTestData(CoreNegativeData.class).getGuestLoginApiWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getGuestLoginApiWithIncorrectDataHeaders();
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        Map<String, Object> payload = testData.getTestData(CoreNegativeData.class).getGuestLoginApiWithIncorrectDataPayload();
        //payload.put("entityId", username);
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }
}
