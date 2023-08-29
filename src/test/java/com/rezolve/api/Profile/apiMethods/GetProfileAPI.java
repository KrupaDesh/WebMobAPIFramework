package com.rezolve.api.Profile.apiMethods;

import com.rezolve.api.Profile.model.CommonPrams;
import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GetProfileAPI {
    public static Response getGetProfileAPI(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getGetProfileAPIPath()+partner_id+"/customer/"+user_id+"/profile";
        Map<String, String> headers = testData.getTestData(ProfileData.class).getGetProfileAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "GetProfileSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);

    }
    public static Response getGetProfileAPIWithIncorrectHeaders(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getGetProfileAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/profile";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getGetProfileAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        return RestAPIUtil.performGetWithoutSchema(url, headers);

    }
}
