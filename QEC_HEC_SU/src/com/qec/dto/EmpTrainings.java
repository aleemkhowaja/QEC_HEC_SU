package pojos;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * EmpTrainings generated by hbm2java
 */
public class EmpTrainings  implements java.io.Serializable {


     private Long empTrainingsId;
     private Employee employee;
     private Countries countries;
     private Cities cities;
     private String name;
     private String place;
     private String file;
     private String locality;
     private String instituteName;
     private String trainingCondition;
     private Date dateof;
     private String fundingDetail;

    public EmpTrainings() {
    }

    public EmpTrainings(Employee employee, Countries countries, Cities cities, String name, String place, String file, String locality, String instituteName, String trainingCondition, Date dateof, String fundingDetail) {
       this.employee = employee;
       this.countries = countries;
       this.cities = cities;
       this.name = name;
       this.place = place;
       this.file = file;
       this.locality = locality;
       this.instituteName = instituteName;
       this.trainingCondition = trainingCondition;
       this.dateof = dateof;
       this.fundingDetail = fundingDetail;
    }
   
    public Long getEmpTrainingsId() {
        return this.empTrainingsId;
    }
    
    public void setEmpTrainingsId(Long empTrainingsId) {
        this.empTrainingsId = empTrainingsId;
    }
    public Employee getEmployee() {
        return this.employee;
    }
    
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    public Countries getCountries() {
        return this.countries;
    }
    
    public void setCountries(Countries countries) {
        this.countries = countries;
    }
    public Cities getCities() {
        return this.cities;
    }
    
    public void setCities(Cities cities) {
        this.cities = cities;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPlace() {
        return this.place;
    }
    
    public void setPlace(String place) {
        this.place = place;
    }
    public String getFile() {
        return this.file;
    }
    
    public void setFile(String file) {
        this.file = file;
    }
    public String getLocality() {
        return this.locality;
    }
    
    public void setLocality(String locality) {
        this.locality = locality;
    }
    public String getInstituteName() {
        return this.instituteName;
    }
    
    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }
    public String getTrainingCondition() {
        return this.trainingCondition;
    }
    
    public void setTrainingCondition(String trainingCondition) {
        this.trainingCondition = trainingCondition;
    }
    public Date getDateof() {
        return this.dateof;
    }
    
    public void setDateof(Date dateof) {
        this.dateof = dateof;
    }
    public String getFundingDetail() {
        return this.fundingDetail;
    }
    
    public void setFundingDetail(String fundingDetail) {
        this.fundingDetail = fundingDetail;
    }




}


