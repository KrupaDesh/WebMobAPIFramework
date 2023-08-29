package com.rezolve.web.icv2.tests.eu;

import com.rezolve.web.icv2.model.AddressDataICv2;
import com.rezolve.web.icv2.model.CreditCardDataICv2;
import com.rezolve.web.icv2.model.EngagementLinkDataICv2;
import com.rezolve.web.icv2.pages.*;
import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.rezolve.web.icv2.model.TestDataICv2.*;

public class ProdsantiyICv2 extends BaseTest {
    

        @SneakyThrows
        @Test(priority = 1, description = "Buy the product by using Facebook Account", groups = {"ICv2_EU_Desk_Regression_Prod","ICv2_EU_Mobile_Regression_Prod"})
        public void buyProductByFacebookAccountWithExistingCard(){
            BasePage basePage = new BasePage();
            TestData testData = buyFacebookAccountCase();
            driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
            maximizeWindow();
            new ProductDetailsPageICv2().clickInstantBuy();
            new SignInOptionsPageICv2().clickFacebook(testData);

            new ProductDetailsPageICv2().waitToPageLoad().selectAddressIfNot();
            new ProductDetailsPageICv2().changePayment().selectCreditCard(testData).clickDone().clickInstantBuy();
            Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");

        }
        @SneakyThrows
        @Test(priority = 1,description = "Buy the product then Collect in store by using Facebook Account with credit card", groups = {"ICv2_EU_Desk_Regression_Prod","ICv2_EU_Mobile_Regression_Prod"})
        public void buyProductCollectInStoreByFacebookAccount(){
            BasePage basePage = new BasePage();
            TestData testData = buyFaceBookAccountCollectInStoreWithCreditCardCase();
            driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
            maximizeWindow();
            new ProductDetailsPageICv2().waitToPageLoad().setConfig(testData).clickInstantBuy();
            new SignInOptionsPageICv2().clickFacebook(testData);
            new ProductDetailsPageICv2().waitToPageLoad().selectAddressIfNot().changeDeliveryOptionToCollectInStore().clickInstantBuy();
            Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
        }

        @Test(priority = 3, description = "Add new Address and validate", groups = {"ICv2_EU_Desk_Regression_Prod","ICv2_EU_Mobile_Regression_Prod"})
        public void addNewGeneralAddress(){
            TestData testData = generalAddressValidationFacebookAccountCase();
            AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
            maximizeWindow();
            driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
            new ProductDetailsPageICv2().clickInstantBuy();
            //new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
            new SignInOptionsPageICv2().clickFacebook(testData);
            AddressPageICv2 addressPage = new ProductDetailsPageICv2().waitToPageLoad().changeAddress();
            new ProductDetailsPageICv2().changeDeliveryOptionToSendToAddress().changeAddress();
            addressPage.clickAddAnAddress().enterAddressDetails(testData).clickContinueButton();
            String newlyAddedAddress = addressPage.waitToLoadPage().getNewlyAddedAddress();
            System.out.println("New Address: "+newlyAddedAddress);
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
            new ProductDetailsPageICv2().increaseQuantity().clickInstantBuy();//CVV should be mandate
            //new ProductDetailsPageICv2().increaseQuantity().enterCvv("123").clickInstantBuy();
            Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
            String address = new OrderSummaryPageICv2().getAddress();
            Assert.assertTrue(address.contains(addressData.getAddressLine1()), "Address Line 1 mismatch");
            Assert.assertTrue(address.contains(addressData.getAddressLine2()), "Address Line 2 mismatch");
            Assert.assertTrue(address.contains(addressData.getCity()), "City mismatch");
            // Assert.assertTrue(address.contains(addressData.getCountry()), "Country mismatch");

        }
        @SneakyThrows
        @Test(priority = 4, description = "User should be able to delete an existing saved address",groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
        public void deleteExistingAddress()
        {
            BasePage basePage = new BasePage();
            TestData testData = generalAddressValidationFacebookAccountCase();
            AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
            maximizeWindow();
            driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
            new ProductDetailsPageICv2().clickInstantBuy();
            //new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
            new SignInOptionsPageICv2().clickFacebook(testData);
            AddressPageICv2 addressPage =  new ProductDetailsPageICv2().changeAddress();
            addressPage.deleteFirstAddressDetails(testData);
        }
        @SneakyThrows
        @Test(priority = 4,description = "Add New Card and Delete Added Card", groups = {"ICv2_EU_Desk_Regression_Prod","ICv2_EU_Mobile_Regression_Prod"})
        public void addNewCardAndDeleteCardWithFacebookAccount(){
            BasePage basePage = new BasePage();
            TestData testData = addCardTestCasewithFacebookAccount();
            driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
            maximizeWindow();
            new ProductDetailsPageICv2().clickInstantBuy();
            new SignInOptionsPageICv2().clickFacebook(testData);
            new ProductDetailsPageICv2().changePayment();

            //Add card
            CardPageICv2 cardPageICv2 = new CardPageICv2();
            cardPageICv2.clickOnAddNewCard().addNewCard(testData);
            new ProductDetailsPageICv2().changePayment();

            String newlyAddedCard = cardPageICv2.waitToLoadPage().getNewlyAddedCard();
            Assert.assertTrue(newlyAddedCard.contains(testData.getTestData(CreditCardDataICv2.class).getLastFourDigitOfCard()), "Card Number mismatch");
            Assert.assertTrue(newlyAddedCard.contains(testData.getTestData(CreditCardDataICv2.class).getExpires()), "Expiry date mismatch");
            Assert.assertTrue(newlyAddedCard.contains(testData.getTestData(CreditCardDataICv2.class).getType()), "Card type mismatch");

            //delete Card

            cardPageICv2.deleteCard();
            String deletedCard = cardPageICv2.waitToLoadPage().getNewlyAddedCard();
            Assert.assertFalse(deletedCard.contains(testData.getTestData(CreditCardDataICv2.class).getLastFourDigitOfCard()), "Card Not Deleted");
            Assert.assertFalse(deletedCard.contains(testData.getTestData(CreditCardDataICv2.class).getExpires()),"Card Not Deleted");
            Assert.assertFalse(deletedCard.contains(testData.getTestData(CreditCardDataICv2.class).getType()),"Card Not Deleted");
        }
        @Test(priority = 5,description = "Switching between payment methods", groups = {"ICv2_EU_Desk_Regression_Prod","ICv2_EU_Mobile_Regression_Prod"})
        public void switchingBetweenPaymentMethods() throws InterruptedException {
            BasePage basePage = new BasePage();
            TestData testData = addCardTestCasewithFacebookAccount();
            driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
            maximizeWindow();
            new ProductDetailsPageICv2().clickInstantBuy();
            new SignInOptionsPageICv2().clickFacebook(testData);
            new ProductDetailsPageICv2().changePayment();
            //Change payment method to Paypal
            new PaymentListPageICv2().selectPayPal().clickDone();

            new ProductDetailsPageICv2().waitToPageLoad().selectAddressIfNot().changePayment().selectExistingCard().clickDone();
        }


        @SneakyThrows
        @Test(priority = 5,description = "Switching between delivery methods by using Facebook Account", groups = {"ICv2_EU_Desk_Regression_Prod","ICv2_EU_Mobile_Regression_Prod"})
        public void switchingBetweenDeliverMethodsByFacebookAccount() {
            BasePage basePage = new BasePage();
            TestData testData = buyFacebookAccountCase();
            driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
            maximizeWindow();
            new ProductDetailsPageICv2().clickInstantBuy();
            new SignInOptionsPageICv2().clickFacebook(testData);
            new ProductDetailsPageICv2().changeAddress();
            new ProductDetailsPageICv2().waitToPageLoad().changeDeliveryOptionToCollectInStore();

        }


    }
