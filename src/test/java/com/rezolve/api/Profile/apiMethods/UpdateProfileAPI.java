package com.rezolve.api.Profile.apiMethods;

import com.rezolve.api.Profile.model.CommonPrams;
import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class UpdateProfileAPI {
    public static Response updateprofileAPI(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileData.class).getUpdateProfileAPIPath()+partner_id+"/customer/"+user_id+"/profile";
        Map<String, String> headers = testData.getTestData(ProfileData.class).getUpdateProfileAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(ProfileData.class).getUpdateProfileAPIPayload();
        String schemaFilePath = "UpdateProfileSchema.json";
        return RestAPIUtil.performPut(url, headers, payload,schemaFilePath);

    }
    public static Response updateprofileAPIWithIncorrectData(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(ProfileNegativeData.class).getUpdateProfileAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/profile";
        Map<String, String> headers = testData.getTestData(ProfileNegativeData.class).getUpdateProfileAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> payload = testData.getTestData(ProfileNegativeData.class).getUpdateProfileAPIWithIncorrectDataPayload();
        payload.put("use_data_for_marketing",null);
        return RestAPIUtil.performPutWithoutSchema(url, headers, payload);

    }

}
