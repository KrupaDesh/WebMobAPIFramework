package com.rezolve.api.Profile.test;

import com.rezolve.api.APIBaseTest;

import com.rezolve.api.Profile.apiMethods.*;
import com.rezolve.api.Profile.model.ProfileNegativeData;
import engine.TestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.rezolve.api.Profile.model.TestDataArrangerAPI.*;

public class ProfileNegativeTest extends APIBaseTest {

    @Test(priority = 3,description = "Verify Get Public Key API with Incorrect Headers ",groups={"API_regression"})
    public void verifyGetPublicKeyWithIncorrectData() throws IOException {
        TestData testData = getPublicKeyAPIDataWithIncorrectData();
        Response response = GetPublicKeyAPI.getpublicKeyAPIwithIncorrectHeader(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getGetPublicKeyAPIErrorResponseWithIncorrectHeaders();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }
        @Test(priority = 3,description = "Verify Update Profile API with Incorrect Data",groups={"API_regression"})
        public void verifyUpdateProfileWithIncorrectData() throws IOException {
            TestData testData = updateProfileAPIDataWithIncorrectData();
            Response response = UpdateProfileAPI.updateprofileAPIWithIncorrectData(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 400);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getUpdateProfileAPIErrorResponseWithIncorrectData();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

        }

        @Test(priority = 4,description = "Verify Get Profile API with Incorrect Headers",groups={"API_regression"})
        public void verifyGetProfileWithIncorrectData() throws IOException {
            TestData testData = getProfileAPIDataWithIncorrectData();
            Response response = GetProfileAPI.getGetProfileAPIWithIncorrectHeaders(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 403);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getGetProfileAPIErrorResponseWithIncorrectHeaders();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

        }

        @Test(priority = 3,description = "Verify Add Phonebook API with Incorrect Data",groups={"API_regression"})
        //@Test(priority = 3,dependsOnMethods = "verifyLogin",description = "Verify Add Phonebook API",groups={"API_regression"})
        public void verifyAddPhonebookWithIncorrectData() throws IOException {
            TestData testData = addPhonebookAPIDataWithIncorrectData();
            Response response = AddPhonebookAPI.addPhonebookAPIWithIncorrectData(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 400);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getAddPhonebookAPIErrorResponseWithIncorrectData();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertTrue(List.of(errorRespone.get("altMessage").toString(),errorRespone.get("message").toString()).contains(errorMessage));

        }
    @Test(priority = 3,description = "Verify Add Phonebook API with Incorrect Headers",groups={"API_regression"})
     public void verifyAddPhonebookWithIncorrectHeaders() throws IOException {
        TestData testData = addPhonebookAPIDataWithIncorrectData();
        Response response = AddPhonebookAPI.addPhonebookAPIWithIncorrectHeaders(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getAddPhonebookAPIErrorResponseWithIncorrectHeaders();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }
        @Test(priority = 4,description = "Verify Get Phonebook API with Incorrect Headers",groups={"API_regression"})
        public void verifyGetPhonebookWithIncorrectHeaders() throws IOException {
            TestData testData = getPhonebookAPIDataWithIncorrectData();
            Response response = GetPhonebookAPI.getPhonebookAPIWithIncorrectHeaders(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 403);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getGetPhonebookAPIErrorResponseWithIncorrectHeaders();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");


        }
        @Test(priority = 5,description = "Verify Add Address API with Incorrect Data",groups={"AddressAPI","API_regression"})
        public void verifyAddAddressWithIncorrectData()  {
            TestData testData = addAddressAPIDataWithIncorrectData();
            Response response = AddAddressAPI.addAddressAPIWithIncorrectData(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 404);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getAddAddressAPIErrorResponseWithIncorrectPhone();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

        }
    @Test(priority = 5,description = "Verify Add Address API with Incorrect Headers",groups={"AddressAPI","API_regression"})
    public void verifyAddAddressWithIncorrectHeaders()  {
        TestData testData = addAddressAPIDataWithIncorrectData();
        Response response = AddAddressAPI.addAddressAPIWithIncorrectHeaders(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 403);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getAddAddressAPIErrorResponseWithIncorrectHeader();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }

        @Test(priority = 6,description = "Verify Get Address API with Incorrect Headers",groups={"API_regression"})
        public void verifyGetAddressWithIncorrectHeaders() throws IOException {
            TestData testData = getAddressAPIDataWithIncorrectData();
            Response response = GetAddressAPI.getAddressAPIWithIncorrectHeaders(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 403);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getGetAddressAPIErrorResponseWithIncorrectData();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

        }
        @Test(priority = 7,description = "Verify Delete Address API with Address added to credit card",groups={"API_regression"})
        public void verifyDelAddressWithIncorrectData()  {
            TestData testData = delAddressByIDAPIDataWithIncorrectData();
            Response response = DeleteAddressByIDAPI.delAddressAPIwithAddressAttachedToCard(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 400);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getDelAddressByIDAPIErrorResponseWithIncorrectData();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        }

        @Test(priority = 7,description = "Verify Delete Address API with Incorrect Headers",groups={"API_regression"})
        public void verifyDelAddressWithIncorrectHeaders()  {
            TestData testData = delAddressByIDAPIDataWithIncorrectData();
            Response response = DeleteAddressByIDAPI.delAddressAPIwithIncorrectHeaders(testData,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 403);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getDelAddressByIDAPIErrorResponseWithIncorrectHeader();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        }
        @Test(priority = 8,description = "Verify Update Phonebook API with Incorrect Headers",groups={"API_regression"})
        public void verifyUpdatePhonebookWithIncorrectHeaders() throws IOException {
            TestData testData = updatePhonebookAPIDataWithIncorrectData();
            Response response = UpdatePhonebookAPI.updatePhonebookAPIWithIncorrectHeaders(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 403);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIErrorResponseWithIncorrectHeaders();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        }
        @Test(priority = 8,description = "Verify Update Phonebook API with Incorrect Data",groups={"API_regression"})
        public void verifyUpdatePhonebookWithIncorrectData() {
            TestData testData = updatePhonebookAPIDataWithIncorrectData();
            Response response = UpdatePhonebookAPI.updatePhonebookAPIWithIncorrectData(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 400);
            JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getUpdatePhonebookAPIErrorResponseWithIncorrectData();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }
        @Test(priority = 8,description = "Verify Delete Phonebook API with Incorrect Data",groups={"API_regression"})
        public void verifyDelPhonebookWithIncorrectData()  {
            TestData testData = delPhonebookAPIDataWithIncorrectData();
            Response response = DeletePhonebookAPI.delPhonebookAPIWithIncorrectData(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 404);JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getDelPhonebookAPIErrorResponseWithIncorrectData();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        }

        @Test(priority = 8,description = "Verify Delete Phonebook API with Incorrect Headers",groups={"API_regression"})
        public void verifyDelPhonebookWithIncorrectHeaders() {
            TestData testData = delPhonebookAPIDataWithIncorrectData();
            Response response = DeletePhonebookAPI.delPhonebookAPIWithIncorrectHeaders(testData,token,user_id,partner_id);
            Assert.assertEquals(response.statusCode(), 403);JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
            Map<String,Object> errorRespone = testData.getTestData(ProfileNegativeData.class).getDelPhonebookAPIErrorResponseWithIncorrectHeaders();
            String errorType=responseJsonPath.getString("errors[0].type");
            String errorMessage = responseJsonPath.get("errors[0].message").toString();
            Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
            Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        }
 }


