package com.rezolve.web.rxp.model;

import engine.TestData;

import static engine.reader.MyJsonReader.getDataObject;

public class TestDataArranger {

    public static TestData productCase(){
       return new TestData().addTestData(getDataObject("userCredentials",LoginData.class))
                .addTestData("electronics",ProductData.class);
    }

    public static TestData loginCase(){
        return new TestData().addTestData("userCredentials", LoginData.class);
    }

    public static TestData paymentProviderDetailsCase(){
        TestData testData = new TestData();
        testData.addTestData("yourDetails", PaymentProviderDetailsData.class)
                .addTestData("userCredentials", LoginData.class)
                .addTestData("paymentProviders", PaymentProvidersData.class);
             //  .addTestData("commonDetails", PaymentProviderDetailsData.class)
             //   .addTestData("visaDetails", PaymentProviderDetailsData.class);
        testData.addTestData("selectECommercePlatform",EcommercePlatformData.class);
        testData.addTestData("bigCommercePlatformDetails",EcommercePlatformData.class);
        return testData;
    }
}
