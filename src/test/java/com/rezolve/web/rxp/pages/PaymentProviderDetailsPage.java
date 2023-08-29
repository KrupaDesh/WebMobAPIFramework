package com.rezolve.web.rxp.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.rxp.model.PaymentProviderDetailsData;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class PaymentProviderDetailsPage extends BasePage {

    Element merchantName = elementById("MERCHANT_NAME");
    Element merchantId = elementById("MERCHANT_ID");
    Element terminalId = elementById("TERMINAL_ID");
    Element currencyForPayments = elementByXpath("//mat-form-field[2]/div/div[1]/div[3]/mat-select/div/div[1]");
    Element currencyForPaymentsDropDown = elementByXpath("//mat-option[@role='option']");
    Element posID = elementById("POS_ID");
    Element uID = elementById("UID");
    Element computopMerchantID = elementById("computop_merchant_id");
    Element computopHMACKey = elementById("computop_hmac_key");
    Element computopBlowFishKey = elementById("computop_blowfish_key");
    Element currencyForPayment = elementById("currency_for_payment");
    Element selectEuroCurrency = elementByXpath("//div[@role='listbox']/mat-option/span[contains(.,' Euro € ')]");
    Element selectVisaCard = elementByXpath("//label[@class=\"mat-checkbox-layout\"]/span[contains(.,' VISA ')]");
    Element selectMastercard = elementByXpath("//label[@class=\"mat-checkbox-layout\"]/span[contains(.,' MasterCard ')]");
    Element selectAmexcard = elementByXpath("//label[@class=\"mat-checkbox-layout\"]/span[contains(.,' AMEX ')]");
    Element timezoneID = elementById("timezone");
    Element selectEuropeOrLondonTimeZone = elementByXpath("//div[@role='listbox']/mat-option/span[contains(.,'Europe/London')]");
    Element customerServicePhoneNum = elementById("phone");
    Element termsAndConditionCheckBox = elementByXpath("//mat-checkbox[@formcontrolname=\"acceptTermsConditions\"]/label/span[1]");
    Element nextButtonInPaymentProviderDetailPage = elementByXpath("//div[3]/div[3]/div/div/app-confirm-button/button");
    Element acquiringInstitutionID = elementById("ACQUIRING_INSTITUTION_ID");
    Element helpLinkInPaymentProviderDetailsPage = elementByXpath("//a[@class=\"help-href\"]");

    @Step("Enter Merchant Name")
    public PaymentProviderDetailsPage enterMerchantName(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        merchantName.enterText(paymentProviderDetailsData.getMerchantName());
        return this;
    }

    @Step("Enter Merchant ID Elavon")
    public PaymentProviderDetailsPage enterMerchantId(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        merchantId.waitUntilElementPresent(60).scrollDownUtillFindElement().enterText(paymentProviderDetailsData.getMerchantId());
        return this;
    }

    @Step("Enter Merchant ID for Worldline")
    public PaymentProviderDetailsPage enterMerchantIdForWorldline(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        merchantId.scrollDownUtillFindElement().enterText(paymentProviderDetailsData.getMerchantIdForWorldLine());
        return this;
    }

    @Step("Enter Merchant ID for SixWorldline")
    public PaymentProviderDetailsPage enterMerchantIdForSixWorldline(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        merchantId.waitUntilElementPresent(60).scrollDownUtillFindElement().enterText(paymentProviderDetailsData.getSixWorldLineMerchantId());
        return this;
    }

    @Step("Enter Terminal ID Elavon")
    public PaymentProviderDetailsPage enterTerminalId(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        terminalId.scrollDownUtillFindElement().enterText(paymentProviderDetailsData.getTerminalId());
        return this;
    }

    @Step("Enter Terminal ID for Worldline")
    public PaymentProviderDetailsPage enterTerminalIdForWorldline(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        terminalId.scrollDownUtillFindElement().enterText(paymentProviderDetailsData.getTerminalIdForWorldLine());
        return this;
    }

    @Step("Enter Terminal ID for SixWorldline")
    public PaymentProviderDetailsPage enterTerminalIdForSixWorldline(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        terminalId.waitUntilElementPresent(60).scrollDownUtillFindElement().enterText(paymentProviderDetailsData.getSixWorldLineTerminalId());
        return this;
    }

    @Step("Select Currency for Payments")
    public void selectCurrencyForPayments() {
        currencyForPayments.scrollDownUtillFindElement().click();
        currencyForPaymentsDropDown.getElements();
    }

    @Step("Enter SOP ID")
    public PaymentProviderDetailsPage enterSOPId(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        posID.enterText(paymentProviderDetailsData.getPosID());
        return this;
    }

    @Step("Enter UID")
    public PaymentProviderDetailsPage enterUId(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        uID.enterText(paymentProviderDetailsData.getUID());
        return this;
    }

    @Step("Enter Computop Merchant Name")
    public PaymentProviderDetailsPage enterComputopMerchantID(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        computopMerchantID.enterText(paymentProviderDetailsData.getComputopMerchantID());
        return this;

    }

    @Step("Enter Computop HMAC Key")
    public PaymentProviderDetailsPage enterComputopHMACKey(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        computopHMACKey.enterText(paymentProviderDetailsData.getComputopHMACKey());
        return this;

    }

    @Step("Enter Computop BlowFish Key")
    public PaymentProviderDetailsPage enterComputopBlowFishKey(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        computopBlowFishKey.enterText(paymentProviderDetailsData.getComputopHMACKey());
        return this;

    }

    @Step("click Currency For Payments")
    public PaymentProviderDetailsPage clickOnCurrencyForPayment() {
        currencyForPayment.scrollDownUtillFindElement().click();
        return this;
    }

    @Step("click Euro Currency from Currency For Payments")
    public PaymentProviderDetailsPage clickOnEuroCurrencyFromCurrencyForPayment() {
        selectEuroCurrency.waitUntilElementVisible(60).click();
        return this;
    }

    @Step("click Visa from Card Brands")
    public PaymentProviderDetailsPage clickVisaCardFromCardBrands() {
        selectVisaCard.click();
        return this;
    }

    @Step("click Mastercard from Card Brands")
    public PaymentProviderDetailsPage clickMasterCardFromCardBrands() {
        selectMastercard.click();
        return this;
    }

    @Step("click Amex card from Card Brands")
    public PaymentProviderDetailsPage clickAmexCardFromCardBrands() {
        selectAmexcard.click();
        return this;
    }

    @Step("click on TimeZoneID")
    public PaymentProviderDetailsPage clickOnTimeZoneID() {
        timezoneID.scrollDownUtillFindElement().click();
        return this;
    }

    @Step("click Europe/London in TimeZone")
    public PaymentProviderDetailsPage clickOnEuropeOrLondonTimeZone() {
        selectEuropeOrLondonTimeZone.waitUntilElementVisible(60).click();
        return this;
    }

    @Step("Enter Customer Service Phone Number")
    public PaymentProviderDetailsPage enterCustomerServiceNumber(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        customerServicePhoneNum.scrollDownUtillFindElement().enterText(paymentProviderDetailsData.getCustomerServicePhoneNum());
        return this;
    }

    @Step("click on Terms and Conditions Checkbox")
    public PaymentProviderDetailsPage clickOnTermsAndConditionCheckbox() {
        termsAndConditionCheckBox.click();
        return this;
    }

    @Step("Click on Next Button")
    public SecureSetupPage clickOnNextButtonInPaymentProviderPage(){
        nextButtonInPaymentProviderDetailPage.waitUntilElementVisible(60).click();
        return new SecureSetupPage();
    }

    @Step("Click on Next Button")
    public SelectECommercePlatformPage clickOnNextButton(){
        nextButtonInPaymentProviderDetailPage.waitUntilElementVisible(60).click();
        return new SelectECommercePlatformPage();
    }

    @Step("Enter acquiring Institution ID")
    public PaymentProviderDetailsPage enterAcquiringInstitutionID(TestData testData) {
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);
        acquiringInstitutionID.scrollDownUtillFindElement().enterText(paymentProviderDetailsData.getAcquiringInstitutionID());
        return this;
    }

    @Step("Verify HelpLink in PaymentProvider Details Page")
    public PaymentProviderDetailsPage verifyHelpLinkInPaymentProviderDetailsPage(){
        helpLinkInPaymentProviderDetailsPage.waitUntilElementPresent(60).isElementDisplayed();
        return new PaymentProviderDetailsPage();
    }
}
