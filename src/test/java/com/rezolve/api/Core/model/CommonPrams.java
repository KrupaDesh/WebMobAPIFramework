package com.rezolve.api.Core.model;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CommonPrams {
    private String ruaHost;
    private String coreHost;
    private String bitplace_host;
    private String oauth_host;
    private String engagament_host;
}
