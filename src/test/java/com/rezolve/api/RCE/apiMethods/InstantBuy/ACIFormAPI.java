package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;

import java.util.Map;

public class ACIFormAPI {
    public static Response aciFormAPIforBuyOrder(TestData testData, String action, String input1) {

        String url = "https://test.ppipe.net/connectors/asyncresponse_simulator;jsessionid=0A5A245A2F68D8AA7A1066B9DFF9AF26.uat01-vm-con02?asyncsource=ACI_3DS_2&type=methodRedirect&cdkForward=true&ndcid=8ac7a4ca7c93a11f017c93f13589018c_15fbe8285a584190b726a5e25436e32a";
        Map<String, String> formParam = testData.getTestData(RCEData.class).getACIFormForBuyOrderPayload();
        //formParam.put("threeDSMethodData",input1);
        return RestAPIUtil.performPostWithURLEncodedData(url, formParam);
    }
}
