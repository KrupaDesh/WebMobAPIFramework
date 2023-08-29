package com.rezolve.web.brain.pages;

import engine.core.BasePage;
import engine.core.Element;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

import static engine.core.Element.elementByXpath;

public class RealEstateStorePage extends BasePage {

   Element querySearchField = elementByXpath("//form//div//textarea");
   Element realEstateQuerySearchField = elementByXpath("//input[@aria-label=\"search-label-mob\"]");
   Element languageDropdown = elementByXpath("//div[@class=\"flex\"]//..//..//button");
   Element englishLanguage = elementByXpath("(//div//label//input)[1]");
   Element spanishLanguage = elementByXpath("(//div//label//input)[2]");
   Element frenchLanguage = elementByXpath("(//div//label//input)[3]");
   Element deutschLanguage = elementByXpath("(//div//label//input)[4]");
   Element koreanLanguage = elementByXpath("(//div//label//input)[5]");
   Element arabicLanguage = elementByXpath("(//div//label//input)[6]");
   Element chineseLanguage = elementByXpath("(//div//label//input)[7]");
   Element askFollowUpButton = elementByXpath("//span[@x-text=\"_('followup')\"]");
   Element searchedQueryText = elementByXpath("//span[@x-text=\"item.message\"]");
   Element queryResponseText = elementByXpath("//span[@class=\"whitespace-pre-wrap\"]");
   Element productActNowButton = elementByXpath("//div[@class=\"inner-wrap\"]//button[@type=\"button\"]");
   Element productName = elementByXpath("//div[@class=\"inner-wrap\"]//h4[1]");
   Element firstSuggestionQuery = elementByXpath("//div/section/div[3]/div/div/ul/li[1]");
   Element showSuggestions = elementByXpath("//div[1]/div[2]/div[1]/div/p");
   Element allSuggestionsQuery = elementByXpath("//div/section/div[3]/div/div/ul/li");
   Element followUpSearchedQueryText = elementByXpath("(//span[@x-text=\"item.message\"])[2]");
    Element followUpQueryResponseText = elementByXpath("(//span[@class=\"whitespace-pre-wrap\"])[2]");
    Element followUpQueryProductActNowButton = elementByXpath("//section/div[4]/div/div/div[2]/div[2]/div/div/div/div[2]/button");
    Element followUpQueryProductName = elementByXpath("//section/div[4]/div/div/div[2]/div[2]/div/div/div/div[2]/h4[1]");


    @Step("Enter your query")
    public RealEstateStorePage enterYourQuery(String query) {
        WebElement searchField = driver.findElement(By.xpath("//input[@aria-label=\"search-label-mob\"]"));
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }
    @Step("Ask a follow up query")
    public RealEstateStorePage enterYourFollowUpQuery(String query) {
        WebElement searchField = driver.findElement(By.xpath("(//input[@aria-label=\"search-label-mob\"])[2]"));
        searchField.sendKeys(query);
        searchField.sendKeys(Keys.ENTER);
        return this;
    }
    @Step("Get searched query text")
    public String getSearchedQuery(){
      return searchedQueryText.waitUntilElementVisible(25).getText();
    }
    @Step("Verify query response displayed")
    public boolean isQueryResponseDisplayed(){
        long startTime = System.currentTimeMillis();
        long timeout = 6000;
        while(queryResponseText.waitUntilElementVisible(25).getText().isEmpty() && System.currentTimeMillis()-startTime<timeout)
        {
            queryResponseText.getText();
        }
        screenshot();
        return queryResponseText.getText().isEmpty();
    }
    @Step("Get Default Message Content")
    public String getDefaultMessage(){
        long startTime = System.currentTimeMillis();
        long timeout = 6000;
        while(queryResponseText.waitUntilElementVisible(25).getText().isEmpty() && System.currentTimeMillis()-startTime<timeout)
        {
            queryResponseText.getText();
        }
        screenshot();
        return queryResponseText.getText();
    }
    @Step("Get all Act Now buttons")
    public List<WebElement> getActNowButtons(){
        List<WebElement> actNowButton = productActNowButton.waitUntilElementVisible(25).getElements();
        return actNowButton;
    }
    @Step("Get all Products Name")
    public List<WebElement> getProductsName(){
        screenshot();
        List<WebElement> productsName = productName.waitUntilElementVisible(25).getElements();
        return productsName;
    }
    @Step("Verify Act Now Button Displayed for searched query")
    public boolean isActNowButtonDisplayed(){
        if(productActNowButton.waitUntilElementVisible(25).isElementDisplayed()){
            return true;
        }else {
            return false;
        }
    }
    @Step("Click on Buy Now button")
    public RealEstateStorePage clickActNow(WebElement element){
        element.click();
        return this;
    }
    @Step("Select English Language")
    public RealEstateStorePage selectEnglishLanguage(){
        languageDropdown.waitUntilElementVisible(25).click();
        englishLanguage.click();
        return this;
    }
    @Step("Select Spanish Language")
    public RealEstateStorePage selectSpanishLanguage(){
        languageDropdown.waitUntilElementVisible(25).click();
        spanishLanguage.click();
        return this;
    }
    @Step("Select French Language")
    public RealEstateStorePage selectFrenchLanguage(){
        languageDropdown.waitUntilElementVisible(25).click();
        frenchLanguage.click();
        return this;
    }
    @Step("Select Deutsch Language")
    public RealEstateStorePage selectDeutschLanguage(){
        languageDropdown.waitUntilElementVisible(25).click();
        deutschLanguage.click();
        return this;
    }
    @Step("Select Korean Language")
    public RealEstateStorePage selectKoreanLanguage(){
        languageDropdown.waitUntilElementVisible(25).click();
        koreanLanguage.click();
        return this;
    }
    @Step("Select Arabic Language")
    public RealEstateStorePage selectArabicLanguage(){
        languageDropdown.waitUntilElementVisible(25).click();
        arabicLanguage.click();
        return this;
    }
    @Step("Select Chinese Language")
    public RealEstateStorePage selectChineseLanguage(){
        languageDropdown.waitUntilElementVisible(25).click();
        chineseLanguage.click();
        return this;
    }
    @Step("Verify English language detected by brain")
    public boolean isEnglishLanguageDetected(){
        languageDropdown.waitUntilElementVisible(25).click();
        if(englishLanguage.isElementSelected()){
            return true;
        }else {
            return false;
        }
    }
    @Step("Verify Spanish language detected by brain")
    public boolean isSpanishLanguageDetected(){
        languageDropdown.waitUntilElementVisible(25).click();
        if(spanishLanguage.isElementSelected()){
            return true;
        }else {
            return false;
        }
    }
    @Step("Verify French language detected by brain")
    public boolean isFrenchLanguageDetected(){
        languageDropdown.waitUntilElementVisible(25).click();
        if(frenchLanguage.isElementSelected()){
            return true;
        }else {
            return false;
        }
    }
    @Step("Verify Deutsch language detected by brain")
    public boolean isDeutschLanguageDetected(){
        languageDropdown.waitUntilElementVisible(25).click();
        if(deutschLanguage.isElementSelected()){
            return true;
        }else {
            return false;
        }
    }
    @Step("Verify Korean language detected by brain")
    public boolean isKoreanLanguageDetected(){
        languageDropdown.waitUntilElementVisible(25).click();
        if(koreanLanguage.isElementSelected()){
            return true;
        }else {
            return false;
        }
    }
    @Step("Verify Arabic language detected by brain")
    public boolean isArabicLanguageDetected(){
        languageDropdown.waitUntilElementVisible(25).click();
        if(arabicLanguage.isElementSelected()){
            return true;
        }else {
            return false;
        }
    }
    @Step("Verify Chinese language detected by brain")
    public boolean isChineseLanguageDetected(){
        languageDropdown.waitUntilElementVisible(25).click();
        if(chineseLanguage.isElementSelected()){
            return true;
        }else {
            return false;
        }
    }
    @SneakyThrows
    @Step("Get first suggestion query")
    public String getFirstSuggestionQuery(){
        Thread.sleep(1000);
        return firstSuggestionQuery.waitUntilElementVisible(25).getText();
    }
    @Step("Click on first suggestion query")
    public RealEstateStorePage clickFirstSuggestion(){
        firstSuggestionQuery.waitUntilElementVisible(25).click();
        return this;
    }
    @Step("Click on show suggestion")
    public RealEstateStorePage clickShowSuggestion(){
        showSuggestions.scrollDownUtillFindElement().waitUntilElementVisible(25).click();
        return this;
    }
    @Step("Get all suggestions query")
    public List<WebElement> getAllSuggestionsQuery(){
        List<WebElement> queries = allSuggestionsQuery.waitUntilElementVisible(25).getElements();
        return queries;
    }
    @Step("Click on suggestion query")
    public RealEstateStorePage clickOnSuggestionsQuery(WebElement element){
        element.click();
        return this;
    }
    @Step("Get follow up searched query text")
    public String getFollowUpSearchedQuery(){
        return followUpSearchedQueryText.waitUntilElementVisible(25).getText();
    }
    @Step("Verify Follow Up query response displayed")
    public boolean isFollowUpQueryResponseDisplayed(){
        long startTime = System.currentTimeMillis();
        long timeout = 6000;
        while(followUpQueryResponseText.waitUntilElementVisible(25).getText().isEmpty() && System.currentTimeMillis()-startTime<timeout)
        {
            followUpSearchedQueryText.getText();
        }
        screenshot();
        return followUpSearchedQueryText.getText().isEmpty();
    }
    @Step("Get Follow Up query all Act Now buttons")
    public List<WebElement> getFollowUpQueryActNowButtons(){
        List<WebElement> buyNowButton = followUpQueryProductActNowButton.waitUntilElementVisible(25).getElements();
        return buyNowButton;
    }
    @Step("Get Follow Up query all Products Name")
    public List<WebElement> getFollowUpQueryProductsName(){
        screenshot();
        List<WebElement> productsName = followUpQueryProductName.waitUntilElementVisible(25).getElements();
        return productsName;
    }
    @Step("Verify Act Now Button Displayed for searched Follow Up Query ")
    public boolean isFollowUpQueryActNowButtonDisplayed(){
        if(followUpQueryProductActNowButton.waitUntilElementVisible(25).isElementDisplayed()){
            return true;
        }else {
            return false;
        }
    }
    @Step("Click on Ask Follow Up Query button")
    public RealEstateStorePage clickAskFollowUpQuery(){
        askFollowUpButton.click();
        return this;
    }

}
