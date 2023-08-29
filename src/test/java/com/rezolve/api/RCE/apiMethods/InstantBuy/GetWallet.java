package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class GetWallet {
    public static Response getWalletAPI(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getGetWalletAPIPath()+partner_id+"/customer/"+user_id+"/wallet";
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetWalletAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "RCE/GetWalletSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);
    }
    public static Response getWalletAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetWalletAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/wallet";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetWalletAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}


