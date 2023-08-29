package com.rezolve.web.rxp.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.rxp.model.LoginData;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class LoginPage extends BasePage {

Element userName = elementById ("username");
Element password = elementById ("password");
Element continueButton = elementByXpath("//button[@type='submit'][@value='default']");

    @Step("Login with valid credentials")
    public HomePage loginWithValidCred(TestData testData){
        LoginData loginData = testData.getTestData(LoginData.class);
        userName.enterText(loginData.getUserName());
        password.enterText(loginData.getPassword());
        continueButton.click();
        return new HomePage();

    }


}
