package com.rezolve.web.ic.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MerchantData {

     private String merchantName;
     private String phoneNumber;
     private String website;


   }
