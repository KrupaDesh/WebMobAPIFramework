package com.rezolve.web.ic.model;

import lombok.*;


@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class RxpUrlLoginData {
    private String url;
    private String email;
    private String password;
}





