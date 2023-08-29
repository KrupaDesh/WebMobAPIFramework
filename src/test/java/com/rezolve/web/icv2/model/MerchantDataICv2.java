package com.rezolve.web.icv2.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class MerchantDataICv2 {

     private String merchantName;
     private String phoneNumber;
     private String website;


   }
