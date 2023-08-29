package com.rezolve.api.RXP.apiMethods;

import com.rezolve.api.RXP.model.RXPData;
import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RXP.model.RXPNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GetGeoEngagementsAPI {
    public static Response getGeoEngagementsAPI(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPData.class).getGetGeoEngagementsAPIPath();

        Map<String, String> headers = testData.getTestData(RXPData.class).getGetGeoEngagementsAPIheaders();
        headers.put("authorization","Bearer "+authToken);

        Map<String,Object> queryParam = testData.getTestData(RXPData.class).getGetGeoEngagementsAPIQueryParam();
        String schemaFilePath = "RXP/GetGeoEngagementsSchema.json";
        return RestAPIUtil.performGetWithQueryParam(url, headers,queryParam, schemaFilePath);
    }

    public static Response getGeoEngagementsAPIWithMissingQueryParam(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPNegativeData.class).getGetGeoEngagementsAPIWithIncorrectDataPath();

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getGetGeoEngagementsAPIWithIncorrectDataheaders();
        headers.put("authorization","Bearer "+authToken);

        Map<String,Object> queryParam = testData.getTestData(RXPNegativeData.class).getGetGeoEngagementsAPIWithIncorrectDataQueryParam();
        queryParam.remove("area.center.latitude");
        queryParam.remove("area.center.longitude");
        return RestAPIUtil.performGetWithQueryParamWithoutSchema(url, headers, queryParam);
    }
    public static Response getGeoEngagementsAPIWithoutAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPNegativeData.class).getGetGeoEngagementsAPIWithIncorrectDataPath();

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getGetGeoEngagementsAPIWithIncorrectDataheaders();
        headers.remove("authorization");

        Map<String,Object> queryParam = testData.getTestData(RXPNegativeData.class).getGetGeoEngagementsAPIWithIncorrectDataQueryParam();
        return RestAPIUtil.performGetWithQueryParamWithoutSchema(url, headers, queryParam);
    }


}
