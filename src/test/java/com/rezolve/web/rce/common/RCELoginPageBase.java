package com.rezolve.web.rce.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class RCELoginPageBase extends AbstractPage {

    public RCELoginPageBase(WebDriver driver) { super(driver);}

    public abstract void typeUsername(String name);

    public abstract void typePassword(String password);

    public abstract void clickSignInButton();
    //DashboardPageBase




}
