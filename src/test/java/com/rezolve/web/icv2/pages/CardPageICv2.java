package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.icv2.model.CreditCardDataICv2;
import lombok.SneakyThrows;
import org.assertj.core.api.ThrowableAssert;
import org.openqa.selenium.WebElement;

import java.util.List;

import static engine.core.Element.elementByXpath;

public class CardPageICv2 extends BasePage {
    Element nameOnCard = elementByXpath("//mat-label[contains(text(),\"Name exactly\")]/../../input");
    Element cardNumber = elementByXpath("//mat-label[contains(text(),\"Card Number\")]/../../input");
    Element cvv = elementByXpath("//mat-label[contains(text(),\"CVV\")]/../../input");
    Element expires = elementByXpath("//mat-label[contains(text(),\"Expiry\")]/../../input");
    Element saveCardButton = elementByXpath("//span[contains(text(),\"Save card\")]/../../button");
    Element addNewCard = elementByXpath("(//ic-card//button)[2]");
    Element selectFirstAddress = elementByXpath("(//input[@type=\"radio\"])[1]/../../div");
    Element saveCard = elementByXpath("//span[text()=\" Save card \"]/../../button");
    Element menuButton = elementByXpath("//ic-card/div/div/div/div[4]/ul/li[1]/div[1]/div/button | //ic-card/div/div/div/div[3]/ul/li[1]/div[1]/div/button");
    Element cards = elementByXpath("//mat-radio-button");
    Element deleteButton = elementByXpath("//button[@role=\"menuitem\"]");
    Element confirmDeleteButton = elementByXpath("(//span[text()=\"Delete\"]/../../button)[2]");
    Element selectPaymentOptionLabel = elementByXpath("//ic-card//h2");
    Element savedCardsLabel = elementByXpath("//ic-card//div[text()=\"Gespeicherte Karten\"]");
    Element addCardLabel = elementByXpath("//ic-card//h2");
    Element cardNumberLabel = elementByXpath("(//mat-label)[1]");
    Element nameOnCardLabel = elementByXpath("(//mat-label)[2]");
    Element expiryDateLabel = elementByXpath("(//mat-label)[3]");
    Element cvvLabel = elementByXpath("(//mat-label)[4]");
    Element cardElements = elementByXpath("//ic-add-card//input");
    Element errorCardNumber = elementByXpath("//ic-validation-message//mat-error[contains(text(), \" Kartennummer\")]");
    Element errorNameOnCard = elementByXpath("//ic-validation-message//mat-error[contains(text(), \"Name genau\")]");
    Element errorExpires = elementByXpath("//ic-validation-message//mat-error[contains(text(), \"Verfallsdatum\")]");
    Element errorCvv = elementByXpath("//ic-validation-message//mat-error[contains(text(), \"CVV\")]");
    Element billingAddress = elementByXpath("//ic-add-card//div[contains(text(),\"Rechnungsadresse\")]");
    Element saveCardLabel = elementByXpath("//button//span[contains(text(),\"Karte speichern\")]");


    @Step("Select the expires date")
    public CardPageICv2 selectGivenExpiresDate(TestData testData){
        CreditCardDataICv2 creditCardData = testData.getTestData(CreditCardDataICv2.class);
        elementByXpath("//mat-option/span[text()='"+creditCardData.getExpires()+"']").click();
        return  this;
    }

    @Step("Add New Card")
    public CardPageICv2 addNewCard(TestData testData){
        screenshot();
        CreditCardDataICv2 creditCardData = testData.getTestData(CreditCardDataICv2.class);
        cardNumber.waitUntilElementClickable(60).enterText(creditCardData.getCardNumber());
        nameOnCard.waitUntilElementClickable(60).enterText(creditCardData.getNameOnCard());
        cvv.waitUntilElementClickable(60).enterText(creditCardData.getCvv());
        expires.waitUntilElementClickable(60).enterText(creditCardData.getExpires());
        screenshot();
        cvv.scrollDownUtillFindElement();
        //selectFirstAddress.waitUntilElementVisible(30).click();
        selectFirstAddress.waitUntilElementVisible(20).click();
        saveCard.waitUntilElementVisible(30).click();
        screenshot();
        return this;
    }

    @Step("Click Save Card")
    public PaymentListPageICv2 clickSaveCard(){
        saveCardButton.waitUntilElementClickable(60).click();
        return new PaymentListPageICv2();
    }

    @Step("Click Add new card")
    public CardPageICv2 clickOnAddNewCard(){
        addNewCard.click();
        return  new CardPageICv2();
    }

    @SneakyThrows
    @Step("Get newly added Card ")
    public String getNewlyAddedCard(){
        Thread.sleep(2000);
        List<WebElement> numbers = cards.getElements();
        screenshot();
        return numbers.get(0).getText();
    }

    @SneakyThrows
    @Step("Delete Card")
    public CardPageICv2 deleteCard(){
        menuButton.waitUntilElementVisible(25).click();
        deleteButton.waitUntilElementVisible(25).click();
        screenshot();
        confirmDeleteButton.waitUntilElementVisible(25).click();
        screenshot();
        return  new CardPageICv2();
    }

    @Step("Wait to load Card Page")
    public CardPageICv2 waitToLoadPage(){
        addNewCard.waitUntilElementClickable(60);
        screenshot();
        return this;
    }
    public String getSelectPaymentOptionLabel(){ return selectPaymentOptionLabel.getText();}
    public String getSavedCardsLabel(){ return savedCardsLabel.getText();}
    public String getaddCardLabel(){ return addCardLabel.getText();}
    public String getCardNumberLabel() { return cardNumberLabel.getText();}
    public String getNameOnCardLabel() { return nameOnCardLabel.getText();}
    public String getExpiryDateLabel() { return expiryDateLabel.getText();}
    @Step("Click on all mandatory input fields")
    public CardPageICv2 clickOnMandatoryInputFields(){
        List<WebElement> cardElementsList = cardElements.getElements();
        cardElementsList.get(0).click();
        cardElementsList.get(1).click();
        cardElementsList.get(2).click();
        cardElementsList.get(3).click();
        cardElementsList.get(0).click();
        return this;
    }
    public String getCardNumberErrorLabel() { return errorCardNumber.getText(); }
    public String getNameOnCardErrorLabel(){
        return errorNameOnCard.getText();
    }
    public String getExpiresErrorLabel(){
        return errorExpires.getText();
    }
    public String getCvvErrorLabel() { return errorCvv.getText(); }
    public String getBillingAddressLabel() { return billingAddress.getText(); }
    public String getSaveCardButtonLabel() { return saveCardLabel.getText(); }
}
