package com.rezolve.web.icv2.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EnvDataICv2 {
     private String ruaUrl;
     private String ruaAccess;
     private String env;

   }
