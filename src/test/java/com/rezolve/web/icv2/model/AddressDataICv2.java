package com.rezolve.web.icv2.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AddressDataICv2 {

     private String country;
     private String addressLine1;
     private String addressLine2;
     private String city;
     private String state;
     private String zip;
     private String nickName;

   }
