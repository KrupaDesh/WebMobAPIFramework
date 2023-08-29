package com.rezolve.web.ic.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EngagementLinkData {

     private String icLink;
     private String productName;
     private String[] sizeWithAutomationLocators;   //Array of sequence of actions to perform
     private String[] colorWithAutomationLocators;
     private String actTitle;

}
