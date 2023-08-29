package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.ic.model.CreditCardData;

import static engine.core.Element.elementByXpath;

public class CardPage extends BasePage {
    Element nameOnCard = elementByXpath("//input[@formcontrolname=\"nameOnCard\"]");
    Element cardNumber = elementByXpath("//input[@formcontrolname=\"cardNumber\"]");
    Element cvv = elementByXpath("//input[@formcontrolname=\"cvv\"]");
    Element expires = elementByXpath("//mat-select[@formcontrolname=\"expires\"]");
    Element saveCardButton = elementByXpath("//rezolve-frontend-form-submit-button/button");


    @Step("Select the expires date")
    public CardPage selectGivenExpiresDate(TestData testData){
        CreditCardData creditCardData = testData.getTestData(CreditCardData.class);
        elementByXpath("//mat-option/span[text()='"+creditCardData.getExpires()+"']").click();
        return  this;
    }

    @Step("Enter all card details")
    public CardPage enterCardDetails(TestData testData){
        screenshot();
        CreditCardData creditCardData = testData.getTestData(CreditCardData.class);
        nameOnCard.waitUntilElementClickable(60).enterText(creditCardData.getNameOnCard());
        cardNumber.waitUntilElementClickable(60).enterText(creditCardData.getCardNumber());
        cvv.waitUntilElementClickable(60).enterText(creditCardData.getCvv());
        expires.click();
        selectGivenExpiresDate(testData);
        screenshot();
        return this;
    }

    @Step("Click Save Card")
    public PaymentListPage  clickSaveCard(){
        saveCardButton.waitUntilElementClickable(60).click();
        return new PaymentListPage();
    }

}
