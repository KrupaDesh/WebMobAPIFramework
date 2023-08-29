package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class AddToCartAPI {
    public static Response addToCartAPI(TestData testData, String authToken, String user_id, String partner_id, String merchant_id, Integer product_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getAddtoCartAPIPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/cart";
        Map<String, String> headers = testData.getTestData(RCEData.class).getAddtoCartAPIheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCEData.class).getAddtoCartAPIPayload();
        Map<String,Object> product = (Map<String, Object>) payload.get("product");
        product.put("id",Integer.valueOf(product_id));
        product.put("qty",Integer.valueOf(1));
        String schemaFilePath = "RCE/AddToCartSchema.json";
        return RestAPIUtil.performPost(url, headers, payload,schemaFilePath);
    }
    public static Response addToCartAPIWithIncorrectHeaders(TestData testData,String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/cart";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectDataPayload();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response addToCartAPIWithEmptyData(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"177"+"/cart";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectDataPayload();
        payload.clear();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response addToCartAPIWithNullData(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"177"+"/cart";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectDataPayload();
        payload.put("product",null);
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
}
