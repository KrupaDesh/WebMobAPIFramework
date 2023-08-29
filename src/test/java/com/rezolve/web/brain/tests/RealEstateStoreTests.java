package com.rezolve.web.brain.tests;

import com.rezolve.web.brain.model.QueryData;
import com.rezolve.web.brain.model.StoreLinkData;
import com.rezolve.web.brain.pages.ActNowPage;
import com.rezolve.web.brain.pages.ElectronicsStorePage;
import com.rezolve.web.brain.pages.BuyNowPage;
import com.rezolve.web.brain.pages.RealEstateStorePage;
import com.rezolve.web.icv2.pages.OrderSummaryPageICv2;
import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static com.rezolve.web.brain.model.TestDataArranger.electronicsStoreCase;
import static com.rezolve.web.brain.model.TestDataArranger.realEstateStoreCase;

public class RealEstateStoreTests extends BaseTest {
    @Test(description = "Verify Brain Response with English Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void englishSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RealEstateStorePage realEstateStorePage = new RealEstateStorePage();
        ActNowPage actNowPage = new ActNowPage();
        TestData testData= realEstateStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getEnglishSampleQuery();
        realEstateStorePage.enterYourQuery(query);
        softAssert.assertTrue(realEstateStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(realEstateStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(realEstateStorePage.isEnglishLanguageDetected(), "English language not detected by Brain");

        List<WebElement> productName = realEstateStorePage.getProductsName();
        int ind = 0;
        List<WebElement> actNowButton = realEstateStorePage.getActNowButtons();
        for(WebElement element: actNowButton) {
            String name = productName.get(ind).getText();
            System.out.println("Name on real estate page: "+name);
            realEstateStorePage.clickActNow(element);
            softAssert.assertTrue(actNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" - Product "+ind+" th name mismatch");
            basePage.clickOutside();
            ind = ind + 1;
        }

        Reporter.log("Product Act Now Journey", true);
        String propertyName = productName.get(0).getText();
        actNowButton.get(0).click();
        actNowPage.clickInstantAct().clickFacebook(testData);
        actNowPage.verifyActSubmission(propertyName).assertAll();
        actNowPage.clickDoneButton();
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Spanish Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void spanishSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RealEstateStorePage realEstateStorePage = new RealEstateStorePage();
        ActNowPage actNowPage = new ActNowPage();
        TestData testData= realEstateStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getSpanishSampleQuery();
        realEstateStorePage.enterYourQuery(query);
        softAssert.assertTrue(realEstateStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(realEstateStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(realEstateStorePage.isSpanishLanguageDetected(), "Spanish language not detected by Brain");

        List<WebElement> productName = realEstateStorePage.getProductsName();
        int ind = 0;
        List<WebElement> actNowButton = realEstateStorePage.getActNowButtons();
        for(WebElement element: actNowButton) {
            String name = productName.get(ind).getText();
            System.out.println("Name on real estate page: "+name);
            realEstateStorePage.clickActNow(element);
            softAssert.assertTrue(actNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" - Product "+ind+" th name mismatch");
            basePage.clickOutside();
            ind = ind + 1;
        }

        Reporter.log("Product Act Now Journey", true);
        String propertyName = productName.get(0).getText();
        actNowButton.get(0).click();
        actNowPage.clickInstantAct().clickFacebook(testData);
        actNowPage.verifyActSubmission(propertyName).assertAll();
        actNowPage.clickDoneButton();
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with French Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void frenchSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RealEstateStorePage realEstateStorePage = new RealEstateStorePage();
        ActNowPage actNowPage = new ActNowPage();
        TestData testData= realEstateStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getFrenchSampleQuery();
        realEstateStorePage.enterYourQuery(query);
        softAssert.assertTrue(realEstateStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(realEstateStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(realEstateStorePage.isFrenchLanguageDetected(), "French language not detected by Brain");

        List<WebElement> productName = realEstateStorePage.getProductsName();
        int ind = 0;
        List<WebElement> actNowButton = realEstateStorePage.getActNowButtons();
        for(WebElement element: actNowButton) {
            String name = productName.get(ind).getText();
            System.out.println("Name on real estate page: "+name);
            realEstateStorePage.clickActNow(element);
            softAssert.assertTrue(actNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" - Product "+ind+" th name mismatch");
            basePage.clickOutside();
            ind = ind + 1;
        }

        Reporter.log("Product Act Now Journey", true);
        String propertyName = productName.get(0).getText();
        actNowButton.get(0).click();
        actNowPage.clickInstantAct().clickFacebook(testData);
        actNowPage.verifyActSubmission(propertyName).assertAll();
        actNowPage.clickDoneButton();
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Deutsch Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void deutschSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RealEstateStorePage realEstateStorePage = new RealEstateStorePage();
        ActNowPage actNowPage = new ActNowPage();
        TestData testData= realEstateStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getDeutschSampleQuery();
        realEstateStorePage.enterYourQuery(query);
        softAssert.assertTrue(realEstateStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(realEstateStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(realEstateStorePage.isDeutschLanguageDetected(), "Deutsch language not detected by Brain");

        List<WebElement> productName = realEstateStorePage.getProductsName();
        int ind = 0;
        List<WebElement> actNowButton = realEstateStorePage.getActNowButtons();
        for(WebElement element: actNowButton) {
            String name = productName.get(ind).getText();
            System.out.println("Name on real estate page: "+name);
            realEstateStorePage.clickActNow(element);
            softAssert.assertTrue(actNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" - Product "+ind+" th name mismatch");
            basePage.clickOutside();
            ind = ind + 1;
        }

        Reporter.log("Product Act Now Journey", true);
        String propertyName = productName.get(0).getText();
        actNowButton.get(0).click();
        actNowPage.clickInstantAct().clickFacebook(testData);
        actNowPage.verifyActSubmission(propertyName).assertAll();
        actNowPage.clickDoneButton();
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Korean Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void koreanSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RealEstateStorePage realEstateStorePage = new RealEstateStorePage();
        ActNowPage actNowPage = new ActNowPage();
        TestData testData= realEstateStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getKoreanSampleQuery();
        realEstateStorePage.enterYourQuery(query);
        softAssert.assertTrue(realEstateStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(realEstateStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(realEstateStorePage.isKoreanLanguageDetected(), "Korean language not detected by Brain");

        List<WebElement> productName = realEstateStorePage.getProductsName();
        int ind = 0;
        List<WebElement> actNowButton = realEstateStorePage.getActNowButtons();
        for(WebElement element: actNowButton) {
            String name = productName.get(ind).getText();
            System.out.println("Name on real estate page: "+name);
            realEstateStorePage.clickActNow(element);
            softAssert.assertTrue(actNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" - Product "+ind+" th name mismatch");
            basePage.clickOutside();
            ind = ind + 1;
        }

        Reporter.log("Product Act Now Journey", true);
        String propertyName = productName.get(0).getText();
        actNowButton.get(0).click();
        actNowPage.clickInstantAct().clickFacebook(testData);
        actNowPage.verifyActSubmission(propertyName).assertAll();
        actNowPage.clickDoneButton();
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Arabic Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void arabicSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RealEstateStorePage realEstateStorePage = new RealEstateStorePage();
        ActNowPage actNowPage = new ActNowPage();
        TestData testData= realEstateStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getArabicSampleQuery();
        realEstateStorePage.enterYourQuery(query);
        softAssert.assertTrue(realEstateStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(realEstateStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(realEstateStorePage.isArabicLanguageDetected(), "Arabic language not detected by Brain");

        List<WebElement> productName = realEstateStorePage.getProductsName();
        int ind = 0;
        List<WebElement> actNowButton = realEstateStorePage.getActNowButtons();
        for(WebElement element: actNowButton) {
            String name = productName.get(ind).getText();
            System.out.println("Name on real estate page: "+name);
            realEstateStorePage.clickActNow(element);
            softAssert.assertTrue(actNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" - Product "+ind+" th name mismatch");
            basePage.clickOutside();
            ind = ind + 1;
        }

        Reporter.log("Product Act Now Journey", true);
        String propertyName = productName.get(0).getText();
        actNowButton.get(0).click();
        actNowPage.clickInstantAct().clickFacebook(testData);
        actNowPage.verifyActSubmission(propertyName).assertAll();
        actNowPage.clickDoneButton();
        softAssert.assertAll();
    }
    @Test(description = "Verify Brain Response with Chinese Sample Query", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void chineseSampleQueryTests(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RealEstateStorePage realEstateStorePage = new RealEstateStorePage();
        ActNowPage actNowPage = new ActNowPage();
        TestData testData= realEstateStoreCase();
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getStoreLink());
        String query = testData.getTestData(QueryData.class).getChineseSampleQuery();
        realEstateStorePage.enterYourQuery(query);
        softAssert.assertTrue(realEstateStorePage.getSearchedQuery().contains(query), "Entered query : "+query+" - mismatch with Searched one");
        softAssert.assertFalse(realEstateStorePage.isQueryResponseDisplayed(), "Entered Query : "+query+" - response not displayed within 6 seconds");
        softAssert.assertTrue(realEstateStorePage.isChineseLanguageDetected(), "Chinese language not detected by Brain");

        List<WebElement> productName = realEstateStorePage.getProductsName();
        int ind = 0;
        List<WebElement> actNowButton = realEstateStorePage.getActNowButtons();
        for(WebElement element: actNowButton) {
            String name = productName.get(ind).getText();
            System.out.println("Name on real estate page: "+name);
            realEstateStorePage.clickActNow(element);
            softAssert.assertTrue(actNowPage.getTrimmedProductName().contains(name),"For Query : "+query+" - Product "+ind+" th name mismatch");
            basePage.clickOutside();
            ind = ind + 1;
        }

        Reporter.log("Product Act Now Journey", true);
        String propertyName = productName.get(0).getText();
        actNowButton.get(0).click();
        actNowPage.clickInstantAct().clickFacebook(testData);
        actNowPage.verifyActSubmission(propertyName).assertAll();
        actNowPage.clickDoneButton();
        softAssert.assertAll();
    }

}
