package com.rezolve.api;

import com.rezolve.api.Core.apiMethods.LoginAPI;
import com.rezolve.api.Core.model.CoreData;
import engine.TestData;
import engine.core.BaseTest;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Map;

import static com.rezolve.api.TestDataArranger.*;

public class APIBaseTest {
    public static String token,user_id,partner_id,username =null;
    public static int loginId;

    @SneakyThrows
    @BeforeMethod(alwaysRun = true)
    public void verifyBaseLogin() throws IOException {
        Thread.sleep(100);
        TestData testData = getCommonLoginApiDataTest();

        Response response = LoginAPI.postBaseLoginAPI(testData);// API method
        //Assertions
        Assert.assertEquals(response.statusCode(), 200);
        token = response.getHeader("Authorization");
        user_id = response.path("sdkEntity");
        partner_id = response.path("sdkPartner");
        username = response.jsonPath().getString("username");
        loginId = response.path("id");
    }
}
