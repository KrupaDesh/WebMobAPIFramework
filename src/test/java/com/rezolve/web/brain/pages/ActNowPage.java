package com.rezolve.web.brain.pages;

import com.rezolve.web.brain.model.UserLoginData;
import com.rezolve.web.icv2.model.UserAccountDataICv2;
import com.rezolve.web.icv2.pages.FacebookPageICv2;
import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.testng.asserts.SoftAssert;

import static engine.core.Element.elementByName;
import static engine.core.Element.elementByXpath;

public class ActNowPage extends BasePage {

    Element productName = elementByXpath("//body[@class=\"overflow-hidden\"]//div[@id=\"basket\"]//h3");
    Element actNowButton = elementByXpath("//div[@class=\"inner-wrapper-basket \"]//button");
    Element actSubmitMessage = elementByXpath("//div[@class=\"inner-wrapper-basket\"]//h4");
    Element actSubmitSuccessfulMessage = elementByXpath("(//div[@class=\"inner-wrapper-basket\"]//p)[1]");
    Element summaryText = elementByXpath("(//div[@class=\"inner-wrapper-basket\"]//h5)[1]");
    Element propertyReference = elementByXpath("(//div[@class=\"inner-wrapper-basket\"]//p)[3]");
    Element contactInfoText = elementByXpath("(//div[@class=\"inner-wrapper-basket\"]//h5)[2]");
    Element userName = elementByXpath("(//div[@class=\"inner-wrapper-basket\"]//p)[4]");
    Element doneButton = elementByXpath("//button[text()=\"Done\"]");
    Element facebook = elementByXpath("//body//ic-act-landing/div/div/div/ic-login/div/div/div[5]/button");
    Element email = elementByXpath("//input[contains(@placeholder, \"number\")]");
    Element nextButton = elementByName("login");
    Element password = elementByXpath("//input[@type=\"password\"]");
    Element continueButton = elementByXpath("//button[@value=\"Continue\"]");

    @SneakyThrows
    @Step("Get Product Name")
    public String getTrimmedProductName() {
      Thread.sleep(2000);
        String productNameOnActNowPage = productName.waitUntilElementVisible(25).getText().replaceAll("\\(", "").replaceAll("\\)","").replaceAll("\\+","").trim();
        System.out.println("Name on act now page: "+productNameOnActNowPage);
        screenshot();
        return productNameOnActNowPage;
    }
    @Step("Get Product Name")
    public String getProductName() {
        String productNameOnActNowPage = productName.waitUntilElementVisible(25).getText();
        screenshot();
        return productNameOnActNowPage;
    }

    @Step("Click Act Now")
    public ActNowPage clickActNow() {
        actNowButton.waitUntilElementClickable(25).click();
        return this;
    }
    @SneakyThrows
    @Step("Click on Buy Now button")
    public ActNowPage clickInstantAct(){
       // Thread.sleep(5000);
        actNowButton.waitUntilElementVisible(60).waitUntilElementClickable(60);
        screenshot();
        actNowButton.click();
        return this;
    }
    @Step("Verify the product name in Order Summary")
    public boolean isOrderedProductNameCorrectInSummary(String productName){
        screenshot();
        return elementByXpath("//div[text()='"+productName+"']").isElementDisplayed();
    }
    @Step("Verify the ACT Submission success details")
    public SoftAssert verifyActSubmission(String propertyName){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(actSubmitMessage.waitUntilElementVisible(30).isElementDisplayed());
        softAssert.assertTrue(actSubmitSuccessfulMessage.isElementDisplayed());
        softAssert.assertTrue(summaryText.isElementDisplayed());
        softAssert.assertTrue(getPropertyReference().contains(propertyName));
        softAssert.assertTrue(contactInfoText.isElementDisplayed());
        softAssert.assertTrue(userName.isElementDisplayed());
        screenshot();
        return  softAssert;
    }

    @Step("Click on Done")
    public void clickDoneButton(){
      doneButton.waitUntilElementVisible(25).click();
    }
    @SneakyThrows
    @Step("Continue with Facebook")
    public ActNowPage clickFacebook(TestData testData){
        BasePage basePage = new BasePage();
        Thread.sleep(500);
        screenshot();
        switchToFrame("sourceFrame");
        facebook.waitUntilElementVisible(25).click();
        if(basePage.getPlatformName().equalsIgnoreCase("MAC") || basePage.getPlatformName().equalsIgnoreCase("IOS")  ){
            basePage.switchToTab(0);}
        else{basePage.switchToTab(1);}
        login(testData);
        Thread.sleep(7000);
        basePage.switchToTab(0);
        return this;
    }
    @SneakyThrows
    @Step("Facebook - Login using email and password")
    public void login(TestData testData){
        Thread.sleep(4000);
        UserLoginData accountData = testData.getTestData(UserLoginData.class);
        email.waitUntilElementClickable(30).enterText(accountData.getEmail());
        password.enterText(accountData.getPassword());
        Thread.sleep(3000);
        screenshot();
        nextButton.click();


        try {
            if(System.getProperty("config")!= null) {
                String[] config = System.getProperty("config").split("[.]");
                if (config[1].matches("android|ios"))
                    continueButton.click();
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public String getPropertyReference(){
        return propertyReference.waitUntilElementVisible(25).getText();
    }

}
