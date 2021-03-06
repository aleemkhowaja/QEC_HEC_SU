package com.qec.model;
// Generated Aug 19, 2017 7:08:20 PM by Hibernate Tools 3.2.1.GA

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Faculty generated by hbm2java
 */
@Entity
@Table(name="faculty")
public class FacultyModel extends Model  implements java.io.Serializable  {

     private Long facultyId;
     private String facultyName;

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="faculty_id", unique=true, nullable=false)
    public Long getFacultyId() {
        return this.facultyId;
    }
    
    public void setFacultyId(Long facultyId) {
        this.facultyId = facultyId;
    }
    
    @Column(name="faculty_name", nullable=false, length=200)
    public String getFacultyName() {
        return this.facultyName;
    }
    
    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }
}


