package com.rezolve.api.Core.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CoreNegativeData {
    private String loginAPIWithIncorrectDataPath;
    private Map<String ,String> loginAPIWithIncorrectDataHeaders;
    private Map<String,Object> loginAPIWithIncorrectDataPayload;
    private Map<String,Object> loginAPIErrorRespone;
    private Map<String,Object> loginAPIErrorResponseWithIncorrectHeaders;

    private String registerV2WithIncorrectDataApiPath;
    private Map<String ,String> registerV2WithIncorrectDataApiheaders;
    private Map<String,Object> registerV2WithIncorrectDataApiPayload;
    private Map<String,Object> registerV2ErrorResposnse;
    private Map<String,Object> registerV2ErrorResposnseWithIncorrectHeaders;

    private String confirmNumberApiWithIncorrectDataPath;
    private Map<String ,String> confirmNumberApiWithIncorrectDataHeaders;

    private String guestRegisterApiWithIncorrectDataPath;
    private Map<String ,String> guestRegisterApiWithIncorrectDataHeaders;
    private Map<String,Object> guestRegisterErrorResponseWithIncorrectData;

    private String guestLoginApiWithIncorrectDataPath;
    private Map<String ,String> guestLoginApiWithIncorrectDataHeaders;
    private Map<String,Object> guestLoginApiWithIncorrectDataPayload;
    private Map<String,Object> guestLoginApiErrorResponseWithIncorrectHeader;

    private String forgotPasswordApiWithIncorrectDataPath;
    private Map<String ,String> forgotPasswordApiWithIncorrectDataHeaders;
    private Map<String,Object> forgotPasswordApiWithIncorrectDataPayload;
    private Map<String,Object> forgotPasswordApiErrorResponseWithIncorrectHeader;
    private Map<String,Object> forgotPasswordApiErrorResponseWithIncorrectData;

    private String updatePasswordApiWithIncorrectDataPath;
    private Map<String ,String> updatePasswordApiWithIncorrectDataHeaders;
    private Map<String,Object> updatePasswordApiWithIncorrectDataPayload;
    private Map<String,Object> updatePasswordApiErrorResponseWithIncorrectData;
    private Map<String,Object> updatePasswordApiErrorResponseWithIncorrectHeader;
}
