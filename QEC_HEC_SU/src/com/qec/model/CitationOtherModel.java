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
 * CitationOther generated by hbm2java
 */
@Entity
@Table(name="citation_other")
public class CitationOtherModel  implements java.io.Serializable {


     private Long citationOtherId;
     private EmployeeModel employeeModel;
     private UserModel userModel;
     private String title;
     private String url;
     private String authors;
     private Date publicationDate;
     private String source;
     private String reportNumber;
     private String description;

    public CitationOtherModel() {
    }

    public CitationOtherModel(EmployeeModel employeeModel, UserModel userModel, String title, String url, String authors, Date publicationDate, String source, String reportNumber, String description) {
       this.employeeModel = employeeModel;
       this.userModel = userModel;
       this.title = title;
       this.url = url;
       this.authors = authors;
       this.publicationDate = publicationDate;
       this.source = source;
       this.reportNumber = reportNumber;
       this.description = description;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="citation_other_id", unique=true, nullable=false)
    public Long getCitationOtherId() {
        return this.citationOtherId;
    }
    
    public void setCitationOtherId(Long citationOtherId) {
        this.citationOtherId = citationOtherId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id")
    public EmployeeModel getEmployee() {
        return this.employeeModel;
    }
    
    public void setEmployee(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    public UserModel getUser() {
        return this.userModel;
    }
    
    public void setUser(UserModel userModel) {
        this.userModel = userModel;
    }
    
    @Column(name="title", length=65535)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="url", length=65535)
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Column(name="authors", length=65535)
    public String getAuthors() {
        return this.authors;
    }
    
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="publication_date", length=10)
    public Date getPublicationDate() {
        return this.publicationDate;
    }
    
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
    
    @Column(name="source", length=100)
    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
    }
    
    @Column(name="report_number", length=100)
    public String getReportNumber() {
        return this.reportNumber;
    }
    
    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }
    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }




}


