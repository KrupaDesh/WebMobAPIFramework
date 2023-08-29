package com.rezolve.api.RCE.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // This annotation is added to compare similar vlaues from API request and response(e.g.username)

public class RCEData {

    private String merchant_id_SPPayment;
    private String merchant_id_ACIPayment;

    private String getMerchantsListAPIPath;
    private Map<String ,String> getMerchantsListAPIheaders;

    private String getMerchantsAPIPath;
    private Map<String ,String> getMerchantsAPIheaders ;

    private String getCategoriesAndProductsForThemerchantAPIPath;
    private Map<String ,String> getCategoriesAndProductsForThemerchantAPIheaders ;

    private String getCategoriesAPIPath;
    private Map<String ,String> getCategoriesAPIheaders ;

    private String getProductsWithinCategoryAPIPath;
    private Map<String ,String> getProductsWithinCategoryAPIheaders;

    private String getProductAPIPath;
    private Map<String ,String> getProductAPIheaders;

    private String getProductByBarcodeAPIPath;
    private Map<String ,String> getProductByBarcodeAPIheaders ;

    private String getCartAPIPath;
    private Map<String ,String> getCartAPIheaders ;

    private String getWalletAPIPath;
    private Map<String ,String> getWalletAPIheaders ;

    private String getOrdersAPIPath;
    private Map<String ,String> getOrdersAPIheaders ;

    private String getOrderByIDAPIPath;
    private Map<String ,String> getOrderByIDAPIheaders ;

    private String callbackAPIPath;
    private Map<String ,String> callbackAPIheaders ;

    private String addCardAPIPath;
    private Map<String ,String> addCardAPIheaders ;
    private Map<String ,Object> addCardAPIPayload ;

    private String updateCardAPIPath;
    private Map<String ,String> updateCardAPIheaders ;
    private Map<String ,Object> updateCardAPIPayload ;

    private String deleteCardAPIPath;
    private Map<String ,String> deleteCardAPIheaders ;


    private String AddtoCartAPIPath;
    private Map<String ,String> AddtoCartAPIheaders ;
    private Map<String ,Object> AddtoCartAPIPayload ;

    private String optionCallAPIPath;
    private Map<String ,String> optionCallAPIheaders ;
    private Map<String ,Object> optionCallAPIPayload ;

    private String CheckoutCallAPIPath;
    private Map<String ,String> CheckoutCallAPIheaders ;
    private Map<String ,Object> CheckoutCallAPIPayload ;

    private String BuyAPIPath;
    private Map<String ,String> BuyAPIheaders ;
    private Map<String ,Object> BuyAPIPayload ;

    private String optionCallACIAPIPath;
    private Map<String ,String> optionCallACIAPIheaders ;
    private String OptionCallACIMerchantID;
    private Map<String ,Object> optionCallACIAPIPayload ;

    private String CheckoutCallACIAPIPath;
    private Map<String ,String> CheckoutCallACIAPIheaders ;
    private String CheckoutCallACIMerchantID;
    private Map<String ,Object> CheckoutCallACIAPIPayload ;

    private String BuyACIAPIPath;
    private Map<String ,String> BuyACIAPIheaders ;
    private String BuyACIMerchantID;
    private Map<String ,Object> BuyACIAPIPayload ;

    private String GetOrdersAPIPath;
    private Map<String ,String> GetOrdersAPIheaders ;

    private Map<String ,String> ACIFormForBuyOrderPayload ;

}
