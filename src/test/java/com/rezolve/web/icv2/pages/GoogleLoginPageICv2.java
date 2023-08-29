package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.icv2.model.UserAccountDataICv2;

import static engine.core.Element.*;

public class GoogleLoginPageICv2 extends BasePage {


    Element email = elementById("identifierId");
    Element nextButton = elementByXpath("//button//span[text()='Next']");
    Element password = elementByName("Passwd");

    @Step("Google - Login using email and password")
    public void login(TestData testData){
        UserAccountDataICv2 accountData = testData.getTestData(UserAccountDataICv2.class);
        email.enterText(accountData.getEmail());
        nextButton.click();
        password.enterText(accountData.getPassword());
        nextButton.click();
    }


}
