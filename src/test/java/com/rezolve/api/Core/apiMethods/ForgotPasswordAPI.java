package com.rezolve.api.Core.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Core.model.CoreData;
import com.rezolve.api.Core.model.CoreNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

import static com.rezolve.RandomGenerator.getRandomDataFor;
import static engine.constants.RandomDataTypes.EMAIL;

public class ForgotPasswordAPI {
    public static Response verifyForgotPasswordAPI(TestData testData, String username ) {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreData.class).getForgotPasswordPath();
        Map<String, String> headers = testData.getTestData(CoreData.class).getForgotPasswordHeaders();
        Map<String, Object> payload = testData.getTestData(CoreData.class).getForgotPasswordPayload();
        payload.put("email",username);
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }

    public static Response verifyForgotPasswordAPIwithIncorrectData(TestData testData ) {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreNegativeData.class).getForgotPasswordApiWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getForgotPasswordApiWithIncorrectDataHeaders();
        Map<String, Object> payload = testData.getTestData(CoreNegativeData.class).getForgotPasswordApiWithIncorrectDataPayload();
        payload.put("email",getRandomDataFor(EMAIL));
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }
    public static Response verifyForgotPasswordAPIwithIncorrectHeaders(TestData testData ){

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreNegativeData.class).getForgotPasswordApiWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getForgotPasswordApiWithIncorrectDataHeaders();
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        Map<String, Object> payload = testData.getTestData(CoreNegativeData.class).getForgotPasswordApiWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }
}
