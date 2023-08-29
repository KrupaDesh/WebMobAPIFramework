package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.rezolve.web.ic.model.AddressData;

import java.util.List;

import static engine.core.Element.elementByXpath;

public class AddressPage extends BasePage {
    Element addAnAddress = elementByXpath("//mat-radio-group/../button");
    Element closeButton = elementByXpath("(//rezolve-frontend-add-address//button)[1]");
    Element addressNickNames = elementByXpath("//mat-radio-button/label//span[@class=\"text-lg leading-6\"]");
    Element addresses = elementByXpath("//mat-radio-group/span");

    //Add an address page
    Element addressElements = elementByXpath("//form//input");
    Element continueButton = elementByXpath("//rezolve-frontend-form-submit-button//button");
    Element errorCountry = elementByXpath("//input[@formcontrolname=\"country\"]/../../..//mat-error");
    Element errorAddressLine1 = elementByXpath("//input[@formcontrolname=\"addressLine1\"]/../../..//mat-error");
    Element errorZip = elementByXpath("//input[@formcontrolname=\"zip\"]/../../..//mat-error");
    Element errorNickName = elementByXpath("//input[@formcontrolname=\"nickname\"]/../../..//mat-error");
    Element pageTitle = elementByXpath("//rezolve-frontend-close-form-header//span");
    Element countryLabel = elementByXpath("(//mat-label)[1]");
    Element addressLine1Label = elementByXpath("(//mat-label)[2]");
    Element addressLine2Label = elementByXpath("(//mat-label)[3]");
    Element cityLabel = elementByXpath("(//mat-label)[4]");
    Element stateLabel = elementByXpath("(//mat-label)[5]");
    Element zipLabel = elementByXpath("(//mat-label)[6]");
    Element addressNickNamesLabel = elementByXpath("(//mat-label)[7]");



    @Step("Get Add an address label")
    public String getAddAnAddressLabel(){
        return addAnAddress.getText();
    }

    @Step("Get Select an address label ")
    public String getSelectAnAddressLabel(){
        return pageTitle.getText();
    }

    @Step("Get Add An Address page title label ")
    public String getAddAnAddressPageTitleLabel(){
        return pageTitle.getText();
    }
    @Step("Get Done button label ")
    public String getDoneButtonLabel(){
        return continueButton.getText();
    }
    @Step("Get Country label ")
    public String getCountryLabel(){
        return countryLabel.getText();
    }
    @Step("Get Address 1 label  ")
    public String getAddress1Label(){
        return addressLine1Label.getText();
    }

    @Step("Get Address 2 label ")
    public String getAddress2Label(){
        return addressLine2Label.getText();
    }

    @Step("Get City label ")
    public String getCityLabel(){
        return cityLabel.getText();
    }
    @Step("Get State label ")
    public String getStateLabel(){
        return stateLabel.getText();
    }
    @Step("Get Zip label ")
    public String getZipLabel(){
        return zipLabel.getText();
    }
    @Step("Get Address Nickname ")
    public String getAddressNicknameLabel(){
        return addressNickNamesLabel.getText();
    }
    @Step("Wait to load Address Page")
    public AddressPage waitToLoadPage(){
        addAnAddress.waitUntilElementClickable(60);
        screenshot();
        return this;
    }

    @Step("Click Add An Address")
    public AddressPage clickAddAnAddress(){
       addAnAddress.waitUntilElementVisible(60).click();
       return this;
    }

    @Step("Click Close")
    public AddressPage clickClose(){
        closeButton.waitUntilElementVisible(60).click();
        return this;
    }
    @Step("Enter all address details")
    public AddressPage enterAddressDetails(TestData testData){
        AddressData addressData = testData.getTestData(AddressData.class);

        List<WebElement> addressElementsList = addressElements.getElements();
        addressElementsList.get(1).sendKeys(addressData.getAddressLine1());
        addressElementsList.get(2).sendKeys(addressData.getAddressLine2());
        addressElementsList.get(3).sendKeys(addressData.getCity());
        addressElementsList.get(4).sendKeys(addressData.getState());
        addressElementsList.get(5).sendKeys(addressData.getZip());
        addressElementsList.get(6).sendKeys(addressData.getNickName());
        screenshot();

        return  this;
    }

    @Step("Enter mandatory address details")
    public AddressPage enterMandatoryFields(TestData testData){
        AddressData addressData = testData.getTestData(AddressData.class);

        List<WebElement> addressElementsList = addressElements.getElements();
        addressElementsList.get(0).clear();
        addressElementsList.get(0).sendKeys(addressData.getCountry());
        elementByXpath("//mat-option//span[text()='"+addressData.getCountry()+"']").click();
        addressElementsList.get(1).sendKeys(addressData.getAddressLine1());
        addressElementsList.get(5).sendKeys(addressData.getZip());
        addressElementsList.get(6).sendKeys(addressData.getNickName());
        screenshot();

        return  this;
    }

    @Step("Verify the error message for empty mandatory fields")
    public boolean verifyErrorMessageForEmptyMandatoryFields(TestData testData){
        AddressData addressData = testData.getTestData(AddressData.class);
        List<WebElement> addressElementsList = addressElements.getElements();
        addressElementsList.get(0).sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
      //  addressElementsList.get(0).clear();
        addressElementsList.get(6).click();
        addressElementsList.get(1).click();
        addressElementsList.get(5).click();
        addressElementsList.get(4).click();
        screenshot();
        if(errorCountry.isElementDisplayed() && errorAddressLine1.isElementDisplayed() && errorZip.isElementDisplayed() && errorNickName.isElementDisplayed()){
            return  true;
        }else {
            return false;
        }

    }


    @Step("Click on Continue")
    public AddressPage clickContinueButton(){
           continueButton.waitUntilElementClickable(60).click();
           return this;
    }

    @Step("Click on Done")
    public AddressPage clickDoneButton(){
        continueButton.waitUntilElementClickable(60).click();
        return this;
    }


    @Step("Get newly added Address Name")
    public String getNewlyAddedAddressNickName(){
        List<WebElement> names = addressNickNames.getElements();
       return names.get(0).getText();
    }

    @Step("Get newly added Address ")
    public String getNewlyAddedAddress(){
        List<WebElement> names = addresses.getElements();
        return names.get(0).getText();
    }

  }
