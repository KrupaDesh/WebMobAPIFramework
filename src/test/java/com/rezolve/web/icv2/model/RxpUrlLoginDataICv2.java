package com.rezolve.web.icv2.model;

import lombok.*;


@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RxpUrlLoginDataICv2 {
    private String url;
    private String email;
    private String password;
}





