package com.rezolve.api.Core.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Core.model.CoreData;
import com.rezolve.api.Core.model.CoreNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GuestRegisterAPI {
    public static Response verifyGuestRegisterAPI(TestData testData)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreData.class).getGuestRegisterPath();
        Map<String, String> headers = testData.getTestData(CoreData.class).getGuestRegisterHeaders();

        String schemaFilePath = "GuestRegisterSchema.json";
        return RestAPIUtil.performPostWithoutBody(url, headers, schemaFilePath);

    }

    public static Response verifyGuestRegisterAPIwithIncorrectHeaders(TestData testData)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreNegativeData.class).getGuestRegisterApiWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getGuestRegisterApiWithIncorrectDataHeaders();
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        return RestAPIUtil.performPostWithoutBodyAndSchema(url, headers);

    }
}
