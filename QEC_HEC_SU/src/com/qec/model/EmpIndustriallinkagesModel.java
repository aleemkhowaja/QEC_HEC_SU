package com.qec.model;
// Generated Aug 19, 2017 7:08:20 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * EmpIndustriallinkages generated by hbm2java
 */
@Entity
@Table(name="emp_industriallinkages")
public class EmpIndustriallinkagesModel  implements java.io.Serializable {


     private Long empIndustriallinkagesId;
     private EmployeeModel employeeModel;
     private String nameOfOrg;
     private Date dateof;
     private String purposeOfLinkage;
     private Date startDuration;
     private Long endDuration;
     private String file;

    public EmpIndustriallinkagesModel() {
    }

    public EmpIndustriallinkagesModel(EmployeeModel employeeModel, String nameOfOrg, Date dateof, String purposeOfLinkage, Date startDuration, Long endDuration, String file) {
       this.employeeModel = employeeModel;
       this.nameOfOrg = nameOfOrg;
       this.dateof = dateof;
       this.purposeOfLinkage = purposeOfLinkage;
       this.startDuration = startDuration;
       this.endDuration = endDuration;
       this.file = file;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="emp_industriallinkages_id", unique=true, nullable=false)
    public Long getEmpIndustriallinkagesId() {
        return this.empIndustriallinkagesId;
    }
    
    public void setEmpIndustriallinkagesId(Long empIndustriallinkagesId) {
        this.empIndustriallinkagesId = empIndustriallinkagesId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id")
    public EmployeeModel getEmployee() {
        return this.employeeModel;
    }
    
    public void setEmployee(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }
    
    @Column(name="name_of_org", length=250)
    public String getNameOfOrg() {
        return this.nameOfOrg;
    }
    
    public void setNameOfOrg(String nameOfOrg) {
        this.nameOfOrg = nameOfOrg;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="dateof", length=10)
    public Date getDateof() {
        return this.dateof;
    }
    
    public void setDateof(Date dateof) {
        this.dateof = dateof;
    }
    
    @Column(name="purpose_of_linkage", length=250)
    public String getPurposeOfLinkage() {
        return this.purposeOfLinkage;
    }
    
    public void setPurposeOfLinkage(String purposeOfLinkage) {
        this.purposeOfLinkage = purposeOfLinkage;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="start_duration", length=10)
    public Date getStartDuration() {
        return this.startDuration;
    }
    
    public void setStartDuration(Date startDuration) {
        this.startDuration = startDuration;
    }
    
    @Column(name="end_duration", precision=10, scale=0)
    public Long getEndDuration() {
        return this.endDuration;
    }
    
    public void setEndDuration(Long endDuration) {
        this.endDuration = endDuration;
    }
    
    @Column(name="file", length=250)
    public String getFile() {
        return this.file;
    }
    
    public void setFile(String file) {
        this.file = file;
    }




}


