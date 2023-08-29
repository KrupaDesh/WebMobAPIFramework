package com.rezolve.web.rxp.tests.eu;

import engine.TestData;
import engine.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rezolve.web.rxp.model.TestDataArranger;
import com.rezolve.web.rxp.pages.LandingPage;

public class LoginTests extends BaseTest {
    @Test(description = "Verify Login", groups = {"RXP_EU_Regression"})
    public void loginWithValidCredentials(){
        TestData testData = TestDataArranger.loginCase();
        boolean homePageLoaded = new LandingPage()
                .signIn()
                .loginWithValidCred(testData)
                .isHomePageLoaded();
        Assert.assertTrue(homePageLoaded, "Login is failed");
    }

}


