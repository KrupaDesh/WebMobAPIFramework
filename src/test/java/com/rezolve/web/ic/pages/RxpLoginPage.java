package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import com.rezolve.web.ic.model.RxpUrlLoginData;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class RxpLoginPage extends BasePage {


    Element email = elementById("username");
    Element password = elementById("password");
    Element continueButton = elementByXpath("//button[@value='default']");


    public RxpCreateEngagementPage login(TestData testData){
        RxpUrlLoginData loginData = testData.getTestData(RxpUrlLoginData.class);
        email.enterText(loginData.getEmail());
        password.enterText(loginData.getPassword());
        continueButton.click();
        return new RxpCreateEngagementPage();
    }
}
