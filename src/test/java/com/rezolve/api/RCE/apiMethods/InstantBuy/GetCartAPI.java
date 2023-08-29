package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class GetCartAPI {
    public static Response getCartAPI(TestData testData, String authToken, String user_id, String partner_id)  {

        String url = testData.getTestData(CommonPrams.class).getCoreHost() + testData.getTestData(RCEData.class).getGetCartAPIPath() + partner_id + "/customer/" + user_id + "/cart";
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetCartAPIheaders();
        headers.put("authorization", authToken);
        String schemaFilePath = "RCE/GetCartSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);
    }
    public static Response getCartAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id)  {

        String url = testData.getTestData(CommonPrams.class).getCoreHost() + testData.getTestData(RCENegativeData.class).getGetCartAPIWithIncorrectDataPath() + partner_id + "/customer/" + user_id + "/cart";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetCartAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}
