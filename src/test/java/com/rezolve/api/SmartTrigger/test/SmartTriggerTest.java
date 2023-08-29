package com.rezolve.api.SmartTrigger.test;

import com.rezolve.api.APIBaseTest;
import com.rezolve.api.Core.apiMethods.LoginAPI;
import com.rezolve.api.Core.test.CoreAPITest;
import com.rezolve.api.SmartTrigger.apiMethods.*;
import engine.TestData;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.rezolve.api.SmartTrigger.model.TestDataArrangerAPI.*;
import static com.rezolve.api.TestDataArranger.getCommonLoginApiDataTest;


public class SmartTriggerTest extends APIBaseTest {

    @SneakyThrows

    @Test(description = "Verify Check In API",groups={"API_regression"})
    //@Test(priority = 1,description = "Verify Check In API",groups={"API_regression"})
    //@Test(priority = 1,dependsOnMethods = {"verifyLogin"},description = "Verify Check In API",groups={"API_regression"})
    public void verifyCheckIn() {
        TestData testData = checkInAPIData();
        Response response = CheckInAPI.checkInAPI(testData,token);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @SneakyThrows
    @Test(description = "Verify Tracking API",groups={"API_regression"})
    //@Test(priority = 1,dependsOnMethods = {"verifyLogin"},description = "Verify Tracking API",groups={"API_regression"})
    public void verifyTracking() {
        TestData testData = trackingAPIData();
        Response response = TrackingAPI.trackingAPI(testData,token);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @SneakyThrows
    @Test(description = "Verify Get Tags API",groups={"API_regression"})
    //@Test(priority = 1,dependsOnMethods = {"verifyLogin"},description = "Verify Get Tags API",groups={"API_regression"})
    public void verifyGetTags()  {
        TestData testData = getTagsAPIData();
        Response response = GetTagsAPI.getTagsAPI(testData,token);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @SneakyThrows
    //@Test(priority = 1,dependsOnMethods = {"verifyLogin"},description = "Verify Update Tags API",groups={"API_regression"})
    @Test(description = "Verify Update Tags API",groups={"API_regression"})
    public void verifyUpdateTags(){
        TestData testData = updateTagsAPIData();
        Response response = UpdateTagsAPI.updateTagsAPI(testData,token);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @SneakyThrows
    @Test(description = "Verify My Area API",groups={"API_regression"})
    //@Test(priority = 1,dependsOnMethods = {"verifyLogin"},description = "Verify My Area API",groups={"API_regression"})
    public void verifyMyArea() {
        TestData testData = myAreaAPIData();
        Response response = MyAreaAPI.myAreaAPI(testData,token);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @SneakyThrows
    @Test(description = "Verify Add Event API",groups={"API_regression"})
    //@Test(priority = 1,dependsOnMethods = {"verifyLogin"},description = "Verify Add Event API",groups={"API_regression"})
    public void verifyAddEvent() {
        TestData testData = addEventAPIData();
        Response response = AddEventAPI.addEventAPI(testData,token);
        Assert.assertEquals(response.statusCode(), 204);
    }
    @SneakyThrows
    @Test(description = "Verify Add Bulk Event API",groups={"API_regression"})
    //@Test(priority = 1,dependsOnMethods = {"verifyLogin"},description = "Verify Add Bulk Event API",groups={"API_regression"})
    public void verifyAddBulkEvent() {
        TestData testData = addBulkEventAPIData();
        Response response = AddBulkEventAPI.addBulkEventAPI(testData,token);
        Assert.assertEquals(response.statusCode(), 204);
    }
}
