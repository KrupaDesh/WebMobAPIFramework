package com.rezolve.api.Profile.apiMethods;

import com.rezolve.api.Profile.model.CommonPrams;
import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GetPublicKeyAPI {

    public static Response getpublicKeyAPI(TestData testData, String authToken,String user_id,String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getGetPublicKeyAPIPath()+partner_id+"/customer/"+user_id+"/publickey";
        Map<String, String> headers = testData.getTestData(ProfileData.class).getGetPublicKeyAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "GetPublicKeySchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);
    }
    public static Response getpublicKeyAPIwithIncorrectHeader(TestData testData, String authToken,String user_id,String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getGetPublicKeyAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/publickey";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getGetPublicKeyAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}
