package com.rezolve.api.Core.apiMethods;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.Core.model.CoreData;
import com.rezolve.api.Core.model.CoreNegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.io.IOException;
import java.util.Map;

public class UpdatePasswordAPI {
    public static Response verifyUpdatePasswordAPI(TestData testData, String authToken) throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost() + testData.getTestData(CoreData.class).getUpdatePasswordPath();
        Map<String, String> headers = testData.getTestData(CoreData.class).getUpdatePasswordHeaders();
        headers.put("authorization", authToken);
        Map<String, Object> payload = testData.getTestData(CoreData.class).getUpdatePasswordPayload();

        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }

    // to again udpate password to original password to continue wiht same userid
    @SneakyThrows
    public static Response verifyReverseUpdatePasswordAPI(TestData testData, String authToken) throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost() + testData.getTestData(CoreData.class).getUpdatePasswordPath();
        Map<String, String> headers = testData.getTestData(CoreData.class).getUpdatePasswordHeaders();
        headers.put("authorization", authToken);
        Map<String, Object> payload = testData.getTestData(CoreData.class).getUpdatePasswordPayload();
        /*payload.put("currentPassword","test12345");
        payload.put("newPassword","test1234");*/
        String tempCurrentPwd = payload.get("currentPassword").toString();
        payload.put("currentPassword", payload.get("newPassword"));
        payload.put("newPassword", tempCurrentPwd);
        Thread.sleep(2000);
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }

    public static Response verifyUpdatePasswordAPIWithIncorrectData(TestData testData, String authToken) throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost() + testData.getTestData(CoreNegativeData.class).getUpdatePasswordApiWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getUpdatePasswordApiWithIncorrectDataHeaders();
        headers.put("authorization", authToken);
        Map<String, Object> payload = testData.getTestData(CoreNegativeData.class).getUpdatePasswordApiWithIncorrectDataPayload();
        payload.put("currentPassword", "789test892");//Random paswd

        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }

    public static Response verifyUpdatePasswordAPIWithIncorrectHeader(TestData testData) throws IOException {

        String url = testData.getTestData(CommonPrams.class).getRuaHost() + testData.getTestData(CoreNegativeData.class).getUpdatePasswordApiWithIncorrectDataPath();
        Map<String, String> headers = testData.getTestData(CoreNegativeData.class).getUpdatePasswordApiWithIncorrectDataHeaders();
        headers.remove("authorization");
        Map<String, Object> payload = testData.getTestData(CoreNegativeData.class).getUpdatePasswordApiWithIncorrectDataPayload();

        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);

    }
}
