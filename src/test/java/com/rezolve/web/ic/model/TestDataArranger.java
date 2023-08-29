package com.rezolve.web.ic.model;

import engine.TestData;
import engine.core.BasePage;
import io.qameta.allure.Step;
import com.rezolve.RandomGenerator;

import static engine.reader.MyJsonReader.getDataObject;

public class TestDataArranger {
    public static String platformName = new BasePage().getPlatformName().toLowerCase();
    public static String browserName = new BasePage().getBrowserName().toLowerCase();

    public static UserAccountData getMobileNumber(){
        return getDataObject("mobileAccount_"+platformName+"_"+browserName, UserAccountData.class);
    }

    public static UserAccountData getMobileAccountPayPal(){
        return getDataObject("mobileAccountPayPal_"+platformName+"_"+browserName, UserAccountData.class);
    }



    @Step("TestData for the Google Account test case")
    public static TestData buyGoogleAccountCase(){
       return new TestData().addTestData(getDataObject("gmailAccount", UserAccountData.class))
                .addTestData("buyEngagementLink", EngagementLinkData.class)
               .addTestData("masterCardSuccessful", CreditCardData.class);
    }

    @Step("TestData for the Mobile Number test case")
    public static TestData buyMobileNumberCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyEngagementLink", EngagementLinkData.class)
                .addTestData("masterCardSuccessful", CreditCardData.class);
    }
    @Step("TestData for merchant supported card payment")
    public static TestData buyMerchantSupportedPayment(){
        return new TestData().addTestData("mobileAccountPayment_"+platformName+"_"+browserName, UserAccountData.class)
                .addTestData("buyOnlyCreditCard", EngagementLinkData.class)
                .addTestData("masterCardSuccessful", CreditCardData.class);
    }

    @Step("TestData for merchant supported paypal payment")
    public static TestData buyMerchantSupportedPaypalPayment(){
        return new TestData().addTestData("mobileAccountPayment_"+platformName+"_"+browserName, UserAccountData.class)
                .addTestData("buyOnlyPaypal", EngagementLinkData.class)
                .addTestData("payPalDetails", PayPalData.class);

    }

    @Step("TestData for address validation ")
    public static TestData addressValidationCase(){
        AddressData germanAddress = getDataObject("utfAddress", AddressData.class);
        germanAddress.setNickName(RandomGenerator.getRandomText(4)+"_ Ä ä Ö ö Ü ü ẞ ß");
        CreditCardData creditCardData = getDataObject("masterCardSuccessful", CreditCardData.class);
        creditCardData.setNameOnCard(RandomGenerator.getRandomText(5)+" ÄäÖ öÜüẞß");
        return new TestData().addTestData("mobileAccountAddress_"+platformName+"_"+browserName, UserAccountData.class)
                .addTestData("buyEngagementLinkCard", EngagementLinkData.class)
                .addTestData(germanAddress)
                .addTestData(creditCardData);

    }
    @Step("TestData for the Pick in store with mobile number")
    public static TestData buyPickInStoreByMobileLoginCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyPickupInStore", EngagementLinkData.class)
                .addTestData("masterCardSuccessful", CreditCardData.class);
    }

    @Step("TestData for the Unit Price Without Tax with mobile number")
    public static TestData buyUnitPriceWithoutTaxCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyWithoutTax", EngagementLinkData.class)
                .addTestData("payPalDetails", PayPalData.class);
    }
    @Step("TestData for the Unit Price Tax with mobile number")
    public static TestData buyUnitPriceWithTaxCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyWithTax", EngagementLinkData.class)
                .addTestData("payPalDetails", PayPalData.class);
    }
    @Step("TestData for the Product Details and Order Summary")
    public static TestData productDetailsAndOrderSummaryCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyEngagementLink", EngagementLinkData.class)
                .addTestData("icMerchant",MerchantData.class)
                .addTestData("masterCardSuccessful", CreditCardData.class);
    }

    @Step("TestData for the localization testing German")
    public static TestData localizationGermanCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyEngagementLink", EngagementLinkData.class)
                .addTestData("icMerchant",MerchantData.class)
                .addTestData("masterCardSuccessful", CreditCardData.class)
                .addTestData("germanString", LocalizationData.class);
    }

    @Step("TestData for the Google Account test case with PayPal")
    public static TestData buyGoogleAccountWithPayPalCase(){
        return new TestData().addTestData(getDataObject("gmailAccount", UserAccountData.class))
                .addTestData("buyEngagementLink", EngagementLinkData.class)
                .addTestData("payPalDetails", PayPalData.class);
    }

    @Step("TestData for the Phone Number test case with PayPal")
    public static TestData buyPhoneNumberWithPayPalCase(){
        return new TestData().addTestData(getMobileAccountPayPal())
                .addTestData("buyOnlyPaypal", EngagementLinkData.class)
                .addTestData("payPalDetails", PayPalData.class);
    }

    @Step("TestData for the Phone Number & Collect in store test case with PayPal")
    public static TestData buyPhoneNumberCollectInStoreWithPayPalCase(){
        return new TestData().addTestData(getMobileAccountPayPal())
                .addTestData("buyPickupInStore", EngagementLinkData.class)
                .addTestData("payPalDetails", PayPalData.class);
    }

    @Step("TestData for the Facebook Account test case")
    public static TestData buyFacebookAccountCase(){
        return new TestData().addTestData(getDataObject("facebookAccount", UserAccountData.class))
                .addTestData("buyEngagementLink", EngagementLinkData.class)
                .addTestData("masterCardSuccessful", CreditCardData.class);
    }

    @Step("TestData for the Google Account test case")
    public static TestData actGoogleAccountCase(){
        return new TestData().addTestData(getDataObject("gmailAccount", UserAccountData.class))
                .addTestData("actEngagementLink", EngagementLinkData.class)
                .addTestData("masterCardSuccessful", CreditCardData.class);
    }

    @Step("TestData for Add Address and validate UTF-8")
    public static TestData addAddressTestCase(){
        return new TestData().addTestData(getDataObject("gmailAccount", UserAccountData.class))
                .addTestData("actEngagementLink", EngagementLinkData.class)
                .addTestData("masterCardSuccessful", CreditCardData.class);
    }

    @Step("TestData for new buy engagement case")
    public static TestData createNewBuyEngagementCase(){
        RxpNewTargetData rxpNewTargetData = RxpNewTargetData.builder().yourReference(RandomGenerator.getRandomText(7)+"_Automation")
                .promotionalTitle(RandomGenerator.getRandomText(7))
                .promotionalSubTitle(RandomGenerator.getRandomText(7)).build();
        RxpEngagementData rxpEngagementData = RxpEngagementData.builder().name(RandomGenerator.getRandomText(6) + "_Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginData.class))
                .addTestData(rxpNewTargetData)
                .addTestData(getDataObject("buyProduct", RxpProductData.class))
                .addTestData(rxpEngagementData)
                ;

    }


    @Step("TestData for new buy engagement case from saved targets")
    public static TestData createNewBuyEngagementCaseFromSavedTargets(){
        RxpEngagementData rxpEngagementData = RxpEngagementData.builder().name(RandomGenerator.getRandomText(6) + "_Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginData.class))
                .addTestData(getDataObject("buyTargetSimple", RxpTargetData.class))
                .addTestData(getDataObject("buyProduct", RxpProductData.class))
                .addTestData(getDataObject("buyEngagementSmartLinkProduct", EngagementLinkData.class))
                .addTestData(rxpEngagementData);

    }

    @Step("TestData for new act engagement case from saved targets")
    public static TestData createNewActEngagementCaseFromSavedTargets(){
        RxpEngagementData rxpEngagementData = RxpEngagementData.builder().name(RandomGenerator.getRandomText(6) + "_Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginData.class))
                .addTestData(getDataObject("actTarget", RxpTargetData.class))
                .addTestData(getDataObject("actTitle", RxpProductData.class))
                .addTestData(getDataObject("actEngagementSmartLinkTitle", EngagementLinkData.class))
                .addTestData(rxpEngagementData)
                .addTestData(getMobileNumber());

    }

    @Step("TestData for smart code mobile")
    public static TestData smartCodeMobileCases(){
        RxpEngagementData rxpEngagementData = RxpEngagementData.builder().name(RandomGenerator.getRandomText(6) + "_Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginData.class))
                .addTestData(getDataObject("actTarget", RxpTargetData.class))
                .addTestData(getDataObject("actTitle", RxpProductData.class))
                .addTestData(getDataObject("actEngagementSmartLinkTitle", EngagementLinkData.class))
                .addTestData(rxpEngagementData)
                .addTestData(getMobileNumber());

    }


    @Step("TestData for new act engagement case")
    public static TestData createNewActEngagementCase(){
        RxpNewTargetData rxpNewTargetData = RxpNewTargetData.builder().yourReference(RandomGenerator.getRandomText(10))
                .promotionalTitle(RandomGenerator.getRandomText(7))
                .promotionalSubTitle(RandomGenerator.getRandomText(7)).build();
        RxpEngagementData rxpEngagementData = RxpEngagementData.builder().name(RandomGenerator.getRandomText(6) + "Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginData.class))
                .addTestData(rxpNewTargetData)
                .addTestData(rxpEngagementData);

    }

    @Step("TestData for the Facebook Account test case")
    public static TestData actFacebookAccountCase(){
        return new TestData().addTestData(getDataObject("facebookAccount", UserAccountData.class))
                .addTestData("actEngagementLink", EngagementLinkData.class)
                .addTestData("masterCardSuccessful", CreditCardData.class);
    }

    @Step("TestData for the Phone Account test case")
    public static TestData actPhoneNumberCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("actEngagementLink", EngagementLinkData.class);
    }

    @Step("TestData for the Act to validate Mandatory and Older date")
    public static TestData actMandatoryOldDateCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("actEngagementDateAndMandatory", EngagementLinkData.class);
    }

}
