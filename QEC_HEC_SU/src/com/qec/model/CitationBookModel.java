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
 * CitationBook generated by hbm2java
 */
@Entity
@Table(name="citation_book")
public class CitationBookModel extends Model implements java.io.Serializable {


     private Long citationBookId;
     private EmployeeModel employeeModel;
     private UserModel userModel;
     private String title;
     private String url;
     private String authors;
     private Date publicationDate;
     private Long volume;
     private Long issue;
     private String pages;
     private String publisher;
     private String description;

  
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="citation_book_id", unique=true, nullable=false)
    public Long getCitationBookId() {
        return this.citationBookId;
    }
    
    public void setCitationBookId(Long citationBookId) {
        this.citationBookId = citationBookId;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id")
    public EmployeeModel getEmployeeModel() {
        return this.employeeModel;
    }
    
    public void setEmployeeModel(EmployeeModel employeeModel) {
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
    
    @Column(name="volume", precision=10, scale=0)
    public Long getVolume() {
        return this.volume;
    }
    
    public void setVolume(Long volume) {
        this.volume = volume;
    }
    
    @Column(name="issue", precision=10, scale=0)
    public Long getIssue() {
        return this.issue;
    }
    
    public void setIssue(Long issue) {
        this.issue = issue;
    }
    
    @Column(name="pages", length=100)
    public String getPages() {
        return this.pages;
    }
    
    public void setPages(String pages) {
        this.pages = pages;
    }
    
    @Column(name="publisher", length=250)
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    
    @Column(name="description", length=65535)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}


