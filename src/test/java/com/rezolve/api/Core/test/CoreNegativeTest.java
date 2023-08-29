package com.rezolve.api.Core.test;

import com.rezolve.api.Core.apiMethods.*;
import com.rezolve.api.Core.model.CoreNegativeData;
import engine.TestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.rezolve.api.Core.model.TestDataArrangerAPI.*;

public class CoreNegativeTest{

    public static String regToken =null;
    public static String  regUser_id=null;
    public static String regPartner_id = null;
    public static String registeredUserName, guestUserName=null;
    public static int registeredId;

    @Test(priority = 1,description = "Verify Login API with incorrect username password", groups="API_regression")
    public void verifyIncorrectLogin() throws IOException {

        TestData testData = getLoginAPIWithIncorrectData();
        Response response = LoginAPI.postLoginAPIIncorrectData(testData);// API method
        //Assertions
        Assert.assertEquals(response.statusCode(), 401);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getLoginAPIErrorRespone();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");

    }
    @Test(priority = 1,description = "Verify Login API with Incorrect header", groups="API_regression")
    public void verifyLoginwithIncorrectHeaders() throws IOException {

        TestData testData = getLoginAPIWithIncorrectData();
        Response response = LoginAPI.postLoginAPIIncorrectHeaders(testData);// API method
        //Assertions
        Assert.assertEquals(response.statusCode(), 500);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.getString("errors[0].message");

        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getLoginAPIErrorResponseWithIncorrectHeaders();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }

    @Test(priority = 2, description = "Verify Register v2 API with Incorrect data",groups="API_regression")
    public void verifyRegisterv2withIncorrectData() throws IOException {
        //System.out.println("Core > Token:"+token+" User id:"+user_id+"PartnerID:" +partner_id);
        TestData testData = getRegisterV2ApiWithIncorrectData();
        Response response= RegisterV2API.verifyRegisterv2APIwithIncorrectData(testData);
        Assert.assertEquals(response.statusCode(), 422);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getRegisterV2ErrorResposnse();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }

    @Test(priority = 2, description = "Verify Register v2 API with Incorrect headers",groups="API_regression")
    public void verifyRegisterv2withIncorrectHeaders() throws IOException {
        //System.out.println("Core > Token:"+token+" User id:"+user_id+"PartnerID:" +partner_id);
        TestData testData = getRegisterV2ApiWithIncorrectData();
        Response response= RegisterV2API.verifyRegisterv2APIwithIncorrectHeaders(testData);
        Assert.assertEquals(response.statusCode(), 500);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getRegisterV2ErrorResposnseWithIncorrectHeaders();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }

    @Test(priority = 4, description = "Verify ConfirmNumber API with Incorrect Data",groups="API_regression_R")
    public void verifyConfirmNumberWithIncorrectData() throws IOException {
        TestData testData = getConfirmNumberApiwithIncorrectData();
        Response response = ConfirmNumberAPI.getConfirmNumberAPIwithIncorrectUrl(testData);
        Assert.assertEquals(response.statusCode(), 400);

    }

    @Test(priority = 2,description = "Verify Guest Register API with Incorrect Headers",groups={"API_regression","Guest_API"})
    public void verifyGuestRegisterwithIncorrectHeaders() throws IOException {
        TestData testData = getGuestRegisterApiWithIncorrectData();
        Response response = GuestRegisterAPI.verifyGuestRegisterAPIwithIncorrectHeaders(testData);
        Assert.assertEquals(response.statusCode(), 500);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getGuestRegisterErrorResponseWithIncorrectData();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        //Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertTrue(List.of(errorRespone.get("altMessage").toString(),errorRespone.get("message").toString()).contains(errorMessage));
    }



    @Test(priority = 3,description = "Verify Guest Login API with Incorrect Headers",groups={"API_regression","Guest_API"})
    public void verifyGuestLoginwithIncorrectHeaders() throws IOException {
        TestData testData = getGuestLoginApiWithIncorrectData();
        guestUserName = CoreAPITest.guestUserName;
        Response response = GuestLoginAPI.verifyGuestLoginAPIwithIncorrectData(testData,guestUserName );
        Assert.assertEquals(response.statusCode(), 500);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getGuestLoginApiErrorResponseWithIncorrectHeader();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        //Assert.assertEquals(errorMessage, errorRespone.get("altMessage").toString(), "Message Content mismatched");
        Assert.assertTrue(List.of(errorRespone.get("altMessage").toString(),errorRespone.get("message").toString()).contains(errorMessage));

    }
    @Test(priority = 4,description = "Verify Forgot password API with Incorrect Data",groups={"API_regression"})
    public void verifyForgotPasswordWithIncorrectData() throws IOException {
        TestData testData = getForgotPasswordApiWithIncorrectData();
        Response response = ForgotPasswordAPI.verifyForgotPasswordAPIwithIncorrectData(testData );
        Assert.assertEquals(response.statusCode(), 404);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getForgotPasswordApiErrorResponseWithIncorrectData();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        //Assert.assertTrue(List.of(errorRespone.get("altMessage").toString(),errorRespone.get("message").toString()).contains(errorMessage));

    }
    @Test(priority = 4,description = "Verify Forgot password API with Incorrect Header",groups={"API_regression"})
    public void verifyForgotPasswordWithIncorrectHeader() throws IOException {
        TestData testData = getForgotPasswordApiWithIncorrectData();
        Response response = ForgotPasswordAPI.verifyForgotPasswordAPIwithIncorrectHeaders(testData );
        Assert.assertEquals(response.statusCode(), 500);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getForgotPasswordApiErrorResponseWithIncorrectHeader();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        //Assert.assertEquals(errorMessage, errorRespone.get("altMessage").toString(), "Message Content mismatched");
        Assert.assertTrue(List.of(errorRespone.get("altMessage").toString(),errorRespone.get("message").toString()).contains(errorMessage));

    }
    @Test(priority = 2,description = "Verify Update password API with Incorrect Data",groups={"API_regression_Up"})
    public void verifyUpdatePasswordwithIncorrectData() throws IOException {
        TestData testData = getUpdatePasswordApiWithIncorrectData();
        String token = CoreAPITest.token;
        Response response = UpdatePasswordAPI.verifyUpdatePasswordAPIWithIncorrectData(testData, token);
        Assert.assertEquals(response.statusCode(), 422);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getUpdatePasswordApiErrorResponseWithIncorrectData();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
    }

    @Test(priority = 2,description = "Verify Update password API with Incorrect Data",groups={"API_regression_Up"})
    public void verifyUpdatePasswordwithIncorrectHeader() throws IOException {
        TestData testData = getUpdatePasswordApiWithIncorrectData();
        Response response = UpdatePasswordAPI.verifyUpdatePasswordAPIWithIncorrectHeader(testData);
        Assert.assertEquals(response.statusCode(), 401);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        Map<String,Object> errorRespone = testData.getTestData(CoreNegativeData.class).getUpdatePasswordApiErrorResponseWithIncorrectHeader();
        String errorType=responseJsonPath.getString("errors[0].type");
        String errorMessage = responseJsonPath.get("errors[0].message").toString();
        Assert.assertEquals(errorType,errorRespone.get("type").toString(), "Error type mismatched");
        //Assert.assertEquals(errorMessage, errorRespone.get("message").toString(), "Message Content mismatched");
        Assert.assertTrue(List.of(errorRespone.get("altMessage").toString(),errorRespone.get("message").toString()).contains(errorMessage));
    }
}
