package com.rezolve.web.rce.test;/*
package com.rezolve.test.web;

import com.rezolve.main.web.RCE.pages.RCELoginPage;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.utils.Configuration;
import jdk.jfr.Description;
import org.testng.annotations.Test;


public class RCELoginTest implements IAbstractTest {

    @Test
    @Description("Verify RCE login with invalid credentials")
    public void invalidLogin()
    {
        //Open login page of RCE application
        RCELoginPage rceLoginPage = new RCELoginPage(getDriver());
        String url = Configuration.getEnvArg("rceUrl");
        rceLoginPage.openURL(Configuration.getEnvArg("rceUrl"));
        rceLoginPage.typeUsername(Configuration.getEnvArg("invalidUsername"));
        rceLoginPage.typePassword(Configuration.getEnvArg("invalidPassword"));
        rceLoginPage.clickSignInButton();
    }
    @Test
    @Description("Verify RCE login with valid credentials")
    public void validLogin()
    {
        //Open login page of RCE application
        RCELoginPage rceLoginPage = new RCELoginPage(getDriver());
        String url = Configuration.getEnvArg("rceUrl");
        rceLoginPage.openURL(Configuration.getEnvArg("rceUrl"));
        rceLoginPage.typeUsername(Configuration.getEnvArg("rceUsername"));
        rceLoginPage.typePassword(Configuration.getEnvArg("rcePassword"));
        rceLoginPage.clickSignInButton();

    }


}
*/
