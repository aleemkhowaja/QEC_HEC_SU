package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

import com.qec.model.CitationJournalModel;
import com.qec.model.EmployeeModel;
import com.qec.model.UserModel;

/**
 * CitationJournal generated by hbm2java
 */
public class CitationJournalDTO  implements java.io.Serializable {
	
	private Long citationJournalId;
	private Long employeeId;
    private EmployeeDTO employeeDTO;
    private UserModel userModel;
    private String title;
    private String url;
    private String authors;
    private Date publicationDate;
    private String journal;
    private Long volume;
    private Long issue;
    private String pages;
    private String publisher;
    private String description;
    private String impactFactor;
    private String hecRecognize;
    private Double impactFactorValue;
    private Date dateof;
    private Boolean isDeleted;
     
     
	public Long getCitationJournalId() {
		return citationJournalId;
	}
	public void setCitationJournalId(Long citationJournalId) {
		this.citationJournalId = citationJournalId;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}
	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}
	public UserModel getUserModel() {
		return userModel;
	}
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public Date getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public Long getIssue() {
		return issue;
	}
	public void setIssue(Long issue) {
		this.issue = issue;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImpactFactor() {
		return impactFactor;
	}
	public void setImpactFactor(String impactFactor) {
		this.impactFactor = impactFactor;
	}
	public String getHecRecognize() {
		return hecRecognize;
	}
	public void setHecRecognize(String hecRecognize) {
		this.hecRecognize = hecRecognize;
	}
	public Double getImpactFactorValue() {
		return impactFactorValue;
	}
	public void setImpactFactorValue(Double impactFactorValue) {
		this.impactFactorValue = impactFactorValue;
	}
	public Date getDateof() {
		return dateof;
	}
	public void setDateof(Date dateof) {
		this.dateof = dateof;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}

