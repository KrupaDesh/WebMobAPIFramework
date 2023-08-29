package com.rezolve.web.brain.model;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LabelsData {

        private String chineseText;
        private String koreanText;
        private String arabicText;
        private String deutschText;
        private String frenchText;
        private String spanishText;
        private String englishText;

}
