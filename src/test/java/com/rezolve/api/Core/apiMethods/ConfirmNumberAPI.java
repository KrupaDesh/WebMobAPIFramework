package com.rezolve.api.Core.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Core.model.CoreData;
import com.rezolve.api.Core.model.CoreNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.io.IOException;
import java.util.Map;

public class ConfirmNumberAPI {
    public static Response getConfirmNumberAPI(TestData testData, int loginId)throws IOException {

            String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreData.class).getConfirmNumberPath()+ loginId+"/tokens";
            Map<String, String> headers = testData.getTestData(CoreData.class).getConfirmNumberApiHeaders();
            return RestAPIUtil.performGetWithoutSchema(url, headers);

    }
    public static Response getConfirmNumberAPIwithIncorrectUrl(TestData testData)throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost()+testData.getTestData(CoreNegativeData.class).getConfirmNumberApiWithIncorrectDataPath()+"/null"+"/tokens";//null login Id
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getConfirmNumberApiWithIncorrectDataHeaders();
        return RestAPIUtil.performGetWithoutSchema(url, headers);

    }
}
