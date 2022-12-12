package com.devops.studylink.stats.service;

import java.util.List;

import com.devops.studylink.stats.dto.RecordDto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Record {
    
    /** DTO Mapping **/
    public Record( RecordDto r ) {
        this.firstJobDelay = r.getFirstJobDelay();
        this.firstGrossSalary = r.getFirstGrossSalary();
        this.sameCompany = r.isSameCompany();
        this.currentJobDelay = r.getCurrentJobDelay();
        this.currentGrossSalary = r.getCurrentGrossSalary();
        this.currentCompanyDomain = r.getCurrentCompanyDomain();
        this.currentCompanySize = r.getCurrentCompanySize();
        // this.skills = r.getSkills();
    }

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

}
