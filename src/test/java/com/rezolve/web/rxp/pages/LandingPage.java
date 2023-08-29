package com.rezolve.web.rxp.pages;

import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;

import static engine.core.Element.elementByXpath;

public class LandingPage extends BasePage {

    Element signInLink = elementByXpath("//a[@class='sign-in']");


    @Step("Click Sign In")
    public LoginPage signIn(){
        signInLink.click();
        return new LoginPage();
    }

}
