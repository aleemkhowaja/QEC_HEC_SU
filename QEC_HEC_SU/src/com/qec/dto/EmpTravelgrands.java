package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * EmpTravelgrands generated by hbm2java
 */
public class EmpTravelgrands  implements java.io.Serializable {


     private Long empTravelgrandsId;
     private EmployeeDTO employee;
     private Countries countries;
     private Cities cities;
     private String nature;
     private Double amount;
     private Date durationStart;
     private Date durationEnd;
     private String locType;
     private String file;
     private String nameOfProject;
     private String grandType;
     private String fundingAgency;
     private Date approvalDate;

    public EmpTravelgrands() {
    }

    public EmpTravelgrands(EmployeeDTO employee, Countries countries, Cities cities, String nature, Double amount, Date durationStart, Date durationEnd, String locType, String file, String nameOfProject, String grandType, String fundingAgency, Date approvalDate) {
       this.employee = employee;
       this.countries = countries;
       this.cities = cities;
       this.nature = nature;
       this.amount = amount;
       this.durationStart = durationStart;
       this.durationEnd = durationEnd;
       this.locType = locType;
       this.file = file;
       this.nameOfProject = nameOfProject;
       this.grandType = grandType;
       this.fundingAgency = fundingAgency;
       this.approvalDate = approvalDate;
    }
   
    public Long getEmpTravelgrandsId() {
        return this.empTravelgrandsId;
    }
    
    public void setEmpTravelgrandsId(Long empTravelgrandsId) {
        this.empTravelgrandsId = empTravelgrandsId;
    }
    public EmployeeDTO getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
    public Countries getCountries() {
        return this.countries;
    }
    
    public void setCountries(Countries countries) {
        this.countries = countries;
    }
    public Cities getCities() {
        return this.cities;
    }
    
    public void setCities(Cities cities) {
        this.cities = cities;
    }
    public String getNature() {
        return this.nature;
    }
    
    public void setNature(String nature) {
        this.nature = nature;
    }
    public Double getAmount() {
        return this.amount;
    }
    
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public Date getDurationStart() {
        return this.durationStart;
    }
    
    public void setDurationStart(Date durationStart) {
        this.durationStart = durationStart;
    }
    public Date getDurationEnd() {
        return this.durationEnd;
    }
    
    public void setDurationEnd(Date durationEnd) {
        this.durationEnd = durationEnd;
    }
    public String getLocType() {
        return this.locType;
    }
    
    public void setLocType(String locType) {
        this.locType = locType;
    }
    public String getFile() {
        return this.file;
    }
    
    public void setFile(String file) {
        this.file = file;
    }
    public String getNameOfProject() {
        return this.nameOfProject;
    }
    
    public void setNameOfProject(String nameOfProject) {
        this.nameOfProject = nameOfProject;
    }
    public String getGrandType() {
        return this.grandType;
    }
    
    public void setGrandType(String grandType) {
        this.grandType = grandType;
    }
    public String getFundingAgency() {
        return this.fundingAgency;
    }
    
    public void setFundingAgency(String fundingAgency) {
        this.fundingAgency = fundingAgency;
    }
    public Date getApprovalDate() {
        return this.approvalDate;
    }
    
    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }




}


