package com.rezolve.api.RXP.model;

import com.rezolve.api.Core.model.CommonPrams;
import engine.TestData;

public class TestDataArrangerAPI {

    /*public static String platformName = new BasePage().getPlatformName().toLowerCase();
    public static String browserName = new BasePage().getBrowserName().toLowerCase();*/

    public static TestData getOAuthAPIData()
    {
        return new TestData().addTestData("OAuthAPI", RXPData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getGetActByIDAPIData()
    {
        return new TestData().addTestData("GetActByIdAPI", RXPData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getGetEngagementsByIDAPIData()
    {
        return new TestData().addTestData("GetEngagementsByIdAPI", RXPData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getGetGeoEngagementsAPIData()
    {
        return new TestData().addTestData("GetGeoEngagementsAPI", RXPData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getSearchEngagementAPIData()
    {
        return new TestData().addTestData("SearchEngagementAPI", RXPData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    //*******Negative test data************//

    public static TestData getOAuthAPIWithIncorrectDataData()
    {
        return new TestData().addTestData("OAuthAPIWithIncorrectData", RXPNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getGetActByIDAPIWithIncorrectDataData()
    {
        return new TestData().addTestData("GetActByIdAPIWithIncorrectData", RXPNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getGetEngagementsByIDAPIWithIncorrectDataData()
    {
        return new TestData().addTestData("GetEngagementsByIdAPIWithIncorrectData", RXPNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getGetGeoEngagementsAPIWithIncorrectDataData()
    {
        return new TestData().addTestData("GetGeoEngagementsAPIWithIncorrectData", RXPNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getSearchEngagementAPIWithIncorrectDataData()
    {
        return new TestData().addTestData("SearchEngagementAPIWithIncorrectData", RXPNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

}
