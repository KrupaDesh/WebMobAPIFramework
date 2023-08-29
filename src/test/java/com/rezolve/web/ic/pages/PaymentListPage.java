package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.ic.model.CreditCardData;

import static engine.core.Element.elementByXpath;

public class PaymentListPage extends BasePage {

   Element creditCard = elementByXpath("//mat-radio-button//span[contains(text(),'**** **** ****')]");
   Element payPayOptionLabel = elementByXpath("//span[contains(text(),'Pay Pal')]");
   Element googlePayOptionLabel = elementByXpath("//span[contains(text(),'Google Pay')]");
   Element payPayRadioOption = elementByXpath("//span[contains(text(),'Pay Pal')]/../../../span[@class='mat-radio-container']");
   Element googlePayRadioOption = elementByXpath("//span[contains(text(),'Google Pay')]/../../../span[@class='mat-radio-container']");
   Element doneButton = elementByXpath("//rezolve-frontend-form-submit-button//button");
   Element addNewCard = elementByXpath("//mat-radio-group/../button");



  @Step("Select given credit card from payment list")
   public PaymentListPage selectCreditCard(TestData testData){
      String cardNumber = testData.getTestData(CreditCardData.class).getCardNumber();
      elementByXpath("//mat-radio-button//span[contains(text(),'"+cardNumber.substring(cardNumber.length()-4)+"')]").click();
     return this;
  }

    @Step("Select given PayPal from payment list")
    public PaymentListPage selectPayPal(){
        payPayOptionLabel.click();
        return this;
    }


    @Step("And click Done button")
    public ProductDetailsPage clickDone(){
      doneButton.click();
      return  new ProductDetailsPage();
    }

    @Step("Click Add new card")
    public CardPage addNewCard(){
        addNewCard.click();
        return  new CardPage();
    }


}
