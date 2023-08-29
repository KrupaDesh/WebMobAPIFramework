package com.rezolve.api.RXP.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RXP.model.RXPData;
import com.rezolve.api.RXP.model.RXPNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class OAuthAPI {
    public static Response oAuthAPI(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getOauth_host()+testData.getTestData(RXPData.class).getOAuthAPIPath();

        Map<String, String> headers = testData.getTestData(RXPData.class).getOAuthAPIheaders();

        Map<String,Object> payload = testData.getTestData(RXPData.class).getOAuthAPIPayload();
        String schemaFilePath = "RXP/OAuthSchema.json";
        return RestAPIUtil.performPost(url, headers,payload, schemaFilePath);
    }
    public static Response oAuthAPIWithIncorrectdata(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getOauth_host()+testData.getTestData(RXPNegativeData.class).getOAuthAPIWithIncorrectDataPath();

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getOAuthAPIWithIncorrectDataheaders();

        Map<String,Object> payload = testData.getTestData(RXPNegativeData.class).getOAuthAPIWithIncorrectDataPayload();
        payload.remove("apiAudience");
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response oAuthAPIWithoutAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getOauth_host()+testData.getTestData(RXPNegativeData.class).getOAuthAPIWithIncorrectDataPath();

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getOAuthAPIWithIncorrectDataheaders();
        headers.remove("Authorization");

        Map<String,Object> payload = testData.getTestData(RXPNegativeData.class).getOAuthAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
}
