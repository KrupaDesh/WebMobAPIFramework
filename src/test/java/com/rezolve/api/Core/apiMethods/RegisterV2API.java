package com.rezolve.api.Core.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Core.model.CoreData;
import com.rezolve.api.Core.model.CoreNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

import static com.rezolve.RandomGenerator.*;
import static engine.constants.RandomDataTypes.*;

public class RegisterV2API {
    public static Response verifyRegisterv2API(TestData testData, String authToken)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreData.class).getRegisterV2Path();
        Map<String, String> headers = testData.getTestData(CoreData.class).getRegisterV2Apiheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(CoreData.class).getRegisterV2ApiPayload();
        String username= getRandomDataFor(EMAIL);
        payload.put("username", username );
        payload.put("firstName",getRandomDataFor(FIRSTNAME));
        payload.put("lastName", getRandomDataFor(LASTNAME));
        payload.put("email",username);

        String schemaFilePath = "RegisterV2Schema.json";
        return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);
    }

    //***** With Negative data********//
    public static Response verifyRegisterv2APIwithIncorrectData(TestData testData)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreNegativeData.class).getRegisterV2WithIncorrectDataApiPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getRegisterV2WithIncorrectDataApiheaders();
        Map<String,Object> payload = testData.getTestData(CoreNegativeData.class).getRegisterV2WithIncorrectDataApiPayload();

        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }

    public static Response verifyRegisterv2APIwithIncorrectHeaders(TestData testData)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreNegativeData.class).getRegisterV2WithIncorrectDataApiPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getRegisterV2WithIncorrectDataApiheaders();
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        Map<String,Object> payload = testData.getTestData(CoreNegativeData.class).getRegisterV2WithIncorrectDataApiPayload();

        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }
}
