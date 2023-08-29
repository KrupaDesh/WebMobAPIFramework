package com.rezolve.api;

import io.restassured.path.json.JsonPath;

public class ResponseExtractor {
    public static void main(String[] args) {
        String jsonResponse = "{\n" +
                "    \"phone_number\": \"1111111111\",\n" +
                "    \"payment_method\": \"aci\",\n" +
                "    \"partner_name\": \"Rezolve Shared Partner\",\n" +
                "    \"partner_id\": \"2\",\n" +
                "    \"order_id\": \"10571\",\n" +
                "    \"name\": \"ACI Staging Test Store\",\n" +
                "    \"merchant_id\": \"184\",\n" +
                "    \"email\": \"cgouldthorpe@gmail.com\",\n" +
                "    \"data\": {\n" +
                "        \"provider_tx_code\": \"8ac7a49f899a782d01899aaf56791cfe\",\n" +
                "        \"merchant_tx_code\": \"a153d6e9-6a7a-4baa-a56c-05c2cf65e1d3\",\n" +
                "        \"iframe\": {\n" +
                "            \"params\": {\n" +
                "                \"threeDSMethodData\": \"eyJ0aHJlZURTTWV0aG9kTm90aWZpY2F0aW9uVVJMIjoiaHR0cHM6Ly90ZXN0Lm9wcHdhLmNvbS9jb25uZWN0b3JzL2FyX3NpbXVsYXRvci8zZHMyO2pzZXNzaW9uaWQ9MEE1QTI0NUEyRjY4RDhBQTdBMTA2NkI5REZGOUFGMjYudWF0MDEtdm0tY29uMDI_YXN5bmNzb3VyY2U9QUNJXzNEU18yJnR5cGU9bWV0aG9kTm90aWZpY2F0aW9uJm5kY2lkPThhYzdhNGNhN2M5M2ExMWYwMTdjOTNmMTM1ODkwMThjXzE1ZmJlODI4NWE1ODQxOTBiNzI2YTVlMjU0MzZlMzJhIiwidGhyZWVEU1NlcnZlclRyYW5zSUQiOiI3MGRkYmI1Yy1kODMwLTQzZGEtODhlNy1iNDY0YmVhZTg3YWIifQ\"\n" +
                "            },\n" +
                "            \"parameters\": {\n" +
                "                \"threeDSMethodData\": \"eyJ0aHJlZURTTWV0aG9kTm90aWZpY2F0aW9uVVJMIjoiaHR0cHM6Ly90ZXN0Lm9wcHdhLmNvbS9jb25uZWN0b3JzL2FyX3NpbXVsYXRvci8zZHMyO2pzZXNzaW9uaWQ9MEE1QTI0NUEyRjY4RDhBQTdBMTA2NkI5REZGOUFGMjYudWF0MDEtdm0tY29uMDI_YXN5bmNzb3VyY2U9QUNJXzNEU18yJnR5cGU9bWV0aG9kTm90aWZpY2F0aW9uJm5kY2lkPThhYzdhNGNhN2M5M2ExMWYwMTdjOTNmMTM1ODkwMThjXzE1ZmJlODI4NWE1ODQxOTBiNzI2YTVlMjU0MzZlMzJhIiwidGhyZWVEU1NlcnZlclRyYW5zSUQiOiI3MGRkYmI1Yy1kODMwLTQzZGEtODhlNy1iNDY0YmVhZTg3YWIifQ\"\n" +
                "            },\n" +
                "            \"action\": \"https://test.ppipe.net/connectors/demo/submit?action=ACI3DS2AccessControlServer&acsRequest=METHOD\"\n" +
                "        },\n" +
                "        \"form\": {\n" +
                "            \"params\": {},\n" +
                "            \"parameters\": {},\n" +
                "            \"action\": \"https://test.ppipe.net/connectors/asyncresponse_simulator;jsessionid=0A5A245A2F68D8AA7A1066B9DFF9AF26.uat01-vm-con02?asyncsource=ACI_3DS_2&type=methodRedirect&cdkForward=true&ndcid=8ac7a4ca7c93a11f017c93f13589018c_15fbe8285a584190b726a5e25436e32a\"\n" +
                "        },\n" +
                "        \"flow\": \"redirect\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    }\n" +
                "}";



        // Parse the JSON response
        JsonPath jsonPath = new JsonPath(jsonResponse);

        //Extract
        String threeDSMethodData = jsonPath.getString("data.iframe.params.threeDSMethodData");
        String action= jsonPath.getString("data.iframe.action");



        // Print the "type" value
        System.out.println(threeDSMethodData);
        System.out.println(action);
    }
}
