package com.rezolve.api.RCE.model;

import com.rezolve.api.Core.model.CommonPrams;
import engine.TestData;

public class TestDataArrangerAPI {

    /*public static String platformName = new BasePage().getPlatformName().toLowerCase();
    public static String browserName = new BasePage().getBrowserName().toLowerCase();*/

    public static TestData getmerchantIDsForPaymentData()
    {
        return new TestData().addTestData("merchantIDsForPayment", RCEData.class);
    }
    public static TestData getMerchantListApiData()
    {
        return new TestData().addTestData("getMerchantsListAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getMerchantApiData()
    {
        return new TestData().addTestData("getMerchantsAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getCategoriesAndProductsForThemerchantApiData()
    {
        return new TestData().addTestData("getCategoriesAndProductsForThemerchantAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getCategoriesApiData()
    {
        return new TestData().addTestData("getCategoriesAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getProductsWithinCategoryApiData()
    {
        return new TestData().addTestData("getProductsWithinCategoryAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getProductApiData()
    {
        return new TestData().addTestData("getProductAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getCartApiData()
    {
        return new TestData().addTestData("getCartAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getWalletApiData()
    {
        return new TestData().addTestData("getWalletAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData callbackApiData()
    {
        return new TestData().addTestData("callbackAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData addCardAPIData()
    {
        return new TestData().addTestData("addCardAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    public static TestData updateCardAPIData()
    {
        return new TestData().addTestData("updateCardAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData deleteCardAPIData()
    {
        return new TestData().addTestData("deleteCardAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData OptionCallApiData()
    {
        return new TestData().addTestData("optionCallAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData CheckoutCallApiData()
    {
        return new TestData().addTestData("CheckoutCallAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData BuyApiData()
    {
        return new TestData().addTestData("BuyAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    //for ACI need different data
    public static TestData OptionCallACIApiData()
    {
        return new TestData().addTestData("optionCallACIAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData CheckoutCallACIApiData()
    {
        return new TestData().addTestData("CheckoutCallAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData BuyACIApiData()
    {
        return new TestData().addTestData("BuyAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getOrdersApiData()
    {
        return new TestData().addTestData("getOrdersAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getOrderByIDApiData()
    {
        return new TestData().addTestData("getOrderByIDAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData AddtoCartApiData()
    {
        return new TestData().addTestData("AddtoCartAPI", RCEData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData ACIAPIForBuyOrderData()
    {
        return new TestData().addTestData("ACIFormForBuyOrder", RCEData.class);
    }


    //***********Negative test data**************//


    public static TestData getMerchantListApiWithIncorrectData()
    {
        return new TestData().addTestData("getMerchantsListAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getMerchantApiWithIncorrectData()
    {
        return new TestData().addTestData("getMerchantsAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getCategoriesAndProductsForThemerchantApiWithIncorrectData()
    {
        return new TestData().addTestData("getCategoriesAndProductsForThemerchantAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getProductsWithinCategoryApiWithIncorrectData()
    {
        return new TestData().addTestData("getProductsWithinCategoryAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getCategoriesApiWithIncorrectData()
    {
        return new TestData().addTestData("getCategoriesAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    public static TestData getProductApiWithIncorrectData()
    {
        return new TestData().addTestData("getProductAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getCartAPIWithIncorrectData()
    {
        return new TestData().addTestData("getCartAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getWalletApiWithIncorrectData()
    {
        return new TestData().addTestData("getWalletAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData callbackApiWithIncorrectData()
    {
        return new TestData().addTestData("callbackAPI", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getOrdersApiWithIncorrectData()
    {
        return new TestData().addTestData("getOrdersAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData getOrderByIDAPIWithIncorrectData()
    {
        return new TestData().addTestData("getOrderByIDAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    ///Pending
    public static TestData addCardAPIWithIncorrectData()
    {
        return new TestData().addTestData("addCardAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    public static TestData updateCardAPIWithIncorrectData()
    {
        return new TestData().addTestData("updateCardAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData deleteCardAPIWithIncorrectData()
    {
        return new TestData().addTestData("deleteCardAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData OptionCallApiWithIncorrectData()
    {
        return new TestData().addTestData("optionCallAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData CheckoutCallApiWithIncorrectData()
    {
        return new TestData().addTestData("CheckoutCallAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
    public static TestData BuyApiWithIncorrectData()
    {
        return new TestData().addTestData("BuyAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }

    public static TestData AddtoCartApiWithIncorrectData()
    {
        return new TestData().addTestData("AddtoCartAPIWithIncorrectData", RCENegativeData.class)
                .addTestData("endpoint", CommonPrams.class);
    }
}
