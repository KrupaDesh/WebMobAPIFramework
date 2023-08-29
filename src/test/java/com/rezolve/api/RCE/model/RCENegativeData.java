package com.rezolve.api.RCE.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // This annotation is added to compare similar vlaues from API request and response(e.g.username)

public class RCENegativeData {

    private String getMerchantsListAPIWithIncorrectDataPath;
    private Map<String ,String> getMerchantsListAPIWithIncorrectDataheaders;
    private Map<String ,Object> getMerchantsListAPIWithIncorrectHeaderErrorResponse ;

    private String getMerchantsAPIWithIncorrectDataPath;
    private Map<String ,String> getMerchantsAPIWithIncorrectDataheaders ;
    private Map<String ,Object> getMerchantsAPIWithNullMerchantIDErrorResponse ;
    private Map<String ,Object> getMerchantsAPIWithIncorrectHeadersErrorResponse ;

    private String getCategoriesAndProductsForThemerchantAPIWithIncorrectDataPath;
    private Map<String ,String> getCategoriesAndProductsForThemerchantAPIWithIncorrectDataheaders ;
    private Map<String ,Object> getCategoriesAndProductsForThemerchantAPINullMerchantIDErrorResponse ;
    private Map<String ,Object> getCategoriesAndProductsForThemerchantAPIWithIncorrectHeadersErrorResponse ;

    private String getCategoriesAPIWithIncorrectDataPath;
    private Map<String ,String> getCategoriesAPIWithIncorrectDataheaders ;
    private Map<String ,Object> getCategoriesAPINullMerchantIDErrorResponse ;
    private Map<String ,Object> getCategoriesAPINullCategoryIDErrorResponse ;
    private Map<String ,Object> getCategoriesAPIWithIncorrectHeadersErrorResponse ;

    private String getProductsWithinCategoryAPIWithIncorrectDataPath;
    private Map<String ,String> getProductsWithinCategoryAPIWithIncorrectDataheaders;
    private Map<String ,Object> getProductsWithinCategoryAPINullMerchantIDErrorResponse ;
    private Map<String ,Object> getProductsWithinCategoryAPIWithIncorrectHeadersErrorResponse ;

    private String getProductAPIWithIncorrectDataPath;
    private Map<String ,String> getProductAPIWithIncorrectDataheaders;
    private Map<String ,Object> getProductAPINullMerchantIDErrorResponse ;
    private Map<String ,Object> getProductAPINullCategoryIDErrorResponse ;
    private Map<String ,Object> getProductAPIWithIncorrectHeadersErrorResponse ;

    private String getProductByBarcodeAPIWithIncorrectDataPath;
    private Map<String ,String> getProductByBarcodeAPIWithIncorrectDataheaders ;

    private String getCartAPIWithIncorrectDataPath;
    private Map<String ,String> getCartAPIWithIncorrectDataheaders ;
    private Map<String ,Object> getCartAPIWithIncorrectHeadersErrorResponse ;


    private String getWalletAPIWithIncorrectDataPath;
    private Map<String ,String> getWalletAPIWithIncorrectDataheaders ;
    private Map<String ,Object> getWalletAPIWithIncorrectHeadersErrorResponse ;

    private String getOrdersAPIWithIncorrectDataPath;
    private Map<String ,String> getOrdersAPIWithIncorrectDataheaders ;
    private Map<String ,Object> getOrdersAPIWithIncorrectHeadersErrorResponse ;
    private Map<String ,Object> getOrdersAPIWithIncorrectDateErrorResponse ;

    private String getOrderByIDAPIWithIncorrectDataPath;
    private Map<String ,String> getOrderByIDAPIWithIncorrectDataheaders ;
    private Map<String ,Object> getOrderByIDAPIWithIncorrecHeadersErrorResponse ;
    private Map<String ,Object> getOrderByIDAPIWithIncorrectOrederIDErrorResponse ;

    private String callbackAPIPath;
    private Map<String ,String> callbackAPIheaders ;

    private String addCardAPIWithIncorrectDataPath;
    private Map<String ,String> addCardAPIWithIncorrectDataheaders ;
    private Map<String ,Object> addCardAPIWithIncorrectDataPayload;
    private Map<String ,Object> addCardAPIWithEmptyDataErrorResponse;
    private Map<String ,Object> addCardAPIWithNullDataErrorResponse;
    private Map<String ,Object> addCardAPIWithIncorrectHeadersErrorResponse;

    private String updateCardAPIWithIncorrectDataPath;
    private Map<String ,String> updateCardAPIWithIncorrectDataheaders;
    private String updateCardAPIWithIncorrectDataCardID;
    private Map<String ,Object> updateCardAPIWithIncorrectDataPayload;
    private Map<String ,Object> updateCardAPIWithEmptyDataErrorResponse;
    private Map<String ,Object> updateCardAPIWithNullDataErrorResponse;
    private Map<String ,Object> updateCardAPIWithIncorrectHeadersErrorResponse;

    private String deleteCardAPIWithIncorrectDataPath;
    private String deleteCardAPIDeletedCardID;
    private Map<String ,String> deleteCardAPIWithIncorrectDataheaders ;
    private Map<String ,Object> deleteCardAPIWithIncorrectHeadersErrorResponse;
    private Map<String ,Object> deleteCardAPIWithDeletedCardIDErrorResponse;

    private String AddtoCartAPIWithIncorrectDataPath;
    private Map<String ,String> AddtoCartAPIWithIncorrectDataheaders ;
    private Map<String ,Object> AddtoCartAPIWithIncorrectDataPayload ;
    private Map<String ,Object> AddtoCartAPIWithIncorrectHeadersErrorResponse ;
    private Map<String ,Object> AddtoCartAPIWithEmptyDataErrorResponse ;
    private Map<String ,Object> AddtoCartAPIWithNullDataErrorResponse ;

    private String optionCallAPIWithIncorrectDataPath;
    private Map<String ,String> optionCallAPIWithIncorrectDataheaders ;
    private Map<String ,Object> optionCallAPIWithIncorrectDataPayload ;
    private Map<String ,Object> optionCallAPIWithIncorrectHeadersErrorResponse ;
    private Map<String ,Object> optionCallAPIWithEmptyDataErrorResponse ;
    private Map<String ,Object> optionCallAPIWithNullDataErrorResponse ;
    private Map<String ,Object> optionCallAPIWithMaxQtyErrorResponse ;
    private Map<String ,Object> optionCallAPIWithInvalidIDErrorResponse;

    private String CheckoutCallAPIWithIncorrectDataPath;
    private Map<String ,String> CheckoutCallAPIWithIncorrectDataheaders ;
    private Map<String ,Object> CheckoutCallAPIWithIncorrectDataPayload ;
    private String CheckoutCallAPIWithIncorrectDataOptionID;
    private Map<String ,Object> CheckoutCallAPIWithIncorrectHeadersErrorResponse;
    private Map<String ,Object> CheckoutCallAPIWithInvalidOptionIDErrorResponse ;
    private Map<String ,Object> CheckoutCallAPIWithEmptyDataErrorResponse ;
    private Map<String ,Object> CheckoutCallAPIWithNullDataErrorResponse ;

    private String BuyAPIWithIncorrectDataPath;
    private Map<String ,String> BuyAPIWithIncorrectDataheaders ;
    private Map<String ,Object> BuyAPIWithIncorrectDataPayload ;
    private String BuyAPIWithIncorrectDataCheckoutID;
    private Map<String ,Object> BuyAPIWithIncorrectHeadersErrorResponse ;
    private Map<String ,Object> BuyAPIWithInvalidOptionIDErrorResponse ;
    private Map<String ,Object> BuyAPIWithEmptyDataErrorResponse ;
    private Map<String ,Object> BuyAPIWithInvalidPaymentMethodErrorResponse ;




}
