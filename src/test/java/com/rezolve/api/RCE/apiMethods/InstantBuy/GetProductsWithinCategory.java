package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GetProductsWithinCategory {
    public static Response getProductsWithinCategoryAPI(TestData testData, String authToken, String user_id, String partner_id, String merchant_id,String category_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getGetProductsWithinCategoryAPIPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/category/"+category_id+"/product";
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetProductsWithinCategoryAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "RCE/GetProductsWithinCategorySchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);
    }
    public static Response getProductsWithinCategoryAPIWithNullMerchantID(TestData testData, String authToken, String user_id, String partner_id,String category_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetProductsWithinCategoryAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"null"+"/category/"+category_id+"/product";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetProductsWithinCategoryAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getProductsWithinCategoryAPIWithIncorrectHeaders(TestData testData, String authToken, String user_id, String partner_id,String merchant_id,String category_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetProductsWithinCategoryAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/category/"+category_id+"/product";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetProductsWithinCategoryAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}
