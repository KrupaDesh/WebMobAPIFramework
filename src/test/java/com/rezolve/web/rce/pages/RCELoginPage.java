package com.rezolve.web.rce.pages;

import com.rezolve.web.rce.common.RCELoginPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class RCELoginPage extends RCELoginPageBase {

    public RCELoginPage(WebDriver driver){super(driver);
    }

    @FindBy(id="username")
    private ExtendedWebElement Username;

    @FindBy(id="login")
    private ExtendedWebElement Password;

    @FindBy(xpath = "//span[text()='Sign in']")
    private ExtendedWebElement SignInButton;

    @FindBy(className = "messages")
    private ExtendedWebElement SignInSuccessMessage;

    @FindBy(className = "logo-img")
    private ExtendedWebElement RezolveLogo;

    @Step("Enter Username")
    public void typeUsername(String name){
        Username.type(name);
    }

    @Step("Enter Password")
    public  void typePassword(String password) {
        Password.type(password);
    }

    @Step("Click Sign in Button and Navigate to Dashboard")
    public void clickSignInButton() {
        SignInButton.click();
        //return initPage(getDriver(),DashboardPageBase.class);
    }


}
