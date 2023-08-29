package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.EncryptedValue;
import com.rezolve.api.RCE.model.RCEData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.util.Map;

public class BuyACIAPI {


        @SneakyThrows
        public static Response buyACIApi(TestData testData, String authToken, String user_id, String partner_id, String merchant_id, String checkout_id, String card_id, String payment_type, String phone_id, String public_key) {

            String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getBuyAPIPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/buy/"+checkout_id;
            Map<String, String> headers = testData.getTestData(RCEData.class).getBuyAPIheaders();
            headers.put("authorization",authToken);
            Map<String ,Object> payload = testData.getTestData(RCEData.class).getBuyAPIPayload();

            ((Map<String, Object>) payload.get("payment_method")).put("pay_with", card_id);
            ((Map<String, Object>) payload.get("payment_method")).put("type",payment_type);
            ((Map<String, Object>) payload.get("payment_method")).put("phone_id",phone_id);
        ((Map<String, Object>)((Map<String, Object>) payload.get("payment_method")).get("browser_info")).put("color_depth",Integer.valueOf(32));
        ((Map<String, Object>)((Map<String, Object>) payload.get("payment_method")).get("browser_info")).put("screen_height",Integer.valueOf(2072));
        ((Map<String, Object>)((Map<String, Object>) payload.get("payment_method")).get("browser_info")).put("screen_width",Integer.valueOf(1080));
        ((Map<String, Object>)((Map<String, Object>) payload.get("payment_method")).get("browser_info")).put("timezone_offset",Integer.valueOf(330));
            String encValue= EncryptedValue.genratedEncryptedValue("123",public_key);

            ((Map<String,Object>)payload.get("payment_method")).put("cvv",encValue);
            ((Map<String,Object>)payload.get("payment_method")).put("type",payment_type);
            String schemaFilePath = "RCE/OptionCallSchema.json";
            return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);
        }


}
