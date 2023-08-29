package com.rezolve.api.RXP.test;


import com.rezolve.api.RXP.apiMethods.*;
import engine.TestData;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import static com.rezolve.api.RXP.model.TestDataArrangerAPI.*;

public class RXPAPITest {

    public static String  oauthToken,eng_id=null;

    @Test(priority = 1,  description = "Verify OAUth API", groups = {"API_regression"})
    public void verifyOAuth()  {
        TestData testData = getOAuthAPIData();
        Response response = OAuthAPI.oAuthAPI(testData);
        Assert.assertEquals(response.statusCode(), 200);
        oauthToken = response.path("bearerToken");
    }
    @Test(priority = 2, dependsOnMethods = "verifyOAuth", description = "Verify Get Geo Engagement API", groups = {"API_regression"})
    public void verifyGetGeoEngagements()  {
        TestData testData = getGetGeoEngagementsAPIData();
        Response response = GetGeoEngagementsAPI.getGeoEngagementsAPI(testData, oauthToken);
        Assert.assertEquals(response.statusCode(), 200);
        eng_id= response.path("engagements.data[0].id").toString();
    }
    @Test(priority = 3, dependsOnMethods = "verifyOAuth",  description = "Verify Get Engagement By ID API", groups = {"API_regression"})
    public void verifyGetEngagementsByID()  {
        TestData testData = getGetEngagementsByIDAPIData();
        Response response = GetEngagementsByIDAPI.getEngagementByIDAPI(testData, oauthToken, eng_id);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 3, dependsOnMethods = "verifyOAuth",  description = "Verify Get Act By ID API", groups = {"API_regression"})
    public void verifyGetActByID()  {
        TestData testData = getGetActByIDAPIData();
        Response response = GetActByIDAPI.getActByIDAPI(testData, oauthToken);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 3, dependsOnMethods = "verifyOAuth",  description = "Verify Search Engagement API", groups = {"API_regression"})
    public void verifySearchEngagement()  {
        TestData testData = getSearchEngagementAPIData();
        Response response = SearchEngagementAPI.searchEngagementAPI(testData, oauthToken);
        Assert.assertEquals(response.statusCode(), 200);
    }

}