package com.rezolve.web.ic.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountData {

     private String email;
     private String password;
     private String phoneNumber;
     private String countryCode;
     private String address;


}
