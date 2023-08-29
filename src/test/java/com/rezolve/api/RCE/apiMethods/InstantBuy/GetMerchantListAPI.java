package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GetMerchantListAPI {
    public static Response getMerchantListAPI(TestData testData, String authToken,String user_id,String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getGetMerchantsListAPIPath()+partner_id+"/customer/"+user_id+"/merchant";
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetMerchantsListAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "RCE/GetMerchantListSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);
    }
    public static Response getMerchantListAPIWithIncorrectHeaders(TestData testData, String authToken,String user_id,String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetMerchantsListAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetMerchantsListAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }


}
