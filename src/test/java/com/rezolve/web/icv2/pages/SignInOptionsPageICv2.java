package com.rezolve.web.icv2.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static engine.core.Base.getDriver;
import static engine.core.Element.elementByXpath;

public class SignInOptionsPageICv2 extends BasePage {

    Element signInWithPhoneNumber = elementByXpath("//ic-login//button/span[contains(text(), \"Sign in\")]");
    //@FindBy(xpath="/html/body/ic-root/div/ic-product-detail/form/div/div[1]/div[2]/ic-login/div/div/div[2]/button")
    //WebElement signInWithPhoneNumber;
    Element facebook = elementByXpath("//ic-login//button/span[contains(text(), \"Facebook\")]");
    //@FindBy(xpath = "//span[text()=' Continue with Facebook ']")
    //ExtendedWebElement facebook;
    Element google = elementByXpath("//ic-login//div[5]/button");
    //@FindBy(xpath = "//span[text()=' Continue with Google ']")
          //  ExtendedWebElement google;
    Element apple = elementByXpath("//ic-login//div[6]/button");
    //@FindBy(xpath ="//span[text()=' Continue with Apple ']" )
            //ExtendedWebElement apple;
    Element checkoutInAnInstantWithARezolveAccountLabel = elementByXpath("//ic-login//p[contains(text(),\" Sobald du angemeldet bist, kannst du sofort einen Kauf tätigen. \")]");
    Element pageTitle = elementByXpath("//ic-login//h2[contains(text(),\"Instant Buy\")]");
    Element signInWithPhoneNumberLabel = elementByXpath("//ic-login//button//span[contains(text(),\"Mobilfunknummer\")]");
    Element facebookLabel = elementByXpath("//ic-login//button//span[contains(text(),\"Facebook\")]");
    Element googleLabel = elementByXpath("//ic-login//button//span[contains(text(),\"Google\")]");
    Element appleLabel = elementByXpath("//ic-login//button//span[contains(text(),\"Apple\")]");
    Element orLabel = elementByXpath("//ic-login//div[contains(text(),\"or\")]");


    @Step("Get Page Title")
    public String getPageTitle(){
        screenshot();
       return pageTitle.getText();
    }
    @Step("Get CheckoutInAnInstantWithARezolveAccountLabel")
    public String getCheckoutInAnInstantWithARezolveAccountLabel(){
        return checkoutInAnInstantWithARezolveAccountLabel.getText();
    }
    @Step("Get Phone number button label")
    public String getPhoneNumberLabel(){
        screenshot();
        return signInWithPhoneNumberLabel.getText();
    }

    @Step("Get Facebook button label")
    public String getFacebookLabel(){
        return facebookLabel.getText();
    }

    @Step("Get Google button label")
    public String getGoogleLabel(){
        return googleLabel.getText();
    }

    @Step("Get Apple button label")
    public String getAppleLabel(){
        return appleLabel.getText();
    }
    @Step("Get or test")
    public String getOr(){
        return orLabel.getText();
    }


    @Step("Sign in with Phone Number")
    public MobileLoginPageICv2 clickPhoneNumber(){
        screenshot();
        signInWithPhoneNumber.click();
        return new MobileLoginPageICv2();
    }

    @SneakyThrows
    @Step("Continue with Facebook")
    public FacebookPageICv2 clickFacebook(TestData testData){
        BasePage basePage = new BasePage();
        Thread.sleep(5000);
        screenshot();
        facebook.click();
        if(basePage.getPlatformName().equalsIgnoreCase("MAC") || basePage.getPlatformName().equalsIgnoreCase("IOS")  ){
            basePage.switchToTab(0);}
        else{basePage.switchToTab(1);}
        new FacebookPageICv2().login(testData);
        Thread.sleep(7000);
        basePage.switchToTab(0);
        return new FacebookPageICv2();
    }

    @Step("Continue with Google")
    public GoogleLoginPageICv2 clickGoogle(){
        screenshot();
        google.click();
        return new GoogleLoginPageICv2();
    }

    @Step("Continue with Apple")
    public void clickApple(){
        apple.click();
    }

    @Step("Verify all the login options are displayed")
    public boolean areAllLoginOptionsDisplayed(){
        screenshot();
        if(signInWithPhoneNumber.getElement().isDisplayed() && google.isElementDisplayed() && facebook.isElementDisplayed() && apple.isElementDisplayed())
            //if(signInWithPhoneNumber.isDisplayed() && google.isVisible() && facebook.isVisible() && apple.isVisible())
                    return true;
        else
            return  false;
    }
    @Step("Sign in with Phone Number for German Flow")
    public MobileLoginPageICv2 clickPhoneNumberGermanFlow(){
        signInWithPhoneNumberLabel.click();
        return new MobileLoginPageICv2();
    }

}
