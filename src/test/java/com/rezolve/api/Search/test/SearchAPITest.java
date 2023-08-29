package com.rezolve.api.Search.test;


import com.rezolve.api.APIBaseTest;
import com.rezolve.api.Core.test.CoreAPITest;
import com.rezolve.api.Search.apiMethods.MerchantSearchAPI;
import com.rezolve.api.Search.apiMethods.ProductSearchAPI;
import engine.TestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

import static com.rezolve.api.Search.model.TestDataArrangerAPI.*;

public class SearchAPITest extends APIBaseTest {
    public static String merchant_id = null;


    //@Test(priority = 2, dependsOnMethods = {"verifyLogin"}, description = "Verify Merchant Search API", groups = {"API_regression"})
    @Test(priority = 2,  description = "Verify Merchant Search API", groups = {"API_regression"})
    public void verifyMerchantSearch() throws IOException {
        TestData testData = getMerchantSearchApiData();
        Response response = MerchantSearchAPI.merchantSearchAPI(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 200);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        //String consent = responseJsonPath.getString("results[0].fields.consent");
        //merchant_id=responseJsonPath.getString("merchants[21].id");
        merchant_id= "177";//177 for spgateway payment
    }
    //@Test(priority = 2,dependsOnMethods = {"verifyLogin"},description = "Verify Product Search API",groups={"API_regression"})
    @Test(priority = 2,description = "Verify Product Search API",groups={"API_regression"})
    public void verifyProductSearch() throws IOException {
        TestData testData = getProductSearchApiData();
        Response response = ProductSearchAPI.productSearchAPI(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 200);
    }

}