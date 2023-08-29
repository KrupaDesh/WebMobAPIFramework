package com.rezolve.api.Profile.apiMethods;

import com.rezolve.api.Profile.model.CommonPrams;
import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class AddAddressAPI {
    public static Response addAddressAPI(TestData testData, String authToken, String user_id, String partner_id, String phone_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getAddAddressAPIPath()+partner_id+"/customer/"+user_id+"/addressbook";
        Map<String, String> headers = testData.getTestData(ProfileData.class).getAddAddressAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(ProfileData.class).getAddAddressAPIPayload();
        payload.put("phone_id", phone_id );
        String schemaFilePath = "AddAddressSchema.json";
        return RestAPIUtil.performPost(url, headers, payload,schemaFilePath);

    }
    public static Response addAddressAPIWithIncorrectData(TestData testData, String authToken, String user_id, String partner_id){

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getAddAddressAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/addressbook";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getAddAddressAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(ProfileNegativeData.class).getAddAddressAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }
    public static Response addAddressAPIWithIncorrectHeaders(TestData testData, String authToken, String user_id, String partner_id){

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getAddAddressAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/addressbook";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getAddAddressAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        Map<String,Object> payload = testData.getTestData(ProfileNegativeData.class).getAddAddressAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }
}
