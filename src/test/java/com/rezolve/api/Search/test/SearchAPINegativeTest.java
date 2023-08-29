package com.rezolve.api.Search.test;


import com.rezolve.api.APIBaseTest;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import com.rezolve.api.Search.apiMethods.MerchantSearchAPI;
import com.rezolve.api.Search.apiMethods.ProductSearchAPI;
import com.rezolve.api.Search.model.SearchNegativeData;
import engine.TestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

import static com.rezolve.api.Search.model.TestDataArrangerAPI.*;


public class SearchAPINegativeTest extends APIBaseTest {
    public static String merchant_id = null;

    @Test(priority = 2,  description = "Verify Merchant Search API by removing mandatory param", groups = {"API_regression"})
    public void verifyMerchantSearchRemovingMandatoryParam()  {
        TestData testData = getMerchantSearchApiWithIncorrectData();
        Response response = MerchantSearchAPI.merchantSearchAPIRemovingMandatoryParam(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithRemoveMadatoryParamErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 2,  description = "Verify Merchant Search API With Empty Data for Mandatory Param", groups = {"API_regression"})
    public void verifyMerchantSearchWithEmptyData() throws IOException {
        TestData testData = getMerchantSearchApiWithIncorrectData();
        Response response = MerchantSearchAPI.merchantSearchAPIWithEmptyDataForMadatoryParam(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithEmptyDataForMandateParamErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }


    @Test(priority = 2,  description = "Verify Merchant Search API With Incorrect Query Param", groups = {"API_regression"})
    public void verifyMerchantSearchIncorrectQueryParam()  {
        TestData testData = getMerchantSearchApiWithIncorrectData();
        Response response = MerchantSearchAPI.merchantSearchAPIWithIncorrectQueryParam(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectQueryParamErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 2,  description = "Verify Merchant Search API With Incorrect Data Type", groups = {"API_regression"})
    public void verifyMerchantSearchIncorrectDataType() throws IOException {
        TestData testData = getMerchantSearchApiWithIncorrectData();
        Response response = MerchantSearchAPI.merchantSearchAPIWithIncorrectDataType(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SearchNegativeData.class).getMerchantSearchAPIWithIncorrectDataTypeErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 2,  description = "Verify Merchant Search API by removing mandatory param", groups = {"API_regression"})
    public void verifyProductSearchRemovingMandatoryParam()  {
        TestData testData = getProductSearchApiWithIncorrectData();
        Response response = ProductSearchAPI.productSearchAPIRemovingMandatoryParam(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithRemoveMadatoryParamErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 2,  description = "Verify Product Search API With Empty Data for Mandatory Param", groups = {"API_regression"})
    public void verifyProductSearchWithEmptyData() throws IOException {
        TestData testData = getProductSearchApiWithIncorrectData();
        Response response = ProductSearchAPI.productSearchAPIWithEmptyDataForMadatoryParam(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithEmptyDataForMandateParamErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }


    @Test(priority = 2,  description = "Verify Product Search API With Incorrect Query Param", groups = {"API_regression"})
    public void verifyProductSearchIncorrectQueryParam()  {
        TestData testData = getProductSearchApiWithIncorrectData();
        Response response = ProductSearchAPI.productSearchAPIWithIncorrectQueryParam(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectQueryParamErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 2,  description = "Verify Product Search API With Incorrect Data Type", groups = {"API_regression"})
    public void verifyProductSearchIncorrectDataType() throws IOException {
        TestData testData = getProductSearchApiWithIncorrectData();
        Response response = ProductSearchAPI.productSearchAPIWithIncorrectDataType(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SearchNegativeData.class).getProductSearchAPIWithIncorrectDataTypeErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }

}