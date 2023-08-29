package com.rezolve.web.icv2.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserAccountDataICv2 {

     private String email;
     private String password;
     private String phoneNumber;
     private String countryCode;
     private String address;
     private String errorMessage;
     private String invalidOTP;


}
