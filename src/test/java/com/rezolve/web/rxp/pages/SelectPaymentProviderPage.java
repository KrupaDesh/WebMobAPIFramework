package com.rezolve.web.rxp.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import com.rezolve.web.rxp.model.PaymentProvidersData;

import static engine.core.Element.elementByXpath;

public class SelectPaymentProviderPage extends BasePage {

Element searchField = elementByXpath("//input[@type=\"search\"]");
    Element cancelBtn = elementByXpath("//span[text()=' Cancel ']");
Element elavonText = elementByXpath("//h2[@class=\"payment-provider\"]");
//Element nextButton = elementByClassName("mat-focus-indicator btn mat-button mat-button-base btn-confirmation fill border-radius full-width");
Element nextButton = elementByXpath("//div[3]/div[3]/div/div/app-confirm-button/button");
Element paymentProviderNotListedHelpLink = elementByXpath("(//a[@class=\"help-href ng-star-inserted\"])[1]");
Element thinkingOfSellingOnlineForFirstTimeHelpLink = elementByXpath("(//a[@class=\"help-href ng-star-inserted\"])[2]");
Element okButton = elementByXpath("//span[text()=' OK ']");

    @Step("Search for payment provider")
     public SelectPaymentProviderPage SearchElavonPaymentProvider(TestData testData){
        //public SelectPaymentProviderPage SearchPaymentProvider(String data){
        PaymentProvidersData paymentProviderName;
        paymentProviderName = testData.getTestData(PaymentProvidersData.class);
        searchField.waitUntilElementPresent(60).enterText(paymentProviderName.getElavon());
        return this;
    }
    @Step("Select Payment Provider")
    public SelectPaymentProviderPage clickOnPaymentProvider(){
        elavonText.waitUntilElementPresent(60).click();
        return this;
    }
    @Step("Click on Next Button")
    public PaymentProviderDetailsPage clickOnNextButton(){
        nextButton.waitUntilElementVisible(60).click();
        return new PaymentProviderDetailsPage();
    }

    @Step("Search for payment provider")
    public SelectPaymentProviderPage SearchWorldlinePaymentProvider(TestData testData) {
        //public SelectPaymentProviderPage SearchPaymentProvider(String data){
        PaymentProvidersData paymentProviderName;
        paymentProviderName = testData.getTestData(PaymentProvidersData.class);
        searchField.enterText(paymentProviderName.getWorldline());
        return this;

    }

    @Step("Search for payment provider")
    public SelectPaymentProviderPage SearchComputopPaymentProvider(TestData testData) {
        //public SelectPaymentProviderPage SearchPaymentProvider(String data){
        PaymentProvidersData paymentProviderName;
        paymentProviderName = testData.getTestData(PaymentProvidersData.class);
        searchField.enterText(paymentProviderName.getComputop());
        return this;

    }

    @Step("Search for payment provider")
    public SelectPaymentProviderPage SearchSixWorldlinePaymentProvider(TestData testData) {
        //public SelectPaymentProviderPage SearchPaymentProvider(String data){
        PaymentProvidersData paymentProviderName;
        paymentProviderName = testData.getTestData(PaymentProvidersData.class);
        searchField.enterText(paymentProviderName.getSixWorldline());
        return this;
    }

    @Step("Search for payment provider PayPal")
    public SelectPaymentProviderPage SearchPayPalPaymentProvider(TestData testData) {
        //public SelectPaymentProviderPage SearchPaymentProvider(String data){
        PaymentProvidersData paymentProviderName;
        paymentProviderName = testData.getTestData(PaymentProvidersData.class);
        searchField.enterText(paymentProviderName.getPaypal());
        return this;
    }

    @Step("Search for payment provider PayPal")
    public SelectPaymentProviderPage SearchBSPayOnePaymentProvider(TestData testData) {
        //public SelectPaymentProviderPage SearchPaymentProvider(String data){
        PaymentProvidersData paymentProviderName;
        paymentProviderName = testData.getTestData(PaymentProvidersData.class);
        searchField.enterText(paymentProviderName.getBsPayone());
        return this;
    }

    @Step("Verify payment Provider Not Listed HelpLink")
    public SelectPaymentProviderPage verifyPaymentProviderNotListedHelpLink(){
        paymentProviderNotListedHelpLink.waitUntilElementPresent(10).isElementDisplayed();
        return new SelectPaymentProviderPage();
    }

    @Step("Verify Thinking of selling online for the first time HelpLink")
    public SelectPaymentProviderPage verifyThinkingOfSellingOnlineForFirstTimeHelpLink(){
        thinkingOfSellingOnlineForFirstTimeHelpLink.waitUntilElementPresent(10).isElementDisplayed();
        return new SelectPaymentProviderPage();
    }

    @SneakyThrows
    @Step("Clean up previous test state - Click On Cancel Button if its shown")
    public SelectPaymentProviderPage clickOnCancelBtnIfShown(){
        Thread.sleep(5000);
        if(driver.findElements(By.xpath("//span[text()=' Cancel ']")).size() >0){
            cancelBtn.click();
            //elementByXpath("//app-payment-selector").waitUntilElementPresent(30);
        }

        return new SelectPaymentProviderPage();
    }

    @Step("Clean up previous test state - Click On Cancel Button if its shown")
    public SelectPaymentProviderPage waitToLoad(){
        elementByXpath("//app-payment-selector").waitUntilElementPresent(30);
        return new SelectPaymentProviderPage();
    }


    @Step("Click on OK Button")
    public SelectPaymentProviderPage clickOnOKButton(){
        okButton.waitUntilElementVisible(60).click();
        return new SelectPaymentProviderPage();
    }

    @Step("Click On Cancel Button")
    public SelectPaymentProviderPage clickOnCancelBtn(){
        cancelBtn.click();
        return new SelectPaymentProviderPage();
    }

}
