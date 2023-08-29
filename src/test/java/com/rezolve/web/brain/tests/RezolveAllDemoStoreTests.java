package com.rezolve.web.brain.tests;

import com.rezolve.web.brain.model.StoreLinkData;
import com.rezolve.web.brain.pages.RezolveAllDemoStorePage;
import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static com.rezolve.web.brain.model.TestDataArranger.*;

public class RezolveAllDemoStoreTests extends BaseTest {
    @Test(description = "Verify Home page button should be actionable from all stores.", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void homePageButtonTest(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RezolveAllDemoStorePage rezolveAllDemoStorePage = new RezolveAllDemoStorePage();
        TestData testData= rezolveAllDemoStoresCase();
        StoreLinkData link = testData.getTestData(StoreLinkData.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getAllDemoStoreLink());

        rezolveAllDemoStorePage.clickElectronicsStoreButton();
        System.out.println("Electronics Store Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getDemoElectronicsStoreLink()));
        rezolveAllDemoStorePage.clickHomeButton();
        System.out.println("Home Page Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getRezolveHomePageLink()));
        rezolveAllDemoStorePage.clickAIButton().clickDemoStoreButton();
        System.out.println("All Demo Store Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getAllDemoStoreLink()));

        rezolveAllDemoStorePage.clickHomeWareStoreButton();
        System.out.println("HomeWare Store Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getDemoHomeWareStoreLink()));
        rezolveAllDemoStorePage.clickHomeButton();
        System.out.println("Home Page Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getRezolveHomePageLink()));
        rezolveAllDemoStorePage.clickAIButton().clickDemoStoreButton();
        System.out.println("All Demo Store Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getAllDemoStoreLink()));

        rezolveAllDemoStorePage.clickRealEstateStoreButton();
        System.out.println("Real Estate Store Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getDemoRealEstateStoreLink()));
        rezolveAllDemoStorePage.clickHomeButton();
        System.out.println("Home Page Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getRezolveHomePageLink()));
        rezolveAllDemoStorePage.clickAIButton().clickDemoStoreButton();
        System.out.println("All Demo Store Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getAllDemoStoreLink()));

        rezolveAllDemoStorePage.clickDepartmentStoreButton();
        System.out.println("Department Store Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getDemoDepartmentStoreLink()));
        rezolveAllDemoStorePage.clickHomeButton();
        System.out.println("Home Page Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getRezolveHomePageLink()));
        rezolveAllDemoStorePage.clickAIButton().clickDemoStoreButton();
        System.out.println("All Demo Store Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getAllDemoStoreLink()));

        softAssert.assertAll();
    }
    @Test(description = "Verify user is able to go any store(Brain) from Rezolve home page ", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
    public void ableToGoStoreFromRezolveHomePageTest(){
        SoftAssert softAssert = new SoftAssert();
        BasePage basePage = new BasePage();
        RezolveAllDemoStorePage rezolveAllDemoStorePage = new RezolveAllDemoStorePage();
        TestData testData= rezolveAllDemoStoresCase();
        StoreLinkData link = testData.getTestData(StoreLinkData.class);
        maximizeWindow();
        driverGetUrl(testData.getTestData(StoreLinkData.class).getRezolveHomePageLink());
        rezolveAllDemoStorePage.clickAIButton().clickBrainButton().clickAskBrainButton();
        System.out.println("All Demo Store Link: "+basePage.getCurrentUrl());
        softAssert.assertTrue(basePage.getCurrentUrl().contains(link.getAllDemoStoreLink()));
        softAssert.assertAll();
    }
//    @Test(description = "Verify User is successfully able to submit Act now from Home screen", groups = {"Brain_Desk_Regression","Brain_Mobile_Regression"})
//    public void actNowFromHomeScreen(){
//        SoftAssert softAssert = new SoftAssert();
//        BasePage basePage = new BasePage();
//        RezolveAllDemoStorePage rezolveAllDemoStorePage = new RezolveAllDemoStorePage();
//        TestData testData= rezolveAllDemoStoresCase();
//        StoreLinkData link = testData.getTestData(StoreLinkData.class);
//        maximizeWindow();
//        driverGetUrl(testData.getTestData(StoreLinkData.class).getAllDemoStoreLink());
//
//        new RezolveAllDemoStorePage().clickActNowButton().clickInstantAct();
//        new SignInOptionsPageICv2().clickFacebook(testData);
//          new OrderSummaryPageICv2().verifyActSubmissionFromDemoStoreActNowButton(testData).assertAll();
//    }


}
