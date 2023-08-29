package com.rezolve.web.brain.pages;

import com.rezolve.web.icv2.pages.FacebookPageICv2;
import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static engine.core.Base.getDriver;
import static engine.core.Element.elementByXpath;

public class RezolveAllDemoStorePage extends BasePage {

    Element homeButton = elementByXpath("(//a[text()=\"Home\"])[1]");
    Element electronicsStoreButton = elementByXpath("(//ul[@class=\"hfe-nav-menu\"])[3]/li[1]/a[1]");
    Element homeWareStoreButton = elementByXpath("(//ul[@class=\"hfe-nav-menu\"])[3]/li[2]/a[1]");
    Element realEstateStoreButton = elementByXpath("(//ul[@class=\"hfe-nav-menu\"])[3]/li[3]/a[1]");
    Element departmentStoreButton = elementByXpath("(//ul[@class=\"hfe-nav-menu\"])[3]/li[4]/a[1]");
    Element aiLinkButton = elementByXpath("(//ul[@class=\"hfe-nav-menu\"])[2]/li[1]/a");
    Element demoStoreLinkButton = elementByXpath("(//ul[@class=\"hfe-nav-menu\"])[3]/li[3]/a");
    Element brainLinkButton = elementByXpath("(//ul[@class=\"hfe-nav-menu\"])[3]/li[1]/a");
    Element myBrainLinkButton = elementByXpath("(//ul[@class=\"hfe-nav-menu\"])[3]/li[2]/a");
    Element askBrainLinkButton = elementByXpath("//div/section[1]/div[2]/div/div/div[4]/div/div/a");
    Element justAskBrainText = elementByXpath("//h2[text()=\"Just Ask Brain\"]");
    Element actNowButton = elementByXpath("(//rezolve-instant-checkout-button)[1]");
    Element instantActButton = elementByXpath("//button[@type=\"submit\"]");
    Element facebook = elementByXpath("//ic-login//button/span[contains(text(), \"Facebook\")]");



    @Step("Click Home Button")
    public RezolveAllDemoStorePage clickHomeButton() {
        homeButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click Electronics Store Button")
    public RezolveAllDemoStorePage clickElectronicsStoreButton() {
        electronicsStoreButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click HomeWare Store Button")
    public RezolveAllDemoStorePage clickHomeWareStoreButton() {
        homeWareStoreButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click Real Estate Store Button")
    public RezolveAllDemoStorePage clickRealEstateStoreButton() {
        realEstateStoreButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click Department Store Button")
    public RezolveAllDemoStorePage clickDepartmentStoreButton() {
        departmentStoreButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click AI Button")
    public RezolveAllDemoStorePage clickAIButton() {
        aiLinkButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click Demo Store Button")
    public RezolveAllDemoStorePage clickDemoStoreButton() {
        demoStoreLinkButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click Brain Button")
    public RezolveAllDemoStorePage clickBrainButton() {
        brainLinkButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click MyBrain Button")
    public RezolveAllDemoStorePage clickMyBrainButton() {
        myBrainLinkButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click Ask Brain Button")
    public RezolveAllDemoStorePage clickAskBrainButton() {
        justAskBrainText.scrollDownUtillFindElement();
        askBrainLinkButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @Step("Click Act Now Button")
    public RezolveAllDemoStorePage clickActNowButton() {
        actNowButton.waitUntilElementVisible(25).waitUntilElementClickable(25).click();
        return this;
    }
    @SneakyThrows
    @Step("Click on Instant Act")
    public RezolveAllDemoStorePage clickInstantAct(){
        Thread.sleep(10000);
        screenshot();
//        switchToFrame(2);
        WebElement frameElement = driver.findElement(By.xpath("(//ic-header[@class=\"ng-star-inserted\"])[1]"));
        switchToFrame(frameElement);
        instantActButton.waitUntilElementVisible(25).click();
        return this;
    }
}
