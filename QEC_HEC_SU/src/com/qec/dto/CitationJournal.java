package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

import com.qec.model.CitationJournalModel;

/**
 * CitationJournal generated by hbm2java
 */
public class CitationJournal  implements java.io.Serializable {


     private CitationJournalModel citationJournalModel;
     private Long x;
     private Long y
     
     
    public CitationJournal() {
    }

    public CitationJournal(Employee employee, User user, String title, String url, String authors, Date publicationDate, String journal, Long volume, Long issue, String pages, String publisher, String description, String impactFactor, String hecRecognize, Double impactFactorValue, Date dateof) {
       this.employee = employee;
       this.user = user;
       this.title = title;
       this.url = url;
       this.authors = authors;
       this.publicationDate = publicationDate;
       this.journal = journal;
       this.volume = volume;
       this.issue = issue;
       this.pages = pages;
       this.publisher = publisher;
       this.description = description;
       this.impactFactor = impactFactor;
       this.hecRecognize = hecRecognize;
       this.impactFactorValue = impactFactorValue;
       this.dateof = dateof;
    }
   
    public Long getCitationJournalId() {
        return this.citationJournalId;
    }
    
    public void setCitationJournalId(Long citationJournalId) {
        this.citationJournalId = citationJournalId;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public String getAuthors() {
        return this.authors;
    }
    
    public void setAuthors(String authors) {
        this.authors = authors;
    }
    public Date getPublicationDate() {
        return this.publicationDate;
    }
    
    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }
    public String getJournal() {
        return this.journal;
    }
    
    public void setJournal(String journal) {
        this.journal = journal;
    }
    public Long getVolume() {
        return this.volume;
    }
    
    public void setVolume(Long volume) {
        this.volume = volume;
    }
    public Long getIssue() {
        return this.issue;
    }
    
    public void setIssue(Long issue) {
        this.issue = issue;
    }
    public String getPages() {
        return this.pages;
    }
    
    public void setPages(String pages) {
        this.pages = pages;
    }
    public String getPublisher() {
        return this.publisher;
    }
    
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImpactFactor() {
        return this.impactFactor;
    }
    
    public void setImpactFactor(String impactFactor) {
        this.impactFactor = impactFactor;
    }
    public String getHecRecognize() {
        return this.hecRecognize;
    }
    
    public void setHecRecognize(String hecRecognize) {
        this.hecRecognize = hecRecognize;
    }
    public Double getImpactFactorValue() {
        return this.impactFactorValue;
    }
    
    public void setImpactFactorValue(Double impactFactorValue) {
        this.impactFactorValue = impactFactorValue;
    }
    public Date getDateof() {
        return this.dateof;
    }
    
    public void setDateof(Date dateof) {
        this.dateof = dateof;
    }




}


