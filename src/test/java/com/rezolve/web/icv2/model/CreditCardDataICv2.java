package com.rezolve.web.icv2.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardDataICv2 {

     private String nameOnCard;
     private String cardNumber;
     private String type;
     private String expires;
     private String cvv;
     private String lastFourDigitOfCard;

   }
