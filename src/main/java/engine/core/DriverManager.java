package engine.core;

import engine.cloudfarms.BrowserStack;
import engine.reader.ConfigReader;
import engine.reader.MyJsonReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static engine.constants.Config.*;
import static engine.constants.Features.SUPPORTED_CLOUD_FARMS;
import static engine.constants.Paths.CAPS_ROOT_PATH;
import static engine.constants.Paths.CLOUD_CONFIG_ROOT_PATH;

public class DriverManager {
    public static WebDriver doDriverSetup() {
        WebDriver driver = null;
        String demo = ConfigReader.configDetails.get(CLOUD_NAME);
        if(ConfigReader.configDetails.get(CLOUD_NAME) == null ){
            if( !ConfigReader.configDetails.get(CAPABILITIES_FILE).isEmpty()){

                HashMap<String, Object> caps = MyJsonReader.readJsonObject(Path.of(CAPS_ROOT_PATH + ConfigReader.configDetails.get(CAPABILITIES_FILE) + ".json"));
                if(caps.get("browserName").toString().equalsIgnoreCase("safari")){
                    WebDriverManager.safaridriver().setup();
                    SafariOptions options = new SafariOptions();
                    for(Map.Entry cap: caps.entrySet()){
                        options.setCapability(cap.getKey().toString(),cap.getValue());
                    }
                    options.setCapability("browserstack.safari.allowAllCookies","true");
                    driver = new SafariDriver(options);
                }
                else if(caps.get("browserName").toString().equalsIgnoreCase("edge")){
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    for(Map.Entry cap: caps.entrySet()){
                        options.setCapability(cap.getKey().toString(),cap.getValue());
                    }
                    options.setCapability("locationContextEnabled",true);
                    options.setCapability("ms:edgeOptions","{\"extenstions\":[{\"name\":\"Location\", \"version\":\"1.0\"}]}");
                    options.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(options);
                }
                else if(caps.get("browserName").toString().equalsIgnoreCase("firefox")){
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    for(Map.Entry cap: caps.entrySet()){
                        options.setCapability(cap.getKey().toString(),cap.getValue());
                    }
                    options.setCapability("geo.prompt.testing",true);
                    options.setCapability("geo.prompt.testing.allow",true);
                    driver = new FirefoxDriver(options);
                }else if(caps.get("browserName").toString().equalsIgnoreCase("chrome")) {
                    Map < String, Object > prefs = new HashMap < String, Object > ();
                    Map < String, Object > profile = new HashMap < String, Object > ();
                    Map < String, Object > contentSettings = new HashMap < String, Object > ();
                    Map prefs1= new HashMap();
                    // SET CHROME OPTIONS
                    // 0 - Default, 1 - Allow, 2 - Block
                    contentSettings.put("geolocation", 1);
                    profile.put("managed_default_content_settings", contentSettings);
                    //prefs.put("profile", profile);
                    prefs.put("profile.default_content_settings.cookies",2);
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    for(Map.Entry cap: caps.entrySet()){
                        if(!cap.getKey().equals("browserName"))
                            options.setCapability(cap.getKey().toString(),cap.getValue());
                    }
                    //Adding below to block all cookies on chrome
                    //Map prefs= new HashMap();
                    prefs.put("profile.default_content_settings.cookies",2);
                    options.setExperimentalOption("prefs", prefs);

                    options.addArguments("--remote-allow-origins=*");
                    //options.setExperimentalOption("prefs", prefs);
                    // SET CAPABILITY
                    options.setCapability(ChromeOptions.CAPABILITY, options);
                    driver = new ChromeDriver(options);
                }else{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }else{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

        }else {
            String cloudName = ConfigReader.configDetails.get(CLOUD_NAME).toLowerCase();
            if( !ConfigReader.configDetails.get(CAPABILITIES_FILE).isEmpty()){
                String capsFilePath = CAPS_ROOT_PATH + ConfigReader.configDetails.get(CAPABILITIES_FILE) + ".json";
                if(cloudName.equals(SUPPORTED_CLOUD_FARMS[0].toLowerCase())) {
                    driver= BrowserStack.getDriver(capsFilePath);
                }else{
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                }
            }else{
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }

        }
        return driver;
    }
}