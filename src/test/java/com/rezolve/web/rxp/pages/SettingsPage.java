package com.rezolve.web.rxp.pages;

import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;

import static engine.core.Element.elementByXpath;

public class SettingsPage extends BasePage {

Element sellWithRezolve = elementByXpath("//a[@elementid='settings-api2-cart']");



    @Step("Click on SellWithRezolve")
    public SelectPaymentProviderPage clickOnSellWithRezolve(){
      sellWithRezolve.click();
      return new SelectPaymentProviderPage();
    }






}
