package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

public class GetCategoriesAndProductsForTheMerchantAPI {

    public static Response getCategoriesAndProductsForTheMerchantAPI(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getGetCategoriesAndProductsForThemerchantAPIPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/category";
        Map<String, String> headers = testData.getTestData(RCEData.class).getGetCategoriesAndProductsForThemerchantAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam = new HashMap<>();
        queryParam.put("category_sort_direction","ASC");
        queryParam.put("category_items_per_page", 30);
        queryParam.put("category_page_number", 1);
        queryParam.put("product_sort_direction","ASC" );
        queryParam.put("product_items_per_page", 30);
        queryParam.put("product_page_number", 1);
        headers.put("authorization",authToken);
        String schemaFilePath = "RCE/GetCategoriesAndProductForTheMerchanSchema.json";
        return RestAPIUtil.performGetWithQueryParam(url, headers,queryParam, schemaFilePath);
    }
    public static Response getCategoriesAndProductsForTheMerchantAPIWithNullMerchantID(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetCategoriesAndProductsForThemerchantAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"null"+"/category";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetCategoriesAndProductsForThemerchantAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam = new HashMap<>();
        queryParam.put("category_sort_direction","ASC");
        queryParam.put("category_items_per_page", 30);
        queryParam.put("category_page_number", 1);
        queryParam.put("product_sort_direction","ASC" );
        queryParam.put("product_items_per_page", 30);
        queryParam.put("product_page_number", 1);
        headers.put("authorization",authToken);
        return RestAPIUtil.performGetWithQueryParamWithoutSchema(url, headers,queryParam);
    }
    public static Response getCategoriesAndProductsForTheMerchantAPIWithIncorrectHeaders(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getGetCategoriesAndProductsForThemerchantAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"177"+"/category";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getGetCategoriesAndProductsForThemerchantAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        Map<String,Object> queryParam = new HashMap<>();
        queryParam.put("category_sort_direction","ASC");
        queryParam.put("category_items_per_page", 30);
        queryParam.put("category_page_number", 1);
        queryParam.put("product_sort_direction","ASC" );
        queryParam.put("product_items_per_page", 30);
        queryParam.put("product_page_number", 1);
        return RestAPIUtil.performGetWithQueryParamWithoutSchema(url, headers,queryParam);
    }
}
