package com.rezolve.web.rxp.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.rxp.model.EcommercePlatformData;

import static engine.core.Element.elementByXpath;

public class SelectECommercePlatformPage extends BasePage {

Element searchField = elementByXpath("//input[@type=\"search\"]");
Element bigCommercePlatformText = elementByXpath("//h2[text()='BigCommerce']");
Element shopifyPlatform = elementByXpath("//h2[text()='Shopify']");
Element salesForceCommerceCloudPlatform = elementByXpath("//h2[text()='SalesForce Commerce Cloud']");
Element nextButtonInThreeDSecurePage = elementByXpath("//div[3]/div[3]/div/div/app-confirm-button/button");
Element skipThisStepButton = elementByXpath("//span[text()='Skip This Step']");

    @Step("Search for Big commerce E-Commerce Platform")
     public SelectECommercePlatformPage SearchBigCommerce(TestData testData){
        EcommercePlatformData EcommercePlatformName;
        EcommercePlatformName = testData.getTestData(EcommercePlatformData.class);
        searchField.enterText(EcommercePlatformName.getBigCommerce());
        return this;
    }

    @Step("Search for Shopify E-Commerce Platform")
    public SelectECommercePlatformPage SearchShopify(TestData testData){
        EcommercePlatformData EcommercePlatformName;
        EcommercePlatformName = testData.getTestData(EcommercePlatformData.class);
        searchField.enterText(EcommercePlatformName.getShopify());
        return this;
    }

    @Step("Search for SalesForceCommerceCloud E-Commerce Platform")
    public SelectECommercePlatformPage SearchSalesForceCommerceCloud(TestData testData){
        EcommercePlatformData EcommercePlatformName;
        EcommercePlatformName = testData.getTestData(EcommercePlatformData.class);
        searchField.enterText(EcommercePlatformName.getSalesForceCommerceCloud());
        return this;
    }

    @Step("Select BigCommerce Platform")
    public SelectECommercePlatformPage clickOnBigCommercePlatform(){
        bigCommercePlatformText.click();
        return this;
    }

    @Step("Select shopify Platform Platform")
    public SelectECommercePlatformPage clickOnShopifyPlatform(){
        shopifyPlatform.click();
        return this;
    }

    @Step("Select salesForce Commerce Cloud Platform Platform")
    public SelectECommercePlatformPage clickOnSalesForceCommerceCloudPlatform(){
        salesForceCommerceCloudPlatform.click();
        return this;
    }

    @Step("Click on Next Button")
    public ECommercePlatformDetailsPage clickOnNextButtonInSelectEcommercePlatformPage(){
        nextButtonInThreeDSecurePage.waitUntilElementVisible(10).click();
        return new ECommercePlatformDetailsPage();
    }

    @Step("Click on Next Button")
    public ConfirmationPage clickOnSkipThisStepButton(){
        skipThisStepButton.waitUntilElementVisible(10).click();
        return new ConfirmationPage();
    }

}
