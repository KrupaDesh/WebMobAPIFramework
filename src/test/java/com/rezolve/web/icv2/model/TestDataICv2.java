package com.rezolve.web.icv2.model;

import engine.TestData;
import engine.core.BasePage;
import io.qameta.allure.Step;
import com.rezolve.RandomGenerator;

import static engine.reader.MyJsonReader.getDataObject;

public class TestDataICv2 {

    public static String platformName = new BasePage().getPlatformName().toLowerCase();
    public static String browserName = new BasePage().getBrowserName().toLowerCase();

    public static UserAccountDataICv2 getMobileNumber(){
        return getDataObject("mobileAccount_"+platformName+"_"+browserName, UserAccountDataICv2.class);
    }

    public static UserAccountDataICv2 getMobileAccountPayPal(){
        return getDataObject("mobileAccountPayPal_"+platformName+"_"+browserName, UserAccountDataICv2.class);
    }



    @Step("TestData for the Google Account test case")
    public static TestData buyGoogleAccountCase(){
        return new TestData().addTestData(getDataObject("gmailAccount", UserAccountDataICv2.class))
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
    }

    @Step("TestData for the Mobile Number test case")
    public static TestData buyMobileNumberCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
               // .addTestData("invalidOtpErrorMessage", UserAccountDataICv2.class);
    }
    @Step("TestData for merchant supported card payment")
    public static TestData buyMerchantSupportedPayment(){
        return new TestData().addTestData("mobileAccountPayment_"+platformName+"_"+browserName, UserAccountDataICv2.class)
                .addTestData("buyOnlyCreditCard", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
    }

    @Step("TestData for merchant supported paypal payment")
    public static TestData buyMerchantSupportedPaypalPayment(){
        return new TestData().addTestData("mobileAccountPayment_"+platformName+"_"+browserName, UserAccountDataICv2.class)
                .addTestData("buyOnlyPaypal", EngagementLinkDataICv2.class)
                .addTestData("payPalDetails", PayPalDataICv2.class);

    }

    @Step("TestData for address validation ")
    public static TestData addressValidationCase(){
        AddressDataICv2 germanAddress = getDataObject("utfAddress", AddressDataICv2.class);
        germanAddress.setNickName(RandomGenerator.getRandomText(4)+"_ Ä ä Ö ö Ü ü ẞß");
        CreditCardDataICv2 creditCardData = getDataObject("masterCardSuccessful", CreditCardDataICv2.class);
        creditCardData.setNameOnCard(RandomGenerator.getRandomText(5)+" ÄäÖ öÜüẞß");
        return new TestData().addTestData("mobileAccountAddress_"+platformName+"_"+browserName, UserAccountDataICv2.class)
                .addTestData("buyEngagementLinkCard", EngagementLinkDataICv2.class)
                .addTestData(germanAddress)
                .addTestData(creditCardData);

    }
    @Step("TestData for address validation ")
    public static TestData addressValidationCasewithPaypal(){
        AddressDataICv2 germanAddress = getDataObject("utfAddress", AddressDataICv2.class);
        germanAddress.setNickName(RandomGenerator.getRandomText(4)+"_ Ä ä Ö ö Ü ü ẞß");
        CreditCardDataICv2 creditCardData = getDataObject("masterCardSuccessful", CreditCardDataICv2.class);
        creditCardData.setNameOnCard(RandomGenerator.getRandomText(5)+" ÄäÖ öÜüẞß");
        return new TestData().addTestData("mobileAccountAddress_"+platformName+"_"+browserName, UserAccountDataICv2.class)
                .addTestData("buyEngagementLinkCard", EngagementLinkDataICv2.class)
                .addTestData(germanAddress)
                .addTestData("payPalDetails", PayPalDataICv2.class);

    }
    @Step("TestData for address validation ")
    public static TestData generalAddressValidationCase(){
        return new TestData().addTestData(getDataObject("facebookAccount", UserAccountDataICv2.class))
                .addTestData("generalAddress", AddressDataICv2.class)
                .addTestData("buyEngagementLinkCard", EngagementLinkDataICv2.class);

    }
    @Step("TestData for the Pick in store with mobile number")
    public static TestData buyPickInStoreByMobileLoginCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyPickupInStore", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
    }

    @Step("TestData for the Unit Price Without Tax with mobile number")
    public static TestData buyUnitPriceWithoutTaxCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyWithoutTax", EngagementLinkDataICv2.class)
                .addTestData("payPalDetails", PayPalDataICv2.class);
    }
    @Step("TestData for the Unit Price Tax with mobile number")
    public static TestData buyUnitPriceWithTaxCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyWithTax", EngagementLinkDataICv2.class)
                .addTestData("payPalDetails", PayPalDataICv2.class);
    }
    @Step("TestData for the Product Details and Order Summary")
    public static TestData productDetailsAndOrderSummaryCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("icMerchant", MerchantDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class)
                .addTestData("payPalDetails", PayPalDataICv2.class);
    }

    @Step("TestData for the localization testing German")
    public static TestData localizationGermanCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("icMerchant", MerchantDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class)
                .addTestData("germanString", LocalizationDataICv2.class);
    }

    @Step("TestData for the Google Account test case with PayPal")
    public static TestData buyGoogleAccountWithPayPalCase(){
        return new TestData().addTestData(getDataObject("gmailAccount", UserAccountDataICv2.class))
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("payPalDetails", PayPalDataICv2.class);
    }

    @Step("TestData for the Phone Number test case with PayPal")
    public static TestData buyPhoneNumberWithPayPalCase(){
        return new TestData().addTestData(getMobileAccountPayPal())
                .addTestData("buyOnlyPaypal", EngagementLinkDataICv2.class)
                .addTestData("payPalDetails", PayPalDataICv2.class);
    }

    @Step("TestData for the Phone Number & Collect in store test case with PayPal")
    public static TestData buyPhoneNumberCollectInStoreWithPayPalCase(){
        return new TestData().addTestData(getMobileAccountPayPal())
                .addTestData("buyPickupInStore", EngagementLinkDataICv2.class)
                .addTestData("payPalDetails", PayPalDataICv2.class);
    }

/*    //For Production sanity facebook cases
    @Step("TestData for the FacebookAccount & Collect in store test case with Credit Card")
    public static TestData buyFaceBookAccountCollectInStoreWithCreditCardCase(){
        return new TestData().addTestData(getDataObject("facebookAccount", UserAccountDataICv2.class))
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
    }*/


    //For demo sanity facebook cases
    @Step("TestData for the FacebookAccount & Collect in store test case with Credit Card")
    public static TestData buyFaceBookAccountCollectInStoreWithCreditCardCase(){
        return new TestData().addTestData(getDataObject("facebookAccount", UserAccountDataICv2.class))
                .addTestData("buyPickupInStore", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
    }

    @Step("TestData for address validation with FacebookAccount")
    public static TestData generalAddressValidationFacebookAccountCase(){
        return new TestData().addTestData(getDataObject("facebookAccount", UserAccountDataICv2.class))
                .addTestData("generalAddress", AddressDataICv2.class)
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class);

    }

    @Step("TestData for the Facebook Account test case")
    public static TestData buyFacebookAccountCase(){
        return new TestData().addTestData(getDataObject("facebookAccount", UserAccountDataICv2.class))
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
    }

    @Step("TestData for the Google Account test case")
    public static TestData actGoogleAccountCase(){
        return new TestData().addTestData(getDataObject("gmailAccount", UserAccountDataICv2.class))
                .addTestData("actEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
    }

    @Step("TestData for Add Address and validate UTF-8")
    public static TestData addAddressTestCase(){
        return new TestData().addTestData(getDataObject("gmailAccount", UserAccountDataICv2.class))
                .addTestData("actEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
    }

    @Step("TestData for new buy engagement case")
    public static TestData createNewBuyEngagementCase(){
        RxpNewTargetDataICv2 rxpNewTargetData = RxpNewTargetDataICv2.builder().yourReference(RandomGenerator.getRandomText(7)+"_Automation")
                .promotionalTitle(RandomGenerator.getRandomText(7))
                .promotionalSubTitle(RandomGenerator.getRandomText(7)).build();
        RxpEngagementDataICv2 rxpEngagementData = RxpEngagementDataICv2.builder().name(RandomGenerator.getRandomText(6) + "_Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginDataICv2.class))
                .addTestData(rxpNewTargetData)
                .addTestData(getDataObject("buyProduct", RxpProductDataICv2.class))
                .addTestData(rxpEngagementData);

    }


    @Step("TestData for new buy engagement case from saved targets")
    public static TestData createNewBuyEngagementCaseFromSavedTargets(){
        RxpEngagementDataICv2 rxpEngagementData = RxpEngagementDataICv2.builder().name(RandomGenerator.getRandomText(6) + "_Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginDataICv2.class))
                .addTestData(getDataObject("buyTargetSimple", RxpTargetDataICv2.class))
                .addTestData(getDataObject("buyProduct", RxpProductDataICv2.class))
                .addTestData(getDataObject("buyEngagementSmartLinkProduct", EngagementLinkDataICv2.class))
                .addTestData(rxpEngagementData);

    }

    @Step("TestData for new act engagement case from saved targets")
    public static TestData createNewActEngagementCaseFromSavedTargets(){
        RxpEngagementDataICv2 rxpEngagementData = RxpEngagementDataICv2.builder().name(RandomGenerator.getRandomText(6) + "_Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginDataICv2.class))
                .addTestData(getDataObject("actTarget", RxpTargetDataICv2.class))
                .addTestData(getDataObject("actTitle", RxpProductDataICv2.class))
                .addTestData(getDataObject("actEngagementSmartLinkTitle", EngagementLinkDataICv2.class))
                .addTestData(rxpEngagementData)
                .addTestData(getMobileNumber());

    }

    @Step("TestData for smart code mobile")
    public static TestData smartCodeMobileCases(){
        RxpEngagementDataICv2 rxpEngagementData = RxpEngagementDataICv2.builder().name(RandomGenerator.getRandomText(6) + "_Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginDataICv2.class))
                .addTestData(getDataObject("actTarget", RxpTargetDataICv2.class))
                .addTestData(getDataObject("actTitle", RxpProductDataICv2.class))
                .addTestData(getDataObject("actEngagementSmartLinkTitle", EngagementLinkDataICv2.class))
                .addTestData(rxpEngagementData)
                .addTestData(getMobileNumber());

    }


    @Step("TestData for new act engagement case")
    public static TestData createNewActEngagementCase(){
        RxpNewTargetDataICv2 rxpNewTargetData = RxpNewTargetDataICv2.builder().yourReference(RandomGenerator.getRandomText(10))
                .promotionalTitle(RandomGenerator.getRandomText(7))
                .promotionalSubTitle(RandomGenerator.getRandomText(7)).build();
        RxpEngagementDataICv2 rxpEngagementData = RxpEngagementDataICv2.builder().name(RandomGenerator.getRandomText(6) + "Automation").build();
        return new TestData().addTestData(getDataObject("rxpDetails", RxpUrlLoginDataICv2.class))
                .addTestData(rxpNewTargetData)
                .addTestData(rxpEngagementData);

    }

    @Step("TestData for the Facebook Account test case")
    public static TestData actFacebookAccountCase(){
        return new TestData().addTestData(getDataObject("facebookAccount", UserAccountDataICv2.class))
                .addTestData("actEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("masterCardSuccessful", CreditCardDataICv2.class);
    }

    @Step("TestData for the Phone Account test case")
    public static TestData actPhoneNumberCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("actEngagementLink", EngagementLinkDataICv2.class);
    }

    @Step("TestData for the Act to validate Mandatory and Older date")
    public static TestData actMandatoryOldDateCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("actEngagementDateAndMandatory", EngagementLinkDataICv2.class);
    }

    @Step("TestData for Add Card and Delete Card")
    public static TestData addCardTestCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("addCardAndDeleteCard", CreditCardDataICv2.class);
    }

    @Step("TestData for Add Card and Delete Card")
    public static TestData addCardTestCasewithFacebookAccount(){
        return new TestData().addTestData(getDataObject("facebookAccount", UserAccountDataICv2.class))
                .addTestData("buyEngagementLink", EngagementLinkDataICv2.class)
                .addTestData("addCardAndDeleteCard", CreditCardDataICv2.class);
    }
    @Step("TestData Out Of Stock Scenario")
    public static TestData outOfStockCase(){
        return new TestData().addTestData(getMobileNumber())
                .addTestData("outOfStock", EngagementLinkDataICv2.class);
    }

}

