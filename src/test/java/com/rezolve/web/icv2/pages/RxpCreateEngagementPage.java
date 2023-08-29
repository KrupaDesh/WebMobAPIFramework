package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import com.rezolve.web.icv2.model.RxpEngagementDataICv2;
import com.rezolve.web.icv2.model.RxpTargetDataICv2;

import static engine.core.Element.elementByXpath;

public class RxpCreateEngagementPage extends BasePage {

    Element instantCheckoutTile = elementByXpath("//app-base-card//*[text()='Instant Checkout']");
    Element smartLink = elementByXpath("//app-base-card//*[text()='SmartLink']");
    Element smartCode = elementByXpath("//app-base-card//*[text()='SmartCode']");
    Element savedTargetSearchBox = elementByXpath("//input[@type='search']");
    Element signIn = elementByXpath("//a[@data-test=\"sign-in\"]");
    Element createTargetButton = elementByXpath("(//app-confirm-button/button[@data-test='create-buy-page'])[2]");
    Element confirmAndPublishButton = elementByXpath("(//app-confirm-button/button[@data-test='create-buy-page'])[2]");

    Element newInstantAct = elementByXpath("//div[@data-test=\"target-page-create-ACT\"]");
    Element newInstantBuy = elementByXpath("//div[@data-test=\"target-page-create-BUY\"]");
    Element newInfoPage = elementByXpath("//div[@data-test=\"target-page-create-INFORMATION\"]");
    Element newExternalLink = elementByXpath("//div[@data-test=\"target-page-create-URL\"]");
    Element engagementNameInput = elementByXpath("//input[@data-test=\"engagement-name-input\"]");
    Element payButton = elementByXpath("//app-confirm-button");
    Element payOkButton = elementByXpath("//app-success-status-popup//app-confirm-button");
    Element logout = elementByXpath("//div/mat-nav-list/a[8]");

    @Step("Click Instant Checkout ")
    public RxpCreateEngagementPage clickInstantCheckout(){
        instantCheckoutTile.click();
        return this;
    }

    @Step("Click Smart Link ")
    public RxpCreateEngagementPage clickSmartLink(){
        smartLink.click();
        return this;
    }

    @Step("Click Smart Code ")
    public RxpCreateEngagementPage clickSmartCode(){
        smartCode.click();
        return this;
    }
    public RxpCreateEngagementPage clickCreateTarget(){
        createTargetButton.click();
        return new RxpCreateEngagementPage();
    }

    public RxpCreateEngagementPage clickNewInfoPage(){
        newInfoPage.click();
        return this;
    }

    public RxpCreateActTargetPage clickNewInstantAct(){
        newInstantAct.click();
        return new RxpCreateActTargetPage();
    }


    @Step("Click NewInstantBuy")
    public RxpCreateBuyTargetPage clickNewInstantBuy(){
        newInstantBuy.click();
        return new RxpCreateBuyTargetPage();
    }

    public RxpCreateEngagementPage clickNewExternalLink(){
        newExternalLink.click();
        return this;
    }

    @Step("Enter Engagement Name")
    public RxpCreateEngagementPage enterEngagementName(TestData testData){
        engagementNameInput.enterText(testData.getTestData(RxpEngagementDataICv2.class).getName());
    return this;
    }

    @Step("Click Create Engagement")
    public RxpDashboardPage clickCreateEngagement(){
        createTargetButton.click();
        return new RxpDashboardPage();
    }

    @Step("Click SignIn")
    public RxpLoginPage clickSignIn(){
        signIn.click();
        return new RxpLoginPage();
    }

    @SneakyThrows
    @Step("Click SignIn")
    public RxpDashboardPage completeThePayment(){
        Thread.sleep(40000);
        payButton.waitUntilElementPresent(120).click();
        payOkButton.waitUntilElementPresent(120).click();
        return new RxpDashboardPage();
    }

    @Step("Search the given target and publish it")
    public RxpCreateEngagementPage searchAndSelectGivenTarget(TestData testData){
        RxpTargetDataICv2 rxpTargetData = testData.getTestData(RxpTargetDataICv2.class);
         savedTargetSearchBox.enterText(rxpTargetData.getName());
         elementByXpath("(//h3[text()=' "+rxpTargetData.getName()+" '])[1]").waitUntilElementVisible(30).scrollDownUtillFindElement().click();
        confirmAndPublishButton.waitUntilElementVisible(30).click();
        return new RxpCreateEngagementPage();
    }

    @Step("Click Logout")
    public void clickLogout(){
        logout.scrollDownUtillFindElement().click();
    }

}
