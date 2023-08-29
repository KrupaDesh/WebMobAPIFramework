package com.rezolve.web.icv2.tests.eu;

import com.rezolve.web.icv2.pages.*;
import engine.TestData;
import engine.core.BasePage;
import engine.core.BaseTest;
import lombok.SneakyThrows;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rezolve.web.icv2.model.EngagementLinkDataICv2;
import com.rezolve.web.icv2.pages.OrderSummaryPageICv2;
import com.rezolve.web.icv2.pages.SignInOptionsPageICv2;

import static com.rezolve.web.icv2.model.TestDataICv2.*;

public class ActEngagementTestsICv2 extends BaseTest {


   @SneakyThrows
   @Test(description = "Act engagement by using Google Account", groups = {"ICv2_EU_Desk_Regression_NT","ICv2_EU_Mobile_Regression_NT"})
    public void actByGoogleAccount(){
       BasePage basePage = new BasePage();
       TestData testData = actGoogleAccountCase();
       driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
       maximizeWindow();
       new ActDetailsPageICv2().enterActInputs().clickInstantAct();
       new SignInOptionsPageICv2().clickGoogle();
       basePage.switchToTab(1);
       new GoogleLoginPageICv2().login(testData);
       //basePage.switchToTab(0);
       Thread.sleep(5000);
      Assert.assertTrue(new OrderSummaryPageICv2().isOrderSuccessful(), "Act Submit is not placed and payment failed");
   }


    @SneakyThrows
    @Test(description = "Act engagement by using Facebook Account", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})

    public void actByFacebookAccount(){
        BasePage basePage = new BasePage();
        TestData testData = actFacebookAccountCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();

        new ActDetailsPageICv2().enterActInputs().clickInstantAct();
        new SignInOptionsPageICv2().clickFacebook(testData);
        new OrderSummaryPageICv2().verifyActSubmission(testData).assertAll();

    }


    @Test(description = "Act engagement by using Phone number", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void actByPhoneNumber(){
        TestData testData = actPhoneNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        new ActDetailsPageICv2().enterActInputs().clickInstantAct();
        new SignInOptionsPageICv2().clickPhoneNumber().login(testData);
        new OrderSummaryPageICv2().verifyActSubmission(testData).assertAll();

    }

    @Test(description = "Act engagement(Phone number) - Validate mandatory field error and older date", groups = {"ICv2_EU_Desk_Regression","ICv2_EU_Mobile_Regression"})
    public void actMandatoryFieldAndOlderDateValidation(){
        TestData testData = actPhoneNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkDataICv2.class).getIcLink());
        maximizeWindow();
        ActDetailsPageICv2 actDetailsPage = new ActDetailsPageICv2();
        actDetailsPage.clickInstantAct();
        Assert.assertTrue(actDetailsPage.isInstantActShown(),"Act Mandatory Validation failed ");
        actDetailsPage.clickDatePicker().selectOlderDate();
        actDetailsPage.clickOutside();
        actDetailsPage.clickInstantAct();
        Assert.assertTrue(actDetailsPage.isInstantActShown(),"Act accepts older dates. ");

    }

}
