package com.rezolve.web.brain.tests;

import com.rezolve.web.brain.model.LabelsData;
import com.rezolve.web.brain.model.LanguageData;
import com.rezolve.web.brain.model.QueryData;
import com.rezolve.web.brain.model.StoreLinkData;
import com.rezolve.web.brain.pages.ElectronicsStorePage;
import com.rezolve.web.brain.pages.BuyNowPage;
import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.rezolve.web.brain.model.TestDataArranger.defaultMsgContentCase;
import static com.rezolve.web.brain.model.TestDataArranger.electronicsStoreCase;

public class ElectronicsStoreTests extends BaseTest {
    @Test(description = "Verify Brain Response with English Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void englishSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getEnglishSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isEnglishLanguageDetected(), "English language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" - Product "+ind+" th name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Spanish Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void spanishSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getSpanishSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isSpanishLanguageDetected(), "Spanish language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" : "+ind+" th/st Product name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with French Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void frenchSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getFrenchSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isFrenchLanguageDetected(), "French language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" : "+ind+" th/st Product name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Deutsch Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void deutschSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getDeutschSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isDeutschLanguageDetected(), "Deutsch language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" : "+ind+" th/st Product name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Korean Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void koreanSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getKoreanSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isKoreanLanguageDetected(), "Korean language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" : "+ind+" th/st Product name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Arabic Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void arabicSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getArabicSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isArabicLanguageDetected(), "Arabic language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" : "+ind+" th/st Product name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Chinese Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void chineseSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getChineseSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isChineseLanguageDetected(), "Chinese language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" : "+ind+" th/st Product name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with English Suggestions Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void englishSuggestionsQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());

        String firstSuggestedQuery = electronicsStorePage.getFirstSuggestionQuery();
        electronicsStorePage.clickFirstSuggestion();
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(firstSuggestedQuery), "Entered query : "+firstSuggestedQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+firstSuggestedQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isEnglishLanguageDetected(), "English language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"Suggestions Query Product "+ind+" th name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        buyNowPage.clickViewWebsite();
        basePage.switchToTab(0);
        electronicsStorePage.clickShowSuggestion();
        List<WebElement> queries = electronicsStorePage.getAllSuggestionsQuery();
        for(WebElement query: queries){
            String suggestionQuery = query.getText();
            query.click();
            softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(suggestionQuery), "Entered query : "+suggestionQuery+" - mismatch with Searched one");
            softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+suggestionQuery+" - response not displayed within 6 seconds");
            softAssert.assertTrue(electronicsStorePage.isEnglishLanguageDetected(), "English language not detected by Brain");
            softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Suggestion Query : "+suggestionQuery+" - Product/Buy Now Button not displayed");
            electronicsStorePage.clickShowSuggestion();
        }
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Spanish Suggestions Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void spanishSuggestionsQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());

        electronicsStorePage.selectSpanishLanguage();
        String firstSuggestedQuery = electronicsStorePage.getFirstSuggestionQuery();
        String language = basePage.detectLanguage(firstSuggestedQuery);
        softAssert.assertTrue(language.contains(testData.getTestData(LanguageData.class).getSpanishLanguage()), "Suggestions are not displayed in Spanish language");

        electronicsStorePage.clickFirstSuggestion();
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(firstSuggestedQuery), "Entered query : "+firstSuggestedQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+firstSuggestedQuery+" - response not displayed within 6 seconds");
      //  softAssert.assertTrue(brainSearchPage.isSpanishLanguageDetected(), "Spanish language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"Suggestions Query Product "+ind+" th name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        buyNowPage.clickViewWebsite();
        basePage.switchToTab(0);
        electronicsStorePage.clickShowSuggestion();
        List<WebElement> queries = electronicsStorePage.getAllSuggestionsQuery();
        for(WebElement query: queries){
            String suggestionQuery = query.getText();
            query.click();
            softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(suggestionQuery), "Entered query : "+suggestionQuery+" - mismatch with Searched one");
            softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+suggestionQuery+" - response not displayed within 6 seconds");
          //  softAssert.assertTrue(brainSearchPage.isSpanishLanguageDetected(), "Spanish language not detected by Brain");
            softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Suggestion Query : "+suggestionQuery+" - Product/Buy Now Button not displayed");
            electronicsStorePage.clickShowSuggestion();
        }
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with French Suggestions Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void frenchSuggestionsQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());

        electronicsStorePage.selectFrenchLanguage();
        String firstSuggestedQuery = electronicsStorePage.getFirstSuggestionQuery();
        String language = basePage.detectLanguage(firstSuggestedQuery);
        softAssert.assertTrue(language.contains(testData.getTestData(LanguageData.class).getFrenchLanguage()), "Suggestions are not displayed in French language");

        electronicsStorePage.clickFirstSuggestion();
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(firstSuggestedQuery), "Entered query : "+firstSuggestedQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+firstSuggestedQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isSpanishLanguageDetected(), "French language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"Suggestions Query Product "+ind+" th name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        buyNowPage.clickViewWebsite();
        basePage.switchToTab(0);
        electronicsStorePage.clickShowSuggestion();
        List<WebElement> queries = electronicsStorePage.getAllSuggestionsQuery();
        for(WebElement query: queries){
            String suggestionQuery = query.getText();
            query.click();
            softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(suggestionQuery), "Entered query : "+suggestionQuery+" - mismatch with Searched one");
            softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+suggestionQuery+" - response not displayed within 6 seconds");
            //  softAssert.assertTrue(brainSearchPage.isSpanishLanguageDetected(), "French language not detected by Brain");
            softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Suggestion Query : "+suggestionQuery+" - Product/Buy Now Button not displayed");
            electronicsStorePage.clickShowSuggestion();
        }
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Deutsch Suggestions Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void deutschSuggestionsQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());

        electronicsStorePage.selectDeutschLanguage();
        String firstSuggestedQuery = electronicsStorePage.getFirstSuggestionQuery();
        String language = basePage.detectLanguage(firstSuggestedQuery);
        softAssert.assertTrue(language.contains(testData.getTestData(LanguageData.class).getDeutschLanguage()), "Suggestions are not displayed in Deutsch language");

        electronicsStorePage.clickFirstSuggestion();
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(firstSuggestedQuery), "Entered query : "+firstSuggestedQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+firstSuggestedQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isDeutschLanguageDetected(), "Deutsch language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"Suggestions Query Product "+ind+" th name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        buyNowPage.clickViewWebsite();
        basePage.switchToTab(0);
        electronicsStorePage.clickShowSuggestion();
        List<WebElement> queries = electronicsStorePage.getAllSuggestionsQuery();
        for(WebElement query: queries){
            String suggestionQuery = query.getText();
            query.click();
            softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(suggestionQuery), "Entered query : "+suggestionQuery+" - mismatch with Searched one");
            softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+suggestionQuery+" - response not displayed within 6 seconds");
          //  softAssert.assertTrue(brainSearchPage.isDeutschLanguageDetected(), "Deutsch language not detected by Brain");
            softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Suggestion Query : "+suggestionQuery+" - Product/Buy Now Button not displayed");
            electronicsStorePage.clickShowSuggestion();
        }
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Korean Suggestions Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void koreanSuggestionsQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());

        electronicsStorePage.selectKoreanLanguage();
        String firstSuggestedQuery = electronicsStorePage.getFirstSuggestionQuery();
        String language = basePage.detectLanguage(firstSuggestedQuery);
        softAssert.assertTrue(language.contains(testData.getTestData(LanguageData.class).getKoreanLanguage()), "Suggestions are not displayed in Korean language");

        electronicsStorePage.clickFirstSuggestion();
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(firstSuggestedQuery), "Entered query : "+firstSuggestedQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+firstSuggestedQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isKoreanLanguageDetected(), "Korean language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"Suggestions Query Product "+ind+" th name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        buyNowPage.clickViewWebsite();
        basePage.switchToTab(0);
        electronicsStorePage.clickShowSuggestion();
        List<WebElement> queries = electronicsStorePage.getAllSuggestionsQuery();
        for(WebElement query: queries){
            String suggestionQuery = query.getText();
            query.click();
            softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(suggestionQuery), "Entered query : "+suggestionQuery+" - mismatch with Searched one");
            softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+suggestionQuery+" - response not displayed within 6 seconds");
            //  softAssert.assertTrue(brainSearchPage.isKoreanLanguageDetected(), "Korean language not detected by Brain");
            softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Suggestion Query : "+suggestionQuery+" - Product/Buy Now Button not displayed");
            electronicsStorePage.clickShowSuggestion();
        }
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Arabic Suggestions Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void arabicSuggestionsQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());

        electronicsStorePage.selectArabicLanguage();
        String firstSuggestedQuery = electronicsStorePage.getFirstSuggestionQuery();
        String language = basePage.detectLanguage(firstSuggestedQuery);
        softAssert.assertTrue(language.contains(testData.getTestData(LanguageData.class).getArabicLanguage()), "Suggestions are not displayed in Arabic language");

        electronicsStorePage.clickFirstSuggestion();
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(firstSuggestedQuery), "Entered query : "+firstSuggestedQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+firstSuggestedQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isArabicLanguageDetected(), "Arabic language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"Suggestions Query Product "+ind+" th name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        buyNowPage.clickViewWebsite();
        basePage.switchToTab(0);
        electronicsStorePage.clickShowSuggestion();
        List<WebElement> queries = electronicsStorePage.getAllSuggestionsQuery();
        for(WebElement query: queries){
            String suggestionQuery = query.getText();
            query.click();
            softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(suggestionQuery), "Entered query : "+suggestionQuery+" - mismatch with Searched one");
            softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+suggestionQuery+" - response not displayed within 6 seconds");
            //  softAssert.assertTrue(brainSearchPage.isArabicLanguageDetected(), "Arabic language not detected by Brain");
            softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Suggestion Query : "+suggestionQuery+" - Product/Buy Now Button not displayed");
            electronicsStorePage.clickShowSuggestion();
        }
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Chinese Suggestions Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void chineseSuggestionsQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());

        electronicsStorePage.selectChineseLanguage();
        String firstSuggestedQuery = electronicsStorePage.getFirstSuggestionQuery();
        String language = basePage.detectLanguage(firstSuggestedQuery);
        softAssert.assertTrue(language.contains(testData.getTestData(LanguageData.class).getChineseLanguage()), "Suggestions are not displayed in Chinese language");

        electronicsStorePage.clickFirstSuggestion();
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(firstSuggestedQuery), "Entered query : "+firstSuggestedQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+firstSuggestedQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isChineseLanguageDetected(), "Chinese language not detected by Brain");

        List<WebElement> productName = electronicsStorePage.getProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"Suggestions Query Product "+ind+" th name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");

        buyNowPage.clickViewWebsite();
        basePage.switchToTab(0);
        electronicsStorePage.clickShowSuggestion();
        List<WebElement> queries = electronicsStorePage.getAllSuggestionsQuery();
        for(WebElement query: queries){
            String suggestionQuery = query.getText();
            query.click();
            softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(suggestionQuery), "Entered query : "+suggestionQuery+" - mismatch with Searched one");
            softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Suggestions Query : "+suggestionQuery+" - response not displayed within 6 seconds");
            //  softAssert.assertTrue(brainSearchPage.isChineseLanguageDetected(), "Chinese language not detected by Brain");
            softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Suggestion Query : "+suggestionQuery+" - Product/Buy Now Button not displayed");
            electronicsStorePage.clickShowSuggestion();
        }
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with English Follow Up Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void englishFollowUpQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getEnglishSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isEnglishLanguageDetected(), "English language not detected by Brain");
        softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Entered Query : "+query+" -Buy Now buttons not displayed");

        String followUpQuery = testData.getTestData(QueryData.class).getEnglishFollowUpQuery();
        electronicsStorePage.clickAskFollowUpQuery().enterYourFollowUpQuery(followUpQuery);
        softAssert.assertTrue(electronicsStorePage.getFollowUpSearchedQuery().contains(followUpQuery), "Follow up query : "+followUpQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isFollowUpQueryResponseDisplayed(), "Follow up Query : "+followUpQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isFollowUpQueryBuyNowButtonDisplayed(),"Follow up Query : "+followUpQuery+" -Buy Now buttons not displayed");

        List<WebElement> productName = electronicsStorePage.getFollowUpQueryProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getFollowUpQueryBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Follow up Query : "+followUpQuery+" - Product "+ind+1+" st/nd name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Spanish Follow Up Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void spanishFollowUpQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getSpanishSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isSpanishLanguageDetected(), "Spanish language not detected by Brain");
        softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Entered Query : "+query+" -Buy Now buttons not displayed");

        String followUpQuery = testData.getTestData(QueryData.class).getSpanishFollowUpQuery();
        electronicsStorePage.clickAskFollowUpQuery().enterYourFollowUpQuery(followUpQuery);
        softAssert.assertTrue(electronicsStorePage.getFollowUpSearchedQuery().contains(followUpQuery), "Follow up query : "+followUpQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isFollowUpQueryResponseDisplayed(), "Follow up Query : "+followUpQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isFollowUpQueryBuyNowButtonDisplayed(),"Follow up Query : "+followUpQuery+" -Buy Now buttons not displayed");

        List<WebElement> productName = electronicsStorePage.getFollowUpQueryProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getFollowUpQueryBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Follow up Query : "+followUpQuery+" - Product "+ind+1+" st/nd name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with French Follow Up Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void frenchFollowUpQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getFrenchSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isFrenchLanguageDetected(), "French language not detected by Brain");
        softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Entered Query : "+query+" -Buy Now buttons not displayed");

        String followUpQuery = testData.getTestData(QueryData.class).getFrenchFollowUpQuery();
        electronicsStorePage.clickAskFollowUpQuery().enterYourFollowUpQuery(followUpQuery);
        softAssert.assertTrue(electronicsStorePage.getFollowUpSearchedQuery().contains(followUpQuery), "Follow up query : "+followUpQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isFollowUpQueryResponseDisplayed(), "Follow up Query : "+followUpQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isFollowUpQueryBuyNowButtonDisplayed(),"Follow up Query : "+followUpQuery+" -Buy Now buttons not displayed");

        List<WebElement> productName = electronicsStorePage.getFollowUpQueryProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getFollowUpQueryBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Follow up Query : "+followUpQuery+" - Product "+ind+1+" st/nd name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Deutsch Follow Up Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void deutschFollowUpQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getDeutschSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isDeutschLanguageDetected(), "Deutsch language not detected by Brain");
        softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Entered Query : "+query+" -Buy Now buttons not displayed");

        String followUpQuery = testData.getTestData(QueryData.class).getDeutschFollowUpQuery();
        electronicsStorePage.clickAskFollowUpQuery().enterYourFollowUpQuery(followUpQuery);
        softAssert.assertTrue(electronicsStorePage.getFollowUpSearchedQuery().contains(followUpQuery), "Follow up query : "+followUpQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isFollowUpQueryResponseDisplayed(), "Follow up Query : "+followUpQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isFollowUpQueryBuyNowButtonDisplayed(),"Follow up Query : "+followUpQuery+" -Buy Now buttons not displayed");

        List<WebElement> productName = electronicsStorePage.getFollowUpQueryProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getFollowUpQueryBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Follow up Query : "+followUpQuery+" - Product "+ind+1+" st/nd name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Korean Follow Up Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void koreanFollowUpQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getKoreanSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isKoreanLanguageDetected(), "Korean language not detected by Brain");
        softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Entered Query : "+query+" -Buy Now buttons not displayed");

        String followUpQuery = testData.getTestData(QueryData.class).getKoreanFollowUpQuery();
        electronicsStorePage.clickAskFollowUpQuery().enterYourFollowUpQuery(followUpQuery);
        softAssert.assertTrue(electronicsStorePage.getFollowUpSearchedQuery().contains(followUpQuery), "Follow up query : "+followUpQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isFollowUpQueryResponseDisplayed(), "Follow up Query : "+followUpQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isFollowUpQueryBuyNowButtonDisplayed(),"Follow up Query : "+followUpQuery+" -Buy Now buttons not displayed");

        List<WebElement> productName = electronicsStorePage.getFollowUpQueryProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getFollowUpQueryBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Follow up Query : "+followUpQuery+" - Product "+ind+1+" st/nd name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Arabic Follow Up Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void arabicFollowUpQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getArabicSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isArabicLanguageDetected(), "Arabic language not detected by Brain");
        softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Entered Query : "+query+" -Buy Now buttons not displayed");

        String followUpQuery = testData.getTestData(QueryData.class).getArabicFollowUpQuery();
        electronicsStorePage.clickAskFollowUpQuery().enterYourFollowUpQuery(followUpQuery);
        softAssert.assertTrue(electronicsStorePage.getFollowUpSearchedQuery().contains(followUpQuery), "Follow up query : "+followUpQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isFollowUpQueryResponseDisplayed(), "Follow up Query : "+followUpQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isFollowUpQueryBuyNowButtonDisplayed(),"Follow up Query : "+followUpQuery+" -Buy Now buttons not displayed");

        List<WebElement> productName = electronicsStorePage.getFollowUpQueryProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getFollowUpQueryBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Follow up Query : "+followUpQuery+" - Product "+ind+1+" st/nd name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Chinese Follow Up Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void chineseFollowUpQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        BuyNowPage buyNowPage = new BuyNowPage();
        TestData testData= electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getChineseSampleQuery();
        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isChineseLanguageDetected(), "Chinese language not detected by Brain");
        softAssert.assertTrue(electronicsStorePage.isBuyNowButtonDisplayed(),"Entered Query : "+query+" -Buy Now buttons not displayed");

        String followUpQuery = testData.getTestData(QueryData.class).getChineseFollowUpQuery();
        electronicsStorePage.clickAskFollowUpQuery().enterYourFollowUpQuery(followUpQuery);
        softAssert.assertTrue(electronicsStorePage.getFollowUpSearchedQuery().contains(followUpQuery), "Follow up query : "+followUpQuery+" - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.isFollowUpQueryResponseDisplayed(), "Follow up Query : "+followUpQuery+" - response not displayed within 6 seconds");
        softAssert.assertTrue(electronicsStorePage.isFollowUpQueryBuyNowButtonDisplayed(),"Follow up Query : "+followUpQuery+" -Buy Now buttons not displayed");

        List<WebElement> productName = electronicsStorePage.getFollowUpQueryProductsName();
        int ind = 0;
        List<WebElement> buyNowButton = electronicsStorePage.getFollowUpQueryBuyNowButtons();
        for(WebElement element: buyNowButton) {
            String name = productName.get(ind).getText();
            electronicsStorePage.clickBuyNow(element);
            basePage.switchToTab(1);
            softAssert.assertTrue(buyNowPage.getTrimmedProductName().contains(name),"For Follow up Query : "+followUpQuery+" - Product "+ind+1+" st/nd name mismatch");
            basePage.close();
            basePage.switchToTab(0);
            ind = ind + 1;
        }

        Reporter.log("Product Buy Now Journey", true);
        buyNowButton.get(0).click();
        basePage.switchToTab(1);
        String productNameOnBuyNowPage = buyNowPage.getProductName();
        String shippingAddressOnBuyNowPage = buyNowPage.getShippingAddress();
        String cardDetailsOnBuyNowPage = buyNowPage.getCardDetails();
        buyNowPage.clickInstantBuy();
        softAssert.assertTrue(buyNowPage.isOrderSuccessful(), "Order is not placed and payment failed");
        softAssert.assertTrue(buyNowPage.isOrderedProductNameCorrectInSummary(productNameOnBuyNowPage), "Order summary - Product name mismatch");
        softAssert.assertTrue(buyNowPage.getQuantity(productNameOnBuyNowPage).contains("1"), "Order summary - Quantity Mismatch. Actual value: 1");
        softAssert.assertTrue(buyNowPage.isShippingAddressCorrect(shippingAddressOnBuyNowPage), "Order summary - Shipping Address Mismatch");
        softAssert.assertTrue(buyNowPage.isCardDetailsCorrect(cardDetailsOnBuyNowPage),"Order summary - Card Details Mismatch");
        softAssert.assertTrue(buyNowPage.isViewWebSiteButtonDisplayed(),"View Website button not displayed");
        softAssert.assertAll();
    }
    @Test(description = "Verify Default Message For Product Not Available for English Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void englishDefaultMessageForProductNotAvailableTests() {
        SoftAssert softAssert = new SoftAssert();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        TestData testData = defaultMsgContentCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getEngSampleQuery();
        String defaultMessage = testData.getTestData(QueryData.class).getEngMessageContent();

        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : " + query + " - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.getDefaultMessage().contains(defaultMessage), "Default message content for product not available in store mismatch");
    }
    @Test(description = "Verify Default Message For Product Not Available for Spanish Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void spanishDefaultMessageForProductNotAvailableTests() {
        SoftAssert softAssert = new SoftAssert();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        TestData testData = defaultMsgContentCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getSpanSampleQuery();
        String defaultMessage = testData.getTestData(QueryData.class).getSpanMessageContent();

        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : " + query + " - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.getDefaultMessage().contains(defaultMessage), "Default message content for product not available in store mismatch");
    }
    @Test(description = "Verify Default Message For Product Not Available for French Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void frenchDefaultMessageForProductNotAvailableTests() {
        SoftAssert softAssert = new SoftAssert();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        TestData testData = defaultMsgContentCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getFrSampleQuery();
        String defaultMessage = testData.getTestData(QueryData.class).getFrMessageContent();

        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : " + query + " - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.getDefaultMessage().contains(defaultMessage), "Default message content for product not available in store mismatch");
    }
    @Test(description = "Verify Default Message For Product Not Available for Deutsch Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void deutschDefaultMessageForProductNotAvailableTests() {
        SoftAssert softAssert = new SoftAssert();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        TestData testData = defaultMsgContentCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getDeuSampleQuery();
        String defaultMessage = testData.getTestData(QueryData.class).getDeuMessageContent();

        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : " + query + " - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.getDefaultMessage().contains(defaultMessage), "Default message content for product not available in store mismatch");
    }
    @Test(description = "Verify Default Message For Product Not Available for Korean Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void koreanDefaultMessageForProductNotAvailableTests() {
        SoftAssert softAssert = new SoftAssert();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        TestData testData = defaultMsgContentCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getKorSampleQuery();
        String defaultMessage = testData.getTestData(QueryData.class).getKorMessageContent();

        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : " + query + " - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.getDefaultMessage().contains(defaultMessage), "Default message content for product not available in store mismatch");
    }
    @Test(description = "Verify Default Message For Product Not Available for Arabic Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void arabicDefaultMessageForProductNotAvailableTests() {
        SoftAssert softAssert = new SoftAssert();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        TestData testData = defaultMsgContentCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getArabSampleQuery();
        String defaultMessage = testData.getTestData(QueryData.class).getArabMessageContent();

        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : " + query + " - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.getDefaultMessage().contains(defaultMessage), "Default message content for product not available in store mismatch");
    }
    @Test(description = "Verify Default Message For Product Not Available for Chinese Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void chineseDefaultMessageForProductNotAvailableTests() {
        SoftAssert softAssert = new SoftAssert();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        TestData testData = defaultMsgContentCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getChinaSampleQuery();
        String defaultMessage = testData.getTestData(QueryData.class).getChinaMessageContent();

        electronicsStorePage.enterYourQuery(query);
        softAssert.assertTrue(electronicsStorePage.getSearchedQuery().contains(query), "Entered query : " + query + " - mismatch with Searched one");
        softAssert.assertFalse(electronicsStorePage.getDefaultMessage().contains(defaultMessage), "Default message content for product not available in store mismatch");
    }
    @Test(description = "Verify Search Query Input Field Placeholder Text", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void searchQueryInputFieldPlaceholderTextTest() {
        SoftAssert softAssert = new SoftAssert();
        ElectronicsStorePage electronicsStorePage = new ElectronicsStorePage();
        TestData testData = electronicsStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        LabelsData placeholderText = testData.getTestData(LabelsData.class);

        String englishText = electronicsStorePage.selectEnglishLanguage().getQuerySearchFieldPlaceholderAttribute();
        softAssert.assertTrue(englishText.contains(placeholderText.getEnglishText()), "For English Language placeholder text mismatch ");

        String spanishText = electronicsStorePage.clickLanguageDropdown().selectSpanishLanguage().getQuerySearchFieldPlaceholderAttribute();
        softAssert.assertTrue(spanishText.contains(placeholderText.getSpanishText()), "For Spanish Language placeholder text mismatch ");

        String frenchText = electronicsStorePage.selectFrenchLanguage().getQuerySearchFieldPlaceholderAttribute();
        softAssert.assertTrue(frenchText.contains(placeholderText.getFrenchText()), "For French Language placeholder text mismatch ");

        String deutschText = electronicsStorePage.selectDeutschLanguage().getQuerySearchFieldPlaceholderAttribute();
        softAssert.assertTrue(deutschText.contains(placeholderText.getDeutschText()), "For Deutsch Language placeholder text mismatch ");

        String koreanText = electronicsStorePage.selectKoreanLanguage().getQuerySearchFieldPlaceholderAttribute();
        softAssert.assertTrue(koreanText.contains(placeholderText.getKoreanText()), "For Korean Language placeholder text mismatch ");

        String arabicText = electronicsStorePage.selectArabicLanguage().getQuerySearchFieldPlaceholderAttribute();
        softAssert.assertTrue(arabicText.contains(placeholderText.getArabicText()), "For Arabic Language placeholder text mismatch ");

        String chineseText = electronicsStorePage.selectChineseLanguage().getQuerySearchFieldPlaceholderAttribute();
        softAssert.assertTrue(chineseText.contains(placeholderText.getChineseText()), "For Chinese Language placeholder text mismatch ");

       softAssert.assertAll();

    }
}
