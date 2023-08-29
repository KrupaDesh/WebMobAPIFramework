package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class DeleteCard {
    public static Response deleteCardAPI(TestData testData, String authToken, String user_id, String partner_id, String card_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getDeleteCardAPIPath()+partner_id+"/customer/"+user_id+"/wallet/";
        Map<String, String> headers = testData.getTestData(RCEData.class).getDeleteCardAPIheaders();
        headers.put("authorization",authToken);
        return RestAPIUtil.performDelWithAuth(url, headers, card_id);
    }
    public static Response deleteCardAPIWithIncorrectHeaders(TestData testData, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getDeleteCardAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/wallet/";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getDeleteCardAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        String card_id= testData.getTestData(RCENegativeData.class).getDeleteCardAPIDeletedCardID();
        return RestAPIUtil.performDelWithAuth(url, headers, card_id);
    }
    public static Response deleteCardAPIWithDeletedcardID(TestData testData,String authToken, String user_id, String partner_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getDeleteCardAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/wallet/";
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getDeleteCardAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        String card_id= testData.getTestData(RCENegativeData.class).getDeleteCardAPIDeletedCardID();
        return RestAPIUtil.performDelWithAuth(url, headers, card_id);
    }

}
