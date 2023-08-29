package com.rezolve.web.rxp.tests.eu;

import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rezolve.web.rxp.model.PaymentProviderDetailsData;
import com.rezolve.web.rxp.model.TestDataArranger;
import com.rezolve.web.rxp.pages.HomePage;
import com.rezolve.web.rxp.pages.SelectPaymentProviderPage;
import com.rezolve.web.rxp.steps.NavigationStep;

public class SeowFlowTest extends BaseTest {

    @Test(description = "Verify select payment provider Elavon with Visa", groups = {"RXP_EU_Regression"})
    public void seowFlowElavonWithVisa() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();

        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);

        selectPaymentProviderPage.SearchElavonPaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantName(testData)
                .enterMerchantId(testData)
                .enterTerminalId(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickVisaCardFromCardBrands() //with visa card
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()

                .EnterThreeDSecureMerchantName(testData) //common detatils
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwo(testData) //visa details
                .enterRequestorID(testData)
                .enterRequestorName(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnBigCommercePlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterName(testData) //bigcommerce payment details
                .enterStoreURL(testData)
                .enterBigCommerceAPIClientID(testData)
                .enterBigCommerceApiAccessToken(testData)
                .enterBigCommerceApiContextField(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }


    @Test(description = "Verify select payment provider Elavon with Mastercard", groups = {"RXP_EU_Regression"})
    public void seowFlowElavonWithMastercard() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();

        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);

        selectPaymentProviderPage.SearchElavonPaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantName(testData)
                .enterMerchantId(testData)
                .enterTerminalId(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickMasterCardFromCardBrands() //with mastercard
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()

                .EnterThreeDSecureMerchantName(testData) //common details
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwoForMasterCard(testData) //mastercard details
                .enterRequestorIDForMastercard(testData)
                .enterRequestorNameForMastercard(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnBigCommercePlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterName(testData) //bigCommerce details
                .enterStoreURL(testData)
                .enterBigCommerceAPIClientID(testData)
                .enterBigCommerceApiAccessToken(testData)
                .enterBigCommerceApiContextField(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }

    @Test(description = "Verify select payment provider Elavon with AmexCard", groups = {"RXP_EU_Regression"})
    public void seowFlowElavonWithAmexCard() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();

        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);

        selectPaymentProviderPage.SearchElavonPaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantName(testData)
                .enterMerchantId(testData)
                .enterTerminalId(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickAmexCardFromCardBrands() //with Amex card
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()

                .EnterThreeDSecureMerchantName(testData) //common detatils
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwoForAmexcard(testData) //amexcard details
                .enterRequestorIDForAmexcard(testData)
                .enterRequestorNameForAmexcard(testData)
                .enterMerchantIDForAmexcard(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnShopifyPlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterNameForShopify(testData) //Shopify details
                .enterStoreURLForShopify(testData)
                .enterApiAccessTokenForShopify(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }


    @Test(description = "Verify select payment provider Worldline with Visa", groups = {"RXP_EU_Regression"})
    public void seowFlowWorldlineWithVisa() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();
             new BasePage().deleteAllCookies();
        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);

        selectPaymentProviderPage.SearchWorldlinePaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantName(testData)
                .enterUId(testData)
                .enterSOPId(testData)
                .enterMerchantIdForWorldline(testData)
                .enterTerminalIdForWorldline(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickVisaCardFromCardBrands() //with visa card
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()
                .EnterThreeDSecureMerchantName(testData)
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)
                .enterMerchantAcquirerBinVTwo(testData)
                .enterRequestorID(testData)
                .enterRequestorName(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnBigCommercePlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterName(testData) //bigCommerce details
                .enterStoreURL(testData)
                .enterBigCommerceAPIClientID(testData)
                .enterBigCommerceApiAccessToken(testData)
                .enterBigCommerceApiContextField(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }


    @Test(description = "Verify select payment provider Worldline with MasterCard", groups = {"RXP_EU_Regression"})
    public void seowFlowWorldlineWithMastercard() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();
        new BasePage().deleteAllCookies();
        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);

        selectPaymentProviderPage.SearchWorldlinePaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantName(testData)
                .enterUId(testData)
                .enterSOPId(testData)
                .enterMerchantIdForWorldline(testData)
                .enterTerminalIdForWorldline(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickMasterCardFromCardBrands() //with mastercard
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()

                .EnterThreeDSecureMerchantName(testData) //common details
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwoForMasterCard(testData) //mastercard details
                .enterRequestorIDForMastercard(testData)
                .enterRequestorNameForMastercard(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnBigCommercePlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterName(testData) //bigCommerce details
                .enterStoreURL(testData)
                .enterBigCommerceAPIClientID(testData)
                .enterBigCommerceApiAccessToken(testData)
                .enterBigCommerceApiContextField(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }

    @Test(description = "Verify select payment provider Worldline with Amexcard", groups = {"RXP_EU_Regression"})
    public void seowFlowWorldlineWithAmexcard() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();
        new BasePage().deleteAllCookies();
        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);

        selectPaymentProviderPage.SearchWorldlinePaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantName(testData)
                .enterUId(testData)
                .enterSOPId(testData)
                .enterMerchantIdForWorldline(testData)
                .enterTerminalIdForWorldline(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()

                .clickAmexCardFromCardBrands() //with Amexcard
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()

                .EnterThreeDSecureMerchantName(testData) //common details
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwoForAmexcard(testData) //amexcard details
                .enterRequestorIDForAmexcard(testData)
                .enterRequestorNameForAmexcard(testData)
                .enterMerchantIDForAmexcard(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnShopifyPlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterNameForShopify(testData) //Shopify details
                .enterStoreURLForShopify(testData)
                .enterApiAccessTokenForShopify(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }


    @Test(description = "Verify select payment provider For Computop", groups = {"RXP_EU_Regression"})
    public void seowFlowComputop(){
        TestData testData = TestDataArranger.paymentProviderDetailsCase();
                  new BasePage().deleteAllCookies();
        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);

        selectPaymentProviderPage.SearchComputopPaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterComputopMerchantID(testData)
                .enterComputopHMACKey(testData)
                .enterComputopBlowFishKey(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnNextButton()
                .clickOnBigCommercePlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()
                .enterName(testData)
                .enterStoreURL(testData)
                .enterBigCommerceAPIClientID(testData)
                .enterBigCommerceApiAccessToken(testData)
                .enterBigCommerceApiContextField(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();

    }

    @Test(description = "Verify select payment provider SixWorldline with Visa", groups = {"RXP_EU_Regression"})
    public void seowFlowSixWorldlineWithVisa() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();
        new BasePage().deleteAllCookies();
        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);

        selectPaymentProviderPage.SearchSixWorldlinePaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterTerminalIdForSixWorldline(testData)
                .enterMerchantIdForSixWorldline(testData)
                .enterAcquiringInstitutionID(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickVisaCardFromCardBrands()
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()
                .EnterThreeDSecureMerchantName(testData)
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)
                .enterMerchantAcquirerBinVTwo(testData)
                .enterRequestorID(testData)
                .enterRequestorName(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnBigCommercePlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()
                .enterName(testData)
                .enterStoreURL(testData)
                .enterBigCommerceAPIClientID(testData)
                .enterBigCommerceApiAccessToken(testData)
                .enterBigCommerceApiContextField(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }

    @Test(description = "Verify select payment provider SixWorldline with Mastercard", groups = {"RXP_EU_Regression"})
    public void seowFlowSixWorldlineWithMastercard() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();
        new BasePage().deleteAllCookies();
        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);

        selectPaymentProviderPage.SearchSixWorldlinePaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterTerminalIdForSixWorldline(testData)
                .enterMerchantIdForSixWorldline(testData)
                .enterAcquiringInstitutionID(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickMasterCardFromCardBrands() //with mastercard
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()
                .EnterThreeDSecureMerchantName(testData)
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)
                .enterMerchantAcquirerBinVTwoForMasterCard(testData)
                .enterRequestorIDForMastercard(testData)
                .enterRequestorNameForMastercard(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnBigCommercePlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()
                .enterName(testData)
                .enterStoreURL(testData)
                .enterBigCommerceAPIClientID(testData)
                .enterBigCommerceApiAccessToken(testData)
                .enterBigCommerceApiContextField(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn() .clickOnOKButton();
    }

    @Test(description = "Verify select payment provider SixWorldline with AmexCard", groups = {"RXP_EU_Regression"})
    public void seowFlowSixWorldlineWithAmexCard() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();
        new BasePage().deleteAllCookies();
        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);
        PaymentProviderDetailsData paymentProviderDetailsData = testData.getTestData(PaymentProviderDetailsData.class);

        selectPaymentProviderPage.SearchSixWorldlinePaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantIdForSixWorldline(testData)
                .enterTerminalIdForSixWorldline(testData)
                .enterAcquiringInstitutionID(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickAmexCardFromCardBrands() //with Amexcard
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()

                .EnterThreeDSecureMerchantName(testData) //common details
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwoForAmexcard(testData) //amexcard details
                .enterRequestorIDForAmexcard(testData)
                .enterRequestorNameForAmexcard(testData)
                .enterMerchantIDForAmexcard(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnShopifyPlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterNameForShopify(testData) //Shopify details
                .enterStoreURLForShopify(testData)
                .enterApiAccessTokenForShopify(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }


    @Test(description = "Verify select payment provider BS PayOne with Visa", groups = {"RXP_EU_Regression"})
    public void seowFlowBSPayOneWithVisa() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();

        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);

        selectPaymentProviderPage.SearchBSPayOnePaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantId(testData)
                .enterTerminalId(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickVisaCardFromCardBrands() //with visa card
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()

                .EnterThreeDSecureMerchantName(testData) //common detatils
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwo(testData) //visa details
                .enterRequestorID(testData)
                .enterRequestorName(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnBigCommercePlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterName(testData) //bigcommerce payment details
                .enterStoreURL(testData)
                .enterBigCommerceAPIClientID(testData)
                .enterBigCommerceApiAccessToken(testData)
                .enterBigCommerceApiContextField(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }

    @Test(description = "Verify select payment provider BS PayOne with MasterCard", groups = {"RXP_EU_Regression"})
    public void seowFlowBSPayOneWithMastercard() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();

        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);

        selectPaymentProviderPage.SearchBSPayOnePaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantId(testData)
                .enterTerminalId(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickMasterCardFromCardBrands() //with mastercard
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()

                .EnterThreeDSecureMerchantName(testData) //common detatils
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwoForMasterCard(testData) //mastercard details
                .enterRequestorIDForMastercard(testData)
                .enterRequestorNameForMastercard(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnBigCommercePlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterName(testData) //bigcommerce payment details
                .enterStoreURL(testData)
                .enterBigCommerceAPIClientID(testData)
                .enterBigCommerceApiAccessToken(testData)
                .enterBigCommerceApiContextField(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }

    @Test(description = "Verify select payment provider BS PayOne with Amex card", groups = {"RXP_EU_Regression"})
    public void seowFlowBSPayOneWithAmexCard() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();

        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);

        selectPaymentProviderPage.SearchBSPayOnePaymentProvider(testData)
                .clickOnPaymentProvider()
                .clickOnNextButton()
                .enterMerchantId(testData)
                .enterTerminalId(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickAmexCardFromCardBrands() //with Amexcard
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()

                .EnterThreeDSecureMerchantName(testData) //common detatils
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwoForAmexcard(testData) //amexcard details
                .enterRequestorIDForAmexcard(testData)
                .enterRequestorNameForAmexcard(testData)
                .enterMerchantIDForAmexcard(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnShopifyPlatform()
                .clickOnNextButtonInSelectEcommercePlatformPage()

                .enterNameForShopify(testData) //Shopify details
                .enterStoreURLForShopify(testData)
                .enterApiAccessTokenForShopify(testData)
                .clickOnNextButtonInEcommercePlatformDetailsPage()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }

    @Test(description = "Verify Help Links in All The Pages", groups = {"RXP_EU_Regression"})
    public void helpLinksInAllThePages() {
        TestData testData = TestDataArranger.paymentProviderDetailsCase();

        HomePage homePage = new NavigationStep().landingPageToHomePage(testData);
        Assert.assertTrue(homePage.isHomePageLoaded(), "Login failed");

        SelectPaymentProviderPage selectPaymentProviderPage = new NavigationStep().homePageToSelectPaymentProviderPage(testData);

        selectPaymentProviderPage.SearchBSPayOnePaymentProvider(testData)
                .clickOnPaymentProvider()
                .verifyPaymentProviderNotListedHelpLink() //Help link
                .verifyThinkingOfSellingOnlineForFirstTimeHelpLink()
                .clickOnNextButton()
                .verifyHelpLinkInPaymentProviderDetailsPage() //Help link
                .enterMerchantId(testData)
                .enterTerminalId(testData)
                .clickOnCurrencyForPayment().clickOnEuroCurrencyFromCurrencyForPayment()
                .clickAmexCardFromCardBrands() //with Amexcard
                .clickOnTimeZoneID().clickOnEuropeOrLondonTimeZone()
                .enterCustomerServiceNumber(testData)
                .clickOnTermsAndConditionCheckbox()
                .clickOnNextButtonInPaymentProviderPage()
                .verifyHelpLinkInSecureSetUpPage() //Help link
                .EnterThreeDSecureMerchantName(testData) //common details
                .enterThreeDSecureMerchantURL(testData)
                .enterCountryIOSCode(testData)
                .enterThreeDSecureMerchantID(testData)
                .enterThreeDSecureMerchantCatagory(testData)

                .enterMerchantAcquirerBinVTwoForAmexcard(testData) //amexcard details
                .enterRequestorIDForAmexcard(testData)
                .enterRequestorNameForAmexcard(testData)
                .enterMerchantIDForAmexcard(testData)
                .clickOnNextButtonInThreeDSecureSetupPage()
                .clickOnSkipThisStepButton()
                .clickOnCancelBtn()
                .clickOnOKButton();
    }
}


