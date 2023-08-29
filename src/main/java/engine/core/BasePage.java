package engine.core;

import com.optimaize.langdetect.LanguageDetector;
import com.optimaize.langdetect.LanguageDetectorBuilder;
import com.optimaize.langdetect.ngram.NgramExtractors;
import com.optimaize.langdetect.profiles.LanguageProfile;
import com.optimaize.langdetect.profiles.LanguageProfileReader;
import com.optimaize.langdetect.text.CommonTextObjectFactories;
import com.optimaize.langdetect.text.TextObject;
import com.optimaize.langdetect.text.TextObjectFactory;
import io.qameta.allure.Attachment;
import lombok.SneakyThrows;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.*;

import static engine.core.Element.elementByXpath;

public class BasePage {

    public WebDriver driver;
    public BasePage(){

        try {
            driver = Base.getDriver();
        }catch (Exception e)
        {System.out.println("Compile time test failure");// Krupa- Adding comment for debug
            e.printStackTrace();}
    }

    public void back(){
        this.driver.navigate().back();
    }

    public void forward(){
        this.driver.navigate().forward();
    }

    public void refresh(){
        this.driver.navigate().refresh();
    }

    public void navigateTo(String url){
        this.driver.navigate().to(url);
    }

    public void fullscreen(){
        this.driver.manage().window().fullscreen();
    }

    public void maximize(){
        this.driver.manage().window().maximize();
    }
    public void close(){
        this.driver.close();
    }

    public void deleteAllCookies(){
        this.driver.manage().deleteAllCookies();
    }
    public void switchToFrame(int frameIndex){
        this.driver.switchTo().frame(frameIndex);
    }
    @SneakyThrows
    public void alertAccept() {
        Thread.sleep(3000);
        Alert alert = this.driver.switchTo().alert();
        alert.accept();
    }
    @SneakyThrows
    public void alertAndroidAlow(){
        Thread.sleep(3000);
     //   this.driver.findElement(By.xpath("//*[text()='Allow']")).click();
        driver.findElement(By.id("com.android.chrome:id/button1")).click();
    }
    public void alertDismiss(){
        Alert alert = this.driver.switchTo().alert();
        alert.dismiss();
    }
    public void openNewTabAndNavigate(){
        this.driver.switchTo().newWindow(WindowType.TAB);
    }
    @SneakyThrows
    public void switchToTab(int tabIndex){
        Thread.sleep(2000);
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        Thread.sleep(2000);
        this.driver.switchTo().window(tabs.get(tabIndex));
        Thread.sleep(2000);
    }
    public void switchToMain(){
        this.driver.switchTo().defaultContent();
    }

    public String getTitle(){
       return  this.driver.getTitle();
    }

    public void getUrl(String url){
        this.driver.get(url);
    }

    public WebElement switchToActiveElement(){
        return  this.driver.switchTo().activeElement();
    }

    public void scrollDown(){
        JavascriptExecutor js = (JavascriptExecutor) this.driver;
        js.executeScript("window.scrollBy(0,250)", "");
    }

    public void scrollToTop(){
        Actions actions = new Actions(this.driver);
        actions.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
    }


    public void dragAndDrop(Element from, Element to){

        Actions builder = new Actions(this.driver);
//     //   builder.clickAndHold(from.getElement()).moveToElement(to.getElement()).release().perform();
//         builder.dragAndDrop(from.getElement(), to.getElement()).build().perform();
//      //  builder.moveToElement(from.getElement(), to.getElement()).build().perform();
        builder.clickAndHold(from.getElement())
                .moveToElement(to.getElement())
                .release(to.getElement())
                .build()
                .perform();
    }
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] screenshot() {
        String screenshotAsBase64 = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.BASE64);
        screenshotAsBase64 = screenshotAsBase64.replaceAll("[\n\r]", "");
        byte[] bytes = Base64.getDecoder().decode(screenshotAsBase64);
        return bytes;
    }
    @SneakyThrows
    public void processDynamicLocator(String dynamicLocator){
        String[] split = dynamicLocator.split("\\|");
        Element element = null;

        if(split[0].toLowerCase().equals("xpath")){
           element=  elementByXpath(split[1]);
           // element.scrollDownUtillFindElement();
        }
        if(split[2].toLowerCase().equals("click")){
            element.click();
        }

        Thread.sleep(2000);
    }
    public String getPlatformName(){
        return  ((RemoteWebDriver) this.driver).getCapabilities().getCapability("platformName").toString();
    }
    public String getBrowserName(){
        return  ((RemoteWebDriver) this.driver).getCapabilities().getBrowserName();
    }
    public void clickOutside() {
        Actions action = new Actions(this.driver);
        action.moveByOffset(10, 10).click().build().perform();
    }
    public String detectLanguage(String text) {
        try {
            //load all languages:
            List<LanguageProfile> languageProfiles = new LanguageProfileReader().readAllBuiltIn();
            //build language detector:
            LanguageDetector languageDetector = LanguageDetectorBuilder.create(NgramExtractors.standard())
                    .withProfiles(languageProfiles)
                    .build();
            //create a text object factory
            TextObjectFactory textObjectFactory = CommonTextObjectFactories.forDetectingOnLargeText();
            //Text:
            TextObject textObject = textObjectFactory.forText(text);
            String[] lang = languageDetector.detect(textObject).toString().split("\\(");
            String language = lang[1];
            System.out.println("Detected Lang: "+language);

            return language;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }
    public void switchToFrame(WebElement frameElement){
        this.driver.switchTo().frame(frameElement);
    }
    public void switchToFrame(String nameOrId){
        this.driver.switchTo().frame(nameOrId);
    }
}
