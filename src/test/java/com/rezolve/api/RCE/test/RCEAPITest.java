package com.rezolve.api.RCE.test;


import com.rezolve.api.APIBaseTest;
import com.rezolve.api.Profile.test.ProfileAPITest;
import com.rezolve.api.RCE.apiMethods.InstantBuy.*;
import com.rezolve.api.RCE.model.RCEData;
import engine.TestData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.rezolve.api.RCE.model.TestDataArrangerAPI.*;

public class RCEAPITest extends APIBaseTest {
    public static String merchant_id, category_id,address_id_forCard,phone_id_forcard,card_id,updated_card_id,public_key,phone_id = null;
    public static String order_id,option_id,checkout_id,shipping_type,payment_type, option_id_ACI,checkout_id_ACI,shipping_type_ACI,payment_type_ACI=null;
    public static String action, threeDSMethodData;
    public static Integer product_id;


    //@Test(priority = 2, dependsOnMethods = {"verifyLogin"}, description = "Verify Get Merchant List API", groups = {"API_regression"})
    @Test(priority = 3, description = "Verify Get Merchant List API", groups = {"API_regression"})
    public void verifyGeterchantList()  {
        TestData testData = getMerchantListApiData();
        Response response = GetMerchantListAPI.getMerchantListAPI(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 3,description = "Verify Get Merchnat API",groups={"API_regression"})
    //@Test(priority = 2,dependsOnMethods = {"verifyMerchantSearch"},description = "Verify Get Merchnat API",groups={"API_regression"})
    public void verifyGetMerchant() {
        TestData testData = getMerchantApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_SPPayment();
        Response response = GetMerchantAPI.getMerchantAPI(testData,token,user_id,partner_id,merchant_id);
        Assert.assertEquals(response.statusCode(), 200);
    }
    //@Test(priority = 2,description = "Verify Get Categories And Products for the merchant API",groups={"API_regression"})
    @Test(priority = 3,dependsOnMethods = {"verifyMerchantSearch"},description = "Verify Get Categories And Products for the merchant API",groups={"API_regression"})
    public void verifyGetCategoriesAndProductsForTheMerchant() throws IOException {
        TestData testData = getCategoriesAndProductsForThemerchantApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_SPPayment();
        Response response = GetCategoriesAndProductsForTheMerchantAPI.getCategoriesAndProductsForTheMerchantAPI(testData,token,user_id,partner_id,merchant_id);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        if(responseJsonPath.getString("categories.items[0].id").toString() != null){
            category_id=responseJsonPath.getString("categories.items[0].id");}
        else {
            category_id=responseJsonPath.getString("categories.items[0].parent_id");
        }
        Assert.assertEquals(response.statusCode(), 200);

    }
    @Test(priority = 3,dependsOnMethods = {"verifyGetCategoriesAndProductsForTheMerchant"},description = "Verify Get Products Within Category API",groups={"API_regression"})
    //@Test(priority = 2,dependsOnMethods = {"verifyMerchantSearch","verifyGetCategoriesAndProductsForTheMerchant"},description = "Verify Get Products Within Category API",groups={"API_regression"})
    public void verifyGetProductsWithinCategory() throws IOException {
        TestData testData = getProductsWithinCategoryApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_SPPayment();
        Response response = GetProductsWithinCategory.getProductsWithinCategoryAPI(testData,token,user_id,partner_id,merchant_id,category_id);
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        product_id=responseJsonPath.getInt("products[0].id");
        Assert.assertEquals(response.statusCode(), 200);

    }
    @Test(priority = 3,dependsOnMethods = {"verifyGetCategoriesAndProductsForTheMerchant"},description = "Verify Get Categories API",groups={"API_regression"})
    //@Test(priority = 2,dependsOnMethods = {"verifyMerchantSearch","verifyGetCategoriesAndProductsForTheMerchant"},description = "Verify Get Categories API",groups={"API_regression"})
    public void verifyGetCategories() throws IOException {
        TestData testData = getCategoriesApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_SPPayment();
        Response response = GetCategoriesAPI.getCategoriesAPI(testData,token,user_id,partner_id,merchant_id,category_id);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 4,dependsOnMethods = {"verifyGetProductsWithinCategory","verifyGetProductsWithinCategory"},description = "Verify Get Product API",groups={"API_regression"})
    //@Test(priority = 3,dependsOnMethods = {"verifyMerchantSearch","verifyGetCategoriesAndProductsForTheMerchant","verifyGetProductsWithinCategory"},description = "Verify Get Product API",groups={"API_regression"})
    public void verifyProduct() throws IOException {
        TestData testData = getProductApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_SPPayment();
        Response response = GetProductAPI.getProductAPI(testData,token,user_id,partner_id,merchant_id,category_id,product_id);
        Assert.assertEquals(response.statusCode(), 200);
    }
    @Test(priority = 7,description = "Verify Add Card API",groups={"API_regression"})
    //@Test(priority = 2,dependsOnMethods = {"verifyMerchantSearch","verifyGetCategoriesAndProductsForTheMerchant"},description = "Verify Add Card API",groups={"API_regression"})
    public void verifyAddCard()  {
        TestData testData = addCardAPIData();
        address_id_forCard= ProfileAPITest.address_id_forCard;
        Response response = AddCardAPI.addCardAPI(testData,token,user_id,partner_id,address_id_forCard);
        Assert.assertEquals(response.statusCode(), 201);
        card_id=response.path("id");
    }
    @Test(priority = 4,dependsOnMethods = {"verifyGetProductsWithinCategory"},description = "Verify Add To Cart API",groups={"API_regression"})
    //@Test(priority = 3,dependsOnMethods = {"verifyMerchantSearch","verifyGetCategoriesAndProductsForTheMerchant"},description = "Verify Add To Cart API",groups={"API_regression"})
    public void verifyAddToCart() throws IOException {
        TestData testData = AddtoCartApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_SPPayment();
        Response response = AddToCartAPI.addToCartAPI(testData,token,user_id,partner_id,merchant_id,product_id);
        Assert.assertEquals(response.statusCode(), 201);
    }
    @Test(priority = 5,dependsOnMethods = {"verifyGetCategoriesAndProductsForTheMerchant","verifyAddToCart"},description = "Verify Get Cart API",groups={"API_regression"})
    //@Test(priority = 4,dependsOnMethods = {"verifyMerchantSearch","verifyGetCategoriesAndProductsForTheMerchant","verifyAddToCart"},description = "Verify Get Cart API",groups={"API_regression"})
    public void verifyGetCart()  {
        TestData testData = getCartApiData();
        Response response = GetCartAPI.getCartAPI(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 200);
    }
    //for spgateway buy order flow
    @Test(priority = 8,dependsOnMethods = {"verifyGetProductsWithinCategory"},description = "Verify Option Call API",groups={"API_regression"})
    public void verifyOptionCallSP() throws IOException {
        TestData testData = OptionCallApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_SPPayment();
        Response response = OptionCallAPI.optionCallAPI(testData,token,user_id,partner_id,merchant_id,product_id);
        Assert.assertEquals(response.statusCode(), 200);
        option_id=response.path("id");
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        shipping_type=responseJsonPath.getString("supported_shipping_methods[0].execute.method_code");
        payment_type=responseJsonPath.getString("supported_payment_methods[0].type");
    }
    @Test(priority = 9,dependsOnMethods = {"verifyOptionCallSP"},description = "Verify Checkout Call API",groups={"API_regression"})
    //@Test(priority = 3,dependsOnMethods = {"verifyMerchantSearch","verifyGetCategoriesAndProductsForTheMerchant"},description = "Verify Checkout Call API",groups={"API_regression"})
    public void verifyCheckoutCallSP() throws IOException {
        TestData testData = CheckoutCallApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_SPPayment();
        address_id_forCard= ProfileAPITest.address_id_forCard;
        Response response = CheckoutCallApi.checkoutCallApi(testData,token,user_id,partner_id,merchant_id,option_id, shipping_type,payment_type,address_id_forCard);
        Assert.assertEquals(response.statusCode(), 200);
        checkout_id = response.path("id");
    }
    @Test(priority = 10,dependsOnMethods = {"verifyCheckoutCallSP"},description = "Verify Buy order API with Sp payment",groups={"API_regression"})
    public void verifyBuySP() throws IOException {
        TestData testData = BuyApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_SPPayment();
        public_key= ProfileAPITest.public_key;
        phone_id_forcard=ProfileAPITest.phone_id_forcard;
        Response response = BuySPAPI.buySPApi(testData,token,user_id,partner_id,merchant_id,checkout_id, card_id, payment_type, phone_id_forcard, public_key);
        Assert.assertEquals(response.statusCode(), 200);
        //order_id = response.path("order_id");

    }

    //for ACI buy order flow
    @Test(priority = 8,dependsOnMethods = {"verifyGetProductsWithinCategory"},description = "Verify Option Call API for ACI",groups={"API_regression"})
    public void verifyOptionCallACI() throws IOException {
        TestData testData = OptionCallACIApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_ACIPayment();
        Response response = OptionCallAPI.optionCallACIAPI(testData,token,user_id,partner_id,product_id);
        Assert.assertEquals(response.statusCode(), 200);
        option_id_ACI=response.path("id");
        JsonPath responseJsonPath = new JsonPath(response.getBody().asString());
        shipping_type_ACI=responseJsonPath.getString("supported_shipping_methods[0].execute.method_code");
        payment_type_ACI=responseJsonPath.getString("supported_payment_methods[0].type");
    }
    @Test(priority = 9,dependsOnMethods = {"verifyOptionCallACI"},description = "Verify Checkout Call API for ACI",groups={"API_regression"})
    public void verifyCheckoutCallACI()  {
        TestData testData = CheckoutCallACIApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_ACIPayment();
        address_id_forCard= ProfileAPITest.address_id_forCard;
        Response response = CheckoutCallApi.checkoutCallApi(testData,token,user_id,partner_id,merchant_id,option_id_ACI, shipping_type_ACI,payment_type_ACI,address_id_forCard);
        Assert.assertEquals(response.statusCode(), 200);
        checkout_id_ACI = response.path("id");
    }
/*    @Test(priority = 10,dependsOnMethods = {"verifyCheckoutCallACI"},description = "Verify Buy order API with ACI payment",groups={"API_regression"})
    public void verifyBuyACI()  {
        TestData testData = BuyACIApiData();
        TestData merchantData = getmerchantIDsForPaymentData();
        merchant_id= merchantData.getTestData(RCEData.class).getMerchant_id_ACIPayment();
        public_key= ProfileAPITest.public_key;
        phone_id_forcard=ProfileAPITest.phone_id_forcard;
        Response response = BuySPAPI.buyACIApi(testData,token,user_id,partner_id,merchant_id,checkout_id_ACI,card_id, payment_type_ACI, phone_id_forcard, public_key);
        Assert.assertEquals(response.statusCode(), 200);
        threeDSMethodData = response.path("data.iframe.params.threeDSMethodData");
        action= response.path("data.iframe.action");
        //order_id = response.path("order_id");
    }*/
    @Test(priority = 11,description = "Verify Get order by ID API ",groups={"API_regression"})
    public void verifyGetOrders()  {
        TestData testData = getOrdersApiData();
        Response response = GetOrdersAPI.getOrdersAPI(testData,token,user_id,partner_id);
        Assert.assertEquals(response.statusCode(), 200);

        order_id=response.jsonPath().getString("orders[0].order_id");
    }
    @Test(priority = 11,dependsOnMethods ={"verifyGetOrders"}, description = "Verify Get orders API ",groups={"API_regression"})
    public void verifyGetOrdersById()  {
        TestData testData = getOrderByIDApiData();
        Response response = GetOrderByID.getOrderByIdAPI(testData,token,user_id,partner_id, order_id);
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(priority = 11,dependsOnGroups = "AddressAPI",description = "Verify Update Card API",groups={"API_regression"})
    //@Test(priority = 2,dependsOnMethods = {"verifyMerchantSearch","verifyGetCategoriesAndProductsForTheMerchant"},dependsOnGroups = "AddressAPI",description = "Verify Update Card API",groups={"API_regression"})
    public void verifyUpdateCard()  {
        TestData testData = updateCardAPIData();
        address_id_forCard= ProfileAPITest.address_id_forCard;
        Response response = UpdateCard.updateCardAPI(testData,token,user_id,partner_id,address_id_forCard, card_id);
        Assert.assertEquals(response.statusCode(), 200);
        updated_card_id=response.path("id");
    }
    @Test(priority = 12,dependsOnGroups = "AddressAPI",description = "Verify Delete Card API",groups={"API_regression"})
    //@Test(priority = 2,dependsOnMethods = {"verifyMerchantSearch","verifyGetCategoriesAndProductsForTheMerchant"},dependsOnGroups = "AddressAPI",description = "Verify Delete Card API",groups={"API_regression"})
    public void verifyDeleteCard()  {
        TestData testData = deleteCardAPIData();
        address_id_forCard= ProfileAPITest.address_id_forCard;
        Response response = DeleteCard.deleteCardAPI(testData,token,user_id,partner_id,updated_card_id);
        Assert.assertEquals(response.statusCode(), 204);
    }
    @Test(priority = 9,description = "Verify wallet API", groups = {"API_regression"})
    public void verifyGetWallet() {
        TestData testData = getWalletApiData();
        Response response = GetWallet.getWalletAPI(testData, token, user_id, partner_id);
        Assert.assertEquals(response.statusCode(), 200);
    }

/*    @Test(priority = 11,description = "Verify ACI form for Buy order", groups = {"API_regression"})
    public void verifyACIformForBuyOrder(){
        TestData testData = ACIAPIForBuyOrderData();
        Response response=ACIFormAPI.aciFormAPIforBuyOrder(testData,action,threeDSMethodData);
        XmlPath htmlPath = new XmlPath(HTML, response.getBody().asString());
        String action = htmlPath.getString("html.body.form.@action");
        String threeDSMethodData = htmlPath.getString("html.body.form.input.@value");
    }*/
}