package com.rezolve.web.icv2.tests.eu;

import com.rezolve.web.icv2.pages.*;
import engine.TestData;
import engine.core.BaseTest;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rezolve.web.icv2.model.AddressDataICv2;
import com.rezolve.web.icv2.model.EngagementLinkDataICv2;

import javax.swing.plaf.synth.SynthTabbedPaneUI;

import static com.rezolve.web.icv2.model.TestDataICv2.*;

public class AddressValidationTestsICv2 extends BaseTest {


   @SneakyThrows
   @Test(priority = 0, description = "Add new Address and validate the UTF-8 (Umlauts) ", groups = {"ICv2_EU_Desk_Regression_add","ICv2_EU_Mobile_Regression"})
    public void addNewAddress(){
       TestData testData = addressValidationCasewithPaypal();
       AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
       maximizeWindow();
       driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
       //zoomInWebPage();
       new ProductDetailsPageICv2().clickInstantBuy();
       new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
       AddressPageICv2 addressPage = new ProductDetailsPageICv2().waitToPageLoad().changeAddress().clickAddAnAddress().enterAddressDetails(testData).clickContinueButton();
       String newlyAddedAddress = addressPage.waitToLoadPage().getNewlyAddedAddress();
       System.out.println("New added Address: "+newlyAddedAddress);
       //Assert.assertTrue(addressPage.getNewlyAddedAddressNickName().equals(addressData.getNickName()), "Address nick name mismatch");
       Assert.assertTrue(addressPage.getNewlyAddedAddressNickName().contains(addressData.getNickName()), "Address nick name mismatch");
       Assert.assertTrue(newlyAddedAddress.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
       Assert.assertTrue(newlyAddedAddress.contains(addressData.getAddressLine2()), "Address Line 2 mismatch");
       Assert.assertTrue(newlyAddedAddress.contains(addressData.getCity()), "City mismatch");
     //  Assert.assertTrue(newlyAddedAddress.contains(addressData.getState()), "State mismatch"); // Address is not displaying State
       Assert.assertTrue(newlyAddedAddress.contains(addressData.getZip()), "zip mismatch");
       addressPage.clickconfirmDeliveryAddressButton();
       // This is for credit card UTF validation
      // new ProductDetailsPage().increaseQuantity().changePayment().addNewCard().enterCardDetails(testData).clickSaveCard().clickDone().clickInstantBuy();
       //new ProductDetailsPageICv2().increaseQuantity().enterCvv("123").clickInstantBuy(); //Commenting due to CVV input issue
       new ProductDetailsPageICv2().waitToPageLoad().increaseQuantity();
       new ProductDetailsPageICv2().changePayment().selectPayPal().clickDone().clickInstantBuy();
       new PayPalPageICv2().completePayment(testData);

      Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
      String address = new OrderSummaryPageICv2().getAddress();
      Assert.assertTrue(address.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
      Assert.assertTrue(address.contains(addressData.getAddressLine2()), "Address Line 2 mismatch");
      Assert.assertTrue(address.contains(addressData.getCity()), "City mismatch");
     // Assert.assertTrue(address.contains(addressData.getCountry()), "Country mismatch");
   }

   //Zip code in order summary is not showing
    @Test(description = "Address - Validate mandatory fields error message then add address with only mandatory fields ", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})

    public void addressErrorValidationAndAddAddressWithOnlyMandatoryFields(){
        TestData testData = addressValidationCasewithPaypal();
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        AddressPageICv2 addressPage = new ProductDetailsPageICv2().changeAddress().clickAddAnAddress();
        Assert.assertTrue(addressPage.verifyErrorMessageForEmptyMandatoryFields(testData), "Mandatory field error message is not working. Ref Screenshot");
        addressPage.enterMandatoryFields(testData).clickContinueButton();
        String newlyAddedAddress = addressPage.waitToLoadPage().getNewlyAddedAddress();
        Assert.assertTrue(addressPage.getNewlyAddedAddressNickName().contains(addressData.getNickName()), "Address nick name mismatch");
        Assert.assertTrue(newlyAddedAddress.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
        Assert.assertTrue(newlyAddedAddress.contains(addressData.getZip()), "zip mismatch");
        addressPage.clickconfirmDeliveryAddressButton();
        //new ProductDetailsPageICv2().increaseQuantity().enterCvv("123").clickInstantBuy();
        new ProductDetailsPageICv2().waitToPageLoad().increaseQuantity();
        new ProductDetailsPageICv2().changePayment().selectPayPal().clickDone().clickInstantBuy();
        new PayPalPageICv2().completePayment(testData);

        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
        String address = new OrderSummaryPageICv2().getAddress();
        Assert.assertTrue(address.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
       // Assert.assertTrue(address.contains(addressData.getCountry()), "Country mismatch");

    }

    @Test(priority = 1, description = "User should be able to edit an existing saved address",groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void editExistingAddress()
    {
        TestData testData = generalAddressValidationCase();
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        AddressPageICv2 addressPage =  new ProductDetailsPageICv2().changeAddress().editFirstAddressDetails(testData).clickContinueButton();
        String newlyAddedAddress = addressPage.waitToLoadPage().getNewlyAddedAddress();
        Assert.assertTrue(addressPage.getNewlyAddedAddressNickName().contains(addressData.getNickName()), "Address nick name mismatch");
        Assert.assertTrue(addressPage.getNewlyAddedAddressNickName().contains(addressData.getNickName()), "Address nick name mismatch");
        Assert.assertTrue(newlyAddedAddress.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
        Assert.assertTrue(newlyAddedAddress.contains(addressData.getAddressLine2()), "Address Line 2 mismatch");
        Assert.assertTrue(newlyAddedAddress.contains(addressData.getCity()), "City mismatch");
        Assert.assertTrue(newlyAddedAddress.contains(addressData.getZip()), "zip mismatch");

    }

    @Test(dependsOnMethods ="editExistingAddress", description = "User should be able to delete an existing saved address",groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void deleteExistingAddress()
    {
        TestData testData = generalAddressValidationCase();
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        AddressPageICv2 addressPage =  new ProductDetailsPageICv2().changeAddress();
        String newlyAddedAddress = addressPage.waitToLoadPage().getNewlyAddedAddress();
        addressPage.deleteFirstAddressDetails(testData);
    }

    @Test(description = "User click on Use my location then address fields gets filled automatically",groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void addressUseMyLocation()
    {
        TestData testData = generalAddressValidationCase();
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        AddressPageICv2 addressPage =  new ProductDetailsPageICv2().changeAddress().clickAddAnAddress().useMyLocationforAddress(testData).clickDoneButton();
        String newlyAddedAddress = addressPage.waitToLoadPage().getNewlyAddedAddress();
        Assert.assertTrue(!newlyAddedAddress.isEmpty());
    }

}
