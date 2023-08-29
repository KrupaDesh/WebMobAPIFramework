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

public class ProductSearchAPI {
    public static Response productSearchAPI(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchData.class).getProductSearchAPIPath()+partner_id+"/"+user_id;
        Map<String, String> headers = testData.getTestData(SearchData.class).getProductSearchAPIheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page",1);
        queryParam.put("limit",50);
        Map<String,Object> payload = testData.getTestData(SearchData.class).getProductSearchAPIPayload();
        String schemaFilePath = "Search/ProductSearchSchema.json";
        return RestAPIUtil.performPostWithQueryParam(url, headers,queryParam, payload,schemaFilePath);
    }

    public static Response productSearchAPIRemovingMandatoryParam(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataPath()+partner_id+"/"+user_id;

        Map<String, String> headers = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page",1);
        queryParam.put("limit",50);
        Map<String,Object> payload = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataPayload();
        payload.remove("order_by");
        payload.remove("order");
        payload.remove("device_info");

        return RestAPIUtil.performPostWithQueryParamWithoutScehma(url, headers,queryParam, payload);
    }
    public static Response productSearchAPIWithEmptyDataForMadatoryParam(TestData testData, String authToken, String user_id, String partner_id)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataPath()+partner_id+"/"+user_id;

        Map<String, String> headers = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page",1);
        queryParam.put("limit",50);
        Map<String,Object> payload = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataPayload();
        payload.put("query","");
        payload.put("order_by","");
        payload.put("order","");
        payload.put("device_info","");

        return RestAPIUtil.performPostWithQueryParamWithoutScehma(url, headers,queryParam, payload);
    }
    public static Response productSearchAPIWithIncorrectQueryParam(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataPath()+partner_id+"/"+user_id;

        Map<String, String> headers = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page","kjdkjh");
        queryParam.put("limit","kjlkj");
        Map<String,Object> payload = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataPayload();


        return RestAPIUtil.performPostWithQueryParamWithoutScehma(url, headers,queryParam, payload);
    }
    public static Response productSearchAPIWithIncorrectDataType(TestData testData, String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataPath()+partner_id+"/"+user_id;

        Map<String, String> headers = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String,Object> queryParam= new HashMap<>();
        queryParam.put("page",1);
        queryParam.put("limit",50);
        Map<String,Object> payload = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataPayload();
        payload.put("query",1);
        payload.put("order_by",1.0);
        payload.put("order",1);
        payload.put("device_info",200);

        return RestAPIUtil.performPostWithQueryParamWithoutScehma(url, headers,queryParam, payload);
    }
}
