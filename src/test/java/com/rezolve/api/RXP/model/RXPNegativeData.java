package com.rezolve.api.RXP.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // This annotation is added to compare similar vlaues from API request and response(e.g.username)

public class RXPNegativeData {

    private String OAuthAPIWithIncorrectDataPath;
    private Map<String ,String> OAuthAPIWithIncorrectDataheaders;
    private Map<String,Object> OAuthAPIWithIncorrectDataPayload;
    private Map<String,Object> OAuthAPIWithoutAuthErrorResponse;
    private Map<String,Object> OAuthAPIWithIncorrectDataErrorResponse;

    private String GetGeoEngagementsAPIWithIncorrectDataPath;
    private Map<String ,String> GetGeoEngagementsAPIWithIncorrectDataheaders ;
    private Map<String,Object> GetGeoEngagementsAPIWithIncorrectDataQueryParam;
    private Map<String,Object> GetGeoEngagementsAPIMissingQueryParamErrorResponse;

    private String GetEngagementsByIdAPIWithIncorrectDataPath;
    private Map<String ,String> GetEngagementsByIdAPIWithIncorrectDataheaders ;
    private Map<String,Object> GetEngagementsByIdAPIWithIncorrectDataPayload;
    private Map<String,Object> GetEngagementsByIdAPIWithNullEngIDErrorResponse;

    private String GetActByIdAPIWithIncorrectDataPath;
    private Map<String ,String> GetActByIdAPIWithIncorrectDataheaders ;
    private String GetActByIdAPIWithIncorrectDataAct_ID;
    private Map<String,Object> GetActByIdAPINullActIDErrorResponse;

    private String SearchEngagementAPIWithIncorrectDataPath;
    private Map<String ,String> SearchEngagementAPIWithIncorrectDataheaders ;
    private Map<String,Object> SearchEngagementAPIWithIncorrectDataPayload;
    private Map<String,Object> SearchEngagementAPIWithIncorrectDataErrorResponse;
}
