package com.rezolve.api.SmartTrigger.model;

import com.rezolve.api.Core.model.CoreData;
import com.rezolve.api.Profile.model.ProfileData;
import engine.TestData;

public class TestDataArrangerAPI {

    /*public static String platformName = new BasePage().getPlatformName().toLowerCase();
    public static String browserName = new BasePage().getBrowserName().toLowerCase();*/


    //**********Smart Trigger APIs data set**********//
    public static TestData checkInAPIData()
    {
        return new TestData().addTestData("checkInAPI", SmartTriggersData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData trackingAPIData()
    {
        return new TestData().addTestData("trackingAPI", SmartTriggersData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getTagsAPIData()
    {
        return new TestData().addTestData("getTagsAPI", SmartTriggersData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData updateTagsAPIData()
    {
        return new TestData().addTestData("updateTagsAPI", SmartTriggersData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData myAreaAPIData()
    {
        return new TestData().addTestData("myAreaAPI", SmartTriggersData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData addEventAPIData()
    {
        return new TestData().addTestData("addEventAPI", SmartTriggersData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData addBulkEventAPIData()
    {
        return new TestData().addTestData("addBulkEventAPI", SmartTriggersData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    /*******Negative test cases data**********/

    public static TestData checkInAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("checkInAPIWithIncorrectData", SmartTriggersNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData trackingAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("trackingAPIWithIncorrectData", SmartTriggersNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getTagsAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("getTagsAPIWithIncorrectData", SmartTriggersNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData updateTagsAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("updateTagsAPIWithIncorrectData", SmartTriggersNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData myAreaAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("myAreaAPIWithIncorrectData", SmartTriggersNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData addEventAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("addEventAPIWithIncorrectData", SmartTriggersNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData addBulkEventAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("addBulkEventAPIWithIncorrectData", SmartTriggersNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
}
