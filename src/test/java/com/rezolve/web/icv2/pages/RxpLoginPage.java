package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import com.rezolve.web.icv2.model.RxpUrlLoginDataICv2;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class RxpLoginPage extends BasePage {


    Element email = elementById("username");
    Element password = elementById("password");
    Element continueButton = elementByXpath("(//button[@value='default'])[2]");



    public RxpCreateEngagementPage login(TestData testData){
        RxpUrlLoginDataICv2 loginData = testData.getTestData(RxpUrlLoginDataICv2.class);
        email.enterText(loginData.getEmail());
        password.enterText(loginData.getPassword());
        continueButton.click();
        return new RxpCreateEngagementPage();
    }
}
