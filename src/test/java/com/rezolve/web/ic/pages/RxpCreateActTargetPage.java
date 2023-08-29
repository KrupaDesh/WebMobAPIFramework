package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import com.rezolve.web.ic.model.RxpNewTargetData;
import com.rezolve.web.ic.model.RxpProductData;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class RxpCreateActTargetPage extends BasePage {


    Element yourReference = elementById("pageName");
    Element promotionalTitle = elementById("title");
    Element promotionalSubTitle = elementById("subtitle");
    Element dropAreaElement = elementByXpath("(//div[@class=\"drop-zone\"])[2]");
    Element header = elementByXpath("(//app-page-building-block)[1]");
    Element confirmAndPublishButton = elementByXpath("(//app-confirm-button/button[@type=\"submit\"])[2]");



    //Heading
    Element headingText = elementById("tinymce");
    Element yesButton = elementByXpath("(//app-heading-customisation-popup//app-confirm-button/button)[2]");
    Element noButton = elementByXpath("(//app-heading-customisation-popup//app-confirm-button/button)[1]");



    public RxpCreateActTargetPage enteryourReference(TestData testData){
       yourReference.enterText(testData.getTestData(RxpNewTargetData.class).getYourReference());
        return this;
    }

    public RxpCreateActTargetPage enterPromotionalTitle(TestData testData){
        promotionalTitle.enterText(testData.getTestData(RxpNewTargetData.class).getPromotionalTitle());
        return this;
    }

    public RxpCreateActTargetPage enterPromotionalSubTitle(TestData testData){
        promotionalSubTitle.enterText(testData.getTestData(RxpNewTargetData.class).getPromotionalSubTitle());
        return this;
    }



    public RxpCreateActTargetPage selectGivenProduct(TestData testData){
        String buyTargetProduct = testData.getTestData(RxpProductData.class).getName();
        elementByXpath("//span[text()=' "+buyTargetProduct+"']").waitUntilElementVisible(120).scrollDownUtillFindElement().click();
        return this;
    }

    @Step("Click ConfirmAndPublish")

    public RxpCreateEngagementPage clickConfirmAndPublish(){
        confirmAndPublishButton.click();
        return new RxpCreateEngagementPage();
    }

    @Step("Enter all details for new Act Target")
    public RxpCreateActTargetPage enterAllActDetails(TestData testData){
        enteryourReference(testData).enterPromotionalTitle(testData)
                .enterPromotionalSubTitle(testData);
        return new RxpCreateActTargetPage();
    }


    @SneakyThrows
    @Step("Place the header")
    public RxpCreateActTargetPage dragAndDropHeader(String headerName){
        dropAreaElement.scrollDownUtillFindElement();
        dragAndDrop(header,dropAreaElement);
        Thread.sleep(1000);
        elementByXpath("//iframe").waitUntilElementVisible(120);
        switchToFrame(0);
        headingText.enterText(headerName);
        switchToMain();
        yesButton.click();
        return this;
    }

}
