package com.rezolve.web.brain.model;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginData {

        private String email;
        private String password;

}
