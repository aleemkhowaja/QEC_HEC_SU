package com.qec.dto;
// Generated Aug 19, 2017 9:08:15 PM by Hibernate Tools 3.2.1.GA



/**
 * AwardsList generated by hbm2java
 */
public class AwardsList  implements java.io.Serializable {


     private Long awardsListId;
     private String awardName;
     private String locality;

    public AwardsList() {
    }

    public AwardsList(String awardName, String locality) {
       this.awardName = awardName;
       this.locality = locality;
    }
   
    public Long getAwardsListId() {
        return this.awardsListId;
    }
    
    public void setAwardsListId(Long awardsListId) {
        this.awardsListId = awardsListId;
    }
    public String getAwardName() {
        return this.awardName;
    }
    
    public void setAwardName(String awardName) {
        this.awardName = awardName;
    }
    public String getLocality() {
        return this.locality;
    }
    
    public void setLocality(String locality) {
        this.locality = locality;
    }




}


