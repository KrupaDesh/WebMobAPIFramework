package com.rezolve.web.brain.model;

import com.rezolve.RandomGenerator;
import com.rezolve.web.icv2.model.*;
import engine.TestData;
import engine.core.BasePage;
import io.qameta.allure.Step;

import static engine.reader.MyJsonReader.getDataObject;

public class TestDataArranger {


    @Step("TestData Sample Query")
    public static TestData getSampleQuery(){
        return new TestData().addTestData("electronicsStoreQuery", QueryData.class);
    }

    @Step("TestData Sample Query for Default Message Content")
    public static TestData defaultMsgContentCase(){
        return new TestData().addTestData("electronicsStore", StoreLinkData.class)
                .addTestData("defaultMessageContent", QueryData.class);
    }
    @Step("TestData Sample Query")
    public static TestData electronicsStoreCase(){
        return new TestData().addTestData("electronicsStore", StoreLinkData.class)
                .addTestData("electronicsStoreQuery", QueryData.class)
                .addTestData("enterQueryInputFieldPlaceholderText", LabelsData.class)
                .addTestData("queryLanguage", LanguageData.class);
    }
    @Step("TestData Sample Query for Default Message Content")
    public static TestData rezolveAllDemoStoresCase(){
        return new TestData().addTestData("websiteLink", StoreLinkData.class);
    }
    @Step("TestData Sample Query")
    public static TestData realEstateStoreCase(){
        return new TestData().addTestData("realEstateStore", StoreLinkData.class)
                .addTestData("realEstateStoreQuery", QueryData.class)
                .addTestData("queryLanguage", LanguageData.class)
                .addTestData("facebookAccount", UserLoginData.class);
    }

}

