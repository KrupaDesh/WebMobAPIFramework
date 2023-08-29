package com.rezolve.web.icv2.pages;

import engine.LogHelper;
import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import com.rezolve.web.icv2.model.CreditCardDataICv2;
import com.rezolve.web.icv2.model.EngagementLinkDataICv2;
import com.rezolve.web.icv2.model.UserAccountDataICv2;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import javax.swing.text.View;

import static engine.core.Element.elementByXpath;

public class ProductDetailsPageICv2 extends BasePage {

   Element instantBuyButton = elementByXpath("//button[@type=\"submit\"]");
   Element unitPriceNextToImage = elementByXpath("//ic-product-detail//div[2]//div[@class=\"flex items-center\"]/span");
   Element instantBuyButtonLabel = elementByXpath("//rezolve-frontend-instant-buy-button/button/span/span");

   Element paymentLayout = elementByXpath("//ic-product-checkout/div[2]/div/div[2]");
   Element paymentChangeButton = elementByXpath("//h2[text()=\"Pay Using\"]/../button | //h2[text()=\"Bezahlen mit\"]/../button");
   Element addressChangeButton = elementByXpath("//h2[text()=\"Delivery Option\"]/../button | //h2[text()=\"Optionen für die Lieferung\"]/../button");
   Element creditCardTile = elementByXpath("//div[text()=\" Add Debit/Credit Cards \"]");
   Element paypalTile = elementByXpath("//rezolve-frontend-pay-using//rezolve-frontend-payment-button//span[text()=\"Pay Pal\"]");
   Element paypalSelected = elementByXpath("//div[@class=\"flex items-center\"]/div[2]");
   Element cvvInput = elementByXpath("//input[@placeholder=\"CVV\"]");
   Element quantityElement = elementByXpath("//ic-product-detail//div[@class=\"inline-flex flex-col\"]");
   Element buttonIncreaseQuantity = elementByXpath("(//ic-product-detail//button[@type=\"button\"])[2]");
   Element buttonDecreaseQuantity = elementByXpath("(//ic-product-detail//button[@type=\"button\"])[1]");
   Element quantity = elementByXpath("//ul[@class=\"quantity-list\"]/li[2]");
   Element deliveryAddress = elementByXpath("//div[@class=\"delivery-card\"]/div[2]//div[2]");
   Element alternateDeliveryOption = elementByXpath("//div[contains(text(),'can also')]/span");
   Element collectInStore = elementByXpath("//ic-product-detail//span[text()=\" Collect in store \"] | //div[text()=' Collect in store '] | //div/span[text()='Collect in store']");
   Element sendToAddress = elementByXpath("//ic-product-detail//div[text()=\" Send to address \"] | //div[text()=\" Send to address \"]| //ic-product-detail//div[text()=\" An Lieferadresse senden \"]");
  // Element selectFirstStore = elementByXpath("//ic-delivery-options//ic-collect-in-store//mat-radio-button//div[1]//input");
   Element selectFirstStore = elementByXpath("//ic-delivery-options//mat-radio-button//div[1]//label | //input[@type=\"radio\"][1]/../../div");
   //Element selectFirstAddress = elementByXpath("(//input[@type=\"radio\"])[1]");
   //Element selectFirstAddress = elementByXpath("//ic-delivery-options//li[1] | (//div[@class='mdc-form-field']//input[@type=\"radio\"])[1]");
   Element selectFirstAddress = elementByXpath("(//input[@type=\"radio\"])[1]/../../label | (//input[@type=\"radio\"])[1]/../../div");
   Element selectFirstAddressForIos = elementByXpath("(//input[@type=\"radio\"])[1]/../../label");
   Element selectFirstStoreForIos = elementByXpath("//ic-delivery-options//mat-radio-button//div[1]//label");
   Element doneButton = elementByXpath("//ic-delivery-options/ic-card/div/div/div[2]/div/div[2]/button");
   Element confirmPickupLocation = elementByXpath("//span[text()=\" Confirm Pickup Location \"]//../../button");
   Element confirmDeliveryAddress = elementByXpath("//ic-delivery-options/ic-card/div/div/div[2]/div/div[2]/button");
   Element paymentCard = elementByXpath("//ic-product-checkout/div[2]/div/div[2]/div/div[2]/div[1]");
   Element seeMoreLess = elementByXpath("//button[@class=\"expand-decription-btn\"]");
   Element descriptionMore = elementByXpath("//ic-product-detail//div[2]/div[2]//div[@class=\"pdp-product-info__txt\"]");
   Element profileButton = elementByXpath("//ic-header//button[@aria-label=\"menu1\"]");
   Element germanOption = elementByXpath("(//mat-radio-button//div[@class=\"mdc-form-field\"])[2]//label");
   Element englishOption = elementByXpath("(//button[@role='menuitem'])[1]");
   Element quantityLabel = elementByXpath("//ic-product-detail//div[text()=\" Select Quantity \"] | //ic-product-detail//div[text()=\" Anzahl Auswählen \"]");
   Element quantityGermanText = elementByXpath("//ic-product-detail//div[text()=\" Anzahl Auswählen \"]");
   Element deliveryOptionLabel = elementByXpath("//ic-product-checkout/div[1]//h2");
   Element payUsingLabel = elementByXpath("//ic-product-checkout/div[2]//h2");
   Element changeLabel = elementByXpath("(//ic-product-checkout//button)[1]");
   Element sendToAddressLabel = elementByXpath("//ic-product-detail//div[text()=\" Send to address \"]");
   Element collectInStoreLabel = elementByXpath("//ic-product-detail//span[text()=\"Collect in store\"]");
   Element footerText = elementByXpath("(//ic-terms-and-condition//div/div/span)[1]");
   Element termsAndConditionsLinkText = elementByXpath("(//ic-terms-and-condition//div/div/a)[1]");
   Element privacyPolicyLinkText = elementByXpath("(//ic-terms-and-condition//div/div/a)[2]");
   Element andText = elementByXpath("(//ic-terms-and-condition//div/div/span)[2]");
   Element ofText = elementByXpath("(//ic-terms-and-condition//div/div/span)[3]");
   Element subTotalTitle = elementByXpath("(//ic-price-details//div[2]//div//div[1])[2]");
   Element subTotalAmount = elementByXpath("(//ic-price-details//div[2]//div[2])[1]");
   Element shippingTitle = elementByXpath("(//ic-price-details//div[2]//div//div[1])[3]");
   Element shippingAmount = elementByXpath("(//ic-price-details//div[2]//div[2])[3]");
   Element taxTitle = elementByXpath("(//ic-price-details//div[2]//div//div[1])[4]");
   Element taxAmount = elementByXpath("(//ic-price-details//div[2]//div[2])[4]");
   Element discountTitle = elementByXpath("(//ic-price-details//div[2]//div//div[1])[5]");
   Element discountAmount = elementByXpath("(//ic-price-details//div[2]//div[2])[5]");
   Element totalTitle = elementByXpath("(//rezolve-frontend-price-breakdown/section/span/span[1])[5]");
   Element totalAmount = elementByXpath("(//ic-price-details//div[2]//div[2])[6]");
   Element productName = elementByXpath("//div/h1");
   Element viewDetails = elementByXpath("//span/a[text()=\"View Details\"]");
   Element priceDetailsTile = elementByXpath("//div/h2[text()=\"Price Details \"]");
   Element outOfStockText = elementByXpath("//div[text()=\" Out of stock \"]");
   Element backButton = elementByXpath("(//ic-add-address//button)[1] | (//ic-card//button)[1]");
   Element confirmPaymentOptionButtonLabel = elementByXpath("//button//span[contains(text(),\"Bestätigen Sie die Zahlungsmethode\")]");

   @SneakyThrows
   @Step("Click on Instant Buy")
   public void clickInstantBuy(){
      Thread.sleep(5000);
      instantBuyButton.waitUntilElementVisible(60).waitUntilElementClickable(60);
      screenshot();
      instantBuyButton.click();
   }

   @Step("Get the unit price below the image")
   public Double getUnitPrice(){
      String price = unitPriceNextToImage.getText();
      System.out.println("Unit price below image:"+price);

       try {
           if(System.getProperty("config")!= null) {
               String[] config = System.getProperty("config").split("[.]");
               if (config[1].matches("mac")){
                   price =  price.substring(2, price.length() - 1);
                   System.out.println("Unit price below image:"+price);
               }
               else{
                   price =  price.substring(1, price.length() - 1);
                   System.out.println("Unit price below image:"+price);
               }
               return Double.valueOf(price);
           }
       }catch (Exception e)
       {
           e.printStackTrace();
       } return null;
   }
   @Step("Get the SubTotal cost")
   public Double getSubtotalCost(){
      String price = subTotalAmount.scrollDownUtillFindElement().getText();
       System.out.println("Subtotal price: "+price);
      screenshot();
       try {
           if(System.getProperty("config")!= null) {
               String[] config = System.getProperty("config").split("[.]");
               if (config[1].matches("mac")){
                   price =  price.substring(2, price.length() - 1);
                   System.out.println("Subtotal price:"+price);
               }
               else{
                   price =  price.substring(1, price.length() - 1);
                   System.out.println("Subtotal price:"+price);
               }
               return Double.valueOf(price);
           }
       }catch (Exception e)
       {
           e.printStackTrace();
       } return null;
   }

   @Step("Get the Shipping cost")
   public Double getShippingCost(){
      String price = shippingAmount.scrollDownUtillFindElement().getText();
      System.out.println("Shipping price: "+price);
       try {
           if(System.getProperty("config")!= null) {
               String[] config = System.getProperty("config").split("[.]");
               if (config[1].matches("mac")){
                   price =  price.substring(2, price.length() - 1);
                   System.out.println("Shipping price:"+price);
               }
               else{
                   price =  price.substring(1, price.length() - 1);
                   System.out.println("Shipping price:"+price);
               }
               return Double.valueOf(price);
           }
       }catch (Exception e)
       {
           e.printStackTrace();
       } return null;
   }
   @Step("Get the Tax cost")
   public Double getTaxCost(){
      String price = taxAmount.scrollDownUtillFindElement().getText();
       System.out.println("Tax price: "+price);
       try {
           if(System.getProperty("config")!= null) {
               String[] config = System.getProperty("config").split("[.]");
               if (config[1].matches("mac")){
                   price =  price.substring(2, price.length() - 1);
                   System.out.println("Tax price:"+price);
               }
               else{
                   price =  price.substring(1, price.length() - 1);
                   System.out.println("Tax price:"+price);
               }
               return Double.valueOf(price);
           }
       }catch (Exception e)
       {
           e.printStackTrace();
       } return null;
   }
   @Step("Get the Discount cost")
   public Double getDiscountCost(){
      String price = discountAmount.scrollDownUtillFindElement().getText();
       try {
           if(System.getProperty("config")!= null) {
               String[] config = System.getProperty("config").split("[.]");
               if (config[1].matches("mac")){
                   price =  price.substring(2, price.length() - 1);
               }
               else{
                   price =  price.substring(1, price.length() - 1);
                   System.out.println("Unit price below image: "+price);
               }
               return Double.valueOf(price);
           }
       }catch (Exception e)
       {
           e.printStackTrace();
       } return null;
   }
   @Step("Get the Total cost")
   public Double getTotalCost(){
      String price = totalAmount.scrollDownUtillFindElement().getText();
      System.out.println("Total price:"+price);
       try {
           if(System.getProperty("config")!= null) {
               String[] config = System.getProperty("config").split("[.]");
               if (config[1].matches("mac")){
                   price =  price.substring(2, price.length() - 1);
                   System.out.println("Total price:"+price);
               }
               else{
                   price =  price.substring(1, price.length() - 1);
                   System.out.println("Total price:"+price);
               }
               return Double.valueOf(price);
           }
       }catch (Exception e)
       {
           e.printStackTrace();
       } return null;
   }
   @Step("Get the Quantity")
   public Integer getQuantity(){
      return Integer.valueOf(quantity.scrollDownUtillFindElement().getText());
   }

   @Step("Get Quantity label")
   public String getQuantityLabel(){
    return quantityGermanText.getText();
   }
   @Step("Get See more/less label")
   public String getSeeMoreLessLabel(){
       quantityLabel.waitUntilElementVisible(25).scrollDownUtillFindElement();
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
   @Step("and")
   public String getAndLabel() {return andText.getText();}
   @Step("of")
   public String getOfText() {return ofText.getText();}

   @Step("Get the Quantity label")
   public void clickInstantBuyMerchantPayment(){
      instantBuyButton.waitUntilElementVisible(60).waitUntilElementClickable(60);
      driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

   }

   @Step("Wait to load product detail page's Instant Buy")
   public ProductDetailsPageICv2 waitToPageLoad(){
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


   @SneakyThrows
   @Step("Enter CVV")
   public ProductDetailsPageICv2 enterCvv(String cvv){
      //To be fixed for IOS
      Thread.sleep(2000);
      cvvInput.waitUntilElementClickable(60).scrollDownUtillFindElement().clear().enterText(cvv);
      screenshot();
      return this;
   }
   @Step("Verify the last transaction delivery address is shown as default address ")
   public boolean isGivenAddressShown(TestData testData){
      UserAccountDataICv2 userAccountData = testData.getTestData(UserAccountDataICv2.class);
      String deliveryAddress = this.deliveryAddress.waitUntilElementVisible(30).scrollDownUtillFindElement().getText();
      screenshot();
     return deliveryAddress.contains(userAccountData.getAddress());
   }

   @Step("Verify the last transaction's credit card is shown as default payment ")
   public boolean isGivenPaymentCardShown(TestData testData){
      CreditCardDataICv2 creditCardData = testData.getTestData(CreditCardDataICv2.class);
      String cardNumber = creditCardData.getCardNumber();
      screenshot();
      String lastFourDigits = cardNumber.substring(cardNumber.length() - 4);
      return paymentCard.getText().contains(lastFourDigits);
   }

   @SneakyThrows
   @Step("Click change in payment")
   public PaymentListPageICv2 changePayment(){
       Thread.sleep(5000);
      //paymentChangeButton.waitUntilElementClickable(45).click();
      //addressChangeButton.scrollDownUtillFindElement(); //Scroll to previous element
      deliveryOptionLabel.waitUntilElementVisible(30).scrollDownUtillFindElement();
      Thread.sleep(2000);
      paymentChangeButton.click();
      return new PaymentListPageICv2();
   }
   @SneakyThrows
   @Step("Click change in address")
   public AddressPageICv2 changeAddress(){

       quantityLabel.waitUntilElementVisible(25).scrollDownUtillFindElement();
       deliveryOptionLabel.waitUntilElementVisible(30);
       Thread.sleep(5000);
       screenshot();
      if(this.driver.findElements(By.xpath("//h2[text()=\"Delivery Option\"]/../button | //h2[text()=\"Optionen für die Lieferung\"]/../button")).size() <= 0)

      {
         sendToAddress.waitUntilElementClickable(30).click();
         selectFirstAddress.waitUntilElementClickable(30).click();
         selectFirstAddressForIos.waitUntilElementVisible(30).click(); //This double click is only for IOS, currently it is not deselecting on other platforms on double click.
         screenshot();
         doneButton.scrollDownUtillFindElement().click();
         scrollToTop();
         Thread.sleep(5000);
      }
      //addressChangeButton.waitUntilElementClickable(60).scrollDownUtillFindElement().click();
       screenshot();
      addressChangeButton.waitUntilElementClickable(60).click();
      return new AddressPageICv2();
   }

    @SneakyThrows
    @Step("Check Alternate Delivery Option")
    public String checkAlternateDeliveryOption()
    {
        LogHelper.log.info("Alternate Delivery Option: "+ alternateDeliveryOption.getText());
        return alternateDeliveryOption.getText();
    }
    @SneakyThrows
    @Step("Change Delivery Option To Send To Address")
    public ProductDetailsPageICv2 changeDeliveryOptionToSendToAddress(){
       try{
       if(checkAlternateDeliveryOption().equals("Send to address")) {
           //alternateDeliveryOption.click();
           //elementByXpath("//ic-product-detail//span[text()=\""+checkAlternateDeliveryOption()+"\"]").click();
           if(sendToAddress.isElementDisplayed()){
               System.out.println("Send to address is displayed");
               sendToAddress.click();}
           selectFirstStore.click();
           selectFirstStoreForIos.click(); //This double click is only for IOS, currently it is not deselecting on other platforms on double click.
           confirmDeliveryAddress.click();
       }}
        catch (Exception e){
           System.out.println("Address not selected to check alternate delivery option" );
           e.printStackTrace();
       }
        screenshot();
        return new ProductDetailsPageICv2();
    }
    @SneakyThrows
    @Step("Change Delivery Option To Collect InStore")
    public ProductDetailsPageICv2 changeDeliveryOptionToCollectInStore(){
        try{
        if(checkAlternateDeliveryOption().equals("Collect in store")) {
            alternateDeliveryOption.waitUntilElementClickable(25).click();
            selectFirstStore.click();
            selectFirstStoreForIos.click(); //This double click is only for IOS, currently it is not deselecting on other platforms on double click.
            confirmPickupLocation.click();
        }}
        catch (Exception e){
        System.out.println("Address not selected to check alternate delivery option");
    }
        screenshot();
        return new ProductDetailsPageICv2();
    }

    public ProductDetailsPageICv2 switchDeliveryOption(){
        alternateDeliveryOption.waitUntilElementClickable(25).click();
        selectFirstStore.click();
        selectFirstStoreForIos.click(); //This double click is only for IOS, currently it is not deselecting on other platforms on double click.
        confirmDeliveryAddress.click();
        return new ProductDetailsPageICv2();
    }
   @Step("Click Credit Card tile")
   public PaymentListPageICv2 clickCreditCard(){
       screenshot();
      creditCardTile.scrollDownUtillFindElement().click();
      return new PaymentListPageICv2();
   }


   /**
    * This handles cases when card is displayed with number and also credit card tiles
    * @return
    */
   @SneakyThrows
   @Step("Click Credit Card tile")
   public PaymentListPageICv2 chooseCreditCardOrChangePayment(){
      Thread.sleep(3000);
      if(cvvInput.getElements() !=null && cvvInput.getElements().size() >0){
        return changePayment();
      }else if (creditCardTile.getElements() != null && creditCardTile.getElements().size() >0) {
         return clickCreditCard();
      }
      return  null;
   }

   @Step("Click Pay Pal tile")
   public ProductDetailsPageICv2 clickPayPal(){
      if(driver.findElements(By.xpath("//ic-product-checkout//div[contains(text(), \"PayPal\")]")).size()<1) {
         paypalTile.waitUntilElementClickable(60).scrollDownUtillFindElement().click();
      }
      return new ProductDetailsPageICv2();
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
   public ProductDetailsPageICv2 clickCollectInStore(){
      screenshot();
      deliveryOptionLabel.waitUntilElementVisible(25).scrollDownUtillFindElement();
      Thread.sleep(5000);
      collectInStore.waitUntilElementPresent(30).click();
      selectFirstStore.click();
      selectFirstStoreForIos.click(); //This double click is only for IOS, currently it is not deselecting on other platforms on double click.
      //confirmPickupLocation.scrollDownUtillFindElement().click();
       confirmPickupLocation.click();
      Thread.sleep(4000);
      return new ProductDetailsPageICv2();
   }
   @SneakyThrows
   @Step("Select 'Send To Address'")
   public ProductDetailsPageICv2 clickSendToAddressAndSelectFirstAddress(){
      Thread.sleep(4000);
      unitPriceNextToImage.waitUntilElementVisible(25).scrollDownUtillFindElement();
      screenshot();
      sendToAddress.waitUntilElementPresent(30).click();
      selectFirstAddress.waitUntilElementVisible(30).click();
      selectFirstAddressForIos.waitUntilElementVisible(30).click(); //This double click is only for IOS, currently it is not deselecting on other platforms on double click.
      screenshot();
      doneButton.waitUntilElementVisible(25).scrollDownUtillFindElement().click();
      Thread.sleep(4000);
      return new ProductDetailsPageICv2();
   }

   @SneakyThrows
   @Step("Select address if not shown default address'")
   public ProductDetailsPageICv2 selectAddressIfNot(){
      Thread.sleep(4000);
      if(driver.findElements(By.xpath("//h2[text()=\"Delivery Option\"]//..//button[text()=\"Change\"]")).size() <=0){
         clickSendToAddressAndSelectFirstAddress();
      }
      screenshot();
      return new ProductDetailsPageICv2();
   }


   @SneakyThrows
   @Step("Get Quantity elements validations and default value should be 1")
   public boolean isQuantityDisplayed(){
      unitPriceNextToImage.waitUntilElementVisible(25).scrollDownUtillFindElement();
      Thread.sleep(2000);
      if(buttonIncreaseQuantity.isElementDisplayed() && buttonDecreaseQuantity.isElementDisplayed() && quantity.getText().contains("1")){
          return  true;
      }else {
         return false;
      }
   }

/*   @SneakyThrows
   @Step("Increase Quantity By 1")
   public ProductDetailsPageICv2 increaseQuantity() {
      buttonIncreaseQuantity.waitUntilElementClickable(60).click();
      Thread.sleep(5000); // load the new price
      return this ;
   }*/
   @SneakyThrows
   @Step("Increase Quantity By 1")
   public ProductDetailsPageICv2 increaseQuantity() {
      //scrollToTop();
      productName.scrollDownUtillFindElement();
       Thread.sleep(2000);
      buttonIncreaseQuantity.waitUntilElementClickable(60).click();
      Thread.sleep(5000); // load the new price
      return this ;
   }
   @SneakyThrows
   @Step("Decrease Quantity By 1")
   public ProductDetailsPageICv2 decreaseQuantity() {
      buttonDecreaseQuantity.waitUntilElementClickable(60).click();
      Thread.sleep(5000);  // load the new price
      return this ;
   }
   @Step("Change Language To German")
   public ProductDetailsPageICv2 changeLanguageToGerman(){
      profileButton.waitUntilElementClickable(30).click();
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
      Thread.onSpinWait();
      EngagementLinkDataICv2 engagementLinkData = testData.getTestData(EngagementLinkDataICv2.class);
      screenshot();
     if(getTitle().equals(engagementLinkData.getProductName()))
        return true;
     else
        return false;
   }


   @SneakyThrows
   @Step("Set the config details")
   public ProductDetailsPageICv2 setConfig(TestData testData){
      quantityLabel.waitUntilElementVisible(25).scrollDownUtillFindElement();
      EngagementLinkDataICv2 engagementLinkData = testData.getTestData(EngagementLinkDataICv2.class);
      Thread.sleep(4000);
      for (String locator : engagementLinkData.getSizeWithAutomationLocators()) {
          processDynamicLocator(locator);
      }
      for(String locator: engagementLinkData.getColorWithAutomationLocators()){
         processDynamicLocator(locator);
      }
      return this;
   }

   @Step("Click See More")
   public ProductDetailsPageICv2 clickSeeMore() {
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
   public ProductDetailsPageICv2 clickSeeLess() {
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
   @Step
   public void clickOnViewDetailsLink(){
      screenshot();
      viewDetails.waitUntilElementVisible(25).click();
      screenshot();
   }
   @Step
   public boolean isPriceDetailsDisplayed(){
      return priceDetailsTile.waitUntilElementPresent(25).isElementDisplayed();
   }
   @Step
   public boolean isOutOfStockTextDisplayed(){
      productName.scrollDownUtillFindElement();
      screenshot();
      return outOfStockText.waitUntilElementVisible(25).isElementDisplayed();
   }
//   @Step As element disable functionality is not present in dom structure
//   public boolean isInstantBuyButtonDisabled(){
//     try {
//        WebDriverWait wt = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wt.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type=\"submit\"]")));
//     }catch(Exception e){
//        e.printStackTrace();
//        return true;
//      }
//      return false;
//   }
   @Step
   public boolean isDeliverySectionDisplayed(){
      return deliveryOptionLabel.waitUntilElementVisible(25).scrollDownUtillFindElement().isElementDisplayed();
   }
    @Step
    public void clickBackButton(){
        backButton.waitUntilElementVisible(25).click();
    }
    public String getConfirmPaymentOptionButtonLabel(){
       return confirmPaymentOptionButtonLabel.getText();
    }
}
