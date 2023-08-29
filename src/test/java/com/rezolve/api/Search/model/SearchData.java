package com.rezolve.api.Search.model;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // This annotation is added to compare similar vlaues from API request and response(e.g.username)

public class SearchData {

    private String merchantSearchAPIPath;
    private Map<String ,String> merchantSearchAPIheaders;
    private Map<String,Object> merchantSearchAPIPayload;

    private String productSearchAPIPath;
    private Map<String ,String> productSearchAPIheaders ;
    private Map<String,Object> productSearchAPIPayload;
}
