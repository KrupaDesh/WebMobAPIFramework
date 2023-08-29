package com.rezolve.api.SmartTrigger.model;
import lombok.*;
import java.util.Map;
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SmartTriggersData {

    private String checkInAPIPath;
    private Map<String ,String> checkInAPIheaders;
    private Map<String,Object> checkInAPIPayload;


    private String trackingAPIPath;
    private Map<String ,String> trackingAPIheaders;
    private Map<String,Object> trackingAPIPayload;

    private String getTagsAPIPath;
    private Map<String ,String> getTagsAPIheaders;

    private String updateTagsAPIPath;
    private Map<String ,String> updateTagsAPIheaders;
    private Map<String,Object> updateTagsAPIPayload;

    private String myAreaAPIPath;
    private Map<String ,String> myAreaAPIheaders;

    private String addEventAPIPath;
    private Map<String ,String> addEventAPIheaders;
    private Map<String,Object> addEventAPIPayload;

    private String addBulkEventAPIPath;
    private Map<String ,String> addBulkEventAPIheaders;
    private Map<String,Object> addBulkEventAPIPayload;


}
