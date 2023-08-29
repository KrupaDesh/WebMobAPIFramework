package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.ic.model.UserAccountData;

import static engine.core.Element.elementById;

public class FacebookPage extends BasePage {


    Element email = elementById("email");
    Element nextButton = elementById("loginbutton");
    Element password = elementById("pass");

    @Step("Facebook - Login using email and password")
    public void login(TestData testData){
        UserAccountData accountData = testData.getTestData(UserAccountData.class);
        email.enterText(accountData.getEmail());
        nextButton.click();
        password.enterText(accountData.getPassword());
        nextButton.click();
    }


}
