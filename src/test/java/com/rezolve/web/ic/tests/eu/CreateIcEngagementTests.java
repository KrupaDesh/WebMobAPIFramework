package com.rezolve.web.ic.tests.eu;

import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rezolve.web.ic.model.EngagementLinkData;
import com.rezolve.web.ic.model.RxpUrlLoginData;
import com.rezolve.web.ic.pages.*;

import static com.rezolve.web.ic.model.TestDataArranger.*;

public class CreateIcEngagementTests extends BaseTest {

    @Test(description = "Create new Instant Checkout Buy engagement and verify it", groups = {"ICv1_EU_Desk_Regression"})
    public void createInstantCheckoutBuyEngagement(){
        TestData testData = createNewBuyEngagementCase();

        driverGetUrl(testData.getTestData(RxpUrlLoginData.class).getUrl());
        maximizeWindow();
        RxpDashboardPage rxpDashboardPage = new RxpCreateEngagementPage().clickSignIn().login(testData)
                .clickInstantCheckout()
                .clickCreateTarget()
                .clickNewInstantBuy()
                .enterAllDetails(testData)
                .enterEngagementName(testData)
                .clickCreateEngagement()
                .clickDownloadOfGivenEngagement(testData);

        Assert.assertTrue(rxpDashboardPage.getHeaderCodeSnippet().toLowerCase().startsWith("<link"));
        Assert.assertTrue(rxpDashboardPage.getButtonCodeSnippet().toLowerCase().startsWith("<button"));
        rxpDashboardPage.closeIcCodeSnippetPopup().clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();

    }

    @Test(description = "Create new Instant Checkout Act engagement and verify it", groups = {"ICv1_EU_Desk_Regression"})
    public void createInstantCheckoutActEngagement(){
        TestData testData = createNewActEngagementCase();

        driverGetUrl(testData.getTestData(RxpUrlLoginData.class).getUrl());
        maximizeWindow();
        RxpDashboardPage rxpDashboardPage = new RxpCreateEngagementPage().clickSignIn().login(testData)
                .clickInstantCheckout()
                .clickCreateTarget()
                .clickNewInstantAct()
                .enterAllActDetails(testData)
                .dragAndDropHeader("TestAutomation")
                .clickConfirmAndPublish()
                .enterEngagementName(testData)
                .clickCreateEngagement()
                .clickDownloadOfGivenEngagement(testData);
        Assert.assertTrue(rxpDashboardPage.getHeaderCodeSnippet().toLowerCase().startsWith("<link"));
        Assert.assertTrue(rxpDashboardPage.getButtonCodeSnippet().toLowerCase().startsWith("<button"));
        rxpDashboardPage.closeIcCodeSnippetPopup().clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();

    }

    @Test(description = "Create new Instant Checkout Buy engagement by smart link and verify it", groups = {"ICv1_EU_Desk_Regression"})
    public void createInstantCheckoutBuyEngagementBySmartLink(){
        TestData testData = createNewBuyEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();

        driverGetUrl(testData.getTestData(RxpUrlLoginData.class).getUrl());
        maximizeWindow();
        RxpDashboardPage rxpDashboardPage = new RxpCreateEngagementPage().clickSignIn().login(testData)
                .clickSmartLink()
                .clickCreateTarget()
                .searchAndSelectGivenTarget(testData)
                .enterEngagementName(testData)
                .clickCreateEngagement()
                .clickCopyLinkOfGivenEngagement(testData)
                .pasteCopyLinkInSearchBox();
        String icSmartLink = rxpDashboardPage.getTheSearchBoxText();
        basePage.openNewTabAndNavigate();
        basePage.navigateTo(icSmartLink);
        boolean isProductNameValid = new ProductDetailsPage().waitToPageLoad().isProductNameDisplayedAsTitle(testData);
        basePage.close();
        basePage.switchToTab(0);
        basePage.refresh();
        rxpDashboardPage.clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();
        Assert.assertTrue(isProductNameValid, "IC link product is not selected product - mismatch in the selection");

    }

    @Test(description = "Create new Instant Checkout Act engagement by smart link and verify it", groups = {"ICv1_EU_Desk_Regression"})
    public void createInstantCheckoutActEngagementBySmartLink(){
        TestData testData = createNewActEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();
        EngagementLinkData engagementLinkData = testData.getTestData(EngagementLinkData.class);

        driverGetUrl(testData.getTestData(RxpUrlLoginData.class).getUrl());
        maximizeWindow();
        RxpDashboardPage rxpDashboardPage = new RxpCreateEngagementPage().clickSignIn().login(testData)
                .clickSmartLink()
                .clickCreateTarget()
                .searchAndSelectGivenTarget(testData)
                .enterEngagementName(testData)
                .clickCreateEngagement()
                .clickCopyLinkOfGivenEngagement(testData)
                .pasteCopyLinkInSearchBox();
        String icSmartLink = rxpDashboardPage.getTheSearchBoxText();
        basePage.openNewTabAndNavigate();
        basePage.navigateTo(icSmartLink);
        new ActDetailsPage().waitToLoadActPage();
        boolean isActTabTitleCorrect = basePage.getTitle().equals(engagementLinkData.getActTitle());
        basePage.close();
        basePage.switchToTab(0);
        basePage.refresh();
        rxpDashboardPage.clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();
        Assert.assertTrue(isActTabTitleCorrect, "IC link product is not selected product - mismatch in the selection");

    }

    @SneakyThrows
    @Test(description = "Smart Code for Buy Engagement", groups = {"ICv1_EU_Desk_Regression"})
    public void smartCodeForBuyEngagement() {
        TestData testData = createNewBuyEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();
        driverGetUrl(testData.getTestData(RxpUrlLoginData.class).getUrl());
        maximizeWindow();
        RxpCreateEngagementPage rxpCreateEngagementPage = new RxpCreateEngagementPage().clickSignIn().login(testData)
                .clickSmartCode()
                .clickCreateTarget()
                .searchAndSelectGivenTarget(testData)
                .enterEngagementName(testData);
        RxpDashboardPage rxpDashboardPage = rxpCreateEngagementPage.clickCreateEngagement();
        rxpCreateEngagementPage.completeThePayment();
        rxpDashboardPage.clickDownloadOfGivenSmartCode(testData);

       // basePage.alertAccept();
        Thread.sleep(30000);

        //  String icSmartLink = rxpDashboardPage.getTheSearchBoxText();
        basePage.openNewTabAndNavigate();
        basePage.navigateTo("https://www.online-qr-scanner.com/");
        new QrScanPage().selectGivenQRCode(testData).openUrl();
        //getDriver().findElement(By.id("file-selector")).sendKeys("C:\\Users\\hello\\downloads\\"+testData.getTestData(RxpEngagementData.class).getName()+".png");
        //Thread.sleep(10000);

        //getDriver().findElement(By.xpath("(//button/span)[1]")).click();
      //  Thread.sleep(40000);
        Thread.sleep(4000);
        basePage.switchToTab(2);
        boolean isProductNameValid = new ProductDetailsPage().waitToPageLoad().isProductNameDisplayedAsTitle(testData);
        TestData testDataIC = buyMobileNumberCase();
        new ProductDetailsPage().clickInstantBuy();
        new SignInOptionsPage().clickPhoneNumber().login(testDataIC);
        new ProductDetailsPage().changePayment().selectCreditCard(testDataIC).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");
        basePage.close();
        basePage.switchToTab(0);
        basePage.refresh();
        rxpDashboardPage.clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();
        Assert.assertTrue(isProductNameValid, "IC link product is not selected product - mismatch in the selection");
        }

    @SneakyThrows
    @Test(description = "Smart Code for Act Engagement", groups = {"ICv1_EU_Desk_Regression"})
    public void smartCodeForActEngagement() {
        TestData testData = createNewActEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();
        maximizeWindow();
        EngagementLinkData engagementLinkData = testData.getTestData(EngagementLinkData.class);
        driverGetUrl(testData.getTestData(RxpUrlLoginData.class).getUrl());
        RxpCreateEngagementPage rxpCreateEngagementPage = new RxpCreateEngagementPage().clickSignIn().login(testData)
                .clickSmartCode()
                .clickCreateTarget()
                .searchAndSelectGivenTarget(testData)
                .enterEngagementName(testData);
        RxpDashboardPage rxpDashboardPage = rxpCreateEngagementPage.clickCreateEngagement();
        rxpCreateEngagementPage.completeThePayment();
        rxpDashboardPage.clickDownloadOfGivenSmartCode(testData);

        // basePage.alertAccept();
        Thread.sleep(30000);

        basePage.openNewTabAndNavigate();
        basePage.navigateTo("https://www.online-qr-scanner.com/");
        new QrScanPage().selectGivenQRCode(testData).openUrl();

        basePage.switchToTab(2);
        new ActDetailsPage().waitToLoadActPage();
        boolean isActTabTitleCorrect = basePage.getTitle().equals(engagementLinkData.getActTitle());
        new ActDetailsPage().clickInstantAct();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        new OrderSummaryPage().isOrderSuccessful();
        basePage.close();
        basePage.switchToTab(0);
        basePage.refresh();
        rxpDashboardPage.clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();
        Assert.assertTrue(isActTabTitleCorrect, "IC link product is not selected product - mismatch in the selection");

    }


    //This is for smart code on mobile app in chrome/safari browsers - Under investigation
    @SneakyThrows
    @Test(description = "Smart Code for Act Engagement", groups = {"ICv1_EU_Desk_Regression_nt"})
    public void smartCodeOnMobileApp() {
        TestData testData = createNewActEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();
        maximizeWindow();
        EngagementLinkData engagementLinkData = testData.getTestData(EngagementLinkData.class);
        driverGetUrl("https://www.online-qr-scanner.com/");
        Thread.sleep(5000);
        new BasePage().alertAndroidAlow();
//        RxpCreateEngagementPage rxpCreateEngagementPage = new RxpCreateEngagementPage().clickSignIn().login(testData)
//                .clickSmartCode()
//                .clickCreateTarget()
//                .searchAndSelectGivenTarget(testData)
//                .enterEngagementName(testData);
//        RxpDashboardPage rxpDashboardPage = rxpCreateEngagementPage.clickCreateEngagement();
//        rxpCreateEngagementPage.completeThePayment();
//        rxpDashboardPage.clickDownloadOfGivenSmartCode(testData);
//
//        // basePage.alertAccept();
//        Thread.sleep(30000);
//
//        basePage.openNewTabAndNavigate();
//        basePage.navigateTo("https://www.online-qr-scanner.com/");
        new QrScanPage().selectLocalCode().openUrl();

        Thread.sleep(50000);
//        basePage.switchToTab(2);
//        new ActDetailsPage().waitToLoadActPage();
//        boolean isActTabTitleCorrect = basePage.getTitle().equals(engagementLinkData.getActTitle());
//        new ActDetailsPage().clickInstantAct();
//        new SignInOptionsPage().clickPhoneNumber().login(testData);
//        new OrderSummaryPage().isOrderSuccessful();
//        basePage.close();
//        basePage.switchToTab(0);
//        basePage.refresh();
//        rxpDashboardPage.clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();
//        Assert.assertTrue(isActTabTitleCorrect, "IC link product is not selected product - mismatch in the selection");

    }

}
