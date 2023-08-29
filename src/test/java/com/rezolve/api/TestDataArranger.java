package com.rezolve.api;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Core.model.CoreData;
import engine.TestData;
import engine.core.BaseTest;

public class TestDataArranger {
    public static TestData getCommonLoginApiDataTest()
    {
        return new TestData().addTestData("baseloginAPI", APIBaseTestData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
}
