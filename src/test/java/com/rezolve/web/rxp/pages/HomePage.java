package com.rezolve.web.rxp.pages;

import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;

import static engine.core.Element.elementByXpath;

public class HomePage extends BasePage {

Element email = elementByXpath("//span[@class='email']");
Element settingsButton = elementByXpath("//a[@routerlink='/settings'][@class='link']");



    @Step("Verify Home Page Loaded")
    public boolean isHomePageLoaded(){
        return email.waitUntilElementVisible(60).getElement().isDisplayed();
    }

    @Step("Click on Settings Icon")
    public SettingsPage clickOnSettingsIcon(){
        settingsButton.click();
        return new SettingsPage();
    }

}
