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

public class GetActByIDAPI {
    public static Response getActByIDAPI(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPData.class).getGetActByIdAPIPath()
                +testData.getTestData(RXPData.class).getGetActByIdAPIAct_ID();

        Map<String, String> headers = testData.getTestData(RXPData.class).getGetActByIdAPIheaders();
        headers.put("authorization","Bearer "+authToken);

        String schemaFilePath = "RXP/GetActByIDSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);
    }
    public static Response getActByIDAPIWithNullActID(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPNegativeData.class).getGetActByIdAPIWithIncorrectDataPath()+"null";

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getGetActByIdAPIWithIncorrectDataheaders();
        headers.put("authorization","Bearer "+authToken);
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getActByIDAPIWithoutAuth(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getEngagament_host()+testData.getTestData(RXPNegativeData.class).getGetActByIdAPIWithIncorrectDataPath()
                +testData.getTestData(RXPNegativeData.class).getGetActByIdAPIWithIncorrectDataAct_ID();;

        Map<String, String> headers = testData.getTestData(RXPNegativeData.class).getGetActByIdAPIWithIncorrectDataheaders();
        headers.remove("authorization");

        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}
