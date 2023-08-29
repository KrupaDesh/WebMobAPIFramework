package com.rezolve.api.Core.model;

import com.rezolve.api.Profile.model.ProfileData;
import com.rezolve.api.SmartTrigger.model.SmartTriggersData;
import engine.TestData;

public class TestDataArrangerAPI {
    public static TestData getLoginApiDataTest()
    {
        return new TestData().addTestData("loginAPI", CoreData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getConfirmNumberApiDataTest()
    {
        return new TestData().addTestData("confirmNumberApi", CoreData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getRegisterV2ApiData()
    {
        return new TestData().addTestData("registerV2Api", CoreData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getGuestRegisterApiData()
    {
        return new TestData().addTestData("guestRegisterApi", CoreData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getGuestLoginApiData()
    {
        return new TestData().addTestData("guestLoginApi", CoreData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getForgotPasswordApiData()
    {
        return new TestData().addTestData("forgotPasswordApi", CoreData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getUpdatePasswordApiData()
    {
        return new TestData().addTestData("updatePasswordApi", CoreData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getLogoutApiData()
    {
        return new TestData().addTestData("logoutApi", CoreData.class)
                .addTestData("endpoint",CommonPrams.class);
    }

        /*public static String platformName = new BasePage().getPlatformName().toLowerCase();
    public static String browserName = new BasePage().getBrowserName().toLowerCase();*/

    //*********Core API Negative data sets***********//


    public static TestData getLoginAPIWithIncorrectData()
    {
        return new TestData().addTestData("loginAPIWithIncorrectData", CoreNegativeData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getRegisterV2ApiWithIncorrectData()
    {
        return new TestData().addTestData("registerV2WithIncorrectDataApi", CoreNegativeData.class)
                .addTestData("endpoint",CommonPrams.class);
    }

    public static TestData getConfirmNumberApiwithIncorrectData()
    {
        return new TestData().addTestData("confirmNumberApiWithIncorrectData", CoreNegativeData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getGuestRegisterApiWithIncorrectData()
    {
        return new TestData().addTestData("guestRegisterApiWithIncorrectData", CoreNegativeData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getGuestLoginApiWithIncorrectData()
    {
        return new TestData().addTestData("guestLoginApiWithIncorrectData", CoreNegativeData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getForgotPasswordApiWithIncorrectData()
    {
        return new TestData().addTestData("forgotPasswordApiWithIncorrectData", CoreNegativeData.class)
                .addTestData("endpoint",CommonPrams.class);
    }
    public static TestData getUpdatePasswordApiWithIncorrectData()
    {
        return new TestData().addTestData("updatePasswordApiWithIncorrectData", CoreNegativeData.class)
                .addTestData("endpoint",CommonPrams.class);
    }


}
