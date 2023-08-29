package engine.core;

import org.openqa.selenium.WebDriver;

public class Base {
    public static
    ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();

    public void driverSetUp() {
        threadLocalDriver.set(DriverManager.doDriverSetup());
    }

    public static WebDriver getDriver(){
        return threadLocalDriver.get();
    }

    public static void removeDriver(){
        threadLocalDriver.remove();
    }
}
