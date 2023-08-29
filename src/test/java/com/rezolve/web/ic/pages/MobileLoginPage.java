package com.rezolve.web.ic.pages;

import engine.LogHelper;
import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import com.rezolve.web.ic.model.EnvData;
import com.rezolve.web.ic.model.UserAccountData;

import static engine.core.Element.elementByXpath;
import static engine.reader.MyJsonReader.getDataObject;
import static io.restassured.RestAssured.given;

public class MobileLoginPage extends BasePage {


    Element countryCode = elementByXpath("//mat-select[@formcontrolname=\"country\"]");
    Element phoneNumber = elementByXpath("//input[@formcontrolname=\"phoneNumber\"]");
    Element continueButton = elementByXpath("(//button)[2]");
    Element otpFirst = elementByXpath("//input[@formcontrolname=\"first\" ]");
    Element otpSecond = elementByXpath("//input[@formcontrolname=\"second\" ]");
    Element otpThird = elementByXpath("//input[@formcontrolname=\"third\" ]");
    Element otpFourth = elementByXpath("//input[@formcontrolname=\"fourth\" ]");
    Element otpFifth = elementByXpath("//input[@formcontrolname=\"fifth\" ]");
    Element otpSixth = elementByXpath("//input[@formcontrolname=\"sixth\" ]");
    Element resendOtp = elementByXpath("//rezolve-frontend-verification-code//span/span[contains(@class,\"text-rezolve-blue\")]");
    Element pleaseEnterMobileNumberLabel = elementByXpath("(//rezolve-frontend-enter-phone-number/div/div/span)[1]");
    Element willSendYouOtp = elementByXpath("(//rezolve-frontend-enter-phone-number/div/div/span)[2]");
    Element continueButtonLabel = elementByXpath("//rezolve-frontend-form-submit-button/button/span/span");
    Element enterOneTimePasswordLabel = elementByXpath("(//rezolve-frontend-enter-verification-code/div/div/span)[1]");
    Element sentSixDigitCodeLabel = elementByXpath("(//rezolve-frontend-enter-verification-code/div/div/span)[2]");
    Element phoneNumberLabel = elementByXpath("(//rezolve-frontend-enter-verification-code/div/div/span)[3]");
    Element pleaseEnterItShortLabel = elementByXpath("(//rezolve-frontend-enter-verification-code/div/div/span)[4]");

    @Step(" Login using phone number and otp")
    public void login(TestData testData){
        UserAccountData accountData = testData.getTestData(UserAccountData.class);
        countryCode.click();
        selectGivenCode(accountData.getCountryCode()).phoneNumber.enterText(accountData.getPhoneNumber());
        continueButton.click();
        getOtpAndEnter(testData);
        continueButton.click();
    }


     @Step("Select given country code")
     public MobileLoginPage selectGivenCode(String countryCodePefixedPlus){
          elementByXpath("//span[text()=\""+countryCodePefixedPlus+"\"]").waitUntilElementPresent(20).scrollDownUtillFindElement().click();
        return this;
     }

     @Step("Enter country code and phone number")
     public MobileLoginPage enterCountryCodeAndPhoneNumber(TestData testData){
         UserAccountData accountData = testData.getTestData(UserAccountData.class);
         countryCode.click();
         selectGivenCode(accountData.getCountryCode()).phoneNumber.enterText(accountData.getPhoneNumber());
         continueButton.click();
         return this;
     }
      @Step("Verify the default the cursor on first otp box")
      public boolean isCursorOnFirstBox(){
        otpFirst.waitUntilElementVisible(30);
        screenshot();
       return switchToActiveElement().getAttribute("id").equals("otp-0");

      }


    @Step("Wait given sec and click resendotp")
    public MobileLoginPage waitAndClickResendOtp(int otpWait){
        resendOtp.waitUntilElementVisible(otpWait);
        screenshot();
        resendOtp.click();
        return new MobileLoginPage();

    }

      public void clickContinue(){
        continueButton.click();
      }
     @SneakyThrows
     @Step("Get OTP (receive-smss.com) and enter ")
    public MobileLoginPage getOtpAndEnter(TestData testData){
         UserAccountData accountData = testData.getTestData(UserAccountData.class);
         String otp = "000000";
         String mobileNumber = accountData.getCountryCode().replace("+", "") + accountData.getPhoneNumber();

     // This is use to read the html file and get the otp form https://receive-smss.com
     /*        Thread.sleep(15000);
             RestAssured.baseURI = "https://receive-smss.com";
             Response response = given()
                     .when()
                     .contentType(ContentType.HTML)
                     .get("/sms/" + mobileNumber + "/")   //https://receive-smss.com/sms/447946268462/"
                     .then()
                     .extract().response();
             //System.out.println(response.toString());
             String[] split = response.getBody().asString().split("\n");//Zhihu
             for (String l : split) {
                 if (l.contains("Rezolve")) {
                     //   System.out.println("l");
                     otp = l.split("<b>")[1].split("</b>")[0];
                     break;
                 }
             }
         */

       //   OTP API Call
         Thread.sleep(15000);
       EnvData envData = getDataObject("envDetails", EnvData.class);
         RestAssured.baseURI = envData.getRuaUrl();
         Response response = given()
                 .when()
                 .contentType(ContentType.HTML)
                 .header("Authorization",envData.getRuaAccess())
                 .get("/admin/inventory/users/+"+mobileNumber+"/anonymous-tokens")
                 .then()
                 .extract().response();
         LogHelper.log.info(response.getBody().asString());
         if( response.jsonPath().get("[0].otpCode") != null)
             otp= response.jsonPath().get("[0].otpCode").toString();
         else
             LogHelper.log.error("OTP is not received");

         if(otp.equals("000000"))
             LogHelper.log.error("OTP not found so entered default otp 000000");
         String[] pins = otp.split("");
         otpFirst.enterText(pins[0]);
         otpSecond.enterText(pins[1]);
         otpThird.enterText(pins[2]);
         otpFourth.enterText(pins[3]);
         otpFifth.enterText(pins[4]);
         otpSixth.enterText(pins[5]);
         return this;

    }


    @Step("Get Login page - Please enter your phone number ")
    public String getPleaseEnterYourPhoneNumberLabel(){
        return pleaseEnterMobileNumberLabel.getText();
    }

    @Step("Get Login page - We’ll send you a one-time password (OTP) to sign you in. ")
    public String getWillSendYouOtpLabel(){
        return willSendYouOtp.getText();
    }

    @Step("Get Login page  - Continue ")
    public String getContinueButtonLabel(){
        return continueButtonLabel.getText();
    }

    @Step("Get Login page  - Enter One Time Password Label ")
    public String getEnterOneTimePasswordLabel(){
        return enterOneTimePasswordLabel.getText();
    }

    @Step("Get Login page  - We have sent a 6-digit code to ")
    public String getSentSixDigitCodeLabel(){
        return sentSixDigitCodeLabel.getText();
    }

    @Step("Get Login page  - Please enter it in the fields below to continue. ")
    public String getPleaseEnterItShortLabel(){
        return pleaseEnterItShortLabel.getText();
    }

}
