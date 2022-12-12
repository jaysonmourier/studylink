package com.devops.studylink.stats.repository.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.devops.studylink.stats.service.Record;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="record") @Table(name="record")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class RecordEntity {
    
    public RecordEntity( Record r ) {
        this.firstJobDelay = r.getFirstJobDelay();
        this.firstGrossSalary = r.getFirstGrossSalary();
        this.sameCompany = r.isSameCompany();
        this.currentJobDelay = r.getCurrentJobDelay();
        this.currentGrossSalary = r.getCurrentGrossSalary();
        this.currentCompanyDomain = r.getCurrentCompanyDomain();
        this.currentCompanySize = r.getCurrentCompanySize();
        // this.skills = r.getSkills();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /** Record Data **/

    @Column(name="firstJobDelay")
    private int firstJobDelay;

    @Column(name="firstGrossSalary")
    private float firstGrossSalary;

    @Column(name="sameCompany")
    private boolean sameCompany;

    @Column(name="currentJobDelay")
    private int currentJobDelay;

    @Column(name="currentGrossSalary")
    private float currentGrossSalary;

    @Column(name="currentCompanyDomain")
    private String currentCompanyDomain;

    @Column(name="currentCompanySize")
    private String currentCompanySize;

    // @Column(name="skills")
    // private List<String> skills;

}
