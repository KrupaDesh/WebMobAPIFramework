package com.rezolve.api.RXP.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // This annotation is added to compare similar vlaues from API request and response(e.g.username)

public class RXPData {

    private String OAuthAPIPath;
    private Map<String ,String> OAuthAPIheaders;
    private Map<String,Object> OAuthAPIPayload;

    private String GetGeoEngagementsAPIPath;
    private Map<String ,String> GetGeoEngagementsAPIheaders ;
    private Map<String,Object> GetGeoEngagementsAPIQueryParam;

    private String GetEngagementsByIdAPIPath;
    private Map<String ,String> GetEngagementsByIdAPIheaders ;
    private Map<String,Object> GetEngagementsByIdAPIPayload;

    private String GetActByIdAPIPath;
    private Map<String ,String> GetActByIdAPIheaders ;
    private String GetActByIdAPIAct_ID;

    private String SearchEngagementAPIPath;
    private Map<String ,String> SearchEngagementAPIheaders ;
    private Map<String,Object> SearchEngagementAPIPayload;
}
