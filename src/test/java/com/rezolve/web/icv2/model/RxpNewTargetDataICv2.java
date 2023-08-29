package com.rezolve.web.icv2.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RxpNewTargetDataICv2 {

     private String yourReference;
     private String promotionalTitle;
     private String promotionalSubTitle;


}
