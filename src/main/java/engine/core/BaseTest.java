package engine.core;
import engine.LogHelper;
import engine.constants.Config;
import engine.reader.ConfigReader;
import engine.reader.MyJsonReader;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.awt.event.KeyEvent;
import java.awt.*;
import static engine.reader.ConfigReader.configDetails;
public class BaseTest extends Base {
    public static String browserName;
    @BeforeMethod(alwaysRun = true)
    public void setup()
    {

        driverSetUp();
        if(configDetails.get(Config.BASEURL) !=null)
            getDriver().get(configDetails.get(Config.BASEURL));
        else
            LogHelper.log.info("Baseurl is null. The url is missing in given property files "  +System.getProperty("config","base"));
    }
    @Step("Load the URL")
    public void driverGetUrl(String url) {
        getDriver().get(url);
/*        HashMap<String, Object> caps = MyJsonReader.readJsonObject(Path.of(CAPS_ROOT_PATH + ConfigReader.configDetails.get(CAPABILITIES_FILE) + ".json"));
        browserName = caps.get("browserName").toString();
        if(browserName.equalsIgnoreCase("chrome")){
            ((JavascriptExecutor) getDriver()).executeScript("document.body.style.zoom='0.5'");
        }
        else if(browserName.equalsIgnoreCase("firefox")) {
        ((JavascriptExecutor) getDriver()).executeScript("document.body.style.MozTransform = 'scale(0.33)'");
     }*/
        /*public void zoomOut(){*/
        //To zoom out page 4 time using CTRL and - keys.
/*        for(int i=0; i<4; i++){
            getDriver().findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, Keys.SUBTRACT));
        }*/

//        try {
//            Robot robot = new Robot();
//            System.out.println("About to zoom in");
//            for (int i = 0; i < 2; i++) {
//                robot.keyPress(KeyEvent.VK_CONTROL);
//                robot.keyPress(KeyEvent.VK_SUBTRACT);
//                robot.keyRelease(KeyEvent.VK_SUBTRACT);
//                robot.keyRelease(KeyEvent.VK_CONTROL);
//            }
//        }catch (Exception e)
//        {
//            LogHelper.log.info("Zoom in is not wokring on browser");
//        }
    }
    @Step("Maximize the window")
    public void maximizeWindow(){

        getDriver().manage().window().maximize();

    }

    @AfterMethod()
    public void teardown(ITestResult result) {
        if(ITestResult.FAILURE==result.getStatus()){
            WebDriver driver = getDriver();
            if (driver != null)
                new BasePage().screenshot();
            //  Allure.addAttachment(result.getName(), new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        }
        getDriver().quit();
        removeDriver();
    }

}
