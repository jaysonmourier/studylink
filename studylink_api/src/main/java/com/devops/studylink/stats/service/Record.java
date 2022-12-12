package com.devops.studylink.stats.service;

import java.util.List;

import com.devops.studylink.stats.dto.RecordDto;
import com.devops.studylink.stats.repository.entities.RecordEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Record {

    /** First Job **/
    private int firstJobDelay;
    private float firstGrossSalary;
    private boolean sameCompany;

    /** Current Job **/
    private int currentJobDelay;
    private float currentGrossSalary;
    private String currentCompanyDomain;
    private String currentCompanySize;

    /** Employee **/
    // private List<String> skills;

    /** Mapping **/
    public static Record create( RecordDto r ) {
        return new Record( 
            r.getFirstJobDelay(),
            r.getFirstGrossSalary(),
            r.isSameCompany(),
            r.isSameCompany() ? r.getFirstJobDelay() : r.getCurrentJobDelay(),
            r.isSameCompany() ? r.getFirstGrossSalary() : r.getCurrentGrossSalary(),
            r.getCurrentCompanyDomain(),
            r.getCurrentCompanySize()
        );
    }
    public static Record create( RecordEntity r ) {
        return new Record( 
            r.getFirstJobDelay(),
            r.getFirstGrossSalary(),
            r.isSameCompany(),
            r.getCurrentJobDelay(),
            r.getCurrentGrossSalary(),
            r.getCurrentCompanyDomain(),
            r.getCurrentCompanySize()
        );
    }

}
