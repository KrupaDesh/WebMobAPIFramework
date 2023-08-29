package com.rezolve.api.Profile.apiMethods;

import com.rezolve.api.Profile.model.CommonPrams;
import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class UpdatePhonebookAPI {
    public static Response updatePhonebookAPI(TestData testData, String authToken, String user_id, String partner_id, String phone_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getUpdatePhonebookAPIPath()+partner_id+"/customer/"+user_id+"/phonebook";
        Map<String, String> headers = testData.getTestData(ProfileData.class).getUpdatePhonebookAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(ProfileData.class).getUpdatePhonebookAPIPayload();
        String putString ="/"+phone_id;
        String schemaFilePath = "UpdatePhonebookSchema.json";
        return RestAPIUtil.performPut(url, headers, payload,putString,schemaFilePath);

    }
    public static Response updatePhonebookAPIWithIncorrectHeaders(TestData testData, String authToken, String user_id, String partner_id) {

        String putstring = testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIWithIncorrectDataPhoneId();
        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/phonebook/"+putstring;
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        Map<String,Object> payload = testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPutWithoutSchema(url, headers, payload);

    }
    public static Response updatePhonebookAPIWithIncorrectData(TestData testData, String authToken, String user_id, String partner_id) {
        String putstring = testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIWithIncorrectDataPhoneId();
        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/phonebook/"+putstring;
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIWithIncorrectDataPayload();
        payload.put("phone","");
        payload.put("name","");
        return RestAPIUtil.performPutWithoutSchema(url, headers, payload);

    }
}
