package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class GetMerchantAPI {

    public static Response getMerchantAPI(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getGetMerchantsAPIPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id;
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetMerchantsAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "RCE/GetMerchantSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);
    }
    public static Response getMerchantAPIWithNullMerchantID(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetMerchantsAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"null";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetMerchantsAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getMerchantAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetMerchantsAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"null";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetMerchantsAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}
