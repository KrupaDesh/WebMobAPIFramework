package com.rezolve.api.Profile.model;

import engine.TestData;

public class TestDataArrangerAPI {


    //*********Profile API data sets***********//
    public static TestData getPublicKeyAPIData()
    {
        return new TestData().addTestData("getPublicKeyAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData addPhonebookAPIData()
    {
        return new TestData().addTestData("addPhonebookAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getPhonebookAPIData()
    {
        return new TestData().addTestData("getPhonebookAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    public static TestData addAddressAPIData()
    {
        return new TestData().addTestData("addAddressAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getAddressAPIData()
    {
        return new TestData().addTestData("getAddressAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData delAddressByIDAPIData()
    {
        return new TestData().addTestData("delAddressByIDAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData updatePhonebookAPIData()
    {
        return new TestData().addTestData("updatePhonebookAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData delPhonebookAPIData()
    {
        return new TestData().addTestData("delPhonebookAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData updateProfileAPIData()
    {
        return new TestData().addTestData("updateProfileAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getProfileAPIData()
    {
        return new TestData().addTestData("getProfileAPI", ProfileData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
//****Negative test cases data*****//

    public static TestData getPublicKeyAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("getPublicKeyAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData updateProfileAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("updateProfileAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getProfileAPIDataWithIncorrectData() {
        return new TestData().addTestData("getProfileAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData addPhonebookAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("addPhonebookAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getPhonebookAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("getPhonebookAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    public static TestData addAddressAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("addAddressAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getAddressAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("getAddressAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData delAddressByIDAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("delAddressByIDAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData updatePhonebookAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("updatePhonebookAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData delPhonebookAPIDataWithIncorrectData()
    {
        return new TestData().addTestData("delPhonebookAPIWithIncorrectData", ProfileNegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }


}
