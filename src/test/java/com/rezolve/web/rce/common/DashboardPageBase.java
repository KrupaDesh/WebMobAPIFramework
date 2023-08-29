package com.rezolve.web.rce.common;

import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class DashboardPageBase extends AbstractPage {

    public DashboardPageBase (WebDriver driver){super(driver);}

    public abstract CatalogProductPageBase navigateToProductPage();

    public abstract CatalogCategoryPageBase navigateToCategoryPage();

}
