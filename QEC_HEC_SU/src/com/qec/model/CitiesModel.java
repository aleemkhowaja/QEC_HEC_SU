package com.qec.model;
// Generated Aug 19, 2017 7:08:20 PM by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cities generated by hbm2java
 */
@Entity
@Table(name="cities"
    ,catalog="qecdb"
)
public class CitiesModel  implements java.io.Serializable {


     private Long citiesId;
     private String cityName;
     private String province;
     private String abbrivation;
     private Set<EmpTrainingsModel> empTrainingses = new HashSet<EmpTrainingsModel>(0);
     private Set<EmpTravelgrandsModel> empTravelgrandses = new HashSet<EmpTravelgrandsModel>(0);
     private Set<StudentScholarshipsModel> studentScholarshipses = new HashSet<StudentScholarshipsModel>(0);
     private Set<EmployeesEducationModel> employeesEducationModels = new HashSet<EmployeesEducationModel>(0);

    public CitiesModel() {
    }

    public CitiesModel(String cityName, String province, String abbrivation, Set<EmpTrainingsModel> empTrainingses, Set<EmpTravelgrandsModel> empTravelgrandses, Set<StudentScholarshipsModel> studentScholarshipses, Set<EmployeesEducationModel> employeesEducationModels) {
       this.cityName = cityName;
       this.province = province;
       this.abbrivation = abbrivation;
       this.empTrainingses = empTrainingses;
       this.empTravelgrandses = empTravelgrandses;
       this.studentScholarshipses = studentScholarshipses;
       this.employeesEducationModels = employeesEducationModels;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="cities_id", unique=true, nullable=false)
    public Long getCitiesId() {
        return this.citiesId;
    }
    
    public void setCitiesId(Long citiesId) {
        this.citiesId = citiesId;
    }
    
    @Column(name="city_name", length=250)
    public String getCityName() {
        return this.cityName;
    }
    
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    
    @Column(name="province", length=11)
    public String getProvince() {
        return this.province;
    }
    
    public void setProvince(String province) {
        this.province = province;
    }
    
    @Column(name="abbrivation", length=250)
    public String getAbbrivation() {
        return this.abbrivation;
    }
    
    public void setAbbrivation(String abbrivation) {
        this.abbrivation = abbrivation;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cities")
    public Set<EmpTrainingsModel> getEmpTrainingses() {
        return this.empTrainingses;
    }
    
    public void setEmpTrainingses(Set<EmpTrainingsModel> empTrainingses) {
        this.empTrainingses = empTrainingses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cities")
    public Set<EmpTravelgrandsModel> getEmpTravelgrandses() {
        return this.empTravelgrandses;
    }
    
    public void setEmpTravelgrandses(Set<EmpTravelgrandsModel> empTravelgrandses) {
        this.empTravelgrandses = empTravelgrandses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cities")
    public Set<StudentScholarshipsModel> getStudentScholarshipses() {
        return this.studentScholarshipses;
    }
    
    public void setStudentScholarshipses(Set<StudentScholarshipsModel> studentScholarshipses) {
        this.studentScholarshipses = studentScholarshipses;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="cities")
    public Set<EmployeesEducationModel> getEmployeesEducations() {
        return this.employeesEducationModels;
    }
    
    public void setEmployeesEducations(Set<EmployeesEducationModel> employeesEducationModels) {
        this.employeesEducationModels = employeesEducationModels;
    }




}


