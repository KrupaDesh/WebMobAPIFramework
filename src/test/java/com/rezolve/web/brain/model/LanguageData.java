package com.rezolve.web.brain.model;
import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class LanguageData {

        private String chineseLanguage;
        private String koreanLanguage;
        private String arabicLanguage;
        private String deutschLanguage;
        private String frenchLanguage;
        private String spanishLanguage;
        private String englishLanguage;

}
