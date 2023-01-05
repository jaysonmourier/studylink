package com.devops.studylink.stats.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RecordDto {

    /** First Job **/

    @JsonProperty("firstJobDelay")
    private int firstJobDelay;

    @JsonProperty("firstGrossSalary")
    private float firstGrossSalary;

    @JsonProperty("sameCompany")
    private boolean sameCompany;

    /** Current Job **/

    @JsonProperty("currentJobDelay")
    private int currentJobDelay;

    @JsonProperty("currentGrossSalary")
    private float currentGrossSalary;

    @JsonProperty("currentCompanyDomain")
    private String currentCompanyDomain; // Secteur d'activité 

    @JsonProperty("currentCompanySize")
    private String currentCompanySize;

    /** Employee **/

    // @JsonProperty("skills")
    // private List<String> skills;

}

