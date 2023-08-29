package com.rezolve.api.SmartTrigger.apiMethods;

import com.rezolve.api.SmartTrigger.model.CommonPrams;
import com.rezolve.api.SmartTrigger.model.SmartTriggersData;
import com.rezolve.api.SmartTrigger.model.SmartTriggersNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MyAreaAPI {
    public static Response myAreaAPI(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersData.class).getMyAreaAPIPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersData.class).getMyAreaAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("lat",43.811);
        queryParam.put("lng",18.319486);
        queryParam.put("distance",20000);
        queryParam.put("coordinateSystem","WGS84");
        queryParam.put("filter","ALL");
        queryParam.put("limit",100);
        queryParam.put("offset",0);
        String schemaFilePath = "MyAreaSchema.json";
        return RestAPIUtil.performGetWithQueryParam(url, headers, queryParam, schemaFilePath);

    }
    public static Response myAreaAPIwithoutQueryParam(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getBitplace_host()+testData.getTestData(SmartTriggersNegativeData.class).getMyAreaAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(SmartTriggersNegativeData.class).getMyAreaAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);

        return RestAPIUtil.performGetWithoutSchema(url, headers);

    }
}
