package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA

/**
 * GoogleCitation generated by hbm2java
 */
public class GoogleCitationDTO  implements java.io.Serializable {

    private Long googleCitationId;
    private EmployeeDTO employee;
    private Integer employeeId;
    private UserDTO user;
    private String url;
    private String isDeleted;
   
    public Long getGoogleCitationId() {
        return this.googleCitationId;
    }
    
    public void setGoogleCitationId(Long googleCitationId) {
        this.googleCitationId = googleCitationId;
    }
    public EmployeeDTO getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }
    
	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public UserDTO getUser() {
        return this.user;
    }
    
    public void setUser(UserDTO user) {
        this.user = user;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }

	public String getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
}