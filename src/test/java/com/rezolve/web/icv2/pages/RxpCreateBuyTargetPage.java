package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import com.rezolve.web.icv2.model.RxpNewTargetDataICv2;
import com.rezolve.web.icv2.model.RxpProductDataICv2;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class RxpCreateBuyTargetPage extends BasePage {


    Element yourReference = elementById("pageName");
    Element promotionalTitle = elementById("title");
    Element promotionalSubTitle = elementById("subtitle");
    Element search = elementByXpath("//input[@type='search']");
    Element confirmAndPublishButton = elementByXpath("(//app-confirm-button/button)[3]");



    public RxpCreateBuyTargetPage enteryourReference(TestData testData){
       yourReference.enterText(testData.getTestData(RxpNewTargetDataICv2.class).getYourReference());
        return this;
    }

    public RxpCreateBuyTargetPage enterPromotionalTitle(TestData testData){
        promotionalTitle.enterText(testData.getTestData(RxpNewTargetDataICv2.class).getPromotionalTitle());
        return this;
    }

    public RxpCreateBuyTargetPage enterPromotionalSubTitle(TestData testData){
        promotionalSubTitle.enterText(testData.getTestData(RxpNewTargetDataICv2.class).getPromotionalSubTitle());
        return this;
    }

    public RxpCreateBuyTargetPage searchGivenProduct(TestData testData){
        search.scrollDownUtillFindElement().enterText(testData.getTestData(RxpProductDataICv2.class).getName());
        return this;
    }

    public RxpCreateBuyTargetPage selectGivenProduct(TestData testData){
        String buyTargetProduct = testData.getTestData(RxpProductDataICv2.class).getName();
        elementByXpath("//span[text()=' "+buyTargetProduct+"']").waitUntilElementVisible(120).scrollDownUtillFindElement().click();
        return this;
    }

    @Step("Click ConfirmAndPublish")

    public RxpCreateEngagementPage clickConfirmAndPublish(){
        confirmAndPublishButton.click();
        return new RxpCreateEngagementPage();
    }

    @Step("Enter all details for new Buy Target")
    public RxpCreateEngagementPage enterAllDetails(TestData testData){
        enteryourReference(testData).enterPromotionalTitle(testData)
                .enterPromotionalSubTitle(testData)
                .searchGivenProduct(testData)
                .selectGivenProduct(testData)
                .clickConfirmAndPublish();
        return new RxpCreateEngagementPage();
    }

}
