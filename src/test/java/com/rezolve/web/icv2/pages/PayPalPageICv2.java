package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import com.rezolve.web.icv2.model.PayPalDataICv2;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class PayPalPageICv2 extends BasePage {


    Element email = elementById("email");
    Element nextButton = elementById("btnNext");
    Element loginButton = elementById("btnLogin");
    Element completePayment = elementById("payment-submit-btn");
    Element password = elementById("password");
    Element cancelAtEmailPasswordPage = elementByXpath("//div[@class='cancelUrl ']/a");
    Element cancelAtPaypalCheckoutPage= elementByXpath("//div[contains(@class,'CancelLink')]/a");
    Element acceptCookiesButton = elementByXpath("//button[text()=\"Accept\"] | //button[@id=\"acceptAllButton\"] | //button[@class=\"ccpaCookieBanner_accept-button\"]");

    @SneakyThrows
    @Step("PayPal - Enter email and click next")
    public PayPalPageICv2 enterEmail(TestData testData) {
        screenshot();
        try {
            PayPalDataICv2 payPalData = testData.getTestData(PayPalDataICv2.class);
            email.enterText(payPalData.getEmail());
            nextButton.click();
            Thread.sleep(3000);
            return this;
        }catch (Exception e){
            return null;
            }
        }
    @Step("PayPal - Enter Password and click next")
    public PayPalPageICv2 enterPassword(TestData testData) {
        PayPalDataICv2 payPalData = testData.getTestData(PayPalDataICv2.class);
        screenshot();
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
        screenshot();
        try {
            PayPalDataICv2 payPalData = testData.getTestData(PayPalDataICv2.class);
            if(driver.findElements(By.xpath("//button[text()=\"Accept\"] | //button[@id=\"acceptAllButton\"] | //button[@class=\"ccpaCookieBanner_accept-button\"]")).size()>0){
                acceptCookiesButton.click();
            }
            email.enterText(payPalData.getEmail());
            nextButton.click();
            screenshot();
            Thread.sleep(3000);
            if(driver.findElements(By.xpath("//button[text()=\"Accept\"] | //button[@id=\"acceptAllButton\"] | //button[@class=\"ccpaCookieBanner_accept-button\"]")).size()>0){
               acceptCookiesButton.click();
            }
            password.waitUntilElementVisible(30).enterText(payPalData.getPassword());
            screenshot();
            loginButton.click();
            screenshot();
            if(driver.findElements(By.xpath("//button[text()=\"Accept\"] | //button[@id=\"acceptAllButton\"] | //button[@class=\"ccpaCookieBanner_accept-button\"]")).size()>0){
                acceptCookiesButton.click();
            }
            completePayment.click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Step("PayPal - Cancel at Email/Password page")
    public void cancelAtEmailPassword( ){
       cancelAtEmailPasswordPage.waitUntilElementClickable(120).click();
       screenshot();
    }

    @Step("PayPal - Cancel at PayPal checkout page")
    public void cancelAtPayPalCheckout( ){
        cancelAtPaypalCheckoutPage.scrollDownUtillFindElement().waitUntilElementClickable(25).click();
        screenshot();
    }
//    @Step("PayPal - Cancel at PayPal checkout page")
//    public void acceptCookies( ){
//        By cookies_accept = By.xpath("//*[@title='Accept Cookies']");
//        By cookies_gotIt = By.xpath("//a[text()='Got it!']");
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(cookies_accept)).click();
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(cookies_accept));
//        wait.until(ExpectedConditions.elementToBeClickable(cookies_gotIt)).click();
//    }

}
