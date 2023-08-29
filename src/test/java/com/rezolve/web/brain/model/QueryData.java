package com.rezolve.web.brain.model;
import lombok.*;
@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class QueryData {

        private String chineseSampleQuery;
        private String koreanSampleQuery;
        private String arabicSampleQuery;
        private String deutschSampleQuery;
        private String frenchSampleQuery;
        private String spanishSampleQuery;
        private String englishSampleQuery;
        private String engSampleQuery;
        private String engMessageContent;
        private String chinaSampleQuery;
        private String chinaMessageContent;
        private String korSampleQuery;
        private String korMessageContent;
        private String arabSampleQuery;
        private String arabMessageContent;
        private String deuSampleQuery;
        private String deuMessageContent;
        private String frSampleQuery;
        private String frMessageContent;
        private String spanSampleQuery;
        private String spanMessageContent;
        private String chineseFollowUpQuery;
        private String koreanFollowUpQuery;
        private String arabicFollowUpQuery;
        private String deutschFollowUpQuery;
        private String frenchFollowUpQuery;
        private String spanishFollowUpQuery;
        private String englishFollowUpQuery;

}
