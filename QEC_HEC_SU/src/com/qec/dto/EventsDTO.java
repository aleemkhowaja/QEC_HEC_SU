package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA
import java.util.Date;
import com.qec.model.DepartmentsModel;
import com.qec.model.UserModel;

/**
 * Events generated by hbm2java
 */
public class EventsDTO  implements java.io.Serializable {


     private Long eventsId;
     private UserDTO userModel;
     private DepartmentsDTO departmentsModel;
     private Long departmentId;
     private String departmentName;
     private String eventTitle;
     private Date dateof;
     private Date endDate;
     private Double quota;
     private String eventDetail;
     private String color;
     private Boolean isDeleted;

    public Long getEventsId() {
        return this.eventsId;
    }
    
    public void setEventsId(Long eventsId) {
        this.eventsId = eventsId;
    }

	public UserDTO getUserModel() {
		return userModel;
	}

	public void setUserModel(UserDTO userModel) {
		this.userModel = userModel;
	}

	public DepartmentsDTO getDepartmentsModel() {
		return departmentsModel;
	}

	public void setDepartmentsModel(DepartmentsDTO departmentsModel) {
		this.departmentsModel = departmentsModel;
	}

	public String getEventTitle() {
		return eventTitle;
	}

	public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }
    public Date getDateof() {
        return this.dateof;
    }
    
    public void setDateof(Date dateof) {
        this.dateof = dateof;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    public Double getQuota() {
        return this.quota;
    }
    
    public void setQuota(Double quota) {
        this.quota = quota;
    }
    public String getEventDetail() {
        return this.eventDetail;
    }
    
    public void setEventDetail(String eventDetail) {
        this.eventDetail = eventDetail;
    }
    public String getColor() {
        return this.color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	
}


