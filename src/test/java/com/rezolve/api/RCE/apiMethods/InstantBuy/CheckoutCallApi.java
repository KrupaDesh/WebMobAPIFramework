package com.rezolve.api.RCE.apiMethods.InstantBuy;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rezolve.api.Core.model.CommonPrams;
import com.rezolve.api.RCE.model.RCEData;
import com.rezolve.api.RCE.model.RCENegativeData;
import engine.TestData;
import engine.restUtils.RestAPIUtil;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import org.json.JSONObject;

import java.io.DataInput;
import java.util.HashMap;
import java.util.Map;

public class CheckoutCallApi {
    @SneakyThrows
    public static Response checkoutCallApi(TestData testData, String authToken, String user_id, String partner_id, String merchant_id, String option_id, String shipping_type, String payment_type,String address_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getCheckoutCallAPIPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/checkout/"+option_id;
        Map<String, String> headers = testData.getTestData(RCEData.class).getCheckoutCallAPIheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCEData.class).getCheckoutCallAPIPayload();
        /*JSONObject jsonObject = new JSONObject(payload);
        jsonObject.getJSONObject("shipping_method").put("type", shipping_type);
        jsonObject.getJSONObject("payment_method").put("type",payment_type);
        Map<String ,Object> updatedPayload = new ObjectMapper().readValue((DataInput) jsonObject, HashMap.class);*/
        ((Map<String,Object>)payload.get("shipping_method")).put("type", shipping_type);
        ((Map<String,Object>)payload.get("shipping_method")).put("address_id", address_id);
        ((Map<String,Object>)payload.get("payment_method")).put("type",payment_type);
        String schemaFilePath = "RCE/CheckoutCallSchema.json";
        return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);
    }
    public static Response checkoutCallACIApi(TestData testData, String authToken, String user_id, String partner_id, String merchant_id, String option_id, String shipping_type, String payment_type,String address_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCEData.class).getCheckoutCallACIAPIPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/checkout/"+option_id;
        Map<String, String> headers = testData.getTestData(RCEData.class).getCheckoutCallACIAPIheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCEData.class).getCheckoutCallACIAPIPayload();
        /*JSONObject jsonObject = new JSONObject(payload);
        jsonObject.getJSONObject("shipping_method").put("type", shipping_type);
        jsonObject.getJSONObject("payment_method").put("type",payment_type);
        Map<String ,Object> updatedPayload = new ObjectMapper().readValue((DataInput) jsonObject, HashMap.class);*/
        ((Map<String,Object>)payload.get("shipping_method")).put("type", shipping_type);
        ((Map<String,Object>)payload.get("shipping_method")).put("address_id", address_id);
        ((Map<String,Object>)payload.get("payment_method")).put("type",payment_type);
        String schemaFilePath = "RCE/CheckoutCallSchema.json";
        return RestAPIUtil.performPost(url, headers, payload, schemaFilePath);
    }
    public static Response checkoutCallApiWithIncorrectHeaders(TestData testData, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+merchant_id+"/checkout/"
                +testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataOptionID();
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataheaders();
        headers.remove("authorization");
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataPayload();

        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response checkoutCallApiWithInvalidOptionID(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"177"+"/checkout/"
                +testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataOptionID();;
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataPayload();

        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response checkoutCallApiWithEmptyData(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"177"+"/checkout/"
                +testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataOptionID();;
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataPayload();
        payload.clear();
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
    public static Response checkoutCallApiWithNullData(TestData testData, String authToken, String user_id, String partner_id, String merchant_id) {

        String url = testData.getTestData(CommonPrams.class).getCoreHost()+testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataPath()+partner_id+"/customer/"+user_id+"/merchant/"+"177"+"/checkout/"
                +testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataOptionID();;
        Map<String, String> headers = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataheaders();
        headers.put("authorization",authToken);
        Map<String ,Object> payload = testData.getTestData(RCENegativeData.class).getCheckoutCallAPIWithIncorrectDataPayload();
        payload.put("payment_method", null);
        payload.put("shipping_method", null);
        return RestAPIUtil.performPostWithoutSchema(url, headers, payload);
    }
}
