package com.qec.model;
// Generated Aug 19, 2017 7:08:20 PM by Hibernate Tools 3.2.1.GA


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * AwardsList generated by hbm2java
 */
@Entity
@Table(name="awards_list")
public class AwardsListModel  implements java.io.Serializable {


     private Long awardsListId;
     private String awardName;
     private String locality;

    public AwardsListModel() {
    }

    public AwardsListModel(String awardName, String locality) {
       this.awardName = awardName;
       this.locality = locality;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="awards_list_id", unique=true, nullable=false)
    public Long getAwardsListId() {
        return this.awardsListId;
    }
    
    public void setAwardsListId(Long awardsListId) {
        this.awardsListId = awardsListId;
    }
    
    @Column(name="award_name", length=250)
    public String getAwardName() {
        return this.awardName;
    }
    
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
    
    @Column(name="locality", length=13)
    public String getLocality() {
        return this.locality;
    }
    
    public void setLocality(String locality) {
        this.locality = locality;
    }




}


