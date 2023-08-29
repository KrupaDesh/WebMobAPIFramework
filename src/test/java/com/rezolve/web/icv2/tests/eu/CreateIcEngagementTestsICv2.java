package com.rezolve.web.icv2.tests.eu;

import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rezolve.web.icv2.model.EngagementLinkDataICv2;
import com.rezolve.web.icv2.model.RxpUrlLoginDataICv2;
import com.rezolve.web.icv2.pages.*;

import static com.rezolve.web.icv2.model.TestDataICv2.*;

public class CreateIcEngagementTestsICv2 extends BaseTest {

    @Test(description = "Create new Instant Checkout Buy engagement and verify it", groups = {"ICv2_EU_Desk_Regression-create"})
    public void createInstantCheckoutBuyEngagement(){
        TestData testData = createNewBuyEngagementCase();

        driverGetUrl(testData.getTestData(RxpUrlLoginDataICv2.class).getUrl());
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
        new RxpCreateEngagementPage().clickLogout();
    }

    @Test(description = "Create new Instant Checkout Act engagement and verify it", groups = {"ICv2_EU_Desk_Regression-create"})
    public void createInstantCheckoutActEngagement(){
        TestData testData = createNewActEngagementCase();

        driverGetUrl(testData.getTestData(RxpUrlLoginDataICv2.class).getUrl());
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
        new RxpCreateEngagementPage().clickLogout();
    }

    @Test(description = "Create new Instant Checkout Buy engagement by smart link and verify it", groups = {"ICv2_EU_Desk_Regression-create"})
    public void createInstantCheckoutBuyEngagementBySmartLink(){
        TestData testData = createNewBuyEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();

        driverGetUrl(testData.getTestData(RxpUrlLoginDataICv2.class).getUrl());
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
        boolean isProductNameValid = new ProductDetailsPageICv2().isProductNameDisplayedAsTitle(testData);
        basePage.close();
        basePage.switchToTab(0);
        basePage.refresh();
        rxpDashboardPage.clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();
        Assert.assertTrue(isProductNameValid, "IC link product is not selected product - mismatch in the selection");
        new RxpCreateEngagementPage().clickLogout();
    }

    @Test(description = "Create new Instant Checkout Act engagement by smart link and verify it", groups = {"ICv2_EU_Desk_Regression-create"})
    public void createInstantCheckoutActEngagementBySmartLink(){
        TestData testData = createNewActEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();
        EngagementLinkDataICv2 engagementLinkData = testData.getTestData(EngagementLinkDataICv2.class);

        driverGetUrl(testData.getTestData(RxpUrlLoginDataICv2.class).getUrl());
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
        new ActDetailsPageICv2().waitToLoadActPage();
        boolean isActTabTitleCorrect = basePage.getTitle().equals(engagementLinkData.getActTitle());
        basePage.close();
        basePage.switchToTab(0);
        basePage.refresh();
        rxpDashboardPage.clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();
        Assert.assertTrue(isActTabTitleCorrect, "IC link product is not selected product - mismatch in the selection");
        new RxpCreateEngagementPage().clickLogout();
    }

    @SneakyThrows
    @Test(description = "Smart Code for Buy Engagement", groups = {"ICv2_EU_Desk_Regression-create"})
    public void smartCodeForBuyEngagement() {
        TestData testData = createNewBuyEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();
        driverGetUrl(testData.getTestData(RxpUrlLoginDataICv2.class).getUrl());
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
        boolean isProductNameValid = new ProductDetailsPageICv2().waitToPageLoad().isProductNameDisplayedAsTitle(testData);
        TestData testDataIC = buyMobileNumberCase();
        new ProductDetailsPageICv2().clickInstantBuy();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testDataIC);
        new ProductDetailsPageICv2().changePayment().selectCreditCard(testDataIC).clickDone().enterCvv("123").clickInstantBuy();
        Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Order is not placed and payment failed");
        basePage.close();
        basePage.switchToTab(0);
        basePage.refresh();
        rxpDashboardPage.clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();
        Assert.assertTrue(isProductNameValid, "IC link product is not selected product - mismatch in the selection");
        new RxpCreateEngagementPage().clickLogout();
        }

    @SneakyThrows
    @Test(description = "Smart Code for Act Engagement", groups = {"ICv2_EU_Desk_Regression-create"})
    public void smartCodeForActEngagement() {
        TestData testData = createNewActEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();
        maximizeWindow();
        EngagementLinkDataICv2 engagementLinkData = testData.getTestData(EngagementLinkDataICv2.class);
        driverGetUrl(testData.getTestData(RxpUrlLoginDataICv2.class).getUrl());
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
        new ActDetailsPageICv2().waitToLoadActPage();
        boolean isActTabTitleCorrect = basePage.getTitle().equals(engagementLinkData.getActTitle());
        new ActDetailsPageICv2().clickInstantAct();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        new OrderSummaryPageICv2().isOrderSuccessful();
        basePage.close();
        basePage.switchToTab(0);
        basePage.refresh();
        rxpDashboardPage.clickMoreOfGivenEngagement(testData).clickDeleteOnMenu().clickYesButton();
        Assert.assertTrue(isActTabTitleCorrect, "IC link product is not selected product - mismatch in the selection");
        new RxpCreateEngagementPage().clickLogout();
    }


    //This is for smart code on mobile app in chrome/safari browsers - Under investigation
    @SneakyThrows
    @Test(description = "Smart Code for Act Engagement", groups = {"ICv2_EU_Desk_Regression-create_nt"})
    public void smartCodeOnMobileApp() {
        TestData testData = createNewActEngagementCaseFromSavedTargets();
        BasePage basePage = new BasePage();
        maximizeWindow();
        EngagementLinkDataICv2 engagementLinkData = testData.getTestData(EngagementLinkDataICv2.class);
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
