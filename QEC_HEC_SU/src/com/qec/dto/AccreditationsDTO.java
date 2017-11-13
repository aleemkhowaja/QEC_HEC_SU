package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * Accreditations generated by hbm2java
 */
public class AccreditationsDTO  implements java.io.Serializable {


     private Long accreditationsId;
     private UserDTO user;
     private Faculty faculty;
     private UniPrograms uniPrograms;
     private DepartmentsDTO departments;
     private String nameOfProgram;
     private String title;
     private String locality;
     private Long accreditationCouncilId;
     private String internationalAccreditationCouncil;
     private Date year;
     private String file;
     private Date approvedDate;
     private Date validityDate;

    public AccreditationsDTO() {
    }

    public AccreditationsDTO(UserDTO user, Faculty faculty, UniPrograms uniPrograms, DepartmentsDTO departments, String nameOfProgram, String title, String locality, Long accreditationCouncilId, String internationalAccreditationCouncil, Date year, String file, Date approvedDate, Date validityDate) {
       this.user = user;
       this.faculty = faculty;
       this.uniPrograms = uniPrograms;
       this.departments = departments;
       this.nameOfProgram = nameOfProgram;
       this.title = title;
       this.locality = locality;
       this.accreditationCouncilId = accreditationCouncilId;
       this.internationalAccreditationCouncil = internationalAccreditationCouncil;
       this.year = year;
       this.file = file;
       this.approvedDate = approvedDate;
       this.validityDate = validityDate;
    }
   
    public Long getAccreditationsId() {
        return this.accreditationsId;
    }
    
    public void setAccreditationsId(Long accreditationsId) {
        this.accreditationsId = accreditationsId;
    }
    public UserDTO getUser() {
        return this.user;
    }
    
    public void setUser(UserDTO user) {
        this.user = user;
    }
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    public UniPrograms getUniPrograms() {
        return this.uniPrograms;
    }
    
    public void setUniPrograms(UniPrograms uniPrograms) {
        this.uniPrograms = uniPrograms;
    }
    public DepartmentsDTO getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(DepartmentsDTO departments) {
        this.departments = departments;
    }
    public String getNameOfProgram() {
        return this.nameOfProgram;
    }
    
    public void setNameOfProgram(String nameOfProgram) {
        this.nameOfProgram = nameOfProgram;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getLocality() {
        return this.locality;
    }
    
    public void setLocality(String locality) {
        this.locality = locality;
    }
    public Long getAccreditationCouncilId() {
        return this.accreditationCouncilId;
    }
    
    public void setAccreditationCouncilId(Long accreditationCouncilId) {
        this.accreditationCouncilId = accreditationCouncilId;
    }
    public String getInternationalAccreditationCouncil() {
        return this.internationalAccreditationCouncil;
    }
    
    public void setInternationalAccreditationCouncil(String internationalAccreditationCouncil) {
        this.internationalAccreditationCouncil = internationalAccreditationCouncil;
    }
    public Date getYear() {
        return this.year;
    }
    
    public void setYear(Date year) {
        this.year = year;
    }
    public String getFile() {
        return this.file;
    }
    
    public void setFile(String file) {
        this.file = file;
    }
    public Date getApprovedDate() {
        return this.approvedDate;
    }
    
    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }
    public Date getValidityDate() {
        return this.validityDate;
    }
    
    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }




}


