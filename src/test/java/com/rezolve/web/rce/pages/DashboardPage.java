package com.rezolve.web.rce.pages;

import com.rezolve.web.rce.common.CatalogCategoryPageBase;
import com.rezolve.web.rce.common.CatalogProductPageBase;
import com.rezolve.web.rce.common.DashboardPageBase;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends DashboardPageBase {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    String pageTitle = driver.getTitle();

    @FindBy(linkText = "Catalog")
    ExtendedWebElement CatalogTab;

    @FindBy(linkText = "Products")
    ExtendedWebElement Products;
    @FindBy(linkText = "Categories")
    ExtendedWebElement Categories;

    @Override
    public CatalogProductPageBase navigateToProductPage() {
        CatalogTab.click();
        Products.click();
        return initPage(getDriver(), CatalogProductPageBase.class) ;
    }

    @Override
    public CatalogCategoryPageBase navigateToCategoryPage() {
        CatalogTab.click();
        Categories.click();
        return initPage(getDriver(), CatalogCategoryPageBase.class) ;
    }

}
