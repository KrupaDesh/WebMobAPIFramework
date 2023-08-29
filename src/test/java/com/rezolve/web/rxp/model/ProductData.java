package com.rezolve.web.rxp.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductData {

     private String productName;
     private String brand;


}
