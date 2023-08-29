package com.rezolve.api.Search.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Search.model.SearchData;
import com.rezolve.api.Search.model.SearchNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MerchantSearchAPI {
    public static Response merchantSearchAPI(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchData.class).getMerchantSearchAPIPath()+partner_id+"/"+user_id;

        Map<String, String> headers = testData.getTestData(SearchData.class).getMerchantSearchAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page",1);
        queryParam.put("limit",50);
        Map<String,Object> payload = testData.getTestData(SearchData.class).getMerchantSearchAPIPayload();
        String schemaFilePath = "Search/MerchantSearchSchema.json";
        return RestAPIUtil.performPostWithQueryParam(url, headers,queryParam, payload,schemaFilePath);
    }

    public static Response merchantSearchAPIRemovingMandatoryParam(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataPath()+partner_id+"/"+user_id;

        Map<String, String> headers = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page",1);
        queryParam.put("limit",50);
        Map<String,Object> payload = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataPayload();
        payload.remove("order_by");
        payload.remove("order");
        payload.remove("device_info");

        return RestAPIUtil.performPostWithQueryParamWithoutScehma(url, headers,queryParam, payload);
    }
    public static Response merchantSearchAPIWithEmptyDataForMadatoryParam(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataPath()+partner_id+"/"+user_id;

        Map<String, String> headers = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page",1);
        queryParam.put("limit",50);
        Map<String,Object> payload = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataPayload();
        payload.put("order_by","");
        payload.put("order","");
        payload.put("device_info","");

        return RestAPIUtil.performPostWithQueryParamWithoutScehma(url, headers,queryParam, payload);
    }
    public static Response merchantSearchAPIWithIncorrectQueryParam(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataPath()+partner_id+"/"+user_id;

        Map<String, String> headers = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page","kjdkjh");
        queryParam.put("limit","kjlkj");
        Map<String,Object> payload = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataPayload();


        return RestAPIUtil.performPostWithQueryParamWithoutScehma(url, headers,queryParam, payload);
    }
    public static Response merchantSearchAPIWithIncorrectDataType(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataPath()+partner_id+"/"+user_id;

        Map<String, String> headers = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page",1);
        queryParam.put("limit",50);
        Map<String,Object> payload = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataPayload();
        payload.put("order_by",1.0);
        payload.put("order",1);
        payload.put("device_info",200);

        return RestAPIUtil.performPostWithQueryParamWithoutScehma(url, headers,queryParam, payload);
    }
}
