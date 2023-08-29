package com.rezolve.api.Profile.test;


import com.rezolve.api.APIBaseTest;
import com.rezolve.api.Profile.apiMethods.*;
import engine.TestData;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static com.rezolve.api.Profile.model.TestDataArrangerAPI.*;

public class ProfileAPITest extends APIBaseTest {
    public static String phone_id,address_id,address_id_forCard,phone_id_forcard,public_key =null;
    @Test(priority = 3,description = "Verify Update Profile API",groups={"API_regression"})
    //@Test(priority = 3,dependsOnMethods = {"verifyLogin"},description = "Verify Update Profile API",groups={"API_regression"})
    public void verifyUpdateProfile() throws IOException {
        TestData testData = updateProfileAPIData();
        Response response = UpdateProfileAPI.updateprofileAPI(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 4,description = "Verify Get Profile API",groups={"API_regression"})
    //@Test(priority = 3,dependsOnMethods = {"verifyLogin","verifyUpdateProfile"},description = "Verify Get Profile API",groups={"API_regression"})
    public void verifyGetProfile() throws IOException {
        TestData testData = getProfileAPIData();
        Response response = GetProfileAPI.getGetProfileAPI(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 3,description = "Verify Get Public Key API",groups={"API_regression"})
    //@Test(priority = 3,dependsOnMethods = "verifyLogin",description = "Verify Get Public Key API",groups={"API_regression"})
    public void verifyGetPublicKey() throws IOException {
        //System.out.println("Profile> Token:"+token+" User id:"+user_id+"PartnerID:" +partner_id);
        TestData testData = getPublicKeyAPIData();
        Response response = GetPublicKeyAPI.getpublicKeyAPI(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 200);
        public_key = response.path("public_key");
    }

    //Commenting as delete phonebook is failing
    @Test(priority = 3,description = "Verify Add Phonebook API",groups={"API_regression"})
    //@Test(priority = 3,dependsOnMethods = "verifyLogin",description = "Verify Add Phonebook API",groups={"API_regression"})
    public void verifyAddPhonebook() throws IOException {
        TestData testData = addPhonebookAPIData();
        Response response = AddPhonebookAPI.addPhonebookAPI(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 201);
        phone_id = response.path("id");
    }
    @Test(priority = 4,description = "Verify Get Phonebook API",groups={"API_regression"})
    //@Test(priority = 3,dependsOnMethods = {"verifyLogin","verifyAddPhonebook"},description = "Verify Add Phonebook API",groups={"API_regression"})
    public void verifyGetPhonebook() throws IOException, ParseException {
        TestData testData = getPhonebookAPIData();
        Response response = GetPhonebookAPI.getPhonebookAPI(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 200);
        Map<String,Object > responseBody = GetPhonebookAPI.getPhonebookAPI();
/*        List<Map<String ,Object>> phoneList = (List<Map<String,java.lang.Object>>) responseBody.get("phones");
        if(phoneList.get(0).isEmpty()){}
        else {
            Map<String, Object> firstPhoneDetails = phoneList.get(0);
            phone_id_forcard = firstPhoneDetails.get("id").toString();
        }*/
    }
    @Test(priority = 5,dependsOnMethods = "verifyAddPhonebook",description = "Verify Add Address API",groups={"AddressAPI","API_regression"})
    //@Test(priority = 3,dependsOnMethods = {"verifyLogin","verifyGetPhonebook"},description = "Verify Add Address API",groups={"AddressAPI","API_regression"})
    public void verifyAddAddress() throws IOException {
        TestData testData = addAddressAPIData();
        Response response = AddAddressAPI.addAddressAPI(testData,token,user_id,partner_id,phone_id);
        Assert.assertEquals(response.statusCode(), 201);
        address_id = response.path("id");
    }
/*    @Test(priority = 5,dependsOnMethods = "verifyAddPhonebook",description = "Verify Add additional Address for card API",groups={"AddressAPI","API_regression"})
    //@Test(priority = 3,dependsOnMethods = {"verifyLogin","verifyGetPhonebook"},description = "Verify Add Address API",groups={"AddressAPI","API_regression"})
    public void verifyAddAddressforCard() throws IOException {
        TestData testData = addAddressAPIData();
        Response response = AddAddressAPI.addAddressAPI(testData,token,user_id,partner_id,phone_id);
        Assert.assertEquals(response.statusCode(), 201);
        address_id_forCard = response.path("id");
    }*/

    @Test(priority = 6,description = "Verify Get Address API",groups={"API_regression"})
    //@Test(priority = 3,dependsOnMethods = {"verifyLogin","verifyAddAddress"},description = "Verify Get Address API",groups={"API_regression"})
    public void verifyGetAddress() throws IOException {
        TestData testData = getAddressAPIData();
        Response response = GetAddressAPI.getAddressAPI(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 200);
        List<Map<String ,Object>> addressList =  response.jsonPath().getList("$");
        address_id_forCard = addressList.get(4).get("id").toString();
        phone_id_forcard=addressList.get(4).get("phone_id").toString();
    }
    //@Test(priority = 3,dependsOnMethods = {"verifyLogin","verifyGetAddress"},description = "Verify Delete Address API",groups={"API_regression"})
    @Test(priority = 7,description = "Verify Delete Address API",groups={"API_regression"})

    public void verifyDelAddress() throws IOException {
        TestData testData = delAddressByIDAPIData();
        Response response = DeleteAddressByIDAPI.delAddressAPI(testData,token,user_id,partner_id,address_id);
        Assert.assertEquals(response.statusCode(), 204);
    }
    @Test(priority = 8,description = "Verify Update Phonebook API",groups={"API_regression"})
    public void verifyUpdatePhonebook() throws IOException {
        TestData testData = updatePhonebookAPIData();
        Response response = UpdatePhonebookAPI.updatePhonebookAPI(testData,token,user_id,partner_id,phone_id);
        Assert.assertEquals(response.statusCode(), 200);
    }
    //@Test(priority = 3,dependsOnMethods = {"verifyLogin","verifyDelAddress"},description = "Verify Delete Phonebook API",groups={"API_regression"})
    @Test(priority = 9,description = "Verify Delete Phonebook API",groups={"API_regression"})
    public void verifyDelPhonebook() throws IOException {
        TestData testData = delPhonebookAPIData();
        Response response = DeletePhonebookAPI.delPhonebookAPI(testData,token,user_id,partner_id,phone_id);
        Assert.assertEquals(response.statusCode(), 204);
    }

}
