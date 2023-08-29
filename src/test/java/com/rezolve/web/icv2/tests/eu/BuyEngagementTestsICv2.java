package com.rezolve.web.icv2.tests.eu;

import com.rezolve.web.ic.pages.ProductDetailsPage;
import com.rezolve.web.icv2.model.CreditCardDataICv2;
import com.rezolve.web.icv2.model.UserAccountDataICv2;
import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.rezolve.web.icv2.model.EngagementLinkDataICv2;
import com.rezolve.web.icv2.model.LocalizationDataICv2;
import com.rezolve.web.icv2.pages.*;
import com.rezolve.web.icv2.pages.MobileLoginPageICv2;
import com.rezolve.web.icv2.pages.OrderSummaryPageICv2;
import com.rezolve.web.icv2.pages.ProductDetailsPageICv2;
import com.rezolve.web.icv2.pages.SignInOptionsPageICv2;

import static com.rezolve.web.icv2.model.TestDataICv2.*;

public class BuyEngagementTestsICv2 extends BaseTest {


    @Test(description = "Buy the product by using Google Account with credit card", groups = {"ICv2_EU_Desk_Regression_NT","ICv2_EU_Mobile_Regression_NT"})
    public void buyProductByGoogleAccountWithCreditCard(){
        TestData testData = buyGoogleAccountCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPageICv2().clickInstantBuy();
        //new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickGoogle().login(testData);
        // new SignInOptionsPage().clickGoogle().login(testData);
        new ProductDetailsPageICv2().changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
    }

    @SneakyThrows
    @Test(description = "Buy the product by using Facebook Account", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void buyProductByFacebookAccount(){
        BasePage basePage = new BasePage();
        TestData testData = buyFacebookAccountCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickFacebook(testData);
        if(basePage.getPlatformName().equalsIgnoreCase("MAC") || basePage.getPlatformName().equalsIgnoreCase("IOS")  ){
        basePage.switchToTab(0);}
        else{basePage.switchToTab(1);}
        new FacebookPageICv2().login(testData);
        Thread.sleep(7000);
        basePage.switchToTab(0);
        new ProductDetailsPageICv2().changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
    }

    @Test(description = "Buy the product by using Google Account with PayPal", groups = {"ICv2_EU_Desk_Regression_NT","ICv2_EU_Mobile_Regression_NT"})
    public void buyProductByGoogleAccountWithPayPal(){
        TestData testData = buyGoogleAccountWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickGoogle().login(testData);
        new ProductDetailsPageICv2().changePayment().selectPayPal().clickDone().clickInstantBuy();
        new PayPalPageICv2().completePayment(testData);
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "PayPal - Order is not placed and payment failed");
    }

    @Test(description = "Buy the product by using Mobile Number with PayPal", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void buyProductByMobileNumberWithPayPal(){
        TestData testData = buyPhoneNumberWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        // productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
        productDetailsPage.waitToPageLoad().increaseQuantity();
        //productDetailsPage.waitToPageLoad().selectAddressIfNot().clickPayPal().clickInstantBuy();
        productDetailsPage.waitToPageLoad().selectAddressIfNot().clickPayPal();
        productDetailsPage.clickInstantBuy();

        new PayPalPageICv2().completePayment(testData);
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "PayPal - Order is not placed and payment failed");
    }

    @Test(description = "Payment cancellation - PayPal cancel at email page", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void paymentCancelAtPayPalEmailPage(){
        TestData testData = buyPhoneNumberWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        //  productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
        productDetailsPage.waitToPageLoad().selectAddressIfNot().clickInstantBuy();
        new PayPalPageICv2().cancelAtEmailPassword();
        Assert.assertTrue(new OrderSummaryPageICv2().getOrderCancelled().contains("Order Cancelled"), "PayPal Failure is not working : Order Cancelled -not shown");
        Assert.assertTrue(new OrderSummaryPageICv2().getYourOrderHasBeenCancelled().contains("Your order has been cancelled"), "PayPal Failure is not working: Your order has been cancelled - Not shown");
    }
    @Test(description = "Payment cancellation - PayPal cancel at password page", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void paymentCancelAtPayPalPasswordPage(){
        TestData testData = buyPhoneNumberWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());

        maximizeWindow();
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        //  productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
        productDetailsPage.waitToPageLoad().selectAddressIfNot().clickInstantBuy();
        new PayPalPageICv2().enterEmail(testData).cancelAtEmailPassword();
        Assert.assertTrue(new OrderSummaryPageICv2().getOrderCancelled().contains("Order Cancelled"), "PayPal Failure is not working : Order Cancelled -not shown");
        Assert.assertTrue(new OrderSummaryPageICv2().getYourOrderHasBeenCancelled().contains("Your order has been cancelled"), "PayPal Failure is not working: Your order has been cancelled - Not shown");
    }

    @Test(description = "Payment cancellation - PayPal cancel at checkout page", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void paymentCancelAtPayPalCheckoutPage(){
        TestData testData = buyPhoneNumberWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());

        maximizeWindow();
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        //  productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
        productDetailsPage.waitToPageLoad().selectAddressIfNot().clickInstantBuy();
        new PayPalPageICv2().enterEmail(testData).enterPassword(testData).cancelAtPayPalCheckout();
        Assert.assertTrue(new OrderSummaryPageICv2().getOrderCancelled().contains("Order Cancelled"), "PayPal Failure is not working : Order Cancelled -not shown");
        Assert.assertTrue(new OrderSummaryPageICv2().getYourOrderHasBeenCancelled().contains("Your order has been cancelled"), "PayPal Failure is not working: Your order has been cancelled - Not shown");
    }

    @Test(description = "Buy the product then  Collect in store by using Mobile Number with PayPal", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void buyProductCollectInStoreByMobileNumberWithPayPal(){
        TestData testData = buyPhoneNumberCollectInStoreWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPageICv2().waitToPageLoad().setConfig(testData).clickInstantBuy();
       // new ProductDetailsPageICv2().setConfig(testData).clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        new ProductDetailsPageICv2().waitToPageLoad().clickCollectInStore().changePayment().selectPayPal().clickDone().clickInstantBuy();
        new PayPalPageICv2().completePayment(testData);
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "PayPal - Order is not placed and payment failed");
    }
    @Test(description = "Buy the product by using Mobile number with credit card", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void buyProductByMobileNumberWithCreditCard(){
        TestData testData = buyMobileNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        new ProductDetailsPageICv2().waitToPageLoad().selectAddressIfNot().changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
    }

    @Test(description = " Verify only the supported payment is showing though the default payment is different",groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void verifyOnlyTheMerchantSupportedPaymentShown(){
        BasePage basePage = new BasePage();
        TestData testDataCard = buyMerchantSupportedPayment();
        TestData testDataPayPal = buyMerchantSupportedPaypalPayment();
        maximizeWindow();
        driverGetUrl(testDataCard.getTestData(EngagementLinkDataICv2.class).getIcLink());
       // new ProductDetailsPageICv2().waitToPageLoad().setConfig(testDataCard).clickInstantBuy();
        new ProductDetailsPageICv2().waitToPageLoad().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testDataCard);
        new ProductDetailsPageICv2().waitToPageLoad().selectAddressIfNot().chooseCreditCardOrChangePayment().selectCreditCard(testDataCard).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
        // basePage.openNewTabAndNavigate();
        //  basePage.switchToTab(0);
        //  basePage.close();
        // basePage.switchToTab(0);
        basePage.deleteAllCookies();
        basePage.navigateTo(testDataPayPal.getTestData(EngagementLinkDataICv2.class).getIcLink());
        new ProductDetailsPageICv2().waitToPageLoad();
        new ProductDetailsPageICv2().clickPayPal().clickInstantBuyMerchantPayment();
        // new SignInOptionsPage().clickPhoneNumber().login(testDataCard);
        new PayPalPageICv2().completePayment(testDataPayPal);
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "PayPal - Order is not placed and payment failed");

    }

    @Test(description = "Mobile Number - Resend the mobile number after 30 sec", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void verifyMobileNumberOtpResend(){
        TestData testData = buyMobileNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().enterCountryCodeAndPhoneNumber(testData);
        new MobileLoginPageICv2().waitAndClickResendOtp(50).getOtpAndEnter(testData).clickContinue();
        // Commented below code as it is not related to Resend OTP test case
       // new ProductDetailsPageICv2().waitToPageLoad().selectAddressIfNot().changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new ProductDetailsPageICv2().isDeliverySectionDisplayed(), "Login Failed");
        // Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
    }

    @Test(description = "Mobile Number - Buy Config product, Pick In Store with credit card", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void buyPickInStoreWithCard(){
        TestData testData = buyPickInStoreByMobileLoginCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.waitToPageLoad().setConfig(testData).clickInstantBuy();
        // productDetailsPage.clickInstantBuy();
        //productDetailsPage.waitToPageLoad().setConfig(testData).clickInstantBuy();
        //productDetailsPage.waitToPageLoad().clickInstantBuy();
       // productDetailsPage.clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        productDetailsPage.waitToPageLoad().clickCollectInStore().clickInstantBuy();//CVV should be asked
        //productDetailsPage.waitToPageLoad().clickCollectInStore().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
    }

    @Test(description = "IC Buy - Validate login otp default cursor, product page and Order summary elements. Check the steps and screenshot.", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void buyProductValidateElements(){
        BasePage basePage = new BasePage();
        SoftAssert softAssert = new SoftAssert();
        TestData testData = productDetailsAndOrderSummaryCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        SignInOptionsPageICv2 signInOptionsPage = new SignInOptionsPageICv2();
        OrderSummaryPageICv2 orderSummaryPage = new OrderSummaryPageICv2();
        // softAssert.assertTrue(productDetailsPage.waitToPageLoad().clickSeeMore().isFullDescriptionShown(), "See More is not working");
        // softAssert.assertFalse(productDetailsPage.clickSeeLess().isFullDescriptionShown(), "See Less is not working");
        softAssert.assertTrue(productDetailsPage.waitToPageLoad().isQuantityDisplayed(), "Quantity is not displayed properly");
        softAssert.assertTrue(productDetailsPage.isProductNameDisplayedAsTitle(testData), "Tab Title is not same as product name");
        productDetailsPage .clickInstantBuy();
       // softAssert.assertTrue(signInOptionsPage.areAllLoginOptionsDisplayed(), "One or more login options are not displayed - ref screenshot");
        MobileLoginPageICv2 mobileLoginPage = signInOptionsPage.clickPhoneNumber().enterCountryCodeAndPhoneNumber(testData);
        softAssert.assertTrue(mobileLoginPage.isCursorOnFirstBox(),"Cursor is not in OTP first box");
        mobileLoginPage.getOtpAndEnter(testData).clickContinue();

        new ProductDetailsPageICv2().waitToPageLoad().selectAddressIfNot();
        softAssert.assertTrue(productDetailsPage.isGivenAddressShown(testData), "Delivery address is not same as last selected address");

        if(basePage.getPlatformName().equalsIgnoreCase("IOS")){
            productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
            new PayPalPageICv2().completePayment(testData);
        }else{
            softAssert.assertTrue(productDetailsPage.isGivenPaymentCardShown(testData), "Payment Card is not same as last selected card");
            productDetailsPage.changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        }
        softAssert.assertTrue(orderSummaryPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(orderSummaryPage.isOrderProductNameInSummary(testData), "Order summary - Product name mismatch");
        softAssert.assertTrue(orderSummaryPage.getQuantity(testData).contains("1"), "Order summary - Quantity Mismatch. Actual value: "+orderSummaryPage.getQuantity(testData));
        softAssert.assertTrue(orderSummaryPage.isShippingAddressCorrect(testData), "Order summary - Shipping Address Mismatch");
       // softAssert.assertTrue(orderSummaryPage.isMerchantDetailsDisplayed(testData), "Order summary - Merchant Details Mismatch");
        softAssert.assertTrue(orderSummaryPage.clickViewWebsite().isNaviagteToMerchantSite(testData), "View Website is not landed in merchant site");
        softAssert.assertAll();
    }


    @SneakyThrows
    @Test(description = "Verify the localized strings (GERMAN)", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression_InDev"})
    public void buyFlowLocalizationTest(){
        BasePage basePage = new BasePage();
        SoftAssert softAssert = new SoftAssert();
        TestData testData = localizationGermanCase();
        LocalizationDataICv2 localizationData = testData.getTestData(LocalizationDataICv2.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        SignInOptionsPageICv2 signInOptionsPage = new SignInOptionsPageICv2();
        OrderSummaryPageICv2 orderSummaryPage = new OrderSummaryPageICv2();

        productDetailsPage.waitToPageLoad().changeLanguageToGerman();
        softAssert.assertTrue(productDetailsPage.getQuantityLabel().contains(localizationData.getQuantity()), "Quantity label is not localized");

        // See more and See less functionality is only for Mobile devices
        String[] config = System.getProperty("config").split("[.]");
        if(config[1].matches("android|ios")){
            softAssert.assertTrue(productDetailsPage.getSeeMoreLessLabel().contains(localizationData.getSeeMore()), "See More is not localized");
            productDetailsPage.clickSeeMore();
            softAssert.assertTrue(productDetailsPage.getSeeMoreLessLabel().contains(localizationData.getSeeLess()), "See Less is not localized");
        }
        // softAssert.assertTrue(productDetailsPage.getInstantBuyLabel().contains(localizationData.getInstantBuy()), "Instant Buy is not localized");
        productDetailsPage.clickInstantBuy();

        softAssert.assertTrue(signInOptionsPage.getPageTitle().contains(localizationData.getBuyNow()), "Login list - Page title is not localized");
        softAssert.assertTrue(signInOptionsPage.getCheckoutInAnInstantWithARezolveAccountLabel().contains(localizationData.getCheckoutInAnInstantWithARezolveAccount()), "CheckoutInAnInstantWithARezolveAccount - Not localized");
        softAssert.assertTrue(signInOptionsPage.getPhoneNumberLabel().contains(localizationData.getSignInWithYourPhoneNumber()), "Phone Number Button - Not localized");
        softAssert.assertTrue(signInOptionsPage.getGoogleLabel().contains(localizationData.getContinueWithGoogle()), "Google Button - Not localized");
        softAssert.assertTrue(signInOptionsPage.getFacebookLabel().contains(localizationData.getContinueWithFacebook()), "Facebook Button - Not localized");
        softAssert.assertTrue(signInOptionsPage.getAppleLabel().contains(localizationData.getContinueWithApple()), "Apple Button - Not localized");

        MobileLoginPageICv2 mobileLoginPage = signInOptionsPage.clickPhoneNumberGermanFlow();
        softAssert.assertTrue(mobileLoginPage.getPleaseEnterYourPhoneNumberLabel().contains(localizationData.getPleaseEnterYourPhoneNumber()), "Sign in with phone number - Not localized");
        softAssert.assertTrue(mobileLoginPage.getWillSendYouOtpLabel().contains(localizationData.getSendYouOtpShort()), "We’ll send you a one-time password (OTP) to sign you in. - Not localized");
        softAssert.assertTrue(mobileLoginPage.getContinueButtonLabel().contains(localizationData.getContinueText()), "Continue button - Not localized");

        mobileLoginPage.enterCountryCodeAndPhoneNumber(testData);
        softAssert.assertTrue(mobileLoginPage.getEnterOneTimePasswordLabel().contains(localizationData.getEnterOneTimePassword()), "Verify Phone Number - Not localized");
        softAssert.assertTrue(mobileLoginPage.getSentSixDigitCodeLabel().contains(localizationData.getWeHaveSentA6DigitCodeTo()), "We have sent a 6-digit code to - Not localized");
       // softAssert.assertTrue(mobileLoginPage.getPleaseEnterItShortLabel().contains(localizationData.getPleaseEnterItInTheFieldsBelowToContinue()), "Please enter it in the fields below to continue. - Not localized");
        softAssert.assertTrue(mobileLoginPage.getContinueButtonLabel().contains(localizationData.getVerifyText()), "Verify button - Not localized");
        mobileLoginPage.getOtpAndEnter(testData).clickContinue();

        //productDetailsPage.waitToPageLoad().increaseQuantity().decreaseQuantity();
        softAssert.assertTrue(productDetailsPage.getQuantityLabel().contains(localizationData.getQuantity()), "Quantity label is not localized");
        softAssert.assertTrue(productDetailsPage.getDeliveryOptionsLabel().contains(localizationData.getDeliveryOption()), "DELIVERY OPTION - Not localized ");
        softAssert.assertTrue(productDetailsPage.getPayUsingLabel().contains(localizationData.getPayUsing()), "Pay Using - Not Localized");
        softAssert.assertTrue(productDetailsPage.getAddressChangeLabel().contains(localizationData.getChange()), "Change - Not Localized");
        // softAssert.assertTrue(productDetailsPage.().contains(localizationData.getSubtotalExcludingTax()), "Change - Not Localized");

        AddressPageICv2 addressPage = productDetailsPage.changeAddress();

        softAssert.assertTrue(addressPage.getSelectAnAddressLabel().contains(localizationData.getSelectAnAddress()), "Select Delivery Option - Not Localized");
        softAssert.assertTrue(addressPage.getAddAnAddressLabel().contains(localizationData.getAddAnAddress()), "Add Address - Not Localized");
        softAssert.assertTrue(addressPage.getConfirmDeliveryAddressButtonLabel().contains(localizationData.getConfirmDeliveryAddress()), "Confirm Delivery Address - Not Localized");
        addressPage.clickAddAnAddress();
      //  softAssert.assertTrue(addressPage.getAddAnAddressPageTitleLabel().contains(localizationData.getAddAnAddressPageTitle()), "Add Address page title - Not Localized");
        softAssert.assertTrue(addressPage.getCountryLabel().contains(localizationData.getCountry()), "Country - Not Localized");
        softAssert.assertTrue(addressPage.getAddress1Label().contains(localizationData.getAddressLine1()), "Address Line 1  - Not Localized");
        softAssert.assertTrue(addressPage.getAddress2Label().contains(localizationData.getAddressLine2()), "Address Line 2 - Not Localized");
        softAssert.assertTrue(addressPage.getCityLabel().contains(localizationData.getCity()), "City - Not Localized");
        softAssert.assertTrue(addressPage.getStateLabel().contains(localizationData.getStateProvinceRegion()), "State Province - Not Localized");
        softAssert.assertTrue(addressPage.getZipLabel().contains(localizationData.getZipPostalCode()), "Zip PostalCode - Not Localized");
        softAssert.assertTrue(addressPage.getHouseLabel().contains(localizationData.getHouse()), "House - Not Localized");
        softAssert.assertTrue(addressPage.getWorkLabel().contains(localizationData.getWork()), "Work - Not Localized");
        softAssert.assertTrue(addressPage.getAddressNicknameLabel().contains(localizationData.getAddressNickname()), "Address Nickname - Not Localized");

        addressPage.clickOnMandatoryInputFields();
        softAssert.assertTrue(addressPage.getZipErrorLabel().contains(localizationData.getErrorZip()), "Zip Error Message - Not Localized");
        softAssert.assertTrue(addressPage.getAddressLine1ErrorLabel().contains(localizationData.getErrorAddressLine()), "Address Line 1 Error Message - Not Localized");
        softAssert.assertTrue(addressPage.getCityErrorLabel().contains(localizationData.getErrorCity()), "City Error Message- Not Localized");
        softAssert.assertTrue(addressPage.getStateErrorLabel().contains(localizationData.getErrorState()), "State Error Message - Not Localized");
        softAssert.assertTrue(addressPage.getNicknameErrorLabel().contains(localizationData.getErrorNickname()), "Nickname Error Message - Not Localized");

        if(basePage.getPlatformName().equalsIgnoreCase("windows") || basePage.getPlatformName().equalsIgnoreCase("MAC")){
        productDetailsPage.changeAddress().clickconfirmDeliveryButton();
        }else{
        productDetailsPage.clickBackButton();
        Thread.sleep(1000);
        productDetailsPage.clickBackButton();
        }

        productDetailsPage.changePayment();
        CardPageICv2 cardPageICv2 = new CardPageICv2();
        softAssert.assertTrue(cardPageICv2.getSelectPaymentOptionLabel().contains(localizationData.getSelectPaymentMethod()), "Select payment option - Not Localized");
        softAssert.assertTrue(cardPageICv2.getSavedCardsLabel().contains(localizationData.getSavedCards()), "Saved Cards - Not Localized");
        softAssert.assertTrue(productDetailsPage.getConfirmPaymentOptionButtonLabel().contains(localizationData.getConfirmPaymentOptionButtonLabel()), "Confirm Payment Option button text - Not Localized");
        cardPageICv2.clickOnAddNewCard();
        softAssert.assertTrue(cardPageICv2.getaddCardLabel().contains(localizationData.getAddCard()), "Add Card - Not Localized");
        softAssert.assertTrue(cardPageICv2.getCardNumberLabel().contains(localizationData.getCardNumber()), "Card Number - Not Localized");
        softAssert.assertTrue(cardPageICv2.getNameOnCardLabel().contains(localizationData.getNameExactlyAsOnCard()), "Name on card - Not Localized");
        softAssert.assertTrue(cardPageICv2.getExpiryDateLabel().contains(localizationData.getExpires()), "Card Number - Not Localized");

        cardPageICv2.clickOnMandatoryInputFields();
        softAssert.assertTrue(cardPageICv2.getCardNumberErrorLabel().contains(localizationData.getErrorCardNumber()), "Card Number Error Message - Not Localized");
        softAssert.assertTrue(cardPageICv2.getNameOnCardErrorLabel().contains(localizationData.getErrorNameOnCard()), "Name on card Error Message - Not Localized");
        softAssert.assertTrue(cardPageICv2.getExpiresErrorLabel().contains(localizationData.getErrorExpires()), "Expires Error Message - Not Localized");
        softAssert.assertTrue(cardPageICv2.getCvvErrorLabel().contains(localizationData.getErrorCvv()), "CVV Error Message - Not Localized");
        softAssert.assertTrue(cardPageICv2.getBillingAddressLabel().contains(localizationData.getBillingAddress()), "Billing Address - Not Localized");
        softAssert.assertTrue(cardPageICv2.getSaveCardButtonLabel().contains(localizationData.getSaveCardButton()), "Save card button text - Not Localized");
        productDetailsPage.clickBackButton();
        new PaymentListPageICv2().clickDone().enterCvv("123");
      //  productDetailsPage.changePayment().selectCreditCard(testData).clickDone().enterCvv("123");

        softAssert.assertTrue(productDetailsPage.getFooterText().contains(localizationData.getByContinuingWithThisPurchaseYouAcceptTheStandard()), "By continuing with this purchase, you accept the standard - Not Localized");
        softAssert.assertTrue(productDetailsPage.getTermsAndConditionsLinkText().contains(localizationData.getTermsAndConditions()), "Terms and Conditions - Not Localized");
        softAssert.assertTrue(productDetailsPage.getAndLabel().contains(localizationData.getAndText()), "and - Not Localized");
        softAssert.assertTrue(productDetailsPage.getPrivacyPolicyLabel().contains(localizationData.getPrivacyPolicy()), "Privacy Policy - Not Localized");
        softAssert.assertTrue(productDetailsPage.getOfText().contains(localizationData.getOfText()), "of - Not Localized");

        if(basePage.getPlatformName().equalsIgnoreCase("IOS")){
            productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
            new PayPalPageICv2().completePayment(testData);
        }else{
            productDetailsPage.clickInstantBuy();
        }
        softAssert.assertTrue(orderSummaryPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(orderSummaryPage.getOrderConfirmLabel().contains(localizationData.getOrderConfirmed()),"Thank you for your order! - Not Localized");
        softAssert.assertTrue(orderSummaryPage.getEmailSentLabel().contains(localizationData.getAnEmailConfirmationHasBeenSentTo1()),"The order confirmation has been sent to your email address- Not Localized");
        softAssert.assertTrue(orderSummaryPage.getDeliveryToAddressLabel().contains(localizationData.getDeliverToAddress()),"Deliver To - Not Localized");
        softAssert.assertTrue(orderSummaryPage.getViewWebsiteLabel().contains(localizationData.getViewWebsite()),"View Website - Not Localized");
        softAssert.assertAll();
    }

    @Test(description = "Unit Price Validation Without Tax", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void validateUnitPriceWithoutTax(){
        TestData testData = buyUnitPriceWithoutTaxCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.waitToPageLoad().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        productDetailsPage.waitToPageLoad().increaseQuantity().decreaseQuantity().selectAddressIfNot(); //.clickCollectInStore().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(productDetailsPage.getUnitPrice()== (productDetailsPage.getSubtotalCost()+ productDetailsPage.getTaxCost()),"Missmatch in unit price. Not equal to subtotal + tax");
        Assert.assertTrue( productDetailsPage.getShippingCost() >0, "Shipping price is zero");
    }

    @Test(description = "Unit Price Validation With Tax", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void validateUnitPriceWithTax(){
        TestData testData = buyUnitPriceWithTaxCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.waitToPageLoad().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        productDetailsPage.waitToPageLoad().increaseQuantity().decreaseQuantity().selectAddressIfNot(); //.clickCollectInStore().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(productDetailsPage.getUnitPrice()== (productDetailsPage.getSubtotalCost()+ productDetailsPage.getTaxCost()),"Missmatch in unit price. Not equal to subtotal + tax");
        Assert.assertTrue( productDetailsPage.getShippingCost() >0, "Shipping price is zero");
        Assert.assertTrue( productDetailsPage.getTotalCost() == (productDetailsPage.getSubtotalCost()+ productDetailsPage.getTaxCost()+ productDetailsPage.getShippingCost()), "Shipping price is zero");
    }

    @Test(description = "Add New Card and Delete Added Card", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void addNewCardAndDeleteCard(){
        TestData testData = addCardTestCase();
        CreditCardDataICv2 cardData = testData.getTestData(CreditCardDataICv2.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.waitToPageLoad().clickInstantBuy();

        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        productDetailsPage.changePayment();

        CardPageICv2 cardPageICv2 = new CardPageICv2();
        cardPageICv2.clickOnAddNewCard().addNewCard(testData);
        productDetailsPage.changePayment();

        String newlyAddedCard = cardPageICv2.waitToLoadPage().getNewlyAddedCard();
        Assert.assertTrue(newlyAddedCard.contains(cardData.getLastFourDigitOfCard()), "Card Number mismatch");
        Assert.assertTrue(newlyAddedCard.contains(cardData.getExpires()),"Expiry date mismatch");
        Assert.assertTrue(newlyAddedCard.contains(cardData.getType()),"Card type mismatch");

        cardPageICv2.deleteCard();
        String deletedCard = cardPageICv2.waitToLoadPage().getNewlyAddedCard();
        Assert.assertFalse(deletedCard.contains(cardData.getLastFourDigitOfCard()), "Card Not Deleted");
        Assert.assertFalse(deletedCard.contains(cardData.getExpires()),"Card Not Deleted");
        Assert.assertFalse(deletedCard.contains(cardData.getType()),"Card Not Deleted");
    }
    @Test(description = "Verify View Details Link", groups = {"ICv2_EU_Desk_Regression"})
    public void validateViewDetailsLink(){
        TestData testData = buyMobileNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.waitToPageLoad().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        productDetailsPage.waitToPageLoad().clickOnViewDetailsLink();
        boolean seePriceDetails = productDetailsPage.isPriceDetailsDisplayed();
        Assert.assertTrue(seePriceDetails,"Payment details is not displayed when clicking the view details link");
    }
    @Test(description = "Out Of Stock Scenario", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void outOfStockScenario(){
        TestData testData = outOfStockCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        ProductDetailsPageICv2 productDetailsPage = new ProductDetailsPageICv2();
        productDetailsPage.waitToPageLoad().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        boolean outOfStockText = productDetailsPage.waitToPageLoad().isOutOfStockTextDisplayed();
        //boolean instantBuyButton = productDetailsPage.isInstantBuyButtonDisabled();
        Assert.assertTrue(outOfStockText,"Out Of Stock Error Message Is Not Displayed");
        // Assert.assertTrue(instantBuyButton,"Instant Buy Button Is Enabled");
    }
    @SneakyThrows
    @Test(description = "Invalid OTP Error Message Validation ", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void verifyErrorMessageForInvalidOTP(){
        TestData testData = buyMobileNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();

        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber();
        MobileLoginPageICv2 mobileLoginPageICv2 = new MobileLoginPageICv2();
        mobileLoginPageICv2.enterCountryCodeAndPhoneNumber(testData);
        mobileLoginPageICv2.enterInvalidOTP(testData).clickContinue();
        Thread.sleep(5000);
        String errorMessage = mobileLoginPageICv2.getInvalidOtpErrorMessage();
        Assert.assertTrue(errorMessage.contains(testData.getTestData(UserAccountDataICv2.class).getErrorMessage()),"Login successful with InvalidOTP");
    }
}
