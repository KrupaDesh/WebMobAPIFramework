package com.rezolve.api.RXP.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RXP.model.RXPData;
import com.rezolve.api.RXP.model.RXPNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class SearchEngagementAPI {
    public static Response searchEngagementAPI(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPData.class).getSearchEngagementAPIPath();

        Map<String, String> headers = testData.getTestData(RXPData.class).getSearchEngagementAPIheaders();
        headers.put("authorization","Bearer "+authToken);

        Map<String,Object> payload = testData.getTestData(RXPData.class).getSearchEngagementAPIPayload();
        payload.put("offset", Integer.valueOf(0));
        payload.put("limit", Integer.valueOf(0));
        String schemaFilePath = "RXP/SearchEngagementSchema.json";
        return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);
    }
    public static Response searchEngagementAPIWithIncorrectdata(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPNegativeData.class).getSearchEngagementAPIWithIncorrectDataPath();

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getSearchEngagementAPIWithIncorrectDataheaders();
        headers.put("authorization","Bearer "+authToken);

        Map<String,Object> payload = testData.getTestData(RXPNegativeData.class).getSearchEngagementAPIWithIncorrectDataPayload();
        payload.put("engagementStatusEnums", new String[]{"EmbedInProgress"});
        payload.put("engagementTypeEnums", new String[]{"EmbedInProgress"});
        payload.put("offset", "@#@");
        payload.put("limit", Integer.valueOf(0));
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response searchEngagementAPIWithoutAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPNegativeData.class).getSearchEngagementAPIWithIncorrectDataPath();

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getSearchEngagementAPIWithIncorrectDataheaders();
        headers.remove("authorization");

        Map<String,Object> payload = testData.getTestData(RXPNegativeData.class).getSearchEngagementAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
}
