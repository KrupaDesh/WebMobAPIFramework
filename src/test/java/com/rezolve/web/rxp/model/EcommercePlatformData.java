package com.rezolve.web.rxp.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EcommercePlatformData {

     private String bigCommerce;
     private String shopify;
     private String salesForceCommerceCloud;
     private String name;
     private String storeURL;
     private String clientID;
     private String accessToken;
     private String context;
     private String nameForShopify;
     private String storeURLForShopify;
     private String accessTokenForShopify;


}
