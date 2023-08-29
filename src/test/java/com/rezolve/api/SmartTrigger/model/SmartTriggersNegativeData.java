package com.rezolve.api.SmartTrigger.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SmartTriggersNegativeData {

    private String checkInAPIWithIncorrectDataPath;
    private Map<String ,String> checkInAPIWithIncorrectDataheaders;
    private Map<String,Object> checkInAPIWithIncorrectDataPayload;
    private Map<String,Object> checkInAPIWithoutAuthErrorResponse;
    private Map<String,Object> checkInAPIInvalidAuthErrorResponse;
    private Map<String,Object> checkInAPIWithEmptyDataErrorResponse;

    private String trackingAPIWithIncorrectDataPath;
    private Map<String ,String> trackingAPIWithIncorrectDataheaders;
    private Map<String,Object> trackingAPIWithIncorrectDataPayload;
    private Map<String,Object> trackingAPIWithoutAuthErrorResponse;
    private Map<String,Object>trackingAPIWithEmptyDataErrorResponse;

    private String getTagsAPIWithIncorrectDataPath;
    private Map<String ,String> getTagsAPIWithIncorrectDataheaders;
    private Map<String,Object> getTagsAPIWithoutAuthErrorResponse;
    private Map<String,Object> getTagsAPIWithInvalidAuthErrorResponse;

    private String updateTagsAPIWithIncorrectDataPath;
    private Map<String ,String> updateTagsAPIWithIncorrectDataheaders;
    private Map<String,Object> updateTagsAPIWithIncorrectDataPayload;
    private Map<String,Object> updateTagsAPIWithEmptyDataErrorResponse;

    private String myAreaAPIWithIncorrectDataPath;
    private Map<String ,String> myAreaAPIWithIncorrectDataheaders;
    private Map<String,Object> myAreaAPIWithoutQueryParamErrorResponse;

    private String addEventAPIWithIncorrectDataPath;
    private Map<String ,String> addEventAPIWithIncorrectDataheaders;
    private Map<String,Object> addEventAPIWithIncorrectDataPayload;
    private Map<String,Object> addEventAPIWithNullDataErrorResponse;
    private Map<String,Object> addEventAPIWithEmptyBodyErrorResponse;

    private String addBulkEventAPIWithIncorrectDataPath;
    private Map<String ,String> addBulkEventAPIWithIncorrectDataheaders;
    private Map<String,Object> addBulkEventAPIWithIncorrectDataPayload;
    private Map<String,Object> addBulkEventAPIWithNullDataErrorResponse;
    private Map<String,Object> addBulkEventAPIWithEmptyBodyErrorResponse;
}
