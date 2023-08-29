package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.icv2.model.UserAccountDataICv2;
import lombok.SneakyThrows;

import static engine.core.Element.*;

//public class FacebookPage extends BasePage {

public class FacebookPageICv2 extends BasePage {
    Element email = elementByXpath("//input[contains(@placeholder, \"number\")]");
   // Element nextButton = elementByXpath("//button[contains(text(),\"Log in\")]");
    Element nextButton = elementByName("login");
    Element password = elementByXpath("//input[@type=\"password\"]");
    Element continueButton = elementByXpath("//button[@value=\"Continue\"]");

    @SneakyThrows
    @Step("Facebook - Login using email and password")
    public void login(TestData testData){
        Thread.sleep(4000);
        UserAccountDataICv2 accountData = testData.getTestData(UserAccountDataICv2.class);
        email.waitUntilElementClickable(30).enterText(accountData.getEmail());
        password.enterText(accountData.getPassword());
        Thread.sleep(3000);
        screenshot();
        nextButton.click();


        try {
            if(System.getProperty("config")!= null) {
                String[] config = System.getProperty("config").split("[.]");
                if (config[1].matches("android|ios"))
                    continueButton.click();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
