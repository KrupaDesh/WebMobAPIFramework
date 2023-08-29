package com.rezolve.api.RXP.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RXP.model.RXPData;
import com.rezolve.api.RXP.model.RXPNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GetEngagementsByIDAPI {
    public static Response getEngagementByIDAPI(TestData testData, String authToken, String eng_id){

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPData.class).getGetEngagementsByIdAPIPath()+eng_id;

        Map<String, String> headers = testData.getTestData(RXPData.class).getGetEngagementsByIdAPIheaders();
        headers.put("authorization","Bearer "+authToken);

        Map<String,Object> payload = testData.getTestData(RXPData.class).getGetEngagementsByIdAPIPayload();
        String schemaFilePath = "RXP/GetEngagementsByIdSchema.json";
        return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);
    }

    public static Response getEngagementByIDAPIWithNullEngID(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPNegativeData.class).getGetEngagementsByIdAPIWithIncorrectDataPath()+"null";

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getGetEngagementsByIdAPIWithIncorrectDataheaders();
        headers.put("authorization","Bearer "+authToken);

        Map<String,Object> payload = testData.getTestData(RXPNegativeData.class).getGetEngagementsByIdAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response getEngagementByIDAPIWithoutAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPNegativeData.class).getGetEngagementsByIdAPIWithIncorrectDataPath()+"null";

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getGetEngagementsByIdAPIWithIncorrectDataheaders();
        headers.remove("authorization");

        Map<String,Object> payload = testData.getTestData(RXPNegativeData.class).getGetEngagementsByIdAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }


}
