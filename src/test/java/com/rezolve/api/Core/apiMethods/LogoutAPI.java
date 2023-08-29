package com.rezolve.api.Core.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Core.model.CoreData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class LogoutAPI {

    public static Response logoutAPI(TestData testData, String authToken) {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreData.class).getLogoutApiPath();
        Map<String, String> headers = testData.getTestData(CoreData.class).getLogoutApiHeaders();
        headers.put("authorization", authToken);

        return RestAPIUtil.performPostWithoutBodyAndSchema(url, headers);
    }
}
