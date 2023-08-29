package com.rezolve.api.SmartTrigger.test;

import com.rezolve.api.APIBaseTest;
import com.rezolve.api.Core.model.CoreNegativeData;
import com.rezolve.api.SmartTrigger.apiMethods.*;
import com.rezolve.api.SmartTrigger.model.SmartTriggersNegativeData;
import engine.TestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

import static com.rezolve.api.SmartTrigger.model.TestDataArrangerAPI.*;


public class SmartTriggerNegativeTest extends APIBaseTest {

    @SneakyThrows

    @Test(description = "Verify Check In API without auth token",groups={"API_regression"})
    public void verifyCheckInWithoutAuthToken() {
        TestData testData = checkInAPIDataWithIncorrectData();
        Response response = CheckInAPI.checkInAPIWithoutAuth(testData);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithoutAuthErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String attributeName = responseJsonPath.get("errors[0].attributeName").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(attributeName, errorRespone.get("attributeName").toString(), "AttributeName mismatched");

    }
    @Test(description = "Verify Check In API with invalid auth",groups={"API_regression"})
    public void verifyCheckInWithInvalidAuth() {
        TestData testData = checkInAPIDataWithIncorrectData();
        Response response = CheckInAPI.checkInAPIInvalidAuth(testData);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIInvalidAuthErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String attributeName = responseJsonPath.get("errors[0].attributeName").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(attributeName, errorRespone.get("attributeName").toString(), "AttributeName mismatched");

    }
    @Test(description = "Verify Check In API with black values for attributes",groups={"API_regression"})
    public void verifyCheckInWithEmptyData() {
        TestData testData = checkInAPIDataWithIncorrectData();
        Response response = CheckInAPI.checkInAPIWithEmptyData(testData,token);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getCheckInAPIWithEmptyDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(constraintType, errorRespone.get("constraintType").toString(), "ConstraintType mismatched");
    // to put validation for Attribute name with contains method in loop
    }

    @Test(description = "Verify Tracking API",groups={"API_regression"})
    public void verifyTrackingWithoutAuth() {
        TestData testData = trackingAPIDataWithIncorrectData();
        Response response = TrackingAPI.trackingAPIWithoutAuth(testData);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getTrackingAPIWithoutAuthErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(constraintType, errorRespone.get("constraintType").toString(), "ConstraintType mismatched");
    }
    @Test(description = "Verify Tracking API",groups={"API_regression"})
    public void verifyTrackingWithEmptyData() {
        TestData testData = trackingAPIDataWithIncorrectData();
        Response response = TrackingAPI.trackingAPIWithEmptyData(testData, token);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getTrackingAPIWithEmptyDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(constraintType, errorRespone.get("constraintType").toString(), "ConstraintType mismatched");
    }

    @Test(description = "Verify Get Tags API without Auth token",groups={"API_regression"})
    public void verifyGetTagsWithoutAuth()  {
        TestData testData = getTagsAPIDataWithIncorrectData();
        Response response = GetTagsAPI.getTagsAPIWithoutAuth(testData);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getGetTagsAPIWithoutAuthErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String attributeName = responseJsonPath.get("errors[0].attributeName").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(attributeName, errorRespone.get("attributeName").toString(), "AttributeName mismatched");
    }
    @Test(description = "Verify Get Tags API with Invalid Auth token",groups={"API_regression"})
    public void verifyGetTagsWithInvalidAuth()  {
        TestData testData = getTagsAPIDataWithIncorrectData();
        Response response = GetTagsAPI.getTagsAPIWithInvalidAuth(testData);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getGetTagsAPIWithInvalidAuthErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(constraintType, errorRespone.get("constraintType").toString(), "ConstraintType mismatched");
    }

   @Test(description = "Verify Update Tags API with Blank values for attribute",groups={"API_regression"})
    public void verifyUpdateTagsWithEmptyData(){
        TestData testData = updateTagsAPIDataWithIncorrectData();
        Response response = UpdateTagsAPI.updateTagsAPIWithEmptyData(testData,token);
       Assert.assertEquals(response.statusCode(), 400);
       JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
       Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getUpdateTagsAPIWithEmptyDataErrorResponse();
       String errorType=responseJsonPath.getString("errors[0].type");
       String errorMessage = responseJsonPath.get("errors[0].message").toString();
       String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
       Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
       //Below to assertions are checking against 2 values for each message
       Assert.assertTrue(errorRespone.get("message").toString().contains(errorMessage), "Message Content mismatched");
       Assert.assertTrue(errorRespone.get("constraintType").toString().contains(constraintType), "ConstraintType mismatched");
   }
     @Test(description = "Verify My Area API withou Query Param",groups={"API_regression"})
     public void verifyMyAreaWithoutQueryParam() {
        TestData testData = myAreaAPIDataWithIncorrectData();
        Response response = MyAreaAPI.myAreaAPIwithoutQueryParam(testData,token);
         Assert.assertEquals(response.statusCode(), 400);
         JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
         Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getMyAreaAPIWithoutQueryParamErrorResponse();
         String errorType=responseJsonPath.getString("errors[0].type");
         String errorMessage = responseJsonPath.get("errors[0].message").toString();
         String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
         Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
         Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
         Assert.assertEquals(constraintType, errorRespone.get("constraintType").toString(), "ConstraintType mismatched");
     }

    @Test(description = "Verify Add Event API with Empty Request Body",groups={"API_regression"})
     public void verifyAddEventWithEmptyBody() {
        TestData testData = addEventAPIDataWithIncorrectData();
        Response response = AddEventAPI.addEventAPIWithEmptyBody(testData,token);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getAddEventAPIWithEmptyBodyErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(constraintType, errorRespone.get("constraintType").toString(), "ConstraintType mismatched");
    }

    @Test(description = "Verify Add Event API with attribute values as Null",groups={"API_regression"})
    public void verifyAddEventWithNulldata() {
        TestData testData = addEventAPIDataWithIncorrectData();
        Response response = AddEventAPI.addEventAPIWithNullData(testData,token);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getAddEventAPIWithNullDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(constraintType, errorRespone.get("constraintType").toString(), "ConstraintType mismatched");
    }
    @Test(description = "Verify Add Bulk Event API with Empty body",groups={"API_regression"})
    public void verifyAddBulkEventWithEmptyBody() {
        TestData testData = addBulkEventAPIDataWithIncorrectData();
        Response response = AddBulkEventAPI.addBulkEventAPIWithEmptyBody(testData,token);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getAddBulkEventAPIWithEmptyBodyErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(constraintType, errorRespone.get("constraintType").toString(), "ConstraintType mismatched");
    }
    @Test(description = "Verify Add Bulk Event API with attribute values as Null",groups={"API_regression"})
    public void verifyAddBulkEventWithNullData() {
        TestData testData = addBulkEventAPIDataWithIncorrectData();
        Response response = AddBulkEventAPI.addBulkEventAPIWithNullData(testData,token);
        Assert.assertEquals(response.statusCode(), 400);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(SmartTriggersNegativeData.class).getAddBulkEventAPIWithNullDataErrorResponse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        String constraintType = responseJsonPath.get("errors[0].constraintType").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertEquals(constraintType, errorRespone.get("constraintType").toString(), "ConstraintType mismatched");
    }
}
