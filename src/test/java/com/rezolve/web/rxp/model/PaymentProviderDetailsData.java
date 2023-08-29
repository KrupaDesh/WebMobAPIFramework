package com.rezolve.web.rxp.model;


import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class PaymentProviderDetailsData {

     private String merchantName;
     private String merchantId;
     private String terminalId;
     private String posID;
     private String uID;
     private String computopMerchantID;
     private String computopHMACKey;
     private String computopBlowfishKey;
     private String customerServicePhoneNum;
     private String threeDSecureMerchantName;
     private String threeDSecureMerchantURL;
     private String CountryISCode;
     private String threeDSecureMerchantID;
     private String threeDSecureMerchantCategory;
     private String MerchantAcquirerBinVTwo;
     private String RequestorID;
     private String RequestorName;
     private String acquiringInstitutionID;
     private String merchantIdForWorldLine;
     private String terminalIdForWorldLine;
     private String sixWorldLineMerchantId;
     private String sixWorldLineTerminalId;
     private String MerchantAcquirerBinVTwoForMasterCard;
     private String MerchantAcquirerBinVTwoForAmexCard;
     private String requestorIDForMastercard;
     private String requestorIDForAmex;
     private String RequestorNameForMastercard;
     private String RequestorNameForAmexCard;
     private String amexcardMerchantID;

}
