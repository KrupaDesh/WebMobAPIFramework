package com.rezolve.web.icv2.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PayPalDataICv2 {

     private String email;
     private String password;


}
