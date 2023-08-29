package com.rezolve.web.ic.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.rezolve.web.ic.model.RxpEngagementData;

import static engine.core.Element.elementById;
import static engine.core.Element.elementByXpath;

public class QrScanPage extends BasePage {
    Element fileUpload = elementById("file-selector");
    Element openUrlButton = elementByXpath("(//button/span)[1]");

    @SneakyThrows
    @Step("Select Given Qr Code image")
    public QrScanPage selectGivenQRCode(TestData testData){
     //   fileUpload.fileUploadSendkeys("/Users/arulchristopher/downloads/"+testData.getTestData(RxpEngagementData.class).getName()+".png");

        if (getPlatformName().toLowerCase().equals("mac")){
           fileUpload.fileUploadSendkeys("/Users/test1/downloads/"+testData.getTestData(RxpEngagementData.class).getName()+".png");
       }else {
           fileUpload.fileUploadSendkeys("C:\\Users\\hello\\downloads\\" + testData.getTestData(RxpEngagementData.class).getName() + ".png");
       }
       Thread.sleep(10000);
        return new QrScanPage();
    }

    @SneakyThrows
    @Step("Select Given Qr Code image")
    public QrScanPage selectLocalCode(){
        WebDriver remoteDriver = this.driver;

        ((RemoteWebDriver)remoteDriver).setFileDetector(new LocalFileDetector());
        remoteDriver.findElement(By.id("file-selector")).sendKeys("src/test/resources/testData/ic_stagging/files/smartCode1.png");
        Thread.sleep(10000);
        return new QrScanPage();
    }


    @Step("Open Url")
    public void openUrl(){
        openUrlButton.waitUntilElementClickable(60).click();
    }


}
