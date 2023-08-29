package com.rezolve.web.icv2.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EngagementLinkDataICv2 {

     private String icLink;
     private String productName;
     private String[] sizeWithAutomationLocators;   //Array of sequence of actions to perform
     private String[] colorWithAutomationLocators;
     private String actTitle;

}
