package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA

/**
 * EmpPhdstrategy generated by hbm2java
 */
public class EmployeeMphilPhdStudentsDTO  implements java.io.Serializable {


	 private Long employeeMphilPhdStudentsId;
     private EmployeeDTO employee;
     private DepartmentsDTO departments;
     private String studentName;
     private String dtype;
     private Double noOfStudents;
     private String startDate;
     private String registrationDate;
     private Double studentId;
     private String file;
     private String approvedTopic;
     private Long employeeId;
     private Long departmentId;
     
     public Long getEmployeeMphilPhdStudentsId() {
    	 return employeeMphilPhdStudentsId;
     }
     public void setEmployeeMphilPhdStudentsId(Long employeeMphilPhdStudentsId) {
    	 this.employeeMphilPhdStudentsId = employeeMphilPhdStudentsId;
     }
     public EmployeeDTO getEmployee() {
    	 return employee;
     }
     public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
     }
     public DepartmentsDTO getDepartments() {
		return departments;
     }
     public void setDepartments(DepartmentsDTO departments) {
		this.departments = departments;
     }
     public String getStudentName() {
		return studentName;
     }
     public void setStudentName(String studentName) {
		this.studentName = studentName;
     }
     public String getDtype() {
		return dtype;
     }
     public void setDtype(String dtype) {
		this.dtype = dtype;
     }
     public Double getNoOfStudents() {
		return noOfStudents;
     }
     public void setNoOfStudents(Double noOfStudents) {
		this.noOfStudents = noOfStudents;
     }
     public String getStartDate() {
		return startDate;
     }
     public void setStartDate(String startDate) {
		this.startDate = startDate;
     }
     public String getRegistrationDate() {
		return registrationDate;
     }
     public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
     }
     public Double getStudentId() {
		return studentId;
     }
     public void setStudentId(Double studentId) {
		this.studentId = studentId;
     }
     public String getFile() {
    	return file;
     }
     public void setFile(String file) {
		this.file = file;
     }
     public String getApprovedTopic() {
		return approvedTopic;
     }
     public void setApprovedTopic(String approvedTopic) {
		this.approvedTopic = approvedTopic;
     }
     public Long getEmployeeId() {
 		return employeeId;
     }
     public void setEmployeeId(Long employeeId) {
 		this.employeeId = employeeId;
     }
     public Long getDepartmentId() {
 		return departmentId;
     }
     public void setDepartmentId(Long departmentId) {
 		this.departmentId = departmentId;
     }
}

