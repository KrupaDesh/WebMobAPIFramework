package com.rezolve.web.ic.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardData {

     private String nameOnCard;
     private String cardNumber;
     private String type;
     private String expires;
     private String cvv;

   }
