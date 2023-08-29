package com.rezolve.web.ic.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EnvData {
     private String ruaUrl;
     private String ruaAccess;
     private String env;

   }
