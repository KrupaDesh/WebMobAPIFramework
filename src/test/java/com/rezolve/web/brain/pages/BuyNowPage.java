package com.rezolve.web.brain.pages;

import com.rezolve.web.icv2.model.EngagementLinkDataICv2;
import com.rezolve.web.icv2.model.UserAccountDataICv2;
import com.rezolve.web.icv2.pages.OrderSummaryPageICv2;
import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;

import static engine.core.Element.elementByXpath;

public class BuyNowPage extends BasePage {

    Element productName = elementByXpath("//div/h1");
    Element buyNowButton = elementByXpath("//button[@type=\"submit\"]");
    Element successfulOrderConfirmationLayout = elementByXpath("//ic-order-placed/div");
    Element buyNowPageShippingAddress = elementByXpath("//ic-product-checkout/div[1]/div/div[2]/div/div/div[2]/div[2]");
    Element buyNowPageCardDetails = elementByXpath("//ic-product-checkout/div[2]/div/div[2]/div/div[2]/div[1]");
    Element orderSummaryPageShippingAddress = elementByXpath("//ic-order-placed//div[3]/div[2]/div");
    Element orderSummaryPageCardDetails = elementByXpath("//ic-order-placed/div/div[2]/div[3]/div[5]/div[2]/div");
    Element viewWebsite = elementByXpath("//ic-order-placed//button");
    @Step("Get Product Name")
    public String getTrimmedProductName() {
        String productNameOnBuyNowPage = productName.waitUntilElementVisible(25).getText().replaceAll("\\(", "").replaceAll("\\)","").replaceAll("\\+","").trim();
        screenshot();
        return productNameOnBuyNowPage;
    }
    @Step("Get Product Name")
    public String getProductName() {
        String productNameOnBuyNowPage = productName.waitUntilElementVisible(25).getText();
        screenshot();
        return productNameOnBuyNowPage;
    }
    @Step("Get Shipping Address")
    public String getShippingAddress() {
        String[] productNameOnBuyNowPage = buyNowPageShippingAddress.waitUntilElementVisible(25).getText().split(":");
        return productNameOnBuyNowPage[1].trim();
    }
    @Step("Get Card Details")
    public String getCardDetails() {
        String productNameOnBuyNowPage = buyNowPageCardDetails.waitUntilElementVisible(25).getText();
        screenshot();
        return productNameOnBuyNowPage;
    }
    @Step("Click Buy Now")
    public BuyNowPage clickBuyNow() {
        buyNowButton.waitUntilElementClickable(25).click();
        return this;
    }
    @SneakyThrows
    @Step("Click on Buy Now button")
    public void clickInstantBuy(){
       // Thread.sleep(5000);
        buyNowButton.waitUntilElementVisible(60).waitUntilElementClickable(60);
        screenshot();
        buyNowButton.click();
    }
    @Step("Get successful order confirmation status")
    public boolean isOrderSuccessful(){
        successfulOrderConfirmationLayout.waitUntilElementVisible(120);
        screenshot();
        return successfulOrderConfirmationLayout.isElementDisplayed();
    }
    @Step("Verify the product name in Order Summary")
    public boolean isOrderedProductNameCorrectInSummary(String productName){
        screenshot();
        return elementByXpath("//div[text()='"+productName+"']").isElementDisplayed();
    }
    @Step("Get the quantity in Order Summary")
    public String getQuantity(String productName){
        return elementByXpath("//div[text()='"+productName+"']/../div[2]").getText();
    }
    @Step("Verify the shipping address in Order Summary")
    public boolean isShippingAddressCorrect(String address){
        screenshot();
        return orderSummaryPageShippingAddress.getText().contains(address);
    }
    @Step("Verify the Card Details in Order Summary")
    public boolean isCardDetailsCorrect(String card){
        screenshot();
        return orderSummaryPageCardDetails.getText().contains(card);
    }
    @Step("Verify View WebSite Button Displayed in Order Summary")
    public boolean isViewWebSiteButtonDisplayed(){
        boolean result = viewWebsite.scrollDownUtillFindElement().isElementDisplayed();
        screenshot();
        return result;
    }
    @Step("Click on View Website")
    public void clickViewWebsite(){
        viewWebsite.click();
    }

}
