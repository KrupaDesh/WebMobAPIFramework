package com.rezolve.web.rxp.pages;

import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;

import static engine.core.Element.elementByXpath;

public class ConfirmationPage extends BasePage {

Element cancelBtn = elementByXpath("//span[text()=' Cancel ']");
Element backBtn = elementByXpath("//span[text()=' Back ']");
Element confirmBtn = elementByXpath("//span[text()=' Confirm ']");
Element okButton = elementByXpath("//span[text()=' OK ']");

    @Step("Click On Cancel Button")
    public SelectPaymentProviderPage clickOnCancelBtn(){
        cancelBtn.click();
        return new SelectPaymentProviderPage();
    }

    @Step("Click On Back Button")
    public SelectPaymentProviderPage clickOnBackBtn(){
        backBtn.click();
        return new SelectPaymentProviderPage();
    }

    @Step("Click On Confirm Button")
    public SelectPaymentProviderPage clickOnConfirmBtn(){
        confirmBtn.click();
        return new SelectPaymentProviderPage();
    }

    @Step("Click on OK Button")
    public SelectPaymentProviderPage clickOnOKButton(){
        okButton.waitUntilElementVisible(60).click();
        return new SelectPaymentProviderPage();
    }


}
