package com.rezolve.api.RXP.test;


import com.rezolve.api.RCE.model.RCENegativeData;
import com.rezolve.api.RXP.apiMethods.*;
import com.rezolve.api.RXP.model.RXPNegativeData;
import engine.TestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static com.rezolve.api.RXP.model.TestDataArrangerAPI.*;

public class RXPAPINegativeTest {

    public static String  oauthToken,eng_id=null;

    @Test(priority = 1,  description = "Generate OAuth RXP", groups = {"API_regression"})
    public void generateOAuth()  {
        TestData testData = getOAuthAPIData();
        Response response = OAuthAPI.oAuthAPI(testData);
        Assert.assertEquals(response.statusCode(), 200);
        oauthToken = response.path("bearerToken");
    }

    @Test(priority = 1,  description = "Verify OAUth API", groups = {"API_regression"})
    public void generateOAuthWithoutAuthorization()  {
        TestData testData = getOAuthAPIWithIncorrectDataData();
        Response response = OAuthAPI.oAuthAPIWithoutAuth(testData);
        Assert.assertEquals(response.statusCode(), 500);
    }
    @Test(priority = 1,  description = "Verify OAUth API", groups = {"API_regression"})
    public void generateOAuthWithIncorrectData()  {
        TestData testData = getOAuthAPIWithIncorrectDataData();
        Response response = OAuthAPI.oAuthAPIWithIncorrectdata(testData);
        Assert.assertEquals(response.statusCode(), 500);
        String errorMessage = response.path("message");
        Map<String,Object> errorRespone = testData.getTestData(RXPNegativeData.class).getOAuthAPIWithIncorrectDataErrorResponse();

        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }
    @Test(priority = 2, dependsOnMethods = "generateOAuth", description = "Verify Get Geo Engagement API", groups = {"API_regression"})
    public void verifyGetGeoEngagementsWithoutAuthorization()  {
        TestData testData = getGetGeoEngagementsAPIWithIncorrectDataData();
        Response response = GetGeoEngagementsAPI.getGeoEngagementsAPIWithoutAuth(testData);
        Assert.assertEquals(response.statusCode(), 401);
    }
    @Test(priority = 2, dependsOnMethods = "generateOAuth", description = "Verify Get Geo Engagement API", groups = {"API_regression"})
    public void verifyGetGeoEngagementsWithMissingQueryParam()  {
        TestData testData = getGetGeoEngagementsAPIWithIncorrectDataData();
        Response response = GetGeoEngagementsAPI.getGeoEngagementsAPIWithMissingQueryParam(testData, oauthToken);
        Assert.assertEquals(response.statusCode(), 500);
        String errorMessage = response.path("message");
        Map<String,Object> errorRespone = testData.getTestData(RXPNegativeData.class).getGetGeoEngagementsAPIMissingQueryParamErrorResponse();
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }
    @Test(priority = 3, dependsOnMethods = "generateOAuth",  description = "Verify Get Engagement By ID API", groups = {"API_regression"})
    public void verifyGetEngagementsByIDWithoutAuthorization()  {
        TestData testData = getGetEngagementsByIDAPIWithIncorrectDataData();
        Response response = GetEngagementsByIDAPI.getEngagementByIDAPIWithoutAuth(testData);
        Assert.assertEquals(response.statusCode(), 401);
    }
    @Test(priority = 3, dependsOnMethods = "generateOAuth",  description = "Verify Get Engagement By ID API", groups = {"API_regression"})
    public void verifyGetEngagementsByIDWithNullEngID()  {
        TestData testData = getGetEngagementsByIDAPIWithIncorrectDataData();
        Response response = GetEngagementsByIDAPI.getEngagementByIDAPIWithNullEngID(testData,oauthToken);
        Assert.assertEquals(response.statusCode(), 400);
        String errorMessage = response.path("title");
        Map<String,Object> errorRespone = testData.getTestData(RXPNegativeData.class).getGetEngagementsByIdAPIWithNullEngIDErrorResponse();
        Assert.assertEquals(errorMessage, errorRespone.get("title").toString(), "Title mismatched");
    }
    @Test(priority = 3, dependsOnMethods = "generateOAuth",  description = "Verify Get Act By ID API", groups = {"API_regression"})
    public void verifyGetActByIDWithoutAuthorization()  {
        TestData testData = getGetActByIDAPIWithIncorrectDataData();
        Response response = GetActByIDAPI.getActByIDAPIWithoutAuth(testData);
        Assert.assertEquals(response.statusCode(), 401);
    }
    @Test(priority = 3, dependsOnMethods = "generateOAuth",  description = "Verify Get Act By ID API", groups = {"API_regression"})
    public void verifyGetActByIDWithNullActID()  {
        TestData testData = getGetActByIDAPIWithIncorrectDataData();
        Response response = GetActByIDAPI.getActByIDAPIWithNullActID(testData, oauthToken);
        Assert.assertEquals(response.statusCode(), 400);
        String errorMessage = response.path("actId[0]");
        Map<String,Object> errorRespone = testData.getTestData(RXPNegativeData.class).getGetActByIdAPINullActIDErrorResponse();
        ArrayList<String> actIds = (ArrayList<String>) errorRespone.get("actId");
        Assert.assertEquals(errorMessage, actIds.get(0), "Message Content mismatched");
    }
    @Test(priority = 3, dependsOnMethods = "generateOAuth",  description = "Verify Search Engagement API", groups = {"API_regression"})
    public void verifySearchEngagementWithoutAuthorization()  {
        TestData testData = getSearchEngagementAPIWithIncorrectDataData();
        Response response = SearchEngagementAPI.searchEngagementAPIWithoutAuth(testData);
        Assert.assertEquals(response.statusCode(), 401);
    }
    @Test(priority = 3, dependsOnMethods = "generateOAuth",  description = "Verify Search Engagement API", groups = {"API_regression"})
    public void verifySearchEngagementWithIncorrectdata()  {
        TestData testData = getSearchEngagementAPIWithIncorrectDataData();
        Response response = SearchEngagementAPI.searchEngagementAPIWithIncorrectdata(testData, oauthToken);
        Assert.assertEquals(response.statusCode(), 400);
        String errorMessage = response.path("offset[0]");
        Map<String,Object> errorRespone = testData.getTestData(RXPNegativeData.class).getSearchEngagementAPIWithIncorrectDataErrorResponse();
        ArrayList<String> offsets = (ArrayList<String>) errorRespone.get("offset");
        Assert.assertEquals(errorMessage, offsets.get(0), "Message Content mismatched");

    }

}