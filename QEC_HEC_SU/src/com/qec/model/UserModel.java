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
public class UserModel  implements java.io.Serializable {


     private Long userId;
     private EmployeeModel employeeModel;
     private String username;
     private String password;
     private String role;
     private String fullName;
     private Long departmentId;
     private String email;
     private Date dateof;
     private Long campusId;
     private Byte isDeleted;
     private Byte isActive;


    public UserModel() {
    }

    public UserModel(EmployeeModel employeeModel, String username, String password, String role, String fullName, Long departmentId, String email, Date dateof, Long campusId, Byte isDeleted, Byte isActive, Set<GoogleCitationModel> googleCitationModels, Set<CitationConferenceModel> citationConferenceModels, Set<AccreditationsModel> accreditationses, Set<CitationBookModel> citationBookModels, Set<LoginsHistoryModel> loginsHistoryModels, Set<CitationOtherModel> citationOtherModels, Set<CitationThesisModel> citationThesises, Set<PromotionsModel> promotionses, Set<CitationJournalModel> citationJournalModels, Set<BugsModel> bugses, Set<CitationChapterModel> citationChapterModels, Set<CitationPatentModel> citationPatentModels, Set<EventsModel> eventses) {
       this.employeeModel = employeeModel;
       this.username = username;
       this.password = password;
       this.role = role;
       this.fullName = fullName;
       this.departmentId = departmentId;
       this.email = email;
       this.dateof = dateof;
       this.campusId = campusId;
       this.isDeleted = isDeleted;
       this.isActive = isActive;
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
    public EmployeeModel getEmployee() {
        return this.employeeModel;
    }
    
    public void setEmployee(EmployeeModel employeeModel) {
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
    
    @Column(name="department_id")
    public Long getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
    
    @Column(name="email", length=250)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="dateof", length=10)
    public Date getDateof() {
        return this.dateof;
    }
    
    public void setDateof(Date dateof) {
        this.dateof = dateof;
    }
    
    @Column(name="campus_id")
    public Long getCampusId() {
        return this.campusId;
    }
    
    public void setCampusId(Long campusId) {
        this.campusId = campusId;
    }
    
    @Column(name="is_deleted")
    public Byte getIsDeleted() {
        return this.isDeleted;
    }
    
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
    
    @Column(name="is_active")
    public Byte getIsActive() {
        return this.isActive;
    }
    
    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

}


