package com.rezolve.web.ic.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class AddressData {

     private String country;
     private String addressLine1;
     private String addressLine2;
     private String city;
     private String state;
     private String zip;
     private String nickName;

   }
