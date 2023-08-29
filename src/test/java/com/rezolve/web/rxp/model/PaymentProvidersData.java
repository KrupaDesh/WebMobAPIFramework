package com.rezolve.web.rxp.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PaymentProvidersData {

     private String paypal;
     private String computop;
     private String bsPayone;
     private String elavon;
     private String sixWorldline;
     private String worldline;


}
