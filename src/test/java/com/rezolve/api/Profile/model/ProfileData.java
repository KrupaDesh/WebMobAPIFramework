package com.rezolve.api.Profile.model;

import lombok.*;
import java.util.Map;
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // This annotation is added to compare similar vlaues from API request and response(e.g.username)
public class ProfileData {

        private String getPublicKeyAPIPath;
        private Map<String ,String> getPublicKeyAPIheaders;

        private String addPhonebookAPIPath;
        private Map<String ,String> addPhonebookAPIheaders;
        private Map<String,Object> addPhonebookAPIPayload;

        private String getPhonebookAPIPath;
        private Map<String ,String> getPhonebookAPIheaders;

        private String getAddressAPIPath;
        private Map<String ,String> getAddressAPIheaders;

        private String addAddressAPIPath;
        private Map<String ,String> addAddressAPIheaders;
        private Map<String,Object> addAddressAPIPayload;

        private String delAddressByIDAPIPath;
        private Map<String ,String> delAddressByIDAPIheaders;

        private String updatePhonebookAPIPath;
        private Map<String ,String> updatePhonebookAPIheaders;
        private Map<String,Object> updatePhonebookAPIPayload;

        private String delPhonebookAPIPath;
        private Map<String ,String> delPhonebookAPIheaders;


        private String updateProfileAPIPath;
        private Map<String ,String> updateProfileAPIheaders;
        private Map<String,Object> updateProfileAPIPayload;

        private String getProfileAPIPath;
        private Map<String ,String> getProfileAPIheaders;


}
