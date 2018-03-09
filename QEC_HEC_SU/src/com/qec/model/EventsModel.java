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
 * Events generated by hbm2java
 */
@Entity
@Table(name="events")
public class EventsModel  extends Model  implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private Long eventsId;
    private UserModel userModel;
    private DepartmentsModel departmentsModel;
    private String eventTitle;
    private Date dateof;
    private Date endDate;
    private Double quota;
    private String eventDetail;
    private String color;

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="events_id", unique=true, nullable=false)
    public Long getEventsId() {
    	return this.eventsId;
    }
    
    public void setEventsId(Long eventsId) {
    	this.eventsId = eventsId;
    }
	
	@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="user_id")
    public UserModel getUserModel() {
		return this.userModel;
	}
    
	public void setUserModel(UserModel userModel) {
		this.userModel = userModel;
	}
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="department_id")
	public DepartmentsModel getDepartmentsModel() {
		return this.departmentsModel;
	}
    
	public void setDepartmentsModel(DepartmentsModel departmentsModel) {
		this.departmentsModel = departmentsModel;
	}
    
	@Column(name="event_title", length=250)
	public String getEventTitle() {
		return this.eventTitle;
	}
    
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
    
	@Temporal(TemporalType.DATE)
	@Column(name="dateof", length=10)
	public Date getDateof() {
		return this.dateof;
	}
    
	public void setDateof(Date dateof) {
		this.dateof = dateof;
	}
	 
	@Temporal(TemporalType.DATE)
	@Column(name="end_date", length=10)
	public Date getEndDate() {
		return this.endDate;
	}
    
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
    
	@Column(name="quota", precision=22, scale=0)
	public Double getQuota() {
		return this.quota;
	}
    
	public void setQuota(Double quota) {
		this.quota = quota;
	}
    
	@Column(name="event_detail", length=65535)
	public String getEventDetail() {
		return this.eventDetail;
	}
    
	public void setEventDetail(String eventDetail) {
		this.eventDetail = eventDetail;
	}
    
	@Column(name="color", length=100)
	public String getColor() {
		return this.color;
	}
    
	public void setColor(String color) {
		this.color = color;
	}
}