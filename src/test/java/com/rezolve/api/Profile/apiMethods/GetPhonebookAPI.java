package com.rezolve.api.Profile.apiMethods;

import com.rezolve.api.Profile.model.CommonPrams;
import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GetPhonebookAPI {
    public static String url;
    public static Map<String, String> headers;

    public static Response getPhonebookAPI(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getGetPhonebookAPIPath()+partner_id+"/customer/"+user_id+"/phonebook";
        headers = testData.getTestData(ProfileData.class).getGetPhonebookAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "GetPhonebookSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);

    }
    public static Map<String,Object> getPhonebookAPI()    {
        return RestAPIUtil.performGetWithAuthRetrunMap(url, headers);

    }
    public static Response getPhonebookAPIWithIncorrectHeaders(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getGetPhonebookAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/phonebook";
        headers = testData.getTestData(ProfileNegativeData.class).getGetPhonebookAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        return RestAPIUtil.performGetWithoutSchema(url, headers);

    }
}
