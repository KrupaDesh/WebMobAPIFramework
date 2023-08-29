package engine.core;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Element extends Base {

    private final int defaultExplicitWaitInSec = 30;
    protected WebElement webElement;
    protected By by;

    private static Element by(By by) {
        Element element = new Element();
        element.by= by;
        return element;
    }

    public static Element elementById(String id ){
        return by(By.id(id));
    }

    public static Element elementByXpath(String xpath ){
        return by(By.xpath(xpath));
    }
    public static Element elementByName(String name ){
        return by(By.name(name));
    }

    public static Element elementByClassName(String className ){
        return by(By.className(className));
    }

    public static Element elementByCssSelector(String cssSelector ){
        return by(By.cssSelector(cssSelector));
    }

    public void click(){
        this.waitUntilElementVisible(defaultExplicitWaitInSec).getElement().click();
    }

    public void enterText(String input){
        this.waitUntilElementVisible(defaultExplicitWaitInSec).getElement().sendKeys(input);
    }
    public void fileUploadSendkeys(String input){
        this.getElement().sendKeys(input);
    }
    public Element clear(){
        this.waitUntilElementVisible(defaultExplicitWaitInSec).getElement().clear();
        return this;
    }

    public String getCssValue(String cssAttribute){
       return this.waitUntilElementVisible(defaultExplicitWaitInSec).getCssValue(cssAttribute);
    }

    public String getText(){
        return  this.waitUntilElementVisible(defaultExplicitWaitInSec).getElement().getText();
    }

    public String getAttribute(String type){
       return this.waitUntilElementVisible(defaultExplicitWaitInSec).getElement().getAttribute(type);
    }

    public WebElement getElement(){
        try {
            this.webElement = getDriver().findElements(this.by).get(0);
        }catch (Exception e){
            throw new NoSuchElementException("Element Not Found : " + by.toString());
        }
        return this.webElement;
    }

    public List<WebElement> getElements(){
        try {
            return   getDriver().findElements(this.by);
        }catch (Exception e){
            throw new NoSuchElementException("Element Not Found : " + by.toString());
        }
    }

    public Element waitUntilElementVisible(int sec){
        new WebDriverWait(getDriver(), Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOfElementLocated(this.by));
       return this;
    }

    public Element waitUntilElementClickable(int sec){
        new WebDriverWait(getDriver(), Duration.ofSeconds(sec)).until(ExpectedConditions.elementToBeClickable(this.by));
        return this;
    }
    public Element waitUntilElementPresent(int sec){
        new WebDriverWait(getDriver(), Duration.ofSeconds(sec)).until(ExpectedConditions.presenceOfElementLocated(this.by));
        return this;
    }

    public Element waitUntilElementVisible(int sec, boolean takeScreenshot){
        new WebDriverWait(getDriver(), Duration.ofSeconds(sec)).until(ExpectedConditions.visibilityOfElementLocated(this.by));
        if(takeScreenshot)
            new BasePage().screenshot();
        return this;
    }

    public boolean isElementDisplayed(){
        return this.getElement().isDisplayed();
    }

    public boolean isElementEnabled(){
        return this.getElement().isEnabled();
    }

    public Element scrollDownUtillFindElement(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("return arguments[0].scrollIntoView(true);", getDriver().findElements(this.by).get(0));
        return this;
    }
   public Element scrollDownUtillFindElementWithadditionalbottomSpace(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollTo(0, arguments[0].getBoundingClientRect().top - 200);", getDriver().findElements(this.by).get(0));
        return this;
    }
    public void doubleClick()
    {
        Actions act = new Actions(getDriver());
        act.doubleClick(getElement()).perform();
    }
    public boolean isElementSelected(){
        return this.getElement().isSelected();
    }

}
