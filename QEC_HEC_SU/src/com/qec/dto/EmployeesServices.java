package pojos;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * EmployeesServices generated by hbm2java
 */
public class EmployeesServices  implements java.io.Serializable {


     private Long employeesServicesId;
     private UniPrograms uniPrograms;
     private Employee employee;
     private Faculty faculty;
     private Departments departments;
     private String department;
     private String empType;
     private String postHeld;
     private String jobStatus;
     private String natureOfJob;
     private Date postStartDate;
     private Date postEndDate;
     private String jobDuties;
     private String tcategory;
     private String grade;
     private Short scale;
     private Byte currentWorking;

    public EmployeesServices() {
    }

	
    public EmployeesServices(Faculty faculty, String empType) {
        this.faculty = faculty;
        this.empType = empType;
    }
    public EmployeesServices(UniPrograms uniPrograms, Employee employee, Faculty faculty, Departments departments, String department, String empType, String postHeld, String jobStatus, String natureOfJob, Date postStartDate, Date postEndDate, String jobDuties, String tcategory, String grade, Short scale, Byte currentWorking) {
       this.uniPrograms = uniPrograms;
       this.employee = employee;
       this.faculty = faculty;
       this.departments = departments;
       this.department = department;
       this.empType = empType;
       this.postHeld = postHeld;
       this.jobStatus = jobStatus;
       this.natureOfJob = natureOfJob;
       this.postStartDate = postStartDate;
       this.postEndDate = postEndDate;
       this.jobDuties = jobDuties;
       this.tcategory = tcategory;
       this.grade = grade;
       this.scale = scale;
       this.currentWorking = currentWorking;
    }
   
    public Long getEmployeesServicesId() {
        return this.employeesServicesId;
    }
    
    public void setEmployeesServicesId(Long employeesServicesId) {
        this.employeesServicesId = employeesServicesId;
    }
    public UniPrograms getUniPrograms() {
        return this.uniPrograms;
    }
    
    public void setUniPrograms(UniPrograms uniPrograms) {
        this.uniPrograms = uniPrograms;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Faculty getFaculty() {
        return this.faculty;
    }
    
    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }
    public Departments getDepartments() {
        return this.departments;
    }
    
    public void setDepartments(Departments departments) {
        this.departments = departments;
    }
    public String getDepartment() {
        return this.department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }
    public String getEmpType() {
        return this.empType;
    }
    
    public void setEmpType(String empType) {
        this.empType = empType;
    }
    public String getPostHeld() {
        return this.postHeld;
    }
    
    public void setPostHeld(String postHeld) {
        this.postHeld = postHeld;
    }
    public String getJobStatus() {
        return this.jobStatus;
    }
    
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
    public String getNatureOfJob() {
        return this.natureOfJob;
    }
    
    public void setNatureOfJob(String natureOfJob) {
        this.natureOfJob = natureOfJob;
    }
    public Date getPostStartDate() {
        return this.postStartDate;
    }
    
    public void setPostStartDate(Date postStartDate) {
        this.postStartDate = postStartDate;
    }
    public Date getPostEndDate() {
        return this.postEndDate;
    }
    
    public void setPostEndDate(Date postEndDate) {
        this.postEndDate = postEndDate;
    }
    public String getJobDuties() {
        return this.jobDuties;
    }
    
    public void setJobDuties(String jobDuties) {
        this.jobDuties = jobDuties;
    }
    public String getTcategory() {
        return this.tcategory;
    }
    
    public void setTcategory(String tcategory) {
        this.tcategory = tcategory;
    }
    public String getGrade() {
        return this.grade;
    }
    
    public void setGrade(String grade) {
        this.grade = grade;
    }
    public Short getScale() {
        return this.scale;
    }
    
    public void setScale(Short scale) {
        this.scale = scale;
    }
    public Byte getCurrentWorking() {
        return this.currentWorking;
    }
    
    public void setCurrentWorking(Byte currentWorking) {
        this.currentWorking = currentWorking;
    }




}


