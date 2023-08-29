package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class GetProductAPI {
    public static Response getProductAPI(TestData testData, String authToken, String user_id, String partner_id, String merchant_id, String category_id, Integer product_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getGetProductAPIPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/category/"+category_id+"/product/"+product_id;
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetProductAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "RCE/GetProductSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);
    }
    public static Response getProductAPIwithNullCategoryID(TestData testData, String authToken, String user_id, String partner_id, String merchant_id, Integer product_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetProductAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"177"+"/category/"+null+"/product/"+"4232";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetProductAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getProductAPIwithNullMerchantID(TestData testData, String authToken, String user_id, String partner_id, String category_id, Integer product_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetProductAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+null+"/category/"+category_id+"/product/"+"4232";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetProductAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getProductAPIwithIncorrectHeaders(TestData testData, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetProductAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+null+"/category/"+null+"/product/"+null;
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetProductAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}

