package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.rezolve.web.icv2.model.AddressDataICv2;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static engine.core.Base.getDriver;
import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class AddressPageICv2 extends BasePage {
    Element addAnAddress = elementByXpath("//ic-card//button[contains(text(), \"Ad\")]");
    Element closeButton = elementByXpath("//ic-card//div[2]/div[1]/button");
    //Element addressNickNames = elementByXpath("//mat-radio-button/label//span[@class=\"text-lg leading-6\"]");
    //Element addressNickNames = elementByXpath("//mat-radio-button//input");
    Element StateLabel = elementByXpath("//mat-label[text()='State/Province'] | //mat-label[text()='Staat/Provinz']");
    Element addressNickNames = elementByXpath("//mat-radio-button//label/div");
    //Element addresses = elementByXpath("//mat-radio-button//label/div/p/text()"); //Commenting for debug purpose
    //Element addresses = elementByXpath("//mat-radio-button");
    Element addresses = elementByXpath("//mat-radio-button//label/div");
    Element addressChangeButton = elementByXpath("(//button[text()='Change'])[1]");

    Element useMyLocation =elementByXpath("//form/mat-form-field//div/button");
    //Add an address page
    Element addressElements = elementByXpath("//ic-add-address//input");
    Element addressOptions = elementByXpath("//div[@class=\"flex w-full justify-between\"]//button//span[@class=\"mat-mdc-button-touch-target\"]");
    Element addressEditOption = elementByXpath("//div[@class=\"cdk-overlay-connected-position-bounding-box\"]/div/div/div/button/span/span[text()='Edit']");
    Element addressDeleteOption = elementByXpath("//div[@class=\"cdk-overlay-connected-position-bounding-box\"]/div/div/div/button/span/span[text()='Delete']");
    Element deleteDialogPopup = elementByXpath("//ic-confirm-dialog//div/div[text()=\" Are you sure you want to delete this address? \"]");
    Element dialogDeleteButton = elementByXpath("//ic-confirm-dialog//div[2]//button[2]");
    Element dialogCancelButton = elementByXpath("//ic-confirm-dialog//div[2]//button[1]");
    Element deliveryOptionLabel = elementByXpath("//h2[text()='Delivery Option'] | //h2[text()='Optionen für die Lieferung']");

    Element ZipCode = elementByXpath("//mat-label[text()='Postal Code']");
    Element ZipCodeInput = elementByXpath("(//ic-add-address//mat-form-field//div//input)[1] | //mat-label[text()='Postal Code']/following::input[1]");
    Element continueButton = elementByXpath("//ic-add-address//ic-card//div[4]/button");
    Element errorCity = elementByXpath("//ic-validation-message//mat-error[contains(text(), \"City\")] | //ic-validation-message//mat-error[contains(text(), \"Stadt\")]");
    Element errorState = elementByXpath("//ic-validation-message//mat-error[contains(text(), \"State/Province\")] | //ic-validation-message//mat-error[contains(text(), \"Staat/Provinz\")]");
    Element errorAddressLine1 = elementByXpath("//ic-validation-message//mat-error[contains(text(), \"Address Line 1\")] | //ic-validation-message//mat-error[contains(text(), \"Anschrift Zeile 1\")]");
    Element errorZip = elementByXpath("//ic-validation-message//mat-error[contains(text(), \"Postal Code\")] | //ic-validation-message//mat-error[contains(text(), \"Postleitzahl\")]");
    Element errorNickName = elementByXpath("//ic-validation-message//mat-error[contains(text(), \"Address nickname\")] | //ic-validation-message//mat-error[contains(text(), \"Spitzname der\")]");
    Element pageTitle = elementByXpath("//h2[contains(text(),\"Select Delivery Option\")] | //h2[contains(text(),\"Optionen für die Lieferung\")] | //h2[text()=' Adresse hinzufügen ']");
    Element countryLabel = elementByXpath("(//mat-label)[2]");
    Element addressLine1Label = elementByXpath("(//mat-label)[3]");
    Element addressLine2Label = elementByXpath("(//mat-label)[4]");
    Element cityLabel = elementByXpath("(//mat-label)[5]");
    Element stateLabel = elementByXpath("(//mat-label)[6]");
    Element zipLabel = elementByXpath("(//mat-label)[1]");
    Element addressNickNamesLabel = elementByXpath("//div[contains(text(),\"nickname\")] | //div[contains(text(),\"Spitzname der Adresse\")]");
    //Element addNickNameOthers = elementByXpath("//button/span[text()='Others']");
    Element addNickNameOthers = elementByXpath("//button/span[contains(text(),'Others')] | //button/span[contains(text(),'Andere')] | (//mat-button-toggle/button[@type='button']/span)[3]");
    Element addOtherNickNameText = elementByXpath("//div[@class=\"w-full ng-star-inserted\"]//input");
    Element  confirmDeliveryAddressButton = elementByXpath("//button/span[text()=' Confirm Delivery Address '] | //button/span[text()=' Lieferadresse bestätigen ']");
    Element selectDeliveryOption = elementByXpath("//h2[contains(text(),'Delivery Option')] | //h2[contains(text(),'Optionen für')]");
    Element addAnAddressPageTitle = elementByXpath("//ic-card//h2[contains(text(), \"Adresse hinzufügen\")] | //ic-card//div[contains(text(), \"Adresse hinzufügen\")] | //ic-card//h2[contains(text(), \"Add address\")]");
    Element countryDropdown = elementByXpath("//ic-add-address//div//mat-select");
    Element houseLabel = elementByXpath("(//mat-button-toggle/button[@type='button']/span)[1]");
    Element workLabel = elementByXpath("(//mat-button-toggle/button[@type='button']/span)[2]");
    Element addressLineOneInputField = elementByXpath("(//ic-add-address//input)[2]");
    Element addressLineTwoInputField = elementByXpath("(//ic-add-address//input)[3]");
    Element cityInputField = elementByXpath("(//ic-add-address//input)[4]");
    Element stateInputField = elementByXpath("(//ic-add-address//input)[5]");
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
        return addAnAddressPageTitle.getText();
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
    @Step("Get House label")
    public String getHouseLabel(){
        return houseLabel.getText();
    }
    @Step("Get Work label")
    public String getWorkLabel(){
        return workLabel.getText();
    }
    @Step("Wait to load Address Page")
    public AddressPageICv2 waitToLoadPage(){
        addAnAddress.waitUntilElementClickable(60);
        screenshot();
        return this;
    }

    @SneakyThrows
    @Step("Click Add An Address")
    public AddressPageICv2 clickAddAnAddress(){

        //Added this code due to static bars as element hides behind those
        Thread.sleep(4000);
//        List<WebElement> names = addresses.getElements();
//        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", names.get(names.size()-1));
        selectDeliveryOption.waitUntilElementVisible(30).scrollDownUtillFindElement();
        screenshot();
        addAnAddress.waitUntilElementVisible(60).click();
        screenshot();
        scrollToTop();
        Thread.sleep(3000);
        //used scroll method due to static bar
        deliveryOptionLabel.waitUntilElementVisible(30).scrollDownUtillFindElement();
        return this;

    }

    @Step("Click Close")
    public AddressPageICv2 clickClose(){
        closeButton.waitUntilElementVisible(60).click();
        return this;
    }
    @SneakyThrows
    @Step("Enter all address details")
    public AddressPageICv2 enterAddressDetails(TestData testData){
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        Thread.sleep(4000);
        ZipCodeInput.enterText(addressData.getZip());
        countryDropdown.click();
        selectCountry(addressData.getCountry());
        addressLineOneInputField.click();
        addressLineOneInputField.enterText(addressData.getAddressLine1());
        addressLineTwoInputField.enterText(addressData.getAddressLine2());
        cityInputField.enterText(addressData.getCity());
        stateInputField.enterText(addressData.getState());
        StateLabel.scrollDownUtillFindElement();
        Thread.sleep(2000);
        addNickNameOthers.click();
        addOtherNickNameText.click();
        addOtherNickNameText.enterText(addressData.getNickName());
        screenshot();
        return  this;

//        List<WebElement> addressElementsList = addressElements.getElements();
//        addressElementsList.get(0).sendKeys(addressData.getZip());
//        countryDropdown.click();
//        selectCountry(addressData.getCountry());
//        addressElementsList.get(1).sendKeys(addressData.getAddressLine1());
//        addressElementsList.get(2).sendKeys(addressData.getAddressLine2());
//        addressElementsList.get(3).sendKeys(addressData.getCity());
//        addressElementsList.get(4).sendKeys(addressData.getState());
//        addressElementsList.get(5).sendKeys(addressData.getZip());
//        addressElementsList.get(6).sendKeys(addressData.getNickName());
////      useMyLocation.scrollDownUtillFindElement();
////      ZipCodeInput.waitUntilElementClickable(30).click();
////      ZipCodeInput.enterText(addressData.getZip());
//
    }
    @Step("Edit Existing address details and save")
    public AddressPageICv2 editFirstAddressDetails(TestData testData){
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        screenshot();
        addressOptions.waitUntilElementVisible(30);
        List<WebElement> addressOptionsList = addressOptions.getElements();
        addressOptionsList.get(0).click();
        addressEditOption.waitUntilElementClickable(30).click();
        ZipCodeInput.waitUntilElementClickable(30).clear();
        ZipCodeInput.enterText(addressData.getZip());
        List<WebElement> addressElementsList = addressElements.getElements();
        /*addressElementsList.get(0).clear();
        addressElementsList.get(0).sendKeys(addressData.getZip());*/
        addressElementsList.get(1).clear();
        addressElementsList.get(1).sendKeys(addressData.getAddressLine1());
        addressElementsList.get(2).clear();
        addressElementsList.get(2).sendKeys(addressData.getAddressLine2());
        addressElementsList.get(3).clear();
        addressElementsList.get(3).sendKeys(addressData.getCity());
        addressElementsList.get(4).clear();
        addressElementsList.get(4).sendKeys(addressData.getState());
        /*addressElementsList.get(5).sendKeys(addressData.getZip());
        addressElementsList.get(6).sendKeys(addressData.getNickName());*/
        stateLabel.scrollDownUtillFindElement();
        addNickNameOthers.waitUntilElementVisible(25).click();
        addOtherNickNameText.clear();
        addOtherNickNameText.enterText(addressData.getNickName());
        //zipLabel.scrollDownUtillFindElement();

        screenshot();

        return  this;
    }

    @SneakyThrows
    @Step("Delete Existing address")
    public AddressPageICv2 deleteFirstAddressDetails(TestData testData) {
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        Thread.sleep(4000);
        String newlyAddedAddress= getNewlyAddedAddress();
        addressOptions.waitUntilElementVisible(30);
        List<WebElement> addressOptionsList = addressOptions.getElements();
        addressOptionsList.get(0).click();
        addressDeleteOption.waitUntilElementClickable(30).click();
        deleteDialogPopup.isElementDisplayed();
        screenshot();
        dialogDeleteButton.waitUntilElementClickable(30).click();
        waitToLoadPage();
        Thread.sleep(3000);
        List<WebElement> names = addresses.getElements();

        for (WebElement element : names) {
            String elementText = element.getText();
            if (elementText.contains(addressData.getNickName())) {
                // Assertion failed, handle the failure accordingly
                throw new AssertionError("The string '" + addressData.getNickName() + "' is present on the page.");
            }
        }
        // If the loop completes without finding a match, the assertion passes
        System.out.println("The address '" + addressData.getNickName() + "' is not present on the page.");
        screenshot();
        return this;
    }

    @SneakyThrows
    @Step("Enter Address using Use my location")
    public AddressPageICv2 useMyLocationforAddress(TestData testData)
    {
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        useMyLocation.click();
        screenshot();
        Thread.sleep(2000);
        getDriver().switchTo().alert().accept();
        Thread.sleep(2000);
        deliveryOptionLabel.scrollDownUtillFindElement(); // To scroll other elements to appear on page
        addressElements.waitUntilElementClickable(30);
        List<WebElement> addressElementsList = addressElements.getElements();
        Thread.sleep(2000);
        if(addressElementsList.get(0).getText().isEmpty()){
            addressElementsList.get(0).sendKeys(addressData.getZip());
        }
        countryDropdown.click();
        selectCountry(addressData.getCountry());
        addressElementsList.get(1).sendKeys(addressData.getAddressLine1());
        useMyLocation.scrollDownUtillFindElement();
        screenshot();
        addNickNameOthers.waitUntilElementClickable(30).click();
        addOtherNickNameText.click();
        addOtherNickNameText.enterText(addressData.getNickName());
        screenshot();
        return this;

    }
    @Step("Enter mandatory address details")
    public AddressPageICv2 enterMandatoryFields(TestData testData){
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        addressChangeButton.scrollDownUtillFindElement();
        /*ZipCodeInput.waitUntilElementClickable(30).click();
        ZipCode.enterText(addressData.getZip());*/
        List<WebElement> addressElementsList = addressElements.getElements();
        addressElementsList.get(0).sendKeys(addressData.getZip());
        addressElementsList.get(1).sendKeys(addressData.getAddressLine1());
        addressElementsList.get(3).sendKeys(addressData.getCity());
        addressElementsList.get(4).sendKeys(addressData.getState());

        elementByXpath("//mat-label[text()=\"Country\"]").scrollDownUtillFindElement();

        /*addressElementsList.get(5).sendKeys(addressData.getZip());
        addressElementsList.get(6).sendKeys(addressData.getNickName());*/
        addOtherNickNameText.enterText(addressData.getNickName());
        screenshot();
        //zipLabel.scrollDownUtillFindElement();

        return  this;
    }

    @Step("Verify the error message for empty mandatory fields")
    public boolean verifyErrorMessageForEmptyMandatoryFields(TestData testData){
        AddressDataICv2 addressData = testData.getTestData(AddressDataICv2.class);
        screenshot();
        List<WebElement> addressElementsList = addressElements.getElements();
        //addressElementsList.get(0).sendKeys(Keys.chord(Keys.CONTROL, "a"), "55");
        addressElementsList.get(0).click();
        addressElementsList.get(1).click();
        errorZip.scrollDownUtillFindElement();
        addressElementsList.get(2).click();

        addressElementsList.get(3).click();
        addressElementsList.get(4).click();
        addNickNameOthers.click();
        addOtherNickNameText.click();
        addressElementsList.get(4).click();
        screenshot();
        //if(errorCountry.isElementDisplayed() && errorAddressLine1.isElementDisplayed() && errorZip.isElementDisplayed() && errorNickName.isElementDisplayed()){
        if(errorAddressLine1.isElementDisplayed()  && errorState.isElementDisplayed() && errorCity.isElementDisplayed() && errorZip.isElementDisplayed() && errorNickName.isElementDisplayed()){
            return  true;
        }else {
            return false;
        }

    }


    @Step("Click on Continue")
    public AddressPageICv2 clickContinueButton(){
        zipLabel.scrollDownUtillFindElement();
        continueButton.waitUntilElementClickable(60).click();
        return this;
    }
    @Step("Click on Continue")
    public AddressPageICv2 clickconfirmDeliveryAddressButton(){
        addAnAddress.scrollDownUtillFindElement();
        List<WebElement> names = addresses.getElements();
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", names.get(names.size()-1));
        confirmDeliveryAddressButton.waitUntilElementClickable(60).click();
        return this;
    }

    @Step("Click on Done")
    public AddressPageICv2 clickDoneButton(){
        continueButton.waitUntilElementClickable(60).click();
        return this;
    }
    @Step("Get newly added Address Name")
    public String getNewlyAddedAddressNickName(){
        List<WebElement> names = addressNickNames.getElements();
        String Nickname = names.get(0).getText();
        screenshot();
        return names.get(0).getText();
    }

    @Step("Get newly added Address ")
    public String getNewlyAddedAddress(){
        List<WebElement> names = addresses.waitUntilElementVisible(25).getElements();
        return names.get(0).getText();

    }
    @Step("Get Done button label ")
    public String getConfirmDeliveryAddressButtonLabel(){
        return confirmDeliveryAddressButton.getText();
    }
    @Step("Click on confirm delivery address button")
    public AddressPageICv2 clickconfirmDeliveryButton(){
        confirmDeliveryAddressButton.waitUntilElementClickable(60).click();
        return this;
    }
    @SneakyThrows
    @Step("Select given country code")
    public AddressPageICv2 selectCountry(String country){
        Thread.sleep(2000);
        elementByXpath("//mat-option//span[text()=\""+country+"\"]").waitUntilElementPresent(20).scrollDownUtillFindElement().click();
        return this;
    }
    @SneakyThrows
    @Step("Click on all mandatory input fields")
    public AddressPageICv2 clickOnMandatoryInputFields(){
        BasePage basePage = new BasePage();
        List<WebElement> addressElementsList = addressElements.getElements();
        addressElementsList.get(1).click();
        addressElementsList.get(3).click();
        addressElementsList.get(4).click();
        addressElementsList.get(0).click();
        addressElementsList.get(2).click();

        //     StateLabel.scrollDownUtillFindElement();
//      Thread.sleep(2000);
//      addNickNameOthers.click();
//      addOtherNickNameText.click();
        screenshot();
        return this;
    }
    public String getZipErrorLabel(){
        return errorZip.getText();
    }
    public String getAddressLine1ErrorLabel(){
        return errorAddressLine1.getText();
    }
    public String getCityErrorLabel(){
        return errorCity.getText();
    }
    public String getStateErrorLabel(){
        return errorState.getText();
    }
    public String getNicknameErrorLabel(){
        return errorNickName.getText();
    }
    public AddressPageICv2 clickConfirmDeliveryAddressButton(){
        confirmDeliveryAddressButton.waitUntilElementClickable(25).click();
        return this;
    }


}