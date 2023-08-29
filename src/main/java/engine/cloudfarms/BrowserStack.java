package engine.cloudfarms;

import engine.reader.ConfigReader;
import engine.reader.MyJsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import static engine.constants.Config.CAPABILITIES_FILE;
import static engine.constants.Config.CLOUD_CONFIG;
import static engine.constants.Paths.*;
public class BrowserStack {


    public static WebDriver getDriver(String capsFilePath){

        HashMap<String, Object> caps = MyJsonReader.readJsonObject(Path.of(CAPS_ROOT_PATH + ConfigReader.configDetails.get(CAPABILITIES_FILE) + ".json"));
        String browserName = caps.get("browserName").toString();
        if(browserName.equalsIgnoreCase("safari")){
            return getSafariDriver(capsFilePath);
        }else if(browserName.equalsIgnoreCase("edge")){
            return getEdgeDriver(capsFilePath);
        }
        else if(browserName.equalsIgnoreCase("firefox")){
            return getFirefoxDriver(capsFilePath);
        }else if(browserName.equalsIgnoreCase("chrome")) {
            return getChromeDriver(capsFilePath);
        }else{
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
    }
    private static WebDriver getChromeDriver(String capsFilePath){
        WebDriver driver = null;
        ChromeOptions chromeOptions = null;
        HashMap<String, Object> caps = MyJsonReader.readJsonObject(Path.of(CAPS_ROOT_PATH + ConfigReader.configDetails.get(CAPABILITIES_FILE) + ".json"));
        String browserName = caps.get("browserName").toString();
        if(browserName.equalsIgnoreCase("chrome")) {
            chromeOptions = new ChromeOptions();
        }else{
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        HashMap<String, Object> browserstackOptions;
        for(Map.Entry cap: caps.entrySet()){
            if(cap.getKey().toString().equals("bstack:chromeOptions")){
                browserstackOptions = MyJsonReader.readJsonObject(cap.getValue().toString());
                chromeOptions.setCapability("bstack:chromeOptions", browserstackOptions);
            }else if(!cap.getKey().equals("browserName")) {
                chromeOptions.setCapability(cap.getKey().toString(), cap.getValue());
            }
        }

        try {
            HashMap<String, Object> config = MyJsonReader.readJsonObject(Path.of(CLOUD_CONFIG_ROOT_PATH + ConfigReader.configDetails.get(CLOUD_CONFIG) + ".json"));

            String userName = System.getProperty("BROWSERSTACK_USERNAME").equals("") ?  config.get("username").toString() :System.getProperty("BROWSERSTACK_USERNAME");
            String accessKey = System.getProperty("BROWSERSTACK_ACCESS_KEY").equals("")? config.get("accessKey").toString() : System.getProperty("BROWSERSTACK_ACCESS_KEY");
            System.out.println("Remote URL: "+"https://" + userName + ":" + accessKey + "@"+config.get("hub")+"/wd/hub");
            //   driver = new RemoteWebDriver(new URL("https://" + config.get("username") + ":" + config.get("accessKey") + "@"+config.get("hub")+"/wd/hub"), chromeOptions);
            driver = new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + "@"+config.get("hub")+"/wd/hub"), chromeOptions);
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // return  driver;
    }



    private static WebDriver getSafariDriver(String capsFilePath){
        WebDriver driver = null;
        SafariOptions safariOptions = null;
        HashMap<String, Object> caps = MyJsonReader.readJsonObject(Path.of(CAPS_ROOT_PATH + ConfigReader.configDetails.get(CAPABILITIES_FILE) + ".json"));
        String browserName = caps.get("browserName").toString();
        if(browserName.equalsIgnoreCase("safari")){
            safariOptions = new SafariOptions();
        }else{
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        HashMap<String, Object> browserstackOptions;
        for(Map.Entry cap: caps.entrySet()){
            if(cap.getKey().toString().equals("bstack:safariOptions")){
                browserstackOptions = MyJsonReader.readJsonObject(cap.getValue().toString());
                safariOptions.setCapability("bstack:safariOptions", browserstackOptions);
            }else if(!cap.getKey().equals("browserName")) {
                safariOptions.setCapability(cap.getKey().toString(), cap.getValue());
            }
        }
        try {
            HashMap<String, Object> config = MyJsonReader.readJsonObject(Path.of(CLOUD_CONFIG_ROOT_PATH + ConfigReader.configDetails.get(CLOUD_CONFIG) + ".json"));
            String userName = System.getProperty("BROWSERSTACK_USERNAME").equals("") ?  config.get("username").toString() :System.getProperty("BROWSERSTACK_USERNAME");
            String accessKey = System.getProperty("BROWSERSTACK_ACCESS_KEY").equals("")? config.get("accessKey").toString() : System.getProperty("BROWSERSTACK_ACCESS_KEY");
            // driver = new RemoteWebDriver(new URL("https://" + config.get("username") + ":" + config.get("accessKey") + "@"+config.get("hub")+"/wd/hub"), safariOptions);
            driver = new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + "@"+config.get("hub")+"/wd/hub"), safariOptions);
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // return  driver;
    }

    private static WebDriver getEdgeDriver(String capsFilePath){
        WebDriver driver = null;
        EdgeOptions edgeOptions = null;
        HashMap<String, Object> caps = MyJsonReader.readJsonObject(Path.of(CAPS_ROOT_PATH + ConfigReader.configDetails.get(CAPABILITIES_FILE) + ".json"));
        String browserName = caps.get("browserName").toString();
        if(browserName.equalsIgnoreCase("edge")){
            edgeOptions = new EdgeOptions();
        }else{
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        HashMap<String, Object> browserstackOptions;
        for(Map.Entry cap: caps.entrySet()){
            if(cap.getKey().toString().equals("bstack:edgeOptions")){
                browserstackOptions = MyJsonReader.readJsonObject(cap.getValue().toString());
                edgeOptions.setCapability("bstack:edgeOptions", browserstackOptions);
            }else if(!cap.getKey().equals("browserName")) {
                edgeOptions.setCapability(cap.getKey().toString(), cap.getValue());
            }
        }
        try {
            HashMap<String, Object> config = MyJsonReader.readJsonObject(Path.of(CLOUD_CONFIG_ROOT_PATH + ConfigReader.configDetails.get(CLOUD_CONFIG) + ".json"));
            String userName = System.getProperty("BROWSERSTACK_USERNAME").equals("") ?  config.get("username").toString() :System.getProperty("BROWSERSTACK_USERNAME");
            String accessKey = System.getProperty("BROWSERSTACK_ACCESS_KEY").equals("")? config.get("accessKey").toString() : System.getProperty("BROWSERSTACK_ACCESS_KEY");

            //driver = new RemoteWebDriver(new URL("https://" + config.get("username") + ":" + config.get("accessKey") + "@"+config.get("hub")+"/wd/hub"), edgeOptions);
            driver = new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + "@"+config.get("hub")+"/wd/hub"), edgeOptions);
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // return  driver;
    }


    private static WebDriver getFirefoxDriver(String capsFilePath){
        WebDriver driver = null;
        FirefoxOptions firefoxOptions = null;
        HashMap<String, Object> caps = MyJsonReader.readJsonObject(Path.of(CAPS_ROOT_PATH + ConfigReader.configDetails.get(CAPABILITIES_FILE) + ".json"));
        String browserName = caps.get("browserName").toString();
        if(browserName.equalsIgnoreCase("firefox")){
            firefoxOptions = new FirefoxOptions();
        }else{
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }

        HashMap<String, Object> browserstackOptions;
        for(Map.Entry cap: caps.entrySet()){
            if(cap.getKey().toString().equals("bstack:firefoxOptions")){
                browserstackOptions = MyJsonReader.readJsonObject(cap.getValue().toString());
                firefoxOptions.setCapability("bstack:firefoxOptions", browserstackOptions);
            }else if(!cap.getKey().equals("browserName")) {
                firefoxOptions.setCapability(cap.getKey().toString(), cap.getValue());
            }
        }
        try {
            HashMap<String, Object> config = MyJsonReader.readJsonObject(Path.of(CLOUD_CONFIG_ROOT_PATH + ConfigReader.configDetails.get(CLOUD_CONFIG) + ".json"));
            String userName = System.getProperty("BROWSERSTACK_USERNAME").equals("") ?  config.get("username").toString() :System.getProperty("BROWSERSTACK_USERNAME");
            String accessKey = System.getProperty("BROWSERSTACK_ACCESS_KEY").equals("")? config.get("accessKey").toString() : System.getProperty("BROWSERSTACK_ACCESS_KEY");
            driver = new RemoteWebDriver(new URL("https://" + userName + ":" + accessKey + "@"+config.get("hub")+"/wd/hub"), firefoxOptions);
            //driver = new RemoteWebDriver(new URL("https://" + config.get("username") + ":" + config.get("accessKey") + "@"+config.get("hub")+"/wd/hub"), firefoxOptions);
            return driver;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        // return  driver;
    }
}
