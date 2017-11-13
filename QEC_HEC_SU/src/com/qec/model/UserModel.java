package com.qec.model;
// Generated Aug 19, 2017 7:08:20 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * User generated by hbm2java
 */
@Entity
@Table(name="user"
    ,catalog="qecdb"
)
public class UserModel extends Model  implements java.io.Serializable {


     private Long userId;
     					   
     private EmployeeModel employeeModel;
     private String username;
     private String password;
     private String role;
     private String fullName;
     private DepartmentsModel departmentsModel;
     private CampusesModel campusesModel;
     private String email;
    /* private Date dateof;*/
     private Boolean isDeleted;
     private Boolean isActive;

     public UserModel() {
     }

     public UserModel(CampusesModel campusesModel, DepartmentsModel departmentsModel, Long userId, EmployeeModel employeeModel,String username ,String password,String role,String fullName,String email,Long campusId,Boolean isDeleted,Boolean isActive) {
        this.departmentsModel = departmentsModel;
        this.userId = userId;
        this.username = username;
        this.campusesModel =campusesModel;
        this.password = password;
        this.role = role;
        this.fullName = fullName;
        this.email = email ;
        //this.dateof = dateof;
        this.isDeleted =isDeleted;
        this.isActive = isActive;
        this.employeeModel = employeeModel;
     }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="user_id", unique=true, nullable=false)
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id")
    public EmployeeModel getEmployeeModel() {
		return employeeModel;
	}

	public void setEmployeeModel(EmployeeModel employeeModel) {
		this.employeeModel = employeeModel;
	}
    
    @Column(name="username", length=250)
    public String getUsername() {
        return this.username;
    }

	public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="password", length=65535)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name="role", length=11)
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    @Column(name="full_name", length=250)
    public String getFullName() {
        return this.fullName;
    }
    
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="department_id") 
    public DepartmentsModel getDepartmentsModel() {
		return departmentsModel;
	}

	public void setDepartmentsModel(DepartmentsModel departmentsModel) {
		this.departmentsModel = departmentsModel;
	}
    @Column(name="email", length=250)
    public String getEmail() {
        return this.email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
   
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="campus_id")
    public CampusesModel getCampusesModel() {
		return campusesModel;
	}

	public void setCampusesModel(CampusesModel campusesModel) {
		this.campusesModel = campusesModel;
	}
	
   /* @Temporal(TemporalType.DATE)
    @Column(name="dateof", length=10)
    public Date getDateof() {
        return this.dateof;
    }
    
    public void setDateof(Date dateof) {
        this.dateof = dateof;
    }*/
    @Column(name="is_deleted")
    public Boolean getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    @Column(name="is_active")
    public Boolean getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

}


