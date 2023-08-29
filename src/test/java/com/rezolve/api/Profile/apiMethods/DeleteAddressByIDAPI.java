package com.rezolve.api.Profile.apiMethods;

import com.rezolve.api.Profile.model.CommonPrams;
import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class DeleteAddressByIDAPI {
    public static Response delAddressAPI(TestData testData, String authToken, String user_id, String partner_id, String address_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getDelAddressByIDAPIPath()+partner_id+"/customer/"+user_id+"/addressbook/";
        Map<String, String> headers = testData.getTestData(ProfileData.class).getDelAddressByIDAPIheaders();
        headers.put("authorization",authToken);
        return RestAPIUtil.performDelWithAuth(url, headers,address_id);

    }
    public static Response delAddressAPIwithAddressAttachedToCard(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getDelAddressByIDAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/addressbook/";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getDelAddressByIDAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        String address_id = testData.getTestData(ProfileNegativeData.class).getDelAddressByIDAPIWithIncorrectDataAddress();
        return RestAPIUtil.performDelWithAuth(url, headers,address_id);

    }
    public static Response delAddressAPIwithIncorrectHeaders(TestData testData, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getDelAddressByIDAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/addressbook/";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getDelAddressByIDAPIWithIncorrectDataheaders();
        headers.put("x-rezolve-partner-apikey","123jlklk");//entering incorrect vlaue
        String address_id = testData.getTestData(ProfileNegativeData.class).getDelAddressByIDAPIWithIncorrectDataAddress();
        return RestAPIUtil.performDelWithAuth(url, headers,address_id);

    }
}
