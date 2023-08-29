package com.rezolve.api.Profile.apiMethods;

import com.rezolve.api.Profile.model.CommonPrams;
import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

import static com.rezolve.RandomGenerator.getRandomDataFor;
import static com.rezolve.RandomGenerator.getRandomNumber;
import static engine.constants.RandomDataTypes.FIRSTNAME;

public class AddPhonebookAPI {
    public static Response addPhonebookAPI(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getAddPhonebookAPIPath()+partner_id+"/customer/"+user_id+"/phonebook";
        Map<String, String> headers = testData.getTestData(ProfileData.class).getAddPhonebookAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(ProfileData.class).getAddPhonebookAPIPayload();
        payload.put("name", getRandomDataFor(FIRSTNAME) );
        payload.put("phone",getRandomNumber(10));
        String schemaFilePath = "AddPhonebookSchema.json";
        return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);
    }
    public static Response addPhonebookAPIWithIncorrectData(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getAddPhonebookAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/phonebook";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getAddPhonebookAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(ProfileNegativeData.class).getAddPhonebookAPIWithIncorrectDataPayload();
        payload.remove("name");
        payload.remove("phone");

        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response addPhonebookAPIWithIncorrectHeaders(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getAddPhonebookAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/phonebook";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getAddPhonebookAPIWithIncorrectDataheaders();
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        Map<String,Object> payload = testData.getTestData(ProfileNegativeData.class).getAddPhonebookAPIWithIncorrectDataPayload();

        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
}
