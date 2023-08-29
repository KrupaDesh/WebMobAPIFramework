package com.rezolve.api.Profile.apiMethods;

import com.rezolve.api.Profile.model.CommonPrams;
import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class DeletePhonebookAPI {
    public static Response delPhonebookAPI(TestData testData, String authToken, String user_id, String partner_id, String phone_id)throws IOException {

        //String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getDelPhonebookAPIPath()+partner_id+"/customer/"+user_id+"/phonebook";
        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getDelPhonebookAPIPath()+partner_id+"/customer/"+user_id+"/phonebook/";
        Map<String, String> headers = testData.getTestData(ProfileData.class).getDelPhonebookAPIheaders();
        headers.put("authorization",authToken);
        String delString ="/"+phone_id;
        return RestAPIUtil.performDelWithAuth(url, headers,delString);

    }
    public static Response delPhonebookAPIWithIncorrectData(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getDelPhonebookAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/phonebook/";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getDelPhonebookAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        String delString ="/"+testData.getTestData(ProfileNegativeData.class).getDelPhonebookAPIWithIncorrectDataPhoneId();
        return RestAPIUtil.performDelWithAuth(url, headers,delString);

    }
    public static Response delPhonebookAPIWithIncorrectHeaders(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getDelPhonebookAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/phonebook/";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getDelPhonebookAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        String delString ="/"+testData.getTestData(ProfileNegativeData.class).getDelPhonebookAPIWithIncorrectDataPhoneId();
        return RestAPIUtil.performDelWithAuth(url, headers,delString);

    }
}
