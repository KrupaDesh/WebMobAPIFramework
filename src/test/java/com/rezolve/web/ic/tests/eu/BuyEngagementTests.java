package com.rezolve.web.ic.tests.eu;

import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.rezolve.web.ic.model.EngagementLinkData;
import com.rezolve.web.ic.model.LocalizationData;
import com.rezolve.web.ic.pages.*;

import static com.rezolve.web.ic.model.TestDataArranger.*;

public class BuyEngagementTests extends BaseTest {


   @Test(description = "Buy the product by using Google Account with credit card", groups = {"ICv1_EU_Desk_Regression_NT","ICv1_EU_Mobile_Regression_NT"})
    public void buyProductByGoogleAccountWithCreditCard(){
       TestData testData = buyGoogleAccountCase();
       driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
       maximizeWindow();
       new ProductDetailsPage().clickInstantBuy();
       new SignInOptionsPage().clickGoogle().login(testData);
       new ProductDetailsPage().changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
      Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");
   }

    @Test(description = "Buy the product by using Facebook Account", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void buyProductByFacebookAccount(){
        TestData testData = buyFacebookAccountCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPage().clickInstantBuy();
        new SignInOptionsPage().clickFacebook() .login(testData);
        new ProductDetailsPage().changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");

    }

    @Test(description = "Buy the product by using Google Account with PayPal", groups = {"ICv1_EU_Desk_Regression_NT","ICv1_EU_Mobile_Regression_NT"})
    public void buyProductByGoogleAccountWithPayPal(){
        TestData testData = buyGoogleAccountWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPage().clickInstantBuy();
        new SignInOptionsPage().clickGoogle().login(testData);
        new ProductDetailsPage().changePayment().selectPayPal().clickDone().clickInstantBuy();
        new PayPalPage().completePayment(testData);
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "PayPal - Order is not placed and payment failed");
    }

    @Test(description = "Buy the product by using Mobile Number with PayPal", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void buyProductByMobileNumberWithPayPal(){
        TestData testData = buyPhoneNumberWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
       // productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
        productDetailsPage.waitToPageLoad().selectAddressIfNot().clickPayPal().clickInstantBuy();
        new PayPalPage().completePayment(testData);
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "PayPal - Order is not placed and payment failed");
    }

    @Test(description = "Payment cancellation - PayPal cancel at email page", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void paymentCancelAtPayPalEmailPage(){
        TestData testData = buyPhoneNumberWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());

        maximizeWindow();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
      //  productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
        productDetailsPage.waitToPageLoad().selectAddressIfNot().clickInstantBuy();
        new PayPalPage().cancelAtEmailPassword();
        Assert.assertTrue(new OrderSummaryPage().getOrderCancelled().contains("Order Cancelled"), "PayPal Failure is not working : Order Cancelled -not shown");
        Assert.assertTrue(new OrderSummaryPage().getYourOrderHasBeenCancelled().contains("Your order has been cancelled"), "PayPal Failure is not working: Your order has been cancelled - Not shown");
    }
    @Test(description = "Payment cancellation - PayPal cancel at password page", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void paymentCancelAtPayPalPasswordPage(){
        TestData testData = buyPhoneNumberWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());

        maximizeWindow();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        //  productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
        productDetailsPage.waitToPageLoad().selectAddressIfNot().clickInstantBuy();
        new PayPalPage().enterEmail(testData).cancelAtEmailPassword();
        Assert.assertTrue(new OrderSummaryPage().getOrderCancelled().contains("Order Cancelled"), "PayPal Failure is not working : Order Cancelled -not shown");
        Assert.assertTrue(new OrderSummaryPage().getYourOrderHasBeenCancelled().contains("Your order has been cancelled"), "PayPal Failure is not working: Your order has been cancelled - Not shown");
    }

    @Test(description = "Payment cancellation - PayPal cancel at checkout page", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void paymentCancelAtPayPalCheckoutPage(){
        TestData testData = buyPhoneNumberWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());

        maximizeWindow();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        //  productDetailsPage.changePayment().selectPayPal().clickDone().clickInstantBuy();
        productDetailsPage.waitToPageLoad().selectAddressIfNot().clickInstantBuy();
        new PayPalPage().enterEmail(testData).enterPassword(testData).cancelAtPayPalCheckout();
        Assert.assertTrue(new OrderSummaryPage().getOrderCancelled().contains("Order Cancelled"), "PayPal Failure is not working : Order Cancelled -not shown");
        Assert.assertTrue(new OrderSummaryPage().getYourOrderHasBeenCancelled().contains("Your order has been cancelled"), "PayPal Failure is not working: Your order has been cancelled - Not shown");
    }

    @Test(description = "Buy the product then  Collect in store by using Mobile Number with PayPal", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void buyProductCollectInStoreByMobileNumberWithPayPal(){
        TestData testData = buyPhoneNumberCollectInStoreWithPayPalCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPage().waitToPageLoad().setConfig(testData).clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        new ProductDetailsPage().waitToPageLoad().clickCollectInStore().changePayment().selectPayPal().clickDone().clickInstantBuy();
        new PayPalPage().completePayment(testData);
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "PayPal - Order is not placed and payment failed");
    }
    @Test(description = "Buy the product by using Mobile number with credit card", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void buyProductByMobileNumberWithCreditCard(){
        TestData testData = buyMobileNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPage().clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        new ProductDetailsPage().waitToPageLoad().selectAddressIfNot().changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");
    }

    @Test(description = " Verify only the supported payment is showing though the default payment is different",groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void verifyOnlyTheMerchantSupportedPaymentShown(){
        BasePage basePage = new BasePage();
        TestData testDataCard = buyMerchantSupportedPayment();
        TestData testDataPayPal = buyMerchantSupportedPaypalPayment();
        maximizeWindow();
        driverGetUrl(testDataCard.getTestData(EngagementLinkData.class).getIcLink());
        new ProductDetailsPage().waitToPageLoad().setConfig(testDataCard).clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testDataCard);
        new ProductDetailsPage().waitToPageLoad().selectAddressIfNot().chooseCreditCardOrChangePayment().selectCreditCard(testDataCard).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");
       // basePage.openNewTabAndNavigate();
      //  basePage.switchToTab(0);
      //  basePage.close();
       // basePage.switchToTab(0);
        basePage.deleteAllCookies();
        basePage.navigateTo(testDataPayPal.getTestData(EngagementLinkData.class).getIcLink());
        new ProductDetailsPage().waitToPageLoad();
        new ProductDetailsPage().clickPayPal().clickInstantBuyMerchantPayment();
       // new SignInOptionsPage().clickPhoneNumber().login(testDataCard);
        new PayPalPage().completePayment(testDataPayPal);
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "PayPal - Order is not placed and payment failed");

    }

    @Test(description = "Mobile Number - Resend the mobile number after 30 sec", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void verifyMobileNumberOtpResend(){
        TestData testData = buyMobileNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        new ProductDetailsPage().clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().enterCountryCodeAndPhoneNumber(testData)
                .waitAndClickResendOtp(50).getOtpAndEnter(testData).clickContinue();
        new ProductDetailsPage().waitToPageLoad().selectAddressIfNot().changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");
    }

    @Test(description = "Mobile Number - Buy Config product, Pick In Store with credit card", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void buyPickInStoreWithCard(){
        TestData testData = buyPickInStoreByMobileLoginCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.waitToPageLoad().setConfig(testData).clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        productDetailsPage.waitToPageLoad().clickCollectInStore().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");
    }

    @Test(description = "IC Buy - Validate login otp default cursor, product page and Order summary elements. Check the steps and screenshot.", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void buyProductValidateElements(){
        SoftAssert softAssert = new SoftAssert();
        TestData testData = productDetailsAndOrderSummaryCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        SignInOptionsPage signInOptionsPage = new SignInOptionsPage();
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
       // softAssert.assertTrue(productDetailsPage.waitToPageLoad().clickSeeMore().isFullDescriptionShown(), "See More is not working");
       // softAssert.assertFalse(productDetailsPage.clickSeeLess().isFullDescriptionShown(), "See Less is not working");
        softAssert.assertTrue(productDetailsPage.isQuantityDisplayed(), "Quantity is not displayed properly");
        softAssert.assertTrue(productDetailsPage.isProductNameDisplayedAsTitle(testData), "Tab Title is not same as product name");
        productDetailsPage .clickInstantBuy();
        softAssert.assertTrue(signInOptionsPage.areAllLoginOptionsDisplayed(), "One or more login options are not displayed - ref screenshot");
        MobileLoginPage mobileLoginPage = signInOptionsPage.clickPhoneNumber().enterCountryCodeAndPhoneNumber(testData);
        softAssert.assertTrue(mobileLoginPage.isCursorOnFirstBox(),"Cursor is not in OTP first box");
        mobileLoginPage.getOtpAndEnter(testData).clickContinue();

        softAssert.assertTrue(productDetailsPage.isGivenAddressShown(testData), "Delivery address is not same as last selected address");
        softAssert.assertTrue(productDetailsPage.isGivenPaymentCardShown(testData), "Payment Card is not same as last selected card");


        productDetailsPage.changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        softAssert.assertTrue(orderSummaryPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(orderSummaryPage.isOrderProductNameInSummary(testData), "Order summary - Product name mismatch");
        softAssert.assertTrue(orderSummaryPage.getQuantity(testData).equals("1"), "Order summary - Quantity Mismatch");
        softAssert.assertTrue(orderSummaryPage.isShippingAddressCorrect(testData), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(orderSummaryPage.isMerchantDetailsDisplayed(testData), "Order summary - Merchant Details Mismatch");
        softAssert.assertTrue(orderSummaryPage.clickViewWebsite().isNaviagteToMerchantSite(testData), "View Website is not landed in merchant site");
        softAssert.assertAll();
    }


    @Test(description = "Verify the localized strings (GERMAN)", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void buyFlowLocalizationTest(){
        SoftAssert softAssert = new SoftAssert();
        TestData testData = localizationGermanCase();
        LocalizationData localizationData = testData.getTestData(LocalizationData.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        SignInOptionsPage signInOptionsPage = new SignInOptionsPage();
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage();
      //  softAssert.assertTrue(productDetailsPage.waitToPageLoad().clickSeeMore().isFullDescriptionShown(), "See More is not working");
       // softAssert.assertFalse(productDetailsPage.clickSeeLess().isFullDescriptionShown(), "See Less is not working");
        productDetailsPage.changeLanguageToGerman();

        softAssert.assertTrue(productDetailsPage.getQuantityLabel().contains(localizationData.getQuantity()), "Quantity label is not localized");
        softAssert.assertTrue(productDetailsPage.getSeeMoreLessLabel().contains(localizationData.getSeeMore()), "See More is not localized");
        productDetailsPage.clickSeeMore();
        softAssert.assertTrue(productDetailsPage.getSeeMoreLessLabel().contains(localizationData.getSeeLess()), "See Less is not localized");
       // softAssert.assertTrue(productDetailsPage.getInstantBuyLabel().contains(localizationData.getInstantBuy()), "Instant Buy is not localized");
        productDetailsPage .clickInstantBuy();

        softAssert.assertTrue(signInOptionsPage.getPageTitle().contains(localizationData.getBuyNow()), "Login list - Page title is not localized");
        softAssert.assertTrue(signInOptionsPage.getCheckoutInAnInstantWithARezolveAccountLabel().contains(localizationData.getCheckoutInAnInstantWithARezolveAccount()), "CheckoutInAnInstantWithARezolveAccount - Not localized");
        softAssert.assertTrue(signInOptionsPage.getGoogleLabel().contains(localizationData.getContinueWithGoogle()), "Google Button - Not localized");
        softAssert.assertTrue(signInOptionsPage.getFacebookLabel().contains(localizationData.getContinueWithFacebook()), "Facebook Button - Not localized");
        softAssert.assertTrue(signInOptionsPage.getAppleLabel().contains(localizationData.getContinueWithApple()), "Apple Button - Not localized");

        MobileLoginPage mobileLoginPage = signInOptionsPage.clickPhoneNumber();
        softAssert.assertTrue(mobileLoginPage.getPleaseEnterYourPhoneNumberLabel().contains(localizationData.getPleaseEnterYourPhoneNumber()), "Please enter your phone number - Not localized");
        softAssert.assertTrue(mobileLoginPage.getWillSendYouOtpLabel().contains(localizationData.getSendYouOtpShort()), "We’ll send you a one-time password (OTP) to sign you in. - Not localized");
        softAssert.assertTrue(mobileLoginPage.getContinueButtonLabel().contains(localizationData.getContinueText()), "Continue button - Not localized");

        mobileLoginPage.enterCountryCodeAndPhoneNumber(testData);
        softAssert.assertTrue(mobileLoginPage.getEnterOneTimePasswordLabel().contains(localizationData.getEnterOneTimePassword()), "Enter One Time Password - Not localized");
        softAssert.assertTrue(mobileLoginPage.getSentSixDigitCodeLabel().contains(localizationData.getWeHaveSentA6DigitCodeTo()), "We have sent a 6-digit code to - Not localized");
        softAssert.assertTrue(mobileLoginPage.getPleaseEnterItShortLabel().contains(localizationData.getPleaseEnterItInTheFieldsBelowToContinue()), "Please enter it in the fields below to continue. - Not localized");
        softAssert.assertTrue(mobileLoginPage.getContinueButtonLabel().contains(localizationData.getContinueText()), "Continue button - Not localized");
        mobileLoginPage.getOtpAndEnter(testData).clickContinue();
        productDetailsPage.waitToPageLoad().increaseQuantity().decreaseQuantity();
        softAssert.assertTrue(productDetailsPage.getDeliveryOptionsLabel().contains(localizationData.getDeliveryOption()), "DELIVERY OPTION - Not localized ");
        softAssert.assertTrue(productDetailsPage.getPayUsingLabel().contains(localizationData.getPayUsing()), "Pay Using - Not Localized");
        softAssert.assertTrue(productDetailsPage.getAddressChangeLabel().contains(localizationData.getChange()), "Change - Not Localized");
       // softAssert.assertTrue(productDetailsPage.().contains(localizationData.getSubtotalExcludingTax()), "Change - Not Localized");
        softAssert.assertTrue(productDetailsPage.getFooterText().contains(localizationData.getByContinuingWithThisPurchaseYouAcceptTheStandard()), "By continuing with this purchase, you accept the standard - Not Localized");
        softAssert.assertTrue(productDetailsPage.getTermsAndConditionsLinkText().contains(localizationData.getTermsAndConditions()), "Terms and Conditions - Not Localized");
        softAssert.assertTrue(productDetailsPage.getPrivacyPolicyLabel().contains(localizationData.getPrivacyPolicy()), "Privacy Policy - Not Localized");
        AddressPage addressPage = productDetailsPage.changeAddress();

        softAssert.assertTrue(addressPage.getSelectAnAddressLabel().contains(localizationData.getSelectAnAddress()), "SelectAnAddress - Not Localized");
        softAssert.assertTrue(addressPage.getAddAnAddressLabel().contains(localizationData.getAddAnAddress()), "AddAnAddress - Not Localized");
        softAssert.assertTrue(addressPage.getDoneButtonLabel().contains(localizationData.getDone()), "Done - Not Localized");
        addressPage.clickAddAnAddress();
        softAssert.assertTrue(addressPage.getAddAnAddressPageTitleLabel().contains(localizationData.getAddAnAddress()), "Add An Address - Not Localized");
        softAssert.assertTrue(addressPage.getCountryLabel().contains(localizationData.getCountry()), "Country - Not Localized");
        softAssert.assertTrue(addressPage.getAddress1Label().contains(localizationData.getAddressLine1()), "Address Line 1  - Not Localized");
        softAssert.assertTrue(addressPage.getAddress2Label().contains(localizationData.getAddressLine2()), "Address Line 2 - Not Localized");
        softAssert.assertTrue(addressPage.getCityLabel().contains(localizationData.getCity()), "City - Not Localized");
        softAssert.assertTrue(addressPage.getStateLabel().contains(localizationData.getStateProvinceRegion()), "State Province Region - Not Localized");
        softAssert.assertTrue(addressPage.getZipLabel().contains(localizationData.getZipPostalCode()), "Zip PostalCode - Not Localized");
        softAssert.assertTrue(addressPage.getAddressNicknameLabel().contains(localizationData.getAddressNickname()), "Address Nickname - Not Localized");
        addressPage.clickClose().clickDoneButton();
        productDetailsPage.changePayment().selectCreditCard(testData).clickDone().enterCvv("123").clickInstantBuy();
        softAssert.assertTrue(orderSummaryPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(orderSummaryPage.getOrderConfirmLabel().contains(localizationData.getOrderConfirmed()),"Order Confirmed - Not Localized");
        softAssert.assertTrue(orderSummaryPage.getEmailSentLabel().contains(localizationData.getAnEmailConfirmationHasBeenSentTo1()),"Email Sent- Not Localized");
        softAssert.assertTrue(orderSummaryPage.getDeliveryToAddressLabel().contains(localizationData.getDeliverToAddress()),"Deliver To Address - Not Localized");
        softAssert.assertTrue(orderSummaryPage.getViewWebsiteLabel().contains(localizationData.getViewWebsite()),"View Website - Not Localized");
        softAssert.assertAll();
    }

    @Test(description = "Unit Price Validation Without Tax", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void validateUnitPriceWithoutTax(){
        TestData testData = buyUnitPriceWithoutTaxCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.waitToPageLoad().clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        productDetailsPage.waitToPageLoad().increaseQuantity().decreaseQuantity().selectAddressIfNot(); //.clickCollectInStore().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(productDetailsPage.getUnitPrice()== (productDetailsPage.getSubtotalCost()+ productDetailsPage.getTaxCost()),"Missmatch in unit price. Not equal to subtotal + tax");
        Assert.assertTrue( productDetailsPage.getShippingCost() >0, "Shipping price is zero");
    }

    @Test(description = "Unit Price Validation Without Tax", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void validateUnitPriceWithTax(){
        TestData testData = buyUnitPriceWithTaxCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        productDetailsPage.waitToPageLoad().clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        productDetailsPage.waitToPageLoad().increaseQuantity().decreaseQuantity().selectAddressIfNot(); //.clickCollectInStore().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(productDetailsPage.getUnitPrice()== (productDetailsPage.getSubtotalCost()+ productDetailsPage.getTaxCost()),"Missmatch in unit price. Not equal to subtotal + tax");
        Assert.assertTrue( productDetailsPage.getShippingCost() >0, "Shipping price is zero");
        Assert.assertTrue( productDetailsPage.getTotalCost() == (productDetailsPage.getSubtotalCost()+ productDetailsPage.getTaxCost()+ productDetailsPage.getShippingCost()), "Shipping price is zero");
    }
}
