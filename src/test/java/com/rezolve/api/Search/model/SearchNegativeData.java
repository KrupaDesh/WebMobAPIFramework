package com.rezolve.api.Search.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // This annotation is added to compare similar vlaues from API request and response(e.g.username)

public class SearchNegativeData {

    private String merchantSearchAPIWithIncorrectDataPath;
    private Map<String ,String> merchantSearchAPIWithIncorrectDataheaders;
    private Map<String,Object> merchantSearchAPIWithIncorrectDataPayload;
    private Map<String,Object> merchantSearchAPIWithRemoveMadatoryParamErrorResponse;
    private Map<String,Object> merchantSearchAPIWithEmptyDataForMandateParamErrorResponse;
    private Map<String,Object> merchantSearchAPIWithIncorrectQueryParamErrorResponse;
    private Map<String,Object> merchantSearchAPIWithIncorrectDataTypeErrorResponse;

    private String productSearchAPIWithIncorrectDataPath ;
    private Map<String,String> productSearchAPIWithIncorrectDataheaders;
    private Map<String,Object> productSearchAPIWithIncorrectDataPayload;
    private Map<String,Object> productSearchAPIWithRemoveMadatoryParamErrorResponse;
    private Map<String,Object> productSearchAPIWithEmptyDataForMandateParamErrorResponse;
    private Map<String,Object> productSearchAPIWithIncorrectQueryParamErrorResponse;
    private Map<String,Object> productSearchAPIWithIncorrectDataTypeErrorResponse;

}
