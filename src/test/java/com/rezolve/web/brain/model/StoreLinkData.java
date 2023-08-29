package com.rezolve.web.brain.model;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class StoreLinkData {

        private String allDemoStoreLink;
        private String storeLink;
        private String rezolveHomePageLink;
        private String demoElectronicsStoreLink;
        private String demoHomeWareStoreLink;
        private String demoRealEstateStoreLink;
        private String demoDepartmentStoreLink;

}
