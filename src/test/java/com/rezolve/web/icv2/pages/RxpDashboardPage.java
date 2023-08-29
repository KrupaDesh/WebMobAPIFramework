package com.rezolve.web.icv2.pages;

import engine.TestData;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.Keys;
import com.rezolve.web.icv2.model.RxpEngagementDataICv2;

import static engine.core.Element.elementByXpath;

public class RxpDashboardPage extends BasePage {



    Element icHeaderLinkSnippet = elementByXpath("(//span[@class='code-snippet'])[1]");
    Element  icButtonCodeSnippet= elementByXpath("(//span[@class='code-snippet'])[2]");
    Element  closeICGenerateButtonCodePopup= elementByXpath("//button[contains(@class, 'close')]");
    Element  yesButton= elementByXpath("(//mat-dialog-container//span[@class=\"mat-button-wrapper\"])[2]");
    Element  menuDelete= elementByXpath("(//button[@role='menuitem'])[1]");
    Element  searchBox= elementByXpath("(//app-search-input//input)[2]");



//   (//app-confirm-button/button[@data-test='create-buy-page'])[2]
//
//    actButton: //div[@data-test="target-page-create-ACT"]
//    buy: //div[@data-test="target-page-create-BUY"]
//
//    info: //div[@data-test="target-page-create-INFORMATION"]
//
//    url: //div[@data-test="target-page-create-URL"]



    public RxpDashboardPage clickDownloadOfGivenEngagement(TestData testdata){
        String name = testdata.getTestData(RxpEngagementDataICv2.class).getName();
       elementByXpath ("(//mat-card//section/h3[text()=' "+name+" ']/../..//mat-icon[@data-mat-icon-name='download'])[3]").click();
       return this;
    }

    public RxpDashboardPage clickDownloadOfGivenSmartCode(TestData testdata){
        String name = testdata.getTestData(RxpEngagementDataICv2.class).getName();
        elementByXpath ("(//mat-card//section/h3[text()=' "+name+" ']/../..//mat-icon[@data-mat-icon-name='download'])[1]").click();
        return this;
    }
    @SneakyThrows
    public RxpDashboardPage clickCopyLinkOfGivenEngagement(TestData testdata){
        String name = testdata.getTestData(RxpEngagementDataICv2.class).getName();
        Thread.sleep(4000);

       if(elementByXpath ("//mat-card//section/h3[text()=' "+name+" ']/../../section[@gdarea='status']/div[@class='color green']").getElements().size()<=0)
           refresh();
       refresh();
       elementByXpath ("(//mat-card//section/h3[text()=' "+name+" ']/../..//mat-icon[text()='file_copy'])[1]").click();
       alertAccept();
       return this;
    }


    public RxpDashboardPage clickMoreOfGivenEngagement(TestData testdata){
        String name = testdata.getTestData(RxpEngagementDataICv2.class).getName();
        elementByXpath ("//mat-card//section/h3[text()=' "+name+" ']/../..//button").click();
        return this;
    }
     public RxpDashboardPage clickDeleteOnMenu(){
              menuDelete.click();
            return  this;
     }

    public RxpDashboardPage clickYesButton(){
        try {
            yesButton.click();
            Thread.sleep(4000);
        }catch (Exception e){

        }
        return  this;
    }

    public String getHeaderCodeSnippet(){
        return  icHeaderLinkSnippet.getText();
    }
    public String getButtonCodeSnippet(){
        return  icButtonCodeSnippet.getText();
    }

    public RxpDashboardPage closeIcCodeSnippetPopup(){
        closeICGenerateButtonCodePopup.click();
        return this;
    }


    @SneakyThrows
    @Step("Paste the value from clipoard")
    public RxpDashboardPage pasteCopyLinkInSearchBox(){
        if(getPlatformName().toLowerCase().equals("mac")){
            searchBox.enterText(Keys.COMMAND + "v");
        }else {
            searchBox.enterText(Keys.CONTROL + "v");
        }
        Thread.sleep(2000);
        return this;
    }

    @Step("Get the search box value")
    public String  getTheSearchBoxText(){
        return searchBox.getAttribute("value");
    }



}
