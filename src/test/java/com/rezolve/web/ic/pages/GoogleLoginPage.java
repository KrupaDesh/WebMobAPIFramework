package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.ic.model.UserAccountData;

import static engine.core.Element.*;

public class GoogleLoginPage extends BasePage {


    Element email = elementById("identifierId");
    Element nextButton = elementByXpath("//button//span[text()='Next']");
    Element password = elementByName("password");

    @Step("Google - Login using email and password")
    public void login(TestData testData){
        UserAccountData accountData = testData.getTestData(UserAccountData.class);
        email.enterText(accountData.getEmail());
        nextButton.click();
        password.enterText(accountData.getPassword());
        nextButton.click();
    }


}
