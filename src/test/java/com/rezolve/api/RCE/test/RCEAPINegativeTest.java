package com.rezolve.api.RCE.test;


import com.rezolve.api.APIBaseTest;
import com.rezolve.api.RCE.apiMethods.InstantBuy.*;
import com.rezolve.api.RCE.model.RCENegativeData;
import com.rezolve.api.Search.test.SearchAPITest;
import engine.TestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static com.rezolve.api.RCE.model.TestDataArrangerAPI.*;

public class RCEAPINegativeTest extends APIBaseTest {
    public static String merchant_id, category_id,address_id_forCard,phone_id_forcard,card_id,updated_card_id,public_key,phone_id ;
    public static String option_id,checkout_id,shipping_type,payment_type;
    public static Integer product_id;


    @Test(priority = 3, description = "Verify Get Merchant List API with Incorrect headers", groups = {"API_regression"})
    public void verifyGeterchantList()  {
        TestData testData = getMerchantListApiWithIncorrectData();
        Response response = GetMerchantListAPI.getMerchantListAPIWithIncorrectHeaders(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetMerchantsListAPIWithIncorrectHeaderErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");


    }
    @Test(priority = 3,description = "Verify Get Merchnat API with null Merchant ID",groups={"API_regression"})
    public void verifyGetMerchantWithNullMerchatID() {
        TestData testData = getMerchantApiWithIncorrectData();
        Response response = GetMerchantAPI.getMerchantAPIWithNullMerchantID(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetMerchantsAPIWithNullMerchantIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 3,description = "Verify Get Merchnat API with Incorrect Headers",groups={"API_regression"})
    public void verifyGetMerchantWithIncorrectHeaders() {
        TestData testData = getMerchantApiWithIncorrectData();
        Response response = GetMerchantAPI.getMerchantAPIWithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetMerchantsAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }

   @Test(priority = 3,description = "Verify Get Categories And Products for the merchant API with Null merchant ID",groups={"API_regression"})
    public void verifyGetCategoriesAndProductsForTheMerchant()  {
        TestData testData = getCategoriesAndProductsForThemerchantApiWithIncorrectData();
        Response response = GetCategoriesAndProductsForTheMerchantAPI.getCategoriesAndProductsForTheMerchantAPIWithNullMerchantID(testData,token,user_id,partner_id);
       Assert.assertEquals(response.statusCode(), 404);
       JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
       Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetCategoriesAndProductsForThemerchantAPINullMerchantIDErrorResponse();
       String errorType=responseJsonPath.getString("errors[0].type");
       String errorMessage = responseJsonPath.get("errors[0].message").toString();
       Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
       Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

   }
    @Test(priority = 3,description = "Verify Get Categories And Products for the merchant API with incorrect headers",groups={"API_regression"})
    public void verifyGetCategoriesAndProductsForTheMerchantWithIncorrectHeaders()  {
        TestData testData = getCategoriesAndProductsForThemerchantApiWithIncorrectData();
        Response response = GetCategoriesAndProductsForTheMerchantAPI.getCategoriesAndProductsForTheMerchantAPIWithIncorrectHeaders(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetCategoriesAndProductsForThemerchantAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }
    @Test(priority = 3,description = "Verify Get Categories API With Null Merchant ID",groups={"API_regression"})
    public void verifyGetCategoriesWithNullMerchantID()  {
        TestData testData = getCategoriesApiWithIncorrectData();
        Response response = GetCategoriesAPI.getCategoriesAPIWithNullMerchantID(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetCategoriesAPINullMerchantIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 3,description = "Verify Get Categories API With Null Category ID",groups={"API_regression"})
    public void verifyGetCategoriesWithNullCategoryID()  {
        TestData testData = getCategoriesApiWithIncorrectData();
        Response response = GetCategoriesAPI.getCategoriesAPIWithNullCategoryID(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetCategoriesAPINullCategoryIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 3,description = "Verify Get Categories API With Incorrect Headers",groups={"API_regression"})
    public void verifyGetCategoriesWithIncorrectHeaders()  {
        TestData testData = getCategoriesApiWithIncorrectData();
        Response response = GetCategoriesAPI.getCategoriesAPIWithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetCategoriesAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 4,description = "Verify Get Products Within Category API with incorrect headers",groups={"API_regression"})
    public void verifyGetProductsWithinCategoryWithIncorrectHeaders() {
        TestData testData = getProductsWithinCategoryApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        category_id = RCEAPITest.category_id;
        Response response = GetProductsWithinCategory.getProductsWithinCategoryAPIWithIncorrectHeaders(testData,token,user_id,partner_id,merchant_id,category_id);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();

        Assert.assertEquals(response.statusCode(), 403);
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetProductsWithinCategoryAPIWithIncorrectHeadersErrorResponse();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 4,description = "Verify Get Products Within Category API with Null merchant id",groups={"API_regression"})
    public void verifyGetProductsWithinCategoryWithNullMerchantId() {
        TestData testData = getProductsWithinCategoryApiWithIncorrectData();
        category_id = RCEAPITest.category_id;
        Response response = GetProductsWithinCategory.getProductsWithinCategoryAPIWithNullMerchantID(testData,token,user_id,partner_id,category_id);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(response.statusCode(), 404);
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetProductsWithinCategoryAPINullMerchantIDErrorResponse();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 4,description = "Verify Get Product API with Null Category ID",groups={"API_regression"})
    public void verifyGetProductWithNullCategoryID()  {
        TestData testData = getProductApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        product_id=RCEAPITest.product_id;
        Response response = GetProductAPI.getProductAPIwithNullCategoryID(testData,token,user_id,partner_id,merchant_id,product_id);
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetProductAPINullCategoryIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }
    @Test(priority = 4,description = "Verify Get Product API with Null Merchant ID",groups={"API_regression"})
    public void verifyGetProductWithNullMerchantID()  {
        TestData testData = getProductApiWithIncorrectData();
        category_id= RCEAPITest.category_id;
        product_id=RCEAPITest.product_id;
        Response response = GetProductAPI.getProductAPIwithNullMerchantID(testData,token,user_id,partner_id,category_id,product_id);
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetProductAPINullMerchantIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }
    @Test(priority = 4,description = "Verify Get Product API with Incorrect Headers",groups={"API_regression"})
    public void verifyGetProductWithIncorrectHeaders()  {
        TestData testData = getProductApiWithIncorrectData();
        Response response = GetProductAPI.getProductAPIwithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetProductAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }

    @Test(priority = 4,description = "Verify Add To Cart API With Incorrect Headers",groups={"API_regression"})
    public void verifyAddToCartWithIncorrectHeaders()  {
        TestData testData = AddtoCartApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = AddToCartAPI.addToCartAPIWithIncorrectHeaders(testData,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 4,description = "Verify Add To Cart API With Empty Data",groups={"API_regression"})
    public void verifyAddToCartWithEmptyData()  {
        TestData testData = AddtoCartApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = AddToCartAPI.addToCartAPIWithEmptyData(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithEmptyDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 4,description = "Verify Add To Cart API With Null Data",groups={"API_regression"})
    public void verifyAddToCartWithNullData()  {
        TestData testData = AddtoCartApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = AddToCartAPI.addToCartAPIWithNullData(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getAddtoCartAPIWithNullDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 5,description = "Verify Get Cart API with Incorrect Headers",groups={"API_regression"})
    public void verifyGetCartWithIncorrectHeaders()  {
        TestData testData = getCartAPIWithIncorrectData();
        Response response = GetCartAPI.getCartAPIWithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetCartAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }

    @Test(priority = 8,description = "Verify Option Call API With Empty Data",groups={"API_regression"})
    public void verifyOptionCallWithEmptyData()  {
        TestData testData = OptionCallApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = OptionCallAPI.optionCallAPIWithEmptyData(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithEmptyDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 8,description = "Verify Option Call API  With Null Data",groups={"API_regression"})
    public void verifyOptionCallWithNullData()  {
        TestData testData = OptionCallApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = OptionCallAPI.optionCallAPIWithNullData(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithNullDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 8,description = "Verify Option Call API With Qty above Max Limit",groups={"API_regression"})
    public void verifyOptionCallWithMaxQty()  {
        TestData testData = OptionCallApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = OptionCallAPI.optionCallAPIWithMaxQty(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithMaxQtyErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 8,description = "Verify Option Call API",groups={"API_regression"})
    public void verifyOptionCallWithInvalidProductID()  {
        TestData testData = OptionCallApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = OptionCallAPI.optionCallAPIWithInvalidID(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithInvalidIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 8,description = "Verify Option Call API",groups={"API_regression"})
    public void verifyOptionCallWithIncorrectHeaders()  {
        TestData testData = OptionCallApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = OptionCallAPI.optionCallAPIWithIncorrectHeaders(testData,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getOptionCallAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 9,description = "Verify Checkout Call API",groups={"API_regression"})
    public void verifyCheckoutCallWithIcorrectHeaders()  {
        TestData testData = CheckoutCallApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = CheckoutCallApi.checkoutCallApiWithIncorrectHeaders(testData,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 9,description = "Verify Checkout Call API With Invalid OptionID",groups={"API_regression"})
    public void verifyCheckoutCallWithInvalidOptionID()  {
        TestData testData = CheckoutCallApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = CheckoutCallApi.checkoutCallApiWithInvalidOptionID(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithInvalidOptionIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 9,description = "Verify Checkout Call API With Empty Data",groups={"API_regression"})
    public void verifyCheckoutCallWithEmptyData()  {
        TestData testData = CheckoutCallApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = CheckoutCallApi.checkoutCallApiWithEmptyData(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithEmptyDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 9,description = "Verify Checkout Call API  With Null Data",groups={"API_regression"})
    public void verifyCheckoutCallWithNullData()  {
        TestData testData = CheckoutCallApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = CheckoutCallApi.checkoutCallApiWithNullData(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithNullDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }

    @Test(priority = 10,description = "Verify Buy order API with Sp payment With Incorrect Headers",groups={"API_regression"})
    public void verifyBuySPWithIncorrectHeaders()  {
        TestData testData = BuyApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = BuySPAPI.buySPApiWithIncorrectHeaders(testData,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getBuyAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 10,description = "Verify Buy order API with Sp payment With Invalid OptionID",groups={"API_regression"})
    public void verifyBuySPWithInvalidOptionID()  {
        TestData testData = BuyApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = BuySPAPI.buySPApiWithInvalidOptionID(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getBuyAPIWithInvalidOptionIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 10,description = "Verify Buy order API with Sp payment With Empty Data",groups={"API_regression"})
    public void verifyBuySPWithEmptyData()  {
        TestData testData = BuyApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = BuySPAPI.buySPApiWithEmptyData(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getBuyAPIWithEmptyDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 10,description = "Verify Buy order API with Sp payment with Invalid Payment Method",groups={"API_regression"})
    public void verifyBuySPWithInvalidPaymentMethod()  {
        TestData testData = BuyApiWithIncorrectData();
        merchant_id= SearchAPITest.merchant_id;
        Response response = BuySPAPI.buySPApiWithInvalidPaymentMethod(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getBuyAPIWithInvalidPaymentMethodErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 11,description = "Verify Get order API with Incorrect headers",groups={"API_regression"})
    public void verifyGetOrdersWithIncorrectHeaders()  {
        TestData testData = getOrdersApiWithIncorrectData();
        Response response = GetOrdersAPI.getOrdersAPIWithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetOrdersAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }
    @Test(priority = 11,description = "Verify Get order API with Incorrect dates",groups={"API_regression"})
    public void verifyGetOrdersWithIncorrectDates()  {
        TestData testData = getOrdersApiWithIncorrectData();
        Response response = GetOrdersAPI.getOrdersAPIWithIncorrectDates(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetOrdersAPIWithIncorrectDateErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }

    @Test(priority = 12,description = "Verify Get order by ID API with Incorrect Headers",groups={"API_regression"})
    public void verifyGetOrderByIDWithIncorrectHeaders()  {
        TestData testData = getOrderByIDAPIWithIncorrectData();
        Response response = GetOrderByID.getOrderByIdAPIWithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 404);
        /*JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetOrderByIDAPIWithIncorrecHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
*/
    }
    @Test(priority = 12,description = "Verify Get order by ID API with Incorrect Order ID",groups={"API_regression"})
    public void verifyGetOrderByIDWithIncorrectOrderID()  {
        TestData testData = getOrderByIDAPIWithIncorrectData();
        Response response = GetOrderByID.getOrderByIdAPIWithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 404);
        /*JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetOrderByIDAPIWithIncorrectOrederIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
*/
    }
    @Test(priority = 7,description = "Verify Add Card API With Incorrect Headers",groups={"API_regression"})
    public void verifyAddCardWithIncorrectHeaders()  {
        TestData testData = addCardAPIWithIncorrectData();
        Response response = AddCardAPI.addCardAPIWithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getAddCardAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
   }
    @Test(priority = 7,description = "Verify Add Card API With Empty Request Body",groups={"API_regression"})
    public void verifyAddCardWithEmptyData()  {
        TestData testData = addCardAPIWithIncorrectData();
        Response response = AddCardAPI.addCardAPIWithEmptyData(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getAddCardAPIWithEmptyDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 7,description = "Verify Add Card API with Null values for all data",groups={"API_regression"})
    public void verifyAddCardWithNullData()  {
        TestData testData = addCardAPIWithIncorrectData();
        Response response = AddCardAPI.addCardAPIWithNullData(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getAddCardAPIWithNullDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 7,description = "Verify Update Card API With Incorrect Headers",groups={"API_regression"})
    public void verifyUpdateCardWithIncorrectHeaders()  {
        TestData testData = updateCardAPIWithIncorrectData();
        Response response = UpdateCard.updateCardAPIWithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 7,description = "Verify Update Card API With Empty Request Body",groups={"API_regression"})
    public void verifyUpdateCardWithEmptyData()  {
        TestData testData = updateCardAPIWithIncorrectData();
        Response response = UpdateCard.updateCardAPIWithEmptyData(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithEmptyDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 8,description = "Verify Update Card API with Null values for all data",groups={"API_regression"})
    public void verifyUpdateCardWithNullData()  {
        TestData testData = updateCardAPIWithIncorrectData();
        card_id=RCEAPITest.card_id;
        Response response = UpdateCard.updateCardAPIWithNullData(testData,token,user_id,partner_id,card_id);
        Assert.assertEquals(response.statusCode(), 404);
        /*JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getUpdateCardAPIWithNullDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    */}
    @Test(priority = 7,description = "Verify Delete Card API With Incorrect Headers",groups={"API_regression"})
    public void verifyDeleteCardWithIncorrectHeaders()  {
        TestData testData = deleteCardAPIWithIncorrectData();
        Response response = DeleteCard.deleteCardAPIWithIncorrectHeaders(testData,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getDeleteCardAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
    @Test(priority = 7,description = "Verify Delete Card API With Deleted Card ID",groups={"API_regression"})
    public void verifyDeleteCardWithDeletedCardID()  {
        TestData testData = deleteCardAPIWithIncorrectData();
        Response response = DeleteCard.deleteCardAPIWithDeletedcardID(testData,token, user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getDeleteCardAPIWithDeletedCardIDErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }

    @Test(priority = 9,description = "Verify wallet API With Incorrect data", groups = {"API_regression"})
    public void verifyGetWalletApiWithIncorrectData(){
        TestData testData = getWalletApiWithIncorrectData();
        Response response=GetWallet.getWalletAPIWithIncorrectHeaders(testData, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(RCENegativeData.class).getGetWalletAPIWithIncorrectHeadersErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
}