package com.rezolve.web.icv2.pages;

import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import static engine.core.Element.elementByXpath;

public class ActDetailsPageICv2 extends BasePage {

        Element fullName = elementByXpath("(//input)[1]");
        Element datePickerIcon = elementByXpath("//mat-datepicker-toggle");
        Element calendar = elementByXpath("////mat-calendar");
        Element postCode = elementByXpath("(//input)[3]");

        Element instantActButton = elementByXpath("//button[@type=\"submit\"]");




        @Step("Enter the act inputs ")
        public ActDetailsPageICv2 enterActInputs(){
            fullName.waitUntilElementVisible(120).enterText("TestUser");
            datePickerIcon.click();
            //calendar.enterText("11232025");
            new ActCalendarPopupICv2().selectDate();
            // postCode.scrollDownUtillFindElement().enterText("675323");
            screenshot();
            return new ActDetailsPageICv2();
        }

        @Step("Click Date picker")
        public ActCalendarPopupICv2 clickDatePicker(){
            datePickerIcon.click();
            return new ActCalendarPopupICv2();
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
        public ActDetailsPageICv2 waitToLoadActPage(){
            instantActButton.waitUntilElementVisible(60);
            screenshot();
            return new ActDetailsPageICv2();
        }

        @Step("Get the instant act button visibility")
        public boolean isInstantActShown(){
            screenshot();
            return instantActButton.waitUntilElementVisible(60).isElementDisplayed();
        }

}
