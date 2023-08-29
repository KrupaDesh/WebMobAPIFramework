package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import com.rezolve.web.ic.model.PayPalData;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class PayPalPage extends BasePage {


    Element email = elementById("email");
    Element nextButton = elementById("btnNext");
    Element loginButton = elementById("btnLogin");
    Element completePayment = elementById("payment-submit-btn");
    Element password = elementById("password");
    Element cancelAtEmailPasswordPage = elementByXpath("//div[@class='cancelUrl ']/a");
    Element cancelAtPaypalCheckoutPage= elementByXpath("//div[contains(@class,'CancelLink')]/a");


    @SneakyThrows
    @Step("PayPal - Enter email and click next")
    public PayPalPage enterEmail(TestData testData) {
        try {
            PayPalData payPalData = testData.getTestData(PayPalData.class);
            email.enterText(payPalData.getEmail());
            nextButton.click();
            Thread.sleep(3000);
            return this;
        }catch (Exception e){
            return null;
            }
        }
    @Step("PayPal - Enter Password and click next")
    public PayPalPage enterPassword(TestData testData) {
        PayPalData payPalData = testData.getTestData(PayPalData.class);

        try {
            password.waitUntilElementVisible(30).enterText(payPalData.getPassword());
            loginButton.click();
            Thread.sleep(3000);
            return this;
        }catch (Exception e){
            return  null;
        }
    }

    @Step("PayPal - Complete the payment")
    public void completePayment(TestData testData) {
        try {
            PayPalData payPalData = testData.getTestData(PayPalData.class);
            email.enterText(payPalData.getEmail());
            nextButton.click();
            Thread.sleep(3000);
            password.waitUntilElementVisible(30).enterText(payPalData.getPassword());
            loginButton.click();
            completePayment.click();
        }catch (Exception e){

        }
    }

    @Step("PayPal - Cancel at Email/Password page")
    public void cancelAtEmailPassword( ){
       cancelAtEmailPasswordPage.waitUntilElementClickable(120).click();
    }

    @Step("PayPal - Cancel at PayPal checkout page")
    public void cancelAtPayPalCheckout( ){
        cancelAtPaypalCheckoutPage.click();
    }

}
