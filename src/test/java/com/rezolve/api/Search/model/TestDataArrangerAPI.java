package com.rezolve.api.Search.model;

import com.rezolve.api.Core.model.CommonPrams;

import engine.TestData;

public class TestDataArrangerAPI {

    /*public static String platformName = new BasePage().getPlatformName().toLowerCase();
    public static String browserName = new BasePage().getBrowserName().toLowerCase();*/

    public static TestData getMerchantSearchApiData()
    {
        return new TestData().addTestData("merchantSearchAPI", SearchData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getProductSearchApiData()
    {
        return new TestData().addTestData("productSearchAPI", SearchData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    /********For Negative test cases**********/

    public static TestData getMerchantSearchApiWithIncorrectData()
    {
        return new TestData().addTestData("merchantSearchAPIWithIncorrectData", SearchNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getProductSearchApiWithIncorrectData()
    {
        return new TestData().addTestData("productSearchAPIWithIncorrectData", SearchNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

}
