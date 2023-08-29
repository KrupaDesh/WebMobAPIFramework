package com.rezolve.api;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class APIBaseTestData {
    private String baseloginPath;
    private Map<String ,String> baseloginApiheaders;
    private Map<String,Object> baseloginApiPayload;
}
