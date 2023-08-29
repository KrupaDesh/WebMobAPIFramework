package com.rezolve.web.ic.tests.eu;

import engine.TestData;
import engine.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rezolve.web.ic.model.AddressData;
import com.rezolve.web.ic.model.EngagementLinkData;
import com.rezolve.web.ic.pages.*;

import static com.rezolve.web.ic.model.TestDataArranger.*;

public class AddressValidationTests extends BaseTest {


   @Test(description = "Add new Address and validate the UTF-8 (Umlauts) ", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void addNewAddress(){
       TestData testData = addressValidationCase();
       AddressData addressData = testData.getTestData(AddressData.class);
       maximizeWindow();
       driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
       new ProductDetailsPage().clickInstantBuy();
       new SignInOptionsPage().clickPhoneNumber().login(testData);
       AddressPage addressPage = new ProductDetailsPage().changeAddress().clickAddAnAddress().enterAddressDetails(testData).clickContinueButton();
       String newlyAddedAddress = addressPage.waitToLoadPage().getNewlyAddedAddress();
       Assert.assertTrue(addressPage.getNewlyAddedAddressNickName().equals(addressData.getNickName()), "Address nick name mismatch");
       Assert.assertTrue(newlyAddedAddress.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
       Assert.assertTrue(newlyAddedAddress.contains(addressData.getAddressLine2()), "Address Line 2 mismatch");
       Assert.assertTrue(newlyAddedAddress.contains(addressData.getCity()), "City mismatch");
     //  Assert.assertTrue(newlyAddedAddress.contains(addressData.getState()), "State mismatch"); // Address is not displaying State
       Assert.assertTrue(newlyAddedAddress.contains(addressData.getZip()), "zip mismatch");
       addressPage.clickContinueButton();
       // This is for credit card UTF validation
      // new ProductDetailsPage().increaseQuantity().changePayment().addNewCard().enterCardDetails(testData).clickSaveCard().clickDone().clickInstantBuy();
       new ProductDetailsPage().increaseQuantity().enterCvv("123").clickInstantBuy();
      Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");
      String address = new OrderSummaryPage().getAddress();
      Assert.assertTrue(address.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
      Assert.assertTrue(address.contains(addressData.getAddressLine2()), "Address Line 2 mismatch");
      Assert.assertTrue(address.contains(addressData.getCity()), "City mismatch");
     // Assert.assertTrue(address.contains(addressData.getCountry()), "Country mismatch");

   }


   //Zip code in order summary is not showing
    @Test(description = "Address - Validate mandatory fields error message then add address with only mandatory fields ", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void addressErrorValidationAndAddAddressWithOnlyMandatoryFields(){
        TestData testData = addressValidationCase();
        AddressData addressData = testData.getTestData(AddressData.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        new ProductDetailsPage().clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        AddressPage addressPage = new ProductDetailsPage().changeAddress().clickAddAnAddress();
        Assert.assertTrue(addressPage.verifyErrorMessageForEmptyMandatoryFields(testData), "Mandatory field error message is not working. Ref Screenshot");
        addressPage.enterMandatoryFields(testData).clickContinueButton();
        String newlyAddedAddress = addressPage.waitToLoadPage().getNewlyAddedAddress();
        Assert.assertTrue(addressPage.getNewlyAddedAddressNickName().equals(addressData.getNickName()), "Address nick name mismatch");
        Assert.assertTrue(newlyAddedAddress.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
        Assert.assertTrue(newlyAddedAddress.contains(addressData.getZip()), "zip mismatch");
        addressPage.clickContinueButton();
        new ProductDetailsPage().increaseQuantity().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");
        String address = new OrderSummaryPage().getAddress();
        Assert.assertTrue(address.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
        Assert.assertTrue(address.contains(addressData.getCountry()), "Country mismatch");

    }

}
