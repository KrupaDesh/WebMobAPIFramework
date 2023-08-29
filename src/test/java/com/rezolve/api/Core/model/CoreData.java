package com.rezolve.api.Core.model;


import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // This annotation is added to compare similar vlaues from API request and response(e.g.username)
public class CoreData {

     //For both positive and negative cases has same tags except main tag from json file

     private String loginPath;
     private Map<String ,String> loginApiheaders;
     private Map<String,Object> loginApiPayload;

     private String registerV2Path;
     private Map<String ,String> registerV2Apiheaders;
     private Map<String,Object> registerV2ApiPayload;


     private String confirmNumberPath;
     private Map<String ,String> confirmNumberApiHeaders;

     private String guestRegisterPath;
     private Map<String ,String> guestRegisterHeaders;

     private String guestLoginPath;
     private Map<String ,String> guestLoginHeaders;
     private Map<String,Object> guestLoginPayload;

     private String forgotPasswordPath;
     private Map<String ,String> forgotPasswordHeaders;
     private Map<String,Object> forgotPasswordPayload;

     private String updatePasswordPath;
     private Map<String ,String> updatePasswordHeaders;
     private Map<String,Object> updatePasswordPayload;

     private String logoutApiPath;
     private Map<String ,String> logoutApiHeaders;

}
