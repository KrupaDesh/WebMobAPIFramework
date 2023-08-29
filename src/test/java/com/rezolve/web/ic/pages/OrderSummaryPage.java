package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.testng.asserts.SoftAssert;
import com.rezolve.web.ic.model.EngagementLinkData;
import com.rezolve.web.ic.model.MerchantData;
import com.rezolve.web.ic.model.UserAccountData;

import static engine.core.Element.elementByXpath;

public class OrderSummaryPage  extends BasePage {


    Element successfulOrderConfrimationLayout = elementByXpath("//rezolve-frontend-final-order-success");
    Element orderConfirmation = elementByXpath("//rezolve-frontend-final-order-success/span/span[1]");
    Element orderReceivedMessage = elementByXpath("//rezolve-frontend-final-order-success/span/span[2]");
    Element emailConfirmationMessage = elementByXpath("//rezolve-frontend-final-order-success/span/span[3]");
    Element shippingAddress = elementByXpath("//rezolve-frontend-order-success-shipping//span[2]");
    Element viewWebsite = elementByXpath("//rezolve-frontend-form-submit-button/button");

    Element actSubmitMessage = elementByXpath("(//rezolve-frontend-final-order-success/span/span)[1]");
    Element actSubmitSuccessfulMessage = elementByXpath("(//rezolve-frontend-final-order-success/span/span)[2]");
    Element summaryText = elementByXpath("(//rezolve-frontend-final-order-success/../div/div[1]/span)[1]");

    Element nameElementTitle = elementByXpath("(//rezolve-frontend-final-order-success/../div/div[1]/span[2]/span)[1]");
    Element nameElementText = elementByXpath("(//rezolve-frontend-final-order-success/../div/div[1]/span[2]/span)[2]");
    Element dateElementTitle = elementByXpath("(//rezolve-frontend-final-order-success/../div/div[1]/span[3]/span)[1]");
    Element dateElementText = elementByXpath("(//rezolve-frontend-final-order-success/../div/div[1]/span[3]/span)[2]");
    Element contactInfoText = elementByXpath("(//rezolve-frontend-final-order-success/../div/div[2]/span)[1]");
    Element userName = elementByXpath("//rezolve-frontend-final-order-success/../div/div[2]/span[2]");
    Element userEmailID = elementByXpath("//rezolve-frontend-final-order-success/../div/div[2]/span[3]");

    Element orderConfirmationLabel = elementByXpath("(//rezolve-frontend-final-order-success//span)[2]");
    Element emailSentLabel = elementByXpath("(//rezolve-frontend-final-order-success//span)[4]");
    Element deliveryToAddressLabel = elementByXpath("//rezolve-frontend-order-success-shipping//span[1]");
    Element viewWebsiteLabel = elementByXpath("//rezolve-frontend-form-submit-button/button/span/span");
    Element orderCancelled = elementByXpath("(//rezolve-frontend-payment-canceled-error-page//span)[1]");
    Element yourOrderHasBeenCancelled = elementByXpath("(//rezolve-frontend-payment-canceled-error-page//span)[2]");



    @Step("Get Order Confirmation label")
    public String getOrderConfirmLabel(){
        return orderConfirmationLabel.getText();
    }
    @Step("Get Order Cancel label")
    public String getOrderCancelled(){
        return orderCancelled.getText();
    }
    @Step("Get Your Order Has Been Cancelled label")
    public String getYourOrderHasBeenCancelled(){
        return yourOrderHasBeenCancelled.getText();
    }
    @Step("Get Email Sent label")
    public String getEmailSentLabel(){
        return emailSentLabel.getText();
    }

    @Step("Get Delivery To Address Label")
    public String getDeliveryToAddressLabel(){
        return deliveryToAddressLabel.getText();
    }

    @Step("Get View Website Label")
    public String getViewWebsiteLabel(){
        return viewWebsiteLabel.getText();
    }

    @Step("Get successful order confirmation status")
    public boolean isOrderSuccessful(){
            successfulOrderConfrimationLayout.waitUntilElementVisible(120);
            screenshot();
            return successfulOrderConfrimationLayout.isElementDisplayed();
        }

    @Step("Verify the product name in Order Summary")
    public boolean isOrderProductNameInSummary(TestData testData){
        String productName = testData.getTestData(EngagementLinkData.class).getProductName();
        screenshot();
       return elementByXpath("//span[text()='"+productName+"']").isElementDisplayed();
    }

    @Step("Get the quantity in Order Summary")
    public String getQuantity(TestData testData){
        String productName = testData.getTestData(EngagementLinkData.class).getProductName();
        return elementByXpath("//span[text()='"+productName+"']/../span[1]").getText().split(" ")[0];
    }


    @Step("Verify the merchant details in Order Summary")
    public boolean isMerchantDetailsDisplayed(TestData testData){
        MerchantData merchantData = testData.getTestData(MerchantData.class);
        if(  elementByXpath("//span[text()='"+merchantData.getMerchantName()+"']").scrollDownUtillFindElement().isElementDisplayed()
                && elementByXpath("//span[text()='"+merchantData.getPhoneNumber()+"']").isElementDisplayed()){
            screenshot();
            return  true;
        }else {
            screenshot();
            return  false;
        }

    }

    @Step("Verify the shipping address in Order Summary")
    public boolean isShippingAddressCorrect(TestData testData){
            String address = testData.getTestData(UserAccountData.class).getAddress();
            screenshot();
       return shippingAddress.getText().contains(address);
    }

    @Step("Get Address")
    public String getAddress(){
        screenshot();
        return shippingAddress.getText();
    }

    @Step("Click on View Website")
    public OrderSummaryPage clickViewWebsite(){
            viewWebsite.click();
        return this;
    }

    @SneakyThrows
    @Step("Verify the view website is landed on merchant site")
    public boolean isNaviagteToMerchantSite(TestData testData){
        MerchantData merchantData = testData.getTestData(MerchantData.class);
        Thread.sleep(3000);
         screenshot();
         return driver.getCurrentUrl().equals(merchantData.getWebsite());
    }


    @Step("Verfiy the ACT Submission success details - Only the element validation no text validation")
    public SoftAssert verifyActSubmission(TestData testData){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actSubmitMessage.waitUntilElementVisible(30).isElementDisplayed());
        softAssert.assertTrue(actSubmitSuccessfulMessage.isElementDisplayed());
        softAssert.assertTrue(summaryText.isElementDisplayed());
        softAssert.assertTrue(nameElementText.isElementDisplayed());
        softAssert.assertTrue(nameElementTitle.isElementDisplayed());
        softAssert.assertTrue(dateElementTitle.isElementDisplayed());
        softAssert.assertTrue(dateElementText.isElementDisplayed());
        softAssert.assertTrue(contactInfoText.isElementDisplayed());
        softAssert.assertTrue(userEmailID.isElementDisplayed());
        screenshot();
        return  softAssert;




    }






}
