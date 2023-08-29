package com.rezolve.api.Core.test;

import com.rezolve.api.APIBaseTest;
import com.rezolve.api.Core.apiMethods.*;
import com.rezolve.api.Core.model.CoreData;

import engine.TestData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.rezolve.api.Core.model.TestDataArrangerAPI.*;

import java.io.IOException;
import java.util.Map;

@Epic("Epic-01")
@Feature("Core APIs")
public class CoreAPITest extends APIBaseTest {

    public static String regToken,regUser_id ,regPartner_id,registeredUserName=null;
    public static String logintoken,login_user_id ,login_partner_id,login_username=null;
    public static String  guestUserName, newPwd=null;
    public static int registeredId;


    @Test(priority = 1,description = "Verify Login API", groups="API_regression")
    public void verifyLogin() throws IOException {

        TestData testData = getLoginApiDataTest();
        Map<String,Object> payload = testData.getTestData(CoreData.class).getLoginApiPayload();
        Object reqUserName = payload.get("username");
        Response response = LoginAPI.postLoginAPI(testData);// API method
        //Assertions
        Assert.assertEquals(response.statusCode(), 200);
        logintoken = response.getHeader("Authorization");
        login_user_id = response.path("sdkEntity");
        login_partner_id = response.path("sdkPartner");
        login_username = response.jsonPath().getString("username");
        Assert.assertEquals(login_username,reqUserName.toString());

    }

    @Severity(SeverityLevel.NORMAL)
    @Test(priority = 2, description = "Verify Register v2 API",groups="API_regression_newUser")
    //@Test(priority = 1,dependsOnMethods = "verifyLogin", description = "Verify Register v2 API",groups="API_regression")
    public void verifyRegisterv2() throws IOException {
        //System.out.println("Core > Token:"+token+" User id:"+user_id+"PartnerID:" +partner_id);
        TestData testData = getRegisterV2ApiData();
        Response response= RegisterV2API.verifyRegisterv2API(testData,token);
        registeredUserName = response.path("username");
        registeredId = response.path("id");
        Assert.assertEquals(response.statusCode(), 201);
    }

    //Cannot execute daily on stage as deletion of new user is critical task
    @Test(priority = 3, description = "Verify Login with new registed user", groups={"API_regression_newUser"})
    //@Test(priority = 2, dependsOnMethods = "verifyRegisterv2", description = "Verify Login with new registed user", groups={"API_regression"})
    public void verifyLoginWithNewRegisteredUser() throws IOException {
        TestData testData = getLoginApiDataTest();
        Response response = LoginAPI.postLoginWithNewRegisterdUser(testData, registeredUserName);//Passing newly registerd username
        //Assertions
        Assert.assertEquals(response.statusCode(), 200);
        regToken = response.getHeader("Authorization");
        regUser_id = response.path("sdkEntity");
        regPartner_id = response.path("sdkPartner");

    }
    //Cannot execute daily on stage as deletion of new user is critical task
    @Test(priority = 4, description = "Verify ConfirmNumber API",groups="API_regression")
    //@Test(priority = 4,dependsOnMethods = {"verifyRegisterv2","verifyLoginWithNewRegisteredUser"}, description = "Verify ConfirmNumber API",groups="API_regression")
    public void verifyConfirmNumber() throws IOException {
        TestData testData = getConfirmNumberApiDataTest();
        Response response = ConfirmNumberAPI.getConfirmNumberAPI(testData,loginId);
        Assert.assertEquals(response.statusCode(), 200);

    }


    @Test(priority = 2,description = "Verify Guest Register API",groups={"API_regression","Guest_API"})
    public void verifyGuestRegister() throws IOException {
        TestData testData = getGuestRegisterApiData();
        Response response = GuestRegisterAPI.verifyGuestRegisterAPI(testData);
        guestUserName = response.path("username");
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 2,dependsOnMethods = "verifyGuestRegister",description = "Verify Guest Login API",groups={"API_regression","Guest_API"})
    public void verifyGuestLogin() throws IOException {
        TestData testData = getGuestLoginApiData();
        Response response = GuestLoginAPI.verifyGuestLoginAPI(testData,guestUserName );
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 4,description = "Verify Forgot password API",groups={"API_regression"})
    //@Test(priority = 2,dependsOnMethods = "verifyLoginWithNewRegisteredUser",description = "Verify Forgot password API",groups={"API_regression","Guest_API"})
    public void verifyForgotPassword() throws IOException {
        TestData testData = getForgotPasswordApiData();
        Response response = ForgotPasswordAPI.verifyForgotPasswordAPI(testData,username );
        Assert.assertEquals(response.statusCode(), 200);
    }
/*    @Test(priority = 2,dependsOnMethods = "verifyLogin",description = "Verify Update password API",groups={"API_regression"})
    public void verifyUpdatePassword() throws IOException {
        //TestData logintestData = getLoginApiData();
        TestData logintestData = getLoginApiDataTest();
        TestData testData = getUpdatePasswordApiData();

        Map<String,Object> payload = testData.getTestData(CoreData.class).getUpdatePasswordPayload();
        newPwd= payload.get("newPassword").toString();
        Response response = UpdatePasswordAPI.verifyUpdatePasswordAPI(testData,logintoken );
        Assert.assertEquals(response.statusCode(), 200);
        //relogin with updated pwd to generate token

    }*/
    @Test(priority = 1,dependsOnMethods = "verifyLogin",description = "Verify Logout API", groups="API_regression")
    public void verifyLogout()  {

        TestData testData = getLogoutApiData();
        Response response = LogoutAPI.logoutAPI(testData, logintoken);// API method
        //Assertions
        Assert.assertEquals(response.statusCode(), 200);

    }
/*    @Test(priority = 2,dependsOnMethods = "verifyLogout",description = "Verify Update password API to reupdate old pwd",groups={"API_regression"})
    public void verifyReUpdatePassword() throws IOException {
        //TestData logintestData = getLoginApiData();
        TestData logintestData = getLoginApiDataTest();
        TestData testData = getUpdatePasswordApiData();

       //relogin with updated pwd to generate token
        Response loginResponse = LoginAPI.postLoginWithUpdatedPswd(logintestData,newPwd);// API method
        logintoken = loginResponse.getHeader("Authorization");
        //reversing the password update
        Response responsePostReverse =UpdatePasswordAPI.verifyReverseUpdatePasswordAPI(testData,logintoken);
        Assert.assertEquals(responsePostReverse.statusCode(), 200);
    }*/
}
