package com.devops.studylink.stats.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecordDto {
    
    /** First Job **/
    private int firstJobDelay;
    private float firstGrossSalary;
    private boolean sameCompany;

    /** Current Job **/
    private int currentJobDelay;
    private float currentGrossSalary;
    private String currentCompanyDomain; // Secteur d'activité 
    private String currentCompanySize;

    /** Employee **/
    // private List<String> skills;

}
