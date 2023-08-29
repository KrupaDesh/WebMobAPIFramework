package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.testng.asserts.SoftAssert;
import com.rezolve.web.icv2.model.EngagementLinkDataICv2;
import com.rezolve.web.icv2.model.MerchantDataICv2;
import com.rezolve.web.icv2.model.UserAccountDataICv2;

import static engine.core.Element.elementByXpath;

public class OrderSummaryPageICv2 extends BasePage {


    Element successfulOrderConfrimationLayout = elementByXpath("//ic-order-placed/div");
    Element orderConfirmation = elementByXpath("//div[contains(text(), \"Thank you for\")]");
    Element orderReceivedMessage = elementByXpath("//rezolve-frontend-final-order-success/span/span[2]");
    Element emailConfirmationMessage = elementByXpath("//div/p[contains(text(), \"sent to your email\")]");
    Element shippingAddress = elementByXpath("//ic-order-placed//div[3]/div[2]/div");
    Element viewWebsite = elementByXpath("//ic-order-placed//button");

    Element actSubmitMessage = elementByXpath("//div[text()=\" Submitted \"]");
    Element actSubmitSuccessfulMessage = elementByXpath("//p[text()=\" Your response has been submitted successfully \"]");
    Element summaryText = elementByXpath("//div[text()=\" Your Answers \"]");

    Element nameElementTitle = elementByXpath("//ic-answer[1]/div/div");
    Element nameElementText = elementByXpath("//ic-answer[1]/div");
    Element dateElementTitle = elementByXpath("//ic-answer[2]/div/div");
    Element dateElementText = elementByXpath("//ic-answer[2]/div");
    Element contactInfoText = elementByXpath("//div[text()=\" Your Details \"]");
    Element userName = elementByXpath("//div[text()=\" Your Details \"]/../div[2]/div[2]");
    Element userEmailID = elementByXpath("//div[text()=\" Your Details \"]/../div[3]/div[2]");

    Element orderConfirmationLabel = elementByXpath("//div[contains(text(), \"Thank you for\")] | //div[contains(text(), \"Vielen Dank für\")]");
    Element emailSentLabel = elementByXpath("//p[contains(text(), \"email address\")] | //p[contains(text(), \"E-Mail-Adresse gesendet\")]");
    Element deliveryToAddressLabel = elementByXpath("//ic-order-placed//div[3]/div[1]/div[contains(text(),\"Deliver to\")] | //ic-order-placed//div[3]/div[1]/div[contains(text(),\"Liefern an\")]");
    Element viewWebsiteLabel = elementByXpath("(//div/button)[2]");
    Element orderCancelled = elementByXpath("(//ic-order-cancelled//span)[1]");
    Element yourOrderHasBeenCancelled = elementByXpath("(//ic-order-cancelled//span)[2]");



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
        String productName = testData.getTestData(EngagementLinkDataICv2.class).getProductName();
        screenshot();
       return elementByXpath("//div[text()='"+productName+"']").isElementDisplayed();
    }

    @Step("Get the quantity in Order Summary")
    public String getQuantity(TestData testData){
        String productName = testData.getTestData(EngagementLinkDataICv2.class).getProductName();
     // return elementByXpath("//div[text()='"+productName+"']/../div[2]").getText().split(" ")[2];
        return elementByXpath("//div[text()='"+productName+"']/../div[2]").getText();
    }


    @Step("Verify the merchant details in Order Summary")
    public boolean isMerchantDetailsDisplayed(TestData testData){
        MerchantDataICv2 merchantData = testData.getTestData(MerchantDataICv2.class);
        if(  elementByXpath("//div[text()='"+merchantData.getMerchantName()+"']").scrollDownUtillFindElement().isElementDisplayed()
                && elementByXpath("//div[text()='"+merchantData.getPhoneNumber()+"']").isElementDisplayed()){
            screenshot();
            return  true;
        }else {
            screenshot();
            return  false;
        }

    }

    @Step("Verify the shipping address in Order Summary")
    public boolean isShippingAddressCorrect(TestData testData){
            String address = testData.getTestData(UserAccountDataICv2.class).getAddress();
            screenshot();
       return shippingAddress.getText().contains(address);
    }

    @Step("Get Address")
    public String getAddress(){
        screenshot();
        return shippingAddress.getText();
    }

    @Step("Click on View Website")
    public OrderSummaryPageICv2 clickViewWebsite(){
            viewWebsite.click();
        return this;
    }

    @SneakyThrows
    @Step("Verify the view website is landed on merchant site")
    public boolean isNaviagteToMerchantSite(TestData testData){
        MerchantDataICv2 merchantData = testData.getTestData(MerchantDataICv2.class);
        Thread.sleep(3000);
         screenshot();
         return driver.getCurrentUrl().equals(merchantData.getWebsite());
    }


    @Step("Verfiy the ACT Submission success details - Only the element validation no text validation")
    public SoftAssert verifyActSubmission(TestData testData) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actSubmitMessage.waitUntilElementVisible(30).isElementDisplayed());
        softAssert.assertTrue(actSubmitSuccessfulMessage.isElementDisplayed());
        softAssert.assertTrue(summaryText.isElementDisplayed());
        softAssert.assertTrue(nameElementText.isElementDisplayed());
        softAssert.assertTrue(nameElementTitle.isElementDisplayed());
        softAssert.assertTrue(dateElementTitle.isElementDisplayed());
        softAssert.assertTrue(dateElementText.isElementDisplayed());
        softAssert.assertTrue(contactInfoText.isElementDisplayed());
        softAssert.assertTrue(userName.isElementDisplayed());
        softAssert.assertTrue(userEmailID.isElementDisplayed());
        screenshot();
        return  softAssert;
    }
}
