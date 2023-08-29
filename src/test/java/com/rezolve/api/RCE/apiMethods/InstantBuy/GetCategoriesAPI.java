package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class GetCategoriesAPI {
    public static Response getCategoriesAPI(TestData testData, String authToken, String user_id, String partner_id, String merchant_id,String category_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getGetCategoriesAPIPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/category/"+category_id;
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetCategoriesAPIheaders();
        headers.put("authorization",authToken);
        String schemaFilePath = "RCE/GetCategoriesSchema.json";
        return RestAPIUtil.performGet(url, headers, schemaFilePath);
    }
    public static Response getCategoriesAPIWithNullMerchantID(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetCategoriesAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"null"+"/category/"+"2";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetCategoriesAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getCategoriesAPIWithNullCategoryID(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetCategoriesAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"177"+"/category/"+"null";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetCategoriesAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
    public static Response getCategoriesAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetCategoriesAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"177"+"/category/"+"2";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetCategoriesAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        return RestAPIUtil.performGetWithoutSchema(url, headers);
    }
}
