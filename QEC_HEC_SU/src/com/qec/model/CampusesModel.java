package com.qec.model;
// Generated Aug 19, 2017 7:08:20 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Campuses generated by hbm2java
 */
@Entity
@Table(name="campuses")
public class CampusesModel extends Model  implements java.io.Serializable {


     private Long campusesId;
     private String campusName;

   
    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="campuses_id", unique=true, nullable=false)
    public Long getCampusesId() {
        return this.campusesId;
    }
    
    public void setCampusesId(Long campusesId) {
        this.campusesId = campusesId;
    }
    
    @Column(name="campus_name", length=250)
    public String getCampusName() {
        return this.campusName;
    }
    
    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

}


