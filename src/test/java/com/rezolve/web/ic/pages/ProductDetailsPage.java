package com.rezolve.web.ic.pages;

import engine.LogHelper;
import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import com.rezolve.web.ic.model.CreditCardData;
import com.rezolve.web.ic.model.EngagementLinkData;
import com.rezolve.web.ic.model.UserAccountData;

import static engine.core.Element.elementByXpath;

public class ProductDetailsPage extends BasePage {

   Element instantBuyButton = elementByXpath("//rezolve-frontend-instant-buy-button/button");
   Element unitPriceNextToImage = elementByXpath("//rezolve-frontend-product-details//div//span/span[2]");
   Element instantBuyButtonLabel = elementByXpath("//rezolve-frontend-instant-buy-button/button/span/span");

   Element paymentLayout = elementByXpath("//rezolve-frontend-pay-using//rezolve-frontend-payment-checkout-button");
   Element paymentChangeButton = elementByXpath("//rezolve-frontend-pay-using//rezolve-frontend-payment-checkout-button//button");
   Element addressChangeButton = elementByXpath("(//rezolve-frontend-delivery-option//button)[1]");
   Element creditCardTile = elementByXpath("//rezolve-frontend-pay-using//rezolve-frontend-payment-button//span[text()=\"Credit Card\"]");
   Element paypalTile = elementByXpath("//rezolve-frontend-pay-using//rezolve-frontend-payment-button//span[text()=\"Pay Pal\"]");
   Element paypalSelected = elementByXpath("//rezolve-frontend-pay-using//rezolve-frontend-payment-checkout-button//span[text()=\"Pay Pal\"]");
   Element cvvInput = elementByXpath("//rezolve-frontend-payment-checkout-button//input");
   Element quantityElement = elementByXpath("//rezolve-frontend-quantity-input-filed");
   Element buttonIncreaseQuantity = elementByXpath("(//rezolve-frontend-quantity-input-filed//button)[2]");
   Element buttonDecreaseQuantity = elementByXpath("(//rezolve-frontend-quantity-input-filed//button)[1]");
   Element quantity = elementByXpath("//rezolve-frontend-quantity-input-filed//button/../span");
   Element deliveryAddress = elementByXpath("//rezolve-frontend-delivery-option//span[2]");
   Element collectInStore = elementByXpath("(//rezolve-frontend-payment-checkout-button[2]//span)");
   Element sendToAddress = elementByXpath("(//rezolve-frontend-payment-checkout-button[1]//span)");
   Element selectFirstStore = elementByXpath("(//rezolve-frontend-pickup-location//mat-radio-button)[1]");
   Element selectFirstAddress = elementByXpath("(//rezolve-frontend-address-list//mat-radio-button)[1]");
   Element doneButton = elementByXpath("//rezolve-frontend-form-submit-button//button");

   Element paymentCard = elementByXpath("//rezolve-frontend-pay-using//rezolve-frontend-payment-checkout-button//div/span[2]");
   Element seeMoreLess = elementByXpath("//rezolve-frontend-product-details//p/../button");
   Element descriptionMore = elementByXpath("//rezolve-frontend-product-details/div/p[contains(@class,\"show\")]");
   Element languageButton = elementByXpath("//rezolve-frontend-main-header//button");
   Element germanOption = elementByXpath("(//button[@role='menuitem'])[2]");
   Element englishOption = elementByXpath("(//button[@role='menuitem'])[1]");
   Element quantityLabel = elementByXpath("(//rezolve-frontend-quantity-input-filed/div/span)[1]");
   Element deliveryOptionLabel = elementByXpath("//rezolve-frontend-delivery-option/div/span");
   Element payUsingLabel = elementByXpath("//rezolve-frontend-pay-using/div/span");
   Element changeLabel = elementByXpath("//rezolve-frontend-delivery-option//button");
   Element sendToAddressLabel = elementByXpath("(//rezolve-frontend-delivery-option//rezolve-frontend-payment-checkout-button//span)[1]");
   Element collectInStoreLabel = elementByXpath("(//rezolve-frontend-delivery-option//rezolve-frontend-payment-checkout-button//span)[3]");
   Element footerText = elementByXpath("//rezolve-frontend-terms-and-conditions/span");
   Element termsAndConditionsLinkText = elementByXpath("//rezolve-frontend-terms-and-conditions/span/a[1]");
   Element privacyPolicyLinkText = elementByXpath("//rezolve-frontend-terms-and-conditions/span/a[2]");


   Element subTotalTitle = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[1])[1]");
   Element subTotalAmount = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[2])[1]");
   Element shippingTitle = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[1])[2]");
   Element shippingAmount = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[2])[2]");
   Element taxTitle = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[1])[3]");
   Element taxAmount = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[2])[3]");
   Element discountTitle = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[1])[4]");
   Element discountAmount = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[2])[4]");
   Element totalTitle = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[1])[5]");
   Element totalAmount = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[2])[5]");

   @SneakyThrows
   @Step("Click on Instant Buy")
   public void clickInstantBuy(){Thread.sleep(5000);
      instantBuyButton.waitUntilElementVisible(60).waitUntilElementClickable(60);
      screenshot();
      instantBuyButton.click();
   }

   @Step("Get the unit price below the image")
   public Double getUnitPrice(){
      String price = unitPriceNextToImage.getText();
      price =  price.substring(1, price.length() - 1);
      return Double.valueOf(price);
   }
   @Step("Get the SubTotal cost")
   public Double getSubtotalCost(){
      String price = subTotalAmount.scrollDownUtillFindElement().getText();
      price =  price.substring(1, price.length() - 1);
      return Double.valueOf(price);
   }

   @Step("Get the Shipping cost")
   public Double getShippingCost(){
      String price = shippingAmount.scrollDownUtillFindElement().getText();
      price =  price.substring(1, price.length() - 1);
      return Double.valueOf(price);
   }
   @Step("Get the Tax cost")
   public Double getTaxCost(){
      String price = taxAmount.scrollDownUtillFindElement().getText();
      price =  price.substring(1, price.length() - 1);
      return Double.valueOf(price);
   }
   @Step("Get the Discount cost")
   public Double getDiscountCost(){
      String price = discountAmount.scrollDownUtillFindElement().getText();
      price =  price.substring(1, price.length() - 1);
      return Double.valueOf(price);
   }
   @Step("Get the Total cost")
   public Double getTotalCost(){
      String price = totalAmount.scrollDownUtillFindElement().getText();
      price =  price.substring(1, price.length() - 1);
      return Double.valueOf(price);
   }
   @Step("Get the Quantity")
   public Integer getQuantity(){
      return Integer.valueOf(quantity.scrollDownUtillFindElement().getText());
   }

   @Step("Get Quantity label")
   public String getQuantityLabel(){
    return quantityLabel.getText();
   }
   @Step("Get See more/less label")
   public String getSeeMoreLessLabel(){
      return seeMoreLess.getText();
   }
   @Step("Get Instant Buy label")
   public String getInstantBuyLabel(){
      return instantBuyButtonLabel.getText();
   }
   @Step("Get Delivery Options")
   public String getDeliveryOptionsLabel(){
      return deliveryOptionLabel.getText();
   }
   @Step("Get Send to address")
   public String getSendToAddressLabel(){
      return sendToAddressLabel.getText();
   }
   @Step("Get Address's Change label")
   public String getAddressChangeLabel(){
      return changeLabel.getText();
   }
   @Step("Get Collect in store")
   public String getCollectInStoreLabel(){
      return collectInStoreLabel.getText();
   }
   @Step("Get Pay Using label")
   public String getPayUsingLabel(){
      return payUsingLabel.getText();
   }

   @Step("Get footer text")
   public String getFooterText(){
      return footerText.getText();
   }
   @Step("Get terms and conditions text")
   public String getTermsAndConditionsLinkText(){
      return termsAndConditionsLinkText.getText();
   }
   @Step("Get privacy policy")
   public String getPrivacyPolicyLabel(){
      return privacyPolicyLinkText.getText();
   }


   @Step("Get the Quantity label")
   public void clickInstantBuyMerchantPayment(){
      instantBuyButton.waitUntilElementVisible(60).waitUntilElementClickable(60);
      driver.findElement(By.xpath("//rezolve-frontend-instant-buy-button/button")).click();

   }

   @Step("Wait to load product detail page's Instant Buy")
   public ProductDetailsPage waitToPageLoad(){
      try {
         Thread.sleep(3000);
      } catch (InterruptedException e) {
         throw new RuntimeException(e);
      }
      try{
          if (instantBuyButton.waitUntilElementVisible(60).isElementDisplayed())
             return this;
          if(instantBuyButton.waitUntilElementClickable(60).isElementEnabled())
             return  this;
          else
            return null;
      }catch (Exception e){
         if (instantBuyButton.waitUntilElementVisible(60).isElementDisplayed())
            return this;
         if(instantBuyButton.waitUntilElementClickable(60).isElementEnabled())
            return  this;
         else
            return null;
      }


   }


   @Step("Enter CVV")
   public ProductDetailsPage enterCvv(String cvv){
      cvvInput.waitUntilElementClickable(60).scrollDownUtillFindElement().enterText(cvv);
      return this;
   }
   @Step("Verify the last transaction delivery address is shown as default address ")
   public boolean isGivenAddressShown(TestData testData){
      UserAccountData userAccountData = testData.getTestData(UserAccountData.class);
      String deliveryAddress = this.deliveryAddress.waitUntilElementVisible(30).scrollDownUtillFindElement().getText();
      screenshot();
     return deliveryAddress.contains(userAccountData.getAddress());
   }

   @Step("Verify the last transaction's credit card is shown as default payment ")
   public boolean isGivenPaymentCardShown(TestData testData){
      CreditCardData creditCardData = testData.getTestData(CreditCardData.class);
      String cardNumber = creditCardData.getCardNumber();
      screenshot();
      String lastFourDigits = cardNumber.substring(cardNumber.length() - 4);
      return paymentCard.getText().contains(lastFourDigits);
   }

   @Step("Click change in payment")
   public PaymentListPage changePayment(){
      paymentChangeButton.waitUntilElementClickable(45).scrollDownUtillFindElement().click();
      return new PaymentListPage();
   }
   @Step("Click change in address")
   public AddressPage changeAddress(){
      addressChangeButton.waitUntilElementClickable(60).scrollDownUtillFindElement().click();
      return new AddressPage();
   }

   @Step("Click Credit Card tile")
   public PaymentListPage clickCreditCard(){
      creditCardTile.scrollDownUtillFindElement().click();
      return new PaymentListPage();
   }


   /**
    * This handles cases when card is displayed with number and also credit card tiles
    * @return
    */
   @SneakyThrows
   @Step("Click Credit Card tile")
   public PaymentListPage chooseCreditCardOrChangePayment(){
      Thread.sleep(3000);
      if(cvvInput.getElements() !=null && cvvInput.getElements().size() >0){
        return changePayment();
      }else if (creditCardTile.getElements() != null && creditCardTile.getElements().size() >0) {
         return clickCreditCard();
      }
      return  null;
   }

   @Step("Click Pay Pal tile")
   public ProductDetailsPage clickPayPal(){
      if(driver.findElements(By.xpath("//rezolve-frontend-pay-using//rezolve-frontend-payment-checkout-button//span[text()=\"Pay Pal\"]")).size()<1) {
         paypalTile.waitUntilElementClickable(60).scrollDownUtillFindElement().click();
      }
      return new ProductDetailsPage();
   }
   @Step("Get the default card payment status")
   public boolean isDefaultPaymentIsCard(){
      if(cvvInput.getElements()==null && cvvInput.getElements().size() <=0)
         return false;
      else
         return true;
   }



   @SneakyThrows
   @Step("Select 'Collect In Store'")
   public ProductDetailsPage clickCollectInStore(){
      screenshot();
      collectInStore.waitUntilElementPresent(30).scrollDownUtillFindElement().click();
      selectFirstStore.waitUntilElementVisible(30).click();
      doneButton.scrollDownUtillFindElement().click();
      Thread.sleep(4000);
      return new ProductDetailsPage();
   }
   @SneakyThrows
   @Step("Select 'Send To Address'")
   public ProductDetailsPage clickSendToAddressAndSelectFirstAddress(){
      sendToAddress.waitUntilElementPresent(30).scrollDownUtillFindElement().click();
      selectFirstAddress.waitUntilElementVisible(30).click();
      screenshot();
      doneButton.scrollDownUtillFindElement().click();
      Thread.sleep(4000);
      return new ProductDetailsPage();
   }

   @SneakyThrows
   @Step("Select address if not shown default address'")
   public ProductDetailsPage selectAddressIfNot(){
      if(driver.findElements(By.xpath("(//rezolve-frontend-delivery-option//button)[1]")).size() <=0){
         clickSendToAddressAndSelectFirstAddress();
      }
      return new ProductDetailsPage();
   }


   @Step("Get Quantity elements validations and default value should be 1")
   public boolean isQuantityDisplayed(){
      quantityElement.waitUntilElementVisible(120).scrollDownUtillFindElement();
      if(buttonIncreaseQuantity.isElementDisplayed() && buttonDecreaseQuantity.isElementDisplayed() && quantity.getText().equals("1")){
        return  true;
      }else {
         return false;
      }
   }

   @SneakyThrows
   @Step("Increase Quantity By 1")
   public ProductDetailsPage increaseQuantity() {
      buttonIncreaseQuantity.waitUntilElementClickable(60).click();
      Thread.sleep(5000); // load the new price
      return this ;
   }
   @SneakyThrows
   @Step("Decrease Quantity By 1")
   public ProductDetailsPage decreaseQuantity() {
      buttonDecreaseQuantity.waitUntilElementClickable(60).click();
      Thread.sleep(5000);  // load the new price
      return this ;
   }
   @Step("Change Language To German")
   public ProductDetailsPage changeLanguageToGerman(){
      languageButton.waitUntilElementClickable(30).click();
      germanOption.waitUntilElementClickable(30).click();
      screenshot();
      return   this;
   }


   @Step("Get the instant buy button text")
   public String getInstantBuyButtonText(){
    return   instantBuyButton.getText();
   }


   @Step("Verify the tab title")
   public boolean isProductNameDisplayedAsTitle(TestData testData) {
      EngagementLinkData engagementLinkData = testData.getTestData(EngagementLinkData.class);
      screenshot();
     if(getTitle().equals(engagementLinkData.getProductName()))
        return true;
     else
        return false;
   }


   @Step("Set the config details")
   public ProductDetailsPage setConfig(TestData testData){
      EngagementLinkData engagementLinkData = testData.getTestData(EngagementLinkData.class);
      for(String locator: engagementLinkData.getSizeWithAutomationLocators()){
         processDynamicLocator(locator);
      }
      for(String locator: engagementLinkData.getColorWithAutomationLocators()){
         processDynamicLocator(locator);
      }
      return this;
   }

   @Step("Click See More")
   public ProductDetailsPage clickSeeMore() {
      int size = driver.findElements(By.xpath("//rezolve-frontend-product-details/div/p[contains(@class,\"show\")]")).size();
      if(size>0) {
             LogHelper.log.error("See More is not displayed");
             screenshot();
          }else {
             seeMoreLess.click();
          }
      screenshot();
      return this;
   }

   @Step("Click See Less")
   public ProductDetailsPage clickSeeLess() {
      if(descriptionMore.isElementDisplayed()) {
         seeMoreLess.click();
      }else {
         LogHelper.log.error("See More is not displayed");
         screenshot();
      }
      screenshot();
      return this;
   }
   @Step("Get status of the Product's full  description")
   public boolean isFullDescriptionShown(){
      screenshot();
    if ( this.driver.findElements(By.xpath("//rezolve-frontend-product-details/div/p[contains(@class,\"show\")]")).size() >0 ){
       return  descriptionMore.isElementDisplayed();

    }else {
       return false;
    }
   }

}
