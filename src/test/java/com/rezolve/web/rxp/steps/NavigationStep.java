package com.rezolve.web.rxp.steps;

import engine.TestData;
import engine.core.BasePage;
import com.rezolve.web.rxp.pages.*;

public class NavigationStep {

    public HomePage landingPageToHomePage(TestData testData){
         new BasePage().maximize();
         new LandingPage()
                .signIn()
                .loginWithValidCred(testData)
                .isHomePageLoaded();
        return new HomePage();
    }

    public SelectPaymentProviderPage homePageToSelectPaymentProviderPage(TestData testData) {
        new HomePage()
                .clickOnSettingsIcon()
                .clickOnSellWithRezolve()
                .clickOnCancelBtnIfShown()
                .clickOnOKButton()
                .waitToLoad();
//                .SearchPaymentProvider(testData)
//                .clickOnPaymentProvider()
//                .clickOnNextButton();
        return new SelectPaymentProviderPage();
    }
}
