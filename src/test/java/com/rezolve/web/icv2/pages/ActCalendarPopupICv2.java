package com.rezolve.web.icv2.pages;

import engine.LogHelper;
import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static engine.core.Element.elementByXpath;

public class ActCalendarPopupICv2 extends BasePage {


  private   Element monthYearButton = elementByXpath("(//mat-calendar-header//button)[1]");

 private    Element year = elementByXpath("//button/div[contains(text(),'2023')]");
 private    Element month = elementByXpath("//button/div[contains(text(),'DEC')]");
 private    Element date = elementByXpath("//button/div[contains(text(),' 30 ')]");

      public void selectDate(){
          monthYearButton.click();
          year.click();
          month.click();
          date.click();
          screenshot();
      }

//    public void selectDate(TestData testData){
//        monthYearButton.click();
//        year.click();
//        month.click();
//        date.click();
//    }

    @Step("Select Older Date")
    public void selectOlderDate(){
          try {
              monthYearButton.click();
              year.click();
              driver.findElements(By.xpath("//button/div[contains(text(),'JAN')]")).get(0).click();
              date.click();
          }catch (Exception e){
              LogHelper.log.info("OLD date is not selected");
          }
        screenshot();
    }
}
