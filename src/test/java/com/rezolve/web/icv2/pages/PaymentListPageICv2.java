package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.icv2.model.CreditCardDataICv2;

import static engine.core.Element.elementByXpath;

public class PaymentListPageICv2 extends BasePage {

   Element creditCard = elementByXpath("//mat-radio-button//div[contains(text(), 'xxxx')]");
   Element payPayOptionLabel = elementByXpath("//mat-radio-button//div[contains(text(), 'PayPal')]");
   Element googlePayOptionLabel = elementByXpath("//mat-radio-button//div[contains(text(), 'Google')]");
   Element payPayRadioOption = elementByXpath("//mat-radio-button//div[contains(text(), 'PayPal')]/../..//input");
   Element googlePayRadioOption = elementByXpath("//mat-radio-button//div[contains(text(), 'Google')]/../..//input");
   Element doneButton = elementByXpath("//span[contains(text(), ' Confirm Payment Method ')]/.. | //span[contains(text(), ' Bestätigen Sie die Zahlungsmethode ')]/..");
   Element addNewCard = elementByXpath("(//ic-card//button)[2]");



  @Step("Select given credit card from payment list")
   public PaymentListPageICv2 selectCreditCard(TestData testData){
      screenshot();
      String cardNumber = testData.getTestData(CreditCardDataICv2.class).getCardNumber();
      String xpath ="//mat-radio-button//div[contains(text(),'"+cardNumber.substring(cardNumber.length()-4)+"')]";
      elementByXpath("//mat-radio-button//div[contains(text(),'"+cardNumber.substring(cardNumber.length()-4)+"')]").click();
     return this;
  }

    @Step("Select given credit card from payment list")
    public PaymentListPageICv2 selectExistingCard(){
        screenshot();
        elementByXpath("//mat-radio-button//div[1]").click();
        return this;
    }

    @Step("Select given PayPal from payment list")
    public PaymentListPageICv2 selectPayPal(){
        payPayOptionLabel.click();
        return this;
    }


    @Step("And click Done button")
    public ProductDetailsPageICv2 clickDone(){
      addNewCard.scrollDownUtillFindElement();
      doneButton.click();
      return  new ProductDetailsPageICv2();
    }

}
