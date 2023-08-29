package com.rezolve.web.ic.pages;

import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;

import static engine.core.Element.elementByXpath;

public class SignInOptionsPage extends BasePage {

    Element signInWithPhoneNumber = elementByXpath("//rezolve-frontend-sign-in-options//button");
    Element facebook = elementByXpath("//rezolve-frontend-sign-in-options//a/span[contains(text(),\"Facebook\")]");
    Element google = elementByXpath("//rezolve-frontend-sign-in-options//a/span[contains(text(),\"Google\")]");
    Element apple = elementByXpath("//rezolve-frontend-sign-in-options//a/span[contains(text(),\"Apple\")]");
    Element checkoutInAnInstantWithARezolveAccountLabel = elementByXpath("(//rezolve-frontend-sign-in-options/div/p)[2]");
    Element pageTitle = elementByXpath("(//rezolve-frontend-sign-in-options/div/p)[1]");
    Element signInWithPhoneNumberLabel = elementByXpath("//rezolve-frontend-sign-in-options/div/button/span[1]");
    Element facebookLabel = elementByXpath("//rezolve-frontend-sign-in-options/div/a[1]/span[1]");
    Element googleLabel = elementByXpath("//rezolve-frontend-sign-in-options/div/a[2]/span[1]");
    Element appleLabel = elementByXpath("//rezolve-frontend-sign-in-options/div/a[3]/span[1]");
    Element orLabel = elementByXpath("//rezolve-frontend-sign-in-options/div/span");


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
    public MobileLoginPage clickPhoneNumber(){
        signInWithPhoneNumber.click();
        return new MobileLoginPage();
    }

    @Step("Continue with Facebook")
    public FacebookPage clickFacebook(){
        screenshot();
        facebook.click();
        return new FacebookPage();
    }

    @Step("Continue with Google")
    public GoogleLoginPage clickGoogle(){
        screenshot();
        google.click();
        return new GoogleLoginPage();
    }

    @Step("Continue with Apple")
    public void clickApple(){
        apple.click();
    }

    @Step("Verify all the login options are displayed")
    public boolean areAllLoginOptionsDisplayed(){
        screenshot();
        if(signInWithPhoneNumber.isElementDisplayed() && google.isElementDisplayed() && facebook.isElementDisplayed() && apple.isElementDisplayed())
            return true;
        else
            return  false;
    }

}
