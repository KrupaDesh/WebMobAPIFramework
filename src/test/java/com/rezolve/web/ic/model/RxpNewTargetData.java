package com.rezolve.web.ic.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RxpNewTargetData {

     private String yourReference;
     private String promotionalTitle;
     private String promotionalSubTitle;


}
