package com.rezolve.web.rxp.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.rxp.model.EcommercePlatformData;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class ECommercePlatformDetailsPage extends BasePage {

Element nameField = elementById("name");
Element storeURLField = elementById("store-url");
Element bigCommerceAPIClientIDField = elementById("bigCommerceApiClientId");
Element bigCommerceApiAccessTokenField = elementById("bigCommerceApiAccessToken");
Element shopifyApiAccessTokenField = elementById("shopifyAccessToken");
Element bigCommerceApiContextField = elementById("bigCommerceApiContext");
Element nextButtonInEcommercePlatformDetailsPage = elementByXpath("//div[3]/div[3]/div/div/app-confirm-button/button");


    @Step("Enter Name for Big Commerce")
    public ECommercePlatformDetailsPage enterName(TestData testData) {
        EcommercePlatformData ECommercePlatformData;
        ECommercePlatformData= testData.getTestData(EcommercePlatformData.class);
        nameField.enterText(ECommercePlatformData.getName());
        return this;
    }

    @Step("Enter Name for Shopify")
    public ECommercePlatformDetailsPage enterNameForShopify(TestData testData) {
        EcommercePlatformData ECommercePlatformData;
        ECommercePlatformData= testData.getTestData(EcommercePlatformData.class);
        nameField.enterText(ECommercePlatformData.getNameForShopify());
        return this;
    }

    @Step("Enter Store URL for Big Commerce")
    public ECommercePlatformDetailsPage enterStoreURL(TestData testData) {
        EcommercePlatformData ECommercePlatformData;
        ECommercePlatformData= testData.getTestData(EcommercePlatformData.class);
        storeURLField.enterText(ECommercePlatformData.getStoreURL());
        return this;
    }

    @Step("Enter Store URL for Shopify")
    public ECommercePlatformDetailsPage enterStoreURLForShopify(TestData testData) {
        EcommercePlatformData ECommercePlatformData;
        ECommercePlatformData= testData.getTestData(EcommercePlatformData.class);
        storeURLField.enterText(ECommercePlatformData.getStoreURLForShopify());
        return this;
    }

    @Step("Enter Big Commerce API Client ID")
    public ECommercePlatformDetailsPage enterBigCommerceAPIClientID(TestData testData) {
        EcommercePlatformData ECommercePlatformData;
        ECommercePlatformData= testData.getTestData(EcommercePlatformData.class);
        bigCommerceAPIClientIDField.enterText(ECommercePlatformData.getClientID());
        return this;
    }

    @Step("Enter Big Commerce Access Token")
    public ECommercePlatformDetailsPage enterBigCommerceApiAccessToken(TestData testData) {
        EcommercePlatformData ECommercePlatformData;
        ECommercePlatformData= testData.getTestData(EcommercePlatformData.class);
        bigCommerceApiAccessTokenField.enterText(ECommercePlatformData.getAccessToken());
        return this;
    }

    @Step("Enter Shopify Access Token")
    public ECommercePlatformDetailsPage enterApiAccessTokenForShopify(TestData testData) {
        EcommercePlatformData ECommercePlatformData;
        ECommercePlatformData= testData.getTestData(EcommercePlatformData.class);
        shopifyApiAccessTokenField.enterText(ECommercePlatformData.getAccessTokenForShopify());
        return this;
    }

    @Step("Enter Big Commerce Context")
    public ECommercePlatformDetailsPage enterBigCommerceApiContextField(TestData testData) {
        EcommercePlatformData ECommercePlatformData;
        ECommercePlatformData= testData.getTestData(EcommercePlatformData.class);
        bigCommerceApiContextField.enterText(ECommercePlatformData.getContext());
        return this;
    }

    @Step("Click on Next Button")
    public ConfirmationPage clickOnNextButtonInEcommercePlatformDetailsPage(){
        nextButtonInEcommercePlatformDetailsPage.waitUntilElementVisible(10).click();
        return new ConfirmationPage();
    }

}
