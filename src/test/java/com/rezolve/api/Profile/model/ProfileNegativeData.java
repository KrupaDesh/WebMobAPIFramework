package com.rezolve.api.Profile.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // This annotation is added to compare similar vlaues from API request and response(e.g.username)
public class ProfileNegativeData {

        private String getPublicKeyAPIWithIncorrectDataPath;
        private Map<String ,String> getPublicKeyAPIWithIncorrectDataheaders;
        private Map<String ,Object> getPublicKeyAPIErrorResponseWithIncorrectHeaders;

        private String addPhonebookAPIWithIncorrectDataPath;
        private Map<String ,String> addPhonebookAPIWithIncorrectDataheaders;
        private Map<String,Object> addPhonebookAPIWithIncorrectDataPayload;
        private Map<String,Object> addPhonebookAPIErrorResponseWithIncorrectHeaders;
        private Map<String,Object> addPhonebookAPIErrorResponseWithIncorrectData;

        private String getPhonebookAPIWithIncorrectDataPath;
        private Map<String ,String> getPhonebookAPIWithIncorrectDataheaders;
        private Map<String,Object> getPhonebookAPIErrorResponseWithIncorrectHeaders;

        private String addAddressAPIWithIncorrectDataPath;
        private Map<String ,String> addAddressAPIWithIncorrectDataheaders;
        private Map<String,Object> addAddressAPIWithIncorrectDataPayload;
        private Map<String,Object> addAddressAPIErrorResponseWithIncorrectPhone;
        private Map<String,Object> addAddressAPIErrorResponseWithIncorrectHeader;

        private String getAddressAPIWithIncorrectDataPath;
        private Map<String ,String> getAddressAPIWithIncorrectDataheaders;
        private Map<String,Object> getAddressAPIErrorResponseWithIncorrectData;

        private String delAddressByIDAPIWithIncorrectDataPath;
        private Map<String ,String> delAddressByIDAPIWithIncorrectDataheaders;
        private Map<String,Object> delAddressByIDAPIErrorResponseWithIncorrectHeader;
        private String delAddressByIDAPIWithIncorrectDataAddress;
        private Map<String,Object> delAddressByIDAPIErrorResponseWithIncorrectData;

        private String updatePhonebookAPIWithIncorrectDataPath;
        private Map<String ,String> updatePhonebookAPIWithIncorrectDataheaders;
        private String updatePhonebookAPIWithIncorrectDataPhoneId;
        private Map<String,Object> updatePhonebookAPIWithIncorrectDataPayload;
        private Map<String,Object> updatePhonebookAPIErrorResponseWithIncorrectHeaders;
        private Map<String,Object> updatePhonebookAPIErrorResponseWithIncorrectData;

        private String delPhonebookAPIWithIncorrectDataPath;
        private Map<String ,String> delPhonebookAPIWithIncorrectDataheaders;
        private String delPhonebookAPIWithIncorrectDataPhoneId;
        private Map<String,Object> delPhonebookAPIErrorResponseWithIncorrectData;
        private Map<String,Object> delPhonebookAPIErrorResponseWithIncorrectHeaders;


        private String updateProfileAPIWithIncorrectDataPath;
        private Map<String ,String> updateProfileAPIWithIncorrectDataheaders;
        private Map<String,Object> updateProfileAPIWithIncorrectDataPayload;
        private Map<String,Object> updateProfileAPIErrorResponseWithIncorrectData;

        private String getProfileAPIWithIncorrectDataPath;
        private Map<String ,String> getProfileAPIWithIncorrectDataheaders;
        private Map<String,Object> getProfileAPIErrorResponseWithIncorrectHeaders;


}
