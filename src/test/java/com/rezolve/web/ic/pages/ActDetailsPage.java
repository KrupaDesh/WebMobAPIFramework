package com.rezolve.web.ic.pages;

import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;

import static engine.core.Element.elementByXpath;

public class ActDetailsPage extends BasePage {
    Element fullName = elementByXpath("(//input)[1]");
    Element datePickerIcon = elementByXpath("//mat-datepicker-toggle");
    Element calendar = elementByXpath("////mat-calendar");
    Element postCode = elementByXpath("(//input)[3]");

    Element instantActButton = elementByXpath("//rezolve-frontend-instant-buy-button/button");




    @Step("Enter the act inputs ")
    public ActDetailsPage enterActInputs(){
        fullName.waitUntilElementVisible(120).enterText("TestUser");
        datePickerIcon.click();
        //calendar.enterText("11232025");
        new ActCalendarPopup().selectDate();
       // postCode.scrollDownUtillFindElement().enterText("675323");
        screenshot();
        return new ActDetailsPage();
    }

    @Step("Click Date picker")
    public ActCalendarPopup clickDatePicker(){
        datePickerIcon.click();
        return new ActCalendarPopup();
    }

    @Step("Click on Instant Act")
    public void clickInstantAct(){
        screenshot();
        instantActButton.waitUntilElementVisible(60).click();
    }

    @Step("Get the instant act button text")
    public String getInstantActButtonText(){
        return   instantActButton.getText();
    }

    @Step("Get the instant act button text")
    public ActDetailsPage waitToLoadActPage(){
           instantActButton.waitUntilElementVisible(60);
           screenshot();
           return new ActDetailsPage();
    }

    @Step("Get the instant act button visibility")
    public boolean isInstantActShown(){
        screenshot();
       return instantActButton.waitUntilElementVisible(60).isElementDisplayed();
    }


}
