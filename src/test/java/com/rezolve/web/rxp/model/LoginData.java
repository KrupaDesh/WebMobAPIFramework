package com.rezolve.web.rxp.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LoginData {

     private String userName;
     private String password;


}
