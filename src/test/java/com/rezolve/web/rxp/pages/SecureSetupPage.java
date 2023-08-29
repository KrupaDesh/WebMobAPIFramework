package com.rezolve.web.rxp.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.rxp.model.PaymentProviderDetailsData;

import static engine.core.Element.elementByXpath;

public class SecureSetupPage extends BasePage {

    Element threeDSecureMerchantName = elementByXpath("(//div/input[@type='text'])[1]");
    Element threeDSecureMerchantURL = elementByXpath("(//div/input[@type='text'])[2]");
    Element countryIOSCode = elementByXpath("(//div/input[@type='text'])[3]");
    Element threeDSecureMerchantID = elementByXpath("(//div/input[@type='text'])[4]");
    Element threeDSecureMerchantCatagory = elementByXpath("(//div/input[@type='text'])[5]");
    Element merchantAcquirerBinVTwo = elementByXpath("(//div/input[@type='text'])[6]");
    Element requestorID = elementByXpath("(//div/input[@type='text'])[7]");
    Element requestorName = elementByXpath("(//div/input[@type='text'])[8]");
    Element nextButtonInThreeDSecurePage = elementByXpath("//div[3]/div[3]/div/div/app-confirm-button/button");
    Element merchantIDForAmexCard = elementByXpath("(//div/input[@type='text'])[9]");
    Element helpLinkInSecureSetUpPage = elementByXpath("//a[@class=\"help-href\"]");

    @Step("Enter three D Secure Merchant Name")
    public SecureSetupPage EnterThreeDSecureMerchantName(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        threeDSecureMerchantName.waitUntilElementVisible(60).enterText(paymentProviderDetailsData.getThreeDSecureMerchantName());
        return this;
    }

    @Step("Enter three D Secure Merchant URL")
    public SecureSetupPage enterThreeDSecureMerchantURL(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        threeDSecureMerchantURL.enterText(paymentProviderDetailsData.getThreeDSecureMerchantURL());
        return this;
    }

    @Step("Enter three D Secure Country IOS Code")
    public SecureSetupPage enterCountryIOSCode(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        countryIOSCode.enterText(paymentProviderDetailsData.getCountryISCode());
        return this;
    }


    @Step("Enter three D Secure Merchant ID")
    public SecureSetupPage enterThreeDSecureMerchantID(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        threeDSecureMerchantID.enterText(paymentProviderDetailsData.getCountryISCode());
        return this;
    }

    @Step("Enter three D Secure Merchant Catagory")
    public SecureSetupPage enterThreeDSecureMerchantCatagory(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        threeDSecureMerchantCatagory.enterText(paymentProviderDetailsData.getThreeDSecureMerchantCategory());
        return this;
    }

    @Step("Enter three D Secure Merchant Acquire Bin VTwo for visa")
    public SecureSetupPage enterMerchantAcquirerBinVTwo(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        merchantAcquirerBinVTwo.enterText(paymentProviderDetailsData.getMerchantAcquirerBinVTwo());
        return this;
    }

    @Step("Enter three D Secure Merchant Acquirer Bin VTwo For MasterCard")
    public SecureSetupPage enterMerchantAcquirerBinVTwoForMasterCard(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        merchantAcquirerBinVTwo.enterText(paymentProviderDetailsData.getMerchantAcquirerBinVTwoForMasterCard());
        return this;
    }

    @Step("Enter three D Secure Merchant Acquirer Bin VTwo For Amexcard")
    public SecureSetupPage enterMerchantAcquirerBinVTwoForAmexcard(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        merchantAcquirerBinVTwo.enterText(paymentProviderDetailsData.getMerchantAcquirerBinVTwoForAmexCard());
        return this;
    }

    @Step("Enter three D Secure Requestor ID for visa")
    public SecureSetupPage enterRequestorID(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        requestorID.enterText(paymentProviderDetailsData.getRequestorID());
        return this;
    }


    @Step("Enter three D Secure Requestor ID For Mastercard")
    public SecureSetupPage enterRequestorIDForMastercard(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        requestorID.enterText(paymentProviderDetailsData.getRequestorIDForMastercard());
        return this;
    }

    @Step("Enter three D Secure Requestor ID For Amexcard")
    public SecureSetupPage enterRequestorIDForAmexcard(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        requestorID.enterText(paymentProviderDetailsData.getRequestorIDForAmex());
        return this;
    }


    @Step("Enter three D Secure Requestor Name for visa")
    public SecureSetupPage enterRequestorName(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        requestorName.enterText(paymentProviderDetailsData.getRequestorName());
        return this;
    }


    @Step("Enter three D Secure Requestor Name For Mastercard")
    public SecureSetupPage enterRequestorNameForMastercard(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        requestorName.enterText(paymentProviderDetailsData.getRequestorNameForMastercard());
        return this;
    }

    @Step("Enter three D Secure Requestor Name For Amexcard")
    public SecureSetupPage enterRequestorNameForAmexcard(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        requestorName.enterText(paymentProviderDetailsData.getRequestorNameForAmexCard());
        return this;
    }

    @Step("Enter three D Secure Merchant Name For Amexcard")
    public SecureSetupPage enterMerchantIDForAmexcard(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        merchantIDForAmexCard.scrollDownUtillFindElement().enterText(paymentProviderDetailsData.getAmexcardMerchantID());
        return this;
    }

    @Step("Click on Next Button")
    public SelectECommercePlatformPage clickOnNextButtonInThreeDSecureSetupPage() {
        nextButtonInThreeDSecurePage.waitUntilElementVisible(60).click();
        return new SelectECommercePlatformPage();
    }

    @Step("Verify HelpLink in Secure Setup Page")
    public SecureSetupPage verifyHelpLinkInSecureSetUpPage(){
        helpLinkInSecureSetUpPage.waitUntilElementPresent(60).isElementDisplayed();
        return new SecureSetupPage();
    }
}
