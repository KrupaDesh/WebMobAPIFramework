package com.rezolve.api.Core.apiMethods;

import com.rezolve.api.APIBaseTest;
import com.rezolve.api.APIBaseTestData;
import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Core.model.CoreData;
import com.rezolve.api.Core.model.CoreNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Map;

public class LoginAPI {

    public static Response postBaseLoginAPI(TestData testData)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(APIBaseTestData.class).getBaseloginPath();
        Map<String, String> headers = testData.getTestData(APIBaseTestData.class).getBaseloginApiheaders();
        Map<String,Object> payload = testData.getTestData(APIBaseTestData.class).getBaseloginApiPayload();
        String schemaFilePath = "LoginAPISchema.json";
        return RestAPIUtil.performPost(url, headers,payload,schemaFilePath);
    }
    public static Response postLoginAPI(TestData testData)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreData.class).getLoginPath();
        Map<String, String> headers = testData.getTestData(CoreData.class).getLoginApiheaders();
        Map<String,Object> payload = testData.getTestData(CoreData.class).getLoginApiPayload();
        String schemaFilePath = "LoginAPISchema.json";
        return RestAPIUtil.performPost(url, headers,payload,schemaFilePath);
    }

    //For new registerd user
    public static Response postLoginWithNewRegisterdUser(TestData testData, String username)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreData.class).getLoginPath();
        Map<String, String> headers = testData.getTestData(CoreData.class).getLoginApiheaders();
        Map<String,Object> payload = testData.getTestData(CoreData.class).getLoginApiPayload();
        payload.put("username",username);
        String schemaFilePath = "LoginAPISchema.json";
        return RestAPIUtil.performPost(url, headers,payload,schemaFilePath);
    }

    @SneakyThrows
    public static Response postLoginWithUpdatedPswd(TestData testData, String updatedPwd)throws IOException {
        Thread.sleep(2000);
        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreData.class).getLoginPath();
        Map<String, String> headers = testData.getTestData(CoreData.class).getLoginApiheaders();
        Map<String,Object> payload = testData.getTestData(CoreData.class).getLoginApiPayload();
        payload.put("password", updatedPwd);
        String schemaFilePath = "LoginAPISchema.json";
        Thread.sleep(2000);
        return RestAPIUtil.performPost(url, headers,payload,schemaFilePath);
    }

    //**** With incorrect data for negative test*****//
    public static Response postLoginAPIIncorrectData(TestData testData)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreNegativeData.class).getLoginAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getLoginAPIWithIncorrectDataHeaders();
        Map<String,Object> payload = testData.getTestData(CoreNegativeData.class).getLoginAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers,payload);
    }

    public static Response postLoginAPIIncorrectHeaders(TestData testData) {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreNegativeData.class).getLoginAPIWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getLoginAPIWithIncorrectDataHeaders();
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        Map<String,Object> payload = testData.getTestData(CoreNegativeData.class).getLoginAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers,payload);
    }
}
