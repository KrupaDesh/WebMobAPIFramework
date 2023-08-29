package com.rezolve.web.ic.tests.eu;

import engine.TestData;
import engine.core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.rezolve.web.ic.model.EngagementLinkData;
import com.rezolve.web.ic.pages.ActDetailsPage;
import com.rezolve.web.ic.pages.OrderSummaryPage;
import com.rezolve.web.ic.pages.SignInOptionsPage;

import java.awt.*;

import static com.rezolve.web.ic.model.TestDataArranger.*;

public class ActEngagementTests extends BaseTest {


   @Test(description = "Act engagement by using Google Account", groups = {"ICv1_EU_Desk_Regression_NT","ICv1_EU_Mobile_Regression_NT"})
    public void actByGoogleAccount() {
       TestData testData = actGoogleAccountCase();
       driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
       maximizeWindow();
       new ActDetailsPage().enterActInputs().clickInstantAct();
       new SignInOptionsPage().clickGoogle().login(testData);
      Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Act Submit is not placed and payment failed");


   }

    @Test(description = "Act engagement by using Facebook Account", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void actByFacebookAccount(){
        TestData testData = actFacebookAccountCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        new ActDetailsPage().enterActInputs().clickInstantAct();
        new SignInOptionsPage().clickFacebook() .login(testData);
        Assert.assertTrue(new OrderSummaryPage().isOrderSuccessful(), "Order is not placed and payment failed");

    }


    @Test(description = "Act engagement by using Phone number", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void actByPhoneNumber(){
        TestData testData = actPhoneNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        new ActDetailsPage().enterActInputs().clickInstantAct();
        new SignInOptionsPage().clickPhoneNumber().login(testData);
        new OrderSummaryPage().verifyActSubmission(testData).assertAll();

    }

    @Test(description = "Act engagement(Phone number) - Validate mandatory field error and older date", groups = {"ICv1_EU_Desk_Regression","ICv1_EU_Mobile_Regression"})
    public void actMandatoryFieldAndOlderDateValidation(){
        TestData testData = actPhoneNumberCase();
        driverGetUrl(testData.getTestData(EngagementLinkData.class).getIcLink());
        maximizeWindow();
        ActDetailsPage actDetailsPage = new ActDetailsPage();
        actDetailsPage.clickInstantAct();
        Assert.assertTrue(actDetailsPage.isInstantActShown(),"Act Mandatory Validation failed ");
        actDetailsPage.clickDatePicker().selectOlderDate();
        actDetailsPage.clickInstantAct();
        Assert.assertTrue(actDetailsPage.isInstantActShown(),"Act accepts older dates. ");

    }

}
