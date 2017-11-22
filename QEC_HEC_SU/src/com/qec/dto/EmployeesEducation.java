package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * EmployeesEducation generated by hbm2java
 */
public class EmployeesEducation  implements java.io.Serializable {


     private Long employeesEducationId;
     private EmployeeDTO employee;
     private Cities cities;
     private String degreeLevel;
     private String examinationPassed;
     private Date resultDate;
     private String university;
     private String otherUniversity;
     private String grade;
     private String subject1;
     private String subject2;
     private String subject3;

    public EmployeesEducation() {
    }

    public EmployeesEducation(EmployeeDTO employee, Cities cities, String degreeLevel, String examinationPassed, Date resultDate, String university, String otherUniversity, String grade, String subject1, String subject2, String subject3) {
       this.employee = employee;
       this.cities = cities;
       this.degreeLevel = degreeLevel;
       this.examinationPassed = examinationPassed;
       this.resultDate = resultDate;
       this.university = university;
       this.otherUniversity = otherUniversity;
       this.grade = grade;
       this.subject1 = subject1;
       this.subject2 = subject2;
       this.subject3 = subject3;
    }
   
    public Long getEmployeesEducationId() {
        return this.employeesEducationId;
    }
    
    public void setEmployeesEducationId(Long employeesEducationId) {
        this.employeesEducationId = employeesEducationId;
    }
    public EmployeeDTO getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
    public Cities getCities() {
        return this.cities;
    }
    
    public void setCities(Cities cities) {
        this.cities = cities;
    }
    public String getDegreeLevel() {
        return this.degreeLevel;
    }
    
    public void setDegreeLevel(String degreeLevel) {
        this.degreeLevel = degreeLevel;
    }
    public String getExaminationPassed() {
        return this.examinationPassed;
    }
    
    public void setExaminationPassed(String examinationPassed) {
        this.examinationPassed = examinationPassed;
    }
    public Date getResultDate() {
        return this.resultDate;
    }
    
    public void setResultDate(Date resultDate) {
        this.resultDate = resultDate;
    }
    public String getUniversity() {
        return this.university;
    }
    
    public void setUniversity(String university) {
        this.university = university;
    }
    public String getOtherUniversity() {
        return this.otherUniversity;
    }
    
    public void setOtherUniversity(String otherUniversity) {
        this.otherUniversity = otherUniversity;
    }
    public String getGrade() {
        return this.grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public String getSubject1() {
        return this.subject1;
    }
    
    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }
    public String getSubject2() {
        return this.subject2;
    }
    
    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }
    public String getSubject3() {
        return this.subject3;
    }
    
    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }




}


